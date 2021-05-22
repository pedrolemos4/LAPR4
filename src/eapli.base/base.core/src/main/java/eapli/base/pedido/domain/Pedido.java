package eapli.base.pedido.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.File;
import java.util.Date;
import java.util.Set;

@Entity
public class Pedido implements AggregateRoot<Identificador> {

    @EmbeddedId
    @Column(name="id")
    private Identificador Id;

    @Column(name = "solicitador")
    private Colaborador colaborador;

    @Column(name = "dataSolicitacao")
    private Date dataSolicitacao;

    @Column(name = "servicoSolicitado")
    private Servico servico;

    @Column(name = "criticidade")
    private Criticidade criticidade;

    @Column(name = "urgencia")
    private UrgenciaPedido urgenciaPedido;

    @Column(name = "dataLimiteResolucao")
    private Date dataLimiteResolucao;

    Set<File> annexedFiles;

    protected Pedido() {

    }

    public Pedido(Colaborador colaborador, Date dataSolicitacao, Servico servico, Criticidade criticidade, UrgenciaPedido urgenciaPedido, Date dataLimiteResolucao) {
        this.Id = new Identificador().getIdentificador();
        this.colaborador = colaborador;
        this.dataSolicitacao = dataSolicitacao;
        this.servico = servico;
        this.criticidade = criticidade;
        this.urgenciaPedido = urgenciaPedido;
        this.dataLimiteResolucao = dataLimiteResolucao;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "Id=" + Id +
                ", colaborador=" + colaborador +
                ", dataSolicitacao=" + dataSolicitacao +
                ", servico=" + servico +
                ", criticidade=" + criticidade +
                ", urgenciaPedido=" + urgenciaPedido +
                ", dataLimiteResolucao=" + dataLimiteResolucao +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        Pedido pedido = (Pedido) other;
        return this.identity() == pedido.identity();
    }

    @Override
    public Identificador identity() {
        return this.Id;
    }
}
