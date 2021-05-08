package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.Colaborador;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.Optional;

public class JpaEquipaRepository extends BasepaRepositoryBase<Equipa, Long, CodigoUnico> implements EquipaRepository {

    public JpaEquipaRepository() {
        super("Codigo Unico");
    }

    @Override
    public Iterable<Equipa> findByColaborador(MecanographicNumber number) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT e FROM EQUIPA e INNER JOIN EQUIPA_COLABORADOR ec on e.CODIGOUNICO = ec.EQUIPA_CODIGOUNICO " +
                        "WHERE ec.LISTMEMBROS_MECANOGRAPHICNUMBER :number AND e.mealType = :type",
                Equipa.class);
        q.setParameter("number", number);
        return q.getResultList();
    }

}
