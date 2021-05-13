package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.io.util.Console;

public class EnderecoEmailWidget {

    private String value;

    public void show(){
        this.value = Console.readLine("Endereço email:");
    }

    public String value(){
        return this.value;
    }

}
