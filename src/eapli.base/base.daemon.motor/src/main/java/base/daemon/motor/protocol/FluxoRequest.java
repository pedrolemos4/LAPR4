package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.base.atividades.domain.*;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.servico.domain.Servico;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FluxoRequest extends AplicacoesRequest{
    //private final String servicoId;

    static InetAddress serverIP;
    static Socket sock;

    public FluxoRequest(final AplicacoesController controller,final String request/*, final String servicoId*/){
        super(controller,request);
      //  this.servicoId = servicoId;
    }

    @Override
    public String execute() {
        try{
            String id = request.trim();
            Servico servico = controller.findServico(id);
            FluxoAtividade fluxo = controller.getFluxoAtividade(id);
            for(Atividade atividade : fluxo.atividades()){
                if(atividade instanceof AtividadeManual){
                    if(atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)){
                        fluxo.alterarEstado(EstadoFluxo.EM_APROVACAO);
                        servico.alterarEstadoFluxo(fluxo);
                        controller.saveServico(servico);
                        //fazer atividade aprovação
                    } else {
                        fluxo.alterarEstado(EstadoFluxo.EM_RESOLUCAO);
                        servico.alterarEstadoFluxo(fluxo);
                        controller.saveServico(servico);
                        //fazer atividade resolução
                    }
                } else{
                    //mandar para o executor
                    byte[] data = new byte[258];
                    try {
                        serverIP = InetAddress.getLocalHost();//.getByName("endereçoIp");
                    } catch (UnknownHostException ex) {
                        System.out.println("Invalid server: " + "endereçoIp");
                        System.exit(1);
                    }

                    try {
                        sock = new Socket(serverIP, 32507);
                    } catch (IOException ex) {
                        System.out.println("Failed to connect.");
                        System.exit(1);
                    }
                    DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
                    System.out.println("Connected to server");
                    //Thread serverConn = new Thread(new TcpChatCliConn(sock));
                    //serverConn.start();

                    data[0] = 0;
                    data[1] = 3;
                    CodigoUnico cod = new CodigoUnico("cod123");
                    Script s = new Script("TESTE");
                    byte[] idArray = s.toString().getBytes();//pedido.servico().identity().toString().getBytes();
                    data[2] = (byte)idArray.length;
                    for(int i = 0; i<idArray.length;i++){
                        data[i+2] = idArray[i];
                    }

                    sOut.write(data);

                    // serverConn.join();
                    sock.close();
                }
            }
        } catch (final NumberFormatException e){
            return buildBadRequest("Invalid servico id");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
