package eapli.base.pedido.domain;

import junit.framework.TestCase;

public class UrgenciaPedidoTest extends TestCase {

    public void testTestToString() {
        UrgenciaPedido urgenciaPedido = new UrgenciaPedido("3");
        assertEquals("UrgenciaPedido: 3",urgenciaPedido.toString());
    }
}