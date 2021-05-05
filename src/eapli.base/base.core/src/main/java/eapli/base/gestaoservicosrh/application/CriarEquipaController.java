package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.framework.application.UseCaseController;

import java.util.List;

@UseCaseController
public class CriarEquipaController {

    private final EquipaRepository repo = PersistenceContext.repositories().equipas();

    public Equipa novaEquipa(CodigoUnico cod, Acronimo acronimo, Designacao desig, TipoEquipa tipo){
        final Equipa novaEquipa = new Equipa(cod, acronimo, desig, tipo);
        return this.repo.save(novaEquipa);
    }
}
