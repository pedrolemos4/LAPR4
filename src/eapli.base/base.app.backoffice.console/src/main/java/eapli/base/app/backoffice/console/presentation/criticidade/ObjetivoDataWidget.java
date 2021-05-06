package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class ObjetivoDataWidget {
    
    private int tempoMax;
    
    private int tempoMedio;

    public void show(){
        this.tempoMax = Console.readInteger("Tempo Maximo:");
        this.tempoMedio = Console.readInteger("Tempo Minimo:");
    }

    public int tempoMax(){
        return this.tempoMax;
    }
    
    public int tempoMedio(){
        return this.tempoMedio;
    }
    
}
