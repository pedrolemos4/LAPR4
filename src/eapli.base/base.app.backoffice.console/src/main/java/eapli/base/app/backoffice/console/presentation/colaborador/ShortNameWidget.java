package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.io.util.Console;

public class ShortNameWidget {

    private String value;

    public void show(){
        this.value = Console.readLine("Nome curto:");
    }

    public String value(){
        return this.value;
    }

}
