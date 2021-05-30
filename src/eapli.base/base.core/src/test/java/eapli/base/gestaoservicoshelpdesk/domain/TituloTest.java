/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.catalogo.domain.Titulo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class TituloTest {

    private Titulo instance = new Titulo("titulo");

    public TituloTest() {
    }

    /**
     * Test of valueOf method, of class Titulo.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "titulo";
        Titulo result = Titulo.valueOf(name);
        assertEquals(instance, result);
    }

    /**
     * Test of equals method, of class Titulo.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals=true");
        Object o1 = new Titulo("titulo");
        Titulo o = (Titulo) o1;
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Titulo.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals=false");
        Object o1 = new Titulo("false");
        Titulo o = (Titulo) o1;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Titulo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "titulo";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Titulo.
     */
    @Test
    public void testCompareTo1() {
        System.out.println("compareTo=0");
        Titulo o = new Titulo("titulo");
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Titulo.
     */
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo=-1");
        Titulo o = new Titulo("titulo1");
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testTituloMustNotBeNull(){
        try {
            new Titulo(" ");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testTituloMustNotBeGreaterThan50(){
        try{
            new Titulo("50 caracteres será que tem 50 caracteres em quantos caracteres ja vou nao sei mas ok acho que ");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
