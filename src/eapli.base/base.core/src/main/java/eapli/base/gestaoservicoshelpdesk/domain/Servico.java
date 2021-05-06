package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;

import java.util.Set;


public class Servico implements AggregateRoot<CodigoUnico> {

    private final CodigoUnico codigoUnico;

    private DescricaoBreve descricaoBreve;

    private DescricaoCompleta descricaoCompleta;

    private Titulo titulo;

    private EstadoServico estado;

    private Formulario formulario;

    private Servico(ServicoBuilder builder) {
        this.codigoUnico = builder.codigoUnico;
        this.titulo = builder.titulo;
        this.descricaoBreve = builder.descricaoBreve;
        this.descricaoCompleta = builder.descricaoCompleta;
        this.formulario= builder.formulario;
    }


    //private Icone icone;

    //private Catalogo catalogo;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public CodigoUnico identity() {
        return null;
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

        public ServicoBuilder withFormulario(String titulo, Set<Atributo> listaAtributos) {
            this.formulario = new Formulario(titulo, listaAtributos);
            return this;
        }

        public Servico build() {
            Servico servico = new Servico(this);
            //validateServico;
            return servico;
        }
    }
}
