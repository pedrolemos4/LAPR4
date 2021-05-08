package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.general.domain.model.EmailAddress;

import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Long, MecanographicNumber>
        implements ColaboradorRepository {

    public JpaColaboradorRepository() {
        super("Mecanographic Number");
    }

    @Override
    public Optional<Colaborador> findEmailColaborador(EmailAddress email) {
        final TypedQuery<Colaborador> q = createQuery(
                    "SELECT e FROM COLABORADOR e WHERE e.email = :email",
                Colaborador.class);
        final Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        return matchOne("e.email = :email", params);
    }

}
