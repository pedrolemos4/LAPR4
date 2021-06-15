package eapli.base.atividade.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.Comentario;
import eapli.base.atividade.domain.Decisao;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Label;
import eapli.base.formulario.domain.Variavel;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.validacoes.validaFormulario.ValidaForm;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

@UseCaseController
public class RealizarTarefaController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private ColaboradorRepository colabRepo= PersistenceContext.repositories().colaborador();
    private FormularioRepository formRepo= PersistenceContext.repositories().formularios();
    private PedidoRepository pRepo= PersistenceContext.repositories().pedidos();

    private SystemUser currentUser() {
        return authz.session().get().authenticatedUser();
    }

    public Colaborador getUser(){
        final SystemUser user = currentUser();
        EmailAddress email = user.email();
        return this.colabRepo.findEmailColaborador(email);
    }

    public List<Atividade> getListaTarefasPendentes(Colaborador identity) {
        return this.pRepo.findTarefasServico(identity, EstadoAtividade.PENDENTE);
    }

    public Pedido getPedidoByAtividade(Atividade at) {
        return this.pRepo.getPedidoByAtividade(at.identity());
    }

    public Formulario getFormularioDaAtividade(Atividade at) {
        return this.pRepo.getFormularioDaAtividade(at.identity());
    }

    public List<Atributo> getAtributosDoFormulario(Formulario form) {
        return this.formRepo.findAtributos(form.identity());
    }

    public Label getLabelDoAtributo(Atributo atributo) {
        return this.formRepo.getLabelDoAtributo(atributo.identity());
    }

    public void completaForm(Formulario form, Variavel valueOf, Atributo atributo) {
        form.completaFormulario(valueOf, atributo);
    }

    public boolean validaFormulario(File file) {
        ValidaForm valida = new ValidaForm();
        return valida.validaForm(file);
    }

    public void completaDecisaoComentario(String comentario, Decisao aprovado, Pedido pedido, Atividade at) {
        pedido.completaDecisaoComentario(Comentario.valueOf(comentario), aprovado, at);
    }

    public void savePedido(Pedido pedido) {
        this.pRepo.save(pedido);
    }

    public void replaceFormulario(Pedido pedido, Atividade at, Formulario formFinal) {
        pedido.replaceFormulario(at, formFinal);
    }
}
