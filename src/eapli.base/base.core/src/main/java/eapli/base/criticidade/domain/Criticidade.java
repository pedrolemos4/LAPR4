package eapli.base.criticidade.domain;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.equipa.domain.Designacao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Criticidade implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private Long version;

    @Column(name = "Etiqueta")
    private final Etiqueta etiqueta;

    @Column(name = "Escala")
    private final Escala escala;

    @Column(name = "Designacao")
    private final Designacao designacao;

    @Column(name = "Objetivo")
    private final Objetivo objetivo;

    @Column(name = "Cor")
    private final Cor cor;

    public Criticidade(final Etiqueta etiqueta, final Escala escala, final Designacao designacao,
                       final Objetivo objetivo, final Cor cor) {
        Preconditions.nonNull(etiqueta);
        Preconditions.nonNull(escala);
        Preconditions.nonNull(designacao);
        Preconditions.nonNull(objetivo);
        Preconditions.nonNull(cor);
        this.etiqueta = etiqueta;
        this.escala = escala;
        this.designacao = designacao;
        this.objetivo = objetivo;
        this.cor = cor;
    }

    protected Criticidade(){
        this.etiqueta = null;
        this.escala = null;
        this.designacao = null;
        this.objetivo = null;
        this.cor = null;
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
        return id;
    }

    @Override
    public String toString() {
        return "Criticidade: " + "etiqueta=" + etiqueta + ", escala=" + escala + ", designacao="
                + designacao + ", objetivo=" + objetivo + ", cor=" + cor;
    }

}
