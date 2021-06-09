package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividade.application.RealizarTarefaController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class RealizarTarefaUI extends AbstractUI {

    private RealizarTarefaController controller = new RealizarTarefaController();


    @Override
    protected boolean doShow() {
        Colaborador colab = this.controller.getUser();

        List<Atividade> atividades = this.controller.getListaTarefasPendentes(colab);
        return false;
    }

    @Override
    public String headline() {
        return "Realizar tarefas";
    }
}
