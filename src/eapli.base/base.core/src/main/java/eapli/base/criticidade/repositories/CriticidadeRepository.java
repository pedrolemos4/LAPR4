package eapli.base.criticidade.repositories;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.Etiqueta;
import eapli.framework.domain.repositories.DomainRepository;

public interface CriticidadeRepository extends DomainRepository<Long, Criticidade> {

    Criticidade findByTag(Etiqueta etiqueta);

    Criticidade getCriticidadeDoCatalogo(Long identity);
}
