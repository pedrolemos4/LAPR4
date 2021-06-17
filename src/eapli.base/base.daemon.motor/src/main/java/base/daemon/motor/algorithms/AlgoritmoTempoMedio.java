package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.atividade.domain.TipoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
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

    private Map<Double, Colaborador> mapColaboradores;

    public AlgoritmoTempoMedio(List<Colaborador> list, Atividade atividade, CodigoUnico identity) {
        this.list = list;
        this.atividade = atividade;
        this.identity = identity;
        this.mapColaboradores = new TreeMap<>();
    }

    @Override
    public void run() {

        
        synchronized (this) {
			double tempoMedioTotal = 0;
			if (atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
				tempoMedioTotal += servicoRepository.tempoMedioAprovacao(identity);
			} else {
				tempoMedioTotal += servicoRepository.tempoMedioResolucao(identity);
			}
			System.out.println("\n\n\n\n\n\n\nIncremento: "+incrementoColaboradores);
            Colaborador colab = list.get(incrementoColaboradores);
			System.out.println("Colaborador: "+colab.toString()+"\n\n\n\n\n\n\n");
            getIncrement();
            List<Atividade> listaTarefasPendentes = pedidoRepository.getListaTarefasPendentes(colab, EstadoAtividade.PENDENTE, EstadoPedido.CONCLUIDO);
            for (Atividade atividadeList : listaTarefasPendentes) {
                if (atividadeList.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                    tempoMedioTotal += servicoRepository.tempoMedioAprovacao(identity);
                } else {
                    tempoMedioTotal += servicoRepository.tempoMedioResolucao(identity);
                }
            }

            mapColaboradores.put(tempoMedioTotal,colab);
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
        Map.Entry<Double, Colaborador> entry = mapColaboradores.entrySet().iterator().next();
		for(Double e : mapColaboradores.keySet()){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n Colaborador: "+e+" Valor: "+mapColaboradores.get(e).toString()+"\n\n\n\n\n\n\n\n\n\n\n");
		}
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n Colaborador: "+entry.getKey()+" Valor: "+entry.getValue()+"\n\n\n\n\n\n\n\n\n\n\n");
        return entry.getValue();
    }

   /* public static Map<Colaborador, Double> sortByValue(Map<Colaborador, Double> unsortMap) {
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
    }*/

}
