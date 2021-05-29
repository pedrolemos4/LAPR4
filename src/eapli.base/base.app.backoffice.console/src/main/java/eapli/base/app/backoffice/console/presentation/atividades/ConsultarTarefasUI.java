package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.atividades.application.ConsultarTarefasController;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ConsultarTarefasUI extends AbstractUI {
    private final ConsultarTarefasController controller = new ConsultarTarefasController();

    @Override
    protected boolean doShow() {
        Scanner s = new Scanner(System.in);
        final Colaborador colab = this.controller.getUser();
        final Iterable<Pedido> listPedidos = this.controller.listPedidos();
        final List<Atividade> listTarefas = new ArrayList<>();

        int opc, opc2, opc3;
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
                    do {
                        System.out.println("Como pretende filtrar as tarefas?\n" +
                                "1 - Urgência\n" +
                                "2 - Data\n" +
                                "3 - Criticidade (Escala)\n" +
                                "4 - Criticidade (Etiqueta)\n" +
                                "0 - Sair");
                        opc2 = s.nextInt();
                        switch (opc2) {
                            case 1: {
                                listTarefas.clear();
                                System.out.println("Qual a urgência do pedido que deseja verificar?");
                                for (UrgenciaPedido u : UrgenciaPedido.values()) {
                                    System.out.println(u);
                                }
                                String r = s.next();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                listTarefas.clear();
                                listTarefas.addAll(this.controller.filtrarUrgencia(colab, r));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
                            }
                            case 2: {
                                listTarefas.clear();
                                System.out.println("Insira o intervalo de tempo onde quer procurar tarefas.");
                                System.out.println("Data inicio: (yyyy/mm/dd)");
                                String dataI[] = s.next().split("/");
                                final Calendar data1 = Calendar.getInstance();
                                data1.set(Integer.parseInt(dataI[0]),Integer.parseInt(dataI[1]),Integer.parseInt(dataI[2]), 0, 0,0);
                                System.out.println("Data fim: (yyyy/mm/dd)");
                                String dataF[] = s.next().split("/");
                                final Calendar data2 = Calendar.getInstance();
                                data2.set(Integer.parseInt(dataF[0]),Integer.parseInt(dataF[1]),Integer.parseInt(dataF[2]),0,0,0);

                                System.out.println("Lista de tarefas pendentes filtrada: \n");
                                listTarefas.clear();
                                listTarefas.addAll(this.controller.filtrarData(colab, data1, data2));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
                            }
                            case 3: {
                                int escala;
                                listTarefas.clear();
                                do {
                                    System.out.println("Qual a escala criticidade do pedido que deseja verificar? (1-5)");
                                    escala = s.nextInt();
                                } while (escala > 5 || escala < 1);
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                listTarefas.clear();
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscala(colab, escala));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                            }
                            case 4: {
                                listTarefas.clear();
                                System.out.println("Qual a etiqueta criticidade do pedido que deseja verificar?");
                                System.out.println("BAIXA");
                                System.out.println("MEDIA");
                                System.out.println("ELEVADA");
                                String r2 = s.next();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                listTarefas.clear();
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, r2));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opc2 != 0);
                    break;
                }
                case 2: {
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
                        opc3 = s.nextInt();
                        switch (opc3) {
                            case 1: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas ordenada:\n");
                                listTarefas.addAll(this.controller.filtrarUrgencia(colab, "REDUZIDA"));
                                listTarefas.addAll(this.controller.filtrarUrgencia(colab, "MODERADA"));
                                listTarefas.addAll(this.controller.filtrarUrgencia(colab, "URGENTE"));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
                            }
                            case 2: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas ordenada:\n");
                                listTarefas.addAll(this.controller.filtrarUrgencia(colab, "URGENTE"));
                                listTarefas.addAll(this.controller.filtrarUrgencia(colab, "MODERADA"));
                                listTarefas.addAll(this.controller.filtrarUrgencia(colab, "REDUZIDA"));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
                            }
                            case 3: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas ordenada:\n");
                                listTarefas.addAll(this.controller.ordenarDataCrescente(colab));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
                            }
                            case 4: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas ordenada:\n");
                                listTarefas.addAll(this.controller.ordenarDataDecrescente(colab));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
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

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
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

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
                            }
                            case 7: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas ordenada:\n");
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "BAIXA"));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "MEDIA"));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "ELEVADA"));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
                            }
                            case 8: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas ordenada:\n");
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "ELEVADA"));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "MEDIA"));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiqueta(colab, "BAIXA"));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                            }
                            case 0:
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opc3 != 0);
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
