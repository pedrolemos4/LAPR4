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

    private Identificador instance = new Identificador("id1");

    public IdentificadorTest() {
    }

    /**
     * Test of compareTo method, of class Identificador.
     */
    @Test
    public void testCompareTo1() {
        System.out.println("compareTo equals");
        Identificador o = new Identificador("id1");
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Identificador.
     */
    @Test
    public void testCompareTo2() {
        System.out.println("compareTo not equals");
        Identificador o = new Identificador("id2");
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
