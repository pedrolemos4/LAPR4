package eapli.base.app.backoffice.console.presentation.servicos;


import eapli.framework.io.util.Console;

public class DescricaoBreveDataWidget {

    private String descricaoBreve;

    public void show() {
        this.descricaoBreve = Console.readLine("Descrição breve:");
    }

    public String descricao() {
        return this.descricaoBreve;
    }
}
