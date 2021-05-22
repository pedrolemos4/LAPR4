package eapli.base.pedido.domain;

import javax.persistence.*;
import java.util.Calendar;

@Embeddable
public class Identificador implements Comparable<Identificador> {

    private int ano;

    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    protected Identificador(){
        this.ano = Calendar.getInstance().get(Calendar.YEAR);
    }

    @Id
    public Identificador getIdentificador(){
        return new Identificador();
    }

    @Override
    public String toString() {
        return ano + "/" + id ;
    }

    @Override
    public int compareTo(Identificador o) {
        if (this == o.getIdentificador())
        return 0;
        return -1;
    }
}
