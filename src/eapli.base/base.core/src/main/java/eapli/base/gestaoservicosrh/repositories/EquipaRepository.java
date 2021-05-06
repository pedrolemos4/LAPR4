package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;
public interface EquipaRepository
        extends DomainRepository<CodigoUnico, Equipa> {

    Optional<Equipa> findByMember(Colaborador colab);

    default Optional<Equipa> findById(Integer id) {
        return null;//return ofIdentity(number);
    }

    public Iterable<Equipa> findAllActive();
}
