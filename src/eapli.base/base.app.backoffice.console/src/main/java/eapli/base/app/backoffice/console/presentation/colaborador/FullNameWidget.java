package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.io.util.Console;

public class FullNameWidget {

    private String value;

    public void show(){
        this.value = Console.readLine("Nome Completo:");
    }

    public String value(){
        return this.value;
    }

}
