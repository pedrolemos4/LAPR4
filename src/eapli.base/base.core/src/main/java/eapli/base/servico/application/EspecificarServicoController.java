package eapli.base.servico.application;

import eapli.base.atividade.domain.*;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.draft.domain.DraftServico;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.formulario.domain.*;
import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.draft.repositories.DraftServicoRepository;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
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
                                   Catalogo catalogo, final FluxoAtividade fluxoAtividade) {
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

    public Formulario createFormulario(final String titulo, Set<Atributo> listaAtributos) {
        final Formulario formulario = new Formulario(titulo, listaAtributos);
        //System.out.println(formulario.toString());
        //this.formularioRepository.save(formulario);
        return formulario;
    }

    public void createDraftServico(final String codigoUnico, final String descricaoBreve,
                                   final String descricaoCompleta, final String titulo, final String tituloFormulario,
                                   Set<Atributo> listaAtributos, Set<String> keywords, Catalogo catalogo, FluxoAtividade fluxo) {
        DraftServico draftServico = new DraftServico(codigoUnico, descricaoBreve, descricaoCompleta, titulo,
                tituloFormulario, listaAtributos, keywords, catalogo, fluxo);
        this.draftServicoRepository.save(draftServico);
    }

    public Iterable<Catalogo> listCatalogos() {
        final Iterable<Catalogo> lc = catalogoRepository.findAll();
        return lc;
    }

    public FluxoAtividade createFluxo(Set<Atividade> atividades) {
        Set<Atividade> listAtividades = new HashSet<>(atividades);
        FluxoAtividade fluxoAtividade = new FluxoAtividade(listAtividades);
        return fluxoAtividade;
    }

    public Iterable<Equipa> findEquipaDoCatalogo(Long identity) {
        return this.equipaRepo.findEquipaDoCatalogo(identity);
    }

    public Iterable<Colaborador> findColaboradoresDaEquipa(CodigoUnico identity) {
        final Iterable<Colaborador> lc = colaboradorRepository.findColaboradoresDaEquipa(identity);
        return lc;
    }

    public AtividadeManual novaAtividadeAprovacaoManualEquipa(final Set<Equipa> equipa, final Formulario formulario, TipoAtividade tipo) {
        final AtividadeManual atividadeAprovacaoManualEquipa;
        final EstadoAtividade e = EstadoAtividade.PENDENTE;
        atividadeAprovacaoManualEquipa = new AtividadeManual(e, equipa, null, null, formulario, null, tipo);
        return atividadeAprovacaoManualEquipa;
    }

    public AtividadeManual novaAtividadeAprovacaoManualColaborador(final Colaborador colaborador, final Formulario formulario, final TipoAtividade tipoAtividade) {
        final AtividadeManual atividadeAprovacaoColaborador;
        final EstadoAtividade e = EstadoAtividade.PENDENTE;
        atividadeAprovacaoColaborador = new AtividadeManual(e, colaborador, null, null, formulario, null, tipoAtividade);
        return atividadeAprovacaoColaborador;
    }

    public AtividadeAutomatica novaAtividadeAutomatica() {
        final AtividadeAutomatica atividadeAutomatica;
        final TipoAtividade tipoAtividade = TipoAtividade.REALIZACAO;
        final EstadoAtividade e = EstadoAtividade.PENDENTE;
        final Script script = new Script("script.sh");
        atividadeAutomatica = new AtividadeAutomatica(null, e, tipoAtividade, script);
        return atividadeAutomatica;
    }

    public Atributo createAtributo(String label, String tipoDados, String obrigatoriedade, String descricaoAjuda, Formulario formulario) {
        DescricaoAjuda descricaoAjuda1 = new DescricaoAjuda(descricaoAjuda);
        TipoDados tipoDados1 = Enum.valueOf(TipoDados.class, tipoDados.toUpperCase());
        Obrigatoriedade obr = Enum.valueOf(Obrigatoriedade.class, obrigatoriedade.toUpperCase());
        final Atributo atributo = new Atributo(new Label(label), tipoDados1, obr, descricaoAjuda1, formulario);
        return atributo;
    }


    public Catalogo saveCatalogo(Catalogo catalogo) {
        return this.catalogoRepository.save(catalogo);
    }
}
