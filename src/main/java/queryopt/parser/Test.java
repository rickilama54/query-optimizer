package queryopt.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

public class Test {
	public static void main(String[] args) {
		String testQuery = "  SELECT A B,C,SUM(D) FROM TABLE11 ,    TABLE2 WHERE A   = B AND C=D;";
		String testQuery2 = "SELECT * FROM TABLE  WHERE x='4';";
		SelectQueryGrammarLexer lexer = new SelectQueryGrammarLexer(new ANTLRStringStream(testQuery2));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SelectQueryGrammarParser parser = new SelectQueryGrammarParser(tokens);
		CommonTree ast;
		try {
			System.out.println("here");
			parser.query();
			ast = (CommonTree) parser.query().getTree();
			System.out.println(parser.getNumberOfSyntaxErrors()+" "+parser.getErrorMessage());
			//System.out.println(ast.toStringTree());
			System.out.println(print("", ast));
		} catch (Exception e) {
			System.out.println("e.getMessage():" + e.getMessage());
			e.printStackTrace();
		}
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