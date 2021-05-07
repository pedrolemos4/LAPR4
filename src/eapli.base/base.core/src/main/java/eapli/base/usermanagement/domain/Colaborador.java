package eapli.base.usermanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Colaborador extends SystemUser {

    private static final Logger LOGGER = LoggerFactory.getLogger(Colaborador.class);

    private MecanographicNumber numeroMecanografico;

    private ShortName shortName;

    private FullName fullName;

    private Date dataNasc;

    private Contacto contacto;

    private List<Equipa> associatedTeams;

    public Colaborador(MecanographicNumber numeroMecanografico, ShortName shortName, FullName fullName, Date dataNasc, Contacto contacto) {
        try {
            this.numeroMecanografico = numeroMecanografico;
            this.shortName = shortName;
            this.fullName = fullName;
            this.dataNasc = dataNasc;
            this.contacto = contacto;
            this.associatedTeams = new ArrayList<Equipa>();
        }
        catch (final IllegalArgumentException e){
            LOGGER.error("ERROR: Input data misconception ");
        }
    }

    public void addAssociatedTeam(Equipa equipa){
        try {
            List<TipoEquipa> tipoEquipasAssociadas = getAssociatedTeamsTypes();
            if (!tipoEquipasAssociadas.contains(equipa.getTipo()))
                associatedTeams.add(equipa);
            else {
                throw new IllegalArgumentException("ERROR: This user already has an associated team of that type");
            }
        }
        catch (IllegalArgumentException e){
            LOGGER.error("ERROR: This user already has an associated team of that type");
        }
    }

    private List<TipoEquipa> getAssociatedTeamsTypes() {
        return new ArrayList<>();
    }


    public void remAssociatedTeam(Equipa equipa){
        try {
            List<Equipa> equipasAssociadas = getAssociatedTeams();
            if (!equipasAssociadas.contains(equipa))
                associatedTeams.remove(equipa);
            else {
                throw new IllegalArgumentException("Error: No team found");
            }
        }
        catch (IllegalArgumentException e){
            LOGGER.error("ERROR: No team found");
        }
    }

    private List<Equipa> getAssociatedTeams() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "numeroMecanografico=" + numeroMecanografico +
                ", shortName='" + shortName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", contacto='" + contacto + '\'' +
                ", associatedTeams=" + associatedTeams +
                '}';
    }
}
