package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.application.EspecificarServicoController;
import eapli.base.gestaoservicoshelpdesk.application.NovoCatalogoController;
import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicosrh.domain.*;
import eapli.base.usermanagement.domain.*;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CatalogoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ServicoBootstrapper.class);

    private final NovoCatalogoController controller = new NovoCatalogoController();

    @Override
    public boolean execute() {
        Colaborador c1 = new Colaborador(new MecanographicNumber(1190800), new ShortName("Joao"), new FullName("Joao Alves"), new Data(2001, 3, 8)
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));// new Funcao(new CodigoUnico("1a"), new Descricao("coordenador")*/));
        Set<Equipa> list = new HashSet<>();
        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(c1);
        list.add(new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol));
        register("titulo1", "descricaoBreve", "icone", "descricaoComleta", list, c1);

/*        Colaborador c2 = new Colaborador(new MecanographicNumber(123), new ShortName("Raquel"), new FullName("Raquel Alves"), new Data(2001, 3, 8)
                , new Contacto(925681204), new LocalResidencia("Penafiel"), new EnderecoEmail("raquel@gmail.com"));//, new Funcao(new CodigoUnico("2a"), new Descricao("ajunta")));
        Set<Equipa> list2 = new HashSet<>();
        list2.add(new Equipa(new CodigoUnico("op147"), new Acronimo("equipa2"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("te2"), new Designacao("tipo_Equipa"), new Cor(60, 60, 70)), setCol));
        register("titulo2", "descricaoBreve1", "icone1", "descricaoComleta1", list2, c2);
*/
        return true;
    }

    private void register(final String titulo, final String descricaoBreve, final String icone,
                          final String descricaoCompleta, final Iterable<Equipa> listaEquipas, Colaborador colaborador) {
      /*  final InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(icone);

        if (inputStream == null) {
            LOGGER.warn("Could not load image {}", icone);
            // fallback to registration without image
            //register(titulo);
        } else {*/

        try {
            controller.novoCatalogo(titulo, descricaoBreve, icone, descricaoCompleta, listaEquipas, colaborador);
            LOGGER.info(titulo);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", titulo);
            LOGGER.trace("Assuming existing record", e);
        }
    }

}
