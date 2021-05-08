package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class DesignacaoDataWidget {
    
    private String designacao;

    public void show(){
        try {
            this.designacao = Console.readLine("Designacao:");
        } catch (IllegalArgumentException e) {
            System.out.println("Designacao nao pode ser null nem empty!");
        }
    }

    public String designacao(){
        return this.designacao;
    }
}
