package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.gestaoservicosrh.application.CriarEquipaController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;

public class CriarEquipaUI extends AbstractUI {

    private final CriarEquipaController controller = new CriarEquipaController();

    @Override
    protected boolean doShow() {
        try {
            this.controller.novaEquipa(null, null, null, null);
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
