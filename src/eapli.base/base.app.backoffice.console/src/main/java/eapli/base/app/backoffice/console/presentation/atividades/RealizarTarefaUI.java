package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividade.application.RealizarTarefaController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RealizarTarefaUI extends AbstractUI {

    private RealizarTarefaController controller = new RealizarTarefaController();


    @Override
    protected boolean doShow() {
        Colaborador colab = this.controller.getUser();

        List<Atividade> atividades = this.controller.getListaTarefasPendentes(colab);

        final SelectWidget<Atividade> selector = new SelectWidget<>("Selecione uma das seguintes atividades para a realizar: ",
                this.controller.getListaTarefasPendentes(colab),
                visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        selector.show();
        // atividade correspondente
        Atividade at = selector.selectedElement();

        Pedido pedido = this.controller.getPedidoByAtividade(at);

        Formulario form = this.controller.getFormularioDaAtividade(at);

        if(form != null){
            List<Atributo> listAtributos = this.controller.getAtributosDoFormulario(form);
            for(Atributo atributo : listAtributos){
                // mostra a label do atributo
                Console.readLine("Label: " + this.controller.getLabelDoAtributo(atributo));
                String variavel = Console.readLine("Introduza o nome da variável correspondente: ");
                // completa formulario preenchendo a variavel do atributo
                //atributo.completaFormulario(Variavel.valueOf(variavel));
                this.controller.completaFormulario(pedido, variavel, atributo);
                //pedido.completaFormulario(Variavel.valueOf(variavel), atributo);
            }

            /// problema pois estás a atualizar pelo pedido e nao pelo form

            /*try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write(form.toString());
                this.controller.validaFormulario(myWriter);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }*/

        }

        return false;
    }

    @Override
    public String headline() {
        return "Realizar tarefas";
    }
}
