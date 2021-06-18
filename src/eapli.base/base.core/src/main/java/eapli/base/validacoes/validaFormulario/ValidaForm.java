package eapli.base.validacoes.validaFormulario;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ValidaForm {

    public static boolean validaFormVisitor(File file) {
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
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean validaFormListener(File file) {
        try {
            FileInputStream file1 = new FileInputStream(file);
            validaFormLexer lexer = new validaFormLexer((new ANTLRInputStream(file1)));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            validaFormParser parser = new validaFormParser(tokens);
            ParseTree tree = parser.regra();
            ParseTreeWalker walker = new ParseTreeWalker();
            EvalListenerValidaForm listener = new EvalListenerValidaForm();
            walker.walk(listener, tree);
            return true;
        } catch (Exception e) {
            System.out.println("Preenchimento de formulário inválido");
            return false;
        }
    }

    public static void main(String[] args) {
        File file = new File("testForm.txt");
        if(validaFormVisitor(file)){
            System.out.println("ENTÃO É BOOLEAN AQUARIANO");
        } else{
            System.out.println("Lol");
        }

    }
}
