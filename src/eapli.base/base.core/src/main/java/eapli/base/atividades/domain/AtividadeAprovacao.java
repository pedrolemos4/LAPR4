package eapli.base.atividades.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AtividadeAprovacao{ //extends Atividade{

    @Id
    @GeneratedValue
    private Long id;

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

    protected AtividadeAprovacao(){

    }

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
