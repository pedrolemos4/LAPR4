package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.DescricaoBreve;
import eapli.base.gestaoservicoshelpdesk.domain.DescricaoCompletaCatalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Servico;

import eapli.base.gestaoservicoshelpdesk.domain.Titulo;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

public interface ServicoRepository extends DomainRepository<CodigoUnico, Servico>, LockableDomainRepository<CodigoUnico, Servico> {
    Iterable<Servico> findServicosDoCatalogo(Long identity);

    Iterable<Servico> findAllServicos(CodigoUnico identity, Titulo titulo, DescricaoBreve descricaoBreve, DescricaoCompletaCatalogo descricaoCompletaCatalogo);
}
