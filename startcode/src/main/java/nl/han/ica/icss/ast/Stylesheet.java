package nl.han.ica.icss.ast;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
/**
 * A stylesheet is the root node of the AST, it consists of one or more declarations
 *
 */
public class Stylesheet {
	public ArrayList<Declaration> declarations;
	public ArrayList<Assignment> assignments;
	public ArrayList<RuleSet> ruleSets;
	public Stylesheet() {
		declarations = new ArrayList<Declaration>();
		assignments = new ArrayList<Assignment>();
		ruleSets = new ArrayList<RuleSet>();
	}
	public void addToken(Token t) {

	}

	@Override
	public String toString() {
		String returnString = new String();

		if(declarations != null && !declarations.isEmpty()) {
			returnString += "declarations: ";
			for(Declaration declaration : declarations) {
				returnString += declaration.toString();
			}
		}
		return null;
	}





}
