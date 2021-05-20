package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.atividades.AtividadeAprovacaoWidget;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.draft.domain.DraftServico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.application.CompletarServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import javax.persistence.EntityExistsException;
import javax.persistence.RollbackException;
import java.util.List;
import java.util.Set;

public class CompletarServicoUI  extends AbstractUI {

    private final CompletarServicoController theController = new CompletarServicoController();

    @Override
    protected boolean doShow() {
        editarServico();
        return false;
    }

    @Override
    public String headline() {
        return "Completar Serviço";
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

        FluxoAtividade fluxoAtividade= null;

        if(draftServico.fluxo()==null){
            final AtividadeAprovacaoWidget atividadeAprovacaoWidget = new AtividadeAprovacaoWidget();
            System.out.println("\nEspecificação do fluxo de atividades");

            String resposta;
            resposta = Console.readLine("O fluxo de atividades deste serviço é composto por uma atividade de aprovação?");
            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                atividadeAprovacaoWidget.show();

                final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(draftServico.catalogo().identity());
                final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
                System.out.println("\nSelecione a equipa:");
                selectorEquipa.show();
                final Equipa equipa = selectorEquipa.selectedElement();
                Set<Equipa> listEquipas = null;
                AtividadeAprovacao atividadeAprovacao = theController.novaAtividadeAprovacaoManualEquipa(EstadoAtividade.PENDENTE,listEquipas,
                        atividadeAprovacaoWidget.decisao(), atividadeAprovacaoWidget.comentario(), atividadeAprovacaoWidget.ano(), atividadeAprovacaoWidget.mes(), atividadeAprovacaoWidget.dia());
                fluxoAtividade = theController.createFluxo(atividadeAprovacao);
            }
        }
        try {
            Formulario formulario = this.theController.createFormulario(draftServico.tituloFormulario(), draftServico.listaAtributos());
            try{
                this.theController.especificarServico(draftServico.codigoUnico(), draftServico.titulo(), descricaoBreveData.descricao(),
                        descricaoCompletaData.descricao(), formulario, draftServico.keywords(), draftServico.catalogo(),fluxoAtividade);
                this.theController.removeDraft(draftServico);
            } catch(@SuppressWarnings("unused") final RollbackException ex){
                System.out.println("WARNING: That entity has already been changed or deleted since you last read it");
            } catch (@SuppressWarnings("unused") final EntityExistsException ex){
                System.out.println("WARNING: That entity has already been changed or deleted since you last read it");
            }
        } catch (final IntegrityViolationException e) {
            System.out.println("Erro.");
        } catch (final IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }

}
