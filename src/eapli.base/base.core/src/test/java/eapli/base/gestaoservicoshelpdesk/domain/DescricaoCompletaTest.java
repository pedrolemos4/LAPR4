package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.Designacao;
import junit.framework.TestCase;

public class DescricaoCompletaTest extends TestCase {

    public void testLength() {
        DescricaoCompleta d1 = new DescricaoCompleta("desc_completa");
        int exp = 13;
        assertEquals(exp, d1.length());
    }

    public void testValueOf() {
        DescricaoCompleta d1 = new DescricaoCompleta("desc_completa");
        DescricaoCompleta d2 = DescricaoCompleta.valueOf("desc_completa");
        assertEquals(d1,d2);
    }

    public void testTestEquals() {
        DescricaoCompleta d1 = new DescricaoCompleta("desc_completa");
        DescricaoCompleta d2 = new DescricaoCompleta("desc_completa");
        assertEquals(d1,d2);
    }

    public void testTestToString() {
        DescricaoCompleta d1 = new DescricaoCompleta("desc_completa");
        assertEquals(d1.toString(), "desc_completa");
    }

    public void testTestHashCode() {
        DescricaoCompleta d1 = new DescricaoCompleta("desc_completa");
        int exp = d1.hashCode();
        assertEquals(d1.hashCode(),exp);
    }
}