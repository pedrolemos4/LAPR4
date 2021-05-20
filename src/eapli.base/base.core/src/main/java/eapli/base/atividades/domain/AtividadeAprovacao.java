package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.util.Set;

public class AtividadeAprovacao {

    @OneToOne
    private Colaborador colab;

    @OneToOne
    private Set<Equipa> equipa;

    @Enumerated(EnumType.STRING)
    private EstadoAtividade estadoAtividade;

    @Column(name = "DECISAO")
    private Decisao decisao;

    @Column(name = "COMENTARIO")
    private Comentario comentario;

    public AtividadeAprovacao(final EstadoAtividade estadoAtividade, final Colaborador colab, final Decisao decisao,
                              final Comentario comentario) {
        this.colab = colab;
        this.decisao = decisao;
        this.comentario = comentario;
        this.estadoAtividade=estadoAtividade;
    }

    public AtividadeAprovacao(final EstadoAtividade estadoAtividade, final Set<Equipa> equipa, final Decisao decisao,
                              final Comentario comentario) {
        this.equipa=equipa;
        this.decisao = decisao;
        this.comentario = comentario;
        this.estadoAtividade=estadoAtividade;
    }
}
