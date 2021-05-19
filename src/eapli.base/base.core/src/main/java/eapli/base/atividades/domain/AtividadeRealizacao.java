package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtividadeRealizacao{
    private Long id; //extends Atividade{


    public AtividadeRealizacao(Criticidade criticidade, Prioridade prioridade, Data dataLimite, EstadoAtividade estadoAtividade) {
        //super(criticidade, prioridade, dataLimite, estadoAtividade);
    }

    public AtividadeRealizacao() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
