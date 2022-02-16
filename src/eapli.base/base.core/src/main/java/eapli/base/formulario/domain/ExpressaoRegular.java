package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.util.HashCoder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExpressaoRegular implements ValueObject {

    private static final long serialVersionUID = 1L;

    @Column(name = "ExpressaoRegular")
    private String expressaoRegular;

    public ExpressaoRegular (final String name) {
        this.expressaoRegular = name;
    }

    protected ExpressaoRegular() {

    }

    public static ExpressaoRegular valueOf(final String name) {
        return new ExpressaoRegular(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof ExpressaoRegular)) {
            return false;
        } else {
            ExpressaoRegular other = (ExpressaoRegular) o;
            return this.expressaoRegular.equals(other.expressaoRegular);
        }
    }

    public String toString() {
        return this.expressaoRegular;
    }

    public int hashCode() {
        return (new HashCoder()).with(this.expressaoRegular).code();
    }

    public int compareTo(final ExpressaoRegular o) {
        return this.expressaoRegular.compareTo(o.expressaoRegular);
    }
}
