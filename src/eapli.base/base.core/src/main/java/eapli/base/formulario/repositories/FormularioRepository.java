package eapli.base.formulario.repositories;

import eapli.base.formulario.domain.Formulario;
import eapli.framework.domain.repositories.DomainRepository;

public interface FormularioRepository extends DomainRepository<Long, Formulario> {

    Formulario getFormularioDoServico(String idServico);
}
