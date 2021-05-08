package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Identificador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public interface CatalogoRepository extends DomainRepository<Long, Catalogo> {

    Iterable<Catalogo> findCatalogos(final String titulo, final String descricaobreve, final String descricaocompleta);

}
