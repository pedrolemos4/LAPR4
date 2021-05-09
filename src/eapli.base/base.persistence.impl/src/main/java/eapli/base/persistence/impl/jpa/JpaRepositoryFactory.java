package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.*;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */

public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public UserRepository users(final TransactionalContext autoTx) {
		return new JpaAutoTxUserRepository(autoTx);
	}

	@Override
	public UserRepository users() {
		return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}


	@Override
	public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
		return new JpaClientUserRepository(autoTx);
	}

	@Override
	public JpaClientUserRepository clientUsers() {
		return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
	}

	@Override
	public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
		return new JpaSignupRequestRepository(autoTx);
	}

	@Override
	public SignupRequestRepository signupRequests() {
		return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
	}

    @Override
    public EquipaRepository equipas() {
        return new JpaEquipaRepository();
    }

    @Override
	public TipoEquipaRepository tiposEquipa() {
		return new JpaTipoEquipaRepository();
	}

    @Override
    public ServicoRepository servicos() {
        return new JpaServicoRepository();
    }

    @Override
    public CatalogoRepository catalogo() {
        return new JpaCatalogoRepository();
    }

    @Override
    public DraftServicoRepository drafts() {
        return new JpaDraftServicoRepository();
    }

    @Override
    public CriticidadeRepository criticidade() {
        return new JpaCriticidadeRepository();
    }

	@Override
	public FormularioRepository formularios() {
		return new JpaFormularioRepository();
	}

	@Override
	public ColaboradorRepository colaborador() {
		return new JpaColaboradorRepository();
	}

	@Override
	public ContratoRepository contrato() {
		return new JpaContratoRepository();
	}

	@Override
	public TransactionalContext newTransactionalContext() {
		return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
				Application.settings().getExtendedPersistenceProperties());
	}

}


