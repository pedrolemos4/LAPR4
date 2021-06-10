package eapli.base.pedido.domain;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.Comentario;
import eapli.base.atividade.domain.Decisao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Variavel;
import eapli.base.pedido.generators.IdentificadorGenerator;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.util.Calendar;

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
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataSolicitacao;

    @ManyToOne(optional = true)
    @JoinColumn(name = "servico")
    private Servico servico;

    @Column(name = "urgencia")
    @Enumerated(EnumType.STRING)
    private UrgenciaPedido urgenciaPedido;

    @Column(name = "grauSatisfacao")
    private GrauSatisfacao grau;

    @Column(name = "dataLimiteResolucao")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataLimiteResolucao;

    @Column(name = "estadoPedido")
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "formulario")
    private Formulario formulario;

 /*   @Lob
    @Basic(fetch = FetchType.LAZY)
    private List<File> annexedFiles = new ArrayList<>();
*/

    protected Pedido() {
        //for ORM
    }

    public Pedido(Colaborador colaborador, Calendar dataSolicitacao, Servico servico, UrgenciaPedido urgenciaPedido, Calendar dataLimiteResolucao,Formulario formulario) {
        this.colaborador = colaborador;
        this.dataSolicitacao = dataSolicitacao;
        this.servico = servico;
        this.urgenciaPedido = urgenciaPedido;
        this.dataLimiteResolucao = dataLimiteResolucao;
        this.estado = EstadoPedido.SUBMETIDO;
        this.formulario = formulario;
        this.grau = null;
    }

    @Override
    public String toString() {
        return "Pedido: " +
                colaborador +
                ", UrgenciaPedido: " + urgenciaPedido +
                ", DataLimiteResolucao: " + dataLimiteResolucao.getTime() + "Grau Satisfação: " + grau;
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

    public void atribuirGrau(GrauSatisfacao g) {
        this.grau = g;
    }

    public void alterarEstadoPedido(EstadoPedido estadoPedido){
        this.estado=estadoPedido;
    }

    public void annexFile(File file){
     //   this.annexedFiles.add(file);
    }

    public Servico servico() { return this.servico;}

    public void completaFormulario(Variavel variavel, Atributo atributo) {
        this.formulario.completaFormulario(variavel, atributo);
    }

    public void completaDecisaoComentario(Comentario valueOf, Decisao aprovado, Atividade at) {
        this.servico.completaDecisaoComentario(valueOf,aprovado,at);
    }
}
