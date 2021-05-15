package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.criticidade.domain.Objetivo;
import junit.framework.TestCase;

public class ObjetivoTest extends TestCase {

    public void testTestEquals() {
        Objetivo o1 = new Objetivo(10,10,10,8);
        Objetivo o2 = new Objetivo(10,10,10,8);
        assertEquals(o1,o2);
    }

    public void testTestToString() {
        Objetivo o1 = new Objetivo(10,10,10,8);
        assertEquals("Objetivo\n" +
                "tempoMaxApro: 10.0\n" +
                "tempoMedioAprov:10.0\n" +
                "tempoMaxRes:10.0\n" +
                "tempoMedioRes:8.0",o1.toString());
    }

    public void testValueOf() {
        Objetivo o1 = new Objetivo(10,10,10,8);
        Objetivo o2 = Objetivo.valueOf(10,10,10,8);
        assertEquals(o1,o2);
    }

    public void testHashCode() {
        Objetivo o1 = new Objetivo(10,10,10,8);
        assertEquals(-385214591,o1.hashCode());
    }
}