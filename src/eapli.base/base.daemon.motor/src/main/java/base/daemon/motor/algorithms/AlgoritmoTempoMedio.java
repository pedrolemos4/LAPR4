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

    private Map<Double, Colaborador> mapColaboradores;

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
            tempoMedioTotal += tempoMedioAprovacao();
        } else {
            tempoMedioTotal += tempoMedioResolucao();
        }

        String[] threadName = Thread.currentThread().getName().split(" - ");
        int index = Integer.parseInt(threadName[1].replaceAll("\\s+", ""));

        Colaborador colab = list.get(index);
        System.out.println("Colaborador: " + colab.toString() + "\n\n\n\n\n\n\n");
        List<Atividade> listaTarefasPendentes = getListaTarefasPendentes(colab);
        for (Atividade atividadeList : listaTarefasPendentes) {
            if (atividadeList.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                tempoMedioTotal += tempoMedioAprovacao();
            } else {
                tempoMedioTotal += tempoMedioResolucao();
            }
        }
        mapColaboradores.put(tempoMedioTotal, colab);
    }

    private synchronized List<Atividade> getListaTarefasPendentes(Colaborador colab) {
        return pedidoRepository.getListaTarefasPendentes(colab, EstadoAtividade.PENDENTE, EstadoPedido.CONCLUIDO);
    }

    private synchronized double tempoMedioAprovacao() {
        return servicoRepository.tempoMedioAprovacao(identity);
    }

    private synchronized double tempoMedioResolucao() {
        return servicoRepository.tempoMedioResolucao(identity);
    }

    public void createThreads() {
        Thread[] threads = new Thread[list.size()];
        for (int i = 0; i < list.size(); i++) {
            threads[i] = new Thread(this, "Thread -" + i + "- do algoritmo tempo medio");
            threads[i].start();
        }
        for (Thread t : threads) {
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Colaborador getColaboradorEscolhido() {
        Map.Entry<Double, Colaborador> entry = mapColaboradores.entrySet().iterator().next();
        for (Double e : mapColaboradores.keySet()) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n Colaborador: " + e + " Valor: " + mapColaboradores.get(e).toString() + "\n\n\n\n\n\n\n\n\n\n\n");
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n Colaborador: " + entry.getKey() + " Valor: " + entry.getValue() + "\n\n\n\n\n\n\n\n\n\n\n");
        return entry.getValue();
    }

}
