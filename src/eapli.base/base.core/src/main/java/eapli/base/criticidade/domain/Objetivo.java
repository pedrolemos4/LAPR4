package eapli.base.criticidade.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Objetivo implements ValueObject {
    private static final long serialVersionUID = 1L;

    @Column(name="TempoMaximoAprov")
    private final double tempoMaxAprov;

    @Column(name="TempoMedioAprov")
    private final double tempoMedioAprov;

    @Column(name="TempoMaximoRes")
    private final double tempoMaxRes;

    @Column(name="TempoMedioRes")
    private final double tempoMedioRes;

    public Objetivo(final double tempoMaxAprov, final double tempoMedioAprov, final double tempoMaxRes,final double tempoMedioRes) {
        Preconditions.ensure(tempoMaxAprov >= 0, "tempoMaxAprov can't be negative");
        Preconditions.ensure(tempoMedioAprov >= 0, "tempoMedioAprov can't be negative");
        Preconditions.ensure(tempoMaxRes >= 0, "tempoMaxRes can't be negative");
        Preconditions.ensure(tempoMedioRes >= 0, "tempoMedioRes can't be negative");
        this.tempoMaxAprov = tempoMaxAprov;
        this.tempoMedioAprov = tempoMedioAprov;
        this.tempoMaxRes = tempoMaxRes;
        this.tempoMedioRes = tempoMedioRes;
    }

    protected Objetivo(){
        this.tempoMedioAprov = -1;
        this.tempoMaxAprov = -1;
        this.tempoMedioRes = -1;
        this.tempoMaxRes = -1;
    }

    public static Objetivo valueOf (final double tempoMaxAprov, final double tempoMedioAprov, final double tempoMaxRes,final double tempoMedioRes) {
        return new Objetivo(tempoMaxAprov, tempoMedioAprov,tempoMaxRes,tempoMedioRes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objetivo objetivo = (Objetivo) o;
        return tempoMaxRes == objetivo.tempoMaxRes && tempoMedioRes == objetivo.tempoMedioRes && tempoMedioAprov == objetivo.tempoMedioAprov && tempoMaxAprov == objetivo.tempoMaxAprov;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempoMaxAprov,tempoMedioAprov,tempoMaxRes, tempoMedioRes);
    }

    @Override
    public String toString() {
        return "Objetivo\n" + "tempoMaxApro: " + tempoMaxAprov +
                "\ntempoMedioAprov:" + tempoMedioAprov +
                "\ntempoMaxRes:" + tempoMaxRes +
                "\ntempoMedioRes:" + tempoMedioRes ;
    }
}
