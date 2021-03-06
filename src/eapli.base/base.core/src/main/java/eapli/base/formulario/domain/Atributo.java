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

    /*@Column(name="TipoDados")
    @Enumerated(EnumType.STRING)
    private TipoDados tipoDados;

    @Column(name="Obrigatoriedada")
    @Enumerated(EnumType.STRING)
    private Obrigatoriedade obrigatoriedade;*/

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "formulario")
    private Formulario formulario;

    protected Atributo() {
    }

    public void completaFormulario(Variavel valueOf) {
        this.nomeVariavel = valueOf;
    }

    public Long identity() {
        return id;
    }

    public Atributo(Variavel nomeVariavel, Label label,/* TipoDados tipo, Obrigatoriedade obr,*/ Formulario formulario){
        this.nomeVariavel=nomeVariavel;
        this.label=label;
        /*this.tipoDados=tipo;
        this.obrigatoriedade=obr;*/
        this.formulario = formulario;
    }

    @Override
    public String toString() {
        return "Atributo{" +
                "id=" + id +
                ", nomeVariavel=" + nomeVariavel +
                ", label=" + label +
                /*", tipoDados=" + tipoDados +
                ", obrigatoriedade=" + obrigatoriedade +*/
                ", formulario=" + formulario +
                '}';
    }
}
