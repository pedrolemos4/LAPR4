/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.other.console.presentation;

//import eapli.base.app.backoffice.console.presentation.equipas.CriarEquipaUI;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

import java.util.Optional;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int SALES_OPTION = 7;
    private static final int MENU_GSH = 3;
    private static final int MENU_RRH = 4;

    //gestor de serviços helpdesk
    private static final int CRIAR_CATALOGO = 5;
    private static final int ESPECIFICAR_SERVICO = 6;
    private static final int DEFINIR_NIVEIS_CRITICIDADE = 7;

    //responsável rrh
    private static final int ESPECIFICAR_COLABORADOR = 8;
    private static final int CRIAR_NOVA_EQUIPA = 9;
    private static final int ASSOCIAR_REMOVER_COLABORADOR = 10;
    private static final int REGISTAR_TIPO_EQUIPA = 11;

    //utilizador
    //private static final int CONSULTAR_CATALOGOS_SERVICOS = 10;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final Menu menu;
    private final MenuRenderer renderer;

    public MainMenu() {
        menu = buildMainMenu();
        renderer = getRenderer(menu);
    }

    private MenuRenderer getRenderer(final Menu menu) {
        final MenuRenderer theRenderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            theRenderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            theRenderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return theRenderer;
    }

    @Override
    public boolean doShow() {
        return renderer.render();
    }

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        //final Menu myUserMenu = new MyUserMenu(BaseRoles.CASHIER);
        //mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        // if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.CASHIER)) {
        // final Menu cashierMenu = buildCashierMenu();
        //mainMenu.addSubMenu(SALES_OPTION, cashierMenu);
        // mainMenu.addSubMenu(CRIAR_CATALOGO,cashierMenu);

//        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO)) {
//            final Menu gshMenu = buildGSHMenu();
//            mainMenu.addSubMenu(CRIAR_CATALOGO, gshMenu);
//            mainMenu.addSubMenu(ESPECIFICAR_SERVICO, gshMenu);
//            mainMenu.addSubMenu(DEFINIR_NIVEIS_CRITICIDADE, gshMenu);
//        } else if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH)) {
//            //final Menu rrhMenu = buildRRHMenu();
////            mainMenu.addItem(ESPECIFICAR_COLABORADOR, "Especificar Colaborador", Actions.SUCCESS);
////            mainMenu.addItem(CRIAR_NOVA_EQUIPA, "Criar nova Equipa", Actions.SUCCESS);
////            mainMenu.addItem(ASSOCIAR_REMOVER_COLABORADOR, "Associar/Remover Colaborador", Actions.SUCCESS);
////            mainMenu.addItem(REGISTAR_TIPO_EQUIPA, "Registar Tipo de Equipa", Actions.SUCCESS);
//            final Menu menuCriarEquipa = buildEquipaMenu();
//            mainMenu.addSubMenu(CRIAR_NOVA_EQUIPA, menuCriarEquipa);
//            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
//        }

        //}

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

   /* private Menu buildColaboradorMenu(){
        final Menu colaboradorMenu = new Menu("Especificar Colaborador");
        colaboradorMenu.addItem(ESPECIFICAR_COLABORADOR,"Especificar bla"()-> {
            final Optional<UserSession> s = authz.session();
            // example of using an extended class of generic list ui from the
            // framework
            new ListMovementsUI<>(
                    () -> new ListMovementsController().allMovementsByUsername(
                            s.orElseThrow(IllegalStateException::new).authenticatedUser()
                                    .identity()),
                    new MovementPrinter(), "Movement", "List My Movements",
                    "No data").show();
            return true;
        });
    }*/


    private Menu buildCashierMenu() {
        final Menu cashierMenu = new Menu("Sales  >");
        cashierMenu.addItem(CRIAR_CATALOGO, "Criar catálogo", Actions.SUCCESS);
        cashierMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return cashierMenu;
    }

}
