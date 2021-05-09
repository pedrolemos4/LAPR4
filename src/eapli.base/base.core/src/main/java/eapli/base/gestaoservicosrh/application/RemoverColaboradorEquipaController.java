package eapli.base.gestaoservicosrh.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.usermanagement.domain.repositories.UserRepository;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthorizedException;

@UseCaseController
public class RemoverColaboradorEquipaController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final TipoEquipaRepository tipoEquipaRepository = PersistenceContext.repositories().tiposEquipa();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();



    public Equipa removerColaboradorEquipa(String codigoEquipa, int nrColab){
        CodigoUnico codigoUnico = new CodigoUnico(codigoEquipa);
        MecanographicNumber mecanographicNumber = new MecanographicNumber(nrColab);
        try{
            authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.RRH);
            if(existsTeam(codigoUnico) && existsColaborador(mecanographicNumber)) {
                Equipa equipa = equipaRepository.ofIdentity(codigoUnico).orElse(null);
                Colaborador colaborador = colaboradorRepository.ofIdentity(mecanographicNumber).orElse(null);
                equipa.listMembros().remove(colaborador);
                return this.equipaRepository.save(equipa);
            }
        }
        catch(UnauthorizedException e){
            System.out.println("ERROR: You dont have the permission to do this action");
        }
        return null;
    }

    public boolean existsTeam(CodigoUnico ID){
        return equipaRepository.containsOfIdentity(ID);
    }

    public boolean existsColaborador(MecanographicNumber id){
        return colaboradorRepository.containsOfIdentity(id);
    }

}
