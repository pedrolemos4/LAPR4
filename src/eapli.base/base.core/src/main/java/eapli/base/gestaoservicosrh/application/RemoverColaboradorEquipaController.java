package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.usermanagement.domain.repositories.UserRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class RemoverColaboradorEquipaController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private EquipaRepository equipaRepository;
    private UserRepository userRepository;

    public void RemoverColaboradorEquipaController(Equipa equipa, Colaborador colaborador){

    }


}
