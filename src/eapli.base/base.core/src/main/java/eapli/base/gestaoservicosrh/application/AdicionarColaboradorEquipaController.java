package eapli.base.gestaoservicosrh.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.Acronimo;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Designacao;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.exceptions.UnauthorizedException;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.Optional;

@UseCaseController
public class AdicionarColaboradorEquipaController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();

    /*
    No authorization needed bc role is guarentedd
     */
    public boolean adicionarColaboradorEquipa(String codigoEquipa, int nrColab) {
        CodigoUnico codigoUnico = new CodigoUnico(codigoEquipa);
        MecanographicNumber mecanographicNumber = new MecanographicNumber(nrColab);
        if(existsTeam(codigoUnico) && existsColaborador(mecanographicNumber)){
            Equipa equipa = equipaRepository.ofIdentity(codigoUnico).orElse(null);
            Colaborador colaborador = colaboradorRepository.ofIdentity(mecanographicNumber).orElse(null);
            if (validate(equipa,colaborador)) {
                System.out.println(equipa.listMembros());
                equipa.listMembros().add(colaborador);
                System.out.println(equipa.listMembros());
                this.equipaRepository.save(equipa);
                return true;
            }
            else{
                System.out.println("Este colaborador já se encontra com uma equipa deste tipo associada.");
            }
        }
        else{
            System.out.println("Equipa ou Colaborador não encontrado");
        }
        return false;
    }

    private boolean validate(Equipa equipa, Colaborador colaborador) {
        return this.equipaRepository.validate(equipa.getTipo(),colaborador.identity()) == null;
    }

    public boolean existsTeam(CodigoUnico ID){
        return equipaRepository.containsOfIdentity(ID);
    }

    public boolean existsColaborador(MecanographicNumber id){
        return colaboradorRepository.containsOfIdentity(id);
    }

    public void showAll() {
        System.out.println("Available Teams   =========================================================================\n");
        for (Equipa e : this.equipaRepository.findAll()) {
            System.out.println(e);
        }
        System.out.println("===========================================================================================\n");
        System.out.println("Available Collaborators   =================================================================\n");
        for (Colaborador c :this.colaboradorRepository.findAll()) {
            System.out.println(c);
        }
        System.out.println("===========================================================================================\n");    }
}
