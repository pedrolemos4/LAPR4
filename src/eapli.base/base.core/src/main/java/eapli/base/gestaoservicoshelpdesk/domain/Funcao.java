package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class Funcao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CODIGO")
    private CodigoUnico codigo;

    @Column(name = "DESCRICAO")
    private Descricao descricao;

    public Funcao(final CodigoUnico codigo, final Descricao descricao){
        Preconditions.nonNull(codigo);
        this.codigo=codigo;
            this.descricao=descricao;
    }

    protected Funcao() {
        this.descricao=null;
        this.codigo=null;
    }
}
