package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.framework.io.util.Console;

public class FormularioDataWidget {

    private String titulo;

    private String nomeVariavel;

    private String label;

    public void show(){
        this.titulo= Console.readLine("Título do Formulario:");
        atributo();
    }

    public void atributo(){
        System.out.println("Dados do Atributo");
        this.nomeVariavel=Console.readLine("Nome de variável:");
        this.label=Console.readLine("Label:");
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
