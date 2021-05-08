package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.usermanagement.domain.Contacto;
import eapli.framework.io.util.Console;

public class ContactoWidget {

    private int value;

    public void show(){
        this.value = Console.readInteger("Contacto:");
    }

    public int value(){
        return this.value;
    }

}
