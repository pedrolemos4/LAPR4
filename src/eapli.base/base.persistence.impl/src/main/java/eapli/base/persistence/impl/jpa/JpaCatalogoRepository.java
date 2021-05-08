package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Identificador;
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
    public Iterable<Catalogo> findCatalogos(String titulo, String descricaobreve, String descricaocompleta) {
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

    public Iterable<Catalogo>findByDescricaoCompleta(String descricaocompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM CATALOGO e WHERE e.descricaocompleta = :descricaocompleta",
                Catalogo.class);
        q.setParameter("descricaocompleta", descricaocompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreve(String descricaobreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM CATALOGO e WHERE e.descricaobreve = :descricaobreve",
                Catalogo.class);
        q.setParameter("descricaobreve", descricaobreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTitulo(String titulo){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM CATALOGO e WHERE e.titulo = :titulo",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoBreve(String titulo, String descricaobreve){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM CATALOGO e WHERE e.titulo = :titulo AND e.descricaobreve = :descricaobreve",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaobreve", descricaobreve);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByTituloDescricaoCompleta(String titulo, String descricaocompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM CATALOGO e WHERE e.titulo = :titulo AND e.descricaocompleta = :descricaocompleta",
                Catalogo.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaocompleta", descricaocompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findByDescricaoBreveDescricaoCompleta(String descricaobreve, String descricaocompleta) {
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM CATALOGO e WHERE e.descricaobreve = :descricaobreve AND e.descricaocompleta = :descricaocompleta",
                Catalogo.class);
        q.setParameter("descricaobreve", descricaobreve);
        q.setParameter("descricaocompleta", descricaocompleta);
        return q.getResultList();
    }

    public Iterable<Catalogo>findTodos(String titulo, String descricaobreve, String descricaocompleta){
        final TypedQuery<Catalogo> q = createQuery(
                "SELECT e FROM CATALOGO e WHERE e.descricaobreve = :descricaobreve AND e.descricaocompleta = :descricaocompleta",
                Catalogo.class);
        q.setParameter("descricaobreve", descricaobreve);
        q.setParameter("descricaocompleta", descricaocompleta);
        return q.getResultList();
    }


}
