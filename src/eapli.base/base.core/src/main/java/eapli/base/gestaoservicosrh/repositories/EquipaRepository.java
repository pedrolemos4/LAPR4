package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface EquipaRepository extends DomainRepository<CodigoUnico, Equipa> {

    Iterable<Equipa> findByColaborador(MecanographicNumber colab);

    boolean findEquipaDoCatalogo(Long identity, MecanographicNumber number);

    Equipa validate(TipoEquipa tipo, MecanographicNumber identity);

    Equipa findByTipoEquipa(CodigoUnico identity, TipoEquipa tipo);

    List<Equipa> findAll();
}
