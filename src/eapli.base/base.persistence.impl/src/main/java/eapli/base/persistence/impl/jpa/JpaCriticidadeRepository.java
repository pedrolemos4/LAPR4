package eapli.base.persistence.impl.jpa;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.repositories.CriticidadeRepository;

public class JpaCriticidadeRepository extends BasepaRepositoryBase<Criticidade, Long, Long>
        implements CriticidadeRepository {

    public JpaCriticidadeRepository() {
        super("Id");
    }

}
