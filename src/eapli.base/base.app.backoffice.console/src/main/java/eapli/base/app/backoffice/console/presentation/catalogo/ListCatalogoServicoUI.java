package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.app.backoffice.console.presentation.servicos.DescricaoBreveDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.DescricaoCompletaDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.TituloDataWidget;
import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.utilizador.application.ListCatalogoServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class ListCatalogoServicoUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(ListCatalogoServicoUI.class);

    private final ListCatalogoServicoController controller = new ListCatalogoServicoController();

    @Override
    protected boolean doShow() {

        boolean flag = true;

        while (flag) {
            String opcao = Console.readLine("Deseja consultar catalogos, servicos ou ambos (S/N)?");
            if ("catalogo".equalsIgnoreCase(opcao)) {

                final TituloDataWidget tituloDataWidget = new TituloDataWidget();
                tituloDataWidget.show();

                final DescricaoBreveDataWidget descricaoBreveDataWidget = new DescricaoBreveDataWidget();
                descricaoBreveDataWidget.show();

                final DescricaoCompletaDataWidget descricaoCompletaDataWidget = new DescricaoCompletaDataWidget();
                descricaoCompletaDataWidget.show();

                try {
                    Set<Catalogo> list = this.controller.findCatalogo(tituloDataWidget.titulo(),
                            descricaoBreveDataWidget.descricao(), descricaoCompletaDataWidget.descricao());
                    System.out.println(list);
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }

            } else if ("servico".equalsIgnoreCase(opcao)) {

            } else {

            }

            String answer = Console.readLine("Deseja adicionar mais niveis de criticidade (S/N)?");
            if ("N".equalsIgnoreCase(answer)) {
                flag = false;
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Consulta de catalogos e/ou servicos:";
    }
}
