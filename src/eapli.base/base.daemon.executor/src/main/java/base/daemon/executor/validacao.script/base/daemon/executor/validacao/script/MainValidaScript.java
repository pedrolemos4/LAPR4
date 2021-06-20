package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainValidaScript {

    public static void main(String[] args, File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ValidaScriptParser parser = new ValidaScriptParser(tokens);
        ParseTree tree = parser.prog();

        System.out.println("VISITOR: ");
        EvalVisitor eval = new EvalVisitor();
        eval.setQuantidade(Integer.parseInt(args[0]));
        eval.setForm(args[1]);
        eval.visit(tree);

        System.out.println("\nLISTENER: ");
        ParseTreeWalker walker = new ParseTreeWalker();
        EvalListener listener = new EvalListener();
        listener.setQuantidade(Integer.parseInt(args[0]));
        listener.setForm(args[1]);
        walker.walk(listener, tree);
    }

}
