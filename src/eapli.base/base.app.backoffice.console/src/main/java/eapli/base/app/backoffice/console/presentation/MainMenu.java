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
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.catalogo.NovoCatalogoUI;
import eapli.base.app.backoffice.console.presentation.colaborador.EspecificarColaboradorUI;
import eapli.base.app.backoffice.console.presentation.colaborador.LerFicheiroColaboradorUI;
import eapli.base.app.backoffice.console.presentation.criticidade.AtribuirCriticidadeUI;
import eapli.base.app.backoffice.console.presentation.criticidade.DefinirCriticidadeUI;
import eapli.base.app.backoffice.console.presentation.equipas.AdicionarRemoverColaboradorUI;
import eapli.base.app.backoffice.console.presentation.equipas.CriarEquipaUI;
import eapli.base.app.backoffice.console.presentation.equipas.RegistarTipoEquipaUI;
import eapli.base.app.backoffice.console.presentation.pedido.CumprimentoSlaUI;
import eapli.base.app.backoffice.console.presentation.servicos.CompletarServicoUI;
import eapli.base.app.backoffice.console.presentation.servicos.EspecificarServicoUI;
import eapli.base.app.common.console.presentation.authz.LoginUI;
import eapli.base.Application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */

public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";
    private static final String LOGOUT_LABEL = "Logout ";

    private static final int EXIT_OPTION = 0;
    private static final int LOGOUT_OPTION = 9;

    //gestor de serviços helpdesk
    private static final int CRIAR_CATALOGO = 1;
    private static final int ESPECIFICAR_SERVICO = 2;
    private static final int COMPLETAR_SERVICO = 3;
    private static final int DEFINIR_NIVEIS_CRITICIDADE = 3;
    private static final int ATRIBUIR_CRITICIDADE = 4;

    //responsável rrh
    private static final int CRIAR_NOVA_EQUIPA = 1;
    private static final int REGISTAR_TIPO_EQUIPA = 2;
    private static final int ESPECIFICAR_COLABORADOR = 3;
    private static final int ASSOCIAR_REMOVER_COLABORADOR = 4;
    private static final int ESPECIFICAR_COLABORADOR_FICHEIRO = 5;

    //colaborador
    private static final int CONSULTAR_CATALOGO_SERVICO = 1;
    private static final int SOLICITAR_SERVICO = 2;
    private static final int CONSULTAR_TAREFAS = 3;
    private static final int CONSULTAR_REIVINDICAR_TAREFAS = 4;
    private static final int ATRIBUIR_GRAU_SATISFACAO = 5;
    private static final int CONSULTAR_HISTORICO_PEDIDOS = 6;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */

    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {

        final Menu mainMenu = new Menu();

      //  final Menu myUserMenu = new MyUserMenu();
       // mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO)) {
            final Menu menuCatalogo = buildCatalogoMenu();
            mainMenu.addSubMenu(CRIAR_CATALOGO,menuCatalogo);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuServico = buildNovoServicoMenu();
            mainMenu.addSubMenu(ESPECIFICAR_SERVICO,menuServico);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuCriticidade = buildCriticidadeMenu();
            mainMenu.addSubMenu(DEFINIR_NIVEIS_CRITICIDADE,menuCriticidade);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuAtribuirCriticidade = buildAtribuirCriticidadeMenu();
            mainMenu.addSubMenu(ATRIBUIR_CRITICIDADE,menuAtribuirCriticidade);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu buildInCumprimento = buildInCumprimento();
            mainMenu.addSubMenu(5,buildInCumprimento);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        } else if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH)) {
            final Menu menuCriarEquipa = buildEquipaMenu();
            mainMenu.addSubMenu(CRIAR_NOVA_EQUIPA, menuCriarEquipa);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuTipoEquipa = buildTipoEquipaMenu();
            mainMenu.addSubMenu(REGISTAR_TIPO_EQUIPA,menuTipoEquipa);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuEspecificarColaborador = buildEspecificaColaboradorMenu();
            mainMenu.addSubMenu(ESPECIFICAR_COLABORADOR, menuEspecificarColaborador);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuAssociarRemoverColaborador = buildAssociarRemoverColaborador();
            mainMenu.addSubMenu(ASSOCIAR_REMOVER_COLABORADOR, menuAssociarRemoverColaborador);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuEspecificarColaboradorFicheiro = buildEspecificaColaboradorFicheiroMenu();
            mainMenu.addSubMenu(ESPECIFICAR_COLABORADOR_FICHEIRO, menuEspecificarColaboradorFicheiro);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }
        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(LOGOUT_OPTION, LOGOUT_LABEL, ()-> voltarAoLogin());
        mainMenu.addItem(EXIT_OPTION, "Exit", ()->sairDaAplicacao());

        return mainMenu;
    }


    private boolean voltarAoLogin(){
        if(new LoginUI().show()){
            final var menu = new MainMenu();
            menu.mainLoop();
        }
        return false;
    }

    private boolean sairDaAplicacao(){
        System.out.println("Bye, Bye");
        System.exit(1);
        return false;
    }

    private Menu buildAssociarRemoverColaborador() {
        final Menu associarRemoverColaborador = new Menu("Associar/Remover Colaborador");
        associarRemoverColaborador.addItem(CONSULTAR_CATALOGO_SERVICO,"Associar/Remover Colaborador",()->new AdicionarRemoverColaboradorUI().show());
        associarRemoverColaborador.addItem(EXIT_OPTION, RETURN_LABEL, ()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH));
        return associarRemoverColaborador;
    }

    private Menu buildInCumprimento() {
        final Menu inCumprimento = new Menu("SLA");
        inCumprimento.addItem(1,"(in)Cumprimento do SLA",()->new CumprimentoSlaUI().show());
        inCumprimento.addItem(EXIT_OPTION, RETURN_LABEL, ()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO));
        return inCumprimento;
    }

    private Menu buildTipoEquipaMenu(){
        final Menu tipoEquipaMenu = new Menu("Tipo de Equipa");
        tipoEquipaMenu.addItem(REGISTAR_TIPO_EQUIPA,"Registar Equipa",()->new RegistarTipoEquipaUI().show());
        tipoEquipaMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH));
        return tipoEquipaMenu;
    }

    private Menu buildEquipaMenu() {
        final Menu equipaMenu = new Menu("Equipa");
        equipaMenu.addItem(CRIAR_NOVA_EQUIPA, "Criar Equipa", () -> new CriarEquipaUI().show());
        equipaMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH));
        return equipaMenu;
    }

    private Menu buildCriticidadeMenu(){
        final Menu criticidadeMenu = new Menu("Criticidade");
        criticidadeMenu.addItem(DEFINIR_NIVEIS_CRITICIDADE, "Definir Criticidade",()->new DefinirCriticidadeUI().show());
        criticidadeMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO));
        return criticidadeMenu;
    }

    private Menu buildCatalogoMenu(){
        final Menu catalogoMenu = new Menu("Catalogo");
        catalogoMenu.addItem(CRIAR_CATALOGO,"Criar Catalogo",()->new NovoCatalogoUI().show());
        catalogoMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO));
        return catalogoMenu;
    }

    private Menu buildNovoServicoMenu(){
        final Menu servicoMenu = new Menu("Serviço");
        servicoMenu.addItem(ESPECIFICAR_SERVICO,"Especificar Serviço",()->new EspecificarServicoUI().show());
        servicoMenu.addItem(COMPLETAR_SERVICO,"Completar Serviço",()->new  CompletarServicoUI().show());
        servicoMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO));
        return servicoMenu;
    }

    private Menu buildEspecificaColaboradorMenu(){
        final Menu colaboradorMenu = new Menu("Especificar Colaborador");
        colaboradorMenu.addItem(ESPECIFICAR_COLABORADOR,"Especificar Colaborador",()->new EspecificarColaboradorUI().show());
        colaboradorMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH));
        return colaboradorMenu;
    }

    private Menu buildEspecificaColaboradorFicheiroMenu(){
        final Menu colaboradorMenu = new Menu("Especificar Colaborador Pelo Ficheiro");
        colaboradorMenu.addItem(ESPECIFICAR_COLABORADOR,"Especificar Colaborador Pelo Ficheiro",()->new LerFicheiroColaboradorUI().show());
        colaboradorMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.RRH));
        return colaboradorMenu;
    }

    private Menu buildAtribuirCriticidadeMenu(){
        final Menu atribuirCriticidade = new Menu("Atribuir Criticidade");
        atribuirCriticidade.addItem(ATRIBUIR_CRITICIDADE,"Atribuir Criticidade",()->new AtribuirCriticidadeUI().show());
        atribuirCriticidade.addItem(EXIT_OPTION,RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.GESTOR_SERVICO));
        return atribuirCriticidade;
    }

}


