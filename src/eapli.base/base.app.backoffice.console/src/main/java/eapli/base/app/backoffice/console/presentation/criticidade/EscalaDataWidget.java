package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class EscalaDataWidget {
    private int escala;
    
    public void show(){
        this.escala = Console.readInteger("Escala:");
    }

    public int escala(){
        return this.escala;
    }
}
