package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.Criticidade;
import eapli.base.gestaoservicoshelpdesk.repositories.CriticidadeRepository;

public class JpaCriticidadeRepository extends BasepaRepositoryBase<Criticidade, Long, Long>
        implements CriticidadeRepository {

    public JpaCriticidadeRepository() {
        super("Id");
    }

}
