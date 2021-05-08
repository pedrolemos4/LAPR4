package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.app.backoffice.console.presentation.servicos.DescricaoBreveDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.DescricaoCompletaDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.TituloDataWidget;
import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.utilizador.application.ListCatalogoServicoController;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public class ListCatalogoServicoUI extends AbstractUI {
    private static final Logger LOGGER = LogManager.getLogger(ListCatalogoServicoUI.class);

    private final ListCatalogoServicoController controller = new ListCatalogoServicoController();

    @Override
    protected boolean doShow() {

        boolean flag = true;

        while (flag) {
            String opcao = Console.readLine("Deseja consultar catalogos ou servicos? (catalogo|servico)");
            if ("catalogo".equalsIgnoreCase(opcao)) {

                final TituloDataWidget tituloDataWidget = new TituloDataWidget();
                tituloDataWidget.show();

                final DescricaoBreveDataWidget descricaoBreveDataWidget = new DescricaoBreveDataWidget();
                descricaoBreveDataWidget.show();

                final DescricaoCompletaDataWidget descricaoCompletaDataWidget = new DescricaoCompletaDataWidget();
                descricaoCompletaDataWidget.show();

                try {
                    Set<Catalogo> list = new HashSet<>();
                    this.controller.findCatalogo(list, tituloDataWidget.titulo(),
                            descricaoBreveDataWidget.descricao(), descricaoCompletaDataWidget.descricao());
                    for(Catalogo c: list){
                        System.out.println(c.toString());
                    }
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }

            } else if ("servico".equalsIgnoreCase(opcao)) {

                final TituloDataWidget tituloData = new TituloDataWidget();
                tituloData.show();

                ///FALTAM AS KEYWORDS

                final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
                descricaoBreveData.show();

                final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
                descricaoCompletaData.show();

                try {
                    Set<Servico> list = new HashSet<>();
                    this.controller.findServicosUtilizador(list, tituloData.titulo(),
                            descricaoBreveData.descricao(), descricaoCompletaData.descricao());
                    for(Servico c: list){
                        System.out.println(c.toString());
                    }
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }

            } else {

                final TituloDataWidget tituloDataWidget = new TituloDataWidget();
                tituloDataWidget.show();

                final DescricaoBreveDataWidget descricaoBreveDataWidget = new DescricaoBreveDataWidget();
                descricaoBreveDataWidget.show();

                final DescricaoCompletaDataWidget descricaoCompletaDataWidget = new DescricaoCompletaDataWidget();
                descricaoCompletaDataWidget.show();



            }
            String answer = Console.readLine("Deseja consultar mais catalogos e/ou servicos (S/N)?");
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
