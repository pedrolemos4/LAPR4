package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.gestaoservicosrh.application.LerFicheiroColaboradorController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.FileNotFoundException;

public class LerFicheiroColaboradorUI extends AbstractUI {

    private final LerFicheiroColaboradorController controller = new LerFicheiroColaboradorController();

    @Override
    protected boolean doShow() {

        System.out.println("Insira o ficheiro do colaborador");
        String nomeFicheiro=Console.readLine("Nome ficheiro");

        this.controller.lerDados(nomeFicheiro);

        return false;
    }

    @Override
    public String headline() {
        return "Ler dados do ficheiro do colaborador";
    }
}
