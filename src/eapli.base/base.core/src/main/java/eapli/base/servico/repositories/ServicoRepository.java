package eapli.base.servico.repositories;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

import java.util.List;
import java.util.Set;

public interface ServicoRepository extends DomainRepository<CodigoUnico, Servico>, LockableDomainRepository<CodigoUnico, Servico> {

    Iterable<Servico> findServicosDoCatalogo(Long identity);

    List<Atividade> findTarefasServico(CodigoUnico identity, MecanographicNumber identity2, String estado);

    FluxoAtividade findFluxoServico(CodigoUnico identity);

    Iterable<Servico> findServicoByTituloDescricaoBreveDescricaoCompleta(String titulo, String descricaoBreve, String descricaoCompleta);

    Iterable<Servico> findServicoByKeywordsDescricaoBreveDescricaoCompleta(Set<String> keywords, String descricaoBreve, String descricaoCompleta);

    Iterable<Servico> findServicoByTituloKeywordsDescricaoCompleta(String titulo, Set<String> keywords, String descricaoCompleta);

    Iterable<Servico> findServicoByTituloKeywordsDescricaoBreve(String titulo, Set<String> keywords, String descricaoBreve);

    Iterable<Servico> findServicoByKeywordsdescricaoBreve(Set<String> keywords, String descricaoBreve);

    Iterable<Servico> findServicoByKeywordsDescricaoCompleta(Set<String> keywords, String descricaoCompleta);

    Iterable<Servico> findServicoByTituloKeywords(String titulo, Set<String> keywords);

    Iterable<Servico> findServicoByKeywords(Set<String> keywords);

    Iterable<Servico> findServicoByDescricaoCompleta(String descricaoCompleta);

    Iterable<Servico> findServicoByDescricaoBreve(String descricaoBreve);

    Iterable<Servico> findServicoByTitulo(String titulo);

    Iterable<Servico> findServicoByTituloDescricaoBreve(String titulo, String descricaoBreve);

    Iterable<Servico> findServicoByTituloDescricaoCompleta(String titulo, String descricaoCompleta);

    Iterable<Servico> findServicoByDescricaoBreveDescricaoCompleta(String descricaoBreve, String descricaoCompleta);

    Iterable<Servico> findServicoTodos(String titulo, Set<String> keywords, String descricaoBreve, String descricaoCompleta);

    Criticidade getCriticidade(CodigoUnico identity);

    Formulario getAssociatedFormulario(String codigoUnico);
}
