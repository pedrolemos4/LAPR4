package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocalResidencia implements ValueObject {

    @Column(name="ENDERECO")
    private final String endereco;

    public LocalResidencia(String endereco){
        Preconditions.nonEmpty(endereco);
        this.endereco = endereco;
    }

    public LocalResidencia() {
        this.endereco=null;
    }

    @Override
    public String toString() {
        return "LocalResidencia{" +
                "endereco='" + endereco + '\'' +
                '}';
    }
}
