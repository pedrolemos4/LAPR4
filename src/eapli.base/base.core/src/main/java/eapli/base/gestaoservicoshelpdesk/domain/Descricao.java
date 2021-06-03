package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Descricao implements ValueObject {

    @Column(name = "DESC")
    private String desc;

    protected Descricao() {
        this.desc = null;
    }

    public Descricao(final String desc) {
        Preconditions.nonEmpty(desc, "Descrição não pode estar vazia");
        Preconditions.ensure(desc.length() <= 50, "Descrição não deve ter mais de 50 carateres");
        this.desc = desc;
    }
}
