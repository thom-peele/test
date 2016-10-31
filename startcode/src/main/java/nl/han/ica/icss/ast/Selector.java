package nl.han.ica.icss.ast;

/*
 * Selectors define the selection of DOM nodes that a ruleset applies.
 * Examples are: 'h1', '.even', 'a.selected', 'a:hover', 'div#main'
 */
public class Selector {
	public String tag;
	public String cls;  //class
	public String id;
	public String pseudo;

	public Selector() {
	}
}
