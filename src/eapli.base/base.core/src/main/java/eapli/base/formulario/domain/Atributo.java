package eapli.base.formulario.domain;

import eapli.base.servico.domain.Servico;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "formulario")
    private Formulario formulario;

    protected Atributo() {
        this.nomeVariavel=null;
        this.label = null;
        this.formulario = null;
    }

    private enum TipoDados{
        INTEGER ,STRING,BOOLEAN,DATA
    }

    public Atributo(Variavel nomeVariavel, Label label, Formulario formulario){
        this.nomeVariavel=nomeVariavel;
        this.label=label;
        this.formulario = formulario;
    }

    public Variavel nomeVariavel(){
        return this.nomeVariavel;
    }

    @Override
    public String toString() {
        return "Atributo{" +
                "nomeVariavel='" + nomeVariavel + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
