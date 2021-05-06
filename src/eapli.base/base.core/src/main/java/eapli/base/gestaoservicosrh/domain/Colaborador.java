package eapli.base.gestaoservicosrh.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

public class Colaborador extends Utilizador {

    private MecanographicNumber numeroMecanografico;

    private String shortName;

    private String fullName;

    private String dataNasc;

    private String contacto;

    List<Equipa> associatedTeams;

    public Colaborador(MecanographicNumber numeroMecanografico, String shortName, String fullName, String dataNasc, String contacto) {
        this.numeroMecanografico = numeroMecanografico;
        this.shortName = shortName;
        this.fullName = fullName;
        this.dataNasc = dataNasc;
        this.contacto = contacto;
        this.associatedTeams = new ArrayList<Equipa>();
    }

    public void addAssociatedTeam(Equipa equipa){
        associatedTeams.add(equipa);
    }

    public void remAssociatedTeam(Equipa equipa){
        associatedTeams.remove(equipa);
    }
}
