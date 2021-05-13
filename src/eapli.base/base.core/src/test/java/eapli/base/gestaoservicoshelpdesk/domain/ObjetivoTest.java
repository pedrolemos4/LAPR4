package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.criticidade.domain.Objetivo;
import junit.framework.TestCase;

public class ObjetivoTest extends TestCase {

    public void testTestEquals() {
        Objetivo o1 = new Objetivo(10,8);
        Objetivo o2 = new Objetivo(10,8);
        assertEquals(o1,o2);
    }

    public void testTestToString() {
        Objetivo o1 = new Objetivo(10,8);
        assertEquals(o1.toString(),"Objetivo: tempoMax=10, tempoMedio=8");
    }

    public void testValueOf() {
        Objetivo o1 = new Objetivo(10,8);
        Objetivo o2 = Objetivo.valueOf(10,8);
        assertEquals(o1,o2);
    }

    public void testHashCode() {
        Objetivo o1 = new Objetivo(10,8);
        assertEquals(o1.hashCode(),1279);
    }
}