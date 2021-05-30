/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividade;

import eapli.base.atividade.domain.Decisao;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author pedro
 */
public class DecisaoTest extends TestCase {
    
    public DecisaoTest() {
    }

    /**
     * Test of toString method, of class Decisao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Decisao instance = new Decisao("Teste decisao");
        String expResult = "Decisao{" +
                "des='" + "Teste decisao" + '\'' +
                '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
