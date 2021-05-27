package eapli.base.atividades.application;

import eapli.base.atividades.domain.EstadoFluxo;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class AplicacoesController {
    // estatisticas todas da dashboard e estado do fluxo

    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();

    // será mesmo necessário levar o cloaborador associado??????
    public EstadoFluxo getEstadoFluxoDoServico(CodigoUnico servicoId, MecanographicNumber user) {
        return this.pedidoRepository.getEstadoFluxoDoServico(servicoId);
    }
}
