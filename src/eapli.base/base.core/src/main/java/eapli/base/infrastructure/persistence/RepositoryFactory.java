/**
 *
 */
package eapli.base.infrastructure.persistence;

import eapli.base.clientusermanagement.repositories.ClientUserRepository;

import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.*;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.gestaoservicosrh.repositories.TipoEquipaRepository;
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
}
