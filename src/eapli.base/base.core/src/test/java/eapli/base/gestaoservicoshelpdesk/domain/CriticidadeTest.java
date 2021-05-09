package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.Designacao;
import junit.framework.TestCase;

public class CriticidadeTest extends TestCase {

    public void testTestEquals() {
        Criticidade crit = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
        , new Objetivo(12,11), new Cor(3,3,3));
        Criticidade crit2 = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
                , new Objetivo(12,11), new Cor(3,3,3));
        assertEquals(crit,crit2);
    }

    public void testTestToString() {
        Criticidade crit = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
                , new Objetivo(12,11), new Cor(3,3,3));
        assertEquals(crit.toString(), "Criticidade: etiqueta=e1, escala=Valor:3, designacao=desig, objetivo=Objetivo: tempoMax=12, tempoMedio=11, cor=Cor: red=3, green=3, blue=3");
    }

    public void testHashCode() {
        Criticidade crit = new Criticidade(new Etiqueta("e1"), new Escala(3), new Designacao("desig")
                , new Objetivo(12,11), new Cor(3,3,3));
        assertEquals(crit.hashCode(),1147);
    }
}