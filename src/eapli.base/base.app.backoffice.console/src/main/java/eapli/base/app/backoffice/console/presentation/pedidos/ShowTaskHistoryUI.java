package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.pedido.application.ConsultarHistoricoPedidosController;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;

public class ShowTaskHistoryUI extends AbstractUI {

    ConsultarHistoricoPedidosController controller = new ConsultarHistoricoPedidosController();

    @Override
    protected boolean doShow() {
        ArrayList<Pedido> history = (ArrayList<Pedido>) controller.getUsersTaskHistory();
        if (!history.isEmpty()){
            System.out.println("Historico de pedidos efetuados: ");
            for (Pedido p : history) {
                System.out.println(p);
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "ShowTaskHistoryUI";
    }
}
