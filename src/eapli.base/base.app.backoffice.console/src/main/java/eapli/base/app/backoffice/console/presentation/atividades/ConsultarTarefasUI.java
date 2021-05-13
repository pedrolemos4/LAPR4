package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.gestaoservicoshelpdesk.application.ConsultarTarefasController;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;


public class ConsultarTarefasUI extends AbstractUI {
    private final ConsultarTarefasController controller = new ConsultarTarefasController();

    @Override
    protected boolean doShow() {
        final Iterable<Servico> listServicos = this.controller.listServicos();
        return false;
    }

    @Override
    public String headline() {
        return "Consultar Tarefas Pendentes";
    }
}
