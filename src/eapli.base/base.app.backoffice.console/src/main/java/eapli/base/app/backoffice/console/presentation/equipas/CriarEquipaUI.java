package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.app.backoffice.console.presentation.servicos.CodigoUnicoDataWidget;
import eapli.base.gestaoservicosrh.application.CriarEquipaController;
import eapli.base.gestaoservicosrh.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.gestaoservicosrh.domain.Utilizador;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class CriarEquipaUI extends AbstractUI {

    private final CriarEquipaController controller = new CriarEquipaController();

    @Override
    protected boolean doShow() {
        final Iterable<TipoEquipa> listTipos = this.controller.listTipos();
        final Iterable<Utilizador> listUser = this.controller.listUser();

        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final AcronimoDataWidget acronimoData = new AcronimoDataWidget();
        acronimoData.show();

        final DesignacaoDataWidget designacaoData = new DesignacaoDataWidget();
        designacaoData.show();

        final SelectWidget<TipoEquipa> selector = new SelectWidget<>("Tipos Equipa: ", listTipos);
        selector.show();

        final SelectWidget<Utilizador> selector2 = new SelectWidget<>("Lista de utilizadores: ", listUser);
        selector2.show();

        try {
            this.controller.novaEquipa(codigoUnicoData.codigoUnico(), acronimoData.acronimo(), designacaoData.designacao(), selector.selectedElement(), (Colaborador) selector2.selectedElement());
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
