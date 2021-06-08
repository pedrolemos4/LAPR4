/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.colaborador;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ColaboradorTest {
    private Calendar dataAux;
    private Colaborador instance;

    public ColaboradorTest() {
        this.dataAux = Calendar.getInstance();
        this.dataAux.set(1993,4,3);
        this.instance = new Colaborador(new MecanographicNumber(123654),new ShortName("short"),new FullName("full name"),dataAux,new Contacto(963258741),new LocalResidencia("Local Residencia"), EmailAddress.valueOf("email@gmail.com"));
    }

    /**
     * Test of toString method, of class Colaborador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Colaborador{numeroMecanografico=123654, shortName=short, fullName=full name, localResidencia=LocalResidencia{endereco='Local Residencia'}, endereco=email@gmail.com, contacto=Contacto{number=963258741, prefix=0}}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of sameAs method, of class Colaborador.
     */
    @Test
    public void testSameAs1() {
        System.out.println("sameAs=true");
        Object other = new Colaborador(new MecanographicNumber(123456),new ShortName("Robert"),new FullName("Robert De Niro Dos Santos Afonso")
                ,dataAux,new Contacto(159753215),new LocalResidencia("Somewhere Over the rainbow")
                ,EmailAddress.valueOf("exemplo@examplo.com"));
        Object that = (Colaborador) other;
        boolean expResult = false;
        boolean result = instance.sameAs(that);
        assertEquals(expResult, result);
    }

    /**
     * Test of sameAs method, of class Colaborador.
     */
    @Test
    public void testSameAs2() {
        System.out.println("sameAs=false");
        Object other = new Object();
        boolean expResult = false;
        boolean result = instance.sameAs(other);
        assertEquals(expResult, result);
    }
    
}
