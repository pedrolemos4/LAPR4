package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class AdicionarColaboradorEquipaController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private EquipaRepository equipaRepository;
    private UserRepository  userRepository;


    public void AdicionarColaboradorEquipaController(Equipa equipa, Colaborador colaborador) {

    }

    public Equipa findTeam(int ID){
        //Equipa equipa = new EquipaRepository().findTeam(ID);
        return null;
    }

    public Colaborador getColaborador(int ID){
        return null;
    }

}
