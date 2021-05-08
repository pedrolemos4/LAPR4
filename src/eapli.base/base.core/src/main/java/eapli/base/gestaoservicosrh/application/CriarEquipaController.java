package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.domain.*;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.application.UseCaseController;

import java.util.Set;

@UseCaseController
public class CriarEquipaController {

    private final EquipaRepository repo = PersistenceContext.repositories().equipas();
    private final TipoEquipaRepository repo2 = PersistenceContext.repositories().tiposEquipa();
    private final ColaboradorRepository repo3 = PersistenceContext.repositories().colaborador();

    public Equipa novaEquipa(String cod, String acronimo, String desig, TipoEquipa tipo, Set<Colaborador> responsaveis){
        for (Equipa eq : repo.findAll()) {
            for (Colaborador colab : eq.listMembros()){
                if (responsaveis.contains(colab) && eq.getTipo().equals(tipo)){
                    throw new IllegalArgumentException("O colaborador selecionado ja existe numa equipa com este tipo!");
                }
            }
        }
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
