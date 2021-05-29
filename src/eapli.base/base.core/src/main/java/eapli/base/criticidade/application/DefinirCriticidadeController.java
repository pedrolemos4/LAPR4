package eapli.base.criticidade.application;

import eapli.base.contrato.domain.ContratoSLA;
import eapli.base.contrato.repositories.ContratoRepository;
import eapli.base.criticidade.domain.*;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.equipa.domain.Designacao;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.awt.*;

@UseCaseController
public class DefinirCriticidadeController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private CriticidadeRepository criticidadeRepo = PersistenceContext.repositories().criticidade();
    private ContratoRepository contRepo = PersistenceContext.repositories().contrato();

    
    public Criticidade defineCriticidade(double tempoMaximoAprov, double tempoMedioAprov,double tempoMaximoRes, double tempoMedioRes, String etiqueta, int escala,
                                         Color cor , String designacao){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.GESTOR_SERVICO);
        Objetivo objetivo = new Objetivo(tempoMaximoAprov, tempoMedioAprov,tempoMaximoRes,tempoMedioRes);
        Etiqueta e = new Etiqueta(etiqueta);
        Escala esc = new Escala(escala);
        Cor c = new Cor(cor.getRed(),cor.getGreen(),cor.getBlue());
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

    public void registarCriticidade(Etiqueta etiqueta, Escala escala, Designacao designacao, Objetivo objetivo, Cor cor) {
        Criticidade c = new Criticidade(etiqueta,escala,designacao,objetivo,cor);
        criticidadeRepo.save(c);
    }
}
