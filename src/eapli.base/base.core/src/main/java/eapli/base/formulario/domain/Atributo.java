package eapli.base.formulario.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Atributo implements ValueObject {

    @Column(name="Nome_Variavel")
    private Variavel nomeVariavel;

    @Column(name="Label")
    private Label label;

    @Column(name="Obrigatorio")
    private boolean flag;

    @Column(name="Tipo_Atributo")
    @Enumerated(EnumType.STRING)
    private TipoDados tipoDados;

    protected Atributo() {
    }

    public Atributo(Variavel nomeVariavel, Label label, boolean flag, TipoDados tipoDados) {
        this.nomeVariavel = nomeVariavel;
        this.label = label;
        this.flag = flag;
        this.tipoDados = tipoDados;
    }

    @Override
    public String toString() {
        return "Atributo{" +
                "nomeVariavel=" + nomeVariavel +
                ", label=" + label +
                ", obrigatorio=" + flag +
                ", tipoDados=" + tipoDados +
                '}';
    }
}
