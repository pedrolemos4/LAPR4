package eapli.base.app.portal.console;

import base.daemon.motor.MotorDaemon;
import eapli.base.app.portal.console.ajax_server.Dashboard;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.app.portal.console.presentation.MenuPortal;
import eapli.base.clientusermanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import eapli.base.clientusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;

@SuppressWarnings("squid:S106")
public final class Login extends BaseApplication {

    private static final Logger LOGGER = LogManager.getLogger(MotorDaemon.class);

    private Login(){

    }

    public static void main(String[] args) {
        LOGGER.info("Configuring the portal");
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
        new Login().run(args);
    }

    @Override
    protected void doMain(String[] args) throws Exception {
        // login and go to main menu
        if (new LoginUI().show()) {
            // go to main menu
            final var menu = new MenuPortal();
            menu.mainLoop();
            //Server Creation Here
            new Dashboard().execute(InetAddress.getLocalHost(),32507);


        }
    }

    @Override
    protected String appTitle() {
        return "Portal";
    }

    @Override
    protected String appGoodbye() {
        return "Exiting Portal. Goodbye";
    }

    @Override
    protected void doSetupEventHandlers(EventDispatcher dispatcher) {
        dispatcher.subscribe(new NewUserRegisteredFromSignupWatchDog(),
                NewUserRegisteredFromSignupEvent.class);
    }
}
