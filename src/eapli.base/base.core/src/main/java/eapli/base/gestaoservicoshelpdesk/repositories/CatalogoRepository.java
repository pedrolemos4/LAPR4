package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.framework.domain.repositories.DomainRepository;

public interface CatalogoRepository extends DomainRepository<Long, Catalogo> {

    Iterable<Catalogo> findCatalogos(Long identity, final Titulo titulo, final DescricaoBreve descricaobreve, final DescricaoCompletaCatalogo descricaocompleta);

}
