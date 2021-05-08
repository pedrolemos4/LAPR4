package eapli.base.gestaoservicoshelpdesk.domain;

import junit.framework.TestCase;

public class EtiquetaTest extends TestCase {

    public void testTestEquals() {
        Etiqueta e1 = new Etiqueta("valor");
        Etiqueta e2 = new Etiqueta("valor");
        assertEquals(e1,e2);
    }

    public void testTestToString() {
        Etiqueta e1 = new Etiqueta("valor");
        assertEquals(e1.toString(), "valor");
    }

    public void testCompareTo() {
        Etiqueta e1 = new Etiqueta("valor");
        Etiqueta e2 = new Etiqueta("valor");
        int exp = 0;
        assertEquals(e1.compareTo(e2),0);
    }
}