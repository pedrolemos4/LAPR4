package eapli.base.persistence.impl.jpa;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.base.tipoequipa.repositories.TipoEquipaRepository;

public class JpaTipoEquipaRepository extends BasepaRepositoryBase<TipoEquipa, CodigoUnico, CodigoUnico> implements TipoEquipaRepository {

    public JpaTipoEquipaRepository() {
        super("Id");
    }
}
