package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Identificador;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

public interface CatalogoRepository extends DomainRepository<Long, Catalogo> {
}
