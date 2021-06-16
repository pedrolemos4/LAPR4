package eapli.base.persistence.impl.jpa;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.EstadoFluxo;
import eapli.base.atividade.domain.Script;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Escala;
import eapli.base.criticidade.domain.Etiqueta;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Formulario;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;

import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido, Long, String> implements PedidoRepository {

    public JpaPedidoRepository() {
        super("identificador");
    }

    @Override
    public List<Atividade> getListaTarefasPendentesColaborador(MecanographicNumber identity, EstadoPedido concluido, EstadoAtividade pendente) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT at FROM Pedido p JOIN p.listaAtiv at JOIN at.equipa eq " +
                        "JOIN eq.listMembros lm WHERE lm.numeroMecanografico =:identity" +
                        " AND at.colab IS NULL AND at.estadoAtividade =:pendente AND" +
                        " p.concluido !=:concluido",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("pendente", pendente);
        q.setParameter("concluido", concluido);
        return q.getResultList();
    }


    @Override
    public List<Atividade> filtrarUrgenciaPendentes(MecanographicNumber colab, EstadoAtividade estado, UrgenciaPedido urgencia) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a " +
                        "JOIN a.equipa eq JOIN eq.listMembros lm " +
                        "WHERE lm.numeroMecanografico=:colab " +
                        "AND a.estadoAtividade =:estado AND p.urgenciaPedido =:urgencia" +
                        " AND a.colab IS NULL",
                Atividade.class);
        q.setParameter("colab", colab);
        q.setParameter("estado", estado);
        q.setParameter("urgencia", urgencia);
        return q.getResultList();
    }

    @Override
    public List<Atividade> filtrarDataPendentes(MecanographicNumber identity, Calendar data1, Calendar data2, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.equipa eq JOIN eq.listMembros lm " +
                        "WHERE lm.numeroMecanografico=:identity " +
                        "AND a.estadoAtividade =:estado AND a.dataLimite > :data1 AND a.dataLimite < :data2" +
                        " AND a.colab IS NULL",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        q.setParameter("data1", data1);
        q.setParameter("data2", data2);
        return q.getResultList();
    }

    @Override
    public List<Atividade> filtrarCriticidadeEscalaPendentes(MecanographicNumber identity, Escala escala, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.equipa eq JOIN eq.listMembros lm " +
                        "WHERE lm.numeroMecanografico=:identity " +
                        "AND a.estadoAtividade =:estado AND crit.escala=:escala" +
                        " AND a.colab IS NULL",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        q.setParameter("escala", escala);
        return q.getResultList();
    }

    @Override
    public List<Atividade> filtrarCriticidadeEtiquetaPendentes(MecanographicNumber identity, Etiqueta etiqueta, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.equipa eq JOIN eq.listMembros lm " +
                        "WHERE lm.numeroMecanografico=:identity " +
                        "AND a.estadoAtividade =:estado AND crit.etiqueta =:etiqueta" +
                        " AND a.colab IS NULL",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        q.setParameter("etiqueta", etiqueta);
        return q.getResultList();
    }

    @Override
    public List<Atividade> ordenarDataCrescentePendentes(MecanographicNumber identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.equipa eq JOIN eq.listMembros lm " +
                        "WHERE lm.numeroMecanografico=:identity " +
                        "AND a.estadoAtividade =:estado ORDER BY a.dataLimite ASC" +
                        " AND a.colab IS NULL",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    @Override
    public List<Atividade> ordenarDataDecrescentePendentes(MecanographicNumber identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.equipa eq" +
                        " JOIN eq.listMembros lm WHERE lm.numeroMecanografico=:identity " +
                        "AND a.estadoAtividade =:estado ORDER BY a.dataLimite DESC" +
                        " AND a.colab IS NULL",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> findTarefasServico(Colaborador identity, EstadoAtividade estado, EstadoPedido concluido) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado AND " +
                        "p.estado !=:concluido",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        q.setParameter("concluido", concluido);
        return q.getResultList();
    }

    public List<Atividade> filtrarData(Colaborador identity, Calendar dataI, Calendar dataF, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT form FROM Pedido p JOIN p.listaAtiv a WHERE a.colab =: identity " +
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
                "SELECT form FROM Pedido p JOIN p.listaAtiv a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado AND p.urgenciaPedido =:urgencia",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("urgencia", urg);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> filtrarCriticidadeEscala(Colaborador identity, EstadoAtividade estado, Escala esc) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.catalogo cat JOIN cat.criticidade crit " +
                        "JOIN p.listaAtiv a WHERE a.colab =:identity " +
                        "AND a.estadoAtividade =:estado AND crit.escala =:escala",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("escala", esc);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> filtrarCriticidadeEtiqueta(Colaborador identity, EstadoAtividade estado, Etiqueta etiqueta) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.catalogo cat JOIN cat.criticidade crit " +
                        "JOIN p.listaAtiv a WHERE a.colab =:identity " +
                        "AND a.estadoAtividade =:estado AND crit.etiqueta =:etiqueta",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("etiqueta", etiqueta);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarDataCrescente(Colaborador identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:estado ORDER BY a.dataLimite ASC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarDataDecrescente(Colaborador identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a WHERE a.colab =: identity" +
                        " AND a.estadoAtividade =:estado ORDER BY a.dataLimite DESC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarEscalaCrescente(Colaborador identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.catalogo cat JOIN cat.criticidade crit " +
                        "JOIN p.listaAtiv a WHERE a.colab =:identity " +
                        "AND a.estadoAtividade =:estado ORDER BY crit.escala ASC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Atividade> ordenarEscalaDecrescente(Colaborador identity, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.servico ser JOIN ser.catalogo cat JOIN cat.criticidade crit " +
                        "JOIN p.listaAtiv a WHERE a.colab =:identity " +
                        "AND a.estadoAtividade =:estado ORDER BY crit.escala DESC",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    @Override
    public Pedido getPedidoByTarefa(long idAtividade) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p JOIN p.listaAtiv lista" +
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
                "SELECT count(a) FROM PEDIDO p JOIN p.listaAtiv a JOIN a.colab c " +
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
                "SELECT count(a) FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c " +
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
                "SELECT count(a) FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c " +
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
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c " +
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
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c" +
                        " JOIN ser.catalogo cat JOIN cat.criticidade cri" +
                        " JOIN cri.escala es WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
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
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c JOIN ser.catalogo cat" +
                        " JOIN cat.criticidade cri" +
                        " JOIN cri.etiqueta et WHERE c.numeroMecanografico =:userId AND" +
                        " a.estadoAtividade =:estado AND et.value =:etiqueta",
                Atividade.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        q.setParameter("etiqueta", etiqueta);
        return q.getResultList();
    }

    public List<Pedido> getPedidosPendentes(Colaborador colab, EstadoPedido estado) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p WHERE p.colaborador =:colab AND " +
                        "p.estado =:estado AND p.grau IS NULL", Pedido.class);
        q.setParameter("colab", colab);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    public List<Pedido> getPedidosPendentesOrdered(Colaborador colab, EstadoPedido estado) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p WHERE p.colaborador =:colab AND " +
                        "p.estado =:estado AND p.grau IS NULL ORDER BY p.dataSolicitacao DESC", Pedido.class);
        q.setParameter("colab", colab);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    @Override
    public Formulario getFormularioDaAtividade(Long identity) {
        final TypedQuery<Formulario> q = createQuery(
                "SELECT form FROM Pedido p JOIN p.listaAtiv lista" +
                        " JOIN lista.formulario form" +
                        " WHERE lista.id =:identity",
                Formulario.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public Atividade getTarefaByScript(String caminho) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT at FROM Pedido p JOIN p.listaAtiv at" +
                        "WHERE at.script =:identity", Atividade.class);
        q.setParameter("identity", new Script(caminho));
        return q.getSingleResult();
    }

    @Override
    public Double getTempoDeExecucaoTarefa(Atividade atividade) {
        final TypedQuery<Double> q = createQuery(
                "SELECT crit.tempoMedioAprov FROM Pedido p JOIN p.servico ser JOIN ser.catalogo cat " +
                        "JOIN cat.criticidade crit JOIN " +
                        "p.listaAtiv a " +
                        "WHERE a.id =:identity", Double.class);
        q.setParameter("identity", atividade);
        return q.getSingleResult();
    }

    @Override
    public List<Calendar> findDatas(MecanographicNumber number, String idPedido) {
        final TypedQuery<Calendar> q = createQuery("SELECT p.dataSolicitacao FROM Pedido p" +
                " JOIN p.listaAtiv la JOIN la.colab col" +
                " WHERE p.id =:idPedido AND la.estadoAtividade =:pendente AND col.numeroMecanografico=:number", Calendar.class);
        q.setParameter("pendente",EstadoAtividade.PENDENTE);
        q.setParameter("idPedido", idPedido);
        q.setParameter("number", number);
        return q.getResultList();
    }

    @Override
    public List<Pedido> getAllPedidoConcluido(EstadoPedido concluido) {
        /*final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p" +
                        " WHERE p.estado =:concluido", Pedido.class);
        q.setParameter("concluido", concluido);*/
        return /*q.getResultList()*/ null;
    }

    @Override
    public List<Atividade> getTarefasDoPedido(String identity) {
        /*final TypedQuery<Atividade> q = createQuery(
                "SELECT la FROM Pedido p JOIN p.servico ser JOIN ser.fluxoAtividade fl JOIN fl.listaAtividade la" +
                        " WHERE p.Id =:identity", Atividade.class);
        q.setParameter("identity", identity);*/
        return null/*q.getResultList()*/;
    }

    @Override
    public List<Atividade> getListaTarefasPendentes(Colaborador identity, EstadoAtividade pendente, EstadoPedido concluido) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a WHERE a.colab =: identity " +
                        "AND a.estadoAtividade =:pendente AND " +
                        "p.estado !=:concluido",
                Atividade.class);
        q.setParameter("identity", identity);
        q.setParameter("pendente", pendente);
        q.setParameter("concluido", concluido);
        return q.getResultList();
    }

    @Override
    public List<Pedido> getPedidosEmCurso(Colaborador colab) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p WHERE p.colaborador =:colab AND " +
                        "p.estado != :concluido AND p.grau IS NULL ORDER BY p.dataSolicitacao DESC", Pedido.class);
        q.setParameter("colab", colab);
        q.setParameter("concluido", EstadoPedido.CONCLUIDO);
        return q.getResultList();
    }

    @Override
    public Pedido findPedido(String idPedido) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p WHERE p.Id = :idPedido", Pedido.class);
        q.setParameter("idPedido", idPedido);
        return q.getSingleResult();
    }

    @Override
    public List<Atividade> getAtividadesAuto(EstadoPedido estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido JOIN p.listaAtiv a JOIN a.script sas" +
                        "WHERE a.colab IS NULL AND sas.caminhoScript IS NOT NULL" +
                        " AND a.estadoAtividade =:estado",
                Atividade.class);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    @Override
    public String findScriptAtividade(Long identity) {
        final TypedQuery<String> q = createQuery(
                "SELECT sas.caminhoScript FROM Pedido p JOIN p.listaAtiv a" +
                        " JOIN a.script sas WHERE a.id :=identity",
                String.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public Formulario getFormularioPedido(String idPedido) {
        final TypedQuery<Formulario> q = createQuery(
                "SELECT p.formulario form FROM Pedido p WHERE p.id =:identity", Formulario.class);
        q.setParameter("identity", idPedido);
        return q.getSingleResult();
    }

}
