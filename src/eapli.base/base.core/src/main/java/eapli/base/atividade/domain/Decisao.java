package eapli.base.atividade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Decisao implements ValueObject {


    private String des;

    public Decisao(String des) {
        this.des = des;
    }

    protected Decisao() {
    }

    @Override
    public String toString() {
        return "Decisao{" +
                "des='" + des + '\'' +
                '}';
    }
}
