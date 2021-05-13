package eapli.base.colaborador.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

public interface ColaboradorRepository extends DomainRepository<MecanographicNumber, Colaborador> {

    Colaborador findEmailColaborador(EmailAddress email);
}
