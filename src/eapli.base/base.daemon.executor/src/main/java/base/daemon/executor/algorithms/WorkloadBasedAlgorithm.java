package base.daemon.executor.algorithms;

import base.daemon.executor.presentation.ExecutorServer;
import eapli.base.atividade.domain.Atividade;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.repositories.PedidoRepository;

import java.util.*;

public class WorkloadBasedAlgorithm {

    private static Queue<ExecutorServer> instances;
    private static final PedidoRepository repository = PersistenceContext.repositories().pedidos();
    private static final Map<ExecutorServer, Double> mapExecutores = new HashMap<>();

    public static ExecutorServer proximaInstancia() {

        for (ExecutorServer s : instances) {
            double tempo = 0.0;
            for (Atividade a : s.tarefas()) {
                tempo += repository.getTempoDeExecucaoTarefa(a);
            }
            if (!mapExecutores.containsKey(s)) {
                mapExecutores.put(s, tempo);
            }
        }

        entriesSortedByValues(mapExecutores);

        Map.Entry<ExecutorServer,Double> entry = mapExecutores.entrySet().iterator().next();

        return entry.getKey();
    }

    public boolean addInstance(ExecutorServer executorServer) {
        return this.instances.add(executorServer);
    }

    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>((e1, e2) -> {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}

