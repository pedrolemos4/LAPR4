package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.base.gestaoservicoshelpdesk.application.EspecificarServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

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

        try{
            this.theController.especificarServico(codigoUnicoData.codigoUnico(),tituloData.titulo(),descricaoBreveData.descricao(),
                    descricaoCompletaData.descricao());
        } catch (final IntegrityViolationException e) {
            System.out.println("Erro.");
        }

        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
