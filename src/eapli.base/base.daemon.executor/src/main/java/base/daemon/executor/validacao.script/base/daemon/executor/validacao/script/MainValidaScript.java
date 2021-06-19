package base.daemon.executor.validacao.script.base.daemon.executor.validacao.script;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainValidaScript {

    public void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("script_teste.txt"));
        ValidaScriptLexer lexer = new ValidaScriptLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ValidaScriptParser parser = new ValidaScriptParser(tokens);
        ParseTree tree = parser.prog();
        EvalVisitor eval = new EvalVisitor();
        eval.setQuantidade(Integer.parseInt(args[1]));
        eval.visit(tree);

        /*ParseTreeWalker walker = new ParseTreeWalker();
        EvalListener listener = new EvalListener();
        walker.walk(listener, tree);*/
    }

}
