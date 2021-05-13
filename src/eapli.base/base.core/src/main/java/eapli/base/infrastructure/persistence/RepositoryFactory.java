/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.catalogo.repositories.CatalogoRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.contrato.repositories.ContratoRepository;
import eapli.base.criticidade.repositories.CriticidadeRepository;
import eapli.base.draft.repositories.DraftServicoRepository;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.equipa.repositories.EquipaRepository;
import eapli.base.tipoequipa.repositories.TipoEquipaRepository;
import eapli.base.servico.repositories.ServicoRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	/**
	 * factory method to create a transactional context to use in the repositories
	 *
	 * @return
	 */
	TransactionalContext newTransactionalContext();

	/**
	 *
	 * @param autoTx the transactional context to enrol
	 * @return
	 */
	UserRepository users(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	UserRepository users();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	ClientUserRepository clientUsers(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	ClientUserRepository clientUsers();

	/**
	 *
	 * @param autoTx the transactional context to enroll
	 * @return
	 */
	SignupRequestRepository signupRequests(TransactionalContext autoTx);

	/**
	 * repository will be created in auto transaction mode
	 *
	 * @return
	 */
	SignupRequestRepository signupRequests();

	EquipaRepository equipas();

	TipoEquipaRepository tiposEquipa();

	ServicoRepository servicos();

	CatalogoRepository catalogo();

	//UtilizadorRepository utilizador();

	DraftServicoRepository drafts();

	CriticidadeRepository criticidade();

	FormularioRepository formularios();

    ColaboradorRepository colaborador();

    ContratoRepository contrato();
}
