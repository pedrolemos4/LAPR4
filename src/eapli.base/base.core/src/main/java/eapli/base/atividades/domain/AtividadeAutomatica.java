package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtividadeAutomatica extends AtividadeRealizacao {
    private Long id;

    public AtividadeAutomatica(Data dataLimite, EstadoAtividade estadoAtividade) {
        super(dataLimite, estadoAtividade);
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
