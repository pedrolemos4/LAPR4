package eapli.base.app.backoffice.console.presentation.criticidade;

import eapli.framework.io.util.Console;

public class DesignacaoDataWidget {
    
    private String designacao;

    public void show(){
        this.designacao = Console.readLine("Designacao:");
    }

    public String designacao(){
        return this.designacao;
    }
}
