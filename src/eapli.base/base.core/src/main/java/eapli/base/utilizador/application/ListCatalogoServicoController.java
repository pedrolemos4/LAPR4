package eapli.base.utilizador.application;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.gestaoservicoshelpdesk.domain.*;
import eapli.base.gestaoservicoshelpdesk.repositories.CatalogoRepository;
import eapli.base.gestaoservicoshelpdesk.repositories.ServicoRepository;
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
import java.util.Set;

public class ListCatalogoServicoController {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    private UserRepository userRepo = PersistenceContext.repositories().users();
    private CatalogoRepository catRepo = PersistenceContext.repositories().catalogo();
    private ColaboradorRepository colabRepo= PersistenceContext.repositories().colaborador();
    private EquipaRepository equipaRepo= PersistenceContext.repositories().equipas();
    private ServicoRepository servicoRepo= PersistenceContext.repositories().servicos();

    private SystemUser currentUser() {
        return authz.session().get().authenticatedUser();
        //return authz.session().flatMap(s -> userRepo.findByUsername(s.authenticatedUser().username()));

    }

    public Set<Catalogo> findCatalogo(Set<Catalogo> listaFinal, final String titulo, final String descricaobreve,
                                      final String descricaocompleta) {
        final SystemUser user = currentUser()/*.orElseThrow(IllegalStateException::new)*/;
        EmailAddress email = user.email();
        Colaborador colab = colabRepo.findEmailColaborador(email);
        System.out.println(email.toString());
        System.out.println("FEZ FINDEMAILCOLABORADOR");
        MecanographicNumber number = colab.identity();
        final Iterable<Equipa> equipaUser =  equipaRepo.findByColaborador(number);
        Set<Equipa> list1 = new HashSet<>();
        for (Equipa eq : equipaUser) {
            list1.add(eq);
        }

        System.out.println("FEZ findByColaborador");

        Iterable<Catalogo> listaTodos = catRepo.findAll();
        for(Catalogo c : listaTodos){

            final Iterable<Equipa> equipaTotal = equipaRepo.findEquipaDoCatalogo(c.identity());
            System.out.println("FEZ findEquipaDoCatalogo");
            for(Equipa e : equipaTotal) {
                if(list1.contains(e)) {
                    // catalogos dele e verifica se tem ou nao os requisitos
                    Iterable<Catalogo> l = catRepo.findCatalogos(new Titulo(titulo), new DescricaoBreve(descricaobreve), new DescricaoCompletaCatalogo(descricaocompleta));
                    System.out.println("FEZ findCatalogos");
                    for (Catalogo cat : l) {
                        listaFinal.add(cat);
                    }
                }
            }
        }
        return listaFinal;
    }

    public Set<Servico> findServicosUtilizador(Set<Servico> listaFinal, final String titulo, final String descricaobreve,
                                      final String descricaocompleta) {
        final SystemUser user = currentUser()/*.orElseThrow(IllegalStateException::new)*/;
        EmailAddress email = user.email();
        Colaborador colab = colabRepo.findEmailColaborador(email);
        System.out.println(email.toString());
        System.out.println("FEZ FINDEMAILCOLABORADOR");
        MecanographicNumber number = colab.identity();
        final Iterable<Equipa> equipaUser =  equipaRepo.findByColaborador(number);
        Set<Equipa> list1 = new HashSet<>();
        for (Equipa eq : equipaUser) {
            list1.add(eq);
        }

        System.out.println("FEZ findByColaborador");
        Set<Servico> temp = new HashSet<>();
        Iterable<Catalogo> listaTodos = catRepo.findAll();
        for(Catalogo c : listaTodos){
            final Iterable<Equipa> equipaTotal = equipaRepo.findEquipaDoCatalogo(c.identity());
            System.out.println("FEZ findEquipaDoCatalogo");
            for(Equipa e : equipaTotal) {
                if(list1.contains(e)) {
                    //servicos que estao disponiveis para o user
                    Iterable<Servico> l = servicoRepo.findServicosDoCatalogo(c.identity());
                    System.out.println("FEZ findCatalogos");
                    for (Servico cat : l) {
                        temp.add(cat);
                    }
                }
            }
        }

        for(Servico servico : temp) {
            // ve para cada servico se os requisitos sao iguais ao servico
            Iterable<Servico> listServico = servicoRepo.findAllServicos(servico.identity(),new Titulo(titulo),
                    new DescricaoBreve(descricaobreve), new DescricaoCompletaCatalogo(descricaocompleta));
            for(Servico s : listServico) {
                listaFinal.add(s);
            }
        }

        return listaFinal;
    }


}