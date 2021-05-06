package eapli.base.gestaoservicosrh.domain;

import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipa implements AggregateRoot<CodigoUnico> {
    @Id
    @Column(name = "ID_EQUIPA")
    private final CodigoUnico codigo;

    @Column(name = "ACRONIMO")
    private Acronimo acronimo;

    @Column(name = "DESIGNACAO")
    private Designacao designacao;

    @Column(name = "TIPO_EQUIPA")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private TipoEquipa tipo;

    @Column(name = "RESPONSAVEL_EQUIPA")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Colaborador responsavel;

    @Column(name = "LISTA_MEMBROS")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Colaborador> listMembros;

    public Equipa(CodigoUnico codigo, Acronimo acronimo, Designacao desig, TipoEquipa tipo, Colaborador responsavel) {
        this.codigo = codigo;
        this.acronimo = acronimo;
        this.designacao = desig;
        this.tipo = tipo;
        this.responsavel = responsavel;
        this.listMembros = new ArrayList<>();
    }

    public Equipa() {
        codigo = null;
    }

    @Override
    public CodigoUnico identity() {
        return null;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual((DomainEntity<?>) this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode((DomainEntity<?>) this);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String toString() {
        return "Equipa{" +
                "codigo=" + codigo +
                ", acronimo=" + acronimo +
                ", designacao=" + designacao +
                ", tipo=" + tipo +
                ", responsavel=" + responsavel +
                '}';
    }
}
