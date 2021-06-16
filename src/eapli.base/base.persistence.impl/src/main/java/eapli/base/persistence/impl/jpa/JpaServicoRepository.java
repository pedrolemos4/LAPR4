package eapli.base.persistence.impl.jpa;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.FluxoAtividade;
import eapli.base.equipa.domain.CodigoUnico;
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
    public Iterable<Servico> findServicosDoCatalogo(Long identity) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT s FROM Servico s INNER JOIN s.catalogo c WHERE" +
                        " c.id =:identity",
                Servico.class);
        q.setParameter("identity", identity);
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

    @Override
    public FluxoAtividade findFluxo(String cod) {
        final TypedQuery<FluxoAtividade> q = createQuery(
                "SELECT s.fluxoAtividade FROM Pedido p JOIN p.servico s " +
                        "WHERE p.id=:cod",FluxoAtividade.class);
        q.setParameter("cod",cod);
        return  q.getSingleResult();
    }

    @Override
    public Servico findServico(String cod) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT p.servico FROM Pedido p WHERE p.Id =:cod",Servico.class);
        q.setParameter("cod",cod);
        return q.getSingleResult();
    }

    @Override
    public List<Atividade> findListAtividades(CodigoUnico idServico) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT la FROM Servico e JOIN e.fluxoAtividade fl JOIN fl.listaAtividade la WHERE e.codigoUnico=:idServico",Atividade.class);
        q.setParameter("idServico",idServico);
        return q.getResultList();
    }

    @Override
    public String findScriptServico(CodigoUnico cod) {
        final TypedQuery<String> q = createQuery("SELECT sas.caminhoScript FROM Servico s " +
                "JOIN s.fluxoAtividade fa JOIN fa.listaAtividade la JOIN la.script sas " +
                "WHERE s.codigoUnico =:codUnico AND " +
                "la.colab Is NuLl",String.class);
        q.setParameter("codUnico",cod);
        return q.getSingleResult();
    }

    @Override
    public double tempoMedioAprovacao(CodigoUnico identity){
        final TypedQuery<Double> q = createQuery("SELECT ob.tempoMedioAprov FROM Servico e JOIN e.catalogo p JOIN" +
                "p.criticidade la JOIN la.objetivo ob WHERE e.codigoUnico =:identity",Double.class);
        q.setParameter("identity",identity);
        return q.getSingleResult();
    }

    @Override
    public double tempoMedioResolucao(CodigoUnico identity){
        final TypedQuery<Double> q = createQuery("SELECT ob.tempoMedioRes FROM Servico e JOIN e.catalogo p JOIN" +
                "p.criticidade la JOIN la.objetivo ob WHERE e.codigoUnico =:identity",Double.class);
        q.setParameter("identity",identity);
        return q.getSingleResult();
    }

}
