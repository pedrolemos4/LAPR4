package eapli.base.colaborador.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.*;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.*;
import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.RandomRawPassword;

import java.util.Calendar;

@UseCaseController
public class EspecificarColaboradorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository repository = PersistenceContext.repositories().colaborador();
    private final RandomRawPassword randomPassword = new RandomRawPassword();

    public void novoColaborador(final int numeroMecanografico, final String nomeCompleto, final String nomeCurto,
                                       final String dataNascimento, final int prefix, final int contacto, final String local, final String email) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.RRH);
        MecanographicNumber mecanographicNumber = new MecanographicNumber(numeroMecanografico);
        ShortName shortName = new ShortName(nomeCurto);
        FullName fullName = new FullName(nomeCompleto);
        String[] split = dataNascimento.split("/");
        final Calendar data = Calendar.getInstance();
        data.set(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        Contacto contact ;
        if(prefix==0) {
            contact = new Contacto(contacto);
        }else{
            contact = new Contacto(prefix, contacto);
        }
        LocalResidencia local1 = new LocalResidencia(local);
        EmailAddress email1 = EmailAddress.valueOf(email);
        Colaborador colab = new Colaborador(mecanographicNumber, shortName, fullName, data, contact, local1, email1);
        repository.save(colab);
    }


    public String geraPassword() {
        return randomPassword.toString();
    }
}
