package eapli.base.gestaoservicosrh.repositories;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;
public interface EquipaRepository
        extends DomainRepository<CodigoUnico, Equipa> {

    Optional<Equipa> findByMember(Colaborador colab);

    default Optional<Equipa> findById(Integer id) {
        return null;//return ofIdentity(number);
    }

    public Iterable<Equipa> findAllActive();
}
