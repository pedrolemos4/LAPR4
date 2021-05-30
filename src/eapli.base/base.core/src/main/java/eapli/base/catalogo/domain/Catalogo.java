package eapli.base.catalogo.domain;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.draft.domain.DraftServico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.Servico;
import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.*;

@Entity
public class Catalogo implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long identificador;

    @Version
    private Long version;

    @Column(name = "TITULO")
    private final Titulo titulo;

    @Column(name = "DESCCOMP")
    private final DescricaoCompletaCatalogo descricaoCompleta;

    @Column(name = "DESCBRE")
    private final DescricaoBreve descricaoBreve;

    @Column(name = "ICONE")
    private final Icone icone;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EQUIPA", referencedColumnName = "id")
    private Set<Equipa> listEquipas = new HashSet<>();

    @OneToMany(mappedBy = "catalogo", fetch = FetchType.LAZY, cascade =
            CascadeType.ALL)
    private Set<Servico> listServicos = new HashSet<>();

    @OneToMany(mappedBy = "catalogo")
    private Set<DraftServico> listDrafts = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLABORADOR")
    private final Colaborador colab;

    @OneToOne(cascade = CascadeType.ALL)
    private Criticidade criticidade;

    @Column(name = "Objetivo")
    private Objetivo objetivo;

    public Catalogo(Titulo titulo, Colaborador colab, DescricaoCompletaCatalogo descricaoCompleta, DescricaoBreve descricaoBreve,
                    Icone icone, Iterable<Equipa> listEquipas, Criticidade criticidade) {
        this.titulo = titulo;
        Preconditions.nonNull(colab);
        this.colab = colab;
        this.descricaoBreve = descricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.icone = icone;
        this.criticidade = criticidade;
        copyListEquipas(listEquipas);
    }

    public Catalogo(Titulo titulo, Colaborador colab, DescricaoCompletaCatalogo descricaoCompleta, DescricaoBreve descricaoBreve,
                    Icone icone, Iterable<Equipa> listEquipas, Iterable<Servico> listServicos, Criticidade criticidade) {
        this.titulo = titulo;
        Preconditions.nonNull(colab);
        this.colab = colab;
        this.descricaoBreve = descricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.icone = icone;
        this.criticidade = criticidade;
        copyListEquipas(listEquipas);
        copyListServico(listServicos);
    }

    protected Catalogo() {
        this.descricaoBreve = null;
        this.descricaoCompleta = null;
        this.icone = null;
        this.colab = null;
        this.titulo = null;
        this.criticidade = null;
        this.objetivo=null;
    }

    private void copyListEquipas(Iterable<Equipa> listEquipas) {
        if (listEquipas != null)
            for (Equipa eq : listEquipas) {
                this.listEquipas.add(eq);
            }
    }

    private void copyListServico(Iterable<Servico> listServico) {
        for (Servico s : listServico) {
            this.listServicos.add(s);
        }
    }

    public void associarObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public void atribuirCriticidade(Criticidade criticidade) {
        this.criticidade = criticidade;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Catalogo)) {
            return false;
        }
        final Catalogo that = (Catalogo) other;
        if (this == that) {
            return true;
        }
        return titulo.equals(that.titulo) && descricaoCompleta.equals(that.descricaoCompleta) && descricaoBreve.equals(that.descricaoBreve) &&
                icone.equals(that.icone); //&& colab.equals(that.colab);
    }

    @Override
    public Long identity() {
        return this.identificador;
    }

    public Titulo titulo() {
        return this.titulo;
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
                " criticidade=" + criticidade +
                '}';
    }
}
