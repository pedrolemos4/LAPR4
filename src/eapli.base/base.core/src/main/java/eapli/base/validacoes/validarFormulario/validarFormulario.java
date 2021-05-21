package eapli.base.validacoes.validarFormulario;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class validarFormulario {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("testFormulario.txt"));
        validarFormularioLexer lexer = new validarFormularioLexer((new ANTLRInputStream(file)));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        validarFormularioParser parser = new validarFormularioParser(tokens);
        ParseTree tree = parser.regra();
        EvalVisitorValidarFormulario eval = new EvalVisitorValidarFormulario();
        eval.visit(tree);
    }
}
