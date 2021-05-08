package eapli.base.gestaoservicosrh.domain;

import eapli.base.gestaoservicoshelpdesk.domain.Cor;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity

public class TipoEquipa implements AggregateRoot<CodigoUnico> {

    @Version
    private Long version;

    @Id
    @Column(name="Codigo_Unico")
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
        Preconditions.nonNull(cor);
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
