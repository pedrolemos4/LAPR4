package eapli.base.atividades.domain;

import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FluxoAtividade implements DomainEntity<Long>{

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="Id")
    private Long id;


    //@OneToOne (mappedBy = "fluxoAtividade")
    //private Servico servico;


    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name= "ID_ATIVIDADE", referencedColumnName = "id")
    private Set<AtividadeManual> listaAtividade = new HashSet<>();


    public FluxoAtividade(Set<AtividadeManual> atividades){
        this.listaAtividade=atividades;
    }

    protected FluxoAtividade() {
     //   this.value = null;
      //  this.listaAtividade=null;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }
}
