package nl.han.ica.icss.parser;

import nl.han.ica.icss.ast.AST;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTBuilder extends ICSSBaseListener {
	
	//INCOMPLETE!
	public AST getAST() {
		return new AST();
	}
}