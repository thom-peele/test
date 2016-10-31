package nl.han.ica.icss.ast;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
/**
 * A stylesheet is the root node of the AST, it consists of one or more statements
 *
 */
public class Stylesheet {
	public ArrayList<Declaration> statements;
	public ArrayList<Assignment> assignments;
	public Stylesheet() {
		statements = new ArrayList<Declaration>();
		assignments = new ArrayList<Assignment>();
	}
	public void addToken(Token t) {

	}





}
