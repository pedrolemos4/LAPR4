package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.app.backoffice.console.presentation.servicos.DescricaoBreveDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.DescricaoCompletaDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.TituloDataWidget;
import eapli.base.gestaoservicoshelpdesk.application.NovoCatalogoController;
import eapli.base.gestaoservicoshelpdesk.domain.DescricaoBreve;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;

public class NovoCatalogoUI extends AbstractUI {

    private final NovoCatalogoController controller = new NovoCatalogoController();
    private ArrayList<Equipa> list = new ArrayList<>();

    @Override
    protected boolean doShow() {
        boolean bool = true;

        final Iterable<Equipa> listaEquipas = this.controller.getEquipas();

        final Iterable<Colaborador> listColaborador = this.controller.getListaColaboradores();

        final SelectWidget<Colaborador> selectorColab = new SelectWidget<>("Lista Colaboradores:", listColaborador,
                new ListColaboradorPrint());

        System.out.println("Selecione um colaborador responsável pelo catálogo");
        selectorColab.show();

        try {
            Colaborador colaborador = selectorColab.selectedElement();

            final SelectWidget<Equipa> selectorEquipa = new SelectWidget<>("Lista Equipas:", listaEquipas,
                    new ListEquipasPrint());

            while (bool) {
                System.out.println("Pretende adicionar uma equipa ao catálogo?");
                String s = Console.readLine("S/N");
                if (s.equalsIgnoreCase("S")) {
                    System.out.println("Selectione a equipa que pretende adicionar ao catálogo:");
                    selectorEquipa.show();
                    final Equipa equipa = selectorEquipa.selectedElement();
                    list.add(equipa);
                } else {
                    bool = false;
                }
            }

            final TituloDataWidget tituloDataWidget = new TituloDataWidget();
            tituloDataWidget.show();

            final DescricaoBreveDataWidget descricaoBreveDataWidget = new DescricaoBreveDataWidget();
            descricaoBreveDataWidget.show();

            final DescricaoCompletaDataWidget descricaoCompletaDataWidget = new DescricaoCompletaDataWidget();
            descricaoCompletaDataWidget.show();

            final IconeDataWidget iconeDataWidget = new IconeDataWidget();
            iconeDataWidget.show();

            this.controller.novoCatalogo(tituloDataWidget.titulo(), descricaoBreveDataWidget.descricao(), iconeDataWidget.icone(), descricaoCompletaDataWidget.descricao(), listaEquipas, colaborador);
        } catch (Exception e) {
            System.out.println("Erro");
            System.out.println("");
            doShow();
        }
        return false;
    }

    @Override
    public String headline() {
        return "Catalogo";
    }

}
