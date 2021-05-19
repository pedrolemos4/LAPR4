package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

import javax.persistence.*;

@Entity
public class AtividadeAprovacao{ //extends Atividade{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Colaborador colab;

    @Column(name = "DECISAO")
    private Decisao decisao;

    @Column(name = "Comentário")
    private Comentario comentario;

    protected AtividadeAprovacao(){

    }

    public AtividadeAprovacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Colaborador colab, Decisao decisao, Comentario comentario) {
       // super(criticidade, prioridade, dataLimite, estadoAtividade);
        this.colab = colab;
        this.decisao = decisao;
        this.comentario = comentario;
    }

    public AtividadeAprovacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Decisao decisao, Comentario comentario) {
       // super(criticidade, prioridade, dataLimite, estadoAtividade);
        this.decisao = decisao;
        this.comentario = comentario;
    }
}
