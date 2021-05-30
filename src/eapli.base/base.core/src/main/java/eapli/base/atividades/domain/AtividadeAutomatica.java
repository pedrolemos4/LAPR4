package eapli.base.atividades.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@DiscriminatorColumn(name = "AtividadeAutomatica")
public class AtividadeAutomatica extends Atividade {

    @Column(name= "SCRIPT")
    private Script script;

    public AtividadeAutomatica(Calendar dataLimite, EstadoAtividade estadoAtividade, TipoAtividade tipoAtividade) {
        super(dataLimite, estadoAtividade, tipoAtividade);
        Preconditions.ensure(tipoAtividade == TipoAtividade.REALIZACAO, "Atividade é de realização.");

    }

    protected AtividadeAutomatica() {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
