package eapli.base.gestaoservicosrh.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

public class Designacao implements ValueObject, Serializable, StringMixin {
    private static final long serialVersionUID = 1L;
    @Column(
            //name = "designacao"
    )
    @XmlAttribute
    @JsonProperty("designacao")
    private final String value;

    public Designacao(final String name) {
        Preconditions.nonEmpty(name, "Description should neither be null nor empty");
        Preconditions.ensure(name.length()<=30,"O tamanho máximo da designacao são 30 caracteres.");
        this.value = name;
    }

    protected Designacao() {
        this.value = null;
    }

    public int length() {
        return this.value.length();
    }

    public static Designacao valueOf(final String name) {
        return new Designacao(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Designacao)) {
            return false;
        } else {
            Designacao other = (Designacao) o;
            return this.value.equals(other.value);
        }
    }

    public String toString() {
        return this.value;
    }

    public int hashCode() {
        return (new HashCoder()).with(this.value).code();
    }
}
