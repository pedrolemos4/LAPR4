package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.framework.io.util.Console;

public class FormularioDataWidget {

    private String titulo;

    private String nomeVariavel;

    private String label;

    public void show(){
        this.titulo= Console.readLine("\nTítulo do Formulario:");
      //  atributo();
    }

    public void atributo(){
        System.out.println("\nDados do Atributo");
        this.nomeVariavel=Console.readLine("\nNome de variável:");
        this.label=Console.readLine("\nLabel:");
    }

    public String titulo(){
        return this.titulo;
    }

    public String nomeVariavel(){
        return this.nomeVariavel;
    }

    public String label(){
        return this.label;
    }
}
