package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.framework.io.util.Console;

public class TituloDataWidget {

    private String titulo;

    public void show(){
        this.titulo = Console.readLine("Título:");
    }

    public String titulo(){
        return this.titulo;
    }
}
