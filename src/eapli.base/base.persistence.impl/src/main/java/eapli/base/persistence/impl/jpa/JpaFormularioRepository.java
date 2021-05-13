package eapli.base.persistence.impl.jpa;

import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.repositories.FormularioRepository;

public class JpaFormularioRepository extends BasepaRepositoryBase<Formulario,Long, Long>
        implements FormularioRepository {

    public JpaFormularioRepository(){super("Id");}
}
