package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class Etiqueta implements ValueObject, Comparable<Etiqueta> {
    private static final long serialVersionUID = 1L;

    private final String value;

    public Etiqueta(final String value) {
        Preconditions.nonEmpty(value, "Etiqueta should neither be null nor empty");
        this.value = value;
    }

    protected Etiqueta(){
        this.value = null;
    }

    public static Etiqueta valueOf(final String value) {
        return new Etiqueta(value);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Etiqueta)) {
            return false;
        } else {
            Etiqueta other = (Etiqueta)o;
            return this.value.equals(other.value);
        }
    }

    public int hashCode() {
        return (new HashCoder()).with(this.value).code();
    }

    @Override
    public int compareTo(Etiqueta o) {
        return value.compareTo(o.value);
    }

    public String toString() {
        return this.value;
    }
}
