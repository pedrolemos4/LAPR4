package eapli.base.persistence.impl.jpa;

import eapli.base.gestaoservicoshelpdesk.domain.Formulario;
import eapli.base.gestaoservicoshelpdesk.repositories.FormularioRepository;

public class JpaFormularioRepository extends BasepaRepositoryBase<Formulario,Long, Long>
        implements FormularioRepository {

    public JpaFormularioRepository(){super("Id");}
}
