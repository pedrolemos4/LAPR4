package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.catalogo.application.NovoCatalogoController;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.*;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class CatalogoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(CatalogoBootstrapper.class);

    private final NovoCatalogoController controller = new NovoCatalogoController();

    @Override
    public boolean execute() {
        // PRIMEIRO CATALOGO
        Set<FuncaoColaborador> funcao = new HashSet<>();
        funcao.add(BaseRolesColaborador.DIRETOR);
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves"), dataAux
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"),funcao);
        Set<Equipa> list = new HashSet<>();
        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(c1);
        list.add(new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol));
        register("titulo1", "descricaoBreve", "icone", "descricaoCompleta", list, c1, new Criticidade(new Etiqueta("Etiqueta2"), new Escala(3), new Designacao("Name2"), new Objetivo(13,11,13,11), new Cor(13,13,13)));

        // SEGUNDO CATALOGO
        Colaborador c2 = new Colaborador(new MecanographicNumber(119876), new ShortName("Afonso"), new FullName("Afonso Sousa"), dataAux
                , new Contacto(932705057), new LocalResidencia("Bairro Alto"), EmailAddress.valueOf("afonso@gmail.com"),funcao);
        Set<Colaborador> setCol1 = new HashSet<>();
        setCol1.add(c2);
        Set<Equipa> list2 = new HashSet<>();
        list2.add(new Equipa(new CodigoUnico("e2"), new Acronimo("EQP2"), new Designacao("equipa2"), new TipoEquipa(new CodigoUnico("te2"), new Designacao("tipo2"), new Cor(60, 60, 80)), setCol1));
        register("titulo2", "descricaoBreve2", "icone2", "descricaoCompleta2", list2, c2, new Criticidade(new Etiqueta("Etiqueta1"), new Escala(2), new Designacao("Name1"), new Objetivo(12,10,12,10), new Cor(12,12,12)));

        return true;
    }

    private void register(final String titulo, final String descricaoBreve, final String icone,
                          final String descricaoCompleta, final Iterable<Equipa> listaEquipas, Colaborador colaborador,
                          Criticidade criticidade) {
      /*  final InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(icone);

        if (inputStream == null) {
            LOGGER.warn("Could not load image {}", icone);
            // fallback to registration without image
            //register(titulo);
        } else {*/

        try {
            controller.novoCatalogo(titulo, descricaoBreve, icone, descricaoCompleta, listaEquipas, colaborador, criticidade);
            LOGGER.info(titulo);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", titulo);
            LOGGER.trace("Assuming existing record", e);
        }
    }

}
