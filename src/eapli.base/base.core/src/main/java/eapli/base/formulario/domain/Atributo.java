package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class Atributo implements ValueObject {

    @Id
    @GeneratedValue
    @Column(name="id_Atributo")
    private long id;

    @Column(name="Variavel")
    private Variavel nomeVariavel;

    @Column(name="Label")
    private Label label;

    @Column(name="TipoDados")
    @Enumerated(EnumType.STRING)
    private TipoDados tipoDados;

    @Column(name="Obrigatoriedade")
    @Enumerated(EnumType.STRING)
    private Obrigatoriedade obrigatoriedade;

    @Column(name = "DescricaoAjuda")
    private DescricaoAjuda descricaoAjuda;

    @Column(name = "ExpressaoRegular")
    private ExpressaoRegular expressaoRegular;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "formulario")
    private Formulario formulario;

    protected Atributo() {
    }

    public Long identity() {
        return id;
    }

    public Atributo(Variavel nomeVariavel, Label label, TipoDados tipo, Obrigatoriedade obr,
                    DescricaoAjuda descricao, ExpressaoRegular expressaoRegular, Formulario formulario){
        this.nomeVariavel=nomeVariavel;
        this.label=label;
        this.tipoDados=tipo;
        this.obrigatoriedade=obr;
        this.descricaoAjuda = descricao;
        this.expressaoRegular = expressaoRegular;
        this.formulario = formulario;
    }

    public Atributo(Label label, TipoDados tipo, Obrigatoriedade obr,
                    DescricaoAjuda desc, ExpressaoRegular expressaoRegular,Formulario formulario){
        this.label=label;
        this.tipoDados=tipo;
        this.obrigatoriedade=obr;
        this.descricaoAjuda=desc;
        this.expressaoRegular = expressaoRegular;
        this.formulario = formulario;
    }

    public Label label(){
        return this.label;
    }

    public TipoDados tipoDados(){
        return this.tipoDados;
    }

    public Obrigatoriedade obrigatoriedade(){
        return this.obrigatoriedade;
    }

    public DescricaoAjuda descricaoAjuda(){
        return this.descricaoAjuda;
    }

    public ExpressaoRegular expressaoRegular() {
        return this.expressaoRegular;
    }

    @Override
    public String toString() {
        return nomeVariavel +
                "; " + label +
                "; " + descricaoAjuda +
                "; " + tipoDados +
                "; " + obrigatoriedade;
    }
}
