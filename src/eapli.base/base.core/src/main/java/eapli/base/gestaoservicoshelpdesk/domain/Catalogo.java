package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalogo implements AggregateRoot<Identificador>{

    @Id
    @GeneratedValue
    private Identificador identificador;

    @Column(name = "DESCCOMP")
    private DescricaoCompleta descricaoCompleta;

    @Column(name = "DESCBRE")
    private DescricaoBreve descricaoBreve;

    @Column(name = "ICONE")
    private Icone icone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "LIST")
    private List<Equipa> listEquipas;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "COLAB")
    private Colaborador colab;

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
        return null;
    }
}
