package eapli.base.atividades.domain;

import eapli.framework.domain.model.ValueObject;

public class Decisao implements ValueObject {

    private String des;

    public Decisao(String des) {
        this.des = des;
    }
}
