package login;

import eapli.base.app.backoffice.console.presentation.MainMenu;
import eapli.base.app.common.console.BaseApplication;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.clientusermanagement.application.eventhandlers.NewUserRegisteredFromSignupWatchDog;
import eapli.base.clientusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.eventpubsub.EventDispatcher;


public class login  extends BaseApplication {

    Server server = new Server();

    private login(){

    }

    public static void main(String[] args) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
        new login().run(args);
    }

    @Override
    protected void doMain(String[] args) {
        // login and go to main menu
        if (new LoginUI().show()) {
            // go to main menu
            final var menu = new MainMenu();
            //Server Creation Here
            server.createServer();
            //Server Bind???
            server.bind();
            menu.mainLoop();
            // Encerrar Server
            server.disconnect();
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
