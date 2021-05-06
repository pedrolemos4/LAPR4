package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.domain.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.base.usermanagement.domain.Utilizador;
import eapli.framework.application.UseCaseController;

import java.util.ArrayList;
import java.util.List;

@UseCaseController
public class CriarEquipaController {

    private final EquipaRepository repo = PersistenceContext.repositories().equipas();

    public Equipa novaEquipa(String cod, String acronimo, String desig, TipoEquipa tipo, Colaborador responsavel){
        final Equipa novaEquipa = new Equipa(new CodigoUnico(cod), new Acronimo(acronimo), new Designacao(desig), tipo, responsavel);
        return this.repo.save(novaEquipa);
    }

    public List<TipoEquipa> listTipos(){
        final List<TipoEquipa> lt = new ArrayList<>();
        return lt;
    }

    public List<Utilizador> listUser(){
        final List<Utilizador> lu = new ArrayList<>();
        return lu;
    }
}
