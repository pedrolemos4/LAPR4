package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.gestaoservicoshelpdesk.application.EspecificarServicoController;
import eapli.base.gestaoservicoshelpdesk.application.NovoCatalogoController;
import eapli.base.gestaoservicoshelpdesk.domain.Atributo;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class ServicoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ServicoBootstrapper.class);

    private final NovoCatalogoController controller = new NovoCatalogoController();

    @Override
    public boolean execute() {
        /*register(TestDataConstants.ALLERGEN_GLUTEN,
                "Cereais que contêm glúten (trigo, centeio, cevada, aveia, espelta, gamut ou outras estirpes hibridizadas) e produtos à base destes cereais");
        register(TestDataConstants.ALLERGEN_CRUSTACEOS, "Crustáceos e produtos à base de crustáceos");
        register("ovos", "Ovos e produtos à base de ovos");
        register(TestDataConstants.ALLERGEN_PEIXES, "Peixes e produtos à base de peixe", "images/sardinha.jpg");
        register("amendoins", "Amendoins e produtos à base de amendoins");
        register("soja", "Soja e produtos à base de sojaAmendoins e produtos à base de amendoins");
        register("leite", "Leite e produtos à base de leite (incluindo lactose)");
        register("frutossecos",
                "Frutos de casca rija, nomeadamente, amêndoas, avelãs, nozes, castanhas de caju, pistácios, entre outros");
        register("aipo", "Aipo e produtos à base de aipo");
        register("mostarda", "Mostarda e produtos à base de mostarda");
        register("sesamo", "Sementes de sésamo e produtos à base de sementes de sésamo");
        register("sulfitos",
                "Dióxido de enxofre e sulfitos em concentrações superiores a 10mg/Kg ou 10ml/L");
        register("tremoco", "Tremoço e produtos à base de tremoço");
        register("moluscos", "Moluscos e produtos à base de moluscos");*/
        return true;
    }

    private void register(final String titulo, final String descricaoBreve, final String icone,
                          final String descricaoCompleta, final Iterable<Equipa> listaEquipas, Colaborador colaborador) {
        final InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(icone);

        if (inputStream == null) {
            LOGGER.warn("Could not load image {}", icone);
            // fallback to registration without image
            //register(titulo);
        } else {
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

}
