package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.*;

@Entity
public class Catalogo implements AggregateRoot<Identificador>{

    @Id
    @GeneratedValue
    private Identificador identificador;

    @Version
    private Long version;

    @Column(name = "DESCCOMP")
    private final DescricaoCompleta descricaoCompleta;

    @Column(name = "DESCBRE")
    private final DescricaoBreve descricaoBreve;

    @Column(name = "ICONE")
    private final Icone icone;

    @OneToMany()
    @JoinTable(name = "LIST")
    private Set<Equipa> listEquipas = new HashSet<>();

    @OneToOne()
    @JoinColumn(name="COLABORADOR")
    private final Colaborador colab;

    public Catalogo(Colaborador colab, DescricaoCompleta descricaoCompleta, DescricaoBreve descricaoBreve,
                    Icone icone, Iterable<Equipa> listEquipas){
        Preconditions.nonNull(colab);
        this.colab=colab;
        Preconditions.nonNull(descricaoBreve);
        this.descricaoBreve=descricaoBreve;
        Preconditions.nonNull(descricaoCompleta);
        this.descricaoCompleta=descricaoCompleta;
        Preconditions.nonNull(icone);
        this.icone=icone;
        Preconditions.nonNull(listEquipas);
        copyList(listEquipas);

    }

    protected Catalogo() {
        this.descricaoBreve=null;
        this.descricaoCompleta=null;
        this.icone=null;
        this.colab=null;
    }

    private void copyList(Iterable<Equipa> listEquipas) {
        for(Equipa eq : listEquipas){
            this.listEquipas.add(eq);
        }
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Identificador identity() {
        return identificador;
    }

    @Override
    public boolean equals(final Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }


}
