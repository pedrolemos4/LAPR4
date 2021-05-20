package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AtividadeManual extends AtividadeAprovacao{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Colaborador colab;

    @OneToMany
    private Set<Equipa> equipa;

    @Enumerated(EnumType.STRING)
    private EstadoAtividade estadoAtividade;

    @Column(name = "DECISAO")
    private Decisao decisao;

    @Column(name = "COMENTARIO")
    private Comentario comentario;

    @Column(name = "DATA")
    private Data data;

    @Enumerated(EnumType.STRING)
    private TipoAtividade tipoAtividade;

    @OneToOne
    private Formulario formulario;

    protected AtividadeManual(){

    }

    public AtividadeManual(final EstadoAtividade estadoAtividade, final Colaborador colab, final Decisao decisao,
                           final Comentario comentario, final Formulario formulario, final Data data, final TipoAtividade tipoAtividade) {
        super(estadoAtividade, colab, decisao, comentario,data);
        this.colab = colab;
        this.decisao = decisao;
        this.comentario = comentario;
        this.estadoAtividade=estadoAtividade;
        this.data=data;
        this.tipoAtividade=tipoAtividade;
        this.formulario=formulario;
    }

    public AtividadeManual(final EstadoAtividade estadoAtividade, final Set<Equipa> equipa, final Decisao decisao,
                           final Comentario comentario, final Formulario formulario, final Data data, final TipoAtividade tipoAtividade) {
        super(estadoAtividade, equipa, decisao, comentario,data);
        this.equipa = equipa;
        this.decisao = decisao;
        this.comentario = comentario;
        this.estadoAtividade=estadoAtividade;
        this.data=data;
        this.tipoAtividade=tipoAtividade;
        this.formulario=formulario;
    }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
}
