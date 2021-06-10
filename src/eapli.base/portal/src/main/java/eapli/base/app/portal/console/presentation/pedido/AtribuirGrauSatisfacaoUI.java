package eapli.base.app.portal.console.presentation.pedido;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.application.AtribuirGrauSatisfacaoController;
import eapli.base.pedido.domain.GrauSatisfacao;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtribuirGrauSatisfacaoUI extends AbstractUI {
    private final AtribuirGrauSatisfacaoController controller = new AtribuirGrauSatisfacaoController();

    @Override
    protected boolean doShow() {
        Scanner s = new Scanner(System.in);
        final Colaborador colab = this.controller.getUser();
        final List<Pedido> listPedidos = new ArrayList<>();
        listPedidos.addAll(controller.pedidosPendentes(colab));

        while (!listPedidos.isEmpty()) {
            System.out.println("Lista de pedidos:");
            final SelectWidget<Pedido> selector = new SelectWidget<>("Selecione um pedido: ", listPedidos, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
            selector.show();

            if (selector.selectedElement() != null) {
                System.out.println("Qual o grau de satisfação a atribuir a este pedido? (1-5)");
                int grau = s.nextInt();
                controller.atribuirGrau(selector.selectedElement(), new GrauSatisfacao(grau));
                System.out.println("Grau atribuido com sucesso!");
                listPedidos.remove(selector.selectedElement());
            }
        }
        if (listPedidos.isEmpty()) {
            System.out.println("Não tem pedidos para atribuir grau...");
        }
        return false;
    }

    @Override
    public String headline() {
        return "Atribuir Grau Satisfação";
    }
}
