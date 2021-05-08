package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
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

    @Column(name="Estado_Servico")
    @Enumerated(EnumType.STRING)
    private EstadoServico estado;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="formulario")
    private Formulario formulario;
*/

    public Servico(ServicoBuilder builder) {
        this.codigoUnico = builder.codigoUnico;
        this.titulo = builder.titulo;
        this.descricaoBreve = builder.descricaoBreve;
        this.descricaoCompleta = builder.descricaoCompleta;
  //      this.formulario= builder.formulario;
    }

    protected Servico() {
        this.codigoUnico = null;
        this.descricaoBreve=null;
        this.titulo=null;
        this.descricaoCompleta=null;
        this.estado=null;
    //    this.formulario=null;
    }


    //private Icone icone;


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public CodigoUnico identity() {
        return codigoUnico;
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

    public static class ServicoBuilder {

        private final CodigoUnico codigoUnico;

        private DescricaoBreve descricaoBreve;

        private DescricaoCompleta descricaoCompleta;

        private Titulo titulo;

        private Formulario formulario;

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

        public Servico build() {
            Servico servico = new Servico(this);
            //validateServico;
            return servico;
        }
    }
}
