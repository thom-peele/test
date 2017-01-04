package nl.han.ica.icss.ast;

import java.util.ArrayList;

/**
 * A selector with declarations.
 * for example: a div selector with a width and height.
 */
public class RuleSet extends Statement {
	
	private Selector selector;
	private ArrayList<Declaration> declarations;

	public RuleSet(Selector selector) {
		this.selector = selector;
	}

	public Selector getSelector() {
		return selector;
	}

	public void setSelector(Selector selector) {
		this.selector = selector;
	}

	public ArrayList<Declaration> getDeclarations() {
		return declarations;
	}

	public void setDeclarations(ArrayList<Declaration> declarations) {
		this.declarations = declarations;
	}
}
