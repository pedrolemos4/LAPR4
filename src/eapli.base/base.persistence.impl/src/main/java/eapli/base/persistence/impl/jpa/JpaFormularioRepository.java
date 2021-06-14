package eapli.base.persistence.impl.jpa;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Label;
import eapli.base.formulario.repositories.FormularioRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class JpaFormularioRepository extends BasepaRepositoryBase<Formulario,Long, Long>
        implements FormularioRepository {

    public JpaFormularioRepository(){super("Id");}

    @Override
    public Formulario getFormularioDoServico(CodigoUnico idServico) {
        final TypedQuery<Formulario> q = createQuery(
                "SELECT f FROM Formulario f INNER JOIN f.servico s WHERE" +
                        " s.codigoUnico =:identity",
                Formulario.class);
        q.setParameter("identity", idServico);
        return q.getSingleResult();
    }

    @Override
    public List<Atributo> findAtributos(Long id) {
        final TypedQuery<Atributo> q = createQuery("SELECT la from Formulario f INNER JOIN f.atributos la" +
                        " WHERE f.pk=:id",Atributo.class);
        q.setParameter("id",id);
        return q.getResultList();
    }

    @Override
    public Label getLabelDoAtributo(Long identity) {
        final TypedQuery<Label> q = createQuery(
                "SELECT lab FROM Formulario form JOIN form.atributos atr JOIN atr.label lab" +
                        " WHERE atr.id =:identity",
                Label.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }
}
