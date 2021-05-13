package eapli.base.utilizador.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.HashSet;
import java.util.Set;

public class ListCatalogoServicoController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private CatalogoRepository catRepo = PersistenceContext.repositories().catalogo();
    private ColaboradorRepository colabRepo= PersistenceContext.repositories().colaborador();
    private EquipaRepository equipaRepo= PersistenceContext.repositories().equipas();
    private ServicoRepository servicoRepo= PersistenceContext.repositories().servicos();

    private SystemUser currentUser() {
        return authz.session().get().authenticatedUser();
    }

    public Iterable<Catalogo> findByTitulo(final String titulo){
        return catRepo.findByTitulo(titulo);
    }

    public Iterable<Catalogo> findByDescricaoCompleta(final String descricaoCompleta){
        return catRepo.findByDescricaoCompleta(descricaoCompleta);
    }

    public Iterable<Catalogo> findByDescricaoBreve(final String descricaoBreve){
        return catRepo.findByDescricaoBreve(descricaoBreve);
    }

    public Iterable<Catalogo> findByTituloDescricaoBreve(final String titulo, final String descricaoBreve){
        return catRepo.findByTituloDescricaoBreve(titulo, descricaoBreve);
    }

    public Iterable<Catalogo> findByTituloDescricaoCompleta(final String titulo, final String descricaoCompleta){
        return catRepo.findByTituloDescricaoCompleta(titulo, descricaoCompleta);
    }

    public Iterable<Catalogo> findByDescricaoBreveDescricaoCompleta(final String descricaoBreve, final String descricaoCompleta){
        return catRepo.findByDescricaoBreveDescricaoCompleta(descricaoBreve, descricaoCompleta);
    }

    public Iterable<Catalogo> findTodos(final String titulo, final String descricaoBreve, final String descricaoCompleta){
        return catRepo.findTodos(titulo, descricaoBreve, descricaoCompleta);
    }

    public Iterable<Servico> findServicoByTituloDescricaoBreveDescricaoCompleta(final String titulo, final String descricaoBreve, final String descricaoCompleta){
        return servicoRepo.findServicoByTituloDescricaoBreveDescricaoCompleta(titulo, descricaoBreve, descricaoCompleta);
    }

    public Iterable<Servico> findServicoByKeywordsDescricaoBreveDescricaoCompleta(Set<String> keywords, final String descricaoBreve, final String descricaoCompleta){
        return servicoRepo.findServicoByKeywordsDescricaoBreveDescricaoCompleta(keywords, descricaoBreve, descricaoCompleta);
    }

    public Iterable<Servico> findServicoByTituloKeywordsDescricaoCompleta(final String titulo, Set<String> keywords, final String descricaoCompleta){
        return servicoRepo.findServicoByTituloKeywordsDescricaoCompleta(titulo, keywords, descricaoCompleta);
    }

    public Iterable<Servico> findServicoByTituloKeywordsDescricaoBreve(final String titulo, Set<String> keywords, final String descricaoBreve){
        return servicoRepo.findServicoByTituloKeywordsDescricaoBreve(titulo, keywords, descricaoBreve);
    }

    public Iterable<Servico> findServicoByKeywordsdescricaoBreve(Set<String> keywords, final String descricaoBreve){
        return servicoRepo.findServicoByKeywordsdescricaoBreve(keywords, descricaoBreve);
    }

    public Iterable<Servico> findServicoByKeywordsDescricaoCompleta(Set<String> keywords, final String descricaoCompleta){
        return servicoRepo.findServicoByKeywordsDescricaoCompleta(keywords, descricaoCompleta);
    }

    public Iterable<Servico> findServicoByTituloKeywords(final String titulo, Set<String> keywords){
        return servicoRepo.findServicoByTituloKeywords(titulo, keywords);
    }

    public Iterable<Servico> findServicoByKeywords(Set<String> keywords){
        return servicoRepo.findServicoByKeywords(keywords);
    }

    public Iterable<Servico> findServicoByDescricaoCompleta(final String descricaoCompleta){
        return servicoRepo.findServicoByDescricaoCompleta(descricaoCompleta);
    }

    public Iterable<Servico> findServicoByDescricaoBreve(final String descricaoBreve){
        return servicoRepo.findServicoByDescricaoBreve(descricaoBreve);
    }

    public Iterable<Servico> findServicoByTitulo(final String titulo){
        return servicoRepo.findServicoByTitulo(titulo);
    }

    public Iterable<Servico> findServicoByTituloDescricaoBreve(final String titulo, final String descricaoBreve){
        return servicoRepo.findServicoByTituloDescricaoBreve(titulo, descricaoBreve);
    }

    public Iterable<Servico> findServicoByTituloDescricaoCompleta(final String titulo, final String descricaoCompleta){
        return servicoRepo.findServicoByTituloDescricaoCompleta(titulo, descricaoCompleta);
    }

    public Iterable<Servico> findServicoByDescricaoBreveDescricaoCompleta(final String descricaoBreve, final String descricaoCompleta){
        return servicoRepo.findServicoByDescricaoBreveDescricaoCompleta(descricaoBreve, descricaoCompleta);
    }

    public Iterable<Servico> findServicoTodos(final String titulo, Set<String> keywords, final String descricaoBreve, final String descricaoCompleta){
        return servicoRepo.findServicoTodos(titulo, keywords, descricaoBreve, descricaoCompleta);
    }

    public Colaborador getUser(){
        final SystemUser user = currentUser();
        EmailAddress email = user.email();
        return this.colabRepo.findEmailColaborador(email);
    }

    public Set<Equipa> getEquipasDoUser(MecanographicNumber number){
        final Iterable<Equipa> equipaUser =  equipaRepo.findByColaborador(number);
        Set<Equipa> list1 = new HashSet<>();
        for (Equipa eq : equipaUser) {
            list1.add(eq);
        }
        return list1;
    }

    public Iterable<Catalogo> findAllCatalogos() {
        return this.catRepo.findAll();
    }

    public boolean findEquipaDoCatalogo(Long identity, MecanographicNumber number) {
        return this.equipaRepo.findEquipaDoCatalogo(identity, number);
    }

    public Iterable<Servico> findServicosDoCatalogo(Long identity) {
        return this.servicoRepo.findServicosDoCatalogo(identity);
    }
}