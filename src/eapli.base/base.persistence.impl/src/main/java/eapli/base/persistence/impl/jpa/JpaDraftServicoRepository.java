package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.DraftServico;
import eapli.base.gestaoservicoshelpdesk.repositories.DraftServicoRepository;

public class JpaDraftServicoRepository extends BasepaRepositoryBase<DraftServico, Long, String>
        implements DraftServicoRepository {

    public JpaDraftServicoRepository() {
        super("Codigo Unico");
    }
}
