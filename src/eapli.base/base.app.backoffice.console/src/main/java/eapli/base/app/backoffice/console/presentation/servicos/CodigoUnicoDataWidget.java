package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.framework.io.util.Console;

public class CodigoUnicoDataWidget {

    private String codigoUnico;

    public void show(){
        this.codigoUnico= Console.readLine("\nCódigo único:");
    }

    public String codigoUnico(){
        return this.codigoUnico;
    }
}
