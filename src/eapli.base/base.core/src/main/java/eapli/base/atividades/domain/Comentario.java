package eapli.base.atividades.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Comentario implements ValueObject {

    @Column(name="comentário")
    private String coment;

    public Comentario(String coment) {
        this.coment = coment;
    }

    protected Comentario() {
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "coment='" + coment + '\'' +
                '}';
    }
}
