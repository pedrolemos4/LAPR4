package eapli.base.gestaoservicoshelpdesk.domain;

import junit.framework.TestCase;

public class ServicoTest extends TestCase {

    public void testTestToString() {
        Servico s1 = new Servico();
        assertEquals(s1.toString(), "Servico{codigoUnico=null, descricaoBreve=null, descricaoCompleta=null, titulo=null, estado=null}");
    }

    public void testIdentity() {
        Servico s1 = new Servico();
        assertEquals(s1.identity(), null);
    }

    public void testEstado() {
        Servico s1 = new Servico();
        assertEquals(s1.estado(), null);
    }

    public void testMakeAvailable() {
        Servico s1 = new Servico();
        s1.makeAvailable();
        assertEquals(s1.estado(), EstadoServico.DISPONIVEL);
    }

    public void testMakeUnavailable() {
        Servico s1 = new Servico();
        s1.makeUnavailable();
        assertEquals(s1.estado(), EstadoServico.INDISPONIVEL);
    }

    public void testEstaDisponivel() {
        Servico s1 = new Servico();
        s1.makeAvailable();
        assertEquals(true, s1.estaDisponivel());
    }

    public void testEstaIndisponivel() {
        Servico s1 = new Servico();
        s1.makeUnavailable();
        assertEquals(true, s1.estaIndisponivel());
    }
}