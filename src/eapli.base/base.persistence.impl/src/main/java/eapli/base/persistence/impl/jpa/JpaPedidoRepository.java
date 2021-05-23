package eapli.base.persistence.impl.jpa;

import eapli.base.atividades.domain.Atividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.pedido.domain.Identificador;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;

import javax.persistence.TypedQuery;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido,Long,Identificador> implements PedidoRepository {

    public JpaPedidoRepository(){super("identificador");}

    @Override
    public Iterable<Atividade> getListaTarefasPendentes(MecanographicNumber identity, String atividade) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Atividade a JOIN a.equipa eq " +
                        "JOIN eq.listMembros lm WHERE" +
                        " a.TYPE =:atividade AND lm.numeroMecanografico=:identity",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("atividade", atividade);
        return q.getResultList();
    }

    @Override
    public Atividade getTarefaById(int idAtividade) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Atividade e WHERE" +
                        " a.id =:idAtividade",
                Atividade.class);
        q.setParameter("idAtividade", idAtividade);
        return q.getSingleResult();
    }

    @Override
    public Pedido getPedidoByTarefa(int idAtividade) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl JOIN fl.listaAtividade lista" +
                        " WHERE lista.id =:idAtividade",
                Pedido.class);
        q.setParameter("idAtividade", idAtividade);
        return q.getSingleResult();
    }

}
