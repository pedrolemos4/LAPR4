package eapli.base.persistence.impl.jpa;

import eapli.base.atividade.domain.*;
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
    public List<Atividade> getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM PEDIDO p JOIN p.listaAtiv a JOIN a.colab c " +
                        " WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado",
                Atividade.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    // -----------------------------------------ACHO QUE NAO É ASSIM-----------------------------
    @Override
    public List<Atividade> getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c " +
                        "WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
                        "AND p.dataLimiteResolucao > a.dataLimite",
                Atividade.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        return q.getResultList();
    }

    // -----------------------------------------ACHO QUE NAO É ASSIM-----------------------------
    @Override
    public List<Atividade> getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c " +
                        "WHERE c.numeroMecanografico =:userId AND a.estadoAtividade =:estado " +
                        "AND p.dataLimiteResolucao BETWEEN DATE(NOW()) AND DATE(NOW())-1",
                Atividade.class);
        q.setParameter("hours", hours);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        return q.getResultList();
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
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c JOIN Servico ser" +
                        " JOIN ser.catalogo cat JOIN cat.criticidade cri" +
                        " WHERE cri.escala =:i AND c.numeroMecanografico =:userId AND a.estadoAtividade =:estado ",
                Atividade.class);
        q.setParameter("userId", userId);
        q.setParameter("estado", estado);
        q.setParameter("i", i);
        return q.getResultList();
    }

    @Override
    public List<Atividade> getTarefaEtiqueta(MecanographicNumber userId, EstadoAtividade estado, String etiqueta) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a JOIN a.colab c JOIN Servico ser JOIN ser.catalogo cat" +
                        " JOIN cat.criticidade cri" +
                        " WHERE c.numeroMecanografico =:userId AND" +
                        " a.estadoAtividade =:estado AND cri.etiqueta =:etiqueta",
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
    public List<Calendar> findDatas(MecanographicNumber number) {
        final TypedQuery<Calendar> q = createQuery("SELECT p.dataSolicitacao FROM Pedido p" +
                " JOIN p.listaAtiv la JOIN la.colab col" +
                " WHERE la.estadoAtividade =:pendente AND col.numeroMecanografico=:number", Calendar.class);
        q.setParameter("pendente",EstadoAtividade.PENDENTE);
        q.setParameter("number", number);
        return q.getResultList();
    }

    @Override
    public List<Pedido> getAllPedidoConcluido(Calendar calendar1, Calendar calendar2, EstadoPedido concluido) {
        final TypedQuery<Pedido> q = createQuery(
                "SELECT p FROM Pedido p WHERE p.estado =:concluido AND " +
                        "p.dataResolucao >:calendar1 AND p.dataResolucao <:calendar2", Pedido.class);
        q.setParameter("concluido", concluido);
        q.setParameter("calendar1", calendar1);
        q.setParameter("calendar2", calendar2);
        return q.getResultList();
    }

    @Override
    public List<Atividade> getTarefasDoPedido(String identity) {
        final TypedQuery<Atividade> q = createQuery(
                "SELECT a FROM Pedido p JOIN p.listaAtiv a" +
                        " WHERE p.Id =:identity", Atividade.class);
        q.setParameter("identity", identity);
        return q.getResultList();
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
                        " JOIN a.script sas WHERE a.id =:identity",
                String.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public Formulario getFormularioPedido(String idPedido) {
        final TypedQuery<Formulario> q = createQuery(
                "SELECT p.formulario FROM Pedido p WHERE p.Id =:identity", Formulario.class);
        q.setParameter("identity", idPedido);
        return q.getSingleResult();
    }
	
	@Override
    public List<Atividade> getListaAtividades(String idPedido, EstadoAtividade estadoAtividade) {
        final TypedQuery<Atividade> q = createQuery("SELECT at FROM Pedido p JOIN p.listaAtiv at " +
                        "WHERE p.Id =:idPedido" +
                        " AND at.colab IS NULL AND at.estadoAtividade =:estadoAtividade",
                Atividade.class);
        q.setParameter("idPedido",idPedido);
        q.setParameter("estadoAtividade",estadoAtividade);
        return q.getResultList();
    }

    @Override
    public long getTempoDaTarefa(Long identity) {
        final TypedQuery<Long> q = createQuery(
                "SELECT dur.duracao FROM Pedido p JOIN p.listaAtiv a JOIN a.duracaoAtividade dur" +
                        " WHERE a.id =:identity", Long.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public long getTempoMaximoAprov(String identity) {
        final TypedQuery<Long> q = createQuery(
                "SELECT ob.tempoMaxAprov FROM Pedido p JOIN p.servico ser JOIN ser.catalogo c JOIN" +
                        " c.criticidade cri JOIN cri.objetivo ob WHERE p.Id =:identity",Long.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public long getTempoMaximoRes(String identity) {
        final TypedQuery<Long> q = createQuery(
                "SELECT ob.tempoMaxRes FROM Pedido p JOIN p.servico ser JOIN ser.catalogo c JOIN" +
                        " c.criticidade cri JOIN cri.objetivo ob WHERE p.Id =:identity",Long.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

    @Override
    public TipoAtividade getTipoAtividade(Long identity) {
        final TypedQuery<TipoAtividade> q = createQuery(
                "SELECT a.tipoAtividade FROM Pedido p JOIN p.listaAtiv a" +
                        " WHERE a.id =:identity", TipoAtividade.class);
        q.setParameter("identity", identity);
        return q.getSingleResult();
    }

}
