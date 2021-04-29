package eapli.base.gestaoservicosrh.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.List;

public class Colaborador {

    @Version
    private Long version;

    @Id
    @GeneratedValue
    private int numeroMecanografico;

    @Column(name = "SNAME")
    private String shortName;

    @Column(name = "FNAME")
    private String fullName;

    @Column(name = "DNASC")
    private String dataNasc;

    @Column(name = "CONTACTO")
    private String contacto;

    List<Equipa> associatedTeams;

    public Colaborador(Long version, int numeroMecanografico, String shortName, String fullName, String dataNasc, String contacto) {
        this.version = version;
        this.numeroMecanografico = numeroMecanografico;
        this.shortName = shortName;
        this.fullName = fullName;
        this.dataNasc = dataNasc;
        this.contacto = contacto;
    }

    public void addAssociatedTeam(Equipa equipa){
        associatedTeams.add(equipa);
    }

    public void remAssociatedTeam(Equipa equipa){
        associatedTeams.remove(equipa);
    }
}
