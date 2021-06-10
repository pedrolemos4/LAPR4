package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.atividades.AtividadeAprovacaoWidget;
import eapli.base.app.backoffice.console.presentation.atividades.AtividadeResolucaoWidget;
import eapli.base.atividade.domain.*;
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
import java.util.HashSet;
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
        boolean flag;
        if(draftServico.fluxo()==null){
            final AtividadeResolucaoWidget atividadeResolucaoWidget = new AtividadeResolucaoWidget();
            final AtividadeAprovacaoWidget atividadeAprovacaoWidget = new AtividadeAprovacaoWidget();
            System.out.println("\nEspecificação do fluxo de atividades");

            Set<Atividade> listAtividades = new HashSet<>();
            String tipoResolucao;
            tipoResolucao = Console.readLine("A atividade de resolução é automática ou manual?");

            flag = false;
            while (flag) {
                if (tipoResolucao.equalsIgnoreCase("manual")) {
                    atividadeResolucaoWidget.doManual();
                    final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(draftServico.catalogo().identity());
                    final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
                    System.out.println("\nSelecione a Equipa:");
                    selectorEquipa.show();
                    final Equipa equipa = selectorEquipa.selectedElement();
                    Set<Equipa> listEquipas = new HashSet<>();
                    listEquipas.add(equipa);
                    Formulario form = null;
                    TipoAtividade tipo = TipoAtividade.REALIZACAO;
                    AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualEquipa(EstadoAtividade.PENDENTE, listEquipas,
                            /*atividadeResolucaoWidget.decisao(), atividadeResolucaoWidget.comentario(),*/ atividadeResolucaoWidget.ano(),
                            atividadeResolucaoWidget.mes(), atividadeResolucaoWidget.dia(), form,tipo);
                    listAtividades.add(atividadeManual);
                    flag = true;

                } else if (tipoResolucao.equalsIgnoreCase("automatica") || tipoResolucao.equalsIgnoreCase("automática")) {
                    atividadeResolucaoWidget.doAutomatica();
                    AtividadeAutomatica atividadeAutomatica = theController.novaAtividadeAutomatica(atividadeResolucaoWidget.anoA(),
                            atividadeResolucaoWidget.mesA(),atividadeResolucaoWidget.diaA());
                    listAtividades.add(atividadeAutomatica);
                    flag = true;
                } else {
                    System.out.println("Responda corretamente");
                    flag = false;
                }
            }

            String resposta;
            resposta = Console.readLine("O fluxo de atividades deste serviço é composto por uma atividade de aprovação?");
            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                atividadeAprovacaoWidget.show();

                final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(draftServico.catalogo().identity());
                final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
                System.out.println("\nSelecione a equipa:");
                selectorEquipa.show();
                final Equipa equipa = selectorEquipa.selectedElement();
                Set<Equipa> listEquipas = new HashSet<>();
                listEquipas.add(equipa);
                Formulario form = null;
                TipoAtividade tipo = TipoAtividade.APROVACAO;
                AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualEquipa(EstadoAtividade.PENDENTE,listEquipas,
                        /*atividadeAprovacaoWidget.decisao(), atividadeAprovacaoWidget.comentario(),*/ atividadeAprovacaoWidget.ano(),
                        atividadeAprovacaoWidget.mes(), atividadeAprovacaoWidget.dia(),form,tipo);
                listAtividades.add(atividadeManual);
            }
            fluxoAtividade = theController.createFluxo(listAtividades);
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
