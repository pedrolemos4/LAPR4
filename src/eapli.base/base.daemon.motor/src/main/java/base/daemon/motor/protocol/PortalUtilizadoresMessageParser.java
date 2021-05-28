package base.daemon.motor.protocol;

import eapli.framework.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Utility
public class PortalUtilizadoresMessageParser {

    //----------------------------------------- LIXO --------------------------------------------

    private static final Logger LOGGER = LogManager.getLogger(PortalUtilizadoresMessageParser.class);

    /*private static BookAMealForADayController controller;

    private PortalUtilizadoresMessageParser() {
        // avoid instantiation
    }*/

    /**
     * To inject a different controller for testing purposes.
     *
     * @param controller
     */

    /* package *//*public static void injectController(final BookAMealForADayController controller) {
        synchronized (lock) {
            PortalUtilizadoresMessageParser.controller = controller;
        }
    }

    private static final Object lock = new Object();

    private static BookAMealForADayController getController() {
        synchronized (lock) {
            if (PortalUtilizadoresMessageParser.controller != null) {
                return PortalUtilizadoresMessageParser.controller;
            }
        }
        return new BookAMealForADayControllerImpl();
    }*/
}
