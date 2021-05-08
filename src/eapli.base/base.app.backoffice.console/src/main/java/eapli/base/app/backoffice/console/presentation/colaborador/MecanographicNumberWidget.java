package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.framework.io.util.Console;

public class MecanographicNumberWidget {

    private int value;

    public void show(){
        this.value = Console.readInteger("Número Mecanografico:");
    }

    public int value(){
        return this.value;
    }

}
