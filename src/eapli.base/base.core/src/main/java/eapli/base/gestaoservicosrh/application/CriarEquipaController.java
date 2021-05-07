package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.domain.*;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

@UseCaseController
public class CriarEquipaController {

    private final EquipaRepository repo = PersistenceContext.repositories().equipas();
    private final TipoEquipaRepository repo2 = PersistenceContext.repositories().tiposEquipa();
    private final UserRepository repo3 = PersistenceContext.repositories().users();

    public Equipa novaEquipa(String cod, String acronimo, String desig, TipoEquipa tipo, Colaborador responsavel){
        final Equipa novaEquipa = new Equipa(new CodigoUnico(cod), new Acronimo(acronimo), new Designacao(desig), tipo, responsavel);
        return this.repo.save(novaEquipa);
    }

    public Iterable<TipoEquipa> listTipos(){
        final Iterable<TipoEquipa> lt = repo2.findAll();
        return lt;
    }

    public Iterable<SystemUser> listUser(){
        final Iterable<SystemUser> lu = repo3.findAll();
        return lu;
    }
}
