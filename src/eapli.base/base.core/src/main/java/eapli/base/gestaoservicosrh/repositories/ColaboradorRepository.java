package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.EnderecoEmail;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.usermanagement.domain.Utilizador;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface ColaboradorRepository extends DomainRepository<MecanographicNumber, Colaborador> {

    Colaborador findEmailColaborador(EmailAddress email);
}
