package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.app.backoffice.console.presentation.servicos.CodigoUnicoDataWidget;
import eapli.base.gestaoservicosrh.application.CriarEquipaController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;

public class CriarEquipaUI extends AbstractUI {

    private final CriarEquipaController controller = new CriarEquipaController();

    @Override
    protected boolean doShow() {
        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final AcronimoDataWidget acronimoData = new AcronimoDataWidget();
        acronimoData.show();

        final DesignacaoDataWidget designacaoData = new DesignacaoDataWidget();
        designacaoData.show();

        try {
            this.controller.novaEquipa(codigoUnicoData.codigoUnico(), acronimoData.acronimo(), designacaoData.designacao(), null, null);
        } catch (final IntegrityViolationException e){
            System.out.println("Erro.");
        }

        return false;
    }

    @Override
    public String headline() {
        return null;
    }
}
