package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;

public class Label implements ValueObject {

    private static final long serialVersionUID = 1L;

    @Column(name="Variavel")
    private final String label;

    public Label(final String name) {
        Preconditions.ensure(StringPredicates.isPhrase(name), "A label tem de ser especificada");
        this.label = name;
    }

    protected Label() {
        this.label = null;
    }

    public static Label valueOf(final String name) {
        return new Label(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Label)) {
            return false;
        } else {
            Label other = (Label) o;
            return this.label.equals(other.label);
        }
    }

    public String toString() {
        return this.label;
    }

    public int hashCode() {
        return (new HashCoder()).with(this.label).code();
    }

    public int compareTo(final Label o) {
        return this.label.compareTo(o.label);
    }

}
