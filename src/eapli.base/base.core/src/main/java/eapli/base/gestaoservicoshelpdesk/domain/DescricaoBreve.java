package eapli.base.gestaoservicoshelpdesk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

@Embeddable
public class DescricaoBreve implements ValueObject, Serializable, StringMixin {
    private static final long serialVersionUID = 1L;

    @Column(name="DescricaoBreve")
    private final String value;

    public DescricaoBreve(final String name) {
        Preconditions.nonEmpty(name, "Description should neither be null nor empty");
        Preconditions.ensure(name.length()<=40,"O tamanho máximo da descrição breve são 40 caracteres.");
        this.value = name;
    }

    protected DescricaoBreve() {
        this.value = null;
    }

    public int length() {
        return this.value.length();
    }

    public static DescricaoBreve valueOf(final String name) {
        return new DescricaoBreve(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof DescricaoBreve)) {
            return false;
        } else {
            DescricaoBreve other = (DescricaoBreve) o;
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

