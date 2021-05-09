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
public class DescricaoBreveTest {

    private DescricaoBreve instance = new DescricaoBreve("nome");

    public DescricaoBreveTest() {
    }

    /**
     * Test of valueOf method, of class DescricaoBreve.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf=true");
        String name = "nome";
        DescricaoBreve expResult = instance;
        DescricaoBreve result = DescricaoBreve.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class DescricaoBreve.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals=false");
        Object o = new Object();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class DescricaoBreve.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals=true");
        Object o1 = (DescricaoBreve) new DescricaoBreve("nome");
        boolean expResult = true;
        boolean result = instance.equals(o1);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DescricaoBreve.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DescricaoBreve instance = new DescricaoBreve();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
