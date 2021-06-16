package eapli.base.atividade.application;

import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.Comentario;
import eapli.base.atividade.domain.Decisao;
import eapli.base.atividade.domain.EstadoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.formulario.domain.*;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.validacoes.validaFormulario.ValidaForm;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.File;
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
        return this.pRepo.getListaTarefasPendentes(identity, EstadoAtividade.PENDENTE, EstadoPedido.CONCLUIDO);
    }

    public Pedido getPedidoByTarefa(Atividade at) {
        return this.pRepo.getPedidoByTarefa(at.identity());
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

    public boolean validaFormulario(File file) {
        ValidaForm valida = new ValidaForm();
        return valida.validaForm(file);
    }

    public void completaDecisaoComentario(String comentario, Decisao aprovado, Pedido pedido, Atividade at, EstadoPedido estado, EstadoAtividade estadoA) {
        pedido.completaDecisaoComentario(Comentario.valueOf(comentario), aprovado, at, estado, estadoA);
    }

    public void savePedido(Pedido pedido) {
        this.pRepo.save(pedido);
    }

    public void replaceFormularioAtividade(Pedido pedido, Atividade at, Formulario formFinal) {
        pedido.replaceFormularioAtividade(at, formFinal);
    }

    public TipoDados tipoDados(Atributo a) {
        return a.tipoDados();
    }

    public Obrigatoriedade obrigatoriedade(Atributo a) {
        return a.obrigatoriedade();
    }

    public String descricaoAjuda(Atributo a){
        return a.descricaoAjuda().toString();
    }

    public Atributo createAtributo(String nomeVariavel, Label label, TipoDados tipoDados, Obrigatoriedade obrigatoriedade,
                                   String descAjuda, Formulario formulario) {
        final Atributo atributo = new Atributo(new Variavel(nomeVariavel), label, tipoDados, obrigatoriedade,
                new DescricaoAjuda(descAjuda), formulario);
        return atributo;
    }

    public void saveFormulario(Formulario formFinal) {
        this.formRepo.save(formFinal);
    }

    public void deleteFormulario(Formulario formFinal) {
        this.formRepo.delete(formFinal);
    }

}
