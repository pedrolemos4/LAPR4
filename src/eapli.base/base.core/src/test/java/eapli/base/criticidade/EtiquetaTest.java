package eapli.base.criticidade;

import eapli.base.criticidade.domain.Etiqueta;
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

    public void testValueOf() {
        Etiqueta e1 = new Etiqueta("valor");
        Etiqueta e2 = Etiqueta.valueOf("valor");
        assertEquals(e1,e2);
    }

    public void testHashCode() {
        Etiqueta e1 = new Etiqueta("valor");
        assertEquals(e1.hashCode(),111973695);
    }
}