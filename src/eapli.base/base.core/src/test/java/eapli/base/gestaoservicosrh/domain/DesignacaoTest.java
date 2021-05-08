package eapli.base.gestaoservicosrh.domain;

import junit.framework.TestCase;

public class DesignacaoTest extends TestCase {

    public void testLength() {
        Designacao d1 = new Designacao("desig");
        int exp = 5;
        assertEquals(exp, d1.length());
    }

    public void testTestEquals() {
        Designacao d1 = new Designacao("desig");
        Designacao d2 = new Designacao("desig");
        assertEquals(d1,d2);
    }

    public void testTestToString() {
        Designacao d1 = new Designacao("desig");
        assertEquals(d1.toString(), "desig");
    }
}