package eapli.base.colaborador.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.equipa.domain.Equipa;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.time.util.Calendars;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Temporal(TemporalType.DATE)
    private Calendar dataNasc;

    @Column(name="EMAIL")
    private EmailAddress endereco;

    @Column(name="CONTACTO")
    private Contacto contacto;

    @ManyToMany(mappedBy = "listResponsavel")
    private Set<Equipa> likes;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Pedido> pediddosEfetuados;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Set<FuncaoSet> funcoes;

    public Colaborador(MecanographicNumber numeroMecanografico, ShortName shortName, FullName fullName, Calendar dataNasc, Contacto contacto,
                        LocalResidencia localResidencia, EmailAddress endereco, final Set<FuncaoColaborador> roles){
        try {
            final FuncaoSet roleset = new FuncaoSet();
            roleset.addAll(roles.stream().map(rt -> new FuncaoAssignment(rt, Calendars.now()))
                    .collect(Collectors.toList()));
            
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
                //", dataNasc=" + dataNasc+
                ", endereco=" + endereco +
                ", contacto=" + contacto +
                '}';
    }

    @Override
    public boolean sameAs(final Object other) {
        if(!(other instanceof Colaborador)){
            return false;
        }
        final Colaborador that = (Colaborador) other;
        if(this == that){
            return true;
        }
        return numeroMecanografico.equals(that.numeroMecanografico) && shortName.equals(that.shortName) &&
                fullName.equals(that.fullName) && localResidencia.equals(that.localResidencia) && dataNasc.equals(that.dataNasc) &&
                endereco.equals(that.endereco) && contacto.equals(that.contacto);
    }

    @Override
    public MecanographicNumber identity() {
        return this.numeroMecanografico;
    }
}
