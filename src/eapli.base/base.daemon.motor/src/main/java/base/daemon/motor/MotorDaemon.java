package base.daemon.motor;

import base.daemon.motor.algorithms.ExecutorController;
import base.daemon.motor.presentation.MotorServer;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;


public final class MotorDaemon {

    private static final Logger LOGGER = LogManager.getLogger(MotorDaemon.class);

    private MotorDaemon() {
    }

    public static void main(final String[] args) throws Exception {
        LOGGER.info("Configuring the daemon");

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());
        LOGGER.info("Starting the server socket");

        List<String> listServidores = new ArrayList<>();
        listServidores.add("10.8.0.80");
        listServidores.add("10.8.0.81");

        ExecutorController c = new ExecutorController(listServidores);

        final MotorServer server  = new MotorServer();
        MotorServer.main(null);
        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }
}
