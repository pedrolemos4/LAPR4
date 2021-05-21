package eapli.base.validacoes.validarAtividade;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class validarAtividade {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("testAtividade.txt"));
        validarAtividadeLexer lexer = new validarAtividadeLexer((new ANTLRInputStream(file)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        validarAtividadeParser parser = new validarAtividadeParser(tokens);
        ParseTree tree = parser.regra();
        EvalVisitorValidarAtividade eval = new EvalVisitorValidarAtividade();
        eval.visit(tree);
    }
}
