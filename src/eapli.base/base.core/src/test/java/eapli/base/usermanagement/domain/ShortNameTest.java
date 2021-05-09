/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.usermanagement.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ShortNameTest {
    
    public ShortNameTest() {
    }

    /**
     * Test of toString method, of class ShortName.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ShortName instance = new ShortName();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
