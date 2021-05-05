package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public interface EquipaRepository
        extends DomainRepository<CodigoUnico, Equipa> {

    /**
     * returns the team that contains the member specified
     *
     * @param colab
     *            the username to search for
     * @return
     */
    Optional<Equipa> findByMember(Colaborador colab);

    /**
     * returns the team with the id defined
     *
     * @param id
     * @return
     */
    default Optional<Equipa> findById(Integer id) {
        return null;//return ofIdentity(number);
    }

    public Iterable<Equipa> findAllActive();
}
