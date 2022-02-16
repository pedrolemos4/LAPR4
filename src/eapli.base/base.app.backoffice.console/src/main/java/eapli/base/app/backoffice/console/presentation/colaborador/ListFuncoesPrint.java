package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaborador.domain.Funcao;
import eapli.framework.visitor.Visitor;

public class ListFuncoesPrint  implements Visitor<Funcao> {

    @Override
    public void visit(Funcao visitee) {
        System.out.println(visitee.toString());
    }
}
