/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.usermanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.LocalResidencia;
import eapli.framework.general.domain.model.EmailAddress;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedro
 */
public class ColaboradorTest {

    private Colaborador instance = new Colaborador(new MecanographicNumber(123654),new ShortName("short"),new FullName("full name"),new Data(1995,02,01),new Contacto(963258741),new LocalResidencia("Local Residencia"), EmailAddress.valueOf("email@gmail.com"));

    public ColaboradorTest() {
    }

    /**
     * Test of toString method, of class Colaborador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Colaborador{numeroMecanografico=Number: 123654, shortName=short, fullName=full name, localResidencia=LocalResidencia{endereco='Local Residencia'}, dataNasc=Data{ano=1995, mes=2, dia=1}, endereco=email@gmail.com, contacto=Contacto{number=963258741, prefix=0}}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of sameAs method, of class Colaborador.
     */
    @Test
    public void testSameAs1() {
        System.out.println("sameAs=true");
        Object other = new Colaborador();
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