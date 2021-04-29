package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.base.gestaoservicosrh.domain.Colaborador;

import java.util.Optional;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public interface ColaboradorRepository
        extends DomainRepository<MecanographicNumber, ClientUser> {

    /**
     * returns the colaborator whose ID is given
     *
     * @param name
     *            the username to search for
     * @return
     */
    Optional<Colaborador> findByID(int ID);

    /**
     * returns the client user (utente) with the given mecanographic number
     *
     * @param number
     * @return
     */
    default Optional<ClientUser> findByMecanographicNumber(MecanographicNumber number) {
        return ofIdentity(number);
    }

    public Iterable<ClientUser> findAllActive();

    Colaborador getColab(int ID);

    boolean validateColab(int ID);
}
