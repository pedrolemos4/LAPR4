/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.infrastructure.bootstrapers;

import eapli.base.usermanagement.application.AddUserController;

import eapli.base.usermanagement.domain.Roles;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base Bootstrapping data app
 *
 * @author Paulo Gandra de Sousa
 */
@SuppressWarnings("squid:S106")
public class BaseBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            BaseBootstrapper.class);

    private static final String EMAILADMIN = "admin@org.com";

    private static final String IDADMIN = "01";

    private static final String EMAILGESTOR = "gestor@org.com";

    private static final String IDGESTOR = "02";

    private static final String EMAILRRH = "rrg@org.com";

    private static final String IDRRH = "03";

    private static final String EMAILCOLAB = "colab@org.com";

    private static final String IDCOLAB = "04";

    private static final String EMAILUSER = "user@org.com";

    private static final String IDUSER = "05";

    /*
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();
    private final UserRepository userRepository = PersistenceContext.repositories().users();
    */

    private final AddUserController userController = new AddUserController();


    @Override
    public boolean execute() {

        // declare bootstrap actions
        final Action[] actions = { new MasterUsersBootstrapper(), };

        /*registerPowerUser();
        authenticateForBootstrapping();
        */

        registerDefaultOrg();

        // execute all bootstrapping
        boolean ret = true;
        for (final Action boot : actions) {
            //System.out.println("Bootstrapping " + nameOfEntity(boot) + "...");
            ret &= boot.execute();
        }
        return ret;
    }

    /**
     * US 2103 - LEANDRO SOUSA 1190800
     * -----------------------------------------------------------------------------------------------
     * Como Gestor de Projeto, eu pretendo que a equipa proceda à configuração da estrutura do projeto
     * para facilitar / acelerar o desenvolvimento das próximas user stories.
     * @return true in case of sucess or false if fails
     */

    private boolean registerDefaultOrg(){

        userController.addUser("orgAdmin","ADMIN","Ricardo","Soares",EMAILADMIN, Roles.ADMIN);

        userController.addUser("orgRRH","RRH","Paula","Castro",EMAILRRH,Roles.RRH);

        userController.addUser("orgGestorServico","GESTOR","Afonso","Sousa",EMAILGESTOR,Roles.GESTOR_SERVICO);

        userController.addUser("orgColab","COLAB","Joel","Dias",EMAILCOLAB,Roles.COLABORADOR);

        userController.addUser("orgUser","CLIENT","Paulo","Maio",EMAILUSER,Roles.CLIENT_USER);

        return true;
    }


    /**
     * register a power user directly in the persistence layer as we need to
     * circumvent authorisations in the Application Layer
     */
    /*
    private boolean registerPowerUser() {
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername(POWERUSER).withPassword(POWERUSER_A1).withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.POWER_USER);
        final SystemUser newUser = userBuilder.build();

        SystemUser poweruser;
        try {
            poweruser = userRepository.save(newUser);
            assert poweruser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", newUser.username());
            LOGGER.trace("Assuming existing record", e);
            return false;
        }
    }
     */

    /**
     * authenticate a super user to be able to register new users
     *
     */
    /*
    protected void authenticateForBootstrapping() {
        authenticationService.authenticate(POWERUSER, POWERUSER_A1);
        Invariants.ensure(authz.hasSession());
    }

    private String nameOfEntity(final Action boot) {
        final String name = boot.getClass().getSimpleName();
        return Strings.left(name, name.length() - "Bootstrapper".length());
    }

     */
}
