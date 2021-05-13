/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.colaborador.domain.LocalResidencia;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class LocalResidenciaTest {
    
    public LocalResidenciaTest() {
    }

    /**
     * Test of toString method, of class LocalResidencia.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LocalResidencia instance = new LocalResidencia("end");
        String endereco = "end";
        String expResult = "LocalResidencia{" +
                "endereco='" + endereco + '\'' +
                '}';;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
