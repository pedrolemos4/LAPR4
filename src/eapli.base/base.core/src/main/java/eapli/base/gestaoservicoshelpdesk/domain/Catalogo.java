package eapli.base.gestaoservicoshelpdesk.domain;

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
    @Column(name="id")
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
    @JoinTable(name = "LIST",
            joinColumns = @JoinColumn(name = "identificadorCat"),
            inverseJoinColumns = @JoinColumn(name = "equipaId"))
    private Set<Equipa> listEquipas = new HashSet<>();

    @OneToMany(mappedBy = "catalogo")
    private Set<Servico> listServicos = new HashSet<>();

    @OneToMany(mappedBy = "catalogo")
    private Set<DraftServico> listDrafts = new HashSet<>();

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
        if(!(other instanceof Catalogo)){
            return false;
        }
        final Catalogo that = (Catalogo) other;
        if(this == that){
            return true;
        }
        return titulo.equals(that.titulo) && descricaoCompleta.equals(that.descricaoCompleta) && descricaoBreve.equals(that.descricaoBreve) &&
                icone.equals(that.icone); //&& colab.equals(that.colab);
    }

    @Override
    public Long identity() {
        return this.identificador;
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
    public String toString() {
        return "Catalogo{" +
                "titulo=" + titulo +
                ", descricaoCompleta=" + descricaoCompleta +
                ", descricaoBreve=" + descricaoBreve +
                ", icone=" + icone +
                ", listEquipas=" + listEquipas +
                ", listServicos=" + listServicos +
                ", colab=" + colab +
                '}';
    }
}
