package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.app.backoffice.console.presentation.atividades.AtividadeAprovacaoWidget;
import eapli.base.app.backoffice.console.presentation.atividades.AtividadeResolucaoWidget;
import eapli.base.atividades.domain.*;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.application.EspecificarServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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

        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos", catalogos, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        System.out.println("\nSelecione o catálogo a que pertence o serviço:");
        selector.show();
        final Catalogo theCatalogo = selector.selectedElement();

        final KeywordsDataWidget keywordsDataWidget = new KeywordsDataWidget();
        keywordsDataWidget.show();
        boolean flag = true;

        Set<String> keywords = new HashSet<>();
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

        final FormularioDataWidget formularioData = new FormularioDataWidget();
        formularioData.show();

        //perguntar sobre os formulários e os atributos ao stor

        Set<Atributo> listaAtributos = new HashSet<>();
        Atributo atributo = theController.createAtributo(formularioData.nomeVariavel(), formularioData.label());
        listaAtributos.add(atributo);

        while (flag) {
            String resposta;
            System.out.println("Deseja adicionar mais atributos ao formulário?");
            resposta = Console.readLine("Resposta(S/N):");
            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("S")) {
                formularioData.atributo();
                atributo = theController.createAtributo(formularioData.nomeVariavel(), formularioData.label());
                listaAtributos.add(atributo);
            } else {
                flag = false;
            }
        }

        final AtividadeResolucaoWidget atividadeResolucaoWidget = new AtividadeResolucaoWidget();
        final AtividadeAprovacaoWidget atividadeAprovacaoWidget = new AtividadeAprovacaoWidget();
        System.out.println("\nEspecificação do fluxo de atividades");
        FluxoAtividade fluxoAtividade = null;
        Set<Atividade> listAtividades = new HashSet<>();
        String tipoResolucao;
        tipoResolucao = Console.readLine("A atividade de resolução é automática ou manual?");
        String resposta2;
        flag = true;
        while (flag) {
            if (tipoResolucao.equalsIgnoreCase("manual")) {
                    atividadeResolucaoWidget.doManual();
                    final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(theCatalogo.identity());
                    final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
                    System.out.println("\nSelecione a Equipa:");
                    selectorEquipa.show();
                    final Equipa equipa = selectorEquipa.selectedElement();
                    resposta2=Console.readLine("Deseja atribuir a execução da tarefa a uma pessoa em específico?");
                    if(resposta2.equalsIgnoreCase("sim") || resposta2.equalsIgnoreCase("S")){
                        final Iterable<Colaborador> listaColaboradores = this.theController.findColaboradoresDaEquipa(equipa.identity());
                        final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaboradores Disponíveis",listaColaboradores,visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
                        System.out.println("\nSelecione o Colaborador:");
                        selectorColaborador.show();
                        final Colaborador col = selectorColaborador.selectedElement();
                        Formulario form = null;
                        TipoAtividade tipo = TipoAtividade.REALIZACAO;
                        AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualColaborador(/*EstadoAtividade.PENDENTE, */col,
                                atividadeResolucaoWidget.decisao(), atividadeResolucaoWidget.comentario(), atividadeResolucaoWidget.ano(),
                                atividadeResolucaoWidget.mes(), atividadeResolucaoWidget.dia(), form, tipo);
                        listAtividades.add(atividadeManual);
                        flag = false;
                    } else {
                        Set<Equipa> listEquipas = new HashSet<>();
                        listEquipas.add(equipa);
                        Formulario form = null;
                        TipoAtividade tipo = TipoAtividade.REALIZACAO;
                        AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualEquipa(/*EstadoAtividade.PENDENTE, */listEquipas,
                                atividadeResolucaoWidget.decisao(), atividadeResolucaoWidget.comentario(), atividadeResolucaoWidget.ano(),
                                atividadeResolucaoWidget.mes(), atividadeResolucaoWidget.dia(), form, tipo);
                        listAtividades.add(atividadeManual);
                        flag = false;
                    }
            } else if (tipoResolucao.equalsIgnoreCase("automatica") || tipoResolucao.equalsIgnoreCase("automática")) {
                try {
                    atividadeResolucaoWidget.doAutomatica();
                    AtividadeAutomatica atividadeAutomatica = theController.novaAtividadeAutomatica(atividadeResolucaoWidget.anoA(),
                            atividadeResolucaoWidget.mesA(), atividadeResolucaoWidget.diaA());
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
            atividadeAprovacaoWidget.show();

            final Iterable<Equipa> listaEquipas = this.theController.findEquipaDoCatalogo(theCatalogo.identity());
            final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Equipas Disponíveis", listaEquipas, visitee2 -> System.out.printf("%-15s%-80s\n", visitee2.identity(), visitee2.toString()));
            System.out.println("\nSelecione a Equipa:");
            selectorEquipa.show();
            final Equipa equipa = selectorEquipa.selectedElement();
            resposta2=Console.readLine("Deseja atribuir a execução da tarefa a uma pessoa em específico?");
            if(resposta2.equalsIgnoreCase("sim") || resposta2.equalsIgnoreCase("S")){
                final Iterable<Colaborador> listaColaboradores = this.theController.findColaboradoresDaEquipa(equipa.identity());
                final SelectWidget<Colaborador> selectorColaborador = new SelectWidget<>("Colaboradores Disponíveis",listaColaboradores,visitee -> System.out.printf("%-15s%-80s\n", visitee.identity(), visitee.toString()));
                System.out.println("\nSelecione o Colaborador:");
                selectorColaborador.show();
                final Colaborador col = selectorColaborador.selectedElement();
                Formulario form = null;
                TipoAtividade tipo = TipoAtividade.APROVACAO;
                AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualColaborador(/*EstadoAtividade.PENDENTE, */col,
                        atividadeAprovacaoWidget.decisao(), atividadeAprovacaoWidget.comentario(), atividadeAprovacaoWidget.ano(),
                        atividadeAprovacaoWidget.mes(), atividadeAprovacaoWidget.dia(), form, tipo);
                listAtividades.add(atividadeManual);
            } else {
                Set<Equipa> listEquipas = new HashSet<>();
                listEquipas.add(equipa);
                Formulario form = null;
                TipoAtividade tipo = TipoAtividade.APROVACAO;
                AtividadeManual atividadeManual = theController.novaAtividadeAprovacaoManualEquipa(/*EstadoAtividade.PENDENTE, */listEquipas,
                        atividadeAprovacaoWidget.decisao(), atividadeAprovacaoWidget.comentario(), atividadeAprovacaoWidget.ano(),
                        atividadeAprovacaoWidget.mes(), atividadeAprovacaoWidget.dia(), form, tipo);
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
                    Formulario formulario = this.theController.createFormulario(formularioData.titulo(), listaAtributos);
                    this.theController.especificarServico(codigoUnicoData.codigoUnico(), tituloData.titulo(), descricaoBreveData.descricao(),
                            descricaoCompletaData.descricao(), formulario, keywords, theCatalogo, fluxoAtividade);
                    System.out.println("\nServiço especificado com sucesso!\n");
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }
            }
        } catch (final IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        motor(codigoUnicoData.codigoUnico());
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }

    private void motor(final String codigo) throws IOException {
        byte[] data = new byte[258];
        try {
            serverIP = InetAddress.getLocalHost();//.getByName("endereçoIp");
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: " + "endereçoIp");
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, 32508);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            System.exit(1);
        }
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        System.out.println("Connected to server");
        //Thread serverConn = new Thread(new TcpChatCliConn(sock));
        //serverConn.start();
        CodigoUnico cod = new CodigoUnico(codigo);
        data[0] = 0;
        data[1] = 3;
        byte[] idArray = cod.toString().getBytes();//pedido.servico().identity().toString().getBytes();
        data[2] = (byte)idArray.length;
        for(int i = 0; i<idArray.length;i++){
            data[i+2] = idArray[i];
        }

        sOut.write(data);

        // serverConn.join();
        sock.close();
    }
}
