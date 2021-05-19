package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.framework.io.util.Console;

public class DescricaoCompletaDataWidget {

    private String descricaoCompleta;

    public void show(){
        this.descricaoCompleta= Console.readLine("\nDescrição Completa:");
    }

    public String descricao(){
        return this.descricaoCompleta;
    }
}
