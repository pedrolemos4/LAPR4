package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.AtividadeManual;
import eapli.base.atividades.domain.FluxoAtividade;
import eapli.base.catalogo.domain.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.Cor;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class ServicoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ServicoBootstrapper.class);

    private final EspecificarServicoController controller = new EspecificarServicoController();

    @Override
    public boolean execute() {
        Set<Atributo> listAtributos = new HashSet<>();
        listAtributos.add(new Atributo("nomeVariavel", "label"));
        Set<String> keywords = new HashSet<>();
        keywords.add("key1");

        Colaborador c1 = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), new Data(1984, 10, 25)
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));
        Set<Equipa> list = new HashSet<>();
        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(c1);
        list.add(new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol));


        Catalogo cat = new Catalogo(new Titulo("titulo1"), c1, new DescricaoCompletaCatalogo("descricaoCompleta"), new DescricaoBreve("descricaoBreve"), new Icone("icone"), list);
        register("cod123", "tituloServico", "descricaoServicoBreve", "descricaoServicoCompleta",
                "tituloFormulario", listAtributos, keywords, cat);

        Set<Atributo> listAtributos1 = new HashSet<>();
        listAtributos1.add(new Atributo("nomeVariavel1", "label1"));
        Set<String> keywords1 = new HashSet<>();
        keywords1.add("key2");

        register("cod147", "tituloServico1", "descricaoServicoBreve1", "descricaoServicoCompleta1",
                "tituloFormulario1", listAtributos1, keywords1, cat);

        Set<Atributo> listAtributos2 = new HashSet<>();
        listAtributos2.add(new Atributo("nomeVariavel1", "label1"));
        Set<String> keywords2 = new HashSet<>();
        keywords2.add("key2");
        keywords2.add("key1");

        //--------------------------------- SERVICOS DE OUTRO CATALOGO -------------------------------
        Colaborador c2 = new Colaborador(new MecanographicNumber(119876), new ShortName("Afonso"), new FullName("Afonso Sousa"), new Data(1992, 7, 5)
                , new Contacto(932705057), new LocalResidencia("Bairro Alto"), EmailAddress.valueOf("afonso@gmail.com"));
        Set<Colaborador> setCol1 = new HashSet<>();
        setCol1.add(c2);
        Set<Equipa> list2 = new HashSet<>();
        list2.add(new Equipa(new CodigoUnico("e2"), new Acronimo("EQP2"), new Designacao("equipa2"), new TipoEquipa(new CodigoUnico("te2"), new Designacao("tipo2"), new Cor(60, 60, 80)), setCol1));
        Catalogo cat2 = new Catalogo(new Titulo("titulo2"), c2, new DescricaoCompletaCatalogo("descricaoCompleta2"), new DescricaoBreve("descricaoBreve2"), new Icone("icone2"), list2);

        register("cod789", "tituloServico2", "descricaoServicoBreve2", "descricaoServicoCompleta2",
                "tituloFormulario2", listAtributos2, keywords2, cat2);

        return true;
    }

    private void register(final String codigoUnico, final String titulo, final String descricaoBreve,
                          final String descricaoCompleta, final String tituloFormulario, Set<Atributo> listaAtributos,
                          Set<String> keywords, Catalogo catalogo) {
        try {
            Formulario form = controller.createFormulario(tituloFormulario,listaAtributos);
            Set<Atividade> atividades = new HashSet<>();
            FluxoAtividade fluxoAtividade = new FluxoAtividade(atividades);
            controller.especificarServico(codigoUnico, titulo, descricaoBreve, descricaoCompleta,form,keywords,catalogo,fluxoAtividade);
            LOGGER.info(codigoUnico);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigoUnico);
            LOGGER.trace("Assuming existing record", e);
        }
    }

}

