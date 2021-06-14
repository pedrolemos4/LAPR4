package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script.ValidaLerFicheiro;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainLerFicheiro {

    public void lerFicheiro(String args[]) throws IOException {
        FileInputStream fis = new FileInputStream(new File(args[1]));
        ValidaLerFicheiroLexer lexer = new ValidaLerFicheiroLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ValidaLerFicheiroParser parser = new ValidaLerFicheiroParser(tokens);
        ParseTree tree = parser.prog(); // parse
        EvalVisitorFicheiro eval = new EvalVisitorFicheiro(Integer.parseInt(args[0]));
        eval.visit(tree);
    }

}
