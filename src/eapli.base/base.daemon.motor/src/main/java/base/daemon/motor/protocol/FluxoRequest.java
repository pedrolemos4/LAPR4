package base.daemon.motor.protocol;

import eapli.base.atividades.application.AplicacoesController;
import eapli.base.atividades.domain.*;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.servico.domain.Servico;

public class FluxoRequest extends AplicacoesRequest{
    //private final String servicoId;


    public FluxoRequest(final AplicacoesController controller,final String request/*, final String servicoId*/){
        super(controller,request);
      //  this.servicoId = servicoId;
    }

    @Override
    public String execute() {
        try{
            Servico servico = controller.findServico(request);
            FluxoAtividade fluxo = controller.getFluxoAtividade(request);
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
                }
            }
        } catch (final NumberFormatException e){
            return buildBadRequest("Invalid servico id");
        }
        return null;
    }
}
