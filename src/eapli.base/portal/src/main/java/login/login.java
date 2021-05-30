package login;

import ajax_server.DemoConsumer;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;


public class login  extends BaseApplication {

    private static final Logger LOGGER = LogManager.getLogger(login.class);


    private login(){

    }

    public static void main(String[] args) {
        AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());
        new login().run(args);
    }

    @Override
    protected void doMain(String[] args) throws Exception {
        // login and go to main menu
        if (new LoginUI().show()) {
            // go to main menu
            final var menu = new MainMenu();
            //Server Creation Here
            //try {
                //ServerSocket socket = new ServerSocket(9090, 0, InetAddress.getByName(null));
                //new HttpChatConsumer().execute("10.8.0.83","32507");
            new DemoConsumer().execute(InetAddress.getLocalHost(),32507);
                openDashboard();
                menu.mainLoop();
            //}catch (Exception e){
              //  LOGGER.error("Impossivel estabelecer ligação com o servidor");
            //}
        }
    }

    private void openDashboard() throws IOException {
        String url = "portal\\src\\main\\java\\ajax_server\\www\\fluxo.html";
        File file = new File(url);
        Desktop.getDesktop().browse(file.toURI());
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
