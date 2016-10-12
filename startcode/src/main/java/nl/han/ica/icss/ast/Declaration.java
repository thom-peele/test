package nl.han.ica.icss.ast;

/*
 * A Declaration defines a style property. Declarations are things like "width: 100px"
 */
public class Declaration extends Statement  {
	private String property;
	private Value value;
}
