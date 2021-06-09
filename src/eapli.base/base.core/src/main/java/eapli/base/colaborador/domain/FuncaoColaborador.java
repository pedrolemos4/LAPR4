package eapli.base.colaborador.domain;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.util.HashCoder;
import eapli.framework.validations.Preconditions;

import java.io.Serializable;

public class FuncaoColaborador implements ValueObject, Serializable {

    private static final long serialVersionUID = 1L;

    private final String roleName;

    private FuncaoColaborador(final String role) {
        Preconditions.nonEmpty(role);

        roleName = role;
    }

    private FuncaoColaborador() {
        // for ORM
        roleName = null;
    }

    @Override
    public String toString() {
        return roleName;
    }

    public static FuncaoColaborador valueOf(final String role) {
        return new FuncaoColaborador(role);
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Role)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        final FuncaoColaborador that = (FuncaoColaborador) other;
        return roleName.equals(that.roleName);
    }

    @Override
    public int hashCode() {
        return new HashCoder().with(roleName).code();
    }

}
