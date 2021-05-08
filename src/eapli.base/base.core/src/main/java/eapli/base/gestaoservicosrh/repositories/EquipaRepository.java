package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface EquipaRepository
        extends DomainRepository<CodigoUnico, Equipa> {

    /**
     * returns the client user (utente) whose username is given
     *
     * @param email
     *            the username to search for
     * @return
     */

    Optional<Equipa> findByCodigo(CodigoUnico codigoUnico);

}
