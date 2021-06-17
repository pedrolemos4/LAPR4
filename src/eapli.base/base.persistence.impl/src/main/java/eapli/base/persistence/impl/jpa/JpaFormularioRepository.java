package eapli.base.persistence.impl.jpa;

import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.*;
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

    @Override
    public Variavel getVariavelDoAtributo(Long identity) {
        final TypedQuery<Variavel> q = createQuery(
                "SELECT lab FROM Formulario form JOIN form.atributos atr JOIN atr.nomeVariavel lab" +
                        " WHERE atr.id =:identity",
                Variavel.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public ExpressaoRegular getExpressaoRegularDoAtributo(Long identity) {
        final TypedQuery<ExpressaoRegular> q = createQuery(
                "SELECT exp FROM Formulario form JOIN form.atributos atr JOIN atr.expressaoRegular exp" +
                        " WHERE atr.id =:identity",
                ExpressaoRegular.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public List<ExpressaoRegular> getListaExpressaoRegularDoFormulario(Long identity) {
        final TypedQuery<ExpressaoRegular> q = createQuery("SELECT exp from Formulario f JOIN" +
                " f.atributos atr JOIN atr.expressaoRegular exp WHERE f.pk=:identity",ExpressaoRegular.class);
        q.setParameter("identity",identity);
        return q.getResultList();
    }
}
