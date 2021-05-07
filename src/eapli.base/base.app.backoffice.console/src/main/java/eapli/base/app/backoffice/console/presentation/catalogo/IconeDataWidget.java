package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.framework.io.util.Console;

public class IconeDataWidget {

    private String icone;

    public void show(){
        this.icone= Console.readLine("Icone:");
    }

    public String icone(){
        return this.icone;
    }
}
