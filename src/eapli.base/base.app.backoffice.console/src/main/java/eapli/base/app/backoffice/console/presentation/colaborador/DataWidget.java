package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.usermanagement.domain.Data;
import eapli.framework.io.util.Console;

public class DataWidget {

    private String value;

    public void show(){
        this.value=Console.readLine("Data:");
    }

    public String value(){
        return this.value;
    }

}
