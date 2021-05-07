package eapli.base.gestaoservicoshelpdesk.domain;

import javax.persistence.*;

@Entity
public class Funcao {

    @Id
    @GeneratedValue
    @Column(name = "CODIGO")
    private int codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Funcao(final int codigo, final String descricao){
        this.codigo=codigo;
        this.descricao=descricao;
    }
}
