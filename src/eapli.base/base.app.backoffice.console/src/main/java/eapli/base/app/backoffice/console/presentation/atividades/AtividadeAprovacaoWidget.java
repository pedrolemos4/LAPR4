package eapli.base.app.backoffice.console.presentation.atividades;

import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.criticidade.domain.Criticidade;
import eapli.framework.io.util.Console;

public class AtividadeAprovacaoWidget {

    //private final Criticidade c;
    private String prior;
    private int ano;
    private int mes;
    private int dia;
   // private final EstadoAtividade e;
    private String decisao;
    private String comentario;

    public void show(){
        this.prior= Console.readLine("Prioridade:");
        this.ano=Console.readInteger("Ano:");
        this.mes=Console.readInteger("Mês:");
        this.dia=Console.readInteger("Dia:");
        this.decisao=Console.readLine("Decisão:");
        this.comentario=Console.readLine("Comentário");
    }

    public String prior(){
        return this.prior;
    }

    public int ano(){
        return this.ano;
    }

    public int mes(){
        return this.mes;
    }

    public int dia(){
        return this.dia;
    }

    public String decisao(){
        return this.decisao;
    }

    public String comentario(){
        return this.comentario;
    }
}
