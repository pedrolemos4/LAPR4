package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.criticidade.domain.*;
import eapli.base.equipa.domain.Designacao;
import junit.framework.TestCase;

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
}