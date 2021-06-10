/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividade;

import eapli.base.atividade.domain.Decisao;
import eapli.base.atividade.domain.EstadoFluxo;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 *
 * @author pedro
 */
public class DecisaoTest extends TestCase {
    
    public DecisaoTest() {
    }

    @Test
    public void testValues() {
        System.out.println("values");
        Decisao[] expResult = {Decisao.APROVADO,Decisao.REJEITADO};
        Decisao[] result = Decisao.values();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testValueOfAprovado() {
        System.out.println("valueOf");
        String string = "APROVADO";
        Decisao expResult = Decisao.APROVADO;
        Decisao result = Decisao.valueOf(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueOfRejeitado() {
        System.out.println("valueOf");
        String string = "REJEITADO";
        Decisao expResult = Decisao.REJEITADO;
        Decisao result = Decisao.valueOf(string);
        assertEquals(expResult, result);
    }
    
}
