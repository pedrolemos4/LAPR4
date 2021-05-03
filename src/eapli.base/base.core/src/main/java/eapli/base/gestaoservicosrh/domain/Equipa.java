package eapli.base.gestaoservicosrh.domain;

import eapli.framework.domain.model.DomainEntities;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.Version;
import java.util.List;

public class Equipa {
    @Version
    private Long version;
    private int id;
    private String nome;
    private List<Colaborador> listColab;

    public Equipa(int id, String nome, List<Colaborador> lc) {
        this.id = id;
        this.nome = nome;
        this.listColab = lc;
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

}
