package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.servico.domain.EstadoServico;
import eapli.base.servico.domain.Servico;
import junit.framework.TestCase;

public class ServicoTest extends TestCase {

    public void testTestToString() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234","ServicoTest"));
        assertEquals("Servico{codigoUnico=CodigoUnico{codigo='1234'}, descricaoBreve=null, descricaoCompleta=null, titulo=ServicoTest, estado=null}",s1.toString());}

    public void testIdentity() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234","ServicoTest"));
        //assertEquals("CodigoUnico{codigo='1234'}", s1.identity());
    }

    public void testEstado() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234","ServicoTest"));
        assertEquals(s1.estado(), null);
    }

    public void testMakeAvailable() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234","ServicoTest"));
        s1.makeAvailable();
        assertEquals(s1.estado(), EstadoServico.DISPONIVEL);
    }

    public void testMakeUnavailable() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234","ServicoTest"));
        s1.makeUnavailable();
        assertEquals(s1.estado(), EstadoServico.INDISPONIVEL);
    }

    public void testEstaDisponivel() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234","ServicoTest"));
        s1.makeAvailable();
        assertEquals(true, s1.estaDisponivel());
    }

    public void testEstaIndisponivel() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234","ServicoTest"));
        s1.makeUnavailable();
        assertEquals(true, s1.estaIndisponivel());
    }
}