package eapli.base.gestaoservicosrh.domain;

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
public class Acronimo implements ValueObject, Serializable, StringMixin {
    private static final long serialVersionUID = 1L;
    @Column(
            //name = "acronimo"
    )
    @XmlAttribute
    @JsonProperty("acronimo")
    private final String value;

    public Acronimo(final String name) {
        Preconditions.nonEmpty(name, "Description should neither be null nor empty");
        Preconditions.ensure(name.length() <= 10,"O acrónimo não pode ter mais de 10 caratéres.");
        Preconditions.ensure(name.contains("0") || name.contains("1") || name.contains("2") || name.contains("3")
                || name.contains("4") || name.contains("5") || name.contains("6") || name.contains("7")
                || name.contains("8") || name.contains("9"),"O acrónimo deve ser alfanumérico.");
        this.value = name;
    }

    protected Acronimo() {
        this.value = null;
    }

    public int length() {
        return this.value.length();
    }

    public static Acronimo valueOf(final String name) {
        return new Acronimo(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Acronimo)) {
            return false;
        } else {
            Acronimo other = (Acronimo) o;
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
