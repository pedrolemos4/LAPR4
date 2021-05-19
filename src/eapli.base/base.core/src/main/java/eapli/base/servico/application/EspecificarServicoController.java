package eapli.base.servico.application;

import eapli.base.atividades.domain.*;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.domain.Data;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.draft.domain.DraftServico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.draft.repositories.DraftServicoRepository;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Set;


@UseCaseController
public class EspecificarServicoController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formularios();
    private final DraftServicoRepository draftServicoRepository = PersistenceContext.repositories().drafts();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();

    public void especificarServico(final String codigoUnico, final String titulo, final String descricaoBreve,
                                   final String descricaoCompleta, Formulario formulario, Set<String> keywords, Catalogo catalogo) {
        final Servico servico = new Servico.ServicoBuilder(codigoUnico, titulo)
                .withDescricaoBreve(descricaoBreve)
                .withDescricaoCompleta(descricaoCompleta)
                .withFormulario(formulario)
                .withKeywords(keywords)
                .withCatalogo(catalogo)
                .build();
        servico.makeUnavailable();
        this.servicoRepository.save(servico);
    }

    public Formulario createFormulario(final String titulo, Set<Atributo> listaAtributos){
        final Formulario formulario = new Formulario(titulo, listaAtributos);
        //System.out.println(formulario.toString());
        this.formularioRepository.save(formulario);
        return formulario;
    }

    public void createDraftServico(final String codigoUnico, final String descricaoBreve,
                                   final String descricaoCompleta,final String titulo,  final String tituloFormulario,
                                   Set<Atributo> listaAtributos,Set<String> keywords,Catalogo catalogo) {
        DraftServico draftServico = new DraftServico(codigoUnico, descricaoBreve, descricaoCompleta, titulo,
                tituloFormulario, listaAtributos, keywords,catalogo);
        this.draftServicoRepository.save(draftServico);
    }

    public void removeDraft(DraftServico draftServico){
        this.draftServicoRepository.delete(draftServico);
    }

    public Atributo createAtributo(String nomeVariavel, String label) {
        final Atributo atributo = new Atributo(nomeVariavel, label);
        return atributo;
    }

    public Iterable<Servico> listServicos(){
        final Iterable<Servico> ls = servicoRepository.findAll();
        return ls;
    }

    public Iterable<DraftServico> listDrafts(){
        final Iterable<DraftServico> ld = draftServicoRepository.findAll();
        return ld;
    }

    public Iterable<Catalogo> listCatalogos(){
        final Iterable<Catalogo> lc = catalogoRepository.findAll();
        return lc;
    }

    public AtividadeAprovacao novaAtividadeAprovacaoManualEquipa(final Criticidade c, final String prior, final int ano,
                                                           final int mes, final int dia, final EstadoAtividade e, final Equipa equipa,
                                                           final String descisao, final String comentario){
        final Prioridade p = new Prioridade(prior);
        final Data dataL = new Data(ano,mes,dia);
        final Decisao des = new Decisao(descisao);
        final Comentario com = new Comentario(comentario);
        final AtividadeManual atividadeAprovacao = new AtividadeManual(c,p,dataL,e,equipa,des,com);
        return atividadeAprovacao;
    }

    public AtividadeAprovacao novaAtividadeAprovacaoManualColaborador(final Criticidade c, final String prior, final int ano,
                                                                 final int mes, final int dia, final EstadoAtividade e, final Colaborador colaborador,
                                                                 final String descisao, final String comentario){
        final Prioridade p = new Prioridade(prior);
        final Data dataL = new Data(ano,mes,dia);
        final Decisao des = new Decisao(descisao);
        final Comentario com = new Comentario(comentario);
        final AtividadeManual atividadeAprovacao = new AtividadeManual(c,p,dataL,e,colaborador,des,com);
        return atividadeAprovacao;
    }

}
