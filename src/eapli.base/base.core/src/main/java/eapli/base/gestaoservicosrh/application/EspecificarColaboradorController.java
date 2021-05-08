package eapli.base.gestaoservicosrh.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.Descricao;
import eapli.base.gestaoservicoshelpdesk.domain.EnderecoEmail;
import eapli.base.gestaoservicoshelpdesk.domain.Funcao;
import eapli.base.gestaoservicoshelpdesk.domain.LocalResidencia;
import eapli.base.gestaoservicosrh.domain.CodigoUnico;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.*;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.RandomRawPassword;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EspecificarColaboradorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository repository = PersistenceContext.repositories().colaborador();
    private final AddUserController userController = new AddUserController();
    private final RandomRawPassword randomPassword = new RandomRawPassword();

    public void novoUtilizador(final String username, final String password, final String firstName, final String lastName, final String email, final Set<Role> set){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.RRH);
//        Set<Role> set = new HashSet<>();
//        set.add(BaseRoles.COLABORADOR);
        userController.addUser(username,password,firstName,lastName,email,set);
    }

    public void novoColaborador(final int numeroMecanografico, final String nomeCompleto, final String nomeCurto,
                                       final String dataNascimento, final int contacto, final String local, final String email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER);
        MecanographicNumber mecanographicNumber = new MecanographicNumber(numeroMecanografico);
        ShortName shortName = new ShortName(nomeCurto);
        FullName fullName = new FullName(nomeCompleto);
        String[] split = dataNascimento.split("/");
        Data date = new Data(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        Contacto contact = new Contacto(contacto);
        LocalResidencia local1 = new LocalResidencia(local);
        EnderecoEmail email1 = new EnderecoEmail(email);
        Colaborador colab = new Colaborador(mecanographicNumber, shortName, fullName, date, contact, local1, email1);
        repository.save(colab);
    }


    public String geraPassword() {
        return randomPassword.toString();
    }
}
