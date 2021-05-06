package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.framework.io.util.Console;

public class IdentificadorDataWidget {

    private int identificador;

    public void show(){
        this.identificador= Console.readInteger("Identificador único");
    }

    public int identificadorUnico(){
        return this.identificador;
    }
}
