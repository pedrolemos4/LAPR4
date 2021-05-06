package eapli.base.gestaoservicoshelpdesk.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Atributo {
    private String nomeVariavel;

    private String label;

    protected Atributo() {
        this.nomeVariavel=null;
        this.label = null;
    }

    private enum TipoDados{
        INTEGER ,STRING,BOOLEAN,DATA
    }

    public Atributo(String nomeVariavel, String label){
        this.nomeVariavel=nomeVariavel;
        this.label=label;
    }
}
