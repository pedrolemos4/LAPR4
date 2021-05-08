package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.io.util.Console;

public class UsernameWidget {

    private String value;

    public void show(){
        this.value = Console.readLine("Username:");
    }

    public String value(){
        return this.value;
    }
}
