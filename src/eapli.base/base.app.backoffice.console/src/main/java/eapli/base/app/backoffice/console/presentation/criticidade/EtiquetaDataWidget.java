package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class EtiquetaDataWidget {
    private String etiqueta;
    
    public void show(){
        this.etiqueta = Console.readLine("Etiqueta:");
    }

    public String etiqueta(){
        return this.etiqueta;
    }
    
}
