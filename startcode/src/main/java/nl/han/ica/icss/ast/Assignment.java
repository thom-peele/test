package nl.han.ica.icss.ast;

/**
 * An assignment binds a value to an identifier.
 *
 */
public class Assignment extends Statement {
	
	private ConstantIdentifier constantName;
	private Value value;

	public Assignment(ConstantIdentifier constantName, Value value) {
		this.constantName = constantName;
		this.value = value;
	}

	public ConstantIdentifier getConstantName() {
		return constantName;
	}

	public void setConstantName(ConstantIdentifier constantName) {
		this.constantName = constantName;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
}
