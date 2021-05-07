package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Data implements ValueObject {

    @Column(name="ANO")
    private final int ano;

    @Column(name="ANO")
    private final int mes;

    @Column(name="ANO")
    private final int dia;

    public Data (final int ano, final int mes, final int dia){
        this.ano=ano;
        this.mes=mes;
        this.dia=dia;
    }

    public Data() {
        this.mes=0;
        this.ano=0;
        this.dia=0;
    }

    @Override
    public String toString() {
        return "Data{" +
                "ano=" + ano +
                ", mes=" + mes +
                ", dia=" + dia +
                '}';
    }
}
