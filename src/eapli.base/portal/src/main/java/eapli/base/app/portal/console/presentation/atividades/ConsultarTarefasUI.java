package eapli.base.app.portal.console.presentation.atividades;

import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.atividade.application.ConsultarTarefasController;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarTarefasUI extends AbstractUI {
    private final ConsultarTarefasController controller = new ConsultarTarefasController();

    @Override
    protected boolean doShow() {
        Scanner s = new Scanner(System.in);
        final Colaborador colab = this.controller.getUser();
        final List<Atividade> listTarefas = new ArrayList<>();

        int opc;
        do {
            listTarefas.clear();
            System.out.println("Lista de tarefas pendentes:\n");
            listTarefas.addAll(this.controller.tarefasPendentes(colab));

            for (Atividade a : listTarefas) {
                Pedido p = controller.getPedidoByAtividade(a);
                System.out.println(a.toString() + "\n" + p.toString());
                System.out.println();
            }
            System.out.println("Escolha uma das seguintes opções:\n" +
                    "1 - Filtrar Tarefas\n" +
                    "2 - Ordenar Tarefas\n" +
                    "0 - Sair");
            opc = s.nextInt();
            switch (opc) {
                case 1: {
                    FiltrarTarefasDataWidget filtra = new FiltrarTarefasDataWidget();
                    filtra.filtraTarefasPendentes(listTarefas, colab);
                    break;
                }
                case 2: {
                    OrdenarTarefasDataWidget ordena = new OrdenarTarefasDataWidget();
                    ordena.ordenaTarefasPendentes(listTarefas, colab);
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opc != 0);
        return false;
    }

    @Override
    public String headline() {
        return "Consultar Tarefas Pendentes";
    }
}
