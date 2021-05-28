package eapli.base.pedido.repositories;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.EstadoFluxo;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

public interface PedidoRepository extends DomainRepository<String, Pedido> {

    Iterable<Atividade> getListaTarefasPendentes(MecanographicNumber identity, String atividade);

    List<Atividade> findTarefasServico(Long identity, Colaborador identity2, EstadoAtividade estado);

    FluxoAtividade findFluxoServico(CodigoUnico identity);

    Servico findPedidoServico(String identity);

    List<Atividade> filtrarData(Long identity, Colaborador identity2, Calendar dataI, Calendar dataF, EstadoAtividade estado);

    List<Atividade> ordenarDataCrescente(Long identity, Colaborador identity2, EstadoAtividade estado);

    List<Atividade> ordenarDataDecrescente(Long identity, Colaborador identity2, EstadoAtividade estado);

    List<Atividade> ordenarCritCrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

    List<Atividade> ordenarCritDecrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

    List<Atividade> ordenarUrgenciaCrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

    List<Atividade> ordenarUrgenciaDecrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

    Atividade getTarefaById(int idAtividade);

    Pedido getPedidoByTarefa(int idAtividade);

    EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId);

    Long getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado);

    Long getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado);

    Long getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours);

    List<Atividade> getTarefasUrgenciaReduzida(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaReduzida);

    List<Atividade> getTarefasUrgenciaUrgente(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaUrgente);

    List<Atividade> getTarefasUrgenciaModerada(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaModerada);
}
