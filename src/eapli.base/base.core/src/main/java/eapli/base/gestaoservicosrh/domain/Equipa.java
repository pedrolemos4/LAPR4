package eapli.base.gestaoservicosrh.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.Version;
import java.util.List;

public class Equipa implements AggregateRoot<Integer> {
    @Version
    private Long version;
    @GeneratedValue
    private int id;
    private String nome;
    private List<Colaborador> listColab;
    private TipoEquipa tipoEquipa;

    public Equipa(String nome, List<Colaborador> lc, TipoEquipa te) {
        this.nome = nome;
        this.listColab = lc;
        this.tipoEquipa = te;
    }

    public Equipa() {

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
    public Integer identity() {
        return null;
    }
}
