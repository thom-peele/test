package nl.han.ica.icss.ast;

/**
 * A Declaration defines a style property. Declarations are things like "width: 100px"
 */
public class Declaration extends Statement  {
	private String property;
	private Value value;


	public Declaration(String property, Value value) {
		this.property = property;
		this.value = value;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
}
