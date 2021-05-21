package eapli.base.pedido.domain;

import junit.framework.TestCase;
import eapli.base.pedido.domain.Identificador;

public class IdentificadorTest extends TestCase {

    public void testGetIdentificador() {
        System.out.println("testGetIdentificador");
        Identificador identificador = new Identificador().getIdentificador();
        assertEquals("2021/0",identificador.toString());
    }

    public void testTestToString() {
        System.out.println("testTestToString");
        Identificador identificador = new Identificador().getIdentificador();
        assertEquals("2021/0",identificador.toString());
    }
}