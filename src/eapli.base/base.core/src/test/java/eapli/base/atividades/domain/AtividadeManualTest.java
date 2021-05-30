/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividades.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.Cor;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author beatriz
 */
public class AtividadeManualTest {
    
    public AtividadeManualTest() {
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
     * Test of toString method, of class AtividadeManual.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984,10,25);
        Colaborador colab = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);

        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(colab);

        Set<Equipa> listEquipas1 = new HashSet<>();
        Equipa equipa1 = new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol);
        listEquipas1.add(equipa1);

        Set<Atributo> listaAtributosFormulario2 = new HashSet<>();
        listaAtributosFormulario2.add(new Atributo("Nome Completo", "Label do nome completo"));
        listaAtributosFormulario2.add(new Atributo("Idade", "Label da idade"));


        Formulario form1 = new Formulario("Formulario1", listaAtributosFormulario2);

        AtividadeManual instance = new AtividadeManual(EstadoAtividade.PENDENTE, listEquipas1, new Decisao("decisao1"), new Comentario("comentario"), form1, dataS,TipoAtividade.REALIZACAO);

        String expResult = "ID: 0, DataLimite: Sat Jul 03 10:00:00 WEST 2021, EstadoAtividade: PENDENTE";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionaColaborador method, of class AtividadeManual.
     */
    @Test
    public void testAdicionaColaborador() {
        System.out.println("adicionaColaborador");
        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984,10,25);
        Colaborador colab = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);

        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(colab);

        Set<Equipa> listEquipas1 = new HashSet<>();
        Equipa equipa1 = new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol);
        listEquipas1.add(equipa1);

        Set<Atributo> listaAtributosFormulario2 = new HashSet<>();
        listaAtributosFormulario2.add(new Atributo("Nome Completo", "Label do nome completo"));
        listaAtributosFormulario2.add(new Atributo("Idade", "Label da idade"));


        Formulario form1 = new Formulario("Formulario1", listaAtributosFormulario2);

        AtividadeManual instance = new AtividadeManual(EstadoAtividade.PENDENTE, listEquipas1, new Decisao("decisao1"), new Comentario("comentario"), form1, dataS,TipoAtividade.REALIZACAO);

        instance.adicionaColaborador(colab);
    }

    @Test
    public void ensureAtividadeManualRealizacao() {
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);

        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984,10,25);
        Colaborador colab = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);

        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(colab);

        Set<Equipa> listEquipas1 = new HashSet<>();
        Equipa equipa1 = new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol);
        listEquipas1.add(equipa1);

        Set<Atributo> listaAtributosFormulario2 = new HashSet<>();
        listaAtributosFormulario2.add(new Atributo("Nome Completo", "Label do nome completo"));
        listaAtributosFormulario2.add(new Atributo("Idade", "Label da idade"));


        Formulario form1 = new Formulario("Formulario1", listaAtributosFormulario2);

        new AtividadeManual(EstadoAtividade.PENDENTE, listEquipas1, new Decisao("decisao1"), new Comentario("comentario"), form1, dataS,TipoAtividade.REALIZACAO);
        assertTrue(true);
    }

    @Test
    public void ensureAtividadeManualAprovacao() {
        Calendar dataLimiteRes = Calendar.getInstance();
        dataLimiteRes.set(2021,06,03,20,0,0);

        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984,10,25);
        Colaborador colab = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);

        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(colab);

        Set<Equipa> listEquipas1 = new HashSet<>();
        Equipa equipa1 = new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol);
        listEquipas1.add(equipa1);

        Set<Atributo> listaAtributosFormulario2 = new HashSet<>();
        listaAtributosFormulario2.add(new Atributo("Nome Completo", "Label do nome completo"));
        listaAtributosFormulario2.add(new Atributo("Idade", "Label da idade"));


        Formulario form1 = new Formulario("Formulario1", listaAtributosFormulario2);

        new AtividadeManual(EstadoAtividade.PENDENTE, listEquipas1, new Decisao("decisao1"), new Comentario("comentario"), form1, dataS,TipoAtividade.APROVACAO);
        assertTrue(true);
    }
    
}
