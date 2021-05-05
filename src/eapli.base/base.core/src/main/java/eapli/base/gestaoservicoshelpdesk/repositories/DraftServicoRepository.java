package eapli.base.gestaoservicoshelpdesk.repositories;

import eapli.base.gestaoservicoshelpdesk.domain.DraftServico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.domain.repositories.LockableDomainRepository;

public interface DraftServicoRepository extends DomainRepository<String, DraftServico>, LockableDomainRepository<String,DraftServico> {
}
