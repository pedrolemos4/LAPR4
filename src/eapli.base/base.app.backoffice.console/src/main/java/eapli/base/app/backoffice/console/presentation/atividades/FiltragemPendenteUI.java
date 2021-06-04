package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividade.application.ConsultarReivindicarTarefaController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.framework.io.util.Console;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class FiltragemPendenteUI {

    Scanner s = new Scanner(System.in);

    private final ConsultarReivindicarTarefaController controller = new ConsultarReivindicarTarefaController();

    private int opc2;

    public void filtraTarefasPendentes(List<Atividade> listTarefas, Colaborador colab) {
        do {
            System.out.println("Como pretende filtrar as tarefas?\n" +
                    "1 - Urgência\n" +
                    "2 - Data\n" +
                    "3 - Criticidade (Escala)\n" +
                    "4 - Criticidade (Etiqueta)\n" +
                    "0 - Sair");
            opc2 = Console.readInteger("Insira o numero da opção escolhida");
            switch (opc2) {
                case 1: {
                    listTarefas.clear();
                    System.out.println("Lista de tipos de Urgencia:\n");
                    for (UrgenciaPedido u : UrgenciaPedido.values()) {
                        System.out.println(u);
                    }
                    String r = Console.readLine("Insira a Urgencia:\n");
                    System.out.println("Lista de tarefas pendentes filtrada:\n");
                    listTarefas.clear();
                    listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, r));

                    printTarefas(listTarefas);
                    break;
                }
                case 2: {
                    listTarefas.clear();
                    System.out.println("Insira o intervalo de tempo onde quer procurar tarefas.");
                    System.out.println("Data inicio: (yyyy/mm/dd)");
                    String dataI[] = s.next().split("/");
                    final Calendar data1 = Calendar.getInstance();
                    data1.set(Integer.parseInt(dataI[0]), Integer.parseInt(dataI[1]), Integer.parseInt(dataI[2]), 0, 0, 0);
                    System.out.println("Data fim: (yyyy/mm/dd)");
                    String dataF[] = s.next().split("/");
                    final Calendar data2 = Calendar.getInstance();
                    data2.set(Integer.parseInt(dataF[0]), Integer.parseInt(dataF[1]), Integer.parseInt(dataF[2]), 0, 0, 0);

                    System.out.println("Lista de tarefas pendentes filtrada: \n");
                    listTarefas.clear();
                    listTarefas.addAll(this.controller.filtrarDataPendentes(colab, data1, data2));

                    printTarefas(listTarefas);
                    break;
                }
                case 3: {
                    int escala;
                    listTarefas.clear();
                    do {
                        escala = Console.readInteger("Qual a escala criticidade do pedido que deseja verificar? (1-5)");
                    } while (escala > 5 || escala < 1);
                    System.out.println("Lista de tarefas pendentes filtrada:\n");
                    listTarefas.clear();
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, escala));

                    printTarefas(listTarefas);
                    break;
                }
                case 4: {
                    listTarefas.clear();
                    System.out.println("Qual a etiqueta criticidade do pedido que deseja verificar?");
                    System.out.println("BAIXA\nMEDIA\nELEVADA");
                    String r2 = s.next();
                    System.out.println("Lista de tarefas pendentes filtrada:\n");
                    listTarefas.clear();
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, r2));

                    printTarefas(listTarefas);

                }
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opc2 != 0);
    }

    private void printTarefas(List<Atividade> listTarefas){
        for (Atividade a : listTarefas) {
            Pedido p = controller.getPedidoByAtividade(a);
            System.out.println(a.toString() + "\n" + p.toString());
            System.out.println();
        }
    }

}
