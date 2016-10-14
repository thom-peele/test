package nl.han.ica.icss.parser;

import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.Stylesheet;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTBuilder extends ICSSBaseListener {
	AST ast;
	//INCOMPLETE!
	public ASTBuilder() {
		ast = new AST(new Stylesheet());
	}

	public AST getAST() {
		return ast;
	}

	public void visitErrorNode(ErrorNode test) {
		System.out.println(test.getSymbol().getText());
	}

	public void visitTerminal(TerminalNode test) {
		System.out.println(test.getSymbol().getText());
	}

	public void enterEveryRule(ParserRuleContext ctx) {

	}
}