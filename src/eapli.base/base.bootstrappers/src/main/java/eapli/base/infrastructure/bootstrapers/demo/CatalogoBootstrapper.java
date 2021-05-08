package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.gestaoservicoshelpdesk.application.EspecificarServicoController;
import eapli.base.gestaoservicoshelpdesk.domain.Atributo;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class CatalogoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ServicoBootstrapper.class);

    private final EspecificarServicoController controller = new EspecificarServicoController();

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

    private void register(final String codigoUnico, final String titulo, final String descricaoBreve,
                          final String descricaoCompleta, final String tituloFormulario, Set<Atributo> listaAtributos) {
        /*try {
            controller.especificarServico(codigoUnico, titulo, descricaoBreve, descricaoCompleta,
                    tituloFormulario, listaAtributos);
            LOGGER.info(codigoUnico);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigoUnico);
            LOGGER.trace("Assuming existing record", e);
        }*/
    }
}
