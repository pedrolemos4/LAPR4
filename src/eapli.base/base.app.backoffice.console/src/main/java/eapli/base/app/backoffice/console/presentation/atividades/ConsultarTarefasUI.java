package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.atividades.application.ConsultarTarefasController;
import eapli.base.pedido.domain.Pedido;
import eapli.base.servico.domain.Servico;
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
            for (Pedido p : listPedidos) {
                Servico servico = this.controller.getServico(p);
                FluxoAtividade fluxo = this.controller.getFluxo(servico);
                listTarefas.addAll(this.controller.tarefasPendentes(fluxo, colab));

                for (Atividade a : listTarefas) {
                    System.out.println(a.toString() + "\n" + p.toString());
                    System.out.println();
                }
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
                                "3 - Criticidade\n" +
                                "0 - Sair");
                        opc2 = s.nextInt();
                        switch (opc2) {
                            case 1: {
                                listTarefas.clear();
                                System.out.println("Qual a urgência do pedido que deseja verificar?");
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
                                }
                            }
                            case 2: {
                                listTarefas.clear();
                                System.out.println("Insira o intervalo de tempo onde quer procurar tarefas.");
                                System.out.println("Data inicio: (yyyy/mm/dd)");
                                String dataI[] = s.next().split("/");
                                final Calendar data1 = Calendar.getInstance();
                                data1.set(Integer.parseInt(dataI[0]),Integer.parseInt(dataI[1]),Integer.parseInt(dataI[2]));
                                System.out.println("Data fim: (yyyy/mm/dd)");
                                String dataF[] = s.next().split("/");
                                final Calendar data2 = Calendar.getInstance();
                                data2.set(Integer.parseInt(dataF[0]),Integer.parseInt(dataF[1]),Integer.parseInt(dataF[2]));

                                System.out.println("Lista de tarefas pendentes filtrada: \n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.filtrarData(fluxo, colab, data1, data2));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
                                }
                            }
                            case 3: {
                                listTarefas.clear();
                                System.out.println("Qual a criticidade do pedido que deseja verificar?");
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
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
                                "5 - Criticidade crescente\n" +
                                "6 - Criticidade decrescente\n" +
                                "0 - Sair");
                        opc3 = s.nextInt();
                        switch (opc3) {
                            case 1: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
                                }
                            }
                            case 2: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
                                }
                            }
                            case 3: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarDataCrescente(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
                                }
                            }
                            case 4: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarDataDecrescente(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
                                }
                            }
                            case 5: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
                                }
                            }
                            case 6: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade fluxo = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(fluxo, colab));

                                    for (Atividade a : listTarefas) {
                                        System.out.println(a.toString() + "\n" + p.toString());
                                        System.out.println();
                                    }
                                    listTarefas.clear();
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
