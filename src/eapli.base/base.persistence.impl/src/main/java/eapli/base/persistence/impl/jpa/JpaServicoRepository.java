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
    public Iterable<Servico> findAllServicos(CodigoUnico identity, String titulo,Set<String> keywords, String descricaoBreve, String descricaoCompleta) {
        //APENAS DESCRICAOCOMPLETA
        if(titulo.isEmpty() && keywords.isEmpty() && descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findByDescricaoCompleta(identity, descricaoCompleta);
        } //APENAS DESCRICAOBREVE
        else if(titulo.isEmpty() && keywords.isEmpty() && !descricaoBreve.isEmpty() && descricaoCompleta.isEmpty()) {
            return findByDescricaoBreve(identity, descricaoBreve);
        } //APENAS TITULO
        else if(!titulo.isEmpty() && keywords.isEmpty() && descricaoBreve.isEmpty() && descricaoCompleta.isEmpty()) {
            return findByTitulo(identity, titulo);
        }//APENAS KEYWORDS
        else if(titulo.isEmpty() && !keywords.isEmpty() && descricaoBreve.isEmpty() && descricaoCompleta.isEmpty()) {
            return findByKeywords(identity, keywords);
        } // TITULO E DESCRICAOBREVE
        else if(!titulo.isEmpty() && keywords.isEmpty() && !descricaoBreve.isEmpty() && descricaoCompleta.isEmpty()) {
            return findByTituloDescricaoBreve(identity, titulo, descricaoBreve);
        } // TITULO E DESCRICAOCOMPLETA
        else if(!titulo.isEmpty() && keywords.isEmpty() && descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findByTituloDescricaoCompleta(identity, titulo, descricaoCompleta);
        } // TITULO E KEYWORDS
        else if(!titulo.isEmpty() && !keywords.isEmpty() && descricaoBreve.isEmpty() && descricaoCompleta.isEmpty()) {
            return findByTituloKeywords(identity, titulo, keywords);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(titulo.isEmpty() && keywords.isEmpty() && !descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findByDescricaoBreveDescricaoCompleta(identity, descricaoBreve, descricaoCompleta);
        }// KEYWORDS E DESCRICAOCOMPLETA
        else if(titulo.isEmpty() && !keywords.isEmpty() && descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findByKeywordsDescricaoCompleta(identity, keywords, descricaoCompleta);
        }// KEYWORDS E DESCRICAOBREVE
        else if(titulo.isEmpty() && !keywords.isEmpty() && !descricaoBreve.isEmpty() && descricaoCompleta.isEmpty()) {
            return findByKeywordsdescricaoBreve(identity, keywords, descricaoBreve);
        } // TITULO E DESCRICAOBREVE E KEYWORDS
        else if(!titulo.isEmpty() && !keywords.isEmpty() && !descricaoBreve.isEmpty() && descricaoCompleta.isEmpty()) {
            return findByTituloKeywordsDescricaoBreve(identity, titulo, keywords, descricaoBreve);
        } // TITULO E DESCRICAOCOMPLETA E KEYWORDS
        else if(!titulo.isEmpty() && !keywords.isEmpty() && descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findByTituloKeywordsDescricaoCompleta(identity, titulo, keywords, descricaoCompleta);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA E KEYWORDS
        else if(titulo.isEmpty() && !keywords.isEmpty() && !descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findByKeywordsDescricaoBreveDescricaoCompleta(identity, keywords, descricaoBreve, descricaoCompleta);
        }// TITULO E DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(!titulo.isEmpty() && keywords.isEmpty() && !descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findByTituloDescricaoBreveDescricaoCompleta(identity, titulo, descricaoBreve, descricaoCompleta);
        } // TITULO E DESCRICAOBREVE E DESCRICAOCOMPLETA E KEYWORDS
        else if(!titulo.isEmpty() && !keywords.isEmpty() && !descricaoBreve.isEmpty() && !descricaoCompleta.isEmpty()) {
            return findTodos(identity, titulo, keywords, descricaoBreve, descricaoCompleta);
        }
        return null;
    }

    private Iterable<Servico> findByTituloDescricaoBreveDescricaoCompleta(CodigoUnico identity, String titulo, String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db INNER JOIN e.descricaoCompleta dc" +
                        " WHERE e.codigoUnico = :identity AND ec.titulo = :titulo AND" +
                        " db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywordsDescricaoBreveDescricaoCompleta(CodigoUnico identity, Set<String> keywords, String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.descricaoBreve db INNER JOIN e.descricaoCompleta dc " +
                        "WHERE e.codigoUnico = :identity AND k = :keywords AND db.value = :descricaoBreve" +
                        "AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByTituloKeywordsDescricaoCompleta(CodigoUnico identity, String titulo, Set<String> keywords, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.titulo t INNER JOIN e.descricaoCompleta db" +
                        "WHERE e.codigoUnico = :identity AND t.titulo = :titulo" +
                        "AND k = :keywords AND db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByTituloKeywordsDescricaoBreve(CodigoUnico identity, String titulo, Set<String> keywords, String descricaoBreve) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "WHERE e.codigoUnico = :identity AND ec.titulo = :titulo" +
                        "AND k = :keywords AND db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywordsdescricaoBreve(CodigoUnico identity, Set<String> keywords, String descricaoBreve) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.descricaoBreve db " +
                        "WHERE e.codigoUnico = :identity " +
                        "AND k = :keywords AND db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywordsDescricaoCompleta(CodigoUnico identity, Set<String> keywords, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.descricaoCompleta db " +
                        "WHERE e.codigoUnico = :identity " +
                        "AND k = :keywords AND db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    private Iterable<Servico> findByTituloKeywords(CodigoUnico identity, String titulo, Set<String> keywords) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k INNER JOIN e.titulo ec WHERE e.codigoUnico = :identity " +
                        "AND k = :keywords AND ec.titulo = :titulo",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    private Iterable<Servico> findByKeywords(CodigoUnico identity, Set<String> keywords) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k WHERE e.codigoUnico = :identity " +
                        "AND k = :keywords",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("keywords", keywords);
        return q.getResultList();
    }

    public Iterable<Servico>findByDescricaoCompleta(CodigoUnico identity, String descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.descricaoCompleta db WHERE e.codigoUnico = :identity AND" +
                        " db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findByDescricaoBreve(CodigoUnico identity, String descricaoBreve){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.descricaoBreve db " +
                        "WHERE e.codigoUnico = :identity AND db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico>findByTitulo(CodigoUnico identity, String titulo){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo db WHERE e.codigoUnico = :identity AND db.titulo = :titulo",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Servico>findByTituloDescricaoBreve(CodigoUnico identity, String titulo, String descricaoBreve){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "WHERE e.codigoUnico = :identity AND ec.titulo = :titulo AND db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico>findByTituloDescricaoCompleta(CodigoUnico identity, String titulo, String descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo ec INNER JOIN e.descricaoCompleta db " +
                        "WHERE e.codigoUnico = :identity AND ec.titulo = :titulo AND db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findByDescricaoBreveDescricaoCompleta(CodigoUnico identity, String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.descricaoBreve db INNER JOIN e.descricaoCompleta dc " +
                        "WHERE e.codigoUnico = :identity AND db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findTodos(CodigoUnico identity, String titulo, Set<String> keywords, String descricaoBreve, String descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords le INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "INNER JOIN e.descricaoCompleta dc WHERE e.codigoUnico = :identity AND ec.titulo = :titulo AND" +
                        " le = :keywords AND db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

}
