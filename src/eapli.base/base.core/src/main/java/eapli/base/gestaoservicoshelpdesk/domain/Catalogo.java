package eapli.base.gestaoservicoshelpdesk.domain;

import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Catalogo implements AggregateRoot<Identificador>{

    @Id
    @GeneratedValue
    private Identificador identificador;

    @Column(name = "DESCCOMP")
    private DescricaoCompleta descricaoCompleta;

    @Column(name = "DESCBRE")
    private DescricaoBreve descricaoBreve;

    @Column(name = "ICONE")
    private Icone icone;

    @Column(name = "LIST")
    private List<Equipa> listEquipas;

    public Catalogo(DescricaoCompleta descricaoCompleta, DescricaoBreve descricaoBreve,
                    Icone icone, List<Equipa> listEquipas){
        this.descricaoBreve=descricaoBreve;
        this.descricaoBreve=descricaoBreve;
        this.icone=icone;
        this.listEquipas = new ArrayList<Equipa>(listEquipas);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Identificador identity() {
        return null;
    }
}
