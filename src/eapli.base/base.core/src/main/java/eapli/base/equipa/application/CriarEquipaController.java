package eapli.base.equipa.application;

import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.tipoequipa.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.application.UseCaseController;

import java.util.Set;

@UseCaseController
public class CriarEquipaController {

    private final EquipaRepository repo = PersistenceContext.repositories().equipas();
    private final TipoEquipaRepository repo2 = PersistenceContext.repositories().tiposEquipa();
    private final ColaboradorRepository repo3 = PersistenceContext.repositories().colaborador();

    public Equipa novaEquipa(String cod, String acronimo, String desig, TipoEquipa tipo, Set<Colaborador> responsaveis){
        final Equipa novaEquipa = new Equipa(new CodigoUnico(cod), new Acronimo(acronimo), new Designacao(desig), tipo, responsaveis);
        return this.repo.save(novaEquipa);
    }

    public Iterable<TipoEquipa> listTipos(){
        final Iterable<TipoEquipa> lt = repo2.findAll();
        return lt;
    }

    public Iterable<Colaborador> listColab(){
        final Iterable<Colaborador> lc = repo3.findAll();
        return lc;
    }

}
