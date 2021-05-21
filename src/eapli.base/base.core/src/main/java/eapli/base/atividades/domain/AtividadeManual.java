package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@DiscriminatorColumn(name = "AtividadeManual")
public class AtividadeManual extends Atividade{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Colaborador colab;

    @OneToMany
    private Set<Equipa> equipa;

    @Column(name = "DECISAO")
    private Decisao decisao;

    @Column(name = "COMENTARIO")
    private Comentario comentario;

    @OneToOne
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
        System.out.println("COMO ESTÁ O ESTADO ?");
        System.out.println(estadoAtividade.toString());
        this.equipa = equipa;
        this.decisao = decisao;
        this.comentario = comentario;
        this.formulario=formulario;
    }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }
}
