package eapli.base.pedido.domain;

import junit.framework.TestCase;
import org.junit.Test;

public class GrauSatisfacaoTest extends TestCase {

    public void testToString() {
        GrauSatisfacao g = new GrauSatisfacao(3);
        assertEquals("GrauSatisfacao{grau=3}", g.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValorGrau() {
        try {
            new GrauSatisfacao(6);
        } catch (IllegalArgumentException e) {

        }
    }
}