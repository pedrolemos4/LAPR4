package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class EscalaDataWidget {
    private int escala;
    
    public void show(){
        escala = 0;
        while(escala <= 0 || escala > 5) {
            this.escala = Console.readInteger("Escala:");
        }
    }

    public int escala(){
        return this.escala;
    }
}
