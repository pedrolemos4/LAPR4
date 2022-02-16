package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaborador.domain.Funcao;
import eapli.base.usermanagement.application.AddUserController;
import eapli.framework.io.util.Console;
import eapli.base.colaborador.application.EspecificarColaboradorController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.*;

public class EspecificarColaboradorUI extends AbstractUI {

    private final EspecificarColaboradorController controller = new EspecificarColaboradorController();
    private final AddUserController userController = new AddUserController();

    @Override
    protected boolean doShow() {

        System.out.println("Insira os dados relativos ao colaborador que pretende criar:");

        try {
            final MecanographicNumberWidget numberWidget = new MecanographicNumberWidget();
            numberWidget.show();

            final ShortNameWidget shortNameWidget = new ShortNameWidget();
            shortNameWidget.show();

            final FullNameWidget fullNameWidget = new FullNameWidget();
            fullNameWidget.show();

            final DataWidget dataWidget = new DataWidget();
            dataWidget.show();

            final EnderecoEmailWidget endereco = new EnderecoEmailWidget();
            endereco.show();

            final LocalResidenciaWidget localResidenciaWidget = new LocalResidenciaWidget();
            localResidenciaWidget.show();

            final ContactoWidget contactoWidget = new ContactoWidget();
            contactoWidget.show();

            final UsernameWidget usernameWidget = new UsernameWidget();
            usernameWidget.show();

            List<Role> listAllRoles = new ArrayList<>();
            for (int i = 0; i < BaseRoles.nonUserValues().length; i++) {
                listAllRoles.add(BaseRoles.nonUserValues()[i]);
            }

            Set<Role> listRole = new HashSet<>();
            final SelectWidget<Role> selectorRole = new SelectWidget<>("Lista Roles:", listAllRoles, new ListRolePrint());

            boolean bool = true;
            System.out.println("Selecione o papel do colaborador");
            System.out.println("Pretende selecionar mais algum papel além de colaborador?");
            String resposta = Console.readLine("(S/N)");
            if (resposta.equalsIgnoreCase("S")) {
                while (bool) {

                    selectorRole.show();
                    Role role = selectorRole.selectedElement();
                    listRole.add(role);
                    System.out.println("Pretende adicionar mais papeis?");
                    String respostaFinal = Console.readLine("Resposta");
                    if (respostaFinal.equalsIgnoreCase("N")) {
                        bool = false;
                    }
                }
            }
            if (listRole.isEmpty() || !listRole.contains(BaseRoles.COLABORADOR)) {
                listRole.add(BaseRoles.COLABORADOR);
            }

            Set<Funcao> listFuncao = new HashSet<>();
            listFuncao.add(Funcao.COMERCIAL);
            listFuncao.add(Funcao.ASSISTENTE_DIRECAO);
            listFuncao.add(Funcao.DIRETOR);
            listFuncao.add(Funcao.GESTOR_CLIENTES);
            final SelectWidget<Funcao> selectorFuncao = new SelectWidget<>("Lista Funcões:", listFuncao, new ListFuncoesPrint());
            Set<Funcao> listFuncaoAtribuir = new HashSet<>();
            bool=true;
            while(bool){
                System.out.println("Selecione as funcoes do colaborador:");
                selectorFuncao.show();
                Funcao funcao = selectorFuncao.selectedElement();
                listFuncaoAtribuir.add(funcao);
                System.out.println("Pretende adicionar mais funcoes?");
                String respostaFinal = Console.readLine("Resposta");
                if (respostaFinal.equalsIgnoreCase("N")) {
                    bool = false;
                }
            }

            final String password = this.controller.geraPassword();
            String fullName[] = fullNameWidget.value().split(" ");
            this.userController.addUser(usernameWidget.value(), password, fullName[0], fullName[fullName.length - 1], endereco.value(), listRole);
            this.controller.novoColaborador(numberWidget.value(), fullNameWidget.value(), shortNameWidget.value(), dataWidget.value(), contactoWidget.prefix(), contactoWidget.contact(), localResidenciaWidget.value(), endereco.value(), listFuncaoAtribuir);
        } catch (Exception e) {
            System.out.println("Erro");
            System.out.println("");
            doShow();
        }

        return false;
    }

    @Override
    public String headline() {
        return "Especificar Colaborador";
    }
}
