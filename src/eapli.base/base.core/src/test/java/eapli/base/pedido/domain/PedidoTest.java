package eapli.base.pedido.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.*;
import eapli.base.equipa.domain.Designacao;
import eapli.base.servico.domain.Servico;
import eapli.framework.general.domain.model.EmailAddress;
import junit.framework.TestCase;

public class PedidoTest extends TestCase {

    public void testTestToString() {
        Pedido pedido = new Pedido(new Colaborador(new MecanographicNumber(0),new ShortName("Pedro"),new FullName("Pedrao"),new Data(2020,7,2),
                new Contacto(123456789),new LocalResidencia("n sei"), EmailAddress.valueOf("pedro@qq.com"))
        ,new Data(2020,7,1),new Servico.ServicoBuilder("1523","t1").build(),new Criticidade(new Etiqueta("LOW"),new Escala(1),
                new Designacao("Low"),new Objetivo(15,10,15,10),new Cor(50,152,0)),
                new UrgenciaPedido("5"),new Data(2021,8,1));

        assertEquals("Pedido{Id=2021/0, colaborador=Colaborador{numeroMecanografico=Number: 0, shortName=Pedro, fullName=Pedrao, localResidencia=LocalResidencia{endereco='n sei'}, dataNasc=Data{ano=2020, mes=7, dia=2}, endereco=pedro@qq.com, contacto=Contacto{number=123456789, prefix=0}}, dataSolicitacao=Data{ano=2020, mes=7, dia=1}, servico=Servico{codigoUnico=1523, descricaoBreve=null, descricaoCompleta=null, titulo=t1, estado=null}, criticidade=Criticidade: etiqueta=LOW, escala=Valor:1, designacao=Low, objetivo=Objetivo\n" +
                "tempoMaxApro: 15.0\n" +
                "tempoMedioAprov:10.0\n" +
                "tempoMaxRes:15.0\n" +
                "tempoMedioRes:10.0, cor=Cor: red=50, green=152, blue=0, urgenciaPedido=UrgenciaPedido: 5, dataLimiteResolucao=Data{ano=2021, mes=8, dia=1}}",pedido.toString());
    }
}