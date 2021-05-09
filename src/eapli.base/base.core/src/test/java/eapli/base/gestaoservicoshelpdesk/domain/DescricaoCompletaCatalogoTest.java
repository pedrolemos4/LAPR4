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

    private DescricaoCompletaCatalogo instance = new DescricaoCompletaCatalogo("desc");

    public DescricaoCompletaCatalogoTest() {
    }

    /**
     * Test of valueOf method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        DescricaoCompletaCatalogo result = DescricaoCompletaCatalogo.valueOf("desc");
        assertEquals(instance, result);
    }

    /**
     * Test of equals method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals=true");
        Object o = new DescricaoCompletaCatalogo("desc");
        DescricaoCompletaCatalogo instance1 = (DescricaoCompletaCatalogo) o;
        boolean expResult = true;
        boolean result = instance.equals(instance1);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals=false");
        Object o = new Object();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class DescricaoCompletaCatalogo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "desc";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
