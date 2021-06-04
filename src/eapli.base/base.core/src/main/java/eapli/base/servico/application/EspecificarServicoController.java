package eapli.base.servico.application;

import eapli.base.atividade.domain.*;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.draft.domain.DraftServico;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.draft.repositories.DraftServicoRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


@UseCaseController
public class EspecificarServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final EquipaRepository equipaRepo = PersistenceContext.repositories().equipas();
    private final DraftServicoRepository draftServicoRepository = PersistenceContext.repositories().drafts();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ColaboradorRepository colaboradorRepository = PersistenceContext.repositories().colaborador();

    public void especificarServico(final String codigoUnico, final String titulo, final String descricaoBreve,
                                   final String descricaoCompleta, Formulario formulario, Set<String> keywords,
                                   Catalogo catalogo,final FluxoAtividade fluxoAtividade) {
        final Servico servico = new Servico.ServicoBuilder(codigoUnico, titulo)
                .withDescricaoBreve(descricaoBreve)
                .withDescricaoCompleta(descricaoCompleta)
                .withFormulario(formulario)
                .withKeywords(keywords)
                .withCatalogo(catalogo)
                .withFluxo(fluxoAtividade)
                .build();
        //servico.makeUnavailable();
        servico.makeAvailable();
        this.servicoRepository.save(servico);
    }

    public Formulario createFormulario(final String titulo, Set<Atributo> listaAtributos){
        final Formulario formulario = new Formulario(titulo, listaAtributos);
        //System.out.println(formulario.toString());
      //  this.formularioRepository.save(formulario);
        return formulario;
    }

    public void createDraftServico(final String codigoUnico, final String descricaoBreve,
                                   final String descricaoCompleta,final String titulo,  final String tituloFormulario,
                                   Set<Atributo> listaAtributos,Set<String> keywords,Catalogo catalogo, FluxoAtividade fluxo) {
        DraftServico draftServico = new DraftServico(codigoUnico, descricaoBreve, descricaoCompleta, titulo,
                tituloFormulario, listaAtributos, keywords,catalogo, fluxo);
        this.draftServicoRepository.save(draftServico);
    }

    public Atributo createAtributo(String nomeVariavel, String label) {
        final Atributo atributo = new Atributo(nomeVariavel, label);
        return atributo;
    }


    public Iterable<Catalogo> listCatalogos(){
        final Iterable<Catalogo> lc = catalogoRepository.findAll();
        return lc;
    }

    public FluxoAtividade createFluxo (Set<Atividade> atividades){
        Set<Atividade> listAtividades = new HashSet<>(atividades);
        FluxoAtividade fluxoAtividade = new FluxoAtividade(listAtividades);
        return fluxoAtividade;
    }

    public Iterable<Equipa> findEquipaDoCatalogo(Long identity) {
        return this.equipaRepo.findEquipaDoCatalogo(identity);
    }

    public Iterable<Colaborador> findColaboradoresDaEquipa(CodigoUnico identity){
        final Iterable<Colaborador> lc = colaboradorRepository.findColaboradoresDaEquipa(identity);
        return lc;
    }

    public AtividadeManual novaAtividadeAprovacaoManualEquipa(final Set<Equipa> equipa,
                                                              final String decisao, final String comentario,
                                                              final int ano, final int mes, final int dia,
                                                              final Formulario formulario, TipoAtividade tipo){
        final AtividadeManual atividadeAprovacaoManualEquipa;
        final Calendar data = Calendar.getInstance();
        data.set(ano,mes,dia);
        final Decisao des = new Decisao(decisao);
        final Comentario com = new Comentario(comentario);
        final EstadoAtividade e  = EstadoAtividade.PENDENTE ;
        if(ano==0 && mes==0 && dia==0) {
            atividadeAprovacaoManualEquipa = new AtividadeManual(e, equipa, des, com, formulario, null, tipo);
        }else{
            atividadeAprovacaoManualEquipa = new AtividadeManual(e, equipa, des, com, formulario, data, tipo);
        }
        return atividadeAprovacaoManualEquipa;
    }

    public AtividadeManual novaAtividadeAprovacaoManualColaborador(final Colaborador colaborador,
                                                                   final String decisao, final String comentario,
                                                                   final int ano, final int mes, final int dia,
                                                                   final Formulario formulario, final TipoAtividade tipoAtividade){
        final AtividadeManual atividadeAprovacaoColaborador;
        final Calendar data = Calendar.getInstance();
        data.set(ano,mes,dia);
        final Decisao des = new Decisao(decisao);
        final Comentario com = new Comentario(comentario);
        final EstadoAtividade e  = EstadoAtividade.PENDENTE ;
        if(ano==0 && mes==0 && dia==0) {
            atividadeAprovacaoColaborador = new AtividadeManual(e, colaborador, des, com, formulario, null, tipoAtividade);
        }else{
            atividadeAprovacaoColaborador = new AtividadeManual(e, colaborador, des, com, formulario, data, tipoAtividade);
        }
        return atividadeAprovacaoColaborador;
    }

    public AtividadeAutomatica novaAtividadeAutomatica(final int ano, final int mes, final int dia){
        final AtividadeAutomatica atividadeAutomatica;
        final Calendar data = Calendar.getInstance();
        data.set(ano,mes,dia);
        final TipoAtividade tipoAtividade = TipoAtividade.REALIZACAO;
        final EstadoAtividade e = EstadoAtividade.PENDENTE;
        final Script script = new Script("script.sh");
        if(ano==0 && mes==0 && dia==0) {
            atividadeAutomatica = new AtividadeAutomatica(null,e,tipoAtividade, script);
        }else{
            atividadeAutomatica = new AtividadeAutomatica(data,e,tipoAtividade, script);
        }
        return atividadeAutomatica;
    }

    public Catalogo saveCatalogo(Catalogo catalogo){
        return this.catalogoRepository.save(catalogo);
    }
}
