package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class ObjetivoDataWidget {
    
    private double tempoMaxAprov;

    private double tempoMedioAprov;

    private double tempoMaxRes;

    private double tempoMedioRes;

    public void show(){
        tempoMaxAprov = 0;
        while(tempoMaxAprov<=0) {
            this.tempoMaxAprov = Console.readInteger("Tempo Maximo Aprovacao:");
            tempoMedioAprov = 0;
            while(tempoMedioAprov <= 0 || tempoMaxAprov < tempoMedioAprov) {
                this.tempoMedioAprov = Console.readDouble("Tempo Medio Aprovacao:");

            }
        }
        tempoMaxRes = 0;
        while(tempoMaxRes<=0) {
            this.tempoMaxRes = Console.readInteger("Tempo Maximo Resolucao:");
            tempoMedioRes = 0;
            while(tempoMedioRes <= 0 || tempoMaxRes < tempoMedioRes) {
                this.tempoMedioRes = Console.readDouble("Tempo Medio Resolucao:");
            }
        }
    }

    public double tempoMaxAprov(){
        return this.tempoMaxAprov;
    }
    
    public double tempoMedioAprov(){
        return this.tempoMedioAprov;
    }

    public double tempoMaxRes(){
        return this.tempoMaxRes;
    }

    public double tempoMedioRes(){
        return this.tempoMedioRes;
    }
}
