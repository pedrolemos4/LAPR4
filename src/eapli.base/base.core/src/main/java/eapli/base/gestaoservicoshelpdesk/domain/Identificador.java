package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Identificador implements ValueObject, Comparable<Identificador> {

    private String identificador;

    public Identificador(final String identificador){
        this.identificador=identificador;
    }

    public Identificador(){
        this.identificador=null;
    }

    @Override
    public int compareTo(Identificador o) {
        return 0;
    }
}
