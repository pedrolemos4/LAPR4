package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.clientusermanagement.application.SolicitarServicoController;
import eapli.base.servico.domain.Servico;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;
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
        if (servicos != null) {
            for (Servico s : servicos) {
                System.out.println("Codigo " + s.identity() + " | " + s.descricaoBreve());
            }
            System.out.println("Introduaza codigo do servico_________________________________________________");
            return true;
        }
        return false;
    }

    @Override
    public String headline() {
        return "SolicitarServico";
    }


}
