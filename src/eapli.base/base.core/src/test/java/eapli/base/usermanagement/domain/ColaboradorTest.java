/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.usermanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ColaboradorTest {
    
    public ColaboradorTest() {
    }

    /**
     * Test of toString method, of class Colaborador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Colaborador instance = new Colaborador();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sameAs method, of class Colaborador.
     */
    @Test
    public void testSameAs() {
        System.out.println("sameAs");
        Object other = null;
        Colaborador instance = new Colaborador();
        boolean expResult = false;
        boolean result = instance.sameAs(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identity method, of class Colaborador.
     */
    @Test
    public void testIdentity() {
        System.out.println("identity");
        Colaborador instance = new Colaborador();
        MecanographicNumber expResult = null;
        MecanographicNumber result = instance.identity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
