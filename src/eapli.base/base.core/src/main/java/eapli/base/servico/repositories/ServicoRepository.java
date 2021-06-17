package eapli.base.servico.repositories;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.FluxoAtividade;
import eapli.base.atividade.domain.Script;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

import java.util.List;
import java.util.Set;

public interface ServicoRepository extends DomainRepository<CodigoUnico, Servico>, LockableDomainRepository<CodigoUnico, Servico> {

    Iterable<Servico> findServicosDoCatalogo(Long identity);

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

    FluxoAtividade findFluxo(String cod);

    Servico findServico(String cod);

    List<Atividade> findListAtividades(CodigoUnico idServico);

    String findCaminhoScriptServico(CodigoUnico cod);

    Script findScriptServico(CodigoUnico cod);

    double tempoMedioResolucao(CodigoUnico identity);

    double tempoMedioAprovacao(CodigoUnico identity);

    Colaborador findColabResponsavel(Long identity);
}
