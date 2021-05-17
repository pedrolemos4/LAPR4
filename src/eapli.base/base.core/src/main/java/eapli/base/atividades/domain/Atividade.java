package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

public class Atividade {

    @Column(name="CRITICIDADE")
    @OneToOne
    private Criticidade criticidade;

    @Column(name = "PRIORIDADE")
    private Prioridade prioridade;

    @Column(name="DATALIMITE")
    private Data dataLimite;

    @Column(name="ESTADOATIVIDADE")
    @Enumerated(EnumType.STRING)
    private EstadoAtividade estadoAtividade;

    public Atividade(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade){
        this.criticidade=criticidade;
        this.estadoAtividade=estadoAtividade;
        this.dataLimite=dataLimite;
        this.prioridade=prioridade;
    }
}
