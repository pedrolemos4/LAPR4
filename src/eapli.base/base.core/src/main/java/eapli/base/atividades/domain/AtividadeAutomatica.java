package eapli.base.atividades.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
@DiscriminatorColumn(name = "AtividadeAutomatica")
public class AtividadeAutomatica extends Atividade {
    @Id
    @GeneratedValue
    private Long id;

    public AtividadeAutomatica(Calendar dataLimite, EstadoAtividade estadoAtividade, TipoAtividade tipoAtividade) {
        super(dataLimite, estadoAtividade, tipoAtividade);
        Preconditions.ensure(tipoAtividade == TipoAtividade.REALIZACAO, "Atividade é de realização.");

    }

    protected AtividadeAutomatica() {

    }
}
