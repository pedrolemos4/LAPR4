package eapli.base.servico.domain;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.DescricaoBreve;
import eapli.base.catalogo.domain.Titulo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.formulario.domain.Formulario;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Servico implements AggregateRoot<CodigoUnico> {

    @Version
    private Long version;

    @Id
    @Column(name="Codigo_Unico")
    private final CodigoUnico codigoUnico;

    @Column(name="Descricao_Breve")
    private DescricaoBreve descricaoBreve;

    @Column(name="Descricao_Completa")
    private DescricaoCompleta descricaoCompleta;

    @Column(name="Titulo",unique = true)
    private final Titulo titulo;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fluxo",referencedColumnName = "Id")//referencedColumnName = "Codigo_Unico")
    private FluxoAtividade fluxoAtividade;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "ser_fluxo",
            joinColumns =
                    { @JoinColumn(name = "servico_id", referencedColumnName = "Codigo_Unico") },
            inverseJoinColumns =
                    { @JoinColumn(name = "fluxo_id", referencedColumnName = "Id") })
    private FluxoAtividade fluxoAtividade;*/

    @Column(name="Estado_Servico")
    @Enumerated(EnumType.STRING)
    private EstadoServico estado;

    @ElementCollection
    private Set<String> keywords;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="formulario",referencedColumnName = "id")
    private Formulario formulario;


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade =
            CascadeType.ALL)
    @JoinColumn(name="catalogo")
    private Catalogo catalogo;


    public Servico(ServicoBuilder builder) {
        this.codigoUnico = builder.codigoUnico;
        this.titulo = builder.titulo;
        this.descricaoBreve = builder.descricaoBreve;
        this.descricaoCompleta = builder.descricaoCompleta;
        this.keywords = builder.keywords;
        this.formulario= builder.formulario;
        this.catalogo=builder.catalogo;
        this.fluxoAtividade=builder.fluxoAtividade;
    }

    protected Servico() {
        this.codigoUnico = null;
        this.descricaoBreve=null;
        this.titulo=null;
        this.descricaoCompleta=null;
        this.estado=null;
        this.keywords=null;
        this.formulario=null;
        this.catalogo=null;
        this.formulario=null;
        this.fluxoAtividade=null;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "codigoUnico=" + codigoUnico +
                ", descricaoBreve=" + descricaoBreve +
                ", descricaoCompleta=" + descricaoCompleta +
                ", titulo=" + titulo +
                ", estado=" + estado +
                '}';
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public CodigoUnico identity() {
        return codigoUnico;
    }

    public DescricaoBreve descricaoBreve() {
        return descricaoBreve;
    }

    public EstadoServico estado() {
        return estado;
    }

    public void makeAvailable() {
        this.estado = EstadoServico.DISPONIVEL;
    }

    public void makeUnavailable() {
        this.estado = EstadoServico.INDISPONIVEL;
    }

    public boolean estaDisponivel() {
        return estado() == EstadoServico.DISPONIVEL;
    }

    public boolean estaIndisponivel() {
        return estado() == EstadoServico.INDISPONIVEL;
    }

    public void adicionaColaborador(Colaborador colab, Atividade idAtividade) {
        this.fluxoAtividade.adicionaColaborador(colab, idAtividade);
    }

    public static class ServicoBuilder {

        private final CodigoUnico codigoUnico;

        private DescricaoBreve descricaoBreve;

        private DescricaoCompleta descricaoCompleta;

        private Titulo titulo;

        private Formulario formulario;

        private Set<String> keywords;

        private Catalogo catalogo;

        private FluxoAtividade fluxoAtividade;

        public ServicoBuilder(String codigoUnico, String titulo) {
            this.codigoUnico = new CodigoUnico(codigoUnico);
            this.titulo = new Titulo(titulo);
        }

        public ServicoBuilder withDescricaoBreve(String descricaoBreve) {
            this.descricaoBreve = new DescricaoBreve(descricaoBreve);
            return this;
        }

        public ServicoBuilder withDescricaoCompleta(String descricaoCompleta) {
            this.descricaoCompleta = new DescricaoCompleta(descricaoCompleta);
            return this;
        }

        public ServicoBuilder withFormulario(Formulario formulario) {
            this.formulario = formulario;
            return this;
        }

        public ServicoBuilder withKeywords(Set<String> keywords){
            this.keywords = new HashSet<>(keywords);
            return this;
        }

        public ServicoBuilder withCatalogo(Catalogo catalogo){
            this.catalogo=catalogo;
            return this;
        }

       public ServicoBuilder withFluxo(FluxoAtividade fluxo){
            this.fluxoAtividade=fluxo;
            return this;
        }


        public Servico build() {
            Servico servico = new Servico(this);
            //validateServico;
            return servico;
        }
    }
}
