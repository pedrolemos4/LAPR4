package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.atividades.application.ConsultarTarefasController;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;


public class ConsultarTarefasUI extends AbstractUI {
    private final ConsultarTarefasController controller = new ConsultarTarefasController();

    @Override
    protected boolean doShow() {
        final Colaborador colab = this.controller.getUser();
        final Iterable<Servico> listServicos = this.controller.listServicos();
        final List<Atividade> listTarefas = new ArrayList<>();

        for (Servico s : listServicos) {
            FluxoAtividade flx = this.controller.getFluxo(s);
            listTarefas.addAll(this.controller.tarefasPendentes(flx, colab));
        }

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
