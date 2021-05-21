package eapli.base.pedido.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.servico.domain.Servico;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.swing.plaf.FileChooserUI;
import java.io.File;
import java.util.Set;

public class Pedido {

    @EmbeddedId
    @Column(name="id")
    private Identificador Id;

    @Column(name = "solicitador")
    private Colaborador colaborador;

    @Column(name = "dataSolicitacao")
    private Data dataSolicitacao;

    @Column(name = "servicoSolicitado")
    private Servico servico;

    @Column(name = "criticidade")
    private Criticidade criticidade;

    @Column(name = "urgencia")
    private UrgenciaPedido urgenciaPedido;

    @Column(name = "dataLimiteResolucao")
    private Data dataLimiteResolucao;

    Set<File> annexedFiles;


    public Pedido(Colaborador colaborador, Data dataSolicitacao, Servico servico, Criticidade criticidade, UrgenciaPedido urgenciaPedido, Data dataLimiteResolucao) {
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
}
