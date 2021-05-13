package eapli.base.equipa.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.application.UseCaseController;

import java.util.List;

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

    public List<Equipa> showAllTeams() {
        return this.equipaRepository.findAll();
    }

    public List<Colaborador> showAllCollaborators() {
        return (List<Colaborador>) this.colaboradorRepository.findAll();
    }
}
