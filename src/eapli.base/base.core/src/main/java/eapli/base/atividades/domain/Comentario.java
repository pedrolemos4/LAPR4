package eapli.base.atividades.domain;

import eapli.framework.domain.model.ValueObject;

public class Comentario implements ValueObject {

    private String coment;

    public Comentario(String coment) {
        this.coment = coment;
    }
}
