package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.gestaoservicoshelpdesk.application.ConsultarTarefasController;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;


public class ConsultarTarefasUI extends AbstractUI {
    private final ConsultarTarefasController controller = new ConsultarTarefasController();

    @Override
    protected boolean doShow() {
        final Colaborador colab = null;
        final Iterable<Servico> listServicos = this.controller.listServicos();
        final Iterable<Atividade> listTarefas = this.controller.tarefasPendentes(listServicos, colab);

        System.out.println("Lista de tarefas pendentes: ");
        for (Atividade a : listTarefas) {
            System.out.println(a.toString());
        }
        return false;
    }

    @Override
    public String headline() {
        return "Consultar Tarefas Pendentes";
    }
}
