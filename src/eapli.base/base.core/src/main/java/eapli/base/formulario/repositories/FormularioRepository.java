package eapli.base.formulario.repositories;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Formulario;
import eapli.framework.domain.repositories.DomainRepository;

public interface FormularioRepository extends DomainRepository<Long, Formulario> {

    Formulario getFormularioDoServico(CodigoUnico idServico);
}
