package eapli.base.servico;

import eapli.base.servico.domain.EstadoServico;
import eapli.base.servico.domain.Servico;
import junit.framework.TestCase;
import org.junit.Test;

public class ServicoTest extends TestCase {

    @Test
    public void testTestToString() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234", "ServicoTest"));
        assertEquals("Servico{codigoUnico=1234, descricaoBreve=null, descricaoCompleta=null, titulo=ServicoTest, estado=null}", s1.toString());
    }

    @Test
    public void testIdentity() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234", "ServicoTest"));
        //assertEquals("CodigoUnico{codigo='1234'}", s1.identity());
    }

    @Test
    public void testEstado() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234", "ServicoTest"));
        assertEquals(s1.estado(), null);
    }

    @Test
    public void testMakeAvailable() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234", "ServicoTest"));
        s1.makeAvailable();
        assertEquals(s1.estado(), EstadoServico.DISPONIVEL);
    }

    @Test
    public void testMakeUnavailable() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234", "ServicoTest"));
        s1.makeUnavailable();
        assertEquals(s1.estado(), EstadoServico.INDISPONIVEL);
    }

    @Test
    public void testEstaDisponivel() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234", "ServicoTest"));
        s1.makeAvailable();
        assertEquals(true, s1.estaDisponivel());
    }

    @Test
    public void testEstaIndisponivel() {
        Servico s1 = new Servico(new Servico.ServicoBuilder("1234", "ServicoTest"));
        s1.makeUnavailable();
        assertEquals(true, s1.estaIndisponivel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnsureCodigoUnicoMustNotBeNull() {
        Servico s1 = new Servico(new Servico.ServicoBuilder(" ", "ServicoTest"));
    }

    @Test
    public void testEnsureTituloMustNotBeNull() {
        try {
            Servico s1 = new Servico(new Servico.ServicoBuilder("cod123", " "));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEnsureCodigoUnicoLengthMustNotBeGreaterThan15() {
        try {
            Servico s1 = new Servico(new Servico.ServicoBuilder("cod12388888888888888", "ServicoTest"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEnsureDescricaoBreveLengthMustNotBeNull() {
        try {
            new Servico(new Servico.ServicoBuilder("cod123", "titulo")
                    .withDescricaoBreve(" "));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEnsureDescricaoBreveLengthMustNotBeGreaterThan40() {
        try {
            new Servico(new Servico.ServicoBuilder("cod123", "titulo")
                    .withDescricaoBreve("A descrição não pode ter mais de 40 caracteres"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testEnsureDescricaoCompletaMustNotNull() {
        try {
            new Servico(new Servico.ServicoBuilder("cod123", "titulo")
                    .withDescricaoCompleta(" "));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}