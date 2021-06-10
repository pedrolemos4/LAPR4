package eapli.base.app.portal.console.presentation.pedido;

import eapli.base.pedido.application.ConsultarHistoricoPedidosController;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.List;

public class ShowTaskHistoryUI extends AbstractUI {

    private final String SEPARATOR = "=======================================================";

    ConsultarHistoricoPedidosController controller = new ConsultarHistoricoPedidosController();

    @Override
    protected boolean doShow() {
        ArrayList<Pedido> emCurso = (ArrayList<Pedido>) controller.getUsersOnGoingTaks();
        ArrayList<Pedido> history = (ArrayList<Pedido>) controller.getUsersTaskHistory();
        System.out.println("Em curso");
        showLista(emCurso);
        System.out.println(SEPARATOR);
        System.out.println("Historico de pedidos efetuados");
        showLista(history);
        return true;
    }

    private void showLista(List<Pedido> lista){
        for (Pedido p : lista) {
            System.out.println(SEPARATOR);
            System.out.println("Cod: "+p.identity()+"\nServico: "+p.servico());
        }
    }



    @Override
    public String headline() {
        return "ShowTaskHistoryUI";
    }
}
