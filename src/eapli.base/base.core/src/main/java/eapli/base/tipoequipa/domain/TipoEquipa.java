package eapli.base.tipoequipa.domain;

import eapli.base.criticidade.domain.Cor;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity

public class TipoEquipa implements AggregateRoot<CodigoUnico> {

    @Version
    private Long version;

    @Id
    @Column(name="Codigo_Unico")
    //@OneToOne(targetEntity = Equipa.class)
    private final CodigoUnico codigoUnico;

    @Column(name="Designacao")
    private final Designacao designacao;

    @Column(name="Cor")
    private final Cor cor;


    protected TipoEquipa(){
        this.codigoUnico=null;
        this.designacao=null;
        this.cor=null;
    }

    public TipoEquipa(CodigoUnico codigoUnico,Designacao designacao,Cor cor){
        Preconditions.noneNull(cor);
        this.codigoUnico=codigoUnico;
        this.designacao=designacao;
        this.cor=cor;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public CodigoUnico identity() {
        return codigoUnico;
    }

    @Override
    public String toString() {
        return "TipoEquipa{" +
                ", codigoUnico=" + codigoUnico +
                ", designacao=" + designacao +
                ", cor=" + cor +
                '}';
    }
}
