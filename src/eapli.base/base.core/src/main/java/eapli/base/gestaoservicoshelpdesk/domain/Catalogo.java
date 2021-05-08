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
public class Catalogo implements AggregateRoot<Long>{

    @Id
    @GeneratedValue
    private Long identificador;

    @Version
    private Long version;

    @Column(name="TITULO")
    private final Titulo titulo;

    @Column(name = "DESCCOMP")
    private final DescricaoCompletaCatalogo descricaoCompleta;

    @Column(name = "DESCBRE")
    private final DescricaoBreve descricaoBreve;

    @Column(name = "ICONE")
    private final Icone icone;

    @OneToMany()
    @JoinColumn(name = "LIST")
    private Set<Equipa> listEquipas = new HashSet<>();

    @OneToMany()
    @JoinTable(name="LISTSERVICOS")
    Set<Servico> listServicos = new HashSet<>();

    @OneToOne()
    @JoinColumn(name="COLABORADOR")
    private final Colaborador colab;

    public Catalogo(Titulo titulo, Colaborador colab, DescricaoCompletaCatalogo descricaoCompleta, DescricaoBreve descricaoBreve,
                    Icone icone, Iterable<Equipa> listEquipas){
        this.titulo=titulo;
        Preconditions.nonNull(colab);
        this.colab=colab;
        this.descricaoBreve=descricaoBreve;
        this.descricaoCompleta=descricaoCompleta;
        this.icone=icone;
        copyListEquipas(listEquipas);
    }

    public Catalogo(Titulo titulo, Colaborador colab, DescricaoCompletaCatalogo descricaoCompleta, DescricaoBreve descricaoBreve,
                    Icone icone, Iterable<Equipa> listEquipas, Iterable<Servico> listServicos){
        this.titulo=titulo;
        Preconditions.nonNull(colab);
        this.colab=colab;
        this.descricaoBreve=descricaoBreve;
        this.descricaoCompleta=descricaoCompleta;
        this.icone=icone;
        copyListEquipas(listEquipas);
        copyListServico(listServicos);
    }

    protected Catalogo() {
        this.descricaoBreve=null;
        this.descricaoCompleta=null;
        this.icone=null;
        this.colab=null;
        this.titulo=null;
    }

    private void copyListEquipas(Iterable<Equipa> listEquipas) {
        for(Equipa eq : listEquipas){
            this.listEquipas.add(eq);
        }
    }

    private void copyListServico(Iterable<Servico> listServico) {
        for(Servico s : listServico){
            this.listServicos.add(s);
        }
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
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
