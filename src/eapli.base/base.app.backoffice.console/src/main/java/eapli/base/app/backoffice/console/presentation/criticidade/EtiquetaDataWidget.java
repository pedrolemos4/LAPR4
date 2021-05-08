package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class EtiquetaDataWidget {
    private String etiqueta;
    
    public void show(){
        try {
            this.etiqueta = Console.readLine("Etiqueta:");
        }catch (IllegalArgumentException e) {
            System.out.println("Etiqueta nao pode ser null nem empty!");
        }
    }

    public String etiqueta(){
        return this.etiqueta;
    }
    
}
