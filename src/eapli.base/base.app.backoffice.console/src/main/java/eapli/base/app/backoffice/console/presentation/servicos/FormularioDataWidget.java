package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.formulario.domain.DescricaoAjuda;
import eapli.base.formulario.domain.Obrigatoriedade;
import eapli.base.formulario.domain.TipoDados;
import eapli.framework.io.util.Console;

public class FormularioDataWidget {

    private String titulo;

    private String nomeVariavel;

    private String label;

    private TipoDados tipoDados;

    private Obrigatoriedade obrigatoriedade;

    private DescricaoAjuda descAjuda;

    public void show(){
        this.titulo= Console.readLine("\nTítulo do Formulario:");
        //  atributo();
    }

    public void atributo(){
        System.out.println("\nDados do Atributo");
        this.nomeVariavel=Console.readLine("\nNome de variável:");
        this.label=Console.readLine("\nLabel:");
        this.tipoDados=TipoDados.valueOf(Console.readLine("\nTipo de Dados:").toUpperCase());
        this.obrigatoriedade=Obrigatoriedade.valueOf(Console.readLine("\nObrigatoriedade:").toUpperCase());
        this.descAjuda=new DescricaoAjuda(Console.readLine("\nDescricao Ajuda:"));
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

    public TipoDados tipoDados(){ return  this.tipoDados;}

    public Obrigatoriedade obrigatoriedade(){ return this.obrigatoriedade;}

    public DescricaoAjuda descricaoAjuda(){ return this.descAjuda;}

}
