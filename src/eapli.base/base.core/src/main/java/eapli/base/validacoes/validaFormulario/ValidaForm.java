package eapli.base.validacoes.validaFormulario;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;

public class ValidaForm {

    public boolean validaFormVisitor(File file) {
        try {
            FileInputStream file1 = new FileInputStream(file);
            validaFormLexer lexer = new validaFormLexer((new ANTLRInputStream(file1)));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            validaFormParser parser = new validaFormParser(tokens);
            ParseTree tree = parser.regra();
            EvalVisitorValidaForm eval = new EvalVisitorValidaForm();
            String value = eval.visit(tree);
            if (value.equalsIgnoreCase("invalido")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void validaFormListener(File file) throws Exception {
        FileInputStream file1 = new FileInputStream(file);
        validaFormLexer lexer = new validaFormLexer((new ANTLRInputStream(file1)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        validaFormParser parser = new validaFormParser(tokens);
        ParseTree tree = parser.regra();
        ParseTreeWalker walker = new ParseTreeWalker();
        EvalListenerValidaForm listener = new EvalListenerValidaForm();
        walker.walk(listener, tree);
    }

}
