package base.daemon.executor.algorithms;

import base.daemon.executor.presentation.ExecutorServer;
import eapli.base.atividade.domain.Atividade;

import java.util.Queue;

public class WorkloadBasedAlgorithm {

    //private static ArrayList<Pair<Atividade,Double>> orderedInstances;

    private static Queue<ExecutorServer> instances;

    public static void main(String[] args) {
            //Percorrer todas as instancias do motor
            //Buscar a instancia com menor trabalho(baseado em tempo de execução)
            //O que for preciso fazer com a instancia
            //getInstances()
/*          GET EXECUTION TIMES
            long startTime = System.nanoTime();
            //methodToTime();
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
            ***NAO VIAVEL***
            Só obtida no final do metodo
            ***PROVAVELMENTE USAR UMA ESTIMATIVA (VARIAVEL GLOBAL)
 */
            for (ExecutorServer s: instances) {
                double tempo = 0;
                for (Atividade a : s.tarefas()) {

                }
            }


    }

    public boolean addInstance(ExecutorServer executorServer){
            return this.instances.add(executorServer);
    }

}
