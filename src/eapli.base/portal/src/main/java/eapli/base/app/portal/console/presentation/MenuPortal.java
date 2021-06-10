package eapli.base.app.portal.console.presentation;

import eapli.base.Application;
import eapli.base.app.portal.console.presentation.atividades.ConsultarReivindicarTarefaUI;
import eapli.base.app.portal.console.presentation.atividades.ConsultarTarefasUI;
import eapli.base.app.portal.console.presentation.atividades.RealizarTarefaUI;
import eapli.base.app.portal.console.presentation.catalogo.ListCatalogoServicoUI;
import eapli.base.app.portal.console.presentation.pedido.AtribuirGrauSatisfacaoUI;
import eapli.base.app.portal.console.presentation.pedido.ShowTaskHistoryUI;
import eapli.base.app.portal.console.presentation.pedido.SolicitarServicoUI;
import eapli.base.app.common.console.presentation.authz.LoginUI;
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

public class MenuPortal extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";
    private static final String LOGOUT_LABEL = "Logout ";

    private static final int EXIT_OPTION = 0;
    private static final int LOGOUT_OPTION = 9;

    private static final int CONSULTAR_CATALOGO_SERVICO = 1;
    private static final int SOLICITAR_SERVICO = 2;
    private static final int CONSULTAR_TAREFAS = 3;
    private static final int ATRIBUIR_GRAU_SATISFACAO = 4;
    private static final int CONSULTAR_HISTORICO_PEDIDOS = 5;

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
        return authz.session().map(s -> "Portal [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Portal [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {

        final Menu mainMenu = new Menu();

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if(authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR)){
            final Menu menuCatalogoServico = buildConsultarCatalogoServico();
            mainMenu.addSubMenu(CONSULTAR_CATALOGO_SERVICO,menuCatalogoServico);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuSolicitarServico = buildSolicitarServico();
            mainMenu.addSubMenu(SOLICITAR_SERVICO,menuSolicitarServico);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuConsultarTarefas = buildConsultarTarefas();
            mainMenu.addSubMenu(CONSULTAR_TAREFAS,menuConsultarTarefas);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuAtribuirGrau = buildAtribuirGrau();
            mainMenu.addSubMenu(ATRIBUIR_GRAU_SATISFACAO,menuAtribuirGrau);
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
            final Menu menuConsultarHistoricoPedidos = buildConsultarHistoricoPedidos();
            mainMenu.addSubMenu(CONSULTAR_HISTORICO_PEDIDOS,menuConsultarHistoricoPedidos);
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
            final var menu = new MenuPortal();
            menu.mainLoop();
        }
        return false;
    }

    private boolean sairDaAplicacao(){
        System.out.println("Bye, Bye");
        System.exit(1);
        return false;
    }

    private Menu buildConsultarCatalogoServico(){
        final Menu consultarCatalogoServicoMenu = new Menu("Consultar Catálogo e/ou Serviço");
        consultarCatalogoServicoMenu.addItem(1,"Consultar Catálogo e/ou Serviço",()->new ListCatalogoServicoUI().show());
        consultarCatalogoServicoMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR));
        return consultarCatalogoServicoMenu;
    }

    private Menu buildConsultarTarefas(){
        final Menu consultarTarefasMenu = new Menu("Tarefas");
        consultarTarefasMenu.addItem(1,"Consultar Tarefas",()->new ConsultarTarefasUI().show());
        consultarTarefasMenu.addItem(2,"Consultar/ Reivindicar Tarefas",()->new ConsultarReivindicarTarefaUI().show());
        consultarTarefasMenu.addItem(3,"Realizar Tarefas",()->new RealizarTarefaUI().show());
        consultarTarefasMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR));
        return consultarTarefasMenu;
    }

    private Menu buildAtribuirGrau(){
        final Menu atribuirGrauMenu = new Menu("Atribuir Grau de Satisfação");
        atribuirGrauMenu.addItem(1,"Atribuir Grau de Satisfação",()->new AtribuirGrauSatisfacaoUI().show());
        atribuirGrauMenu.addItem(EXIT_OPTION, RETURN_LABEL,()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR));
        return atribuirGrauMenu;
    }

    private Menu buildConsultarHistoricoPedidos() {
        final Menu consultarHistoricoPedidos = new Menu("Consultar Historico de Pedidos");
        consultarHistoricoPedidos.addItem(1,"Consultar Historico de Pedidos",()->new ShowTaskHistoryUI().show());
        consultarHistoricoPedidos.addItem(EXIT_OPTION, RETURN_LABEL, ()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR));
        return consultarHistoricoPedidos;
    }

    private Menu buildSolicitarServico() {
        final Menu solicitarServico = new Menu("Solicitar Servico");
        solicitarServico.addItem(1,"Solicitar Servico",()->new SolicitarServicoUI().show());
        solicitarServico.addItem(EXIT_OPTION, RETURN_LABEL, ()->authz.isAuthenticatedUserAuthorizedTo(BaseRoles.COLABORADOR));
        return solicitarServico;
    }

}
