package eapli.base.formulario.repositories;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface FormularioRepository extends DomainRepository<Long, Formulario> {

    Formulario getFormularioDoServico(CodigoUnico idServico);

    List<Atributo> findAtributos(Long id);

}
