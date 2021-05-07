package eapli.base.gestaoservicoshelpdesk.application;

import eapli.base.gestaoservicoshelpdesk.domain.Atributo;
import eapli.base.gestaoservicoshelpdesk.domain.DraftServico;
import eapli.base.gestaoservicoshelpdesk.domain.Formulario;
import eapli.base.gestaoservicoshelpdesk.domain.Servico;
import eapli.base.gestaoservicoshelpdesk.repositories.DraftServicoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.FormularioRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.hibernate.mapping.Formula;

import java.util.Set;


@UseCaseController
public class EspecificarServicoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formularios();
    private final DraftServicoRepository draftServicoRepository = PersistenceContext.repositories().drafts();

    public void especificarServico(final String codigoUnico, final String titulo, final String descricaoBreve,
                                   final String descricaoCompleta,final String tituloFormulario, Set<Atributo> listaAtributos) {
        if (descricaoBreve == null || descricaoCompleta == null) {
            DraftServico draftServico = new DraftServico(codigoUnico, descricaoBreve, descricaoCompleta, titulo,
                    tituloFormulario,listaAtributos);
            this.draftServicoRepository.save(draftServico);
        } else {
            final Formulario formulario = new Formulario(tituloFormulario,listaAtributos);
            formularioRepository.save(formulario);
            final Servico servico = new Servico.ServicoBuilder(codigoUnico, titulo)
                    .withDescricaoBreve(descricaoBreve)
                    .withDescricaoCompleta(descricaoCompleta)
                    .withFormulario(tituloFormulario,listaAtributos)
                    .build();
            servico.makeUnavailable();
            this.servicoRepository.save(servico);
        }
    }

    public Atributo createAtributo(String nomeVariavel, String label){
        final Atributo atributo = new Atributo(nomeVariavel,label);
        return atributo;
    }

}
