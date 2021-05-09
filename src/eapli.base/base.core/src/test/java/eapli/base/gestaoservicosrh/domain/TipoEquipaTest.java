package eapli.base.gestaoservicosrh.domain;

import eapli.base.gestaoservicoshelpdesk.domain.Cor;
import junit.framework.TestCase;

public class TipoEquipaTest extends TestCase {

    public void testIdentity() {
        CodigoUnico cod = new CodigoUnico("cod");
        TipoEquipa tipo = new TipoEquipa(cod, new Designacao("desig"), new Cor(1,1,1));
        CodigoUnico exp = tipo.identity();
        assertEquals(cod, exp);
    }

    public void testTestToString() {
        TipoEquipa tipo = new TipoEquipa(new CodigoUnico("cod"), new Designacao("desig"), new Cor(1,1,1));
        assertEquals(tipo.toString(), "TipoEquipa{, codigoUnico=CodigoUnico{codigo='cod'}, designacao=desig, cor=Cor: red=1, green=1, blue=1}");
    }
}