package eapli.base.usermanagement.domain;

import javax.persistence.Embeddable;
import java.util.Locale;

@Embeddable
public class Contacto {

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
