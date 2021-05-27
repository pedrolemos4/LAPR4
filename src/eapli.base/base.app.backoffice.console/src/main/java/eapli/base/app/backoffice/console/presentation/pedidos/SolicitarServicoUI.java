package eapli.base.app.backoffice.console.presentation.pedidos;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.pedido.application.SolicitarServicoController;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class SolicitarServicoUI extends AbstractUI {

    SolicitarServicoController controller = new SolicitarServicoController();
    Scanner sc = new Scanner(System.in);


    @Override
    public boolean doShow(){
        showCatalogos();
        System.out.println("Introduaza id catalogo desejado______________________________________________");
        long idCatalogo = sc.nextLong();
        showServicos(idCatalogo);
        System.out.println("Introduza codigo do servico_________________________________________________");
        String idServico = sc.next();
        solicitarServico(idServico);
        return true;
        }

    private void showCatalogos(){
        System.out.println("Catálogos disponiveis________________________________________________________");
        for (Catalogo c : controller.displayAvailableCatalogos()) {
            System.out.println("ID " + c.identity() + " | " + c.titulo()+"\n");
        }
    }

    private void showServicos(long idCatalogo){
        Iterable<Servico> servicos = controller.getServicosCatalogo(idCatalogo);
        System.out.println("Servicos disponiveis_________________________________________________________");
        if (servicos != null) {
            for (Servico s : servicos) {
                System.out.println("Codigo " + s.identity() + " | " + s.descricaoBreve());
            }
        }
    }

    private void solicitarServico(String idServico){
        controller.preencherFormulario(idServico);
        System.out.println("Urgencia____________________________________________________________________");
        for (UrgenciaPedido u : UrgenciaPedido.values()) {
            System.out.println(u);
        }
        System.out.println("Introduza Urgencia");
        String urgencia = sc.next();
        System.out.println("Data Limite de Resolucao(yyyy/mm/dd)________________________________________");
        String data[] = sc.next().split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
        controller.efetuarPedido(idServico,Enum.valueOf(UrgenciaPedido.class, urgencia.toUpperCase(Locale.ROOT)),calendar);
        System.out.println("Pretende anexar ficheiros?__________________________________________________");
    }

    @Override
    public String headline() {
        return "SolicitarServico";
    }


}
