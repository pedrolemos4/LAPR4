package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.*;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

import java.util.Set;

public interface ServicoRepository extends DomainRepository<CodigoUnico, Servico>, LockableDomainRepository<CodigoUnico, Servico> {
    Iterable<Servico> findServicosDoCatalogo(Long identity);

    Iterable<Servico> findAllServicos(CodigoUnico identity, Titulo titulo, Set<String> keywords, DescricaoBreve descricaoBreve, DescricaoCompleta descricaoCompleta);
}
