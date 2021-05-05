package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.domain.Colaborador;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class CriarEquipaController {

    private final EquipaRepository repo = PersistenceContext.repositories().equipas();

    public Equipa novaEquipa(String nome, List<Colaborador> lc, TipoEquipa te){
        final Equipa novaEquipa = new Equipa(nome, lc, te);
        return this.repo.save(novaEquipa);
    }
}
