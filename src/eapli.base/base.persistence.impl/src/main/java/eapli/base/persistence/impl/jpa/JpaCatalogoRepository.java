package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Calendar;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Long, Long> implements CatalogoRepository {

    public JpaCatalogoRepository() {
        super("Identificador");
    }

    @Override
    public Iterable<Catalogo> findCatalogos(Titulo titulo, DescricaoBreve descricaobreve, DescricaoCompletaCatalogo descricaocompleta) {
        //APENAS DESCRICAOCOMPLETA
        if(titulo==null && descricaobreve == null && descricaocompleta != null) {
            return findByDescricaoCompleta(descricaocompleta);
        } //APENAS DESCRICAOBREVE
        else if(titulo==null && descricaobreve != null && descricaocompleta == null) {
            return findByDescricaoBreve(descricaobreve);
        } //APENAS TITULO
        else if(titulo!=null && descricaobreve == null && descricaocompleta == null) {
            return findByTitulo(titulo);
        } // TITULO E DESCRICAOBREVE
        else if(titulo!=null && descricaobreve != null && descricaocompleta == null) {
            return findByTituloDescricaoBreve(titulo, descricaobreve);
        } // TITULO E DESCRICAOCOMPLETA
        else if(titulo!=null && descricaobreve != null && descricaocompleta == null) {
            return findByTituloDescricaoCompleta(titulo, descricaocompleta);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(titulo==null && descricaobreve != null && descricaocompleta != null) {
            return findByDescricaoBreveDescricaoCompleta(descricaobreve, descricaocompleta);
        } // TUDO
        else if(titulo!=null && descricaobreve != null && descricaocompleta != null) {
            return findTodos(titulo, descricaobreve, descricaocompleta);
        }
        return null;
    }

    public Iterable<Catalogo>findByDescricaoCompleta(DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreve(DescricaoBreve descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.descricaoBreve = :descricaoBreve",
                Catalogo.class);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTitulo(Titulo titulo){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.titulo = :titulo",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoBreve(Titulo titulo, DescricaoBreve descricaoBreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.titulo = :titulo AND e.descricaoBreve = :descricaoBreve",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoCompleta(Titulo titulo, DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.titulo = :titulo AND e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreveDescricaoCompleta(DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompleta) {
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findTodos(Titulo titulo, DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM Catalogo e WHERE e.titulo = :titulo AND e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }


}
