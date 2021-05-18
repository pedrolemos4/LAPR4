package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

public class AtividadeManual extends AtividadeAprovacao{

    public AtividadeManual(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Colaborador colab, Decisao decisao, Comentario comentario) {
        super(criticidade, prioridade, dataLimite, estadoAtividade, colab, decisao, comentario);
    }

    public AtividadeManual(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Decisao decisao, Comentario comentario) {
        super(criticidade, prioridade, dataLimite, estadoAtividade, decisao, comentario);
    }

}
