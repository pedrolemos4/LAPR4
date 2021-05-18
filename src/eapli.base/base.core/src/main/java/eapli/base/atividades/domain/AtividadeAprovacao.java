package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

import javax.persistence.Column;

public class AtividadeAprovacao extends Atividade{

    @Column(name = "DECISAO")
    private Decisao decisao;

    private Comentario comentario;

    public AtividadeAprovacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Decisao decisao, Comentario comentario) {
        super(criticidade, prioridade, dataLimite, estadoAtividade);
        this.decisao = decisao;
        this.comentario = comentario;
    }
}
