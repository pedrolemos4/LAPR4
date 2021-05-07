package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FullName  implements ValueObject {

    @Column(name="FULLNAME")
    private String fullName;

    public FullName(String fullName) {
        if (StringPredicates.isNullOrEmpty(fullName)) {
            throw new IllegalArgumentException(
                    "fullName cannot be null");
        }
        else {
            this.fullName = fullName;
        }
    }

    protected FullName() {

    }

    @Override
    public String toString() {
        return fullName;
    }
}
