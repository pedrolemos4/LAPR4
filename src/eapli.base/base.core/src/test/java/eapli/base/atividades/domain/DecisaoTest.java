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
 * @author pedro
 */
public class DecisaoTest {
    
    public DecisaoTest() {
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
