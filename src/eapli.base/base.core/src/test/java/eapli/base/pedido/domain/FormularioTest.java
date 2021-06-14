package eapli.base.pedido.domain;

import eapli.base.formulario.domain.*;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class FormularioTest extends TestCase {

    public void testTestToString() {
        Set<Atributo> listaAtributos = new HashSet<>();
        Atributo a1 = new Atributo(new Variavel("nome"), new Label("label"), TipoDados.STRING,Obrigatoriedade.OPCIONAL,new DescricaoAjuda("ola"),null);
        listaAtributos.add(a1);

        Formulario f1 = new Formulario("titulo1", listaAtributos);
        assertEquals(f1.toString(), "null; titulo1; [nome; label; ola; STRING; OPCIONAL]");
    }
}