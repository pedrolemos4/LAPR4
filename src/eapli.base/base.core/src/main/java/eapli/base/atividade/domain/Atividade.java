package eapli.base.atividade.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Atividade implements ValueObject{

    @Id
    @GeneratedValue
    @Column(name="id_Atividade")
    private long id;

    @Column(name="DATALIMITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataLimite;

    @Column(name="ESTADOATIVIDADE")
    @Enumerated(EnumType.STRING)
    private EstadoAtividade estadoAtividade;

    @Column(name="TIPOATIVIDADE")
    @Enumerated(EnumType.STRING)
    private TipoAtividade tipoAtividade;

    public Atividade(Calendar dataLimite, EstadoAtividade estadoAtividade, TipoAtividade tipoAtividade){
        this.estadoAtividade=estadoAtividade;
        this.dataLimite=dataLimite;
        this.tipoAtividade = tipoAtividade;
    }

    protected Atividade() {
        this.dataLimite=null;
        this.estadoAtividade=null;
    }

    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", DataLimite: " + dataLimite.getTime() +
                ", EstadoAtividade: " + estadoAtividade;
    }

    public void adicionaColaborador(Colaborador colab, Atividade idAtividade) {
        AtividadeManual manual = (AtividadeManual) idAtividade;
        manual.adicionaColaborador(colab);
    }

    public TipoAtividade tipoAtividade() {
        return tipoAtividade;
    }

    public void atualizarDataAtividade(Calendar dataLimiteRes) {
        this.dataLimite = dataLimiteRes;
    }
}
