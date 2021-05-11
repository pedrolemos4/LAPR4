package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.app.backoffice.console.presentation.servicos.DescricaoBreveDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.DescricaoCompletaDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.KeywordsDataWidget;
import eapli.base.app.backoffice.console.presentation.servicos.TituloDataWidget;
import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.gestaoservicosrh.domain.Equipa;
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
            String opcao = Console.readLine("Deseja consultar catalogos ou servicos ou ambos? (catalogo|servico|ambos)");
            if ("catalogo".equalsIgnoreCase(opcao)) {

                final TituloDataWidget tituloDataWidget = new TituloDataWidget();
                tituloDataWidget.show();

                final DescricaoBreveDataWidget descricaoBreveDataWidget = new DescricaoBreveDataWidget();
                descricaoBreveDataWidget.show();

                final DescricaoCompletaDataWidget descricaoCompletaDataWidget = new DescricaoCompletaDataWidget();
                descricaoCompletaDataWidget.show();

                try {
                    Set<Equipa> listaEquipaUser = this.controller.getEquipasDoUser();

                    Set<Catalogo> list = this.controller.findCatalogo(listaEquipaUser, tituloDataWidget.titulo(),
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

                final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
                descricaoBreveData.show();

                final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
                descricaoCompletaData.show();

                final KeywordsDataWidget keywordsDataWidget = new KeywordsDataWidget();
                keywordsDataWidget.show();
                boolean flag1 = true;

                Set<String> keywords = new HashSet<>();
                if(!keywordsDataWidget.keyword().isEmpty()) {
                    keywords.add(keywordsDataWidget.keyword());
                }

                while(flag1){
                    String answer;
                    System.out.println("Deseja adicionar mais keywords?");
                    answer=Console.readLine("Resposta(S/N):");
                    if(answer.equalsIgnoreCase("Sim") || answer.equalsIgnoreCase("S")){
                        keywordsDataWidget.show();
                        if(!keywordsDataWidget.keyword().isEmpty()) {
                            keywords.add(keywordsDataWidget.keyword());
                        }
                    } else {
                        flag1 = false;
                    }
                }

                try {
                    Set<Equipa> listaEquipaUser = this.controller.getEquipasDoUser();
                    Set<Servico> list = this.controller.findServicosUtilizador(listaEquipaUser, keywords, tituloData.titulo(),
                            descricaoBreveData.descricao(), descricaoCompletaData.descricao());
                    for(Servico c: list){
                        System.out.println(c.toString());
                    }
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }

            } else {

                System.out.println("Insira informação relativa ao catalogo");

                final TituloDataWidget tituloDataWidget = new TituloDataWidget();
                tituloDataWidget.show();

                final DescricaoBreveDataWidget descricaoBreveDataWidget = new DescricaoBreveDataWidget();
                descricaoBreveDataWidget.show();

                final DescricaoCompletaDataWidget descricaoCompletaDataWidget = new DescricaoCompletaDataWidget();
                descricaoCompletaDataWidget.show();

                Set<Catalogo> listCatalogos = new HashSet<>();
                try {
                    Set<Equipa> listaEquipa = this.controller.getEquipasDoUser();
                    listCatalogos = this.controller.findCatalogo(listaEquipa,tituloDataWidget.titulo(),
                            descricaoBreveDataWidget.descricao(), descricaoCompletaDataWidget.descricao());
                    for(Catalogo c: listCatalogos){
                        System.out.println(c.toString());
                    }
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }

                System.out.println("Para estes catálogos agora consulte os seus servicos:");

                final TituloDataWidget tituloData = new TituloDataWidget();
                tituloData.show();

                final KeywordsDataWidget keywordsDataWidget = new KeywordsDataWidget();
                keywordsDataWidget.show();
                boolean flag1 = true;

                Set<String> keywords = new HashSet<>();
                keywords.add(keywordsDataWidget.keyword());

                while(flag1){
                    String answer;
                    System.out.println("Deseja adicionar mais keywords?");
                    answer=Console.readLine("Resposta(S/N):");
                    if(answer.equalsIgnoreCase("Sim") || answer.equalsIgnoreCase("S")){
                        keywordsDataWidget.show();
                        keywords.add(keywordsDataWidget.keyword());
                    } else {
                        flag1 = false;
                    }
                }

                final DescricaoBreveDataWidget descricaoBreveData = new DescricaoBreveDataWidget();
                descricaoBreveData.show();

                final DescricaoCompletaDataWidget descricaoCompletaData = new DescricaoCompletaDataWidget();
                descricaoCompletaData.show();

                try {
                    Set<Equipa> listaEquipa = this.controller.getEquipasDoUser();
                    Set<Servico> list1 = this.controller.findServicos(listaEquipa,listCatalogos, keywords, tituloData.titulo()
                            , descricaoBreveData.descricao(), descricaoCompletaData.descricao());
                    for(Servico c: list1){
                        System.out.println(c.toString());
                    }
                } catch (final IntegrityViolationException e) {
                    System.out.println("Erro.");
                }
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
        return "Consulta de catalogos e/ou servicos: ";
    }
}
