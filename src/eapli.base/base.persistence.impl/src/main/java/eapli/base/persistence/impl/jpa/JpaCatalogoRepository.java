package eapli.base.persistence.impl.jpa;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;

import javax.persistence.TypedQuery;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Long, Long> implements CatalogoRepository {

    public JpaCatalogoRepository() {
        super("Identificador");
    }

    public Iterable<Catalogo>findByDescricaoCompleta(String descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.descricaoCompleta ec WHERE" +
                        " ec.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreve(String descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.descricaoBreve ec WHERE" +
                        " ec.value = :descricaoBreve",
                Catalogo.class);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTitulo(String titulo){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec WHERE" +
                        " ec.titulo = :titulo",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoBreve(String titulo, String descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db WHERE " +
                        "ec.titulo = :titulo AND db = :descricaoBreve",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoCompleta(String titulo, String descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec INNER JOIN e.descricaoCompleta dc WHERE " +
                        "ec.titulo = :titulo AND dc.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreveDescricaoCompleta(String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.descricaoBreve ec INNER JOIN e.descricaoCompleta dc WHERE " +
                        "ec.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findTodos(String titulo, String descricaoBreve, String descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "INNER JOIN e.descricaoCompleta dc WHERE " +
                        "ec.titulo = :titulo AND db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }


}
