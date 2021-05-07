package eapli.base.gestaoservicosrh.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class EspecificarColaboradorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository repository = PersistenceContext.repositories().colaborador();

    public

}
