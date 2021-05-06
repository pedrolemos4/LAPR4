package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Long, CodigoUnico> implements ServicoRepository {

    public JpaServicoRepository() {
        super("Codigo Unico");
    }
}
