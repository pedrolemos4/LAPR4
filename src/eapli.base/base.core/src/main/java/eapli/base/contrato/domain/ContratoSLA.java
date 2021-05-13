package eapli.base.contrato.domain;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.equipa.domain.Designacao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ContratoSLA  implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long identificador;

    @Version
    private Long version;

    @Column(name = "Designacao")
    private final Designacao designacao;

    @OneToMany(fetch = FetchType.EAGER)
    private final Set<Criticidade> niveisCriticidade = new HashSet<>();

    public ContratoSLA(final Designacao designacao, final Iterable<Criticidade> lista) {
        Preconditions.nonNull(designacao);
        this.designacao = designacao;
        Preconditions.nonNull(lista);
        copyCriticidade(lista);

    }

    private void copyCriticidade(final Iterable<Criticidade> lista) {
        // to keep with Information Expert principle we are copying the received data to our own
        // internal data. This way we do not suffer from side effects if someone accesses the
        // original data and changes it without our knowledge
        for (final Criticidade c : lista) {
            addCriticidade(c);
        }
    }

    public boolean addCriticidade(final Criticidade c) {
        return this.niveisCriticidade.add(c);
    }

    protected ContratoSLA() {
        this.designacao = null;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return identificador;
    }

    @Override
    public String toString() {
        return "ContratoSLA{" +
                "designacao=" + designacao +
                ", niveisCriticidade=" + niveisCriticidade +
                '}';
    }
}
