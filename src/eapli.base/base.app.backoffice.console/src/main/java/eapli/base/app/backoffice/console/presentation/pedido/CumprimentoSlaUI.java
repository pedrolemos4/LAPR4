package eapli.base.app.backoffice.console.presentation.pedido;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.TipoAtividade;
import eapli.base.pedido.application.CumprimentoSlaController;
import eapli.base.pedido.domain.Pedido;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class CumprimentoSlaUI extends AbstractUI {

    private CumprimentoSlaController controller = new CumprimentoSlaController();

    @Override
    protected boolean doShow() {

        System.out.println("Pedidos: ");
        if(!this.controller.getAllPedidoConcluido().isEmpty() || this.controller.getAllPedidoConcluido() != null) {
            for (Pedido pedido : this.controller.getAllPedidoConcluido()) {
                long tempoMaximoAprov = this.controller.getTempoMaximoAprov(pedido.identity());
                long tempoMaximoRes = this.controller.getTempoMaximoRes(pedido.identity());
                printPedidoObjetivos(pedido, tempoMaximoRes, tempoMaximoAprov);

                List<Atividade> listAtividades = this.controller.getTarefasDoPedido(pedido.identity());
                for (Atividade at : listAtividades) {
                    System.out.println("Tempo decorrido na Atividade: " + this.controller.getTempoDaTarefa(at.identity()));
                    checkAtividade(at, tempoMaximoRes, tempoMaximoAprov);

                }
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

    @Override
    public String headline() {
        return "Listagem sobre o (in)cumprimento do SLA das solicitações recebidas e já concluídas num determinado intervalo de tempo";
    }
}
