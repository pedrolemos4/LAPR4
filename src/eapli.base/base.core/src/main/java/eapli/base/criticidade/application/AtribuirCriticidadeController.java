package eapli.base.criticidade.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.domain.Objetivo;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

@UseCaseController
public class AtribuirCriticidadeController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidade();

    public Iterable<Catalogo> listCatalogos(){
        final Iterable<Catalogo> lc = catalogoRepository.findAll();
        return lc;
    }

    public Iterable<Criticidade> getCriticidades(){
        return this.criticidadeRepository.findAll();
    }

    public void associarObjetivo(double tempoMaximoAprov, double tempoMedioAprov,double tempoMaximoRes, double tempoMedioRes,
                                 Catalogo catalogo){
        Objetivo objetivo = new Objetivo(tempoMaximoAprov, tempoMedioAprov,tempoMaximoRes,tempoMedioRes);
        catalogo.associarObjetivo(objetivo);
    }

    public void saveCatalogo(Catalogo catalogo){
        this.catalogoRepository.save(catalogo);
    }
}
