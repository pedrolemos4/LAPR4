package eapli.base.atividade.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@DiscriminatorColumn(name = "AtividadeManual")
public class AtividadeManual extends Atividade{

    @OneToOne
    private Colaborador colab;

    @OneToMany
    private Set<Equipa> equipa;

    @Column(name = "DECISAO")
    @Enumerated(EnumType.STRING)
    private Decisao decisao;

    @Column(name = "COMENTARIO")
    private Comentario comentario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="formulario",referencedColumnName = "id")
    private Formulario formulario;

    protected AtividadeManual(){

    }

    public AtividadeManual(final EstadoAtividade estadoAtividade, final Colaborador colab, final Decisao decisao,
                           final Comentario comentario, final Formulario formulario, final Calendar data, final TipoAtividade tipoAtividade) {
        super(data,estadoAtividade,tipoAtividade);
        this.colab = colab;
        this.decisao = decisao;
        this.comentario = comentario;
        this.formulario=formulario;
    }

    public AtividadeManual(final EstadoAtividade estadoAtividade, final Set<Equipa> equipa, final Decisao decisao,
                           final Comentario comentario, final Formulario formulario, final Calendar data, final TipoAtividade tipoAtividade) {
        super(data,estadoAtividade,tipoAtividade);
        this.equipa = equipa;
        this.decisao = decisao;
        this.comentario = comentario;
        this.formulario=formulario;
    }

    @Override
    public String toString() {
        return "AtividadeManual{" +
                "colab=" + colab +
                ", equipa=" + equipa +
                ", decisao=" + decisao +
                ", comentario=" + comentario +
                ", formulario=" + formulario +
                '}';
    }

    public void adicionaColaborador(Colaborador colab) {
        this.colab = colab;
    }

    public void completaDecisaoComentario(Comentario valueOf, Decisao aprovado) {
        this.comentario = valueOf;
        this.decisao = aprovado;
    }

    public void replaceFormulario(Formulario formFinal) {
        this.formulario = formFinal;
    }
}
