package nl.han.ica.icss.ast;

import java.util.ArrayList;

public class Ruleset extends Statement {
	
	private Selector selector;
	private ArrayList<Declaration> declarations;

	public Ruleset(Selector selector) {
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
