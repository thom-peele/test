package nl.han.ica.icss.ast;

/*
 * Selectors define the selection of DOM nodes that a ruleSet applies.
 * Examples are: 'h1', '.even', 'a.selected', 'a:hover', 'div#main'
 */
public class Selector {
	private String tag;
	private String cls;  //class
	private String id;
	private String pseudo;

	public Selector() {
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}
