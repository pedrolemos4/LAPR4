package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

public class AtividadeRealizacao extends Atividade{

    public AtividadeRealizacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade) {
        super(criticidade, prioridade, dataLimite, estadoAtividade);
    }
    
}
