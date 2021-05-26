package eapli.base.equipa.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CodigoUnico implements ValueObject, Comparable<CodigoUnico> {

    private static final long serialVersionUID = 1L;

    public static final CodigoUnico UNKNOWN = new CodigoUnico();

    @Column(name="codigoUnico")
    private final String codigo;

    public CodigoUnico(final String codigo){
        Preconditions.ensure(codigo.length()<=15,"O tamanho máximo do código são 15 caracteres.");

        this.codigo = codigo;
    }

    public CodigoUnico() {
        codigo = null;
    }

    @Override
    public int compareTo(CodigoUnico o) {
        return 0;
    }

    @Override
    public String toString() {
        return codigo;
    }

    public static CodigoUnico valueOf(final String codigo) {
        return new CodigoUnico(codigo);
    }
}
