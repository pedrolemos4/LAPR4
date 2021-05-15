package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.criticidade.domain.*;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.equipa.domain.Designacao;
import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CriticidadeBootstrapperBase implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    private final CriticidadeRepository repo = PersistenceContext.repositories().criticidade();

    @Override
    public boolean execute() {
        //Criticidade 1
        registarCriticidade(new Etiqueta("LOWEST"), new Escala(1),new Designacao("Lowest"),
                new Objetivo(180,120,1440,600),new Cor(3,252,128));
        System.out.println("c2");
        registarCriticidade(new Etiqueta("LOW"), new Escala(2),new Designacao("Low"),
                new Objetivo(120,90,720,480),new Cor(3,252,28));
        System.out.println("c3");
        registarCriticidade(new Etiqueta("INTERMEDIATE"), new Escala(3),new Designacao("Intermediate"),
                new Objetivo(90,60,360,240),new Cor(235, 252, 3));
        System.out.println("c4");
        registarCriticidade(new Etiqueta("HIGH"), new Escala(4),new Designacao("High"),
                new Objetivo(30,20,240,150),new Cor(252, 144, 3));
        System.out.println("c5");
        registarCriticidade(new Etiqueta("HIGHEST"), new Escala(5),new Designacao("Highest"),
                new Objetivo(20,10,120,60),new Cor(252, 3, 3));
        return true;
    }

    /**
     * US 2105 - LEANDRO SOUSA 1190800
     * -----------------------------------------------------------------------------------------------
     * Como Gestor de Projeto, eu pretendo que o sistema contemple a possibilidade de ser inicializado com um conjunto
     * de níveis de criticidade e respetivos objetivos aplicados pela organização e a atribuição de alguns desses
     * níveis a catálogos de serviços.
     */
    private void registarCriticidade(final Etiqueta etiqueta, final Escala escala, final Designacao designacao,
                                     final Objetivo objetivo, final Cor cor){
        Criticidade c = new Criticidade(etiqueta,escala,designacao,objetivo,cor);
        try {
            repo.save(c);
        }catch (ConcurrencyException | IntegrityViolationException exception){
            LOGGER.warn("Error saving " + c.toString() );
            LOGGER.trace("Assuming existing record", exception);
        }
    }

}
