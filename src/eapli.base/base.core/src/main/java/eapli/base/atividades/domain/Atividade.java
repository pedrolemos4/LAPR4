package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Atividade implements ValueObject{

    @Id
    @GeneratedValue
    @Column(name="id_Atividade")
    private long id;

    @Column(name="DATALIMITE")
    private Data dataLimite;

    @Column(name="ESTADOATIVIDADE")
    @Enumerated(EnumType.STRING)
    private EstadoAtividade estadoAtividade;

    public Atividade(Data dataLimite, EstadoAtividade estadoAtividade){
        this.estadoAtividade=estadoAtividade;
        this.dataLimite=dataLimite;
    }

    protected Atividade() {
        this.dataLimite=null;
        this.estadoAtividade=null;
    }
}
