package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DescricaoCompletaCatalogo implements ValueObject, Serializable, StringMixin {
    private static final long serialVersionUID = 1L;

    @Column(name="DESCRICAOCOMPLETA")
    private final String value;

    public DescricaoCompletaCatalogo(final String name) {
        Preconditions.nonEmpty(name, "Description should neither be null nor empty");
        Preconditions.ensure(name.length() <= 100, "O tamanho máximo da descrição completa são 100 caracteres.");
        this.value = name;
    }

    protected DescricaoCompletaCatalogo() {
        this.value = null;
    }

    public static DescricaoCompletaCatalogo valueOf(final String name) {
        return new DescricaoCompletaCatalogo(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof DescricaoCompletaCatalogo)) {
            return false;
        } else {
            DescricaoCompletaCatalogo other = (DescricaoCompletaCatalogo) o;
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

