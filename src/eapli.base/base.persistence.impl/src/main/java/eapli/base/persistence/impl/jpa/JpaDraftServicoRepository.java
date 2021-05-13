package eapli.base.persistence.impl.jpa;

import eapli.base.draft.domain.DraftServico;
import eapli.base.draft.repositories.DraftServicoRepository;

public class JpaDraftServicoRepository extends BasepaRepositoryBase<DraftServico, Long, String>
        implements DraftServicoRepository {

    public JpaDraftServicoRepository() {
        super("Codigo Unico");
    }
}
