package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Variavel implements ValueObject {

    private static final long serialVersionUID = 1L;

    @Column(name = "Variavel")
    private String variavel;

    public Variavel(final String name) {
        Preconditions.ensure(StringPredicates.isPhrase(name), "A variavel tem de ser especificada");
        this.variavel = name;
    }

    protected Variavel() {
    }

    public static Variavel valueOf(final String name) {
        return new Variavel(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Variavel)) {
            return false;
        } else {
            Variavel other = (Variavel) o;
            return this.variavel.equals(other.variavel);
        }
    }

    public String toString() {
        return this.variavel;
    }

    public int hashCode() {
        return (new HashCoder()).with(this.variavel).code();
    }

    public int compareTo(final Variavel o) {
        return this.variavel.compareTo(o.variavel);
    }

}
