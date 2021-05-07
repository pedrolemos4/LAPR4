package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Objetivo implements ValueObject {
    private static final long serialVersionUID = 1L;

    @Column(name="TempoMaximo")
    private final int tempoMax;

    @Column(name="TempoMedio")
    private final int tempoMedio;

    public Objetivo(final int tempoMax, final int tempoMedio) {
        Preconditions.ensure(tempoMax >= 0, "TempoMax can't be negative");
        Preconditions.ensure(tempoMedio >= 0, "TempoMedio can't be negative");
        this.tempoMax = tempoMax;
        this.tempoMedio = tempoMedio;
    }

    protected Objetivo(){
        this.tempoMax = -1;
        this.tempoMedio = -1;
    }

    public static Objetivo valueOf (final int tempoMaximo, final int tempoMedio) {
        return new Objetivo(tempoMaximo, tempoMedio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objetivo objetivo = (Objetivo) o;
        return tempoMax == objetivo.tempoMax && tempoMedio == objetivo.tempoMedio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempoMax, tempoMedio);
    }

    @Override
    public String toString() {
        return "Objetivo: " + "tempoMax=" + tempoMax + ", tempoMedio=" + tempoMedio;
    }

}
