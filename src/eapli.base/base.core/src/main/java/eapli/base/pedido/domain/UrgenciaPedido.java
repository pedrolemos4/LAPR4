package eapli.base.pedido.domain;

import javax.persistence.Embeddable;

@Embeddable
public class UrgenciaPedido {

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
