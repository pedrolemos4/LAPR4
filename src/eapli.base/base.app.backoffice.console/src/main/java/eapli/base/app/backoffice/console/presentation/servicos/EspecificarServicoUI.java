package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.gestaoservicoshelpdesk.application.EspecificarServicoController;
import eapli.base.gestaoservicoshelpdesk.domain.Atributo;
import eapli.base.gestaoservicoshelpdesk.domain.DraftServico;
import eapli.base.gestaoservicoshelpdesk.domain.Formulario;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecificarServicoUI extends AbstractUI {

    private final EspecificarServicoController theController = new EspecificarServicoController();

    @Override
    protected boolean doShow() {
       /* final Iterable<Catalogo> catalogos = this.theController.catalogos();

        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos",catalogos,new CatalogosPrinter());
        selector.show();
        final Catalogo theCatalogo =selector.selectedElement();*/

        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
        descricaoBreveData.show();

        final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
        descricaoCompletaData.show();

        final TituloDataWidget tituloData = new TituloDataWidget();
        tituloData.show();

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
        System.out.println("LINHA58");
        System.out.println(descricaoBreveData.descricao().toString());
        if (descricaoBreveData.descricao() == null && descricaoCompletaData.descricao() == null) {
            System.out.println("PAREDES É VIDA CRLH");
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
        return false;
    }

    @Override
    public String headline() {
        return "Especificar Serviço";
    }
}
