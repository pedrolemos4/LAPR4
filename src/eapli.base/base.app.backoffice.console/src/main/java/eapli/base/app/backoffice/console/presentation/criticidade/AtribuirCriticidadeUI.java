package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.base.app.backoffice.console.presentation.catalogo.ListCriticidadePrint;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.criticidade.application.AtribuirCriticidadeController;
import eapli.base.criticidade.domain.Criticidade;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class AtribuirCriticidadeUI extends AbstractUI {

    private final AtribuirCriticidadeController theController = new AtribuirCriticidadeController();

    @Override
    protected boolean doShow(){

        final Iterable<Catalogo> catalogos = this.theController.listCatalogos();
        final SelectWidget<Catalogo> selector = new SelectWidget<>("Catalogos", catalogos, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        System.out.println("\nSelecione o catálogo :");
        selector.show();
        final Catalogo theCatalogo = selector.selectedElement();

        final Iterable<Criticidade> criticidades = this.theController.getCriticidades();

        final SelectWidget<Criticidade> selectorCrit = new SelectWidget<>("Lista de Criticidades:", criticidades,
                new ListCriticidadePrint());

        System.out.println("\nSelecione o nível de criticidade que irá ser atribuido a este catalogo");
        selectorCrit.show();

        theCatalogo.atribuirCriticidade(selectorCrit.selectedElement());
        String resposta= Console.readLine("Pretende associar objetivos diferentes daqueles dos previstos na criticidade?");

        if(resposta.equalsIgnoreCase("Sim")||resposta.equalsIgnoreCase("S")){
            final ObjetivoDataWidget obj = new ObjetivoDataWidget();
            obj.show();
            this.theController.associarObjetivo(obj.tempoMaxAprov(),obj.tempoMedioAprov(),obj.tempoMaxRes(),obj.tempoMedioRes(),theCatalogo);
            this.theController.saveCatalogo(theCatalogo);
        } else{
            this.theController.saveCatalogo(theCatalogo);
        }
        return false;
    }

    @Override
    public String headline() {
        return "Atribuir Criticidade";
    }
}
