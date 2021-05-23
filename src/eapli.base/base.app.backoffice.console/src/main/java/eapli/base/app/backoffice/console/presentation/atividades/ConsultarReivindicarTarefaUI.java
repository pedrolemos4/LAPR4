package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.application.ConsultarReivindicarTarefaController;
import eapli.base.atividades.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class ConsultarReivindicarTarefaUI extends AbstractUI {

    private final ConsultarReivindicarTarefaController controller = new ConsultarReivindicarTarefaController();

    @Override
    protected boolean doShow() {
        Colaborador colab = this.controller.getUser();
        // retornar lista cujas tarefas tenham sido atribuidas a equipas em que o user esteja para as poder reinvidicar
        String atividade = "AtividadeManual";
        Iterable<Atividade> list = this.controller.getListaTarefasPendentes(colab.identity(), atividade);

        //mostra lista de tarefas
        for(Atividade a : list){
            System.out.println(a.toString());
        }

        boolean flag = true;

        while (flag) {
            String opcao = Console.readLine("Deseja reinvidicar uma destas tarefas? (sim|nao)");
            if ("sim".equalsIgnoreCase(opcao) || opcao.equalsIgnoreCase("s")) {
                // escolhe id da tarefa
                int idAtividade = Console.readInteger("Insira o id da tarefa que pretende realizar");
                // atividade correspondente
                Atividade manual = this.controller.getTarefaById(idAtividade);
                // pedido correspondente
                Pedido pedido = this.controller.getPedidoByTarefa(idAtividade);
                // atualiza
                pedido.adicionaColaborador(colab, manual);
                // guarda atualizacao
                this.controller.saveAtualizacao(pedido);

                //am.adicionaColaborador(colab, idAtividade);

            } else {
                flag = false;
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Consultar tarefas que posso reivindicar para mim";
    }

}
