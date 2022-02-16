package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class ObjetivoDataWidget {
    
    private long tempoMaxAprov;

    private long tempoMedioAprov;

    private long tempoMaxRes;

    private long tempoMedioRes;

    public void show(){
        tempoMaxAprov = 0;
        while(tempoMaxAprov<=0) {
            this.tempoMaxAprov = Console.readLong("Tempo Maximo Aprovacao:");
            tempoMedioAprov = 0;
            while(tempoMedioAprov <= 0 || tempoMaxAprov < tempoMedioAprov) {
                this.tempoMedioAprov = Console.readLong("Tempo Medio Aprovacao:");

            }
        }
        tempoMaxRes = 0;
        while(tempoMaxRes<=0) {
            this.tempoMaxRes = Console.readLong("Tempo Maximo Resolucao:");
            tempoMedioRes = 0;
            while(tempoMedioRes <= 0 || tempoMaxRes < tempoMedioRes) {
                this.tempoMedioRes = Console.readLong("Tempo Medio Resolucao:");
            }
        }
    }

    public long tempoMaxAprov(){
        return this.tempoMaxAprov;
    }
    
    public long tempoMedioAprov(){
        return this.tempoMedioAprov;
    }

    public long tempoMaxRes(){
        return this.tempoMaxRes;
    }

    public long tempoMedioRes(){
        return this.tempoMedioRes;
    }
}
