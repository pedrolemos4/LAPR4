package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Locale;

@Embeddable
public class Contacto implements ValueObject {

    @Column(name="NUMBER")
    private int number;

    @Column(name="PREFIX")
    private int prefix;

    protected Contacto() {}

    /**
     * Construtor de contacto
     * @param number numero de telefone
     */
    public Contacto(final int number){
        this.number = number;
    }

    public Contacto(final int prefix, final int number){
        this.number = number;
        this.prefix=prefix;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "number=" + number +
                ", prefix=" + prefix +
                '}';
    }
}
