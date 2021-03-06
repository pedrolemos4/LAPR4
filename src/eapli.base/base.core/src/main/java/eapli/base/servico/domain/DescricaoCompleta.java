package eapli.base.servico.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DescricaoCompleta implements ValueObject, Serializable, StringMixin {
    private static final long serialVersionUID = 1L;

    @Column(name="DescricaoCompleta")
    private final String value;

    public DescricaoCompleta(final String name) {
        Preconditions.nonEmpty(name, "Description should neither be null nor empty");
        Preconditions.ensure(name.length()<=500,"O tamanho máximo da descrição completa são 500 caracteres.");
        this.value = name;
    }

    protected DescricaoCompleta() {
        this.value = null;
    }

    public int length() {
        return this.value.length();
    }

    public static DescricaoCompleta valueOf(final String name) {
        return new DescricaoCompleta(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof DescricaoCompleta)) {
            return false;
        } else {
            DescricaoCompleta other = (DescricaoCompleta) o;
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

