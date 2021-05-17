package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

public class AtividadeAutomatica extends AtividadeRealizacao {

    public AtividadeAutomatica(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade) {
        super(criticidade, prioridade, dataLimite, estadoAtividade);
    }

}
