package nl.han.ica.icss.ast;

/**
 * An assignment binds a value to an identifier.
 *
 */
public class Assignment extends Statement {
	
	public ConstantIdentifier name;
	public Value value;

	public Assignment(ConstantIdentifier name, Value value) {
		this.name = name;
		this.value = value;
	}
}
