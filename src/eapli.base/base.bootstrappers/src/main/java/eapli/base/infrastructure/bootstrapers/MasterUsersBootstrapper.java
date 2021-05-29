/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers;

import java.util.HashSet;
import java.util.Set;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {

    private static final String EMAILGESTOR = "gestor@org.com";

    private static final String IDGESTOR = "02";

    private static final String EMAILRRH = "rrg@org.com";

    private static final String EMAILUSER = "user@org.com";

    @Override
    public boolean execute() {

        initializeOrganizationOrganicStructure();

        return true;
    }

    /**
     * US 2103 - LEANDRO SOUSA 1190800
     * -----------------------------------------------------------------------------------------------
     * Como Gestor de Projeto, eu pretendo que a equipa proceda à configuração da estrutura do projeto
     * para facilitar / acelerar o desenvolvimento das próximas user stories.
     * @return true in case of sucess or false if fails
     */
    private void initializeOrganizationOrganicStructure(){
        registaColaborador(119080,"Joao","Joao Alves Pereira","1984/10/25",0, 965824578, "Penafiel", "joao@gmail.com");
        registerUser("orgColab","Admin1","Joao","Alves Pereira","joao@gmail.com", BaseRoles.COLABORADOR);

        registerUser("orgRRH","Rrh1234","Paula","Castro",EMAILRRH,BaseRoles.RRH);

        registerUser("orgGestorServico","Gestor2","Rui","Nunes",EMAILGESTOR,BaseRoles.GESTOR_SERVICO);

        registerUser("orgColab1","Colab1","Afonso","Sousa","afonso@gmail.com",BaseRoles.COLABORADOR);
        registaColaborador(119876,"Afonso","Afonso Sousa","1992/07/05", 351,932705057, "Bairro Alto", "afonso@gmail.com");

        registerUser("orgUser","Client1","Leonardo","Reis",EMAILUSER,BaseRoles.CLIENT_USER);

        registerUser("orgColab2","Colab2","Maria","Aires","mariaA@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(148752,"Maria","Maria Aires","1995/02/12", 351,914520048, "Algarve", "mariaA@gmail.com");

        registerUser("orgColab3","Colab3","Rita","Oliveira","ritaO@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(157847,"Rita","Rita Oliveira","1997/10/25", 351,925412006, "Leiria", "ritaO@gmail.com");

        registerUser("orgColab4","Colab4","Pedro","Santos","pedroS@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(160108,"Pedro","Pedro Santos","1996/11/11", 351,962574102, "Lisboa", "pedroS@gmail.com");

        registerUser("orgColab5","Colab5","Carlos","Pinto","carlosP@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(145625,"Carlos","Carlos Pinto","1991/05/15", 351,914522755, "Porto", "carlosP@gmail.com");

        registerUser("orgColab6","Colab6","Carla","Anjos","carlaA@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(185526,"Carla","Carla Anjos","1986/06/17", 351,956824886, "Caminha", "carlaA@gmail.com");

        registerUser("orgColab7","Colab7","Henrique","Silva","henriqueS@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(105244,"Henrique","Henrique Silva","1990/01/01", 351,922563248, "Aveiro", "henriqueS@gmail.com");

        registerUser("orgColab8","Colab8","Sofia","Sousa","sofiaS@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(104875,"Sofia","Sofia Sousa","1995/01/03", 351,933659526, "Ermesinde", "sofiaS@gmail.com");

        registerUser("orgColab9","Colab9","Raquel","Tavares","raquelT@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(112300,"Raquel","Raquel Tavares","1996/09/16", 351,910023358, "Espinho", "raquelT@gmail.com");

        registerUser("orgColab10","Colab10","Guilherme","Lapa","guilhermeP@gmail.com", BaseRoles.COLABORADOR);
        registaColaborador(125123,"Guilherme","Guilherme Lapa","1996/09/16", 351,925624569, "Paredes", "guilhermeP@gmail.com");

    }

    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

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
