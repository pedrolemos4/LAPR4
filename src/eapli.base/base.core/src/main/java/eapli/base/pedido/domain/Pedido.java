package eapli.base.pedido.domain;

import eapli.base.atividades.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.pedido.generators.IdentificadorGenerator;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Pedido implements AggregateRoot<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ano_seq")
    @GenericGenerator(name = "ano_seq",
            strategy = "eapli.base.pedido.generators.IdentificadorGenerator",parameters = {
            @org.hibernate.annotations.Parameter(name = IdentificadorGenerator.INCREMENT_PARAM, value = "1"),
            @org.hibernate.annotations.Parameter(name = IdentificadorGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
    })
    @Column(name = "identificador")
    private String Id;

    @ManyToOne
    @JoinColumn(name = "colaborador")
    private Colaborador colaborador;

    @Column(name = "dataSolicitacao")
    @Temporal(TemporalType.DATE)
    private Date dataSolicitacao;

    @OneToOne
    @JoinColumn(name = "servico")
    private Servico servico;

    @Column(name = "urgencia")
    @Enumerated(EnumType.STRING)
    private UrgenciaPedido urgenciaPedido;

    @Column(name = "dataLimiteResolucao")
    @Temporal(TemporalType.DATE)
    private Calendar dataLimiteResolucao;

    @Column(name = "estadoPedido")
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    //Set<File> annexedFiles;

    protected Pedido() {

    }

    public Pedido(Colaborador colaborador, LocalDate dataSolicitacao, Servico servico, UrgenciaPedido urgenciaPedido, Calendar dataLimiteResolucao) {
        this.colaborador = colaborador;
        this.dataSolicitacao = java.sql.Date.valueOf(dataSolicitacao);
        this.servico = servico;
        this.urgenciaPedido = urgenciaPedido;
        this.dataLimiteResolucao = dataLimiteResolucao;
        this.estado = EstadoPedido.SUBMETIDO;
    }

    @Override
    public String toString() {
        return "Pedido: " +
                colaborador +
                ", UrgenciaPedido: " + urgenciaPedido +
                ", DataLimiteResolucao: " + dataLimiteResolucao +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        Pedido pedido = (Pedido) other;
        return this.identity() == pedido.identity();
    }

    @Override
    public String identity() {
        return this.Id;
    }

    public void adicionaColaborador(Colaborador colab, Atividade idAtividade) {
        this.servico.adicionaColaborador(colab, idAtividade);
    }

    public Servico servico() { return this.servico;}
}
