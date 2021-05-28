package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.base.atividades.domain.Atividade;
import eapli.base.atividades.domain.EstadoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.pedido.domain.UrgenciaPedido;

import java.util.List;

public class NumeroTarefasPendentesRequest extends AplicacoesRequest {

    private final int userid;

    public NumeroTarefasPendentesRequest(final AplicacoesController controller, final String request,
                                         final String user){
        super(controller, request);
        this.userid = Integer.parseInt(user);
    }

    @Override
    public String execute() {
        // semantic validation
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
            final Long tarefasQueTerminamEmXHora = controller.getTarefasQueTerminamEm1Hora(user, estado, 1);

            final UrgenciaPedido urgenciaReduzida = UrgenciaPedido.REDUZIDA;
            final List<Atividade> tarefasUrgenciaReduzida = controller.getTarefasUrgencia(user,estado, urgenciaReduzida);
            final UrgenciaPedido urgenciaUrgente = UrgenciaPedido.URGENTE;
            final List<Atividade> tarefasUrgenciaUrgente = controller.getTarefasUrgencia(user,estado, urgenciaUrgente);
            final UrgenciaPedido urgenciaModerada = UrgenciaPedido.MODERADA;
            final List<Atividade> tarefasUrgenciaModerada = controller.getTarefasUrgencia(user,estado, urgenciaModerada);

            final List<Atividade> tarefasEscala1 = controller.getTarefaEscala(user, estado, 1);
            final List<Atividade> tarefasEscala2 = controller.getTarefaEscala(user, estado, 2);
            final List<Atividade> tarefasEscala3 = controller.getTarefaEscala(user, estado, 3);
            final List<Atividade> tarefasEscala4 = controller.getTarefaEscala(user, estado, 4);
            final List<Atividade> tarefasEscala5 = controller.getTarefaEscala(user, estado, 5);

            final List<Atividade> tarefasEtiquetaBaixa = controller.getTarefaEtiqueta(user, estado, "Baixa");
            final List<Atividade> tarefasEtiquetaMedia = controller.getTarefaEtiqueta(user, estado, "Media");
            final List<Atividade> tarefasEtiquetaElevada = controller.getTarefaEtiqueta(user, estado, "Elevada");


            // response
            return buildResponse(quantidadeTarefasPendentes, tarefasQueUltrapassamDataPedido, tarefasQueTerminamEmXHora,
                    tarefasUrgenciaReduzida, tarefasUrgenciaModerada, tarefasUrgenciaUrgente, tarefasEscala1,
                    tarefasEscala2, tarefasEscala3, tarefasEscala4, tarefasEscala5, tarefasEtiquetaBaixa,
                    tarefasEtiquetaMedia, tarefasEtiquetaElevada);
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown user name");
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    private String buildResponse(final Long token, final Long tarefasQueUltrapassamDataPedido, final Long tarefasQueTerminamEmXHora,
                                 final List<Atividade> tarefasUrgenciaReduzida, final List<Atividade> tarefasUrgenciaModerada,
                                 final List<Atividade> tarefasUrgenciaUrgente, final List<Atividade> tarefasEscala1,
                                 final List<Atividade> tarefasEscala2, final List<Atividade> tarefasEscala3,
                                 final List<Atividade> tarefasEscala4, final List<Atividade> tarefasEscala5,
                                 final List<Atividade> tarefasEtiquetaBaixa, final List<Atividade> tarefasEtiquetaMedia,
                                 final List<Atividade> tarefasEtiquetaElevada) {
        return "Quantidade de Tarefas Pendentes: \"" + token + "\"\n" +
                "Quantidade de Tarefas Pendentes que ultrapassam a data de resolução estabelecida no pedido: \"" + tarefasQueUltrapassamDataPedido + "\"\n" +
                "Quantidade de Tarefas Pendentes que terminam em 1 hora: \"" + tarefasQueTerminamEmXHora + "\"\n" +
                "Tarefas Pendentes com Urgência Reduzida: \"" + String.join("\n",tarefasUrgenciaReduzida.toString()) + "\"\n" +
                "Tarefas Pendentes com Urgência Moderada: \"" + String.join("\n",tarefasUrgenciaModerada.toString()) + "\"\n" +
                "Tarefas Pendentes com Urgência Urgente: \"" + String.join("\n",tarefasUrgenciaUrgente.toString()) + "\"\n" +
                "Tarefas Pendentes com Escala 1 de Criticidade: \"" + String.join("\n",tarefasEscala1.toString()) + "\"\n" +
                "Tarefas Pendentes com Escala 2 de Criticidade: \"" + String.join("\n",tarefasEscala2.toString()) + "\"\n" +
                "Tarefas Pendentes com Escala 3 de Criticidade: \"" + String.join("\n",tarefasEscala3.toString()) + "\"\n" +
                "Tarefas Pendentes com Escala 4 de Criticidade: \"" + String.join("\n",tarefasEscala4.toString()) + "\"\n" +
                "Tarefas Pendentes com Escala 5 de Criticidade: \"" + String.join("\n",tarefasEscala5.toString()) + "\"\n" +
                "Tarefas Pendentes com Etiqueta Baixa de Criticidade: \"" + String.join("\n",tarefasEtiquetaBaixa.toString()) + "\"\n" +
                "Tarefas Pendentes com Etiqueta Media de Criticidade: \"" + String.join("\n",tarefasEtiquetaMedia.toString()) + "\"\n" +
                "Tarefas Pendentes com Etiqueta Elevada de Criticidade: \"" + String.join("\n",tarefasEtiquetaElevada.toString()) + "\"\n";
    }

}
