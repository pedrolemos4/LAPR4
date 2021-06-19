package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.TipoAtividade;
import eapli.base.pedido.application.CumprimentoSlaController;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CumprimentoSlaUI extends AbstractUI {

    private CumprimentoSlaController controller = new CumprimentoSlaController();
    Scanner sc = new Scanner(System.in);

    @Override
    protected boolean doShow() {

        System.out.println("Insira uma data de Inicio para filtrar os pedidos:");
        Calendar calendar1 = setData();
        System.out.println("Insira uma data de Fim para filtrar os pedidos:");
        Calendar calendar2 = setData();

        System.out.println("Pedidos: ");
        if(!this.controller.getAllPedidoConcluido(calendar1, calendar2).isEmpty() || this.controller.getAllPedidoConcluido(calendar1, calendar2) != null) {
            System.out.println();
            for (Pedido pedido : this.controller.getAllPedidoConcluido(calendar1, calendar2)) {
                long tempoMaximoAprov = this.controller.getTempoMaximoAprov(pedido.identity());
                long tempoMaximoRes = this.controller.getTempoMaximoRes(pedido.identity());
                printPedidoObjetivos(pedido, tempoMaximoRes, tempoMaximoAprov);

                List<Atividade> listAtividades = this.controller.getTarefasDoPedido(pedido.identity());
                for (Atividade at : listAtividades) {
                    System.out.println("Tempo decorrido na Atividade: " + this.controller.getTempoDaTarefa(at.identity()));
                    checkAtividade(at, tempoMaximoRes, tempoMaximoAprov);

                }
                System.out.println("------------------------------------------------------------------------");
            }
        } else{
            System.out.println("Não existem pedidos concluídos no momento.");
        }

        return false;
    }

    private void printPedidoObjetivos(Pedido pedido, long tempoMaximoRes, long tempoMaximoAprov) {
        System.out.println(pedido.toString());
        System.out.println("Este pedido tem como objectivos máximos: ");
        System.out.println("Tempo Maximo das Atividades de Aprovação: " + tempoMaximoAprov);
        System.out.println("Tempo Maximo das Atividades de Resolução: " + tempoMaximoRes);
    }

    private void checkAtividade(Atividade at, long tempoMaximoRes, long tempoMaximoAprov) {

        if (TipoAtividade.APROVACAO.equals(this.controller.getTipoAtividade(at.identity()))) {
            if (this.controller.getTempoDaTarefa(at.identity()) > tempoMaximoAprov) {
                System.out.println("Atividade de Aprovação realizada para além do tempo máximo proposto");
                System.out.println("Incumprimento do SLA");
            } else {
                System.out.println("Atividade de Aprovação realizada dentro do tempo máximo proposto");
                System.out.println("Cumprimento do SLA");
            }
        } else {
            if (this.controller.getTempoDaTarefa(at.identity()) > tempoMaximoRes) {
                System.out.println("Atividade de Resolução realizada para além do tempo máximo proposto");
                System.out.println("Incumprimento do SLA");
            } else {
                System.out.println("Atividade de Resolução realizada dentro do tempo máximo proposto");
                System.out.println("Cumprimento do SLA");
            }
        }

    }

    public Calendar setData() {
        try {
            String string1[] = sc.next().split(",");
            String data1[] = string1[0].split("/");
            String horas1[] = string1[1].split(":");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(data1[0]), Integer.parseInt(data1[1]) - 1, Integer.parseInt(data1[2]), Integer.parseInt(horas1[0]), Integer.parseInt(horas1[1]));
            return calendar;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Insira a data corretamente\n");
            System.out.println("\nData (yyyy/mm/dd,hh:mm)________________________________________");
            setData();
        } catch (NumberFormatException ex) {
            System.out.println("Insira a data corretamente\n");
            System.out.println("\nData (yyyy/mm/dd,hh:mm)________________________________________");
            setData();
        }
        return null;
    }

    @Override
    public String headline() {
        return "Listagem sobre o (in)cumprimento do SLA";
    }
}
