package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


@UseCaseController
public class EspecificarServicoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServicoRepository repository = PersistenceContext.repositories().servicos();

    public Servico especificarServico(final String codigoUnico, final String titulo, final String descricaoBreve,
                                      final String descricaoCompleta) {
        final Servico servico = new Servico.ServicoBuilder(codigoUnico,titulo)
                .withDescricaoBreve(descricaoBreve)
                .withDescricaoCompleta(descricaoCompleta)
                .build();
        return this.repository.save(servico);
    }

}
