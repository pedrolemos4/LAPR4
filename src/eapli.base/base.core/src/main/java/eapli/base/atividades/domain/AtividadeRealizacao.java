package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtividadeRealizacao extends Atividade{
    private Long id;


    public AtividadeRealizacao(Data dataLimite, EstadoAtividade estadoAtividade) {
        super(dataLimite, estadoAtividade);
    }

    protected AtividadeRealizacao() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
