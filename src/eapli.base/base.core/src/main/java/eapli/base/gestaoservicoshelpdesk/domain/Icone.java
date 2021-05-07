package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Icone implements ValueObject {

    @Column(name="ICONE")
    private final String icone;

    public Icone(String icone) {
        Preconditions.nonEmpty(icone,"Icone não pode estar vazio");
        Preconditions.ensure(icone.length()<=50,"Icone não pode ter mais de 50 caractes");
        this.icone=icone;
    }

    protected Icone() {
        this.icone=null;
    }
}
