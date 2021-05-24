package eapli.base.pedido.repositories;

import eapli.base.atividades.domain.Atividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.pedido.domain.Identificador;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.domain.repositories.DomainRepository;

public interface PedidoRepository extends DomainRepository<Identificador, Pedido> {

    Iterable<Atividade> getListaTarefasPendentes(MecanographicNumber identity, String atividade);

    Atividade getTarefaById(int idAtividade);

    Pedido getPedidoByTarefa(int idAtividade);

}
