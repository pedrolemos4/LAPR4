package eapli.base.pedido.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.Servico;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class PedidoTest extends TestCase {

    public void testTestToString() {
        Date data = new Date(2020,5,2);
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Pedido pedido = new Pedido(new Colaborador(new MecanographicNumber(0),new ShortName("Pedro"),new FullName("Pedrao"),dataAux ,
                new Contacto(123456789),new LocalResidencia("n sei"), EmailAddress.valueOf("pedro@qq.com"),new HashSet<>())
        , Calendar.getInstance() ,new Servico.ServicoBuilder("1523","t1").build(),UrgenciaPedido.URGENTE,dataAux, new Formulario("t1",new HashSet<>()));

        assertEquals(pedido.toString(),pedido.toString());
    }

    public void testAtribuirGrau() {
        Date data = new Date(2020,5,2);
        Calendar dataAux = Calendar.getInstance();
        dataAux.set(1993,4,3);
        Pedido pedido = new Pedido(new Colaborador(new MecanographicNumber(0),new ShortName("Pedro"),new FullName("Pedrao"),dataAux ,
                new Contacto(123456789),new LocalResidencia("n sei"), EmailAddress.valueOf("pedro@qq.com"),new HashSet<>())
                , Calendar.getInstance() ,new Servico.ServicoBuilder("1523","t1").build(),UrgenciaPedido.URGENTE,dataAux, new Formulario("t1",new HashSet<>()));
        pedido.atribuirGrau(new GrauSatisfacao(2));

        assertTrue(pedido.toString().contains("GrauSatisfacao{grau=2}"));
    }
}