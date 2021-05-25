package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.application.SolicitarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Calendar;
import java.util.Scanner;

public class SolicitarServicoUI extends AbstractUI {

    SolicitarServicoController controller = new SolicitarServicoController();
    Scanner sc = new Scanner(System.in);


    @Override
    public boolean doShow(){
        System.out.println("Catálogos disponiveis________________________________________________________");
        for (Catalogo c : controller.displayAvailableCatalogos()) {
            System.out.println("ID " + c.identity() + " | " + c.titulo()+"\n");
        }
        System.out.println("Introduaza id catalogo desejado______________________________________________");
        long idCatalogo = sc.nextLong();
        Iterable<Servico> servicos = controller.getServicosCatalogo(idCatalogo);
        System.out.println("Servicos disponiveis_________________________________________________________");
        if (servicos != null) {
            for (Servico s : servicos) {
                System.out.println("Codigo " + s.identity() + " | " + s.descricaoBreve());
            }
            System.out.println("Introduza codigo do servico_________________________________________________");
            String idServico = sc.next();
            controller.preencherFormulario(idServico);
            System.out.println("Urgencia____________________________________________________________________");
            String urgencia = sc.next();
            System.out.println("Data Limite de Resolucao(yyyy/mm/dd)________________________________________");
            String data[] = sc.next().split("/");
            final Calendar data1 = Calendar.getInstance();
            data1.set(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
            controller.efetuarPedido(new UrgenciaPedido(urgencia),data1.getTime());
            return true;
        }
        return false;
    }

    @Override
    public String headline() {
        return "SolicitarServico";
    }


}