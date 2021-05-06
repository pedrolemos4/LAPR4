package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Identificador;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Long, Identificador> implements CatalogoRepository {

    public JpaCatalogoRepository() {
        super("Identificador");
    }

}
