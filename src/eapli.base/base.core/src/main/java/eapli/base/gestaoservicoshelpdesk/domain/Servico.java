package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.Description;

public class Servico implements AggregateRoot<CodigoUnico> {

    private final CodigoUnico codigoUnico;

    private DescricaoBreve descricaoBreve;

    private DescricaoCompleta descricaoCompleta;

    private Titulo titulo;

    private Servico(ServicoBuilder builder) {
        this.codigoUnico = builder.codigoUnico;
        this.titulo = builder.titulo;
        this.descricaoBreve = builder.descricaoBreve;
        this.descricaoCompleta = builder.descricaoCompleta;
    }

    //private Icone icone;

    //private Catalogo catalogo;

    //private Formulario formulario;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public CodigoUnico identity() {
        return null;
    }

    public static class ServicoBuilder {
        private final CodigoUnico codigoUnico;

        private DescricaoBreve descricaoBreve;

        private DescricaoCompleta descricaoCompleta;

        private Titulo titulo;

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

        public Servico build() {
            Servico servico = new Servico(this);
            //validateServico;
            return servico;
        }
    }
}
