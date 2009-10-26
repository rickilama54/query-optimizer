package queryopt.optimizer;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import queryopt.optimizer.entities.SPJQuery;
import queryopt.parser.SelectQueryGrammarLexer;
import queryopt.parser.SelectQueryGrammarParser;

public class SPJQueryBuilder {
	public static SPJQuery build(String query) throws RecognitionException {
		return buildSpjQueryFromAst(getAstFromString(query));
	}

	private static CommonTree getAstFromString(String query) throws RecognitionException {
		SelectQueryGrammarLexer lexer = new SelectQueryGrammarLexer(new ANTLRStringStream(query));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SelectQueryGrammarParser parser = new SelectQueryGrammarParser(tokens);
		return (CommonTree) parser.query().getTree();
	}

	private static SPJQuery buildSpjQueryFromAst(CommonTree ast) {
		
		return null;
	}
}
