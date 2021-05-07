package eapli.base.usermanagement.domain;

import eapli.framework.strings.util.StringPredicates;

public class FullName {

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

    @Override
    public String toString() {
        return fullName;
    }
}
