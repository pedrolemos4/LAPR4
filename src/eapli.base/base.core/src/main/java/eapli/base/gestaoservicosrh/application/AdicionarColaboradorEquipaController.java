package eapli.base.gestaoservicosrh.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthorizedException;

import java.util.Optional;

@UseCaseController
public class AdicionarColaboradorEquipaController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private EquipaRepository equipaRepository;
    private ColaboradorRepository  colaboradorRepository;


    public void AdicionarColaboradorEquipaController(Equipa equipa, Colaborador colaborador) {
        try{
            authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.RRH);
            if(existsTeam(equipa.identity()) && existsColaborador(colaborador.identity()))
                equipa.addMembro(colaborador);
        }
        catch(UnauthorizedException e){
            System.out.println("ERROR: You dont have the permission to do this action");
        }

    }

    public boolean existsTeam(CodigoUnico ID){
        return equipaRepository.containsOfIdentity(ID);
    }

    public boolean existsColaborador(MecanographicNumber id){
        return colaboradorRepository.containsOfIdentity(id);
    }
}
