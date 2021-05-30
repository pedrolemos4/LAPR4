package eapli.base.criticidade;

import eapli.base.criticidade.domain.Escala;
import junit.framework.TestCase;
import org.junit.Test;


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

    public void testValueOf() {
        Escala e1 = new Escala(1);
        Escala e2 = Escala.valueOf(1);
        assertEquals(e1,e2);
    }

    public void testHashCode() {
        Escala e1 = new Escala(1);
        assertEquals(e1.hashCode(),1148);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEscalaMenorCinco() {
        new Escala(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEscalaPositiva() {
        new Escala(-1);
    }

    @Test
    public void ensureEscala() {
        new Escala(4);
        assertTrue(true);
    }
}