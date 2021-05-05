package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Escala implements ValueObject {
    private static final long serialVersionUID = 1L;

    private final int value;

    public Escala(final int value) {
        Preconditions.ensure(value<6, "Escala deve ser menor que 6");
        Preconditions.ensure(value>0, "Escala deve ser maior que 0");
        this.value = value;
    }

    protected Escala(){
        this.value = 0;
    }

    public static Escala valueOf(final int value) {
        return new Escala(value);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Escala)) {
            return false;
        } else {
            Escala other = (Escala)o;
            return Objects.equals(this.value, other.value);
        }
    }

    public String toString() {
        return "Valor:" + this.value;
    }

    public int hashCode() {
        return (new HashCoder()).with(this.value).code();
    }


}