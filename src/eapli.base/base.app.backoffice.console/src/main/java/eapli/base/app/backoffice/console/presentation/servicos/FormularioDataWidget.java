package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.formulario.domain.DescricaoAjuda;
import eapli.base.formulario.domain.Obrigatoriedade;
import eapli.base.formulario.domain.TipoDados;
import eapli.framework.io.util.Console;

public class FormularioDataWidget {

    private String titulo;

    private String nomeVariavel;

    private String label;

    private String tipoDados;

    private String obrigatoriedade;

    private String descAjuda;

    public void show(){
        this.titulo= Console.readLine("\nTítulo do Formulario:");
        atributo();
    }

    public void atributo(){
        System.out.println("\nDados do Atributo");
        this.tipoDados=Console.readLine("\nTipo de dados:");
        this.obrigatoriedade=Console.readLine("\nObrigatoriedade:");
        this.label=Console.readLine("\nLabel:");
        this.tipoDados=TipoDados.valueOf(Console.readLine("\nTipo de Dados:").toUpperCase()).toString();
        this.obrigatoriedade=Obrigatoriedade.valueOf(Console.readLine("\nObrigatoriedade:").toUpperCase()).toString();
        this.descAjuda=new DescricaoAjuda(Console.readLine("\nDescricao Ajuda:")).toString();
    }

    public void preencherVariavel(){
        this.nomeVariavel=Console.readLine("\nNome de variável:");
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

    public String tipoDados(){ return  this.tipoDados;}

    public String obrigatoriedade(){ return this.obrigatoriedade;}

    public String descricaoAjuda(){ return this.descAjuda;}

}
