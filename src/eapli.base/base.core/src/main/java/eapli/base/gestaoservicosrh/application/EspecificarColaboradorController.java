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
import eapli.base.usermanagement.domain.*;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Date;
import java.util.Set;

public class EspecificarColaboradorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ColaboradorRepository repository = PersistenceContext.repositories().colaborador();

    public void novoColaborador(final int numeroMecanografico, final String nomeCompleto, final String nomeCurto,
                                       final String dataNascimento, final int contacto, final String local, final String email, final String desc, final String codigo) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.COLABORADOR);
        MecanographicNumber mecanographicNumber = new MecanographicNumber(numeroMecanografico);
        ShortName shortName = new ShortName(nomeCurto);
        FullName fullName = new FullName(nomeCompleto);
        String[] split = dataNascimento.split("/");
        Data date = new Data(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        Contacto contact = new Contacto(contacto);
        LocalResidencia local1 = new LocalResidencia(local);
        EnderecoEmail email1 = new EnderecoEmail(email);
        Descricao desc1 = new Descricao(desc);
        CodigoUnico cod = new CodigoUnico(codigo);
        Funcao funcao = new Funcao(cod,desc1);
        Colaborador colab = new Colaborador(mecanographicNumber, shortName, fullName, date, contact, local1, email1, funcao);
        repository.save(colab);
    }


}
