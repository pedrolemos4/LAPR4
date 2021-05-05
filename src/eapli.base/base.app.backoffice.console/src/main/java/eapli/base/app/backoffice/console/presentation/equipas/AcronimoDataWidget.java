package eapli.base.app.backoffice.console.presentation.equipas;

import eapli.framework.io.util.Console;

public class AcronimoDataWidget {

    private String acronimo;

    public void show() {
        this.acronimo = Console.readLine("Acrónimo:");
    }

    public String acronimo() {
        return this.acronimo;
    }
}
