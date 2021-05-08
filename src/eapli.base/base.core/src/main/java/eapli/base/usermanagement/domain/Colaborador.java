package eapli.base.usermanagement.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.LocalResidencia;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Colaborador implements AggregateRoot<MecanographicNumber>{

    private static final Logger LOGGER = LoggerFactory.getLogger(Colaborador.class);

    @Id
    @Column(name="numeroMecanografico")
    private MecanographicNumber numeroMecanografico;

    @Column(name="SHORTNAME")
    private ShortName shortName;

    @Column(name="FULLNAME")
    private FullName fullName;

    @Column(name="RESIDENCIA")
    private LocalResidencia localResidencia;

    @Column(name="DATANASC")
    private Data dataNasc;

    @Column(name="EMAIL")
    private EmailAddress endereco;

    @Column(name="CONTACTO")
    private Contacto contacto;

    @ManyToMany(mappedBy = "listResponsavel")
    private Set<Equipa> likes;

    public Colaborador(MecanographicNumber numeroMecanografico, ShortName shortName, FullName fullName, Data dataNasc, Contacto contacto,
                        LocalResidencia localResidencia, EmailAddress endereco){//}, Funcao funcao) {
        try {
            this.numeroMecanografico = numeroMecanografico;
            this.shortName = shortName;
            this.fullName = fullName;
            this.dataNasc = dataNasc;
            this.contacto = contacto;
            this.endereco=endereco;
            this.localResidencia=localResidencia;
        }
        catch (final IllegalArgumentException e){
            LOGGER.error("ERROR: Input data misconception ");
        }
    }

    protected Colaborador() {
        this.numeroMecanografico=null;
        this.shortName=null;
        this.endereco=null;
        this.localResidencia=null;
        this.contacto=null;
        this.fullName=null;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "numeroMecanografico=" + numeroMecanografico +
                ", shortName=" + shortName +
                ", fullName=" + fullName +
                ", localResidencia=" + localResidencia +
                ", dataNasc=" + dataNasc +
                ", endereco=" + endereco +
                ", contacto=" + contacto +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public MecanographicNumber identity() {
        return this.numeroMecanografico;
    }
}
