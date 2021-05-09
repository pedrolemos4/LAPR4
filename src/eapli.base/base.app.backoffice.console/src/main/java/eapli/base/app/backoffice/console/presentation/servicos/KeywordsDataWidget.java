package eapli.base.app.backoffice.console.presentation.servicos;

import eapli.framework.io.util.Console;

public class KeywordsDataWidget {

    private String keyword;

    public void show(){ this.keyword= Console.readLine("Keyword:");}

    public String keyword(){
        return this.keyword;
    }
}
