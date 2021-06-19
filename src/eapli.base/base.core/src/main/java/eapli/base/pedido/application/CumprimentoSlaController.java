package eapli.base.pedido.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.TipoAtividade;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.framework.application.UseCaseController;

import java.util.Calendar;
import java.util.List;

@UseCaseController
public class CumprimentoSlaController {

    private final PedidoRepository pRepo = PersistenceContext.repositories().pedidos();

    public List<Pedido> getAllPedidoConcluido(Calendar calendar1, Calendar calendar2) {
        return pRepo.getAllPedidoConcluido(calendar1, calendar2, EstadoPedido.CONCLUIDO);
    }

    public List<Atividade> getTarefasDoPedido(String identity) {
        return this.pRepo.getTarefasDoPedido(identity);
    }

    public long getTempoDaTarefa(Long identity) {
        return this.pRepo.getTempoDaTarefa(identity);
    }


    public long getTempoMaximoAprov(String identity) {
        return this.pRepo.getTempoMaximoAprov(identity);
    }

    public long getTempoMaximoRes(String identity) {
        return this.pRepo.getTempoMaximoRes(identity);
    }

    public TipoAtividade getTipoAtividade(Long identity) {
        return this.pRepo.getTipoAtividade(identity);
    }
}