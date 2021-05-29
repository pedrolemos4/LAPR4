package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.atividades.domain.*;
import eapli.base.catalogo.domain.*;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.domain.*;
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
        listaAtributosFormulario1.add(new Atributo("Nome", "Label do nome"));

        Set<Atributo> listaAtributosFormulario2 = new HashSet<>();
        listaAtributosFormulario2.add(new Atributo("Nome Completo", "Label do nome completo"));
        listaAtributosFormulario2.add(new Atributo("Idade", "Label da idade"));

        Set<Atributo> listaAtributosFormulario3 = new HashSet<>();
        listaAtributosFormulario3.add(new Atributo("Morada", "Label da morada"));

        Set<Atributo> listaAtributosFormulario4 = new HashSet<>();
        listaAtributosFormulario4.add(new Atributo("Nome Completo", "Label do nome completo"));
        listaAtributosFormulario4.add(new Atributo("Idade", "Label da idade"));
        listaAtributosFormulario4.add(new Atributo("Morada", "Label da morada"));
        listaAtributosFormulario4.add(new Atributo("Telefone", "Label do telefone"));

        Set<Atributo> listaAtributosFormulario5 = new HashSet<>();
        listaAtributosFormulario5.add(new Atributo("Telemovel", "Label do telemovel"));

        Set<Atributo> listaAtributosFormulario6 = new HashSet<>();
        listaAtributosFormulario6.add(new Atributo("Endereco Postal", "Label endereco postal"));


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
        dataAux1.set(1984,10,25);

        Calendar dataAux2 = Calendar.getInstance();
        dataAux2.set(1992,07,05);

        Calendar dataAux3 = Calendar.getInstance();
        dataAux3.set(1996,11,11);


        //Colaboradores
        Colaborador c1 = new Colaborador(new MecanographicNumber(119080), new ShortName("Joao"), new FullName("Joao Alves Pereira"), dataAux1
                , new Contacto(965824578), new LocalResidencia("Penafiel"), EmailAddress.valueOf("joao@gmail.com"));

        Colaborador c2 = new Colaborador(new MecanographicNumber(119876), new ShortName("Afonso"), new FullName("Afonso Sousa"), dataAux2
                , new Contacto(932705057), new LocalResidencia("Bairro Alto"), EmailAddress.valueOf("afonso@gmail.com"));

        Colaborador c3 = new Colaborador(new MecanographicNumber(160108), new ShortName("Pedro"), new FullName("Pedro Santos"), dataAux3
                , new Contacto(351,962574102), new LocalResidencia("Lisboa"), EmailAddress.valueOf("pedroS@gmail.com"));

        //Listas Colaboradores
        Set<Colaborador> setCol = new HashSet<>();
        setCol.add(c1);

        Set<Colaborador> setCol1 = new HashSet<>();
        setCol1.add(c2);
        setCol1.add(c3);

        //Equipas
        Set<Equipa> listEquipas1 = new HashSet<>();
        Equipa equipa1 = new Equipa(new CodigoUnico("e1"), new Acronimo("EQP1"), new Designacao("desig1"), new TipoEquipa(new CodigoUnico("t1"), new Designacao("tipo1"), new Cor(10, 20, 30)), setCol);
        listEquipas1.add(equipa1);

        Set<Equipa> listEquipas2 = new HashSet<>();
        Equipa equipa2 = new Equipa(new CodigoUnico("e2"), new Acronimo("EQP2"), new Designacao("equipa2"), new TipoEquipa(new CodigoUnico("te2"), new Designacao("tipo2"), new Cor(60, 60, 80)), setCol1);
        listEquipas2.add(equipa2);

        Set<Equipa> listEquipas3 = new HashSet<>();
        listEquipas3.add(equipa1);
        listEquipas3.add(equipa2);

        //Catalogos
        Catalogo catalogo1 = new Catalogo(new Titulo("Catalogo Exemplo"), c1, new DescricaoCompletaCatalogo("Descricao completa do exemplo"), new DescricaoBreve("Descricao exemplo"), new Icone("icone1"), listEquipas1, new Criticidade(new Etiqueta("Etiqueta1"), new Escala(3), new Designacao("Name1"), new Objetivo(13.2,11,13.2,11), new Cor(13,13,13)));

        Catalogo catalogo2 = new Catalogo(new Titulo("Catalogo Teste"), c2, new DescricaoCompletaCatalogo("Descricao completa do teste"), new DescricaoBreve("Descricao teste"), new Icone("icone2"), listEquipas2, new Criticidade(new Etiqueta("Etiqueta2"), new Escala(3), new Designacao("Name2"), new Objetivo(13.2,11,13.2,11), new Cor(13,13,13)));


        //Atividades
        Set<Atividade> atividades1 = new HashSet<>();
        AtividadeAutomatica atividadeAutomatica1 = controller.novaAtividadeAutomatica(0,0,0);
        Formulario form1 = controller.createFormulario("Formulario1", listaAtributosFormulario2);
        AtividadeManual atividadeAutomatica2 = controller.novaAtividadeAprovacaoManualColaborador(c1,"decisao1","comentario1", 0,0,0,form1,TipoAtividade.REALIZACAO);
        atividades1.add(atividadeAutomatica2);
        atividades1.add(atividadeAutomatica1);

        Set<Atividade> atividades2 = new HashSet<>();
        Formulario form2 = controller.createFormulario("Formulario2", listaAtributosFormulario4);
        AtividadeManual a1 = controller.novaAtividadeAprovacaoManualColaborador(c2,"decisao2","comentario2",0,0,0,form2,TipoAtividade.REALIZACAO);
        atividades2.add(a1);

        Set<Atividade> atividades3 = new HashSet<>();
        Formulario form3 = controller.createFormulario("Formulario3", listaAtributosFormulario6);
        AtividadeManual a2 = controller.novaAtividadeAprovacaoManualColaborador(c1,"decisao3","comentario3",0,0,0,form3,TipoAtividade.REALIZACAO);
        atividades3.add(a2);

        Set<Atividade> atividades4 = new HashSet<>();
        Formulario form4 = controller.createFormulario("Formulario4", listaAtributosFormulario2);
        AtividadeManual a3 = controller.novaAtividadeAprovacaoManualEquipa(listEquipas1,"decisao4","comentario4",0,0,0,form4,TipoAtividade.REALIZACAO);
        atividades3.add(a3);

        Set<Atividade> atividades5 = new HashSet<>();
        Formulario form5 = controller.createFormulario("Formulario5", listaAtributosFormulario6);
        AtividadeManual a4 = controller.novaAtividadeAprovacaoManualEquipa(listEquipas3,"decisao5","comentario5",0,0,0,form5,TipoAtividade.REALIZACAO);
        atividades3.add(a4);

        //Register
        register("cod123", "tituloServico", "descricaoServicoBreve", "descricaoServicoCompleta",
                "tituloFormulario", listaAtributosFormulario1, keywords, catalogo1,new FluxoAtividade(atividades1));

        register("cod147", "tituloServico1", "descricaoServicoBreve1", "descricaoServicoCompleta1",
                "tituloFormulario1", listaAtributosFormulario3, keywords1, catalogo1,new FluxoAtividade(atividades2));

        register("cod789", "tituloServico2", "descricaoServicoBreve2", "descricaoServicoCompleta2",
                "tituloFormulario2", listaAtributosFormulario5, keywords2, catalogo2,new FluxoAtividade(atividades3));

        register("cod987","tituloServico3","descricaoBreve3","descricaoServicoCompleta3","tituloFormulario3",
                listaAtributosFormulario1,keywords1,catalogo1,new FluxoAtividade(atividades4));

        register("cod007","tituloServico4","descricaoBreve4","descricaoServicoCompleta4","tituloFormulario4",
                listaAtributosFormulario3,keywords,catalogo2,new FluxoAtividade(atividades5));

        return true;
    }

    private void register(final String codigoUnico, final String titulo, final String descricaoBreve,
                          final String descricaoCompleta, final String tituloFormulario, Set<Atributo> listaAtributos,
                          Set<String> keywords, Catalogo catalogo, FluxoAtividade fluxoAtividade) {
        try {
            Formulario form = controller.createFormulario(tituloFormulario,listaAtributos);
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

