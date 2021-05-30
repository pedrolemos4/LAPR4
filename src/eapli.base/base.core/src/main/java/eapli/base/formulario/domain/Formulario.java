package eapli.base.formulario.domain;

import eapli.base.atividade.domain.AtividadeManual;
import eapli.base.catalogo.domain.Titulo;
import eapli.base.pedido.domain.Pedido;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Formulario implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long pk;

    @Version
    private Long version;

    @Column(name="Titulo")
    private final Titulo titulo;

    @ElementCollection
    private Set<Atributo> atributos = new HashSet<>();

    @OneToOne (mappedBy = "formulario")
    private Servico servico;

    @OneToOne (mappedBy = "formulario")
    private Pedido pedido;

    @OneToOne (mappedBy = "formulario")
    private AtividadeManual atividadeManual;

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

    public void copyAtributos(final Set<Atributo> atributos) {
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
