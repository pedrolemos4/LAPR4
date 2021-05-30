/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaborador;

import eapli.base.colaborador.domain.FullName;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class FullNameTest {

    private FullName instance = new FullName("fullName");

    public FullNameTest() {
    }

    /**
     * Test of toString method, of class FullName.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "fullName";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
