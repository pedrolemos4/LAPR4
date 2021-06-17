/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.atividade;

import eapli.base.atividade.domain.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.formulario.domain.*;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;
import org.junit.*;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


/**
 * @author pedro
 */
public class FluxoAtividadeTest extends TestCase {

    FluxoAtividade instance1;
    FluxoAtividade instance2;

    Set<Atividade> setAtividades1 = new HashSet<>();
    Set<Atividade> setAtividades2 = new HashSet<>();

    public FluxoAtividadeTest() {
        instance1 = new FluxoAtividade(setAtividades1);
        instance2 = new FluxoAtividade(setAtividades2);

        Set<Atributo> listaAtributosFormulario1 = new HashSet<>();
        listaAtributosFormulario1.add(new Atributo(new Variavel("Nome Completo"),new Label("Label do nome completo"), TipoDados.STRING,Obrigatoriedade.OPCIONAL,new DescricaoAjuda("ola"), null, null));
        listaAtributosFormulario1.add(new Atributo(new Variavel("Idade"),new Label("Label da idade"), TipoDados.STRING,Obrigatoriedade.OPCIONAL,new DescricaoAjuda("ola"),null,null));
        Formulario form1 = new Formulario("Formulario1", listaAtributosFormulario1);
        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984, 10, 25);
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"),new HashSet<>());
        AtividadeAutomatica atA1 = new AtividadeAutomatica(dataAux1, EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO, new Script("caminho.sh"));
        AtividadeManual atM1 = new AtividadeManual(EstadoAtividade.PENDENTE, c1, Decisao.APROVADO, new Comentario("Coment"), form1, dataAux1, TipoAtividade.APROVACAO);

        setAtividades1.add(atA1);
        setAtividades2.add(atM1);
    }


    /**
     * Test of sameAs method, of class FluxoAtividade.
     */
    @Test
    public void testSameAs1() {
        System.out.println("sameAs1");

        Object other =  (FluxoAtividade) instance1;
        boolean expResult = true;
        boolean result = instance1.sameAs(other);
        assertEquals(expResult, result);
    }

    @Test
    public void testSameAs2() {
        System.out.println("sameAs2");
        boolean expResult = false;
        boolean result = instance1.sameAs(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of identity method, of class FluxoAtividade.

    @Test
    public void testIdentity() {
        System.out.println("identity");
        Long expResult = null;
        Long result = instance1.identity();
        assertEquals(expResult, result);
    }*/

    /**
     * Test of adicionaColaborador method, of class FluxoAtividade.
     */
    /*@Test
    public void testAdicionaColaborador() {
        System.out.println("adicionaColaborador");
        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984,10,25);
        Colaborador colab = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));

        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade idAtividade = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        Set<Atividade> set = new HashSet<>();
        set.add(idAtividade);
        FluxoAtividade instance = new FluxoAtividade(set);
        instance.adicionaColaborador(colab, idAtividade);
    }*/

    /**
     * Test of atividades method, of class FluxoAtividade.
     */
    @Test
    public void testAtividades() {
        System.out.println("atividades");
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade idAtividade = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        Set<Atividade> set = new HashSet<>();
        set.add(idAtividade);
        FluxoAtividade instance = new FluxoAtividade(set);
        Set<Atividade> expResult = new HashSet<>();
        expResult.add(idAtividade);
        Set<Atividade> result = instance.atividades();
        assertEquals(expResult, result);
    }

    /**
     * Test of alterarEstado method, of class FluxoAtividade.
     */
    @Test
    public void testAlterarEstado() {
        System.out.println("alterarEstado");
        EstadoFluxo estadoFluxo = EstadoFluxo.CANCELADO;
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade idAtividade = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        Set<Atividade> set = new HashSet<>();
        set.add(idAtividade);
        FluxoAtividade instance = new FluxoAtividade(set);
        instance.alterarEstado(estadoFluxo);
    }

    /**
     * Test of atualizarDataAtividade method, of class FluxoAtividade.
     */
    @Test
    public void testAtualizarDataAtividade() {
        /*
        System.out.println("atualizarDataAtividade");
        Atividade atividade = null;
        Calendar dataLimiteRes = null;
        FluxoAtividade instance = new FluxoAtividade();
        instance.atualizarDataAtividade(atividade, dataLimiteRes);

         */
    }

    /**
     * Test of toString method, of class FluxoAtividade.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Calendar dataS = Calendar.getInstance();
        dataS.set(2021,06,03,10,0,0);
        Atividade idAtividade = new Atividade(dataS,EstadoAtividade.PENDENTE, TipoAtividade.REALIZACAO);
        Set<Atividade> set = new HashSet<>();
        set.add(idAtividade);
        FluxoAtividade instance = new FluxoAtividade(set);
        String expResult = "FluxoAtividade{estadoFluxo=PENDENTE, listaAtividade=[ID: 0, DataLimite: Sat Jul 03 10:00:00 WEST 2021, EstadoAtividade: PENDENTE]}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
