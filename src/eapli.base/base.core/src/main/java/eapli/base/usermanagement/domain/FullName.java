package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;

@Embeddable
public class FullName implements ValueObject {

    private String fullName;

    public FullName() {   }

    public FullName(String fullName) {
        if (StringPredicates.isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException(
                    "fullName cannot be null");
        }
        else {
            this.fullName = fullName;
        }
    }

    @Override
    public String toString() {
        return fullName;
    }
}
