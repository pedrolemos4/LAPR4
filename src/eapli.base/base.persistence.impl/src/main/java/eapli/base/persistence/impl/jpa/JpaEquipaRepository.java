package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;

public class JpaEquipaRepository extends BasepaRepositoryBase<Equipa, Long, CodigoUnico> implements EquipaRepository {

    public JpaEquipaRepository() {
        super("Codigo Unico");
    }
}
