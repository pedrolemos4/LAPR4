package eapli.base.pedido.domain;

import junit.framework.TestCase;

public class IdentificadorTest extends TestCase {

    public void testTestToString() {
        System.out.println("testTestToString");
        Identificador identificador = new Identificador();
        assertEquals("2021/0",identificador.toString());
    }
}