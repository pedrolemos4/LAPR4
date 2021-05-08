package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.io.util.Console;

public class LocalResidenciaWidget {

    private String value;

    public void show(){
        this.value = Console.readLine("Local Residência:");
    }

    public String value(){
        return this.value;
    }

}
