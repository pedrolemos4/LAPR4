package eapli.base.gestaoservicosrh.domain;

import eapli.framework.domain.model.AggregateRoot;

public class TipoEquipa implements AggregateRoot<String> {
    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return null;
    }
}
