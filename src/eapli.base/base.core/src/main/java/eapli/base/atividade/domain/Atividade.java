package eapli.base.atividade.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Formulario;
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

    @Column(name="DURAÇAO")
    private DuracaoAtividade duracaoAtividade;

    /*@ManyToOne(optional = true)
    @JoinColumn(name = "pedido")
    private Pedido pedido;*/

    public Atividade(Calendar dataLimite, EstadoAtividade estadoAtividade, TipoAtividade tipoAtividade,
                     DuracaoAtividade duracaoAtividade){
        this.estadoAtividade=estadoAtividade;
        this.dataLimite=dataLimite;
        this.tipoAtividade = tipoAtividade;
        this.duracaoAtividade = duracaoAtividade;
    }

    protected Atividade() {
        this.dataLimite=null;
        this.estadoAtividade=null;
    }

    public Atividade(Atividade atividade){
        this.estadoAtividade=atividade.estadoAtividade;
        this.dataLimite=atividade.dataLimite;
        this.tipoAtividade = atividade.tipoAtividade;
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

    public void completaDecisaoComentario(Comentario valueOf, Decisao aprovado, Atividade at) {
        AtividadeManual manual;
        manual = (AtividadeManual) at;
        manual.completaDecisaoComentario(valueOf, aprovado);
    }

    public void mudaEstadoAtividade(EstadoAtividade estado) {
        this.estadoAtividade = estado;
    }

    public void replaceFormularioAtividade(Atividade at, Formulario formFinal) {
        AtividadeManual manual;
        manual = (AtividadeManual) at;
        manual.replaceFormularioAtividade(formFinal);
    }

    public void mudaDuracao(long duracao) {
        this.duracaoAtividade = DuracaoAtividade.valueOf(duracao);
    }
}
