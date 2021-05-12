package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.Colaborador;

import javax.persistence.NoResultException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class JpaEquipaRepository extends BasepaRepositoryBase<Equipa, Long, CodigoUnico> implements EquipaRepository {

    public JpaEquipaRepository() {
        super("codigo");
    }

    @Override
    public Iterable<Equipa> findByColaborador(MecanographicNumber number) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT e FROM Equipa e JOIN e.listMembros ec " +
                        "WHERE ec.numeroMecanografico =:number",
                Equipa.class);
        q.setParameter("number", number);
        return q.getResultList();
    }

    @Override
    public Iterable<Equipa> findEquipaDoCatalogo(Long identity) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT ec FROM Catalogo e JOIN e.listEquipas ec WHERE" +
                        " e.identificador =:identity",
                Equipa.class);
        q.setParameter("identity", identity);
        return q.getResultList();
    }

    @Override
    public Equipa validate(TipoEquipa tipo, MecanographicNumber identity) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT e FROM Equipa e JOIN e.listMembros ec WHERE ec.numeroMecanografico =:identity AND e.tipo =:tipo" ,
                Equipa.class);
        q.setParameter("identity", identity);
        q.setParameter("tipo", tipo);
        try {
            return q.getSingleResult();
        }
        catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Equipa findByTipoEquipa(CodigoUnico identity, TipoEquipa tipo) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT e FROM Equipa e " +
                        "WHERE e.codigo = :identity AND e.tipo =:tipo",
                Equipa.class);
        q.setParameter("identity", identity);
        q.setParameter("tipo", tipo);
        return q.getSingleResult();
    }

    @Override
    public List<Equipa> findAll(){
        final TypedQuery<Equipa> q = createQuery(
                "SELECT e FROM Equipa e " , Equipa.class);
        return q.getResultList();
    }

}
