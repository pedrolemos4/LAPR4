package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicoshelpdesk.domain.Cor;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Designacao;
import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
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
                                         int red, int green, int blue){
        //authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
          //      CafeteriaRoles.MENU_MANAGER);
        final CodigoUnico codigoUnico1 = new CodigoUnico(codigoUnico);
        final Designacao designation = new Designacao(descricao);
        final Cor cor = new Cor(red,green,blue);
        final TipoEquipa newTipoEquipa = new TipoEquipa(codigoUnico1,designation,cor);
        return this.repository.save(newTipoEquipa);
    }

    public TipoEquipa registarAlt(TipoEquipa tipoEquipa){
        return this.repository.save(tipoEquipa);
    }

}
