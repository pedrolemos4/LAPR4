package eapli.base.atividade.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.EstadoFluxo;
import eapli.base.atividade.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.framework.application.UseCaseController;

import java.util.List;


@UseCaseController
public class AplicacoesController {
    // estatisticas todas da dashboard e estado do fluxo

    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();
    private ColaboradorRepository colabRepo = PersistenceContext.repositories().colaborador();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();

    public EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId) {
        return this.pedidoRepository.getEstadoFluxoDoServico(servicoId);
    }

    public Long getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
        return this.pedidoRepository.getNTarefasPendentes(userId, estado);
    }

    public Long getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
        return this.pedidoRepository.getTarefasQueUltrapassamDataPedido(userId, estado);
    }

    public Long getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
        return this.pedidoRepository.getTarefasQueTerminamEm1Hora(userId, estado, hours);
    }

    public List<Atividade> getTarefasUrgencia(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaReduzida) {
        return this.pedidoRepository.getTarefasUrgencia(userId, estado, urgenciaReduzida);
    }

    public List<Atividade> getTarefaEscala(MecanographicNumber userId, EstadoAtividade estado, int i) {
        return this.pedidoRepository.getTarefaEscala(userId, estado, i);
    }

    public List<Atividade> getTarefaEtiqueta(MecanographicNumber userId, EstadoAtividade estado, String etiqueta) {
        return this.pedidoRepository.getTarefaEtiqueta(userId, estado, etiqueta);
    }

    public FluxoAtividade getFluxoAtividade(String idServico) {
        CodigoUnico cod = new CodigoUnico(idServico);
        return this.servicoRepository.findFluxo(cod);
    }

    public Servico findServico(String idServico) {
        CodigoUnico cod = new CodigoUnico(idServico);
        return this.servicoRepository.findServico(cod);
    }

    public String findScriptServico(CodigoUnico cod){
        return this.servicoRepository.findScriptServico(cod);
    }

    public void saveServico(Servico servico){
        this.servicoRepository.save(servico);
    }
}
