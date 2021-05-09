package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.ContratoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.CriticidadeRepository;
import eapli.base.gestaoservicosrh.domain.Designacao;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.awt.*;
import java.time.Clock;
import java.util.Set;

@UseCaseController
public class DefinirCriticidadeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private CriticidadeRepository criticidadeRepo = PersistenceContext.repositories().criticidade();
    private ContratoRepository contRepo = PersistenceContext.repositories().contrato();

    
    public Criticidade defineCriticidade(int tempoMaximo, int tempoMedio, String etiqueta, int escala,
                                         Color cor , String designacao){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO);
        Objetivo objetivo = new Objetivo(tempoMaximo, tempoMedio);
        Etiqueta e = new Etiqueta(etiqueta);
        Escala esc = new Escala(escala);
        Cor c = new Cor(cor.getRed(),cor.getGreen(),cor.getBlue()/*red, green, blue*/);
        Designacao desig = new Designacao(designacao);

        final Criticidade criticidade = new Criticidade(e, esc, desig, objetivo, c);
        return criticidadeRepo.save(criticidade);
    }

    public ContratoSLA defineContrato(String designacao){
        Iterable<Criticidade> list =  criticidadeRepo.findAll();
        Designacao design = new Designacao(designacao);
        final ContratoSLA contrato = new ContratoSLA(design, list);
        return contRepo.save(contrato);
    }


}
