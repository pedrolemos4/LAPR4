package eapli.base.pedido.repositories;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.EstadoFluxo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Escala;
import eapli.base.criticidade.domain.Etiqueta;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Calendar;
import java.util.List;

public interface PedidoRepository extends DomainRepository<String, Pedido> {

    List<Atividade> getListaTarefasPendentes(MecanographicNumber identity);

    List<Atividade> findTarefasServico(Colaborador identity, EstadoAtividade estado);

    List<Atividade> filtrarData(Colaborador identity, Calendar dataI, Calendar dataF, EstadoAtividade estado);

    List<Atividade> filtrarUrgencia(Colaborador identity, EstadoAtividade estado, UrgenciaPedido urg);

    List<Atividade> filtrarCriticidadeEscala(Colaborador identity, EstadoAtividade estado, Escala esc);

    List<Atividade> filtrarCriticidadeEtiqueta(Colaborador identity, EstadoAtividade estado, Etiqueta etiqueta);

    List<Atividade> ordenarDataCrescente(Colaborador identity, EstadoAtividade estado);

    List<Atividade> ordenarDataDecrescente(Colaborador identity, EstadoAtividade estado);

    Atividade getTarefaById(long idAtividade);

    Pedido getPedidoByTarefa(long idAtividade);

    EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId);

    Long getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado);

    Long getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado);

    Long getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours);

    List<Atividade> getTarefasUrgencia(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaReduzida);
    
    List<Atividade> getTarefaEscala(MecanographicNumber userId, EstadoAtividade estado, int i);

    List<Atividade> getTarefaEtiqueta(MecanographicNumber userId, EstadoAtividade estado, String etiqueta);

    Pedido getPedidoByAtividade(Long idAtiv);

    List<Atividade> ordenarEscalaCrescente(Colaborador identity, EstadoAtividade estado);

    List<Atividade> ordenarEscalaDecrescente(Colaborador identity, EstadoAtividade estado);

    List<Atividade> filtrarUrgenciaPendentes(MecanographicNumber colab, EstadoAtividade pendente, UrgenciaPedido urgencia);

    List<Atividade> filtrarDataPendentes(MecanographicNumber identity, Calendar data1, Calendar data2, EstadoAtividade pendente);

    List<Atividade> filtrarCriticidadeEscalaPendentes(MecanographicNumber identity, Escala valueOf, EstadoAtividade pendente);

    List<Atividade> filtrarCriticidadeEtiquetaPendentes(MecanographicNumber identity, Etiqueta valueOf, EstadoAtividade pendente);

    List<Atividade> ordenarDataCrescentePendentes(MecanographicNumber identity, EstadoAtividade pendente);

    List<Atividade> ordenarDataDecrescentePendentes(MecanographicNumber identity, EstadoAtividade pendente);
}
