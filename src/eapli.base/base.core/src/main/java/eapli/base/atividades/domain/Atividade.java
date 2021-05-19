package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Atividade {

    @Id
    @GeneratedValue
    @Column(name="id_Atividade")
    private long id;

    @Column(name="CRITICIDADE")
  //  @OneToOne
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

    protected Atividade() {
        this.criticidade=null;
        this.prioridade=null;
        this.dataLimite=null;
        this.estadoAtividade=null;
    }
}
