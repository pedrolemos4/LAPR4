package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.atividades.application.ConsultarTarefasController;
import eapli.base.pedido.domain.Pedido;
import eapli.base.servico.domain.Servico;
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
        final Iterable<Pedido> listPedidos = this.controller.listPedidos();
        final List<Atividade> listTarefas = new ArrayList<>();

        int opc, opc2, opc3;
        do {
            listTarefas.clear();
            for (Pedido p : listPedidos) {
                Servico servico = this.controller.getServico(p);
                FluxoAtividade flx = this.controller.getFluxo(servico);
                listTarefas.addAll(this.controller.tarefasPendentes(flx, colab));
            }

            System.out.println("Lista de tarefas pendentes:");
            for (Atividade a : listTarefas) {
                System.out.println(a.toString());
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
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(flx, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            case 2: {
                                listTarefas.clear();
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(flx, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            case 3: {
                                listTarefas.clear();
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.tarefasPendentes(flx, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opc2 != 0);
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
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarUrgenciaCrescente(flx, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            case 2: {
                                listTarefas.clear();
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarUrgenciaDecrescente(flx, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            case 3: {
                                listTarefas.clear();
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarDataCrescente(flx, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            case 4: {
                                listTarefas.clear();
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarDataDecrescente(flx, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            case 5: {
                                listTarefas.clear();
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarCritCrescente(flx, servico, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            case 6: {
                                listTarefas.clear();
                                for (Pedido p : listPedidos) {
                                    Servico servico = this.controller.getServico(p);
                                    FluxoAtividade flx = this.controller.getFluxo(servico);
                                    listTarefas.addAll(this.controller.ordenarCritDecrescente(flx, servico, colab));
                                }

                                System.out.println("Lista de tarefas pendentes filtrada:");
                                for (Atividade a : listTarefas) {
                                    System.out.println(a.toString());
                                }
                            }
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opc3 != 0);
                }
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
