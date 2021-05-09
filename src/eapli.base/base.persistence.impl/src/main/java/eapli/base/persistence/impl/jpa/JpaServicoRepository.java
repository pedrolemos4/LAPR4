package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;

import javax.persistence.TypedQuery;
import java.util.Set;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Long, CodigoUnico> implements ServicoRepository {

    public JpaServicoRepository() {
        super("Codigo Unico");
    }

    @Override
    public Iterable<Servico> findServicosDoCatalogo(Long identity) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT ec FROM Catalogo e JOIN e.listServicos ec WHERE" +
                        " e.identificador =:identity",
                Servico.class);
        q.setParameter("identity", identity);
        return q.getResultList();
    }

    @Override
    public Iterable<Servico> findAllServicos(CodigoUnico identity, Titulo titulo,Set<String> keywords, DescricaoBreve descricaoBreve, DescricaoCompleta descricaoCompleta) {
        //APENAS DESCRICAOCOMPLETA
        if(titulo==null && keywords == null && descricaoBreve == null && descricaoCompleta != null) {
            return findByDescricaoCompleta(identity, descricaoCompleta);
        } //APENAS DESCRICAOBREVE
        else if(titulo==null && keywords == null && descricaoBreve != null && descricaoCompleta == null) {
            return findByDescricaoBreve(identity, descricaoBreve);
        } //APENAS TITULO
        else if(titulo!=null && keywords == null && descricaoBreve == null && descricaoCompleta == null) {
            return findByTitulo(identity, titulo);
        }//APENAS KEYWORDS
        else if(titulo==null && keywords != null && descricaoBreve == null && descricaoCompleta == null) {
            return findByKeywords(identity, keywords);
        } // TITULO E DESCRICAOBREVE
        else if(titulo!=null && keywords == null && descricaoBreve != null && descricaoCompleta == null) {
            return findByTituloDescricaoBreve(identity, titulo, descricaoBreve);
        } // TITULO E DESCRICAOCOMPLETA
        else if(titulo!=null && keywords == null && descricaoBreve != null && descricaoCompleta == null) {
            return findByTituloDescricaoCompleta(identity, titulo, descricaoCompleta);
        } // TITULO E KEYWORDS
        else if(titulo!=null && keywords != null && descricaoBreve != null && descricaoCompleta == null) {
            return findByTituloKeywords(identity, titulo, keywords);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(titulo==null && keywords == null && descricaoBreve != null && descricaoCompleta != null) {
            return findByDescricaoBreveDescricaoCompleta(identity, descricaoBreve, descricaoCompleta);
        }// KEYWORDS E DESCRICAOCOMPLETA
        else if(titulo==null && keywords != null && descricaoBreve == null && descricaoCompleta != null) {
            return findByKeywordsDescricaoCompleta(identity, keywords, descricaoCompleta);
        }// KEYWORDS E DESCRICAOBREVE
        else if(titulo==null && keywords != null && descricaoBreve != null && descricaoCompleta == null) {
            return findByKeywordsdescricaoBreve(identity, keywords, descricaoBreve);
        } // TITULO E DESCRICAOBREVE E KEYWORDS
        else if(titulo!=null && keywords != null && descricaoBreve != null && descricaoCompleta == null) {
            return findByTituloKeywordsDescricaoBreve(identity, titulo, keywords, descricaoBreve);
        } // TITULO E DESCRICAOCOMPLETA E KEYWORDS
        else if(titulo!=null && keywords != null && descricaoBreve == null && descricaoCompleta != null) {
            return findByTituloKeywordsDescricaoCompleta(identity, titulo, keywords, descricaoCompleta);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA E KEYWORDS
        else if(titulo==null && keywords != null && descricaoBreve != null && descricaoCompleta != null) {
            return findByKeywordsDescricaoBreveDescricaoCompleta(identity, keywords, descricaoBreve, descricaoCompleta);
        }// TITULO E DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(titulo!=null && keywords == null && descricaoBreve != null && descricaoCompleta != null) {
            return findByTituloDescricaoBreveDescricaoCompleta(identity, titulo, descricaoBreve, descricaoCompleta);
        } // TITULO E DESCRICAOBREVE E DESCRICAOCOMPLETA E KEYWORDS
        else if(titulo!=null && keywords != null && descricaoBreve != null && descricaoCompleta != null) {
            return findTodos(identity, titulo, keywords, descricaoBreve, descricaoCompleta);
        }
        return null;
    }

    private Iterable<Servico> findByTituloDescricaoBreveDescricaoCompleta(CodigoUnico identity, Titulo titulo, DescricaoBreve descricaoBreve, DescricaoCompleta descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e e.codigoUnico = :identity AND WHERE e.titulo = :titulo AND" +
                        " e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywordsDescricaoBreveDescricaoCompleta(CodigoUnico identity, Set<String> keywords, DescricaoBreve descricaoBreve, DescricaoCompleta descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k WHERE e.codigoUnico = :identity " +
                        "AND k.keywords = :keywords AND e.descricaoBreve = :descricaoBreve" +
                        "AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByTituloKeywordsDescricaoCompleta(CodigoUnico identity, Titulo titulo, Set<String> keywords, DescricaoCompleta descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k WHERE e.codigoUnico = :identity AND e.titulo = :titulo" +
                        "AND k.keywords = :keywords AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByTituloKeywordsDescricaoBreve(CodigoUnico identity, Titulo titulo, Set<String> keywords, DescricaoBreve descricaoBreve) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k WHERE e.codigoUnico = :identity AND e.titulo = :titulo" +
                        "AND k.keywords = :keywords AND e.descricaoBreve = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywordsdescricaoBreve(CodigoUnico identity, Set<String> keywords, DescricaoBreve descricaoBreve) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k WHERE e.codigoUnico = :identity " +
                        "AND k.keywords = :keywords AND e.descricaoBreve = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywordsDescricaoCompleta(CodigoUnico identity, Set<String> keywords, DescricaoCompleta descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k WHERE e.codigoUnico = :identity " +
                        "AND k.keywords = :keywords AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByTituloKeywords(CodigoUnico identity, Titulo titulo, Set<String> keywords) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k WHERE e.codigoUnico = :identity " +
                        "AND k.keywords = :keywords AND e.titulo = :titulo",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywords(CodigoUnico identity, Set<String> keywords) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k WHERE e.codigoUnico = :identity " +
                        "AND k.keywords = :keywords",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        return q.getResultList();
    }

    public Iterable<Servico>findByDescricaoCompleta(CodigoUnico identity, DescricaoCompleta descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND" +
                        " e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findByDescricaoBreve(CodigoUnico identity, DescricaoBreve descricaoBreve){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.descricaoBreve = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico>findByTitulo(CodigoUnico identity, Titulo titulo){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.titulo = :titulo",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Servico>findByTituloDescricaoBreve(CodigoUnico identity, Titulo titulo, DescricaoBreve descricaoBreve){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.titulo = :titulo AND e.descricaoBreve = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico>findByTituloDescricaoCompleta(CodigoUnico identity, Titulo titulo, DescricaoCompleta descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.titulo = :titulo AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findByDescricaoBreveDescricaoCompleta(CodigoUnico identity, DescricaoBreve descricaoBreve, DescricaoCompleta descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findTodos(CodigoUnico identity, Titulo titulo, Set<String> keywords, DescricaoBreve descricaoBreve, DescricaoCompleta descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.titulo = :titulo AND" +
                        " k.keywords = :keywords AND e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }




}
