package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;

import javax.persistence.TypedQuery;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Long, Long> implements CatalogoRepository {

    public JpaCatalogoRepository() {
        super("Identificador");
    }

    @Override
    public Iterable<Catalogo> findCatalogos(Long identity, Titulo titulo, DescricaoBreve descricaobreve, DescricaoCompletaCatalogo descricaocompleta) {
        //APENAS DESCRICAOCOMPLETA
        if(titulo==null && descricaobreve == null && descricaocompleta != null) {
            return findByDescricaoCompleta(identity, descricaocompleta);
        } //APENAS DESCRICAOBREVE
        else if(titulo==null && descricaobreve != null && descricaocompleta == null) {
            return findByDescricaoBreve(identity, descricaobreve);
        } //APENAS TITULO
        else if(titulo!=null && descricaobreve == null && descricaocompleta == null) {
            return findByTitulo(identity, titulo);
        } // TITULO E DESCRICAOBREVE
        else if(titulo!=null && descricaobreve != null && descricaocompleta == null) {
            return findByTituloDescricaoBreve(identity, titulo, descricaobreve);
        } // TITULO E DESCRICAOCOMPLETA
        else if(titulo!=null && descricaobreve != null && descricaocompleta == null) {
            return findByTituloDescricaoCompleta(identity, titulo, descricaocompleta);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(titulo==null && descricaobreve != null && descricaocompleta != null) {
            return findByDescricaoBreveDescricaoCompleta(identity, descricaobreve, descricaocompleta);
        } // TUDO
        else if(titulo!=null && descricaobreve != null && descricaocompleta != null) {
            return findTodos(identity, titulo, descricaobreve, descricaocompleta);
        }
        return null;
    }

    public Iterable<Catalogo>findByDescricaoCompleta(Long identity, DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.identificador = :identity AND e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreve(Long identity, DescricaoBreve descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.identificador = :identity AND e.descricaoBreve = :descricaoBreve",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTitulo(Long identity, Titulo titulo){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.identificador = :identity AND e.titulo = :titulo",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoBreve(Long identity, Titulo titulo, DescricaoBreve descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.identificador = :identity AND e.titulo = :titulo AND e.descricaoBreve = :descricaoBreve",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoCompleta(Long identity, Titulo titulo, DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.identificador = :identity AND e.titulo = :titulo AND e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreveDescricaoCompleta(Long identity, DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompleta) {
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.identificador = :identity AND e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findTodos(Long identity, Titulo titulo, DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.identificador = :identity AND e.titulo = :titulo AND e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }


}
