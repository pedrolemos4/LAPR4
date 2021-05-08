package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;

import javax.persistence.TypedQuery;

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
    public Iterable<Servico> findAllServicos(CodigoUnico identity, Titulo titulo, DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompletaCatalogo) {
        //APENAS DESCRICAOCOMPLETA
        if(titulo==null && descricaoBreve == null && descricaoCompletaCatalogo != null) {
            return findByDescricaoCompleta(identity, descricaoCompletaCatalogo);
        } //APENAS DESCRICAOBREVE
        else if(titulo==null && descricaoBreve != null && descricaoCompletaCatalogo == null) {
            return findByDescricaoBreve(identity, descricaoBreve);
        } //APENAS TITULO
        else if(titulo!=null && descricaoBreve == null && descricaoCompletaCatalogo == null) {
            return findByTitulo(identity, titulo);
        } // TITULO E DESCRICAOBREVE
        else if(titulo!=null && descricaoBreve != null && descricaoCompletaCatalogo == null) {
            return findByTituloDescricaoBreve(identity, titulo, descricaoBreve);
        } // TITULO E DESCRICAOCOMPLETA
        else if(titulo!=null && descricaoBreve != null && descricaoCompletaCatalogo == null) {
            return findByTituloDescricaoCompleta(identity, titulo, descricaoCompletaCatalogo);
        } // DESCRICAOBREVE E DESCRICAOCOMPLETA
        else if(titulo==null && descricaoBreve != null && descricaoCompletaCatalogo != null) {
            return findByDescricaoBreveDescricaoCompleta(identity, descricaoBreve, descricaoCompletaCatalogo);
        } // TUDO
        else if(titulo!=null && descricaoBreve != null && descricaoCompletaCatalogo != null) {
            return findTodos(identity, titulo, descricaoBreve, descricaoCompletaCatalogo);
        }
        return null;
    }

    public Iterable<Servico>findByDescricaoCompleta(CodigoUnico identity, DescricaoCompletaCatalogo descricaoCompleta){
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

    public Iterable<Servico>findByTituloDescricaoCompleta(CodigoUnico identity, Titulo titulo, DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.titulo = :titulo AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findByDescricaoBreveDescricaoCompleta(CodigoUnico identity, DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompleta) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e WHERE e.codigoUnico = :identity AND e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }

    public Iterable<Servico>findTodos(CodigoUnico identity, Titulo titulo, DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompleta){
        final TypedQuery<Servico> q = createQuery(
                "SELECT e FROM Servico e e.codigoUnico = :identity AND WHERE e.titulo = :titulo AND e.descricaoBreve = :descricaoBreve AND e.descricaoCompleta = :descricaoCompleta",
                Servico.class);
        q.setParameter("identity", identity);
        q.setParameter("titulo", titulo);
        q.setParameter("descricaoBreve", descricaoBreve);
        q.setParameter("descricaoCompleta", descricaoCompleta);
        return q.getResultList();
    }




}
