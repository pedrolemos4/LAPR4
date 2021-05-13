package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaborador.application.LerFicheiroColaboradorController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import java.io.FileNotFoundException;

public class LerFicheiroColaboradorUI extends AbstractUI {

    private final LerFicheiroColaboradorController controller = new LerFicheiroColaboradorController();

    @Override
    protected boolean doShow() {

        System.out.println("Insira o ficheiro do colaborador");
        String nomeFicheiro=Console.readLine("Nome ficheiro");

        try {
            this.controller.lerDados(nomeFicheiro);
        }catch(FileNotFoundException e){
            System.out.println("Ficheiro não encontrado");
            doShow();
        }

        return false;
    }

    @Override
    public String headline() {
        return "Ler dados do ficheiro do colaborador";
    }
}
