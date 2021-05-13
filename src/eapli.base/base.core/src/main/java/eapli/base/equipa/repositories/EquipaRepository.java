package eapli.base.equipa.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface EquipaRepository extends DomainRepository<CodigoUnico, Equipa> {

    Iterable<Equipa> findByColaborador(MecanographicNumber colab);

    boolean findEquipaDoCatalogo(Long identity, MecanographicNumber number);

    Equipa validate(TipoEquipa tipo, MecanographicNumber identity);

    Equipa findByTipoEquipa(CodigoUnico identity, TipoEquipa tipo);

    List<Equipa> findAll();
}
