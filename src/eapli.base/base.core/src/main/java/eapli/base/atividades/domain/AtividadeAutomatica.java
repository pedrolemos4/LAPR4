package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtividadeAutomatica {
    private Long id;//extends AtividadeRealizacao {

    public AtividadeAutomatica(Criticidade criticidade/*, Prioridade prioridade*/, Data dataLimite, EstadoAtividade estadoAtividade) {
        //super(criticidade, prioridade, dataLimite, estadoAtividade);
    }

    public AtividadeAutomatica() {
        super();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
