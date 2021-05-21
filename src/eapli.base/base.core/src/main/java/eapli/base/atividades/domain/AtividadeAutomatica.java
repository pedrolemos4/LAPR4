package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Data;
import eapli.framework.validations.Preconditions;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorColumn(name = "AtividadeAutomatica")
public class AtividadeAutomatica extends Atividade {
    @Id
    @GeneratedValue
    private Long id;

    public AtividadeAutomatica(Data dataLimite, EstadoAtividade estadoAtividade, TipoAtividade tipoAtividade) {
        super(dataLimite, estadoAtividade, tipoAtividade);
        Preconditions.ensure(tipoAtividade == TipoAtividade.REALIZACAO, "Atividade é de realização.");

    }

    protected AtividadeAutomatica() {

    }
}
