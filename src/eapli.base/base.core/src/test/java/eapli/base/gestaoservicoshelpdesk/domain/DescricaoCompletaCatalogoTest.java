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
public class DescricaoCompletaCatalogoTest {
    
    public DescricaoCompletaCatalogoTest() {
    }

    /**
     * Test of valueOf method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "";
        DescricaoCompletaCatalogo expResult = null;
        DescricaoCompletaCatalogo result = DescricaoCompletaCatalogo.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        DescricaoCompletaCatalogo instance = new DescricaoCompletaCatalogo();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DescricaoCompletaCatalogo instance = new DescricaoCompletaCatalogo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DescricaoCompletaCatalogo instance = new DescricaoCompletaCatalogo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
