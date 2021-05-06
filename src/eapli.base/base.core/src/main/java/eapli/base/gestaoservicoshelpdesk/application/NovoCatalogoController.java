package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;

import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Colaborador;

import java.util.List;

public class NovoCatalogoController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    //private final UtilizadorRepository utilizadorRepository = PersistenceContext.repositories().utilizador();
    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipas();

    public void novoCatalogo(final String titulo, final String descricaoBreve, final String icone,
                             final String descricaoCompleta, Iterable<Equipa> listEquipas, Colaborador colab){
        final Titulo titulo1 = new Titulo(titulo);
        final DescricaoBreve descBreve = new DescricaoBreve(descricaoBreve);
        final DescricaoCompleta descCompleta = new DescricaoCompleta(descricaoCompleta);
        final Icone icone1 = new Icone(icone);
        final Catalogo catalogo = new Catalogo(colab,descCompleta, descBreve, icone1, listEquipas);
        this.catalogoRepository.save(catalogo);
    }

    public Iterable<Equipa> getEquipas(){
        return this.equipaRepository.findAll();
    }

    public Iterable<Colaborador> getListaColaboradores(){
        return null;
        //return this.utilizadorRepository.findColaboradores();
    }
}
