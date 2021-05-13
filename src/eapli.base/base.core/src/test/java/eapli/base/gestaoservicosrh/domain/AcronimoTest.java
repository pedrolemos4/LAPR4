package eapli.base.gestaoservicosrh.domain;

import eapli.base.equipa.domain.Acronimo;
import junit.framework.TestCase;

public class AcronimoTest extends TestCase {

    public void testLength() {
        Acronimo a1 = new Acronimo("teste1");
        int exp = 6;
        assertEquals(a1.length(), exp);
    }

    public void testTestEquals() {
        Acronimo a1 = new Acronimo("teste1");
        Acronimo a2 = new Acronimo("teste1");
        assertEquals(a1,a2);
    }

    public void testTestToString() {
        Acronimo a1 = new Acronimo("teste1");
        assertEquals(a1.toString(), "teste1");
    }

    public void testValueOf() {
        Acronimo a1 = new Acronimo("teste1");
        Acronimo a2 = Acronimo.valueOf("teste1");
        assertEquals(a1,a2);
    }

    public void testHashCode() {
        Acronimo a1 = new Acronimo("teste1");
        int exp = a1.hashCode();
        assertEquals(a1.hashCode(),exp);
    }
}