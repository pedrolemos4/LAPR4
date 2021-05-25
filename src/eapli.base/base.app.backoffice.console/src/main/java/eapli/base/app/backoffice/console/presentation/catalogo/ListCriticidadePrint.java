package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.criticidade.domain.Criticidade;
import eapli.framework.visitor.Visitor;

public class ListCriticidadePrint implements Visitor<Criticidade> {

    @Override
    public void visit(final Criticidade visitee) {
        System.out.printf(visitee.toString());
    }
}
