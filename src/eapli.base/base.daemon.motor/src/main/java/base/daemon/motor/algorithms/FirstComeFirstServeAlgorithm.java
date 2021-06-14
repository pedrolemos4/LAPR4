package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;
import eapli.base.colaborador.domain.Colaborador;

public class FirstComeFirstServeAlgorithm implements Runnable{

    private Colaborador colaborador;

    private Atividade atividade;

    public FirstComeFirstServeAlgorithm(Colaborador colaborador,Atividade atividade){
        this.colaborador=colaborador;
        this.atividade = atividade;
    }

    @Override
    public void run() {
        
    }


}
