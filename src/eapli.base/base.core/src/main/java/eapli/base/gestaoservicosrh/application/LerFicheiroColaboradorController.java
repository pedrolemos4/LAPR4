package eapli.base.gestaoservicosrh.application;

import eapli.base.gestaoservicosrh.utils.LerFicheiroColaborador;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UseCaseController
public class LerFicheiroColaboradorController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final LerFicheiroColaborador lerFicheiroColaborador = new LerFicheiroColaborador();
    private final EspecificarColaboradorController colaboradorController = new EspecificarColaboradorController();
    private final AddUserController userController = new AddUserController();

    public void lerDados(final String nomeFicheiro){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.RRH);
        try{
            Map<Integer,List<String>> mapa = lerFicheiroColaborador.lerDados(nomeFicheiro);
            for(Integer i : mapa.keySet()){
                List<String> strings = mapa.get(i);
                String roles [] = strings.get(strings.size() - 1).split(" ");
                Set<Role>finalRoles = new HashSet<>();
                for(int p=0; p<roles.length;p++){
                    finalRoles.add(Role.valueOf(roles[p]));
                }
                this.colaboradorController.novoUtilizador(strings.get(0),strings.get(1),strings.get(2),strings.get(3),strings.get(4),finalRoles);
                this.colaboradorController.novoColaborador(Integer.parseInt(strings.get(5)),strings.get(6),strings.get(7),strings.get(8),Integer.parseInt(strings.get(9)),strings.get(10),strings.get(4));
            }
        }catch(FileNotFoundException e){
            System.out.println("Ficheiro não encontrado/ Nome errado");
        }
    }

}
