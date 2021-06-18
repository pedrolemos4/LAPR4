package eapli.base.atividade.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@DiscriminatorColumn(name = "AtividadeAutomatica")
public class AtividadeAutomatica extends Atividade {

    @Column(name= "SCRIPT")
    private Script script;

    public AtividadeAutomatica(Calendar dataLimite, EstadoAtividade estadoAtividade, TipoAtividade tipoAtividade,
                               DuracaoAtividade duracao, Script script) {
        super(dataLimite, estadoAtividade, tipoAtividade, duracao);
        this.script = script;
        Preconditions.ensure(tipoAtividade == TipoAtividade.REALIZACAO, "Atividade é de realização.");
    }

    protected AtividadeAutomatica() {

    }

    @Override
    public String toString() {
        return super.toString() + ", " + script;
    }
}
