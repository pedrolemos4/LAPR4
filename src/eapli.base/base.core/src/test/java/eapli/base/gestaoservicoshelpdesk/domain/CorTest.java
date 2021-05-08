package eapli.base.gestaoservicoshelpdesk.domain;

import junit.framework.TestCase;

public class CorTest extends TestCase {

    public void testTestEquals() {
        Cor cor = new Cor(12,12,12);
        Cor cor2 = new Cor(12,12,12);
        assertEquals(cor,cor2);
    }

    public void testTestToString() {
        Cor cor = new Cor(12,12,12);
        assertEquals(cor.toString(), "Cor: red=12, green=12, blue=12");
    }
}