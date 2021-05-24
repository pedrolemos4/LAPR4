package eapli.base.persistence.impl.jpa;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Long, CodigoUnico> implements ServicoRepository {

    public JpaServicoRepository() {
        super("codigoUnico");
    }

    @Override
    public Criticidade getCriticidade(CodigoUnico identity) {
        final TypedQuery<Criticidade> q = createQuery(
                "SELECT c FROM SERVICO s INNER JOIN c.SERVICO s WHERE s.codigoUnico =: identity",
                Criticidade.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public Formulario getAssociatedFormulario(String codigoUnico) {
        final TypedQuery<Formulario> q = createQuery(
                "SELECT c FROM Servico s INNER JOIN s.Formulario c WHERE s.codigoUnico =: identity",
                Formulario.class);
        q.setParameter("identity", codigoUnico);
        return q.getSingleResult();
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

    public FluxoAtividade findFluxoServico(CodigoUnico identity) {
        final TypedQuery<FluxoAtividade> q = createQuery(
                "SELECT fl FROM Fluxo fl WHERE" +
                        " fl.servico =:identity",
                FluxoAtividade.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    public List<Atividade> findTarefasServico(CodigoUnico identity, MecanographicNumber identity2, String estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Atividade a INNER JOIN a.fluxo fl WHERE" +
                       " fl.identificador =:identity AND" + " a.colaborador =:identity2 AND"
                        + " a.estado like =:estado",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("identity2", identity2);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByTituloDescricaoBreveDescricaoCompleta(String titulo, String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db INNER JOIN e.descricaoCompleta dc" +
                        " WHERE ec.titulo = :titulo AND" +
                        " db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByKeywordsDescricaoBreveDescricaoCompleta(Set<String> keywords, String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.descricaoBreve db INNER JOIN e.descricaoCompleta dc " +
                        "WHERE k = :keywords AND db.value = :descricaoBreve " +
                        "AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByTituloKeywordsDescricaoCompleta(String titulo, Set<String> keywords, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.titulo t INNER JOIN e.descricaoCompleta db" +
                        "WHERE t.titulo = :titulo " +
                        "AND k = :keywords AND db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByTituloKeywordsDescricaoBreve(String titulo, Set<String> keywords, String descricaoBreve) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "WHERE ec.titulo = :titulo " +
                        "AND k = :keywords AND db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByKeywordsdescricaoBreve(Set<String> keywords, String descricaoBreve) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.descricaoBreve db " +
                        "WHERE k = :keywords AND db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByKeywordsDescricaoCompleta(Set<String> keywords, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k INNER JOIN e.descricaoCompleta db " +
                        "WHERE k = :keywords AND db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByTituloKeywords(String titulo, Set<String> keywords) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e JOIN e.keywords k INNER JOIN e.titulo ec WHERE " +
                        "k = :keywords AND ec.titulo = :titulo",
                Servico.class);
        q.setParameter("keywords", keywords);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Servico> findServicoByKeywords(Set<String> keywords) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords k WHERE " +
                        "k = :keywords",
                Servico.class);
        q.setParameter("keywords", keywords);
        return q.getResultList();
    }

    public Iterable<Servico>findServicoByDescricaoCompleta(String descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.descricaoCompleta db WHERE" +
                        " db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findServicoByDescricaoBreve(String descricaoBreve){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.descricaoBreve db " +
                        "WHERE db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico>findServicoByTitulo(String titulo){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo db WHERE db.titulo = :titulo",
                Servico.class);
        q.setParameter("titulo", titulo);
        return q.getResultList();
    }

    public Iterable<Servico>findServicoByTituloDescricaoBreve(String titulo, String descricaoBreve){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "WHERE ec.titulo = :titulo AND db.value = :descricaoBreve",
                Servico.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        return q.getResultList();
    }

    public Iterable<Servico>findServicoByTituloDescricaoCompleta(String titulo, String descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.titulo ec INNER JOIN e.descricaoCompleta db " +
                        "WHERE ec.titulo = :titulo AND db.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findServicoByDescricaoBreveDescricaoCompleta(String descricaoBreve, String descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.descricaoBreve db INNER JOIN e.descricaoCompleta dc " +
                        "WHERE db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findServicoTodos(String titulo, Set<String> keywords, String descricaoBreve, String descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e INNER JOIN e.keywords le INNER JOIN e.titulo ec INNER JOIN e.descricaoBreve db " +
                        "INNER JOIN e.descricaoCompleta dc WHERE ec.titulo = :titulo AND" +
                        " le = :keywords AND db.value = :descricaoBreve AND dc.value = :descricaoCompleta",
                Servico.class);
        q.setParameter("titulo", titulo);
        q.setParameter("keywords", keywords);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

}
