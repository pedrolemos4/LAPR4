package eapli.base.app.backoffice.console.presentation.equipas;
;
import eapli.base.app.backoffice.console.presentation.criticidade.CorDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.CodigoUnicoDataWidget;
import eapli.base.gestaoservicosrh.application.RegistarTipoEquipaController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistarTipoEquipaUI  extends AbstractUI {

    private static final Logger LOGGER = LogManager.getLogger(RegistarTipoEquipaUI.class);

    private final RegistarTipoEquipaController controller = new RegistarTipoEquipaController();

    @Override
    protected boolean doShow() {

        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final DesignacaoDataWidget designacaoData = new DesignacaoDataWidget();
        designacaoData.show();

        final CorDataWidget c = new CorDataWidget();
        c.show();

        try{
            this.controller.registarTipoEquipa(codigoUnicoData.codigoUnico(),designacaoData.designacao(),
                    c.newColor());
            System.out.println("Registado com sucesso!!");
        } catch (final IntegrityViolationException e) {
            System.out.println("Erro.");
            System.out.println("");

        }
        return false;
    }

    @Override
    public String headline() {
        return "Registar Tipo de Equipa";
    }
}
