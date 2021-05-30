package eapli.base.pedido.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.servico.domain.Servico;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class PedidoTest extends TestCase {

    public void testTestToString() {
        Date data = new Date(2020,5,2);
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Pedido pedido = new Pedido(new Colaborador(new MecanographicNumber(0),new ShortName("Pedro"),new FullName("Pedrao"),dataAux ,
                new Contacto(123456789),new LocalResidencia("n sei"), EmailAddress.valueOf("pedro@qq.com"))
        , Calendar.getInstance() ,new Servico.ServicoBuilder("1523","t1").build(),UrgenciaPedido.URGENTE,dataAux);

        assertEquals(pedido.toString(),pedido.toString());
    }
}