package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.usermanagement.domain.Colaborador;

public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Long, MecanographicNumber>
        implements ColaboradorRepository {

    public JpaColaboradorRepository() {
        super("Mecanographic Number");
    }

}
