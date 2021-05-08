package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.EnderecoEmail;
import eapli.base.gestaoservicosrh.domain.Equipa;
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
    public Colaborador findEmailColaborador(EmailAddress email) {
        final TypedQuery<Colaborador> q = createQuery(
                "SELECT e FROM Colaborador e WHERE e.endereco =: email" ,
                Colaborador.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }

}
