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
import java.util.Calendar;
import java.util.List;

@UseCaseController
public class RealizarTarefaController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private ColaboradorRepository colabRepo = PersistenceContext.repositories().colaborador();
    private FormularioRepository formRepo = PersistenceContext.repositories().formularios();
    private PedidoRepository pRepo = PersistenceContext.repositories().pedidos();

    private SystemUser currentUser() {
        return authz.session().get().authenticatedUser();
    }

    public Colaborador getUser() {
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

    public boolean validaFormularioVisitor(File file) {
        ValidaForm valida = new ValidaForm();
        return valida.validaFormVisitor(file);
    }

    public boolean validaFormularioListener(File file) {
        ValidaForm valida = new ValidaForm();
        boolean flag = true;
        try {
            flag = valida.validaFormListener(file);
        } catch (Exception e) {
            System.out.println("Erro de validação do formulário.");
        }
        return flag;
    }

    public void completaDecisaoComentario(String comentario, Decisao aprovado, Pedido pedido,
                                          Atividade at, EstadoPedido estado, EstadoAtividade estadoA,
                                          long duracao, Calendar dataResolucao) {
        pedido.completaDecisaoComentario(Comentario.valueOf(comentario), aprovado, at, estado, estadoA, duracao, dataResolucao);
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

    public ExpressaoRegular expressaoRegular(Atributo a) {
        return a.expressaoRegular();
    }

    public DescricaoAjuda descricaoAjuda(Atributo a) {
        return a.descricaoAjuda();
    }

    public Atributo createAtributo(String nomeVariavel, Label label, TipoDados tipoDados, Obrigatoriedade obrigatoriedade,
                                   DescricaoAjuda descAjuda, ExpressaoRegular expressao,Formulario formulario) {
        final Atributo atributo = new Atributo(new Variavel(nomeVariavel), label, tipoDados, obrigatoriedade,
                        descAjuda, expressao, formulario);
        return atributo;
    }

    public ExpressaoRegular getExpressaoRegularDoAtributo(Atributo atr) {
        return this.formRepo.getExpressaoRegularDoAtributo(atr.identity());
    }

    public Variavel getVariavelDoAtributo(Atributo atributo) {
        return this.formRepo.getVariavelDoAtributo(atributo.identity());
    }

    public List<ExpressaoRegular> getListaExpressaoRegularDoFormulario(Formulario formFinal) {
        return this.formRepo.getListaExpressaoRegularDoFormulario(formFinal.identity());
    }
}
