package nl.han.ica.icss.ast;

/**
 * A literal is a value that is defined in the ICSS code. Examples are '#f00', 'pink' or '42px'
 */
public class Literal extends Value {
	private String text;

	public Literal(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
