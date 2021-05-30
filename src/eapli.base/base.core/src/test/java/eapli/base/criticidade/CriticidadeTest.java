package eapli.base.criticidade;

import eapli.base.criticidade.domain.*;
import eapli.base.equipa.domain.Designacao;
import junit.framework.TestCase;
import org.junit.Test;

public class CriticidadeTest extends TestCase {

    public void testTestEquals() {
        Criticidade crit = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
        , new Objetivo(10,10,12,11), new Cor(3,3,3));
        Criticidade crit2 = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
                , new Objetivo(10,10,12,11), new Cor(3,3,3));
        assertEquals(crit,crit2);
    }

    public void testTestToString() {
        Criticidade crit = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
                , new Objetivo(10,10,12,11), new Cor(3,3,3));
        assertEquals("Criticidade: etiqueta=e1, escala=Valor:3, designacao=desig, objetivo=Objetivo\n" +
                "tempoMaxApro: 10.0\n" +
                "tempoMedioAprov:10.0\n" +
                "tempoMaxRes:12.0\n" +
                "tempoMedioRes:11.0, cor=Cor: red=3, green=3, blue=3",crit.toString());
    }

    public void testHashCode() {
        Criticidade crit = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
                , new Objetivo(10,10,12,11), new Cor(3,3,3));
        assertEquals(crit.hashCode(),1147);
    }

    @Test
    public void ensureCriticidade() {
        new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
                , new Objetivo(10,10,12,11), new Cor(3,3,3));
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriticidadeNotNullEtiqueta() {
        new Criticidade(null, new Escala(3), new Designacao("desig")
                , new Objetivo(10,10,12,11), new Cor(3,3,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriticidadeNotNullDesignacao() {
        new Criticidade(new Etiqueta("e1"), new Escala(3), null
                , new Objetivo(10,10,12,11), new Cor(3,3,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriticidadeNotNullEscala() {
        new Criticidade(new Etiqueta("e1"), null, new Designacao("desig")
                , new Objetivo(10,10,12,11), new Cor(3,3,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriticidadeNotNullObjetivo() {
        new Criticidade(new Etiqueta("e1"), null, new Designacao("desig")
                , null, new Cor(3,3,3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCriticidadeNotNullCor() {
        new Criticidade(new Etiqueta("e1"), null, new Designacao("desig")
                , new Objetivo(10,10,12,11), null);
    }
}