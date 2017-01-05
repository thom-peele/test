package nl.han.ica.icss.ast;

public class AST {
	private Stylesheet root;

	public AST(Stylesheet root) {
		this.root = root;
	}

	public void simplify() {
	}
	public void optimize() {
	}

	public Stylesheet getRoot() {
		return root;
	}

	public void setRoot(Stylesheet root) {
		this.root = root;
	}

	@Override
	public String toString() {
		if(root != null) {
			return root.toString();
		}
		return null;
	}
}
