/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividade;

import eapli.base.atividade.domain.Script;
import junit.framework.TestCase;
import org.junit.Test;


/**
 *
 * @author beatriz
 */
public class ScriptTest extends TestCase {
    
    public ScriptTest() {
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
