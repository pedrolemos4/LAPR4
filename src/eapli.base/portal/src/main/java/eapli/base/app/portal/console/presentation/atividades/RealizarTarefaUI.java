package eapli.base.app.portal.console.presentation.atividades;

import eapli.base.Application;
import eapli.base.atividade.application.RealizarTarefaController;
import eapli.base.atividade.domain.*;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RealizarTarefaUI extends AbstractUI {

    private RealizarTarefaController controller = new RealizarTarefaController();

    @Override
    protected boolean doShow() {
        boolean flag = true;
        Colaborador colab = this.controller.getUser();

        final SelectWidget<Atividade> selector = new SelectWidget<>("Selecione uma das seguintes atividades para a realizar: ",
                this.controller.getListaTarefasPendentes(colab),
                visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        selector.show();

        if (!this.controller.getListaTarefasPendentes(colab).isEmpty()) {
            // atividade correspondente
            Atividade at = selector.selectedElement();
            if (at != null) {
                //AtividadeManual atFinal = null;
                System.out.println("AT:: " + at.identity());

                Pedido pedido = this.controller.getPedidoByTarefa(at);

                System.out.println("PEDIDO:: " + pedido.identity());

                Formulario form = this.controller.getFormularioDaAtividade(at);

                if (form != null) {
                    Set<Atributo> listaAtributos = new HashSet<>();
                    // faz copia do formulario da atividade feito aquando da especificação do serviço
                    Formulario formFinal = preencherAtributos(form, listaAtributos);
                    formFinal.copyAtributos(listaAtributos);

                    // criaçao da atividade que será atualizada no pedido
                    /*atFinal = new AtividadeManual(EstadoAtividade.PENDENTE, colab, null, null,
                            formFinal, at.getDataLimite(), at.tipoAtividade());*/

                    //this.controller.savePedido(pedido);
                    this.controller.replaceFormularioAtividade(pedido, at, formFinal);
                    //this.controller.saveFormulario(formFinal);

                    try {
                        File file = new File("formularioAtividade.txt");
                        FileWriter myWriter = new FileWriter(file);
                        myWriter.write(formFinal.toString());
                        String metodo = Application.settings().getMetodoVerificacaoGramatica();
                        if (metodo.equalsIgnoreCase("visitor")) {
                            // conseguir que retorne se formulario é valido ou nao
                            flag = this.controller.validaFormularioVisitor(file);
                        } else if (metodo.equalsIgnoreCase("listener")) {
                            this.controller.validaFormularioListener(file);
                        }
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

                    //this.controller.deleteFormulario(formFinal);
                }


                //this.controller.savePedido(pedido);

                String comentario = Console.readLine("Introduza um comentario:");

                // todas as decisões são aprovadas
                Decisao decisao;
                EstadoPedido estado;
                EstadoAtividade estadoA;
                if (flag == true) {
                    estado = EstadoPedido.APROVADO;
                    decisao = Decisao.APROVADO;
                    estadoA = EstadoAtividade.COMPLETO;
                } else {
                    estado = EstadoPedido.REJEITADO;
                    decisao = Decisao.REJEITADO;
                    estadoA = EstadoAtividade.PENDENTE;
                }
                if (at.tipoAtividade() == TipoAtividade.REALIZACAO && flag == true) {
                    this.controller.completaDecisaoComentario(comentario, decisao, pedido, at, EstadoPedido.CONCLUIDO, estadoA);
                } else {
                    this.controller.completaDecisaoComentario(comentario, decisao, pedido, at, estado, estadoA);
                }

                this.controller.savePedido(pedido);
            }
        }

        return false;
    }


    private Formulario preencherAtributos(Formulario formulario1, Set<Atributo> listaAtributos) {
        List<Atributo> listaAtributosForm = this.controller.getAtributosDoFormulario(formulario1);
        Formulario formulario = new Formulario(formulario1);
        for (Atributo a : listaAtributosForm) {
            System.out.println("Label: " + this.controller.getLabelDoAtributo(a));
            String variavel = Console.readLine("Introduza o nome da variável correspondente: ");
            Atributo atributo = this.controller.createAtributo(variavel, this.controller.getLabelDoAtributo(a),
                    this.controller.tipoDados(a), this.controller.obrigatoriedade(a), this.controller.descricaoAjuda(a), formulario);
            listaAtributos.add(atributo);
        }
        return formulario;
    }

    @Override
    public String headline() {
        return "Realizar Tarefa Manual";
    }
}
