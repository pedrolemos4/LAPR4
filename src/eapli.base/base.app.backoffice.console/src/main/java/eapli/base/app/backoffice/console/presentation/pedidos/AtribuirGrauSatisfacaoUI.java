package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.application.AtribuirGrauSatisfacaoController;
import eapli.base.pedido.domain.GrauSatisfacao;
import eapli.base.pedido.domain.Pedido;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
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
            final SelectWidget<Pedido> selector = new SelectWidget<>("Tipos de Equipas: ", listPedidos, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
            selector.show();
            System.out.println("Selecione um pedido para atribuir o grau de satisfação. Prima 0 para sair.");
            opc = s.nextInt();
            if (opc == 0) {
                break;
            }
            System.out.println("Qual o grau de satisfação a atribuir a este pedido? (1-5)");
            int grau = s.nextInt();
            controller.atribuirGrau(selector.selectedElement(), new GrauSatisfacao(grau));
            System.out.println("Grau atribuido com sucesso!");
        } while (opc != 0);
        return false;
    }

    @Override
    public String headline() {
        return "Atribuir Grau Satisfação";
    }
}
