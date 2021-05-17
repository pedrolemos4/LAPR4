package eapli.base.atividades.domain;

import eapli.framework.domain.model.ValueObject;

public class Prioridade implements ValueObject {

    private String prioridade;

    public Prioridade(String prioridade){
        this.prioridade=prioridade;
    }

}
