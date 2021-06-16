package eapli.base.servico.application;

import eapli.base.atividade.domain.*;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.criticidade.domain.Criticidade;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.draft.domain.DraftServico;
import eapli.base.draft.repositories.DraftServicoRepository;
import eapli.base.equipa.domain.Equipa;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.framework.application.UseCaseController;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@UseCaseController
public class CompletarServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
    private final DraftServicoRepository draftServicoRepository = PersistenceContext.repositories().drafts();
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formularios();
    private final EquipaRepository equipaRepo = PersistenceContext.repositories().equipas();
    private final CriticidadeRepository criticidadeRepository = PersistenceContext.repositories().criticidade();


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
        servico.makeUnavailable();
        this.servicoRepository.save(servico);
    }

    public void removeDraft(DraftServico draftServico) {
        this.draftServicoRepository.delete(draftServico);
    }

    public Iterable<DraftServico> listDrafts() {
        final Iterable<DraftServico> ld = draftServicoRepository.findAll();
        return ld;
    }

    public Formulario createFormulario(final String titulo, Set<Atributo> listaAtributos) {
        final Formulario formulario = new Formulario(titulo, listaAtributos);
        //System.out.println(formulario.toString());
        this.formularioRepository.save(formulario);
        return formulario;
    }

    public Iterable<Criticidade> listCriticidades() {
        final Iterable<Criticidade> lc = criticidadeRepository.findAll();
        return lc;
    }


    public Iterable<Equipa> findEquipaDoCatalogo(Long identity) {
        return this.equipaRepo.findEquipaDoCatalogo(identity);
    }

    public FluxoAtividade createFluxo(Set<Atividade> atividades) {//, AtividadeRealizacao atividadeRealizacao)
        Set<Atividade> listAtividades = new HashSet<>(atividades);
        FluxoAtividade fluxoAtividade = new FluxoAtividade(listAtividades);
        return fluxoAtividade;
    }

    public AtividadeManual novaAtividadeAprovacaoManualEquipa(final EstadoAtividade e, final Set<Equipa> equipa,
                                                              final Formulario formulario, TipoAtividade tipo) {
        //  final Calendar data = Calendar.getInstance();
        //data.set(ano,mes,dia);
        /*final Decisao des = new Decisao(decisao);
        final Comentario com = new Comentario(comentario);*/
        final AtividadeManual atividadeAprovacaoManualEquipa = new AtividadeManual(e, equipa, null, null, formulario, null, tipo);
        return atividadeAprovacaoManualEquipa;
    }

    public AtividadeAutomatica novaAtividadeAutomatica(final int ano, final int mes, final int dia) {

        final Calendar data = Calendar.getInstance();
        data.set(ano, mes, dia);
        final TipoAtividade tipoAtividade = TipoAtividade.REALIZACAO;
        final EstadoAtividade e = EstadoAtividade.PENDENTE;
        final Script script = new Script("script.sh");
        final AtividadeAutomatica atividadeAutomatica = new AtividadeAutomatica(data, e, tipoAtividade, script);
        return atividadeAutomatica;
    }

}
