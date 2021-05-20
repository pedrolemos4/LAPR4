package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Formulario;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtividadeManual extends AtividadeAprovacao{

    protected AtividadeManual(){

    }

    @OneToOne
    private Formulario formulario;

    public AtividadeManual(final EstadoAtividade estadoAtividade, final Colaborador colab, final Decisao decisao,
                           final Comentario comentario, final Formulario formulario, final Data data) {
        super(estadoAtividade, colab, decisao, comentario,data);
        this.formulario=formulario;
    }

    public AtividadeManual(final EstadoAtividade estadoAtividade, final Set<Equipa> equipa, final Decisao decisao,
                           final Comentario comentario, final Formulario formulario, final Data data) {
        super(estadoAtividade, equipa, decisao, comentario,data);
        this.formulario=formulario;
    }

        public void setId(Long id) {
            this.id = id;
        }

        @Id
        public Long getId() {
            return id;
        }

        private Long id;
}
