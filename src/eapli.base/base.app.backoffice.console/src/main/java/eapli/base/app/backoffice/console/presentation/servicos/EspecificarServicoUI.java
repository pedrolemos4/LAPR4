package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.atividades.AtividadeAprovacaoWidget;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.HashSet;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController theController = new EspecificarServicoController();

    private static final int ESPECIFICAR_SERVICO = 20;

    private static final int EDITAR_SERVICO = 21;

    @Override
    protected boolean doShow() {
        especificarServico();
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
        System.out.println("\nSelecione o catálogo a que pertence o serviço:");
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

        //perguntar sobre os formulários e os atributos ao stor

        Set<Atributo> listaAtributos = new HashSet<>();
       /* Atributo atributo = theController.createAtributo(formularioData.nomeVariavel(), formularioData.label());
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
        }*/

        final AtividadeAprovacaoWidget atividadeAprovacaoWidget = new AtividadeAprovacaoWidget();
        System.out.println("\nEspecificação do fluxo de atividades");

        final Iterable<Criticidade> listaCriticidade = this.theController.listCriticidades();
        final SelectWidget<Criticidade> selector1 = new SelectWidget<>("Criticidade", listaCriticidade, visitee1 -> System.out.printf("%-15s%-80s\n", visitee1.identity(), visitee1.toString()));
        System.out.println("\nSelecione a criticidade:");
        selector1.show();
        final Criticidade theCriticidade = selector1.selectedElement();

        String resposta;
        FluxoAtividade fluxoAtividade= null;
        resposta = Console.readLine("O fluxo de atividades deste serviço é composto por uma atividade de aprovação?");
        if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
            atividadeAprovacaoWidget.show();

            final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(theCatalogo.identity());
            final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
            System.out.println("\nSelecione a criticidade:");
            selectorEquipa.show();
            final Equipa equipa = selectorEquipa.selectedElement();
            Set<Equipa> listEquipas = null;
           AtividadeAprovacao atividadeAprovacao = theController.novaAtividadeAprovacaoManualEquipa(EstadoAtividade.PENDENTE,listEquipas,
                    atividadeAprovacaoWidget.decisao(), atividadeAprovacaoWidget.comentario(), atividadeAprovacaoWidget.ano(), atividadeAprovacaoWidget.mes(), atividadeAprovacaoWidget.dia());
            fluxoAtividade = theController.createFluxo(atividadeAprovacao);
        }
        try {
            if (descricaoBreveData.descricao().isEmpty() || descricaoCompletaData.descricao().isEmpty()) {
                this.theController.createDraftServico(codigoUnicoData.codigoUnico(), descricaoBreveData.descricao(),
                        descricaoCompletaData.descricao(), tituloData.titulo(), formularioData.titulo(), listaAtributos,
                        keywords, theCatalogo,fluxoAtividade);
            } else {
                try {
                    Formulario formulario = this.theController.createFormulario(formularioData.titulo(), listaAtributos);
                    this.theController.especificarServico(codigoUnicoData.codigoUnico(), tituloData.titulo(), descricaoBreveData.descricao(),
                            descricaoCompletaData.descricao(), formulario, keywords, theCatalogo,fluxoAtividade);
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }
            }
        } catch (final IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
