package eapli.base.pedido.domain;

import eapli.base.atividades.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Pedido implements AggregateRoot<Identificador> {

    @Id
    @Column(name="id")
    private Identificador Id;

    @ManyToOne
    @JoinColumn(name = "colaborador")
    private Colaborador colaborador;

    @Column(name = "dataSolicitacao")
    private Date dataSolicitacao;

    @OneToOne
    @JoinColumn(name = "servico")
    private Servico servico;

    @Column(name = "criticidade")
    private Criticidade criticidade;

    @Column(name = "urgencia")
    private UrgenciaPedido urgenciaPedido;

    @Column(name = "dataLimiteResolucao")
    private Date dataLimiteResolucao;

    //Set<File> annexedFiles;

    protected Pedido() {

    }

    public Pedido(Colaborador colaborador, Date dataSolicitacao, Servico servico, Criticidade criticidade, UrgenciaPedido urgenciaPedido, Date dataLimiteResolucao) {
        this.Id = new Identificador();
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

    public void adicionaColaborador(Colaborador colab, Atividade idAtividade) {
        this.servico.adicionaColaborador(colab, idAtividade);
    }

    public Servico servico() { return this.servico;}
}
