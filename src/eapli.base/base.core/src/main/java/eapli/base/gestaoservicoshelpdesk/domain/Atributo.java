package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

@Embeddable
public class Atributo implements ValueObject {

    @Column(name="Nome_Variavel")
    private String nomeVariavel;

    @Column(name="Label")
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
