package eapli.base.persistence.impl.jpa;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.base.equipa.repositories.EquipaRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public boolean findEquipaDoCatalogo(Long identity, MecanographicNumber number) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT ec FROM Catalogo e, Equipa eq, Colaborador c JOIN c.likes l JOIN e.listEquipas ec " +
                        "JOIN eq.listMembros el WHERE" +
                        " e.identificador =:identity AND ec.codigo = l.codigo AND el.numeroMecanografico =:number",
                Equipa.class);
        q.setParameter("identity", identity);
        q.setParameter("number", number);
        if(q.getResultList().isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<Equipa> findEquipaDoCatalogo(Long identity) {
        final TypedQuery<Equipa> q = createQuery(
                "SELECT ec FROM Catalogo e join e.listEquipas ec WHERE " +
                        " e.identificador =:identity ",
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
        try{
            final TypedQuery<Equipa> q = createQuery(
                    "SELECT e FROM Equipa e " +
                            "WHERE e.codigo = :identity AND e.tipo =:tipo",
                    Equipa.class);
            q.setParameter("identity", identity);
            q.setParameter("tipo", tipo);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public List<Equipa> findAll(){
        final TypedQuery<Equipa> q = createQuery(
                "SELECT e FROM Equipa e " , Equipa.class);
        return q.getResultList();
    }

}
