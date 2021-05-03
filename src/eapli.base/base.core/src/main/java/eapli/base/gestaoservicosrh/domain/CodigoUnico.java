package eapli.base.gestaoservicosrh.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class CodigoUnico implements ValueObject {

    private static final long serialVersionUID = 1L;

    public static final CodigoUnico UNKNOWN = new CodigoUnico();

    private final String codigo;

    public CodigoUnico(final String codigo){
        Preconditions.ensure(codigo.length()<=15,"O tamanho máximo do código são 15 caracteres.");

        this.codigo = codigo;
    }

    public CodigoUnico() {
        codigo = null;
    }

}
