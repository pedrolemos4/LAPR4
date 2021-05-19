package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.Equipa;

import javax.persistence.Column;
import javax.persistence.OneToOne;

public class AtividadeAprovacao extends Atividade{

    @OneToOne
    private Colaborador colab;

    @OneToOne
    private Equipa equipa;

    @Column(name = "DECISAO")
    private Decisao decisao;

    @Column(name = "COMENTARIO")
    private Comentario comentario;

    public AtividadeAprovacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Colaborador colab, Decisao decisao, Comentario comentario) {
        super(criticidade, prioridade, dataLimite, estadoAtividade);
        this.colab = colab;
        this.decisao = decisao;
        this.comentario = comentario;
    }

    public AtividadeAprovacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Equipa equipa, Decisao decisao, Comentario comentario) {
        super(criticidade, prioridade, dataLimite, estadoAtividade);
        this.equipa=equipa;
        this.decisao = decisao;
        this.comentario = comentario;
    }
}
