package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

public interface ColaboradorRepository extends DomainRepository<MecanographicNumber, Colaborador> {

    Colaborador findEmailColaborador(EmailAddress email);
}
