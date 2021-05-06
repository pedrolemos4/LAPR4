package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.visitor.Visitor;

public class ListEquipasPrint implements Visitor<Equipa> {

    @Override
    public void visit(final Equipa visitee) {
        System.out.printf(visitee.toString());
    }
}
