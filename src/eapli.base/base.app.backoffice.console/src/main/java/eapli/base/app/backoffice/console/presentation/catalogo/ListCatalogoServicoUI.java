package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.app.backoffice.console.presentation.servicos.DescricaoBreveDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.DescricaoCompletaDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.KeywordsDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.TituloDataWidget;
import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.utilizador.application.ListCatalogoServicoController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class ListCatalogoServicoUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(ListCatalogoServicoUI.class);

    private final ListCatalogoServicoController controller = new ListCatalogoServicoController();

    @Override
    protected boolean doShow() {

        boolean flag = true;

        while (flag) {
            String opcao = Console.readLine("Deseja consultar catalogos ou servicos ou ambos? (catalogo|servico|ambos)");
            Colaborador colab = this.controller.getUser();
            if ("catalogo".equalsIgnoreCase(opcao)) {
                try {
                    Set<Catalogo> listaFinal = new HashSet<>();
                    Set<Catalogo> listaCat = new HashSet<>();
                    Iterable<Catalogo> listCatalogos = getMenuCatalogos();

                    for (Catalogo catalogo : listCatalogos) {
                        listaCat.add(catalogo);
                    }
                    if (!listaCat.isEmpty()) {
                        for (Catalogo cat : listaCat) {
                            if(!this.controller.findEquipaDoCatalogo(cat.identity(), colab.identity())){
                                listaFinal.add(cat);
                            }
                        }
                        for (Catalogo c : listaFinal) {
                            System.out.println(c.toString());
                        }
                    } else {
                        System.out.println("Não foi encontrado nenhum catalogo.");
                    }
                } catch (Exception e) {
                    System.out.println("Erro");
                    System.out.println("");
                    doShow();
                }

            } else if ("servico".equalsIgnoreCase(opcao)) {

                try {
                    Set<Servico> listServicos = new HashSet<>();
                    Set<Catalogo> listaCatalogosDisponiveis = new HashSet<>();
                    Set<Servico> listaFinal = new HashSet<>();
                    Iterable<Catalogo> listTodosCatalogos = this.controller.findAllCatalogos();

                    Iterable<Servico> listTodosServicos = getMenuServicos();
                    for (Servico servico : listTodosServicos) {
                        listServicos.add(servico);
                    }

                    if (!listServicos.isEmpty()) {
                        for (Catalogo cat : listTodosCatalogos) {
                            if(!this.controller.findEquipaDoCatalogo(cat.identity(), colab.identity())){
                                listaCatalogosDisponiveis.add(cat);
                            }
                        }
                        for (Catalogo c : listaCatalogosDisponiveis) {
                            Iterable<Servico> lista1 = this.controller.findServicosDoCatalogo(c.identity());
                            for (Servico servico : lista1) {
                                if (listServicos.contains(servico)) {
                                    listaFinal.add(servico);
                                }
                            }
                        }
                        for (Servico c : listaFinal) {
                            System.out.println(c.toString());
                        }
                    } else {
                        System.out.println("Não foi encontrado nenhum serviço.");
                    }
                } catch (Exception e) {
                    System.out.println("Erro");
                    System.out.println("");
                    doShow();
                }

            } else {

                System.out.println("Insira informação relativa ao catalogo");
                boolean continua = true;
                Set<Catalogo> listaFinal = new HashSet<>();
                try {
                    Set<Catalogo> l = new HashSet<>();
                    Iterable<Catalogo> listTodosCatalogos = getMenuCatalogos();
                    for (Catalogo catalogo : listTodosCatalogos) {
                        l.add(catalogo);
                    }
                    if (!l.isEmpty()) {
                        for (Catalogo cat : l) {
                            if(!this.controller.findEquipaDoCatalogo(cat.identity(), colab.identity())){
                                listaFinal.add(cat);
                            }
                        }
                        for (Catalogo c : listaFinal) {
                            System.out.println(c.toString());
                        }
                    } else {
                        System.out.println("Não foi encontrado nenhum catalogo.");
                        continua = false;
                    }
                } catch (Exception e) {
                    System.out.println("Erro");
                    System.out.println("");
                    doShow();
                }
                if (continua == true) {
                    System.out.println("Para estes catálogos agora consulte os seus servicos:");

                    try {
                        Set<Servico> listServicos = new HashSet<>();
                        Set<Servico> listaFinalServicos = new HashSet<>();

                        Iterable<Servico> listTodosServicos = getMenuServicos();
                        for (Servico servico : listTodosServicos) {
                            listServicos.add(servico);
                        }

                        for (Catalogo c : listaFinal) {
                            Iterable<Servico> lista1 = this.controller.findServicosDoCatalogo(c.identity());
                            for (Servico servico : lista1) {
                                if (listServicos.contains(servico)) {
                                    listaFinalServicos.add(servico);
                                }
                            }
                        }
                        for (Servico c : listaFinalServicos) {
                            System.out.println(c.toString());
                        }
                    } catch (Exception e) {
                        System.out.println("Erro");
                        System.out.println("");
                        doShow();
                    }
                }
            }
            String answer = Console.readLine("Deseja consultar mais catalogos e/ou servicos (S/N)?");
            if ("N".equalsIgnoreCase(answer)) {
                flag = false;
            }

        }
        return false;
    }

    private Iterable<Catalogo> getMenuCatalogos() {
        int op;
        do {
            System.out.println("Consultar Catalogo : \n 1-Pelo titulo \n 2-Pela descrição breve \n 3-Pela descrição completa" +
                    " \n 4-Pelo titulo e descrição breve \n 5-Pelo titulo e descrição completa \n 6-Pelo descrição breve e descrição completa" +
                    " \n 7-Pelo titulo, descrição breve e descrição completa \n 8-Sair");
            op = Console.readInteger("Insira o numero da opção escolhida");
            switch (op) {
                case 1:
                    TituloDataWidget titulo = lerTitulo();
                    System.out.println("TITULO::: " +titulo.titulo());
                    return this.controller.findByTitulo(titulo.titulo());
                case 2:
                    DescricaoBreveDataWidget descricaoBreve = lerDescricaoBreve();
                    return this.controller.findByDescricaoBreve(descricaoBreve.descricao());
                case 3:
                    DescricaoCompletaDataWidget descricaoCompleta = lerDescricaoCompleta();
                    return this.controller.findByDescricaoCompleta(descricaoCompleta.descricao());
                case 4:
                    TituloDataWidget titulo1 = lerTitulo();
                    DescricaoBreveDataWidget descricaoBreve1 = lerDescricaoBreve();
                    return this.controller.findByTituloDescricaoBreve(titulo1.titulo(), descricaoBreve1.descricao());
                case 5:
                    TituloDataWidget titulo2 = lerTitulo();
                    DescricaoCompletaDataWidget descricaoCompleta2 = lerDescricaoCompleta();
                    return this.controller.findByTituloDescricaoCompleta(titulo2.titulo(), descricaoCompleta2.descricao());
                case 6:
                    DescricaoBreveDataWidget descricaoBreve3 = lerDescricaoBreve();
                    DescricaoCompletaDataWidget descricaoCompleta3 = lerDescricaoCompleta();
                    return this.controller.findByDescricaoBreveDescricaoCompleta(descricaoBreve3.descricao(), descricaoCompleta3.descricao());
                case 7:
                    TituloDataWidget titulo4 = lerTitulo();
                    DescricaoBreveDataWidget descricaoBreve4 = lerDescricaoBreve();
                    DescricaoCompletaDataWidget descricaoCompleta4 = lerDescricaoCompleta();
                    return this.controller.findTodos(titulo4.titulo(), descricaoBreve4.descricao(), descricaoCompleta4.descricao());
                case 8:
                    return new HashSet<>();
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        } while (op != 8);
        return null;
    }

    private TituloDataWidget lerTitulo() {
        final TituloDataWidget tituloDataWidget = new TituloDataWidget();
        tituloDataWidget.show();
        return tituloDataWidget;
    }

    private DescricaoBreveDataWidget lerDescricaoBreve() {
        final DescricaoBreveDataWidget descricaoBreveDataWidget = new DescricaoBreveDataWidget();
        descricaoBreveDataWidget.show();
        return descricaoBreveDataWidget;
    }

    private DescricaoCompletaDataWidget lerDescricaoCompleta() {
        final DescricaoCompletaDataWidget descricaoCompletaDataWidget = new DescricaoCompletaDataWidget();
        descricaoCompletaDataWidget.show();
        return descricaoCompletaDataWidget;
    }

    private Iterable<Servico> getMenuServicos() {
        int op;
        do {
            System.out.println("Consultar Servico : \n 1-Pelo titulo \n 2-Pela descrição breve \n 3-Pela descrição completa" +
                    " \n 4-Pelas keywords \n 5-Pelo titulo e descrição breve \n 6-Pelo titulo e descrição completa \n 7-Pelo titulo e keywords" +
                    " \n 8-Pela descrição breve e descrição completa \n 9-Pelas keywords e descrição breve \n 10-Pelas keywords e descrição completa" +
                    " \n 11-Pelo titulo, descrição breve e keywords \n 12-Pelo titulo, descrição completa e keywords" +
                    " \n 13-Pela descrição breve, descrição completa e keywords \n 14-Pelo titulo, descrição breve e descrição completa" +
                    " \n 15-Pelo titulo, descrição breve, descrição completa e keywords \n 16-Sair");
            op = Console.readInteger("Insira o numero da opção escolhida");
            switch (op) {
                case 1:
                    TituloDataWidget titulo = lerTitulo();
                    return this.controller.findServicoByTitulo(titulo.titulo());
                case 2:
                    DescricaoBreveDataWidget descricaoBreve = lerDescricaoBreve();
                    return this.controller.findServicoByDescricaoBreve(descricaoBreve.descricao());
                case 3:
                    DescricaoCompletaDataWidget descricaoCompleta = lerDescricaoCompleta();
                    return this.controller.findServicoByDescricaoCompleta(descricaoCompleta.descricao());
                case 4:
                    Set<String> keywords = lerKeywords();
                    return this.controller.findServicoByKeywords(keywords);
                case 5:
                    TituloDataWidget titulo1 = lerTitulo();
                    DescricaoBreveDataWidget descricaoBreve1 = lerDescricaoBreve();
                    return this.controller.findServicoByTituloDescricaoBreve(titulo1.titulo(), descricaoBreve1.descricao());
                case 6:
                    TituloDataWidget titulo2 = lerTitulo();
                    DescricaoCompletaDataWidget descricaoCompleta2 = lerDescricaoCompleta();
                    return this.controller.findServicoByTituloDescricaoCompleta(titulo2.titulo(), descricaoCompleta2.descricao());
                case 7:
                    TituloDataWidget titulo3 = lerTitulo();
                    Set<String> keywords1 = lerKeywords();
                    return this.controller.findServicoByTituloKeywords(titulo3.titulo(), keywords1);
                case 8:
                    DescricaoBreveDataWidget descricaoBreve3 = lerDescricaoBreve();
                    DescricaoCompletaDataWidget descricaoCompleta3 = lerDescricaoCompleta();
                    return this.controller.findServicoByDescricaoBreveDescricaoCompleta(descricaoBreve3.descricao(), descricaoCompleta3.descricao());
                case 9:
                    Set<String> keywords2 = lerKeywords();
                    DescricaoBreveDataWidget descricaoBreve4 = lerDescricaoBreve();
                    return this.controller.findServicoByKeywordsdescricaoBreve(keywords2, descricaoBreve4.descricao());
                case 10:
                    Set<String> keywords3 = lerKeywords();
                    DescricaoCompletaDataWidget descricaoCompleta4 = lerDescricaoCompleta();
                    return this.controller.findServicoByKeywordsDescricaoCompleta(keywords3, descricaoCompleta4.descricao());
                case 11:
                    TituloDataWidget titulo4 = lerTitulo();
                    DescricaoBreveDataWidget descricaoBreve5 = lerDescricaoBreve();
                    Set<String> keywords4 = lerKeywords();
                    return this.controller.findServicoByTituloKeywordsDescricaoBreve(titulo4.titulo(), keywords4, descricaoBreve5.descricao());
                case 12:
                    TituloDataWidget titulo5 = lerTitulo();
                    DescricaoCompletaDataWidget descricaoCompleta5 = lerDescricaoCompleta();
                    Set<String> keywords5 = lerKeywords();
                    return this.controller.findServicoByTituloKeywordsDescricaoCompleta(titulo5.titulo(), keywords5, descricaoCompleta5.descricao());
                case 13:
                    DescricaoBreveDataWidget descricaoBreve6 = lerDescricaoBreve();
                    DescricaoCompletaDataWidget descricaoCompleta6 = lerDescricaoCompleta();
                    Set<String> keywords6 = lerKeywords();
                    return this.controller.findServicoByKeywordsDescricaoBreveDescricaoCompleta(keywords6, descricaoBreve6.descricao(), descricaoCompleta6.descricao());
                case 14:
                    TituloDataWidget titulo7 = lerTitulo();
                    DescricaoBreveDataWidget descricaoBreve7 = lerDescricaoBreve();
                    DescricaoCompletaDataWidget descricaoCompleta7 = lerDescricaoCompleta();
                    return this.controller.findServicoByTituloDescricaoBreveDescricaoCompleta(titulo7.titulo(), descricaoBreve7.descricao(), descricaoCompleta7.descricao());
                case 15:
                    TituloDataWidget titulo8 = lerTitulo();
                    DescricaoBreveDataWidget descricaoBreve8 = lerDescricaoBreve();
                    DescricaoCompletaDataWidget descricaoCompleta8 = lerDescricaoCompleta();
                    Set<String> keywords7 = lerKeywords();
                    return this.controller.findServicoTodos(titulo8.titulo(), keywords7, descricaoBreve8.descricao(), descricaoCompleta8.descricao());
                case 16:
                    return new HashSet<>();
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        } while (op != 16);
        return null;
    }

    public Set<String> lerKeywords() {
        final KeywordsDataWidget keywordsDataWidget = new KeywordsDataWidget();
        keywordsDataWidget.show();
        boolean flag1 = true;

        Set<String> keywords = new HashSet<>();
        if (!keywordsDataWidget.keyword().isEmpty()) {
            keywords.add(keywordsDataWidget.keyword());
        }

        while (flag1) {
            String answer;
            System.out.println("Deseja adicionar mais keywords?");
            answer = Console.readLine("Resposta(S/N):");
            if (answer.equalsIgnoreCase("Sim") || answer.equalsIgnoreCase("S")) {
                keywordsDataWidget.show();
                if (!keywordsDataWidget.keyword().isEmpty()) {
                    keywords.add(keywordsDataWidget.keyword());
                }
            } else {
                flag1 = false;
            }
        }
        return keywords;
    }

    @Override
    public String headline() {
        return "Consulta de catalogos e/ou servicos: ";
    }
}
