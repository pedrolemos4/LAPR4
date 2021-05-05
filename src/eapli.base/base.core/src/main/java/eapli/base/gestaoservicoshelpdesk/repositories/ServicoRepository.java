package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.Servico;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

public interface ServicoRepository extends DomainRepository<CodigoUnico, Servico>, LockableDomainRepository<CodigoUnico, Servico> {
}
