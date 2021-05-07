package eapli.base.gestaoservicosrh.domain;

import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private TipoEquipa tipo;

    @ManyToMany()
    //@JoinColumn(name="RESPONSAVEL", referencedColumnName = "numeroMecanografico")
    private Set<Colaborador> listResponsavel;

    @ManyToMany()
    //@JoinColumn(name="LISTMEMBERS")
    private Set<Colaborador> listMembros;

    public Equipa(CodigoUnico codigo, Acronimo acronimo, Designacao desig, TipoEquipa tipo, Set<Colaborador> responsaveis) {
        this.codigo = codigo;
        this.acronimo = acronimo;
        this.designacao = desig;
        this.tipo = tipo;
        this.listResponsavel = new HashSet<>();
        this.listMembros = new HashSet<>();
        listResponsavel.addAll(responsaveis);
        listMembros.addAll(responsaveis);
    }

    public Equipa() {
        codigo = null;
    }

    public Set<Colaborador> listMembros() {
        return listMembros;
    }

    public TipoEquipa getTipo() {
        return this.tipo;
    }

    public boolean addMembro(Colaborador colab) {
        return listMembros.add(colab);
    }

    @Override
    public CodigoUnico identity() {
        return null;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode( this);
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
                '}';
    }
}
