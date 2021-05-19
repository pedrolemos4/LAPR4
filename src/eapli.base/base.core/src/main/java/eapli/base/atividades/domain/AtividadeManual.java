package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtividadeManual{ //extends AtividadeAprovacao{

    protected AtividadeManual(){

    }

    public AtividadeManual(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Colaborador colab, Decisao decisao, Comentario comentario) {
        //super(criticidade, prioridade, dataLimite, estadoAtividade, colab, decisao, comentario);
    }

    public AtividadeManual(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade, Decisao decisao, Comentario comentario) {
        //super(criticidade, prioridade, dataLimite, estadoAtividade, decisao, comentario);
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
