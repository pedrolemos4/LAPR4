package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.catalogo.application.NovoCatalogoController;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.criticidade.application.AssociarCriticidadeCatalogoController;
import eapli.base.criticidade.domain.*;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.equipa.domain.Acronimo;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CriticidadeBootstrapperBase implements Action {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();

    private final AssociarCriticidadeCatalogoController controller = new AssociarCriticidadeCatalogoController();

    @Override
    public boolean execute() {
        registarCriticidade(new Etiqueta("LOWEST"), new Escala(1),new Designacao("Lowest"),
                new Objetivo(180,120,1440,600),new Cor(3,252,128));
        registarCriticidade(new Etiqueta("LOW"), new Escala(2),new Designacao("Low"),
                new Objetivo(120,90,720,480),new Cor(3,252,28));
        registarCriticidade(new Etiqueta("INTERMEDIATE"), new Escala(3),new Designacao("Intermediate"),
                new Objetivo(90,60,360,240),new Cor(235, 252, 3));
        registarCriticidade(new Etiqueta("HIGH"), new Escala(4),new Designacao("High"),
                new Objetivo(30,20,240,150),new Cor(252, 144, 3));
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
        controller.saveCriticidade(c);
    }

}
