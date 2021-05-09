/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoservicoshelpdesk.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class TituloTest {
    
    public TituloTest() {
    }

    /**
     * Test of valueOf method, of class Titulo.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        Titulo expResult = null;
        Titulo result = Titulo.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Titulo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Titulo instance = new Titulo();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Titulo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Titulo instance = new Titulo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Titulo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Titulo instance = new Titulo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Titulo.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Titulo o = null;
        Titulo instance = new Titulo();
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
