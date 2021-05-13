package eapli.base.gestaoservicosrh.domain;

import eapli.base.equipa.domain.CodigoUnico;
import junit.framework.TestCase;

public class CodigoUnicoTest extends TestCase {

    public void testTestToString() {
        CodigoUnico c1 = new CodigoUnico("cod1");
        assertEquals(c1.toString(), "CodigoUnico{codigo='cod1'}");
    }
}