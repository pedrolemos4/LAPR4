package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.Designacao;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ContratoSLA {

    @Id
    @GeneratedValue
    private Long identificador;

    @Version
    private Long version;

    @Column(name="Designacao")
    private final Designacao designacao;

    @OneToMany(fetch = FetchType.EAGER)
    private final Set<Criticidade> niveisCriticidade = new HashSet<>();

    public ContratoSLA(final Designacao designacao, final Set<Criticidade> lista) {
        Preconditions.nonNull(designacao);
        this.designacao = designacao;
        Preconditions.nonNull(lista);
        copyCriticidade(lista);

    }

    private void copyCriticidade(final Set<Criticidade> lista) {
        // to keep with Information Expert principle we are copying the received data to our own
        // internal data. This way we do not suffer from side effects if someone accesses the
        // original data and changes it without our knowledge
        for (final Criticidade c : lista) {
            addCriticidade(c);
        }
    }

    public boolean addCriticidade(final Criticidade c) {
        return niveisCriticidade.add(c);
    }

    protected ContratoSLA(){
        this.designacao = null;
    }
}
