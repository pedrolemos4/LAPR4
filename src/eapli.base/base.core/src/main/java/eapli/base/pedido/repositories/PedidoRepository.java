package eapli.base.pedido.repositories;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.atividades.domain.EstadoFluxo;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.pedido.domain.Pedido;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Calendar;
import java.util.List;

public interface PedidoRepository extends DomainRepository<String, Pedido> {

    Iterable<Atividade> getListaTarefasPendentes(MecanographicNumber identity, String atividade);

    List<Atividade> findTarefasServico(Long identity, Colaborador identity2, EstadoAtividade estado);

    FluxoAtividade findFluxoServico(CodigoUnico identity);

    Servico findPedidoServico(String identity);

    List<Atividade> filtrarData(Long identity, MecanographicNumber identity2, Calendar dataI, Calendar dataF, String estado);

    List<Atividade> ordenarCritCrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

    List<Atividade> ordenarCritDecrescente(Long identity, String identity2, MecanographicNumber identity3, String estado);

    Atividade getTarefaById(int idAtividade);

    Pedido getPedidoByTarefa(int idAtividade);

    EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId);
}
