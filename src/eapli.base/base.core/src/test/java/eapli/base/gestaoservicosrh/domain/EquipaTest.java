package eapli.base.gestaoservicosrh.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.Cor;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class EquipaTest extends TestCase {

    public void testIdentity() {
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),dataAux
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        CodigoUnico exp = novaEquipa.identity();
        assertEquals(novaEquipa.identity(),exp);
    }

    public void testListMembros() {
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),dataAux
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);

        Set<Colaborador> exp = novaEquipa.listMembros();
        assertTrue(exp.equals(list));
    }

    public void testGetTipo() {
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),dataAux
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);

        TipoEquipa exp = novaEquipa.getTipo();
        assertTrue(exp.equals(t1));
    }

    public void testTestEquals() {
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),dataAux
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        Equipa novaEquipa2 = novaEquipa;

        assertTrue(novaEquipa.equals(novaEquipa2));
    }

    public void testTestToString() {
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),dataAux
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        String expResult ="Equipa\nCodigo: cod Acronimo: acronimo1 Designacao: desig Tipo: TipoEquipa{, codigoUnico=t1, designacao=tipo1, cor=Cor: red=10, green=20, blue=30}";
        assertEquals(expResult, novaEquipa.toString());
    }

    public void testHashCode() {
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080),new ShortName("Joao"),new FullName("Joao Alves Pereira"),dataAux
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        int exp = novaEquipa.hashCode();
        assertEquals(novaEquipa.hashCode(),exp);
    }
}