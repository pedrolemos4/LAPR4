package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;

import javax.persistence.TypedQuery;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Long, Long> implements CatalogoRepository {

    public JpaCatalogoRepository() {
        super("Identificador");
    }

    @Override
    public Iterable<Catalogo> findCatalogos(Long identity, String titulo, String descricaobreve, String descricaocompleta) {
        //APENAS DESCRICAOCOMPLETA
        if(titulo.isEmpty() && descricaobreve.isEmpty() && !descricaocompleta.isEmpty()) {
            return findByDescricaoCompleta(identity, descricaocompleta);
        } //APENAS DESCRICAOBREVE
        else if(titulo.isEmpty() && !descricaobreve.isEmpty() && descricaocompleta.isEmpty()) {
            return findByDescricaoBreve(identity, descricaobreve);
        } //APENAS TITULO
        else if(!titulo.isEmpty() && descricaobreve.isEmpty() && descricaocompleta.isEmpty()) {
            return findByTitulo(identity, titulo);
        } // TITULO E DESCRICAOBREVE
        else if(!titulo.isEmpty() && !descricaobreve.isEmpty() && descricaocompleta.isEmpty()) {
            return findByTituloDescricaoBreve(identity, titulo, descricaobreve);
        } // TITULO E DESCRICAOCOMPLETA
        else if(!titulo.isEmpty() && descricaobreve.isEmpty() && !descricaocompleta.isEmpty()) {
            return findByTituloDescricaoCompleta(identity, titulo, descricaocompleta);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(titulo.isEmpty() && !descricaobreve.isEmpty() && !descricaocompleta.isEmpty()) {
            return findByDescricaoBreveDescricaoCompleta(identity, descricaobreve, descricaocompleta);
        } // TUDO
        else if(!titulo.isEmpty() && !descricaobreve.isEmpty() && !descricaocompleta.isEmpty()) {
            return findTodos(identity, titulo, descricaobreve, descricaocompleta);
        }
        return null;
    }

    public Iterable<Catalogo>findByDescricaoCompleta(Long identity, String descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.descricaoCompleta ec WHERE e.identificador = :identity" +
                        " AND ec.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreve(Long identity, String descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.descricaoBreve ec WHERE e.identificador = :identity" +
                        " AND ec.value = :descricaoBreve",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTitulo(Long identity, String titulo){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec WHERE e.identificador = :identity" +
                        " AND ec.titulo = :titulo",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoBreve(Long identity, String titulo, String descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db WHERE " +
                        "e.identificador = :identity AND ec.titulo = :titulo AND db = :descricaoBreve",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoCompleta(Long identity, String titulo, String descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec INNER JOIN e.descricaoCompleta dc WHERE " +
                        "e.identificador = :identity AND ec.titulo = :titulo AND dc.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreveDescricaoCompleta(Long identity, String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.descricaoBreve ec INNER JOIN e.descricaoCompleta dc WHERE " +
                        "e.identificador = :identity AND ec.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findTodos(Long identity, String titulo, String descricaoBreve, String descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "INNER JOIN e.descricaoCompleta dc WHERE e.identificador = :identity " +
                        "AND ec.titulo = :titulo AND db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }


}
