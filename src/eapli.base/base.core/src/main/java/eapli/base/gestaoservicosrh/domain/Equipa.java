package eapli.base.gestaoservicosrh.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

public class Equipa implements AggregateRoot<CodigoUnico> {

    private final CodigoUnico codigo;

    private Acronimo acronimo;

    private Designacao designacao;

    private TipoEquipa tipo;

    private Colaborador responsavel;

    public Equipa(CodigoUnico codigo, Acronimo acronimo, Designacao desig, TipoEquipa tipo, Colaborador responsavel) {
        this.codigo = codigo;
        this.acronimo = acronimo;
        this.designacao = desig;
        this.tipo = tipo;
        this.responsavel = responsavel;
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

}
