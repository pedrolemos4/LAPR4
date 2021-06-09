package eapli.base.validacoes.validaFormulario;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;

public class ValidaForm {

    public boolean validaForm(File file) {
        //FileInputStream file = new FileInputStream(new File("testFormulario.txt"));
        try {
            FileInputStream file1 = new FileInputStream(file);
            validaFormLexer lexer = new validaFormLexer((new ANTLRInputStream(file1)));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            validaFormParser parser = new validaFormParser(tokens);
            ParseTree tree = parser.regra();
            EvalVisitorValidaForm eval = new EvalVisitorValidaForm();
            eval.visit(tree);
        } catch (Exception e){
            return false;
        }
        return true;
    }

}
