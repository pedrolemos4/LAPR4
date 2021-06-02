package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.application.AtribuirGrauSatisfacaoController;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.presentation.console.AbstractUI;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;

import java.util.List;
import java.util.Scanner;

public class AtribuirGrauSatisfacaoUI extends AbstractUI {
    private final AtribuirGrauSatisfacaoController controller = new AtribuirGrauSatisfacaoController();

    @Override
    protected boolean doShow() {
        Scanner s = new Scanner(System.in);
        final Colaborador colab = this.controller.getUser();
        final List<Pedido> listPedidos = null;
        int opc;
        do {
            listPedidos.clear();
            listPedidos.addAll(controller.pedidosPendentes(colab));
            System.out.println("Lista de pedidos:");
            for(Pedido p : listPedidos){
                System.out.println(p.toString());
            }
            System.out.println("Selecione um pedido para atribuir o grau de satisfação. Prima 0 para sair.");
            opc = s.nextInt();
            System.out.println("Qual o grau de satisfação a atribuir a este pedido?");
            //controller.atribuirGrau(p);
        } while (opc != 0);
        return false;
    }

    @Override
    public String headline() {
        return "Atribuir Grau Satisfação";
    }
}
