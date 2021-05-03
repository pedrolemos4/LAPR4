package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.domain.TipoEquipa;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.awt.*;

@UseCaseController
public class RegistarTipoEquipaController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TipoEquipaRepository repository = PersistenceContext.repositories().tiposEquipa();

    public TipoEquipa registarTipoEquipa(final String codigoUnico, final String descricao, final String cor /* ???*/){
        //authz.ensureAuthenticatedUserHasAnyOf(CafeteriaRoles.POWER_USER,
          //      CafeteriaRoles.MENU_MANAGER);
        //final CodigoUnico codigoUnico1 = new CodigoUnico(codigoUnico);
        //final Designation designation = new Designation(descricao); diz que é protected???
        //final Cor cor = new Cor(cor);
        final TipoEquipa newTipoEquipa = new TipoEquipa();
        return this.repository.save(newTipoEquipa);
    }

}
