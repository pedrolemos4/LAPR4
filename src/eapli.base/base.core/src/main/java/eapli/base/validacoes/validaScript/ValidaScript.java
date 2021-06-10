package eapli.base.validacoes.validaScript;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;

public class ValidaScript {
    public boolean validaScript(File script) {
        try {
            FileInputStream file = new FileInputStream(script);
            validarScriptLexer lexer = new validarScriptLexer((new ANTLRInputStream(file)));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            validarScriptParser parser = new validarScriptParser(tokens);
            ParseTree tree = parser.regra();
            EvalVisitorValidarScript eval = new EvalVisitorValidarScript();
            eval.visit(tree);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
