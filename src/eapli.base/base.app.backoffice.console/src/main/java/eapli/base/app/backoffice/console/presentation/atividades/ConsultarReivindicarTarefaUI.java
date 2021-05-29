package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.application.ConsultarReivindicarTarefaController;
import eapli.base.atividades.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ConsultarReivindicarTarefaUI extends AbstractUI {

    private final ConsultarReivindicarTarefaController controller = new ConsultarReivindicarTarefaController();

    @Override
    protected boolean doShow() {
        Scanner s = new Scanner(System.in);
        Colaborador colab = this.controller.getUser();
        final List<Atividade> listTarefas = new ArrayList<>();
        String atividade = "AtividadeManual";

        int opc, opc2, opc3;
        do {
            listTarefas.clear();
            System.out.println("Lista de tarefas pendentes:\n");
            listTarefas.addAll(this.controller.getListaTarefasPendentes(colab.identity(), atividade));

            for (Atividade a : listTarefas) {
                Pedido p = this.controller.getPedidoByAtividade(a);
                System.out.println(a.toString() + "\n" + p.toString());
                System.out.println();
            }
            System.out.println("Consultar tarefas:\n" +
                    "1 - Filtrar Tarefas\n" +
                    "2 - Ordenar Tarefas\n" +
                    "0 - Sair");
            opc = Console.readInteger("Insira o numero da opção escolhida");
            switch (opc) {
                case 1: {
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
                                listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, r, atividade));

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
                                listTarefas.addAll(this.controller.filtrarDataPendentes(colab, data1, data2, atividade));

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
                                    escala = Console.readInteger("Qual a escala criticidade do pedido que deseja verificar? (1-5)");
                                } while (escala > 5 || escala < 1);
                                System.out.println("Lista de tarefas pendentes filtrada:\n");
                                listTarefas.clear();
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, escala, atividade));

                                for (Atividade a : listTarefas) {
                                    Pedido p = controller.getPedidoByAtividade(a);
                                    System.out.println(a.toString() + "\n" + p.toString());
                                    System.out.println();
                                }
                                break;
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
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, r2, atividade));

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
                        opc3 = Console.readInteger("Insira o numero da opção escolhida");
                        switch (opc3) {
                            case 1: {
                                listTarefas.clear();
                                System.out.println("Lista de tarefas ordenada:\n");
                                listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "REDUZIDA", atividade));
                                listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "MODERADA", atividade));
                                listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "URGENTE", atividade));

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
                                listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "URGENTE", atividade));
                                listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "MODERADA", atividade));
                                listTarefas.addAll(this.controller.filtrarUrgenciaPendentes(colab, "REDUZIDA", atividade));

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
                                listTarefas.addAll(this.controller.ordenarDataCrescentePendentes(colab, atividade));

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
                                listTarefas.addAll(this.controller.ordenarDataDecrescentePendentes(colab, atividade));

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
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 1, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 2, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 3, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 4, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 5, atividade));

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
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 5, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 4, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 3, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 2, atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEscalaPendentes(colab, 1, atividade));

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
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "BAIXA", atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "MEDIA", atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "ELEVADA", atividade));

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
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "ELEVADA", atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "MEDIA", atividade));
                                listTarefas.addAll(this.controller.filtrarCriticidadeEtiquetaPendentes(colab, "BAIXA", atividade));

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

        // retornar lista cujas tarefas tenham sido atribuidas a equipas em que o user esteja para as poder reinvidicar
        //Iterable<Atividade> list = this.controller.getListaTarefasPendentes(colab.identity(), atividade);

        //mostra lista de tarefas
        /*for(Atividade a : list){
            System.out.println(a.toString());
        }*/

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
