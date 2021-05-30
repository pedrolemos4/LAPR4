/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividade;

import eapli.base.atividade.domain.TipoAtividade;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author beatriz
 */
public class TipoAtividadeTest extends TestCase {
    
    public TipoAtividadeTest() {
    }


    /**
     * Test of values method, of class TipoAtividade.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        TipoAtividade[] expResult = {TipoAtividade.REALIZACAO, TipoAtividade.APROVACAO};
        TipoAtividade[] result = TipoAtividade.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOfRealizacao method, of class TipoAtividade.
     */
    @Test
    public void testValueOfRealizacao() {
        System.out.println("valueOf");
        String string = "REALIZACAO";
        TipoAtividade expResult = TipoAtividade.REALIZACAO;
        TipoAtividade result = TipoAtividade.valueOf(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOfAprovacao method, of class TipoAtividade.
     */
    @Test
    public void testValueOfAprovacao() {
        System.out.println("valueOf");
        String string = "APROVACAO";
        TipoAtividade expResult = TipoAtividade.APROVACAO;
        TipoAtividade result = TipoAtividade.valueOf(string);
        assertEquals(expResult, result);
    }
    
}
