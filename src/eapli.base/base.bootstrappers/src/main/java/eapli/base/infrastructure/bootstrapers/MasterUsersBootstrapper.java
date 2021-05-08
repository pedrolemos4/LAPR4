/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.gestaoservicoshelpdesk.domain.Descricao;
import eapli.base.gestaoservicoshelpdesk.domain.Funcao;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    private static final String EMAILADMIN = "admin@org.com";

    private static final String IDADMIN = "01";

    private static final String EMAILGESTOR = "gestor@org.com";

    private static final String IDGESTOR = "02";

    private static final String EMAILRRH = "rrg@org.com";

    private static final String IDRRH = "03";

    private static final String EMAILCOLAB = "colab@org.com";

    private static final String EMAILCOLAB1 = "colab1@org.com";

    private static final String IDCOLAB = "04";

    private static final String EMAILUSER = "user@org.com";

    private static final String IDUSER = "05";

    @Override
    public boolean execute() {
        registaColaborador(119080,"João","João Alves Pereira","1984/10/25",0,931203457, "Bairro Baixo", "joao@gmail.com");

        registerUser("orgColab","Admin1","Ricardo","Soares",EMAILADMIN, BaseRoles.COLABORADOR);

        registerUser("orgRRH","Rrh1234","Paula","Castro",EMAILRRH,BaseRoles.RRH);

        registerUser("orgGestorServico","Gestor2","Afonso","Sousa",EMAILGESTOR,BaseRoles.GESTOR_SERVICO);

        registaColaborador(119876,"Gustavo","Gustavo Mike White","1992/07/05", 351,932705057, "Bairro Alto", "gustavo@gmail.com");

        registerUser("orgUser","Client1","Paulo","Maio",EMAILUSER,BaseRoles.CLIENT_USER);
        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    /**
     * US 2103 - LEANDRO SOUSA 1190800
     * -----------------------------------------------------------------------------------------------
     * Como Gestor de Projeto, eu pretendo que a equipa proceda à configuração da estrutura do projeto
     * para facilitar / acelerar o desenvolvimento das próximas user stories.
     * @return true in case of sucess or false if fails
     */

    private void registerUser(final String username, final String password, final String firstName,
                              final String lastName, final String email, Role role) {
        final Set<Role> roles = new HashSet<>();

        roles.add(role);
        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registaColaborador(final int numeroMecanografico, final String nomeCurto, final String nomeCompleto,
                                     final String dataNascimento, final int prefix, final int contacto, final String local, final String email){

        registerColaborador(numeroMecanografico, nomeCompleto, nomeCurto, dataNascimento, prefix, contacto, local,email);
    }
}
