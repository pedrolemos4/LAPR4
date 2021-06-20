package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.atividade.domain.*;
import eapli.base.catalogo.domain.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.*;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.*;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class ServicoBootstrapper implements Action {

    private static final Logger LOGGER = LogManager.getLogger(ServicoBootstrapper.class);

    private final EspecificarServicoController controller = new EspecificarServicoController();

    @Override
    public boolean execute() {
        //Lista Atributos
        Set<Atributo> listaAtributosFormulario1 = new HashSet<>();
        Set<Atributo> listaAtributosFormulario2 = new HashSet<>();
        Set<Atributo> listaAtributosFormulario3 = new HashSet<>();
        Set<Atributo> listaAtributosFormulario4 = new HashSet<>();
        Set<Atributo> listaAtributosFormulario5 = new HashSet<>();
        //Keywords
        Set<String> keywords = new HashSet<>();
        keywords.add("Paz");

        Set<String> keywords1 = new HashSet<>();
        keywords1.add("Pastilha");

        Set<String> keywords2 = new HashSet<>();
        keywords2.add("Gado");
        keywords2.add("Ferreiro");

        //Datas
        Calendar dataAux1 = Calendar.getInstance();
        dataAux1.set(1984, 10, 25);

        Calendar dataAux2 = Calendar.getInstance();
        dataAux2.set(1992, 07, 05);

        Calendar dataAux3 = Calendar.getInstance();
        dataAux3.set(1996, 11, 11);

        //Colaboradores
        Set<Funcao> funcao = new HashSet<>();
        funcao.add(Funcao.DIRETOR);
        funcao.add(Funcao.GESTOR_CLIENTES);
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"), funcao);

        Set<Funcao> funcao2 = new HashSet<>();
        funcao2.add(Funcao.GESTOR_CLIENTES);
        Colaborador c2 = new Colaborador(new MecanographicNumber(119876), new ShortName("Afonso"), new FullName("Afonso Sousa"), dataAux2
                , new Contacto(932705057), new LocalResidencia("Bairro Alto"), EmailAddress.valueOf("afonso@gmail.com"), funcao2);

        Set<Funcao> funcao3 = new HashSet<>();
        funcao3.add(Funcao.COMERCIAL);
        funcao3.add(Funcao.ASSISTENTE_DIRECAO);
        Colaborador c3 = new Colaborador(new MecanographicNumber(160108), new ShortName("Pedro"), new FullName("Pedro Santos"), dataAux3
                , new Contacto(351, 962574102), new LocalResidencia("Lisboa"), EmailAddress.valueOf("pedroS@gmail.com"), funcao3);

        //Listas Colaboradores
        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(c1);
        setCol.add(c2);

        Set<Colaborador> setCol1 = new HashSet<>();
        setCol1.add(c2);
        setCol1.add(c3);

          //Equipas
        Set<Equipa> listEquipas1 = new HashSet<>();
        Equipa equipa1 = new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol);
        System.out.println("Membros Equipa 1: " +equipa1.listMembros().size());
        listEquipas1.add(equipa1);

        Set<Equipa> listEquipas2 = new HashSet<>();
        Equipa equipa2 = new Equipa(new CodigoUnico("e2"), new Acronimo("EQP2"), new Designacao("equipa2"), new TipoEquipa(new CodigoUnico("te2"), new Designacao("tipo2"), new Cor(60, 60, 80)), setCol1);
        System.out.println("Membros Equipa 2: " +equipa2.listMembros().size());
        listEquipas2.add(equipa2);


        Set<Equipa> listEquipas3 = new HashSet<>();
        listEquipas3.add(equipa1);
        listEquipas3.add(equipa2);

        //Catalogos
        Catalogo catalogo1 = new Catalogo(new Titulo("Catalogo Exemplo"), c1, new DescricaoCompletaCatalogo("Descricao completa do exemplo"), new DescricaoBreve("Descricao exemplo"), new Icone("icone1"), listEquipas1, new Criticidade(new Etiqueta("MODERADA"), new Escala(3), new Designacao("Name1"), new Objetivo(13, 11, 13, 11), new Cor(18, 241, 26)));
        catalogo1 = this.controller.saveCatalogo(catalogo1);
        Catalogo catalogo2 = new Catalogo(new Titulo("Catalogo Teste"), c2, new DescricaoCompletaCatalogo("Descricao completa do teste"), new DescricaoBreve("Descricao teste"), new Icone("icone2"), listEquipas2, new Criticidade(new Etiqueta("MODERADA"), new Escala(3), new Designacao("Name2"), new Objetivo(18, 15, 11, 11), new Cor(13, 13, 13)));
        catalogo2 = this.controller.saveCatalogo(catalogo2);
        Catalogo catalogo3 = new Catalogo(new Titulo("Catalogo Teste2"), c3, new DescricaoCompletaCatalogo("Descricao completa do teste2"), new DescricaoBreve("Descricao teste2"), new Icone("icone3"), listEquipas3, new Criticidade(new Etiqueta("BAIXA"), new Escala(1), new Designacao("Name3"), new Objetivo(13, 11, 18, 14), new Cor(255, 255, 36)));

        //Atividades
        Set<Atividade> atividades1 = new HashSet<>();
        AtividadeAutomatica atividadeAutomatica1 = controller.novaAtividadeAutomatica("script_teste.txt");
        Formulario form1 = preencherAtributos("Formulario1",listaAtributosFormulario2);
        AtividadeManual atividadeManual2 = controller.novaAtividadeAprovacaoManualColaborador(c1, form1, TipoAtividade.APROVACAO);
        atividades1.add(atividadeManual2);
        atividades1.add(atividadeAutomatica1);

        Set<Atividade> atividades2 = new HashSet<>();
        Formulario form2 = preencherAtributos("Formulario2",listaAtributosFormulario4);
        AtividadeManual a1 = controller.novaAtividadeAprovacaoManualColaborador(c2, form2, TipoAtividade.REALIZACAO);
        atividades2.add(a1);

        Set<Atividade> atividades3 = new HashSet<>();
        Formulario form3 = preencherAtributos("Formulario3",listaAtributosFormulario5);
        AtividadeManual a2 = controller.novaAtividadeAprovacaoManualEquipa(listEquipas1, form3, TipoAtividade.APROVACAO);
        atividades3.add(a2);

        Set<Atividade> atividades4 = new HashSet<>();
        Formulario form4 = preencherAtributos("Formulario4",listaAtributosFormulario3);
        AtividadeManual a3 = controller.novaAtividadeAprovacaoManualColaborador(c1, form4, TipoAtividade.REALIZACAO);
        atividades4.add(a3);

        Set<Atividade> atividades5 = new HashSet<>();
        Formulario form5 = preencherAtributos("Formulario5",listaAtributosFormulario1);
        AtividadeManual a4 = controller.novaAtividadeAprovacaoManualEquipa(listEquipas2, form5, TipoAtividade.REALIZACAO);
        atividades5.add(a4);

        //Register
        register("cod123", "tituloServico", "descricaoServicoBreve", "descricaoServicoCompleta",
                "Tituloformulario0", keywords, catalogo1, new FluxoAtividade(atividades1));

        register("cod147", "tituloServico1", "descricaoServicoBreve1", "descricaoServicoCompleta1",
                "Tituloformulario1", keywords1, catalogo1, new FluxoAtividade(atividades2));

        register("cod789", "tituloServico2", "descricaoServicoBreve2", "descricaoServicoCompleta2",
                "Tituloformulario2", keywords2, catalogo2, new FluxoAtividade(atividades3));

        register("cod987", "tituloServico3", "descricaoBreve3", "descricaoServicoCompleta3",
                "Tituloformulario3", keywords1, catalogo1, new FluxoAtividade(atividades4));

        register("cod007", "tituloServico4", "descricaoBreve4", "descricaoServicoCompleta4",
                "Tituloformulario4" , keywords, catalogo2, new FluxoAtividade(atividades5));

        return true;
    }

    private void register(final String codigoUnico, final String titulo, final String descricaoBreve,
                          final String descricaoCompleta, final String tituloFormulario,
                          Set<String> keywords, Catalogo catalogo, FluxoAtividade fluxoAtividade) {
        try {
            Set<Atributo> listaAtributosFormulario1 = new HashSet<>();
            Formulario form = preencherAtributos(tituloFormulario,listaAtributosFormulario1);
            controller.especificarServico(codigoUnico, titulo, descricaoBreve, descricaoCompleta, form, keywords, catalogo, fluxoAtividade);
            LOGGER.info(codigoUnico);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", codigoUnico);
            LOGGER.trace("Assuming existing record", e);
        }
    }

    private Formulario preencherAtributos(String titulo, Set<Atributo> listaAtributos) {
        Formulario formulario = new Formulario(titulo);
        criarAtributos(listaAtributos, formulario);
        formulario.copyAtributos(listaAtributos);
        return formulario;
    }

    public void criarAtributos(Set<Atributo> listaAtributos, Formulario formulario) {
        Atributo atributo = controller.createAtributo("Label", "String",
                "Obrigatorio", "Descricao Ajuda", null, formulario);
        listaAtributos.add(atributo);
    }
}

