package base.daemon.executor;

import base.daemon.executor.presentation.ExecutorServer;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.base.infrastructure.persistence.PersistenceContext;


public final class ExecutorDaemon {
    private static final int PORT = 32507;

    private static final Logger LOGGER = LogManager.getLogger(ExecutorDaemon.class);

    private ExecutorDaemon() {
    }

    public static void main(final String[] args) {
        LOGGER.info("Configuring the daemon");

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());
        LOGGER.info("Starting the server socket");
        final ExecutorServer server  = new ExecutorServer();
        //server.start(PORT,true);
        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }
}
