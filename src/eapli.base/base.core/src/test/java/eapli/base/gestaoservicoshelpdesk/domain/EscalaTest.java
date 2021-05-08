package eapli.base.gestaoservicoshelpdesk.domain;

import junit.framework.TestCase;

public class EscalaTest extends TestCase {

    public void testTestEquals() {
        Escala e1 = new Escala(1);
        Escala e2 = new Escala(1);
        assertEquals(e1,e2);
    }

    public void testTestToString() {
        Escala e1 = new Escala(1);
        assertEquals(e1.toString(), "Valor:1");
    }
}