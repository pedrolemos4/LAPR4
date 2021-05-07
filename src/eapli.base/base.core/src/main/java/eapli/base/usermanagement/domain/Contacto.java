package eapli.base.usermanagement.domain;

import javax.persistence.Embeddable;
import java.util.Locale;

@Embeddable
public class Contacto {

    private String countryCode;

    private String number;

    public Contacto() {}

    /**
     * Construtor de contacto
     * @param countryCode selecionado da classe CountryCode
     * @param number numero de telefone
     */
    public Contacto(String countryCode,String number){
        this.countryCode=countryCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return countryCode + " " + number;
    }
}
