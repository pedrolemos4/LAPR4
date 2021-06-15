package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.atividades.AtividadeAprovacaoWidget;
import eapli.base.app.backoffice.console.presentation.atividades.AtividadeResolucaoWidget;
import eapli.base.atividade.domain.*;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;

import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import java.util.HashSet;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController theController = new EspecificarServicoController();

    private static final int ESPECIFICAR_SERVICO = 20;

    private static final int EDITAR_SERVICO = 21;


    static InetAddress serverIP;
    static Socket sock;

    @Override
    protected boolean doShow() {
        try {
            especificarServico();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void especificarServico() throws IOException {

        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final TituloDataWidget tituloData = new TituloDataWidget();
        tituloData.show();

        final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
        descricaoBreveData.show();

        final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
        descricaoCompletaData.show();

        final Iterable<Catalogo> catalogos = this.theController.listCatalogos();

        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos\n", catalogos, visitee -> System.out.printf("\n%-15s%-80s\n", visitee.identity(), visitee.toString()));
        System.out.println("\nSelecione o catálogo a que pertence o serviço:");
        selector.show();
        final Catalogo theCatalogo = selector.selectedElement();

        final KeywordsDataWidget keywordsDataWidget = new KeywordsDataWidget();
        Set<String> keywords = new HashSet<>();
        especificarKeywords(keywordsDataWidget, keywords);

        final FormularioDataWidget formularioData = new FormularioDataWidget();
        Set<Atributo> listaAtributos = new HashSet<>();
        Formulario formServico = preencherAtributos(formularioData, listaAtributos);

        System.out.println("\nEspecificação do fluxo de atividades");
        FluxoAtividade fluxoAtividade = null;
        Set<Atividade> listAtividades = new HashSet<>();
        String tipoResolucao;
        tipoResolucao = Console.readLine("A atividade de resolução é automática ou manual?");
        String resposta2;
        boolean flag = true;
        while (flag) {
            if (tipoResolucao.equalsIgnoreCase("manual")) {
                final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(theCatalogo.identity());
                final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
                System.out.println("\nSelecione a Equipa:");
                selectorEquipa.show();
                final Equipa equipa = selectorEquipa.selectedElement();
                resposta2 = Console.readLine("Deseja atribuir a execução da tarefa a uma pessoa em específico?");
                if (resposta2.equalsIgnoreCase("sim") || resposta2.equalsIgnoreCase("S")) {
                    final Iterable<Colaborador> listaColaboradores = this.theController.findColaboradoresDaEquipa(equipa.identity());
                    final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaboradores Disponíveis", listaColaboradores, visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
                    System.out.println("\nSelecione o Colaborador:");
                    selectorColaborador.show();
                    final Colaborador col = selectorColaborador.selectedElement();
                    FormularioDataWidget formularioDataWidget = new FormularioDataWidget();
                    Set<Atributo> listaAtributos1 = new HashSet<>();
                    Formulario form = preencherAtributos(formularioDataWidget, listaAtributos1);
                    form.copyAtributos(listaAtributos1);
                    TipoAtividade tipo = TipoAtividade.REALIZACAO;
                    AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualColaborador(col,form, tipo);
                    listAtividades.add(atividadeManual);
                    flag = false;
                } else {
                    Set<Equipa> listEquipas = new HashSet<>();
                    listEquipas.add(equipa);
                    TipoAtividade tipo = TipoAtividade.REALIZACAO;
                    FormularioDataWidget formularioDataWidget = new FormularioDataWidget();
                    Set<Atributo> listaAtributos1 = new HashSet<>();
                    Formulario form = preencherAtributos(formularioDataWidget, listaAtributos1);
                    form.copyAtributos(listaAtributos1);
                    AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualEquipa(listEquipas, form, tipo);
                    listAtividades.add(atividadeManual);
                    flag = false;
                }
            } else if (tipoResolucao.equalsIgnoreCase("automatica") || tipoResolucao.equalsIgnoreCase("automática")) {
                try {
                    AtividadeAutomatica atividadeAutomatica = theController.novaAtividadeAutomatica();
                    listAtividades.add(atividadeAutomatica);
                    flag = false;
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("Responda corretamente");
                flag = true;
            }
        }

        String resposta;

        resposta = Console.readLine("O fluxo de atividades deste serviço é composto por uma atividade de aprovação?");
        if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {

            final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(theCatalogo.identity());
            final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
            System.out.println("\nSelecione a Equipa:");
            selectorEquipa.show();
            final Equipa equipa = selectorEquipa.selectedElement();
            resposta2 = Console.readLine("Deseja atribuir a execução da tarefa a uma pessoa em específico?");
            if (resposta2.equalsIgnoreCase("sim") || resposta2.equalsIgnoreCase("S")) {
                final Iterable<Colaborador> listaColaboradores = this.theController.findColaboradoresDaEquipa(equipa.identity());
                final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaboradores Disponíveis", listaColaboradores, visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
                System.out.println("\nSelecione o Colaborador:");
                selectorColaborador.show();
                final Colaborador col = selectorColaborador.selectedElement();
                FormularioDataWidget formularioDataWidget = new FormularioDataWidget();
                Set<Atributo> listaAtributos1 = new HashSet<>();
                Formulario form = preencherAtributos(formularioDataWidget, listaAtributos1);
                //form.copyAtributos(listaAtributos1);
                TipoAtividade tipo = TipoAtividade.APROVACAO;
                AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualColaborador(col,form, tipo);
                listAtividades.add(atividadeManual);
            } else {
                Set<Equipa> listEquipas = new HashSet<>();
                listEquipas.add(equipa);
                FormularioDataWidget formularioDataWidget = new FormularioDataWidget();
                Set<Atributo> listaAtributos1 = new HashSet<>();
                Formulario form = preencherAtributos(formularioDataWidget, listaAtributos1);
                //form.copyAtributos(listaAtributos1);
                TipoAtividade tipo = TipoAtividade.APROVACAO;
                AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualEquipa(listEquipas, form, tipo);
                listAtividades.add(atividadeManual);
            }
        }
        fluxoAtividade = theController.createFluxo(listAtividades);

        try {
            if (descricaoBreveData.descricao().isEmpty() || descricaoCompletaData.descricao().isEmpty()) {
                this.theController.createDraftServico(codigoUnicoData.codigoUnico(), descricaoBreveData.descricao(),
                        descricaoCompletaData.descricao(), tituloData.titulo(), formularioData.titulo(), listaAtributos,
                        keywords, theCatalogo, fluxoAtividade);
            } else {
                try {
                    //Formulario formulario = this.theController.createFormulario(formularioData.titulo(), listaAtributos);
                    this.theController.especificarServico(codigoUnicoData.codigoUnico(), tituloData.titulo(), descricaoBreveData.descricao(),
                            descricaoCompletaData.descricao(), formServico, keywords, theCatalogo, fluxoAtividade);
                    System.out.println("\nServiço especificado com sucesso!\n");
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }
            }
        } catch (final IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void especificarKeywords(KeywordsDataWidget keywordsDataWidget, Set<String> keywords) {
        keywordsDataWidget.show();
        boolean flag = true;

        keywords.add(keywordsDataWidget.keyword());

        while (flag) {
            String answer;
            System.out.println("Deseja adicionar mais keywords?");
            answer = Console.readLine("Resposta(S/N):");
            if (answer.equalsIgnoreCase("Sim") || answer.equalsIgnoreCase("S")) {
                keywordsDataWidget.show();
                keywords.add(keywordsDataWidget.keyword());
            } else {
                flag = false;
            }
        }
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }

    public Formulario preencherAtributos(FormularioDataWidget formularioData, Set<Atributo> listaAtributos) {
        formularioData.show();
        Formulario formulario = new Formulario(formularioData.titulo());
        criarAtributos(formularioData,listaAtributos,formulario);

        boolean flag = true;

        while (flag) {
            String resposta;
            resposta = Console.readLine("Deseja adicionar mais atributos ao formulário?\nResposta(S/N):");
            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                formularioData.atributo();
                criarAtributos(formularioData,listaAtributos,formulario);
            } else {
                flag = false;
            }
        }
        formulario.copyAtributos(listaAtributos);
        return formulario;
    }

    public void criarAtributos(FormularioDataWidget formularioData,Set<Atributo> listaAtributos,Formulario formulario){
        formularioData.atributo();
        Atributo atributo = null;
        try {
            atributo = theController.createAtributo(formularioData.label(), formularioData.tipoDados(),
                    formularioData.obrigatoriedade(), formularioData.descricaoAjuda(), formulario);
        } catch (IllegalArgumentException ex) {
            System.out.println("Insira um tipo de dados válido");
            criarAtributos(formularioData,listaAtributos,formulario);
        }
        listaAtributos.add(atributo);
    }
}
