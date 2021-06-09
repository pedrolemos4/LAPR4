package eapli.base.validacoes.valida;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class validaForm {

    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("testFormulario.txt"));
        validaFormLexer lexer = new validaFormLexer((new ANTLRInputStream(file)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        validaFormParser parser = new validaFormParser(tokens);
        ParseTree tree = parser.regra();
        EvalVisitorValidaForm eval = new EvalVisitorValidaForm();
        eval.visit(tree);
    }

}
