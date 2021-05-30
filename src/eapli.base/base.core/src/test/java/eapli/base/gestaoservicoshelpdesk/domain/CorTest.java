package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.criticidade.domain.Cor;
import junit.framework.TestCase;
import org.junit.Test;

public class CorTest extends TestCase {

    public void testTestEquals() {
        Cor cor = new Cor(12,12,12);
        Cor cor2 = new Cor(12,12,12);
        assertEquals(cor,cor2);
    }

    public void testTestToString() {
        Cor cor = new Cor(12,12,12);
        assertEquals(cor.toString(), "Cor: red=12, green=12, blue=12");
    }

    public void testValueOf() {
        Cor cor1 = new Cor(12,12,12);
        Cor cor2 = Cor.valueOf(12,12,12);
        assertEquals(cor1,cor2);
    }

    public void testHashCode() {
        Cor cor1 = new Cor(12,12,12);
        assertEquals(cor1.hashCode(),41707);
    }

    @Test
    public void testRedMustBeGreaterThan0(){
        try {
            Cor cor1 = new Cor(-1, 12, 13);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testRedMustBeLessThan255(){
        try{
            Cor cor1 = new Cor(256,12,13);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testGreenMustBeGreaterThan0(){
        try{
            Cor cor1 = new Cor(13,-1,13);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testGreenMustBeLessThan255(){
        try{
            Cor cor1 = new Cor(13,256,13);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testBlueMustBeGreaterThan0(){
        try{
            Cor cor1 = new Cor(13,12,-3);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testBlueMustBeLessThan255(){
        try{
            Cor cor1 = new Cor(13,12,260);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}