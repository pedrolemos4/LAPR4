package eapli.base.usermanagement.application;

import eapli.base.usermanagement.domain.TipoUtilizador;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 *
 * Created by nuno on 21/03/16.
 */

@UseCaseController
public class AddUserController {

    //private final AuthorizationService authz = AuthzRegistry.authorizationService();
    //private final UserManagementService userSvc = AuthzRegistry.userService();

    /**
     * Get existing RoleTypes available to the user.
     *
     * @return a list of RoleTypes
     */
    //public Role[] getRoleTypes() {       return BaseRoles.nonUserValues();}
/*
    public SystemUser addUser(String username, String password, String firstName, String lastName,
            String email, Set<Role> roles, Calendar createdOn) {
        //authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        return userSvc.registerNewUser(username, password, firstName, lastName, email, roles,createdOn);
    }


    public SystemUser addUser(String username, String password, String firstName, String lastName,
            String email, Set<Role> roles) {
        return addUser(username, password, firstName, lastName, email, roles, Calendars.now());
    }
  */

    public SystemUser addUser(String username, String password, String firstName, String lastName,
                              String email, TipoUtilizador role) {
        return addUser(username, password, firstName, lastName, email, role);
    }
}
