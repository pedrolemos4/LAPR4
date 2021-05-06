package eapli.base.gestaoservicoshelpdesk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;

import eapli.framework.strings.StringMixin;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAttribute;

@Embeddable
public class Titulo implements ValueObject, Comparable<Titulo>, StringMixin {
    private static final long serialVersionUID = 1L;
    private final String titulo;

    public Titulo(final String name) {
        Preconditions.ensure(StringPredicates.isPhrase(name), "Name should neither be null nor empty nor have starting blank spaces");
        Preconditions.ensure(name.length() <= 50, "Um título tem no máximo 50 caracteres.");
        this.titulo = name;
    }

    protected Titulo() {
        this.titulo = null;
    }

    public static Titulo valueOf(final String name) {
        return new Titulo(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Titulo)) {
            return false;
        } else {
            Titulo other = (Titulo) o;
            return this.titulo.equals(other.titulo);
        }
    }

    public String toString() {
        return this.titulo;
    }

    public int hashCode() {
        return (new HashCoder()).with(this.titulo).code();
    }

    public int compareTo(final Titulo o) {
        return this.titulo.compareTo(o.titulo);
    }
}

