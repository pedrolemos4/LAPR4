package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
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
public class FluxoAtividade implements DomainEntity<Long> {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id")
    private Long id;


    //@OneToOne (mappedBy = "fluxoAtividade")
    //private Servico servico;

    @Column(name = "ESTADOFLUXO")
    @Enumerated(EnumType.STRING)
    private EstadoFluxo estadoFluxo;


    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name= "ID_ATIVIDADE", referencedColumnName = "id")
    private Set<Atividade> listaAtividade = new HashSet<>();


    public FluxoAtividade(Set<Atividade> atividades) {
        this.listaAtividade = atividades;
        this.estadoFluxo = EstadoFluxo.PENDENTE;
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

    public void adicionaColaborador(Colaborador colab, Atividade idAtividade) {
        for (Atividade atividade : listaAtividade) {
            if (atividade.equals(idAtividade)) {
                atividade.adicionaColaborador(colab, idAtividade);
            }
        }

    }
}
