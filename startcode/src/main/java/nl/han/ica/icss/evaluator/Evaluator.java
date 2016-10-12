package nl.han.ica.icss.evaluator;

import java.util.ArrayList;

import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.Assignment;
import nl.han.ica.icss.ast.ConstantIdentifier;
import nl.han.ica.icss.ast.Declaration;
import nl.han.ica.icss.ast.Literal;
import nl.han.ica.icss.ast.Ruleset;
import nl.han.ica.icss.ast.Selector;
import nl.han.ica.icss.ast.Statement;
import nl.han.ica.icss.ast.Stylesheet;
import nl.han.ica.icss.ast.Value;
import nl.han.ica.icss.gui.PreviewPane;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Evaluator {
	private Document doc;
	
	public Evaluator(Document doc) {
		this.doc = doc;
	}
	
	public void eval(AST ast) {
		//Example:
		Selector sel = new Selector();
		sel.tag = "h1";
		
		for(Node node : this.select(sel,doc)) {
			PreviewPane.setColor("pink",node,doc);
			PreviewPane.setFontSize("30px", node, doc);
		}
	}
	//Basic pattern: implement an eval* method for every node in the AST
	//(Not every one is necessary, and not all are necessarily void)
	public void evalStylesheet(Stylesheet node) {
	}
	public void evalStatement(Statement node) {
	}
	public void evalRuleset(Ruleset node) {	
	}
	public void evalSelector(Selector node) {	
	}
	public void evalDeclaration(Declaration node) {	
	}
	public String evalValue(Value node) {	
		return null;
	}
	public String evalLiteral(Literal node) {
		return null;
	}
	public void evalConstantIdentifier(ConstantIdentifier node) {
	}
	public void evalAssignment(Assignment node) {
	}
	//INCOMPLETE!
	private ArrayList<Node> select(Selector sel, Document doc) {
		ArrayList<Node> selection = new ArrayList<>();
		if(sel.tag != null) {
			NodeList nodes = doc.getElementsByTagName(sel.tag);
			for(int i = 0; i < nodes.getLength(); i++) {
				selection.add(nodes.item(i));
			}
		}
		return selection;
	}
}
