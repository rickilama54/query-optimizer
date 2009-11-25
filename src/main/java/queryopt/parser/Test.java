package queryopt.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class Test {
	public static void main(String[] args) throws RecognitionException {
		String testQuery = "SELECT A,B,C,  D , F " + "FROM TABLE1 , TABLE2, TABLE3 " + "WHERE " + "A = B AND "
				+ "B < C AND " + "C > D AND " + "D >= F AND " + "F >= A;";
		String testQuery2 = "SELECT * FROM TABLE1;";
		SQL_grammarLexer lexer = new SQL_grammarLexer(new ANTLRStringStream(testQuery));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SQL_grammarParser parser = new SQL_grammarParser(tokens);
		CommonTree ast;
		try {
			ast = (CommonTree) parser.query().tree;
			System.out.println("parser.hasError():" + parser.hasError());
			System.out.println("parser.getNumberOfSyntaxErrors():" + parser.getNumberOfSyntaxErrors()
					+ " parser.getErrorMessage():" + parser.getErrorMessage());
			System.out.println("ast.toStringTree():" + ast.toStringTree());
			System.out.println("print(\"\", ast):" + print("", ast));
		} catch (Exception e) {
			System.out.println("e.getMessage():" + e.getMessage());
			e.printStackTrace();
		}
	}

	static String print(String whitespace, Tree ast) {
		String str = "";
		str += whitespace + ast;
		str += "\n";
		if (ast.getChildCount() > 0)
			for (int childIndex = 0; childIndex < ast.getChildCount(); childIndex++) {
				str += print(whitespace + "   ", ast.getChild(childIndex));
			}
		return str;
	}
}