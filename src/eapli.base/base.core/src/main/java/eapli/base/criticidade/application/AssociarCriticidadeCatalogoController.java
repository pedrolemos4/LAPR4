package eapli.base.criticidade.application;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@UseCaseController
public class AssociarCriticidadeCatalogoController {

    private final CriticidadeRepository repo = PersistenceContext.repositories().criticidade();

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociarCriticidadeCatalogoController.class);

    public boolean saveCriticidade(Criticidade c) {
        try{
            repo.save(c);
            return true;
        }
        catch (ConcurrencyException | IntegrityViolationException exception){
            LOGGER.warn("Error saving " + c.toString() );
            LOGGER.trace("Assuming existing record", exception);
            return false;
        }
    }
}
