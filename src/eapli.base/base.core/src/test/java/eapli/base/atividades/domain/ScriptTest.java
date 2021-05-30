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

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 *
 * @author beatriz
 */
public class ScriptTest {
    
    public ScriptTest() {
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
     * Test of toString method, of class Script.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Script instance = new Script("script.sh");
        String expResult = "Script{script='script.sh'}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void ensureScript() {
        new Script("script.sh");
        assertTrue(true);
    }
    
}
