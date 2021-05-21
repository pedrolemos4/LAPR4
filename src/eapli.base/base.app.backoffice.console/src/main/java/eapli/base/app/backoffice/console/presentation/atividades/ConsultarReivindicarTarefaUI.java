package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.application.ConsultarReivindicarTarefaController;
import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.AtividadeManual;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.servico.domain.Servico;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ConsultarReivindicarTarefaUI extends AbstractUI {

    private final ConsultarReivindicarTarefaController controller = new ConsultarReivindicarTarefaController();

    @Override
    protected boolean doShow() {
        Colaborador colab = this.controller.getUser();
        // retornar lista cujas tarefas tenham sido atribuidas a equipas em que o user esteja
        String atividade = "AtividadeManual";
        Iterable<Atividade> list = this.controller.getListaTarefasPendentes(colab.identity(), atividade);

        //mostra lista
        for(Atividade a : list){
            System.out.println(a.toString());
        }

        // escolhe id da tarefa
        int idAtividade = Console.readInteger("Insira o id da tarefa que pretende realizar");
        Atividade manual = this.controller.getTarefaById(idAtividade);

        AtividadeManual am = (AtividadeManual) manual;
        am.adicionaColaborador(colab);

        // FALTA PERSISITIR INFO

        return false;
    }

    @Override
    public String headline() {
        return "Consultar tarefas que eu posso reivindicar para mim";
    }

}
