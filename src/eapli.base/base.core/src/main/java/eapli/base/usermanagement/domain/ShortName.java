package eapli.base.usermanagement.domain;

import eapli.framework.strings.util.StringPredicates;

public class ShortName {

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

}
