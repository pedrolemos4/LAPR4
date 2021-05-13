package eapli.base.persistence.impl.jpa;

import eapli.base.contrato.domain.ContratoSLA;
import eapli.base.contrato.repositories.ContratoRepository;

public class JpaContratoRepository extends BasepaRepositoryBase<ContratoSLA, Long, Long>
        implements ContratoRepository {

    public JpaContratoRepository() {
        super("Id");
    }
}
