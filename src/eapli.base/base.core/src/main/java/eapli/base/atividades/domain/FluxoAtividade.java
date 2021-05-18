package eapli.base.atividades.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.Set;

@Embeddable
public class FluxoAtividade implements ValueObject {

    @ElementCollection
    private Set<Atividade> atividade;
}
