package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.gestaoservicosrh.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.visitor.Visitor;

public class ListColaboradorPrint  implements Visitor<Colaborador> {

    @Override
    public void visit(Colaborador visitee) {
        System.out.println(visitee.toString());
    }
}
