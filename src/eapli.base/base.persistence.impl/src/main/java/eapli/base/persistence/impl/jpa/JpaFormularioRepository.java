package eapli.base.persistence.impl.jpa;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.repositories.FormularioRepository;

import javax.persistence.TypedQuery;

public class JpaFormularioRepository extends BasepaRepositoryBase<Formulario,Long, Long>
        implements FormularioRepository {

    public JpaFormularioRepository(){super("Id");}

    @Override
    public Formulario getFormularioDoServico(String idServico) {
        final TypedQuery<Formulario> q = createQuery(
                "SELECT f FROM Formulario f INNER JOIN f.servico s WHERE" +
                        " s.codigoUnico =:identity",
                Formulario.class);
        q.setParameter("identity", new CodigoUnico(idServico));
        return q.getSingleResult();
    }
}
