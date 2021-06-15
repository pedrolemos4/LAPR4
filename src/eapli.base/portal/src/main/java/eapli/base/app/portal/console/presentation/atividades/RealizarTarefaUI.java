package eapli.base.app.portal.console.presentation.atividades;

import eapli.base.atividade.application.RealizarTarefaController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.Decisao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Variavel;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RealizarTarefaUI extends AbstractUI {

    private RealizarTarefaController controller = new RealizarTarefaController();

    @Override
    protected boolean doShow() {
        boolean flag = false;
        Colaborador colab = this.controller.getUser();
        //System.out.println("COLABORADOR:: " + colab.identity());

        final SelectWidget<Atividade> selector = new SelectWidget<>("Selecione uma das seguintes atividades para a realizar: ",
                this.controller.getListaTarefasPendentes(colab),
                visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        selector.show();

        if(!this.controller.getListaTarefasPendentes(colab).isEmpty()) {
            // atividade correspondente
            Atividade at = selector.selectedElement();

            Pedido pedido = this.controller.getPedidoByAtividade(at);

            Formulario form = this.controller.getFormularioDaAtividade(at);

            if (form != null) {
                // faz copia do formulario da atividade feito aquando da especificação do serviço
                Formulario formFinal = new Formulario(form);

                List<Atributo> listAtributos = this.controller.getAtributosDoFormulario(form);
                for (Atributo atributo : listAtributos) {
                    // mostra a label de cada atributo
                    Console.readLine("Label: " + this.controller.getLabelDoAtributo(atributo));
                    String variavel = Console.readLine("Introduza o nome da variável correspondente: ");

                    // completa formulario final preenchendo a variavel do atributo
                    this.controller.completaForm(formFinal, Variavel.valueOf(variavel), atributo);

                }

                this.controller.replaceFormulario(pedido, at, formFinal);

                /// problema pois estás a atualizar pelo pedido e nao pelo form
                // dar save do formulario ou criar clone do formulario e só depois é que o preencho e dou save???
                try {
                    File file = new File("formularioAtividade.txt");
                    FileWriter myWriter = new FileWriter(file);
                    myWriter.write(formFinal.toString());

                    // conseguir que retorne se formulario é valido ou nao
                    flag = this.controller.validaFormulario(file);
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }

            String comentario = Console.readLine("Introduza um comentario:");

            // todas as decisões são aprovadas
            Decisao decisao;
            if(flag == true){
                 decisao = Decisao.APROVADO;
            } else{
                decisao = Decisao.REJEITADO;
            }
            this.controller.completaDecisaoComentario(comentario, decisao, pedido, at);

            this.controller.savePedido(pedido);
        }

        return false;
    }

    @Override
    public String headline() {
        return "Realizar tarefas";
    }
}
