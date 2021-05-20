package eapli.base.draft.domain;

import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.formulario.domain.Atributo;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DraftServico implements AggregateRoot<String> {

    @Id
    @Column(name = "Codigo_Unico")
    private final String codigoUnico;

    @Column(name = "DescricaoBreve")
    private String descricaoBreve;

    @Column(name = "DescricaoCompleta")
    private String descricaoCompleta;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "TituloFormulario")
    private String tituloFormulario;

    @OneToOne(cascade = CascadeType.ALL)
    //  @JoinColumn(name = "fluxo",referencedColumnName = "value")
    private FluxoAtividade fluxo;

    @ElementCollection
    private Set<Atributo> listaAtributos;

    @ElementCollection
    private Set<String> keywords;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Catalogo catalogo;

    protected DraftServico() {
        this.codigoUnico = null;
        this.descricaoCompleta = null;
        this.descricaoBreve = null;
        this.titulo = null;
        this.tituloFormulario = null;
        this.keywords = null;
        this.catalogo = null;
        this.fluxo = null;
    }

    public DraftServico(String codigoUnico, String descricaoBreve, String descricaoCompleta, String titulo,
                        String tituloFormulario, Set<Atributo> listaAtributos, Set<String> keywords, Catalogo catalogo,FluxoAtividade fluxo) {
        Preconditions.nonEmpty(codigoUnico, "O código único tem de ser especificado.");
        Preconditions.nonEmpty(titulo, "O título tem de ser especificado.");
        Preconditions.nonEmpty(tituloFormulario, "O título do formulário tem de ser especificado.");
        Preconditions.ensure(titulo.length() <= 500, "O título de um serviço deve ter no máximo 500 caracteres.");
        Preconditions.ensure(tituloFormulario.length() <= 500, "O título de um formulário deve ter no máximo 500 caracteres.");
        this.codigoUnico = codigoUnico;
        this.descricaoBreve = descricaoBreve;
        this.descricaoCompleta = descricaoCompleta;
        this.titulo = titulo;
        this.tituloFormulario = tituloFormulario;
        this.listaAtributos = new HashSet<>(listaAtributos);
        this.keywords = new HashSet<>(keywords);
        this.catalogo = catalogo;
        this.fluxo=fluxo;
    }

    public String codigoUnico() {
        return this.codigoUnico;
    }

    public String descricaoBreve() {
        return this.descricaoBreve;
    }

    public String descricaoCompleta() {
        return this.descricaoCompleta;
    }

    public String titulo() {
        return this.titulo;
    }

    public String tituloFormulario() {
        return this.tituloFormulario;
    }

    public Set<Atributo> listaAtributos() {
        return this.listaAtributos;
    }

    public Catalogo catalogo() {
        return this.catalogo;
    }

    public Set<String> keywords() {
        return this.keywords;
    }

    public FluxoAtividade fluxo() { return this.fluxo; }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public String identity() {
        return codigoUnico;
    }

    @Override
    public String toString() {
        return "DraftServico{" +
                "codigoUnico='" + codigoUnico + '\'' +
                ", descricaoBreve='" + descricaoBreve + '\'' +
                ", descricaoCompleta='" + descricaoCompleta + '\'' +
                ", titulo='" + titulo + '\'' +
                ", tituloFormulario='" + tituloFormulario + '\'' +
                ", listaAtributos=" + listaAtributos +
                '}';
    }
}
