package eapli.base.pedido.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.Calendar;

@Embeddable
public class Identificador implements ValueObject,Comparable<Identificador> {

    private int ano;

    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    protected Identificador(){
        this.ano = Calendar.getInstance().get(Calendar.YEAR);
    }


    @Override
    public String toString() {
        return ano + "/" + id ;
    }

    @Override
    public int compareTo(Identificador o) {
        return -1;
    }
}
