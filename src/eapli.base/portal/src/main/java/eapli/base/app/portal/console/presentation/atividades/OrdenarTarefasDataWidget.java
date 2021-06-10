package eapli.base.app.portal.console.presentation.atividades;

import eapli.base.atividade.application.ConsultarTarefasController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.framework.io.util.Console;

import java.util.List;

public class OrdenarTarefasDataWidget {

    private final ConsultarTarefasController controller = new ConsultarTarefasController();

    private int opc;

    public void ordenaTarefasPendentes(List<Atividade> listTarefas, Colaborador colab) {

        do {
            System.out.println("Como pretende ordenar as tarefas?\n" +
                    "1 - Urgência crescente\n" +
                    "2 - Urgência decrescente\n" +
                    "3 - Data crescente\n" +
                    "4 - Data decrescente\n" +
                    "5 - Criticidade (escala) crescente\n" +
                    "6 - Criticidade (escala) decrescente\n" +
                    "7 - Criticidade (etiqueta) crescente\n" +
                    "8 - Criticidade (etiqueta) decrescente\n" +
                    "0 - Sair");
            opc = Console.readInteger("Insira uma opção:");
            switch (opc) {
                case 1: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarUrgencia(colab, UrgenciaPedido.REDUZIDA));
                    listTarefas.addAll(this.controller.filtrarUrgencia(colab, UrgenciaPedido.MODERADA));
                    listTarefas.addAll(this.controller.filtrarUrgencia(colab, UrgenciaPedido.URGENTE));

                    printTarefas(listTarefas);
                    break;
                }
                case 2: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarUrgencia(colab, UrgenciaPedido.URGENTE));
                    listTarefas.addAll(this.controller.filtrarUrgencia(colab, UrgenciaPedido.MODERADA));
                    listTarefas.addAll(this.controller.filtrarUrgencia(colab, UrgenciaPedido.REDUZIDA));

                    printTarefas(listTarefas);
                    break;
                }
                case 3: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.ordenarDataCrescente(colab));

                    printTarefas(listTarefas);
                    break;
                }
                case 4: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.ordenarDataDecrescente(colab));

                    printTarefas(listTarefas);
                    break;
                }
                case 5: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 1));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 2));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 3));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 4));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 5));

                    printTarefas(listTarefas);
                    break;
                }
                case 6: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 5));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 4));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 3));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 2));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, 1));

                    printTarefas(listTarefas);
                    break;
                }
                case 7: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "BAIXA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "MEDIA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "ELEVADA"));

                    printTarefas(listTarefas);
                    break;
                }
                case 8: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "ELEVADA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "MEDIA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "BAIXA"));

                    printTarefas(listTarefas);
                }
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opc != 0);
    }

    private void printTarefas(List<Atividade> listTarefas){
        for (Atividade a : listTarefas) {
            Pedido p = controller.getPedidoByAtividade(a);
            System.out.println(a.toString() + "\n" + p.toString() + "\n");
        }
    }
}
