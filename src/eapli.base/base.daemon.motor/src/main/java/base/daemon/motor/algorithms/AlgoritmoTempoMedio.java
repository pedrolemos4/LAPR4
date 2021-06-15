package base.daemon.motor.algorithms;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.TipoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.repositories.ServicoRepository;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class AlgoritmoTempoMedio implements Runnable {

    private Colaborador colaborador;

    private Atividade atividade;

    private CodigoUnico identity;

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();

    private Map<Colaborador, Double> mapColaboradores = new TreeMap<>();

    public AlgoritmoTempoMedio(Colaborador colaborador, Atividade atividade, CodigoUnico identity) {
        this.colaborador = colaborador;
        this.atividade = atividade;
        this.identity = identity;
    }

    @Override
    public void run() {
        //while(!Thread.interrupted()){
        addColabToMap();

        new ValueComparator(this.mapColaboradores);
        //}
    }

    private synchronized void addColabToMap() {
        double tempoMedio;
        if (this.atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
            tempoMedio = this.servicoRepository.tempoMedioAprovacao(this.identity);
        } else {
            tempoMedio = this.servicoRepository.tempoMedioResolucao(this.identity);
        }
        this.mapColaboradores.put(this.colaborador, tempoMedio);
    }
}

class ValueComparator implements Comparator<Colaborador> {
    Map<Colaborador, Double> base;

    public ValueComparator(Map<Colaborador, Double> base) {
        this.base = base;
    }

    public int compare(Colaborador a, Colaborador b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
