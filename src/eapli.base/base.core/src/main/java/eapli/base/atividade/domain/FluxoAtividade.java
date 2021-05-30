package eapli.base.atividade.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.domain.model.DomainEntity;

import javax.persistence.*;
import java.util.Calendar;
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
        if (!(other instanceof FluxoAtividade)) {
            return false;
        }
        final FluxoAtividade that = (FluxoAtividade) other;
        if (this == that) {
            return true;
        }
        return this.listaAtividade.equals(that.listaAtividade) && this.estadoFluxo.equals(that.estadoFluxo);
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

    public Set<Atividade> atividades() {
        return this.listaAtividade;
    }

    public void alterarEstado(EstadoFluxo estadoFluxo){
        this.estadoFluxo=estadoFluxo;
    }

    public void atualizarDataAtividade(Atividade atividade, Calendar dataLimiteRes) {
        atividade.atualizarDataAtividade(dataLimiteRes);
    }

    @Override
    public String toString() {
        return "FluxoAtividade{" +
                "estadoFluxo=" + estadoFluxo +
                ", listaAtividade=" + listaAtividade +
                '}';
    }
}
