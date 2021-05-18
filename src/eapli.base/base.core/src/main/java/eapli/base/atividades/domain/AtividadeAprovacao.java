package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

import javax.persistence.Column;
import javax.persistence.OneToOne;

public class AtividadeAprovacao extends Atividade{

    @OneToOne
    private Colaborador colab;

    @Column(name = "DECISAO")
    private Decisao decisao;

    private Comentario comentario;

    public AtividadeAprovacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Colaborador colab, Decisao decisao, Comentario comentario) {
        super(criticidade, prioridade, dataLimite, estadoAtividade);
        this.colab = colab;
        this.decisao = decisao;
        this.comentario = comentario;
    }
}
