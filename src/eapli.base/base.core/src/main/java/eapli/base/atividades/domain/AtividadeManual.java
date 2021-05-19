package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.Equipa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtividadeManual{ //extends AtividadeAprovacao{

    protected AtividadeManual(){

    }

    public AtividadeManual(final Criticidade criticidade,final Prioridade prioridade, final Data dataLimite,
                           final EstadoAtividade estadoAtividade, final Colaborador colab, final Decisao decisao,
                           final Comentario comentario) {
      //  super(criticidade, prioridade, dataLimite, estadoAtividade, colab, decisao, comentario);
    }

    public AtividadeManual(final Criticidade criticidade, final Prioridade prioridade, final Data dataLimite,
                           final EstadoAtividade estadoAtividade, final Equipa equipa, final Decisao decisao,
                           final Comentario comentario) {
       // super(criticidade, prioridade, dataLimite, estadoAtividade, equipa, decisao, comentario);
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
