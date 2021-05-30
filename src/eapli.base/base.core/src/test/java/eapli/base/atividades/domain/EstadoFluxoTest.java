/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividades.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author beatriz
 */
public class EstadoFluxoTest {
    
    public EstadoFluxoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class EstadoFluxo.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        EstadoFluxo[] expResult = {EstadoFluxo.PENDENTE,EstadoFluxo.EM_APROVACAO,EstadoFluxo.EM_RESOLUCAO,
                EstadoFluxo.COMPLETO,EstadoFluxo.CANCELADO,EstadoFluxo.REJEITADO};
        EstadoFluxo[] result = EstadoFluxo.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class EstadoFluxo.
     */
    @Test
    public void testValueOfPendente() {
        System.out.println("valueOf");
        String string = "PENDENTE";
        EstadoFluxo expResult = EstadoFluxo.PENDENTE;
        EstadoFluxo result = EstadoFluxo.valueOf(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueOfEM_APROVACAO() {
        System.out.println("valueOf");
        String string = "EM_APROVACAO";
        EstadoFluxo expResult = EstadoFluxo.EM_APROVACAO;
        EstadoFluxo result = EstadoFluxo.valueOf(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueOfEM_RESOLUCAO() {
        System.out.println("valueOf");
        String string = "EM_RESOLUCAO";
        EstadoFluxo expResult = EstadoFluxo.EM_RESOLUCAO;
        EstadoFluxo result = EstadoFluxo.valueOf(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueOfCOMPLETO() {
        System.out.println("valueOf");
        String string = "COMPLETO";
        EstadoFluxo expResult = EstadoFluxo.COMPLETO;
        EstadoFluxo result = EstadoFluxo.valueOf(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueOfCANCELADO() {
        System.out.println("valueOf");
        String string = "CANCELADO";
        EstadoFluxo expResult = EstadoFluxo.CANCELADO;
        EstadoFluxo result = EstadoFluxo.valueOf(string);
        assertEquals(expResult, result);
    }

    @Test
    public void testValueOfREJEITADO() {
        System.out.println("valueOf");
        String string = "REJEITADO";
        EstadoFluxo expResult = EstadoFluxo.REJEITADO;
        EstadoFluxo result = EstadoFluxo.valueOf(string);
        assertEquals(expResult, result);
    }
    
}
