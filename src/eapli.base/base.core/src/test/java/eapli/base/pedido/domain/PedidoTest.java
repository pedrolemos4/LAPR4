package eapli.base.pedido.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.*;
import eapli.base.equipa.domain.Designacao;
import eapli.base.servico.domain.Servico;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;

import java.util.Calendar;

public class PedidoTest extends TestCase {

    public void testTestToString() {
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Pedido pedido = new Pedido(new Colaborador(new MecanographicNumber(0),new ShortName("Pedro"),new FullName("Pedrao"),dataAux ,
                new Contacto(123456789),new LocalResidencia("n sei"), EmailAddress.valueOf("pedro@qq.com"))
        ,dataAux,new Servico.ServicoBuilder("1523","t1").build(),new Criticidade(new Etiqueta("LOW"),new Escala(1),
                new Designacao("Low"),new Objetivo(15,10,15,10),new Cor(50,152,0)),
                new UrgenciaPedido("5"),dataAux);

        assertEquals(pedido.toString(),pedido.toString());
    }
}