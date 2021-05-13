package eapli.base.tipoequipa.application;

import eapli.base.criticidade.domain.Cor;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Designacao;
import eapli.base.tipoequipa.domain.TipoEquipa;
import eapli.base.tipoequipa.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.awt.*;

@UseCaseController
public class RegistarTipoEquipaController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TipoEquipaRepository repository = PersistenceContext.repositories().tiposEquipa();

    public TipoEquipa registarTipoEquipa(final String codigoUnico, final String descricao,
                                         Color c){
        //authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
          //      CafeteriaRoles.MENU_MANAGER);
        final CodigoUnico codigoUnico1 = new CodigoUnico(codigoUnico);
        final Designacao designation = new Designacao(descricao);
        final Cor cor = new Cor(c.getRed(),c.getGreen(),c.getBlue());
        final TipoEquipa newTipoEquipa = new TipoEquipa(codigoUnico1,designation,cor);
        return this.repository.save(newTipoEquipa);
    }

    public TipoEquipa registarAlt(TipoEquipa tipoEquipa){
        return this.repository.save(tipoEquipa);
    }

}
