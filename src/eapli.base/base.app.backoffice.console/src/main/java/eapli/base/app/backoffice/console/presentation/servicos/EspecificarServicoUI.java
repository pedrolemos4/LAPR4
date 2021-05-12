package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.gestaoservicoshelpdesk.application.EspecificarServicoController;
import eapli.base.gestaoservicoshelpdesk.application.NovoCatalogoController;
import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController theController = new EspecificarServicoController();

    private static final int ESPECIFICAR_SERVICO = 20;

    private static final int EDITAR_SERVICO = 21;

    @Override
    protected boolean doShow() {
        System.out.println("Deseja especificar um novo serviço (opção 20) ou continuar a especificação de um serviço (opção 21)? ");
        int opcao = Console.readInteger("Opção:");
        try {
            if (opcao == ESPECIFICAR_SERVICO) {
                especificarServico();
            } else {
                editarServico();
            }
        } catch (Exception e) {
            System.out.println("Erro");
            System.out.println("");
            doShow();
        }
        return false;
    }

    private void especificarServico() {
        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final TituloDataWidget tituloData = new TituloDataWidget();
        tituloData.show();

        final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
        descricaoBreveData.show();

        final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
        descricaoCompletaData.show();

        final Iterable<Catalogo> catalogos = this.theController.listCatalogos();

        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos", catalogos, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        System.out.println("Selecione o catálogo a que pertence o serviço:");
        selector.show();
        final Catalogo theCatalogo = selector.selectedElement();

        final KeywordsDataWidget keywordsDataWidget = new KeywordsDataWidget();
        keywordsDataWidget.show();
        boolean flag = true;

        Set<String> keywords = new HashSet<>();
        keywords.add(keywordsDataWidget.keyword());

        while (flag) {
            String answer;
            System.out.println("Deseja adicionar mais keywords?");
            answer = Console.readLine("Resposta(S/N):");
            if (answer.equalsIgnoreCase("Sim") || answer.equalsIgnoreCase("S")) {
                keywordsDataWidget.show();
                keywords.add(keywordsDataWidget.keyword());
            } else {
                flag = false;
            }
        }

        flag = true;

        final FormularioDataWidget formularioData = new FormularioDataWidget();
        formularioData.show();

        Set<Atributo> listaAtributos = new HashSet<>();
        Atributo atributo = theController.createAtributo(formularioData.nomeVariavel(), formularioData.label());
        listaAtributos.add(atributo);

        while (flag) {
            String resposta;
            System.out.println("Deseja adicionar mais atributos ao formulário?");
            resposta = Console.readLine("Resposta(S/N):");
            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                formularioData.atributo();
                atributo = theController.createAtributo(formularioData.nomeVariavel(), formularioData.label());
                listaAtributos.add(atributo);
            } else {
                flag = false;
            }
        }
        if (descricaoBreveData.descricao().isEmpty() || descricaoCompletaData.descricao().isEmpty()) {
            this.theController.createDraftServico(codigoUnicoData.codigoUnico(), descricaoBreveData.descricao(),
                    descricaoCompletaData.descricao(), tituloData.titulo(), formularioData.titulo(), listaAtributos, keywords, theCatalogo);
        } else {
            try {
                Formulario formulario = this.theController.createFormulario(formularioData.titulo(), listaAtributos);
                this.theController.especificarServico(codigoUnicoData.codigoUnico(), tituloData.titulo(), descricaoBreveData.descricao(),
                        descricaoCompletaData.descricao(), formulario, keywords, theCatalogo);
            } catch (final IntegrityViolationException e) {
                System.out.println("Erro.");
            }
        }
    }

    private void editarServico() {
        final List<DraftServico> listDrafts = (List<DraftServico>) this.theController.listDrafts();
        DraftServico draftServico = null;
        if (listDrafts.isEmpty()) {
            System.out.println("Não existem serviços incompletos registados");
            return;
        }
        final SelectWidget<DraftServico> selector = new SelectWidget<>("Servico: ", listDrafts, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        selector.show();
        draftServico = selector.selectedElement();
        if (draftServico == null) {
            return;
        }
        System.out.println("Editar Serviço");
        final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
        descricaoBreveData.show();

        final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
        descricaoCompletaData.show();
        try {
            Formulario formulario = this.theController.createFormulario(draftServico.tituloFormulario(), draftServico.listaAtributos());
            this.theController.especificarServico(draftServico.codigoUnico(), draftServico.titulo(), descricaoBreveData.descricao(),
                    descricaoCompletaData.descricao(), formulario, draftServico.keywords(), draftServico.catalogo());
        } catch (final IntegrityViolationException e) {
            System.out.println("Erro.");
        }
        this.theController.removeDraft(draftServico);
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
