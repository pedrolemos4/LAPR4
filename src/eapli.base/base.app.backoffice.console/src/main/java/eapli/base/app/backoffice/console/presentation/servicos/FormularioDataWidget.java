package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.framework.io.util.Console;

public class FormularioDataWidget {

    private String titulo;

    private String nomeVariavel;

    private String label;

    private String tipoDados;

    private String obrigatoriedade;

    private String descAjuda;

    private String expressaoRegular;

    public void show(){
        this.titulo= Console.readLine("\nTítulo do Formulario:");
    }

    public void atributo(){
        System.out.println("\nDados do Atributo");
        this.tipoDados=Console.readLine("\nTipo de dados('STRING'/'DATA'/'INTEIRO'/'BOOLEAN'):");
        this.obrigatoriedade=Console.readLine("\nObrigatoriedade('OBRIGATORIO'/'OPCIONAL'):");
        this.label=Console.readLine("\nLabel:");
        this.descAjuda=Console.readLine("\nDescricao Ajuda:");
        this.expressaoRegular= Console.readLine("\nExpressao Regular:");
    }

    public String titulo(){
        return this.titulo;
    }

    public String label(){
        return this.label;
    }

    public String tipoDados(){ return  this.tipoDados;}

    public String obrigatoriedade(){ return this.obrigatoriedade;}

    public String descricaoAjuda(){ return this.descAjuda;}

    public String expressao(){ return this.expressaoRegular;}

}
