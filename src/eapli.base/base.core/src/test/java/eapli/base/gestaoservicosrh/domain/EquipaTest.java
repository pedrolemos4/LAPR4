package eapli.base.gestaoservicosrh.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.Cor;
import eapli.base.gestaoservicoshelpdesk.domain.EnderecoEmail;
import eapli.base.gestaoservicoshelpdesk.domain.LocalResidencia;
import eapli.base.usermanagement.domain.*;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class EquipaTest extends TestCase {

    public void testIdentity() {
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        CodigoUnico exp = novaEquipa.identity();
        assertEquals(novaEquipa.identity(),exp);
    }

    public void testListMembros() {
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);

        Set<Colaborador> exp = novaEquipa.listMembros();
        assertTrue(exp.equals(list));
    }

    public void testGetTipo() {
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);

        TipoEquipa exp = novaEquipa.getTipo();
        assertTrue(exp.equals(t1));
    }

    public void testTestEquals() {
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        Equipa novaEquipa2 = novaEquipa;

        assertTrue(novaEquipa.equals(novaEquipa2));
    }

    public void testTestToString() {
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        String expResult ="Equipa\nCodigo: CodigoUnico{codigo='cod'} Acronimo: acronimo1 Designacao: desig Tipo: TipoEquipa{, codigoUnico=CodigoUnico{codigo='t1'}, designacao=tipo1, cor=Cor: red=10, green=20, blue=30}";
        assertEquals(expResult, novaEquipa.toString());
    }

    public void testHashCode() {
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        int exp = novaEquipa.hashCode();
        assertEquals(novaEquipa.hashCode(),exp);
    }
}