package base.daemon.motor.protocol;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.pedido.domain.UrgenciaPedido;

import java.util.List;

public class NumeroTarefasPendentesRequest extends AplicacoesRequest {

    public NumeroTarefasPendentesRequest(final AplicacoesController controller, final String request){
        super(controller, request);
    }

    @Override
    public byte[] execute() {
        // semantic validation
        MecanographicNumber user;
        try {
            user = MecanographicNumber.valueOf(Integer.parseInt(request.trim()));
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Invalid user name").getBytes();
        }

        // execution
        try {
            final EstadoAtividade estado = EstadoAtividade.PENDENTE;

            final List<Atividade> quantidadeTarefasPendentes = controller.getNTarefasPendentes(user, estado);

            final List<Atividade> tarefasQueUltrapassamDataPedido = controller.getTarefasQueUltrapassamDataPedido(user, estado);

            final List<Atividade> tarefasQueTerminamEmXHora = controller.getTarefasQueTerminamEm1Hora(user, estado, 1);

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

            final List<Atividade> tarefasEtiquetaBaixa = controller.getTarefaEtiqueta(user, estado, "BAIXA");
            final List<Atividade> tarefasEtiquetaMedia = controller.getTarefaEtiqueta(user, estado, "MEDIA");
            final List<Atividade> tarefasEtiquetaElevada = controller.getTarefaEtiqueta(user, estado, "ELEVADA");

            byte[] data = new byte[258];
            data[0] = 1;
            data[1] = 1;

            String resposta = buildResponse(quantidadeTarefasPendentes, tarefasQueUltrapassamDataPedido, tarefasQueTerminamEmXHora,
                    tarefasUrgenciaReduzida, tarefasUrgenciaModerada, tarefasUrgenciaUrgente, tarefasEscala1,
                    tarefasEscala2, tarefasEscala3, tarefasEscala4, tarefasEscala5, tarefasEtiquetaBaixa,
                    tarefasEtiquetaMedia, tarefasEtiquetaElevada);
            System.out.println(resposta);
            byte[] idArray = resposta.getBytes();
            //int size = idArray.length;
            //data[2] = (byte) size;
            //int p = 0;
            for (int i = 0; i < idArray.length; i++) {
                data[i] = idArray[i];
              //  p++;
            }
            return data;
        } catch (final IllegalArgumentException e) {
            return buildBadRequest("Unknown user name").getBytes();
        } catch (final Exception e) {
             //we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage()).getBytes();
        }
    }

    private String buildResponse(final List<Atividade> token, final List<Atividade> tarefasQueUltrapassamDataPedido, final List<Atividade> tarefasQueTerminamEmXHora,
                                 final List<Atividade> tarefasUrgenciaReduzida, final List<Atividade> tarefasUrgenciaModerada,
                                 final List<Atividade> tarefasUrgenciaUrgente, final List<Atividade> tarefasEscala1,
                                 final List<Atividade> tarefasEscala2, final List<Atividade> tarefasEscala3,
                                 final List<Atividade> tarefasEscala4, final List<Atividade> tarefasEscala5,
                                 final List<Atividade> tarefasEtiquetaBaixa, final List<Atividade> tarefasEtiquetaMedia,
                                 final List<Atividade> tarefasEtiquetaElevada) {
        return String.format("%d %d %d %d %d %d %d %d %d %d %d %d %d",token.size(), tarefasQueUltrapassamDataPedido.size(), tarefasQueTerminamEmXHora.size(),
                tarefasUrgenciaReduzida.size(), tarefasUrgenciaModerada.size(), tarefasUrgenciaUrgente.size(), tarefasEscala1.size(),
                tarefasEscala2.size(), tarefasEscala3.size(), tarefasEscala4.size(), tarefasEscala5.size(), tarefasEtiquetaBaixa.size(),
                tarefasEtiquetaMedia.size(), tarefasEtiquetaElevada.size());
    }
    /*
    "Quantidade de Tarefas Pendentes: \"" + token + "\"\n" +
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
                "Tarefas Pendentes com Etiqueta Elevada de Criticidade: \"" + String.join("\n",tarefasEtiquetaElevada.toString()) + "\"\n"
     */

}
