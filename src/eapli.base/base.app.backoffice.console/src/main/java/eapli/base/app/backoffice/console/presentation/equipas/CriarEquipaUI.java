package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.app.backoffice.console.presentation.servicos.CodigoUnicoDataWidget;
import eapli.base.gestaoservicosrh.application.CriarEquipaController;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

public class CriarEquipaUI extends AbstractUI {

    private final CriarEquipaController controller = new CriarEquipaController();

    @Override
    protected boolean doShow() {
        final Iterable<TipoEquipa> listTipos = this.controller.listTipos();
        final Iterable<SystemUser> listUser = this.controller.listUser();

        final CodigoUnicoDataWidget codigoUnicoData = new CodigoUnicoDataWidget();
        codigoUnicoData.show();

        final AcronimoDataWidget acronimoData = new AcronimoDataWidget();
        acronimoData.show();

        final DesignacaoDataWidget designacaoData = new DesignacaoDataWidget();
        designacaoData.show();

        final SelectWidget<TipoEquipa> selector = new SelectWidget<TipoEquipa>("Tipos de Equipas: ", listTipos, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        selector.show();

        final TipoEquipa tipo = selector.selectedElement();

        final SelectWidget<SystemUser> selector2 = new SelectWidget<>("Lista de utilizadores: ", listUser, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
        selector2.show();

        final Colaborador colab = (Colaborador) selector2.selectedElement();

        if (colab.hasAny(Role.valueOf("COLABORADOR"))) {
            try {
                this.controller.novaEquipa(codigoUnicoData.codigoUnico(), acronimoData.acronimo(), designacaoData.designacao(), tipo, colab);
            } catch (final IntegrityViolationException e){
                System.out.println("A Equipa criada já existe na base de dados.");
            }
        } else {
            System.out.println("O utilizador selecionado não é um colaborador!");
        }

        System.out.println("Operação finalizada!");
        return false;
    }

    @Override
    public String headline() {
        return "Criar Equipa";
    }
}
