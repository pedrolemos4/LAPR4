package eapli.base.app.portal.console.presentation.atividades;

import eapli.base.atividade.application.ConsultarReivindicarTarefaController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

public class ConsultarReivindicarTarefaUI extends AbstractUI {

    private final ConsultarReivindicarTarefaController controller = new ConsultarReivindicarTarefaController();

    @Override
    protected boolean doShow() {
        Colaborador colab = this.controller.getUser();
        final List<Atividade> listTarefas = new ArrayList<>();

        int opc;
        do {
            listTarefas.clear();
            System.out.println("Lista de tarefas pendentes:\n");
            listTarefas.addAll(this.controller.getListaTarefasPendentesColaborador(colab.identity()));

            for (Atividade a : listTarefas) {
                Pedido p = this.controller.getPedidoByAtividade(a);
                System.out.println(a.toString() + "\n" + p.toString() + "\n");
            }
            System.out.println("Consultar tarefas:\n" +
                    "1 - Filtrar Tarefas\n" +
                    "2 - Ordenar Tarefas\n" +
                    "0 - Sair");
            opc = Console.readInteger("Insira o numero da opção escolhida");
            switch (opc) {
                case 1: {
                    FiltragemPendenteDataWidget filtra = new FiltragemPendenteDataWidget();
                    filtra.filtraTarefasPendentes(listTarefas, colab);
                    break;
                }
                case 2: {
                    OrdenarPendenteDataWidget ordena = new OrdenarPendenteDataWidget();
                    ordena.ordenaTarefasPendentes(listTarefas,colab);
                }
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opc != 0);

        boolean flag = true;

        while (flag) {
            String opcao = Console.readLine("Deseja reinvidicar alguma destas tarefas? (sim|nao)");
            if ("sim".equalsIgnoreCase(opcao) || opcao.equalsIgnoreCase("s")) {

                final SelectWidget<Atividade> selector = new SelectWidget<>("Atividade: ",
                        this.controller.getListaTarefasPendentesColaborador(colab.identity()),
                        visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
                selector.show();
                // atividade correspondente
                Atividade manual = selector.selectedElement();

                // pedido correspondente
                Pedido pedido = this.controller.getPedidoByTarefa(selector.selectedElement().identity());
                // atualiza
                this.controller.adicionaColaborador(pedido, colab, manual);

                // guarda atualizacao
                this.controller.saveAtualizacao(pedido);
                System.out.println("Tarefa atualizada com sucesso!");

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
