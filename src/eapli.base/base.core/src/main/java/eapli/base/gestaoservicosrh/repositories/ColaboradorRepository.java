package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.usermanagement.domain.Utilizador;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ColaboradorRepository extends DomainRepository<MecanographicNumber, Colaborador> {

    /**
     * returns the client user (utente) whose username is given
     *
     * @param email
     *            the username to search for
     * @return
     */

    Optional<Colaborador> findByUsername(String email);

    /**
     * returns the client user (utente) with the given mecanographic number
     *
     * @param number
     * @return
     */
    default Optional<Colaborador> findByMecanographicNumber(MecanographicNumber number) {
        return ofIdentity(number);
    }

    public Iterable<Colaborador> findAllActive();

}
