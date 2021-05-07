package eapli.base.usermanagement.domain;

import eapli.framework.infrastructure.authz.domain.model.Role;

public final class CountryCode {

    public static final String ARGENTINA = "+54";

    public static final String AUSTRALIA = "+61";

    public static final String BELGIUM = "+32";

    public static final String BRAZIL = "+55";

    public static final String CANADA = "+1";

    public static final String CHINA = "+86";

    public static final String CROATIA = "+385";

    public static final String FRANCE = "+33";

    public static final String GREECE = "+30";

    public static final String HUNGARY = "+36";

    public static final String ITALY = "+39";

    public static final String PORTUGAL = "+351";

    public static final String NEW_ZEALAND = "+64";

    public static final String UNITED_KINGDOM = "+44";

    public static final String UNITED_STATES = "+1";

    public static final String UNITED_ARAB_EMIRATES = "+971";


    /**
     * get available role types for adding new users
     *
     * @return
     */
    public static String[] CountryCodes() {
        return new String[] { ARGENTINA,AUSTRALIA,BELGIUM,BRAZIL,CANADA,CHINA,CROATIA
        ,FRANCE,GREECE,HUNGARY,ITALY,PORTUGAL,NEW_ZEALAND,UNITED_KINGDOM,UNITED_STATES,UNITED_ARAB_EMIRATES};
    }


}
