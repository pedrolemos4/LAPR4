package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.*;
import eapli.base.catalogo.repositories.CatalogoRepository;

import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.equipa.domain.Equipa;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class NovoCatalogoController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();
    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidade();

    public void novoCatalogo(final String titulo, final String descricaoBreve, final String icone,
                                 final String descricaoCompleta, Iterable<Equipa> listEquipas, Colaborador colab, Criticidade crit){
        final Titulo titulo1 = new Titulo(titulo);
        final DescricaoBreve descBreve = new DescricaoBreve(descricaoBreve);
        final DescricaoCompletaCatalogo descCompleta = new DescricaoCompletaCatalogo(descricaoCompleta);
        final Icone icone1 = new Icone(icone);

        Catalogo catalogo = new Catalogo(titulo1, colab, descCompleta, descBreve, icone1, listEquipas, crit);

        this.catalogoRepository.save(catalogo);
    }

    public Iterable<Equipa> getEquipas(){
        return this.equipaRepository.findAll();
    }

    public Iterable<Colaborador> getListaColaboradores(){
        return this.colaboradorRepository.findAll();
    }
}
