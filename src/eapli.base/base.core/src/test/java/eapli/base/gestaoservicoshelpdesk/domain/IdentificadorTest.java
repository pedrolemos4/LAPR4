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
public class IdentificadorTest {
    
    public IdentificadorTest() {
    }

    /**
     * Test of compareTo method, of class Identificador.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Identificador o = null;
        Identificador instance = new Identificador();
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
