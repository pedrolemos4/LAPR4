package eapli.base.pedido.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class UrgenciaPedido implements ValueObject {

    private String urgencia;

    public UrgenciaPedido() {

    }

    public UrgenciaPedido(String urgencia) {
        this.urgencia = urgencia;
    }

    @Override
    public String toString() {
        return "UrgenciaPedido: " + urgencia;
    }
}
