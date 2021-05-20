package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Embeddable
public class Atividade implements ValueObject {

    @Column(name="CRITICIDADE")
    @OneToOne
    private Criticidade criticidade;

    @Column(name="DATALIMITE")
    private Data dataLimite;

    @Column(name="ESTADOATIVIDADE")
    @Enumerated(EnumType.STRING)
    private EstadoAtividade estadoAtividade;

    public Atividade(Criticidade criticidade, Data dataLimite, EstadoAtividade estadoAtividade){
        this.criticidade=criticidade;
        this.estadoAtividade=estadoAtividade;
        this.dataLimite=dataLimite;
    }

    protected Atividade() {
        this.criticidade=null;
        this.dataLimite=null;
        this.estadoAtividade=null;
    }
}
