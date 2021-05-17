package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.draft.domain.DraftServico;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.application.CompletarServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

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
        try {
            Formulario formulario = this.theController.createFormulario(draftServico.tituloFormulario(), draftServico.listaAtributos());
            this.theController.especificarServico(draftServico.codigoUnico(), draftServico.titulo(), descricaoBreveData.descricao(),
                    descricaoCompletaData.descricao(), formulario, draftServico.keywords(), draftServico.catalogo());
        } catch (final IntegrityViolationException e) {
            System.out.println("Erro.");
        }
        this.theController.removeDraft(draftServico);
    }

}
