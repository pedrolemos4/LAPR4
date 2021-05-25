package eapli.base.servico.repositories;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Formulario;
import eapli.base.pedido.domain.Identificador;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface ServicoRepository extends DomainRepository<CodigoUnico, Servico>, LockableDomainRepository<CodigoUnico, Servico> {

    Iterable<Servico> findServicosDoCatalogo(Long identity);

    List<Atividade> findTarefasServico(Long identity, MecanographicNumber identity2, String estado);

    Long findFluxoServico(String identity);

    String findPedidoServico(Identificador identity);

    List<Atividade> filtrarData(Long identity, MecanographicNumber identity2, Calendar dataI, Calendar dataF, String estado);

    List<Atividade> ordenarCritCrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

    List<Atividade> ordenarCritDecrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

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

    Formulario getAssociatedFormulario(String codigoUnico);
}
