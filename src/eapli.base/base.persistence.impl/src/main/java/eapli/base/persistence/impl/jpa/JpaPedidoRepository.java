package eapli.base.persistence.impl.jpa;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.EstadoFluxo;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;

import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido,Long,String> implements PedidoRepository {

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

    public Servico findPedidoServico(String identity) {
        final TypedQuery<Servico> q = createQuery(
                "SELECT p.servico FROM Pedido p WHERE p.id =:identity",
                Servico.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    public FluxoAtividade findFluxoServico(CodigoUnico identity) {
        final TypedQuery<FluxoAtividade> q = createQuery(
                "SELECT s.fluxoAtividade FROM Servico s WHERE s.codigoUnico =:identity",
                FluxoAtividade.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    public List<Atividade> findTarefasServico(Colaborador identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl" +
                        " JOIN fl.listaAtividade a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> filtrarData(Colaborador identity, Calendar dataI, Calendar dataF, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl" +
                        " JOIN fl.listaAtividade a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado AND a.dataLimite > :dataI AND a.dataLimite < :dataF",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("dataI", dataI);
        q.setParameter("dataF", dataF);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> filtrarUrgencia(Colaborador identity, EstadoAtividade estado, UrgenciaPedido urg) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl" +
                        " JOIN fl.listaAtividade a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado AND p.urgenciaPedido =:urgencia",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("urgencia", urg);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> filtrarCriticidade(FluxoAtividade identity, Pedido identity2, Colaborador identity3, EstadoAtividade estado, UrgenciaPedido urg) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT la FROM FluxoAtividade fl JOIN Servico s JOIN Pedido p JOIN fl.listaAtividade la WHERE " +
                        "s.fluxoAtividade =:identity AND s.pedido =:identity2 AND p.urgenciaPedido =:urgencia " +
                        "AND fl.id =:identity AND la.colab =:identity3 AND la.estadoAtividade =:estado",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("identity2", identity2);
        q.setParameter("identity3", identity3);
        q.setParameter("urgencia", urg);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarDataCrescente(Colaborador identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl" +
                        " JOIN fl.listaAtividade a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado ORDER BY a.dataLimite ASC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarDataDecrescente(Colaborador identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl" +
                        " JOIN fl.listaAtividade a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado ORDER BY a.dataLimite DESC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarCritCrescente(Long identity, String identity2,
                                                MecanographicNumber identity3, String estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT la FROM FluxoAtividade fl JOIN fl.listaAtividade la INNER JOIN Servico s " +
                        "INNER JOIN Pedido p WHERE" + " fla.fluxoatividade_id =:identity AND" +
                        " s.fluxoatividade_id =:identity AND" + " p.servicoSolicitado =:identity2 AND" +
                        " a.colab_mecanographicnumber =:identity3 AND" + " a.estadoatividade like =:estado " +
                        "ORDER BY p.criticidade ASC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("identity2", identity2);
        q.setParameter("identity3", identity3);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarCritDecrescente(Long identity, String identity2,
                                                  MecanographicNumber identity3, String estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Atividade a INNER JOIN FluxoAtividade_Atividade fla INNER JOIN Servico s " +
                        "INNER JOIN Pedido p WHERE" + " fla.fluxoatividade_id =:identity AND" +
                        " s.fluxoatividade_id =:identity AND" + " p.servicoSolicitado =:identity2 AND" +
                        " a.colab_mecanographicnumber =:identity3 AND" + " a.estadoatividade like =:estado " +
                        "ORDER BY p.criticidade DESC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("identity2", identity2);
        q.setParameter("identity3", identity3);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarUrgenciaCrescente(Long identity, Colaborador identity2,
                                                  MecanographicNumber identity3, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Atividade a INNER JOIN FluxoAtividade_Atividade fla INNER JOIN Servico s " +
                        "INNER JOIN Pedido p WHERE" + " fla.fluxoatividade_id =:identity AND" +
                        " s.fluxoatividade_id =:identity AND" + " p.servicoSolicitado =:identity2 AND" +
                        " a.colab_mecanographicnumber =:identity3 AND" + " a.estadoatividade like =:estado " +
                        "ORDER BY p.criticidade DESC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("identity2", identity2);
        q.setParameter("identity3", identity3);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarUrgenciaDecrescente(Long identity, String identity2,
                                                  MecanographicNumber identity3, String estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Atividade a INNER JOIN FluxoAtividade_Atividade fla INNER JOIN Servico s " +
                        "INNER JOIN Pedido p WHERE" + " fla.fluxoatividade_id =:identity AND" +
                        " s.fluxoatividade_id =:identity AND" + " p.servicoSolicitado =:identity2 AND" +
                        " a.colab_mecanographicnumber =:identity3 AND" + " a.estadoatividade like =:estado " +
                        "ORDER BY p.criticidade DESC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("identity2", identity2);
        q.setParameter("identity3", identity3);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public Pedido getPedidoByAtividade(Long idAtiv) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl" +
                        " JOIN fl.listaAtividade a WHERE a.id =: idAtiv", Pedido.class);
        q.setParameter("idAtiv", idAtiv);
        return q.getSingleResult();
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

    @Override
    public EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId) {
        final TypedQuery<EstadoFluxo> q = createQuery(
                "SELECT fluxo FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl JOIN fl.estadoFluxo fluxo" +
                        " WHERE ser.codigoUnico =:servicoId",
                EstadoFluxo.class);
        q.setParameter("servicoId", servicoId);
        return q.getSingleResult();
    }

    @Override
    public Long getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
        final TypedQuery<Long> q = createQuery(
                "SELECT count(a) FROM Atividade a JOIN a.colab c " +
                        " WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado",
                Long.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        return q.getSingleResult();
    }

    // -----------------------------------------ACHO QUE NAO É ASSIM-----------------------------
    @Override
    public Long getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
        final TypedQuery<Long> q = createQuery(
                "SELECT count(a) FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl " +
                        "JOIN fl.listaAtividade a JOIN a.colab c " +
                        "WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
                        "AND p.dataLimiteResolucao > a.dataLimite",
                Long.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        return q.getSingleResult();
    }

    // -----------------------------------------ACHO QUE NAO É ASSIM-----------------------------
    @Override
    public Long getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
        final TypedQuery<Long> q = createQuery(
                "SELECT count(a) FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl " +
                        "JOIN fl.listaAtividade a JOIN a.colab c " +
                        "WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
                        "AND p.dataLimiteResolucao < a.dataLimite + :hours * INTERVAL '1 hour'" +
                        "AND p.dataLimiteResolucao > a.dataLimite",
                Long.class);
        q.setParameter("hours", hours);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        return q.getSingleResult();
    }

    @Override
    public List<Atividade> getTarefasUrgencia(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgencia) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p JOIN p.servico ser JOIN ser.fluxoAtividade fl " +
                        "JOIN fl.listaAtividade a JOIN a.colab c " +
                        "WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
                        "AND p.urgenciaPedido =:urgencia",
                Atividade.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        q.setParameter("urgencia", urgencia);
        return q.getResultList();
    }


    // -------------------------------------NAO TENHO A CERTEZA DA ESCALA-----------------------------
    @Override
    public List<Atividade> getTarefaEscala(MecanographicNumber userId, EstadoAtividade estado, int i) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p JOIN p.servico ser JOIN ser.fluxoAtividade fl " +
                        "JOIN fl.listaAtividade a JOIN a.colab c JOIN ser.catalogo cat JOIN cat.criticidade cri" +
                        "JOIN cri.escala es" +
                        "WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
                        "AND es.value =:i",
                Atividade.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        q.setParameter("i", i);
        return q.getResultList();
    }

    @Override
    public List<Atividade> getTarefaEtiqueta(MecanographicNumber userId, EstadoAtividade estado, String etiqueta) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p JOIN p.servico ser JOIN ser.fluxoAtividade fl " +
                        "JOIN fl.listaAtividade a JOIN a.colab c JOIN ser.catalogo cat JOIN cat.criticidade cri" +
                        "JOIN cri.etiqueta et" +
                        "WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
                        "AND et.value =:etiqueta",
                Atividade.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        q.setParameter("etiqueta", etiqueta);
        return q.getResultList();
    }

}
