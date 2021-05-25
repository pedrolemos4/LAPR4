/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.catalogo.domain.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.*;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class CatalogoTest {

    private final Set<Equipa> iterable = new HashSet<>();
    private Catalogo instance;

    public CatalogoTest() {
        final Calendar data = Calendar.getInstance();
        data.set(1000,02,03);
        instance = new Catalogo(new Titulo("ti"),new Colaborador(new MecanographicNumber(123654),new ShortName("short"),new FullName("full name"), data,new Contacto(963258741),new LocalResidencia("Local Residencia"),EmailAddress.valueOf("email@gmail.com")),new DescricaoCompletaCatalogo("Desc Completa"),new DescricaoBreve("Desc Breve"), new Icone("Icone"), iterable, new Criticidade(new Etiqueta("Etiqueta2"), new Escala(3), new Designacao("Name2"), new Objetivo(13.2,11,13.2,11), new Cor(13,13,13)));
    }

    /**
     * Test of sameAs method, of class Catalogo.
     */
    @Test
    public void testSameAs1() {
        System.out.println("sameAs=True");

        Object other = (Catalogo) instance;
        boolean expResult = true;
        boolean result = instance.sameAs(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of sameAs method, of class Catalogo.
     */
    @Test
    public void testSameAs2() {
        System.out.println("sameAs=False");
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Colaborador colaborador = new Colaborador(new MecanographicNumber(123456),new ShortName("Robert"),new FullName("Robert De Niro Dos Santos Afonso")
                ,dataAux,new Contacto(159753215),new LocalResidencia("Somewhere Over the rainbow")
                ,EmailAddress.valueOf("exemplo@examplo.com"));
        Object other = new Catalogo(new Titulo("Test"),colaborador,new DescricaoCompletaCatalogo("Descrição Completa"),
                new DescricaoBreve("Descricao Breve"),new Icone("Icone"),new ArrayList<>(), new Criticidade(new Etiqueta("Etiqueta2"), new Escala(3), new Designacao("Name2"), new Objetivo(13.2,11,13.2,11), new Cor(13,13,13)));
        boolean expResult = false;
        boolean result = instance.sameAs(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Catalogo.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals=true");

        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Colaborador colaborador = new Colaborador(new MecanographicNumber(123456),new ShortName("Robert"),new FullName("Robert De Niro Dos Santos Afonso")
                ,dataAux,new Contacto(159753215),new LocalResidencia("Somewhere Over the rainbow")
                ,EmailAddress.valueOf("exemplo@examplo.com"));
        Object other = new Catalogo(new Titulo("Test"),colaborador,new DescricaoCompletaCatalogo("Descrição Completa"),
                new DescricaoBreve("Descricao Breve"),new Icone("Icone"),new ArrayList<>(), new Criticidade(new Etiqueta("Etiqueta2"), new Escala(3), new Designacao("Name2"), new Objetivo(13.2,11,13.2,11), new Cor(13,13,13)));
        Catalogo instance1 = (Catalogo) other;
        System.out.println(instance1.toString());
        System.out.println(instance.toString());
        boolean expResult = true;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Catalogo.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals=false");
        Object o = new Object();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Catalogo.
     */
    @Test
    public void testToString1() {
        System.out.println("toString=true");
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Colaborador colaborador = new Colaborador(new MecanographicNumber(123456),new ShortName("Robert"),new FullName("Robert De Niro Dos Santos Afonso")
                ,dataAux,new Contacto(159753215),new LocalResidencia("Somewhere Over the rainbow")
                ,EmailAddress.valueOf("exemplo@examplo.com"));
        Catalogo instance = new Catalogo(new Titulo("Test"),colaborador,new DescricaoCompletaCatalogo("Descricao Completa"),
                new DescricaoBreve("Descricao Breve"),new Icone("Icone"),new ArrayList<>(), new Criticidade(new Etiqueta("Etiqueta2"), new Escala(3), new Designacao("Name2"), new Objetivo(13.2,11,13.2,11), new Cor(13,13,13)));
        String expResult = "Catalogo{titulo=Test, descricaoCompleta=Descricao Completa, descricaoBreve=Descricao Breve, icone=Icone{icone='Icone'}, listEquipas=[], listServicos=[], colab=Colaborador{numeroMecanografico=Number: 123456, shortName=Robert, fullName=Robert De Niro Dos Santos Afonso, localResidencia=LocalResidencia{endereco='Somewhere Over the rainbow'}, endereco=exemplo@examplo.com, contacto=Contacto{number=159753215, prefix=0}} criticidade=Criticidade: etiqueta=Etiqueta2, escala=Valor:3, designacao=Name2, objetivo=Objetivo\n" +
                "tempoMaxApro: 13.2\n" +
                "tempoMedioAprov:11.0\n" +
                "tempoMaxRes:13.2\n" +
                "tempoMedioRes:11.0, cor=Cor: red=13, green=13, blue=13}" ;
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
