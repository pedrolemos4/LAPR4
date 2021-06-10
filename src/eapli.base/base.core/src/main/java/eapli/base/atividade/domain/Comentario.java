package eapli.base.atividade.domain;

import eapli.base.formulario.domain.Label;
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

    public static Comentario valueOf(final String name) {
        return new Comentario(name);
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "coment='" + coment + '\'' +
                '}';
    }
}
