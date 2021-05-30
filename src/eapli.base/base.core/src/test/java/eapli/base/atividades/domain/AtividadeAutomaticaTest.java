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
public class AtividadeAutomaticaTest {
    
    public AtividadeAutomaticaTest() {
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
     * Test of toString method, of class AtividadeAutomatica.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        AtividadeAutomatica instance = new AtividadeAutomatica(dataLimiteRes,EstadoAtividade.PENDENTE,TipoAtividade.REALIZACAO, new Script("script.sh"));
        String expResult = "ID: 0, DataLimite: Sat Jul 03 20:00:00 WEST 2021, EstadoAtividade: PENDENTE, Script{script='script.sh'}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAtividadeNotAprovacao() {
        System.out.println("atividadeNotAprovacao");
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        TipoAtividade tipoAtividade = TipoAtividade.APROVACAO;
        new AtividadeAutomatica(dataLimiteRes,EstadoAtividade.PENDENTE,tipoAtividade, new Script("script.sh"));
    }

    @Test
    public void ensureAtividadeAuto() {
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        new AtividadeAutomatica(dataLimiteRes,EstadoAtividade.PENDENTE,TipoAtividade.REALIZACAO, new Script("script.sh"));
        assertTrue(true);
    }
    
}
