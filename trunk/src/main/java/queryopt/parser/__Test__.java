import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        SQL_grammarLexer lex = new SQL_grammarLexer(new ANTLRFileStream("/home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/__Test___input.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        SQL_grammarParser g = new SQL_grammarParser(tokens, 49100, null);
        try {
            g.query();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}