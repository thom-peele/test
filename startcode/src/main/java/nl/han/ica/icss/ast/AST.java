package nl.han.ica.icss.ast;

public class AST {
	public Stylesheet root;

	public AST(Stylesheet root) {
		this.root = root;
	}

	public void simplify() {
	}
	public void optimize() {
	}

	@Override
	public String toString() {
		if(root != null) {
			return root.toString();
		}
		return null;
	}
}
