package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;

public class JpaTipoEquipaRepository extends BasepaRepositoryBase<TipoEquipa, Long, String> implements TipoEquipaRepository {

    public JpaTipoEquipaRepository() {
        super("Id");
    }
}
