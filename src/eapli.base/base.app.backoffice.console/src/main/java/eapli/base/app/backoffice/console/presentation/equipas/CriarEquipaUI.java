package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.app.backoffice.console.presentation.servicos.CodigoUnicoDataWidget;
import eapli.base.gestaoservicosrh.application.CriarEquipaController;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.Set;

public class CriarEquipaUI extends AbstractUI {

    private final CriarEquipaController controller = new CriarEquipaController();

    @Override
    protected boolean doShow() {
        final Iterable<TipoEquipa> listTipos = this.controller.listTipos();
        final Iterable<Colaborador> listColab = this.controller.listColab();
        CodigoUnicoDataWidget codigoUnicoData = null;
        AcronimoDataWidget acronimoData = null;
        DesignacaoDataWidget designacaoData = null;
        TipoEquipa tipo = null;
        Set<Colaborador> colabs = null;

        while(true){
            try{
                codigoUnicoData = new CodigoUnicoDataWidget();
                codigoUnicoData.show();

                acronimoData = new AcronimoDataWidget();
                acronimoData.show();

                designacaoData = new DesignacaoDataWidget();
                designacaoData.show();

                final SelectWidget<TipoEquipa> selector = new SelectWidget<>("Tipos de Equipas: ", listTipos, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
                selector.show();

                tipo = selector.selectedElement();

                while(true) {
                    final SelectWidget<Colaborador> selector2 = new SelectWidget<>("Lista de Colaboradores: ", listColab, visitee -> System.out.printf("%-15s%-80s", visitee.identity(), visitee.toString()));
                    selector2.show();

                    if (colabs.contains(selector2.selectedElement())) {
                        System.out.println("Já colocou este colaborador!");
                    } else {
                        colabs.add(selector2.selectedElement());
                    }

                    String answer = Console.readLine("Deseja adicionar mais colaboradores responsáveis? (S/N)?");
                    if("N".equalsIgnoreCase(answer))
                            break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Dado inválido!");
            } catch (NullPointerException e) {
                System.out.println("Não existem dados a selecionar!");
            }

            try {
                this.controller.novaEquipa(codigoUnicoData.codigoUnico(), acronimoData.acronimo(), designacaoData.designacao(), tipo, colabs);
                break;
            } catch (final IntegrityViolationException e){
                System.out.println("A equipa criada já existe na base de dados.");
            } catch (IllegalArgumentException e) {
                System.out.println("O colaborador selecionado ja existe numa equipa com este tipo!!");
            }
        }

        System.out.println("Equipa criada com sucesso!");
        return false;
    }

    @Override
    public String headline() {
        return "Criar Equipa";
    }
}
