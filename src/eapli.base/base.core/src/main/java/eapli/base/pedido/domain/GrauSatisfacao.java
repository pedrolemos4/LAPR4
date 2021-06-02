package eapli.base.pedido.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GrauSatisfacao implements ValueObject {

    @Column(name="grauSatisfacao")
    private int grau;

    public GrauSatisfacao(int grau){
        Preconditions.ensure(grau < 6 && grau > 0, "O grau só pode ir de 1 a 5");
        this.grau = grau;
    }

    protected GrauSatisfacao() {

    }

    @Override
    public String toString() {
        return "GrauSatisfacao{" +
                "grau=" + grau +
                '}';
    }
}
