package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.gestaoservicoshelpdesk.application.EspecificarServicoController;
import eapli.base.gestaoservicoshelpdesk.domain.Atributo;
import eapli.base.gestaoservicoshelpdesk.domain.DraftServico;
import eapli.base.gestaoservicoshelpdesk.domain.Formulario;
import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController theController = new EspecificarServicoController();

    private static final int ESPECIFICAR_SERVICO = 20;

    private static final int EDITAR_SERVICO = 21;

    @Override
    protected boolean doShow() {
       /* final Iterable<Catalogo> catalogos = this.theController.catalogos();

        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos",catalogos,new CatalogosPrinter());
        selector.show();
        final Catalogo theCatalogo =selector.selectedElement();*/

        System.out.println("Deseja especificar um novo serviço (opção 20) ou continuar a especificação de um serviço (opção 21)? ");
        int opcao = Console.readInteger("Opção:");
        if(opcao==ESPECIFICAR_SERVICO){
            especificarServico();
        } else {
            editarServico();
        }
        return false;
    }

    private void especificarServico(){
        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final TituloDataWidget tituloData = new TituloDataWidget();
        tituloData.show();

        final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
        descricaoBreveData.show();

        final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
        descricaoCompletaData.show();

        final FormularioDataWidget formularioData = new FormularioDataWidget();
        formularioData.show();
        boolean flag = true;
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
        if (descricaoBreveData.descricao().isEmpty() || descricaoCompletaData.descricao().isEmpty()) {
            this.theController.createDraftServico(codigoUnicoData.codigoUnico(), descricaoBreveData.descricao(),
                    descricaoCompletaData.descricao(), tituloData.titulo(), formularioData.titulo(), listaAtributos);
        } else {
            try {
                Formulario formulario = this.theController.createFormulario(formularioData.titulo(), listaAtributos);
                this.theController.especificarServico(codigoUnicoData.codigoUnico(), tituloData.titulo(), descricaoBreveData.descricao(),
                        descricaoCompletaData.descricao(), formulario);
            } catch (final IntegrityViolationException e) {
                System.out.println("Erro.");
            }
        }
    }

    private void editarServico(){
        final List<DraftServico> listDrafts = (List<DraftServico>) this.theController.listDrafts();
        DraftServico draftServico = null;
        if(listDrafts.isEmpty()) {
            System.out.println("Não existem serviços registados");
            return;
        }
        final SelectWidget<DraftServico> selector = new SelectWidget<>("Servico: ", listDrafts, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        selector.show();
        draftServico = selector.selectedElement();
        if(draftServico==null){
            return;
        }
        System.out.println("Editar Serviço");
        final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
        descricaoBreveData.show();

        final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
        descricaoCompletaData.show();
        try {
            this.theController.removeDraft(draftServico);
            Formulario formulario = this.theController.createFormulario(draftServico.tituloFormulario(), draftServico.listaAtributos());
            this.theController.especificarServico(draftServico.codigoUnico(), draftServico.titulo(), descricaoBreveData.descricao(),
                    descricaoCompletaData.descricao(), formulario);
        } catch (final IntegrityViolationException e) {
            System.out.println("Erro.");
        }
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
