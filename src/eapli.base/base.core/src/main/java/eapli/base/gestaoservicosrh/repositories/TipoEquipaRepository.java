package eapli.base.gestaoservicosrh.repositories;

import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;


public interface TipoEquipaRepository extends DomainRepository<String, TipoEquipa>, LockableDomainRepository<String, TipoEquipa> {
}
