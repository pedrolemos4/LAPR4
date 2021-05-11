package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.base.gestaoservicosrh.application.AdicionarColaboradorEquipaController;
import eapli.base.gestaoservicosrh.application.RemoverColaboradorEquipaController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Scanner;

public class AdicionarRemoverColaboradorUI extends AbstractUI {

    private final AdicionarColaboradorEquipaController controller = new AdicionarColaboradorEquipaController();

    private final RemoverColaboradorEquipaController controller1 = new RemoverColaboradorEquipaController();

    private Scanner sc = new Scanner(System.in);

    @Override
    protected boolean doShow() {
        String codigoUnico;
        int nrMecanografico;
        System.out.println("===========================================================================================\n"+
                           "=                            ADICIONAR/REMOVER COLABORADOR                                =\n"+
                           "===========================================================================================\n"+
                           "=SELECIONE OPCAO:                                                                         =\n"+
                           "=1-ADICIONAR COLABORADOR A EQUIPA                                                         =\n"+
                           "=2-REMOVER COLABORADOR A EQUIPA                                                           =\n"+
                           "=0-SAIR                                                                                   =\n"+
                           "===========================================================================================\n");
        int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("===========================================================================================\n"+
                            "=                                ADICIONAR COLABORADOR                                    =\n"+
                            "===========================================================================================\n"+
                            "=INTRODUZA ID DE EQUIPA E NR MECANOGRAFICO DE COLABORADOR A ADICIONAR:                    =\n"+
                            "===========================================================================================\n");
                    controller.showAll();
                    System.out.println("=ID EQUIPA:                                                                               =\n");
                    codigoUnico = sc.next();
                    System.out.println("===========================================================================================\n");
                    System.out.println("=NUMERO MECANOGRAFICO:                                                                    =\n");
                    nrMecanografico = sc.nextInt();
                    System.out.println("===========================================================================================\n");
                    controller.adicionarColaboradorEquipa(codigoUnico,nrMecanografico);
                    break;
                case 2:
                    System.out.println("===========================================================================================\n"+
                            "=                                REMOVER COLABORADOR                                      =\n"+
                            "===========================================================================================\n"+
                            "=INTRODUZA ID DE EQUIPA E NR MECANOGRAFICO DE COLABORADOR A ADICIONAR:                    =\n"+
                            "===========================================================================================\n");
                    controller1.showAll();
                    System.out.println("=ID EQUIPA:                                                                               =\n");
                    codigoUnico = sc.next();
                    System.out.println("===========================================================================================\n");
                    System.out.println("=NUMERO MECANOGRAFICO:                                                                    =\n");
                    nrMecanografico = sc.nextInt();
                    System.out.println("===========================================================================================");
                    controller1.removerColaboradorEquipa(codigoUnico,nrMecanografico);
                    break;
                default:
                    System.out.println("INVALID OPTION=============================================================================\n");
                    break;
            }
        return true;
    }

    @Override
    public String headline() {
        return "Adicionar/Remover Colaborador";
    }

}
