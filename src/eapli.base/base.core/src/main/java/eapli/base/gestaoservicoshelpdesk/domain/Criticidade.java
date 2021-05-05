package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.Designacao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Criticidade implements AggregateRoot<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private final Etiqueta etiqueta;

    private final Escala escala;

    private final Designacao designacao;

    private final Objetivo objetivo;

    private final Cor cor;


    public Criticidade(final Etiqueta etiqueta, final Escala escala, final Designacao designacao,
                       final Objetivo objetivo, final Cor cor) {
        Preconditions.noneNull(etiqueta, escala, designacao, objetivo, cor);
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
