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

    @OneToOne(cascade=CascadeType.ALL)//one-to-one
    @JoinColumn(name="TipoEquipa")
    private TipoEquipa tipo;

    @ManyToMany()
    @JoinTable(
            name = "tabelaIntermedia",
            joinColumns = @JoinColumn(name = "equipa_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id"))
    private Set<Colaborador> listResponsavel;

    @ManyToMany()
    @JoinTable(
            name = "listMembros",
            joinColumns = @JoinColumn(name = "idEquipa"),
            inverseJoinColumns = @JoinColumn(name = "colaboradorId"))
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
        try {
            validateColab(colab,this.tipo);
            return listMembros.add(colab);
        }
        catch (IllegalArgumentException e){
            System.out.println("ERROR: This collaborator has already an associated team if this type");
            return false;
        }
    }

    private void validateColab(Colaborador colab, TipoEquipa tipo) {

    }

    public boolean removerMembro(Colaborador colab) {
        try {
            return listMembros.remove(colab);
        }
        catch (NullPointerException e){
            System.out.println("ERROR: Colaborator cannot be null");
            return false;
        }
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
