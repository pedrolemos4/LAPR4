package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.gestaoservicosrh.application.EspecificarColaboradorController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;

public class EspecificarColaboradorUI  extends AbstractUI {

    private final EspecificarColaboradorController controller = new EspecificarColaboradorController();

    @Override
    protected boolean doShow() {

        System.out.println("Insira os dados relativos ao colaborador que pretende criar:");

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

        try{
            final String password = this.controller.geraPassword();
            String fullName[]=fullNameWidget.value().split(" ");
            this.controller.novoUtilizador(usernameWidget.value(),password,fullName[0],fullName[fullName.length-1], endereco.value());
            this.controller.novoColaborador(numberWidget.value(),fullNameWidget.value(),shortNameWidget.value(),dataWidget.value(),contactoWidget.value(),localResidenciaWidget.value(),endereco.value());
        }catch (final IntegrityViolationException e){
            System.out.println("Colaborador já existe");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Especificar Colaborador";
    }
}
