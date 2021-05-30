/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividades.domain;


import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AtividadeTest {
    
    public AtividadeTest() {
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
     * Test of identity method, of class Atividade.
     */
    @Test
    public void testIdentity() {
        System.out.println("identity");
        Calendar dataS = Calendar.getInstance();
        Atividade instance = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        Long expResult = Long.valueOf(0);
        Long result = instance.identity();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Atividade.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade instance = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        String expResult = "ID: 0, DataLimite: Sat Jul 03 10:00:00 WEST 2021, EstadoAtividade: PENDENTE";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionaColaborador method, of class Atividade.
     */
    @Test
    public void testAdicionaColaborador() {
        /*System.out.println("adicionaColaborador");
        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984,10,25);
        Colaborador colab = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade instance = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        //Atividade idAtividade = instance;

        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(colab);

        Set<Equipa> listEquipas1 = new HashSet<>();
        Equipa equipa1 = new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol);
        listEquipas1.add(equipa1);

        Set<Atributo> listaAtributosFormulario2 = new HashSet<>();
        listaAtributosFormulario2.add(new Atributo("Nome Completo", "Label do nome completo"));
        listaAtributosFormulario2.add(new Atributo("Idade", "Label da idade"));


        Formulario form1 = new Formulario("Formulario1", listaAtributosFormulario2);

        AtividadeManual idAtividade = new AtividadeManual(EstadoAtividade.PENDENTE, listEquipas1, new Decisao("decisao1"), new Comentario("comentario"), form1, dataS,TipoAtividade.REALIZACAO);
        instance.adicionaColaborador(colab, instance);*/
    }

    /**
     * Test of tipoAtividade method, of class Atividade.
     */
    @Test
    public void testTipoAtividade() {
        System.out.println("tipoAtividade");
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade instance = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        TipoAtividade expResult = TipoAtividade.REALIZACAO;
        TipoAtividade result = instance.tipoAtividade();
        assertEquals(expResult, result);
    }

    /**
     * Test of atualizarDataAtividade method, of class Atividade.
     */
    @Test
    public void testAtualizarDataAtividade() {
        System.out.println("atualizarDataAtividade");
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade instance = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        instance.atualizarDataAtividade(dataLimiteRes);
    }

    @Test
    public void ensureAtividade() {
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);
        new Atividade(dataLimiteRes,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        assertTrue(true);
    }
    
}
