package eapli.base.atividade.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.EstadoFluxo;
import eapli.base.atividade.domain.FluxoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.domain.UrgenciaPedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.framework.application.UseCaseController;

import java.util.ArrayList;
import java.util.Calendar;
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

    public List<Atividade> getNTarefasPendentes(MecanographicNumber userId, EstadoAtividade estado) {
        try {
            return this.pedidoRepository.getNTarefasPendentes(userId, estado);
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public List<Atividade> getTarefasQueUltrapassamDataPedido(MecanographicNumber userId, EstadoAtividade estado) {
        try {
            return this.pedidoRepository.getTarefasQueUltrapassamDataPedido(userId, estado);
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public List<Atividade> getTarefasQueTerminamEm1Hora(MecanographicNumber userId, EstadoAtividade estado, int hours) {
        try {
            return this.pedidoRepository.getTarefasQueTerminamEm1Hora(userId, estado, hours);
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public List<Atividade> getTarefasUrgencia(MecanographicNumber userId, EstadoAtividade estado, UrgenciaPedido urgenciaReduzida) {
        try {
            return this.pedidoRepository.getTarefasUrgencia(userId, estado, urgenciaReduzida);
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public List<Atividade> getTarefaEscala(MecanographicNumber userId, EstadoAtividade estado, int i) {
        try {
            return this.pedidoRepository.getTarefaEscala(userId, estado, i);
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public List<Atividade> getTarefaEtiqueta(MecanographicNumber userId, EstadoAtividade estado, String etiqueta) {
        try {
            return this.pedidoRepository.getTarefaEtiqueta(userId, estado, etiqueta);
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }

    public FluxoAtividade getFluxoAtividade(String idServico) {
        return this.servicoRepository.findFluxo(idServico);
    }

    public Servico findServico(String idServico) {
        return this.servicoRepository.findServico(idServico);
    }

    public String findScriptServico(CodigoUnico cod){
        return this.servicoRepository.findCaminhoScriptServico(cod);
    }

    public void updatePedido(String idPedido, EstadoPedido estadoPedido){
        Pedido pedido = this.pedidoRepository.findPedido(idPedido);
        pedido.alterarEstadoPedido(estadoPedido);
        this.pedidoRepository.save(pedido);
    }

    public Iterable<Servico> getServicos() {
        return this.servicoRepository.findAll();
    }

    public List<Colaborador> findColaboradoresElegiveis(Long idCatalogo){
        return this.colabRepo.findColaboradoresElegiveis(idCatalogo);
    }

    public List<Atividade> getAtividadesAuto() {
        return this.pedidoRepository.getAtividadesAuto(EstadoPedido.valueOf("PENDENTE"));
    }

    public String findScriptAtividade(Long identity) {
        return this.pedidoRepository.findScriptAtividade(identity);
    }

    public List<Calendar> findDatas(MecanographicNumber number,String idPedido){
        return this.pedidoRepository.findDatas(number,idPedido);
    }
}
