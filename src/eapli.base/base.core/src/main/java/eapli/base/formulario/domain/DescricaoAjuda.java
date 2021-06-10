package eapli.base.formulario.domain;

import eapli.framework.strings.util.StringPredicates;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;

public class DescricaoAjuda {

    private static final long serialVersionUID = 1L;

    @Column(name = "Label")
    private String desc;

    public DescricaoAjuda(final String name) {
        Preconditions.ensure(StringPredicates.isPhrase(name), "A descrição ajuda tem de ser especificada");
        this.desc = name;
    }

    protected DescricaoAjuda() {

    }

    public static DescricaoAjuda valueOf(final String name) {
        return new DescricaoAjuda(name);
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof DescricaoAjuda)) {
            return false;
        } else {
            DescricaoAjuda other = (DescricaoAjuda) o;
            return this.desc.equals(other.desc);
        }
    }

    public String toString() {
        return this.desc;
    }

    public int hashCode() {
        return (new HashCoder()).with(this.desc).code();
    }

    public int compareTo(final DescricaoAjuda o) {
        return this.desc.compareTo(o.desc);
    }

}
