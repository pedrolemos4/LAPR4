package eapli.base.atividade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DuracaoAtividade implements ValueObject {

    @Column(name="duração")
    private long duracao;

    public DuracaoAtividade(long duracao) {
        this.duracao = duracao;
    }

    protected DuracaoAtividade() {
    }

    public static DuracaoAtividade valueOf(final long duracao) {
        return new DuracaoAtividade(duracao);
    }

    @Override
    public String toString() {
        return "Duração: " + duracao;
    }

}
