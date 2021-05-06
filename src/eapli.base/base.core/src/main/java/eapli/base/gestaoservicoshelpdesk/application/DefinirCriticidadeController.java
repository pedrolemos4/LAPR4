package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.CriticidadeRepository;
import eapli.base.gestaoservicosrh.domain.Designacao;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Set;

@UseCaseController
public class DefinirCriticidadeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CatalogoRepository catRepo = PersistenceContext.repositories().catalogo();
    private final CriticidadeRepository criticidadeRepo = PersistenceContext.repositories().criticidade();


    public Criticidade defineCriticidade(int tempoMaximo, int tempoMedio, String etiqueta, int escala,
                                  int red, int green, int blue, String designacao){
        Objetivo objetivo = new Objetivo(tempoMaximo, tempoMedio);
        Etiqueta e = new Etiqueta(etiqueta);
        Escala esc = new Escala(escala);
        Cor c = new Cor(red, green, blue);
        Designacao desig = new Designacao(designacao);

        final Criticidade criticidade = new Criticidade(e, esc, desig, objetivo, c);
        return criticidadeRepo.save(criticidade);
    }

    /*public ContratoSLA defineContrato(String designacao){
        Set<Criticidade> list = (Set<Criticidade>) criticidadeRepo.findAll();
        Designacao design = new Designacao(designacao);
        final ContratoSLA contrato = new ContratoSLA(design, list);
        return catRepo.save(contrato);
    }*/


}