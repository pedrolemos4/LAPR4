package eapli.base.gestaoservicosrh.repositories;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface EquipaRepository extends DomainRepository<CodigoUnico, Equipa> {

    Iterable<Equipa> findByColaborador(MecanographicNumber colab);

    Iterable<Equipa> findEquipaDoCatalogo(Long identity);

    Equipa validate(TipoEquipa tipo, MecanographicNumber identity);


}
