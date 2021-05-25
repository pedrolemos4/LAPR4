package eapli.base.persistence.impl.jpa;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.Etiqueta;
import eapli.base.criticidade.repositories.CriticidadeRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaCriticidadeRepository extends BasepaRepositoryBase<Criticidade, Long, Long>
        implements CriticidadeRepository {

    public JpaCriticidadeRepository() {
        super("Id");
    }

    @Override
    public Criticidade findByTag(Etiqueta etiqueta) {
        try{
            final TypedQuery<Criticidade> q = createQuery(
                    "SELECT c FROM Criticidade c " +
                            "WHERE c.etiqueta =: etiqueta",
                    Criticidade.class);
            q.setParameter("etiqueta", etiqueta);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Criticidade getCriticidadeDoCatalogo(Long identity) {
        try{
            final TypedQuery<Criticidade> q = createQuery(
                    "SELECT c FROM Criticidade c, Catalogo ct JOIN ct.criticidades where ct.criticidades =: identity",
                    Criticidade.class);
            q.setParameter("identity", identity);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
