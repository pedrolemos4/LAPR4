package eapli.base.equipa;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.servico.domain.Servico;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CodigoUnicoTest extends TestCase {

    public void testTestToString() {
        CodigoUnico c1 = new CodigoUnico("cod1");
        assertEquals(c1.toString(), "cod1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureCodigoUnicoLengthMustNotBeNull() {
        new CodigoUnico("");
    }

    @Test
    public void testEnsureCodigoUnicoLengthMustNotBeGreaterThan15() {
        try {
            new CodigoUnico("cod1112223334443398989");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void testTestToString1() {
        CodigoUnico c1 = new CodigoUnico("cod1");
        assertEquals(c1.toString(), "cod1");
    }
}