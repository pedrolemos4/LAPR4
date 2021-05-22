package eapli.base.equipa.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class RemoverColaboradorEquipaController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();


    public boolean removerColaboradorEquipa(String codigoEquipa, int nrColab){
        CodigoUnico codigoUnico = new CodigoUnico(codigoEquipa);
        MecanographicNumber mecanographicNumber = new MecanographicNumber(nrColab);
        if(existsTeam(codigoUnico) && existsColaborador(mecanographicNumber)) {
            Equipa equipa = this.equipaRepository.ofIdentity(codigoUnico).orElse(null);
            Colaborador colaborador = this.colaboradorRepository.ofIdentity(mecanographicNumber).orElse(null);
            this.equipaRepository.delete(equipa);
            equipa.removerMembro(colaborador);
            System.out.println(equipa.listMembros());
            this.equipaRepository.save(equipa);
            return true;
        }
        return false;
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
