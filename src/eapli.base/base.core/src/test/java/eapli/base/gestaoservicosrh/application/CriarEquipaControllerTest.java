package eapli.base.gestaoservicosrh.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.Cor;
import eapli.base.gestaoservicoshelpdesk.domain.LocalResidencia;
import eapli.base.gestaoservicosrh.domain.*;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.*;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CriarEquipaControllerTest extends TestCase {

    public void testNovaEquipa() {
        CriarEquipaController ctrl = new CriarEquipaController();
        final EquipaRepository repo = PersistenceContext.repositories().equipas();
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        Colaborador c1 = new Colaborador(new MecanographicNumber(1190800),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));

        Set<Colaborador> list = new HashSet<>();
        list.add(c1);
        final Equipa novaEquipa = new Equipa(new CodigoUnico("cod"), new Acronimo("acronimo1"), new Designacao("desig"), t1, list);
        Equipa res = repo.save(novaEquipa);
        assertTrue(res.equals(novaEquipa));
    }

    public void testListTipos() {
        CriarEquipaController ctrl = new CriarEquipaController();
        final TipoEquipaRepository repo = PersistenceContext.repositories().tiposEquipa();
        TipoEquipa t1 = new TipoEquipa(new CodigoUnico("t1"),new Designacao("tipo1"), new Cor(10,20,30));
        repo.save(t1);

        List<TipoEquipa> lt = new ArrayList<>();
        Iterable<TipoEquipa> tipos = ctrl.listTipos();
        for (TipoEquipa tipo: tipos) {
            lt.add(tipo);
        }
        List<TipoEquipa> expResult = new ArrayList<>();
        expResult.add(t1);

        assertTrue(tipos.equals(lt));
    }

    public void testListColab() {
        CriarEquipaController ctrl = new CriarEquipaController();
        final ColaboradorRepository repo = PersistenceContext.repositories().colaborador();
        Colaborador c1 = new Colaborador(new MecanographicNumber(1190800),new ShortName("Joao"),new FullName("Joao Alves Pereira"),new Data(1984,10,25)
                ,new Contacto(931203457),new LocalResidencia("Bairro Baixo"), EmailAddress.valueOf("joao@gmail.com"));//, new Funcao(new CodigoUnico("1a"),new Descricao("coordenador")));
        repo.save(c1);

        List<Colaborador> lc = new ArrayList<>();
        Iterable<Colaborador> colabs = ctrl.listColab();
        for (Colaborador colab: colabs) {
            lc.add(colab);
        }
        List<Colaborador> expResult = new ArrayList<>();
        expResult.add(c1);

        assertTrue(colabs.equals(lc));
    }
}