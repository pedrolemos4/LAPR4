package eapli.base.pedido.domain;

import eapli.base.formulario.domain.*;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class FormularioTest extends TestCase {

    public void testTestToString() {
        Set<Atributo> listaAtributos = new HashSet<>();
        Atributo a1 = new Atributo(Variavel.valueOf("Idade"), Label.valueOf("Label da idade"), false, TipoDados.INTEGER);
        listaAtributos.add(a1);

        Formulario f1 = new Formulario("titulo1", listaAtributos);
        assertEquals(f1.toString(), "Formulario{pk=null, version=null, titulo=titulo1, atributos=1}");
    }
}