package queryopt.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

public class Test {
	public static void main(String[] args) throws Exception {
		String testQuery = "  SELECT A, B,C,SUM(D) FROM TABLE1 ,    TABLE2 WHERE A   = B AND C=D;";
		SelectQueryGrammarLexer lexer = new SelectQueryGrammarLexer(new ANTLRStringStream(testQuery));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SelectQueryGrammarParser parser = new SelectQueryGrammarParser(tokens);
		CommonTree ast = (CommonTree) parser.query().getTree();
		System.out.println(ast.toStringTree());
		System.out.println(print("", ast));
	}

	static String print(String whitespace, CommonTree ast) {
		String str = "";
		str += whitespace + ast;
		str += "\n";
		if (ast.getChildren() != null)
			for (Object child : ast.getChildren()) {
				str += print(whitespace + "   ", (CommonTree) child);
			}
		return str;
	}
}