package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.gestaoservicoshelpdesk.domain.DraftServico;
import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.gestaoservicoshelpdesk.repositories.DraftServicoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


@UseCaseController
public class EspecificarServicoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final DraftServicoRepository draftServicoRepository = PersistenceContext.repositories().drafts();

    public void especificarServico(final String codigoUnico, final String titulo, final String descricaoBreve,
                                   final String descricaoCompleta) {
        if (descricaoBreve == null || descricaoCompleta == null) {
            DraftServico draftServico = new DraftServico(codigoUnico, descricaoBreve, descricaoCompleta, titulo);
            this.draftServicoRepository.save(draftServico);
        } else {
            final Servico servico = new Servico.ServicoBuilder(codigoUnico, titulo)
                    .withDescricaoBreve(descricaoBreve)
                    .withDescricaoCompleta(descricaoCompleta)
                    .build();
            servico.makeUnavailable();
            this.servicoRepository.save(servico);
        }
    }

}
