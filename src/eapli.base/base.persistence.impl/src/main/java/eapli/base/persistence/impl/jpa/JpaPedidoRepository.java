package eapli.base.persistence.impl.jpa;

import eapli.base.pedido.domain.Identificador;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;

public class JpaPedidoRepository extends BasepaRepositoryBase<Pedido,Long,Identificador> implements PedidoRepository {

    public JpaPedidoRepository(){super("identificador");}

}
