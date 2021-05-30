/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaborador;

import eapli.base.colaborador.domain.ShortName;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ShortNameTest {

    private ShortName instance = new ShortName("shortName");

    public ShortNameTest() {
    }

    /**
     * Test of toString method, of class ShortName.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "shortName";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
