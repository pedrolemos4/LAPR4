package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.framework.io.util.Console;

public class DesignacaoDataWidget {

    private String designacao;

    public void show() {
        this.designacao = Console.readLine("Designação:");
    }

    public String designacao() {
        return this.designacao;
    }
}
