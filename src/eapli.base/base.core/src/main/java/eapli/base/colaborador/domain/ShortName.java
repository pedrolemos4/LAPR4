package eapli.base.colaborador.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ShortName implements ValueObject {

    @Column(name="ShortName")
    private String shortName;

    public ShortName(String shortName) {
        if (StringPredicates.isNullOrEmpty(shortName)) {
            throw new IllegalArgumentException(
                    "shortName cannot be null");
        }
        else {
            this.shortName = shortName;
        }
    }

    @Override
    public String toString() {
        return shortName;
    }

    protected ShortName(){
        this.shortName = null;
    }
}
