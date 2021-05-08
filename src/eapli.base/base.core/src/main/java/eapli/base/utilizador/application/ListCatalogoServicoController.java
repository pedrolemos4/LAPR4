package eapli.base.utilizador.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.Catalogo;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;
import eapli.base.gestaoservicosrh.domain.Equipa;
import eapli.base.gestaoservicosrh.repositories.ColaboradorRepository;
import eapli.base.gestaoservicosrh.repositories.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Colaborador;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ListCatalogoServicoController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private UserRepository userRepo = PersistenceContext.repositories().users();
    private CatalogoRepository catRepo = PersistenceContext.repositories().catalogo();
    private ColaboradorRepository colabRepo= PersistenceContext.repositories().colaborador();
    private EquipaRepository equipaRepo= PersistenceContext.repositories().equipas();

    private SystemUser currentUser() {
        return authz.session().get().authenticatedUser();
        //return authz.session().flatMap(s -> userRepo.findByUsername(s.authenticatedUser().username()));

    }

    public Set<Catalogo> findCatalogo(final String titulo, final String descricaobreve,
                                      final String descricaocompleta) {
        Set<Catalogo> listaFinal = new HashSet<>();
        final SystemUser user = currentUser()/*.orElseThrow(IllegalStateException::new)*/;
        EmailAddress email = user.email();
        Optional<Colaborador> colab = colabRepo.findEmailColaborador(email);
        MecanographicNumber number = colab.get().identity();
        final Iterable<Equipa> equipa = equipaRepo.findByColaborador(number);

        Iterable<Catalogo> listaTodos = catRepo.findAll();
        for(Catalogo c : listaTodos){
            // JA TENS AS EQUIPAS DO HOMEM
            // VERIFICAR SE AS EQUIPAS DO HOMEM SAO IGUAIS ÀS DO CATALOGO, SE SIM AVANÇA PARA A PROCURA
            // SE FOR IGUAL FAZ ISTO
            Iterable<Catalogo> l = catRepo.findCatalogos(titulo, descricaobreve, descricaocompleta);
            for(Catalogo cat : l){
                listaFinal.add(cat);
            }
        }
        return listaFinal;
    }


}