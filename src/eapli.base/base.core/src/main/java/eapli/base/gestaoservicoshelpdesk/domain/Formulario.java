package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Formulario implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long pk;

    @Version
    private Long version;

    @Column(name="Titulo")
    private final Titulo titulo;

    @ElementCollection
    private Set<Atributo> atributos = new HashSet<>();

    protected Formulario(){
        //ORM
        this.titulo=null;
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "pk=" + pk +
                ", version=" + version +
                ", titulo=" + titulo +
                ", atributos=" + atributos.size() +
                '}';
    }

    public Formulario(final String titulo, final Set<Atributo> listaAtributos) {
        this.titulo = new Titulo(titulo);

        Preconditions.nonNull(listaAtributos);
        copyAtributos(listaAtributos);
    }

    private void copyAtributos(final Set<Atributo> atributos) {
        for (final Atributo atributo : atributos) {
            addAtributo(atributo);
        }
    }

    public boolean addAtributo(final Atributo atributo) {
        return atributos.add(atributo);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return pk;
    }
}
