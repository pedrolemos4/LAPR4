/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividade;

import eapli.base.atividade.domain.Comentario;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author pedro
 */
public class ComentarioTest extends TestCase {
    
    public ComentarioTest() {
    }

    /**
     * Test of toString method, of class Comentario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Comentario instance = new Comentario("Teste comentario");
        String expResult = "Comentario{" +
                "coment='" + "Teste comentario" + '\'' +
                '}';;
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
