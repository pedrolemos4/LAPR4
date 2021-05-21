package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
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

    @Column(name="TIPOATIVIDADE")
    @Enumerated(EnumType.STRING)
    private TipoAtividade tipoAtividade;

    public Atividade(Data dataLimite, EstadoAtividade estadoAtividade, TipoAtividade tipoAtividade){
        this.estadoAtividade=estadoAtividade;
        this.dataLimite=dataLimite;
        this.tipoAtividade = tipoAtividade;
    }

    protected Atividade() {
        this.dataLimite=null;
        this.estadoAtividade=null;
    }
}
