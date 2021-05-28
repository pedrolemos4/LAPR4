package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;

public class NumeroTarefasPendentesRequest extends AplicacoesRequest {

    private final int hours;
    private final int userid;

    public NumeroTarefasPendentesRequest(final AplicacoesController controller, final String request, final String hours,
                                         final String user){
        super(controller, request);
        this.hours = Integer.parseInt(hours);
        this.userid = Integer.parseInt(user);
    }

    @Override
    public String execute() {
        // semantic validation
        /*CodigoUnico servico;
        try {
            servico = CodigoUnico.valueOf(servicoId);
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid servico id");
        }*/

        MecanographicNumber user;
        try {
            user = MecanographicNumber.valueOf(userid);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Invalid user name");
        }

        // execution
        try {
            final EstadoAtividade estado = EstadoAtividade.PENDENTE;
            final Long quantidadeTarefasPendentes = controller.getNTarefasPendentes(user, estado);
            // nao tenho a certeza ----------------------REVER------------------------------
            final Long tarefasQueUltrapassamDataPedido = controller.getTarefasQueUltrapassamDataPedido(user, estado);
            //-------------------------------- REVER SITUAÇAO DAS DATAS -----------------------
            final Long tarefasQueTerminamEmXHora = controller.getTarefasQueTerminamEmXHora(user, estado, hours);

            // falta ordenar por urgencia e criticidade

            // response
            return buildResponse(quantidadeTarefasPendentes, tarefasQueUltrapassamDataPedido, tarefasQueTerminamEmXHora);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown user name");
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    private String buildResponse(final Long token, final Long tarefasQueUltrapassamDataPedido, final Long tarefasQueTerminamEmXHora) {
        return "Quantidade de Tarefas Pendentes: \"" + token + "\"\n" +
                "Quantidade de Tarefas Pendentes que ultrapassam a data de resolução estabelecida no pedido: \"" + tarefasQueUltrapassamDataPedido + "\"\n" +
                "Quantidade de Tarefas Pendentes que terminam em \"" + hours + ": \"" + tarefasQueTerminamEmXHora + "\"\n";
    }

}
