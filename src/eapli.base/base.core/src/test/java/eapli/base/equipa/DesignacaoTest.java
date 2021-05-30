package eapli.base.equipa;

import eapli.base.equipa.domain.Designacao;
import junit.framework.TestCase;
import org.junit.Test;

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

    public void testValueOf() {
        Designacao a1 = new Designacao("teste1");
        Designacao a2 = Designacao.valueOf("teste1");
        assertEquals(a1,a2);
    }

    public void testHashCode() {
        Designacao a1 = new Designacao("teste1");
        int exp = a1.hashCode();
        assertEquals(a1.hashCode(),exp);
    }

    @Test
    public void testDesignacaoMustNotBeNull(){
        try{
            Designacao d1 = new Designacao(" ");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testDesignacaoMustBeLessThan30(){
        try{
            Designacao d1 = new Designacao("A designação não pode ter mais de 30");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}