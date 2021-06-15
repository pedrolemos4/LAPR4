package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.TipoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.repositories.ServicoRepository;

import java.util.*;

public class AlgoritmoTempoMedio implements Runnable {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();

    private List<Colaborador> list;

    private Atividade atividade;

    private CodigoUnico identity;

    private int incrementoColaboradores=0;

    private Map<Colaborador, Double> mapColaboradores;

    public AlgoritmoTempoMedio(List<Colaborador> list, Atividade atividade, CodigoUnico identity) {
        this.list = list;
        this.atividade = atividade;
        this.identity = identity;
        this.mapColaboradores = new TreeMap<>();
    }

    @Override
    public void run() {

        double tempoMedioTotal = 0;
        if (atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
            tempoMedioTotal += servicoRepository.tempoMedioAprovacao(identity);
        } else {
            tempoMedioTotal += servicoRepository.tempoMedioResolucao(identity);
        }
        synchronized (this) {
            Colaborador colab = list.get(incrementoColaboradores);
            getIncrement();
            List<Atividade> listaTarefasPendentes = pedidoRepository.getListaTarefasPendentes(colab.identity());
            for (Atividade atividadeList : listaTarefasPendentes) {
                CodigoUnico codigo = new CodigoUnico(atividadeList.identity().toString());
                if (atividadeList.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                    tempoMedioTotal += servicoRepository.tempoMedioAprovacao(codigo);
                } else {
                    tempoMedioTotal += servicoRepository.tempoMedioResolucao(codigo);
                }
            }

            mapColaboradores.put(colab,tempoMedioTotal);
        }
    }

    private synchronized void getIncrement(){
        incrementoColaboradores++;
    }

    public void createThreads() {
        Thread[] threads = new Thread[list.size()];
        for (int i = 0; i < list.size(); i++) {
            threads[i] = new Thread(this, "Thread" + i + " do algoritmo tempo medio");
            threads[i].start();
        }
        for(Thread t : threads){
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Colaborador getColaboradorEscolhido(){
        this.mapColaboradores=sortByValue(mapColaboradores);
        Colaborador[] c = new Colaborador[mapColaboradores.size()];
        mapColaboradores.values().toArray(c);
        return c[0];
    }

    public static Map<Colaborador, Double> sortByValue(Map<Colaborador, Double> unsortMap) {
        LinkedList<Map.Entry<Colaborador, Double>> list
                = new LinkedList<Map.Entry<Colaborador, Double>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Colaborador, Double>>() {
            @Override
            public int compare(Map.Entry<Colaborador, Double> o1,
                               Map.Entry<Colaborador, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<Colaborador, Double> sortedMap = new LinkedHashMap<Colaborador, Double>();
        for (Map.Entry<Colaborador, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
