package eapli.base.formulario.repositories;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.*;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface FormularioRepository extends DomainRepository<Long, Formulario> {

    Formulario getFormularioDoServico(CodigoUnico idServico);

    List<Atributo> findAtributos(Long id);

    Label getLabelDoAtributo(Long identity);

    Variavel getVariavelDoAtributo(Long identity);

    ExpressaoRegular getExpressaoRegularDoAtributo(Long identity);

    List<ExpressaoRegular> getListaExpressaoRegularDoFormulario(Long id);
}
