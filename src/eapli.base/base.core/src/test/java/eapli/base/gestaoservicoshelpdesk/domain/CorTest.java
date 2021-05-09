package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.Designacao;
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

    public void testValueOf() {
        Cor cor1 = new Cor(12,12,12);
        Cor cor2 = Cor.valueOf(12,12,12);
        assertEquals(cor1,cor2);
    }

    public void testHashCode() {
        Cor cor1 = new Cor(12,12,12);
        assertEquals(cor1.hashCode(),41707);
    }
}