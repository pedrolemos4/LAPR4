package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.gestaoservicoshelpdesk.domain.Funcao;
import eapli.base.gestaoservicosrh.application.EspecificarColaboradorController;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.infrastructure.authz.domain.model.Role;

public class UsersBootstrapperBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final AddUserController userController = new AddUserController();
    final EspecificarColaboradorController colabController = new EspecificarColaboradorController();
    final ListUsersController listUserController = new ListUsersController();

    public UsersBootstrapperBase() {
        super();
    }

    /**
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param email
     * @param roles
     */

    protected SystemUser registerUser(final String username, final String password, final String firstName,
                                      final String lastName, final String email, final Set<Role> roles) {
        SystemUser u = null;
        try {
            u = userController.addUser(username, password, firstName, lastName, email, roles);
            LOGGER.debug("»»» %s", username);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            u = listUserController.find(Username.valueOf(username)).orElseThrow(() -> e);
        }
        return u;
    }

    protected void registerColaborador(final int numeroMecanografico, final String nomeCurto, final String nomeCompleto,
                                                    final String dataNascimento, final int prefix, final int contacto, final String local, final String email){
        try{
            colabController.novoColaborador(numeroMecanografico, nomeCompleto, nomeCurto, dataNascimento, prefix, contacto, local,email);
            LOGGER.debug("»»» %s", nomeCurto);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            //c = listColaboradorController.find(Username.valueOf(username)).orElseThrow(() -> e);
        }
    }

}
