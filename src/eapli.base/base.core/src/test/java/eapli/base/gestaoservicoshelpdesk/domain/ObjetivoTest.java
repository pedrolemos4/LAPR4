package eapli.base.gestaoservicoshelpdesk.domain;

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
}