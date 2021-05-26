package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.general.domain.model.EmailAddress;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Long, MecanographicNumber>
        implements ColaboradorRepository {

    public JpaColaboradorRepository() {
        super("numeroMecanografico");
    }

    @Override
    public Colaborador findEmailColaborador(EmailAddress email) {
        final TypedQuery<Colaborador> q = createQuery(
                "SELECT e FROM Colaborador e WHERE e.endereco =: email" ,
                Colaborador.class);
        q.setParameter("email", email);
        return q.getSingleResult();
    }

    @Override
    public List<Equipa> findAssociatedTeams(MecanographicNumber mecanographicNumber) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT e FROM Equipa e INNER JOIN e.listMembros l WHERE l.numeroMecanografico =: mecanographicNumber" ,
                Equipa.class);
        q.setParameter("mecanographicNumber", mecanographicNumber);
        return q.getResultList();
    }

    @Override
    public Iterable<Colaborador> findColaboradoresDaEquipa(CodigoUnico codigoUnico) {
        final TypedQuery<Colaborador> c = createQuery("SELECT c FROM Equipa e " +
                "INNER JOIN e.listMembros c WHERE e.codigo =:codigoUnico",Colaborador.class);
        c.setParameter("codigoUnico",codigoUnico);
        return c.getResultList();
    }

}
