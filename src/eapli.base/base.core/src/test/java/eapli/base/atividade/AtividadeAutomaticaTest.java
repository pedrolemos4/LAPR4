/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividade;

import eapli.base.atividade.domain.AtividadeAutomatica;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.Script;
import eapli.base.atividade.domain.TipoAtividade;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Calendar;


/**
 *
 * @author beatriz
 */
public class AtividadeAutomaticaTest extends TestCase {
    
    public AtividadeAutomaticaTest() {
    }

    /**
     * Test of toString method, of class AtividadeAutomatica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        AtividadeAutomatica instance = new AtividadeAutomatica(dataLimiteRes, EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO, null, new Script("script.sh"));
        String expResult = "ID: 0, DataLimite: Sat Jul 03 20:00:00 WEST 2021, EstadoAtividade: PENDENTE, script.sh";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAtividadeNotAprovacao() {
        System.out.println("atividadeNotAprovacao");
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        TipoAtividade tipoAtividade = TipoAtividade.APROVACAO;
        try {
            new AtividadeAutomatica(dataLimiteRes, EstadoAtividade.PENDENTE, tipoAtividade,null, new Script("script.sh"));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void ensureAtividadeAuto() {
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        new AtividadeAutomatica(dataLimiteRes,EstadoAtividade.PENDENTE,TipoAtividade.REALIZACAO, null, new Script("script.sh"));
        assertTrue(true);
    }
    
}
