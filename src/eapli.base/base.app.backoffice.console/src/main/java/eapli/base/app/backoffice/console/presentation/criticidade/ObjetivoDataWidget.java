package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class ObjetivoDataWidget {
    
    private int tempoMax;
    
    private int tempoMedio;

    public void show(){
        tempoMax = 0;
        while(tempoMax<=0) {
            this.tempoMax = Console.readInteger("Tempo Maximo:");
            tempoMedio = 0;
            while(tempoMedio <= 0 || tempoMax < tempoMedio) {
                this.tempoMedio = Console.readInteger("Tempo Medio:");
            }
        }
    }

    public int tempoMax(){
        return this.tempoMax;
    }
    
    public int tempoMedio(){
        return this.tempoMedio;
    }
    
}
