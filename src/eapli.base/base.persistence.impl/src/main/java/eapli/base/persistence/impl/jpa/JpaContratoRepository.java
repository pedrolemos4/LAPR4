package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.ContratoSLA;
import eapli.base.gestaoservicoshelpdesk.repositories.ContratoRepository;

public class JpaContratoRepository extends BasepaRepositoryBase<ContratoSLA, Long, Long>
        implements ContratoRepository {

    public JpaContratoRepository() {
        super("Id");
    }
}
