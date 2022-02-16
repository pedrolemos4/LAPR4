package eapli.base.app.portal.console.presentation.atividades;

import eapli.base.atividade.application.ConsultarReivindicarTarefaController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.io.util.Console;

import java.util.List;

public class OrdenarPendenteDataWidget {

    private final ConsultarReivindicarTarefaController controller = new ConsultarReivindicarTarefaController();

    private int opc3;

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
            opc3 = Console.readInteger("Insira o numero da opção escolhida");
            switch (opc3) {
                case 1: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "REDUZIDA"));
                    listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "MODERADA"));
                    listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "URGENTE"));

                    printTarefas(listTarefas);
                    break;
                }
                case 2: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "URGENTE"));
                    listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "MODERADA"));
                    listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "REDUZIDA"));

                    printTarefas(listTarefas);
                    break;
                }
                case 3: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.ordenarDataCrescentePendentes(colab));

                    printTarefas(listTarefas);
                    break;
                }
                case 4: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.ordenarDataDecrescentePendentes(colab));

                    printTarefas(listTarefas);
                    break;
                }
                case 5: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 1));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 2));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 3));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 4));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 5));

                    printTarefas(listTarefas);
                    break;
                }
                case 6: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 5));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 4));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 3));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 2));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 1));

                    printTarefas(listTarefas);
                    break;
                }
                case 7: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "BAIXA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "MEDIA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "ELEVADA"));

                    printTarefas(listTarefas);
                    break;
                }
                case 8: {
                    listTarefas.clear();
                    System.out.println("Lista de tarefas ordenada:\n");
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "ELEVADA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "MEDIA"));
                    listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "BAIXA"));

                    printTarefas(listTarefas);
                }
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opc3 != 0);
    }

    private void printTarefas(List<Atividade> listTarefas){
        for (Atividade a : listTarefas) {
            Pedido p = controller.getPedidoByTarefa(a.identity());
            System.out.println(a.toString() + "\n" + p.toString() + "\n");
        }
    }
}
