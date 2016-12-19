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
	public ArrayList<Ruleset> rulesets;
	public Stylesheet() {
		declarations = new ArrayList<Declaration>();
		assignments = new ArrayList<Assignment>();
		rulesets = new ArrayList<Ruleset>();
	}
	public void addToken(Token t) {

	}





}
