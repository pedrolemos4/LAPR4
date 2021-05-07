package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Locale;

@Embeddable
public class Contacto implements ValueObject {

    private int number;

    public Contacto() {}

    /**
     * Construtor de contacto
     * @param number numero de telefone
     */
    public Contacto(final int number){
        this.number = number;
    }

    @Override
    public String toString() {
        return " " + number;
    }
}
