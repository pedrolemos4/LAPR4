package eapli.base.atividade.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Script implements ValueObject {

    @Column(name= "CAMINHOSCRIPT")
    private String caminhoScript;

    public Script(String script) {
        this.caminhoScript = script;
    }


    protected Script() {

    }

    @Override
    public String toString() {
        return "Script{" +
                "script='" + caminhoScript + '\'' +
                '}';
    }
}
