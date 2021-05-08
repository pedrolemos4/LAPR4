package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.visitor.Visitor;

public class ListRolePrint  implements Visitor<Role> {

    @Override
    public void visit(Role visitee) {
        System.out.println(visitee.toString());
    }
}
