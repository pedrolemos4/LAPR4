package eapli.base.atividades.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Script implements ValueObject {

    @Column(name= "SCRIPT")
    private String script;

    public Script(String script) {
        this.script = script;
    }


    protected Script() {

    }
}
