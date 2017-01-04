package nl.han.ica.icss.evaluator;

import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.Assignment;
import nl.han.ica.icss.ast.ConstantIdentifier;
import nl.han.ica.icss.ast.Declaration;
import nl.han.ica.icss.ast.Literal;
import nl.han.ica.icss.ast.RuleSet;
import nl.han.ica.icss.ast.Selector;
import nl.han.ica.icss.ast.Size;
import nl.han.ica.icss.ast.Statement;
import nl.han.ica.icss.ast.Stylesheet;
import nl.han.ica.icss.ast.Value;
import nl.han.ica.icss.gui.PreviewPane;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Evaluator {
    private Document doc;

    public Evaluator(Document doc) {
        this.doc = doc;
    }

    public void eval(AST ast) {
        //Example:
        evalStylesheet(ast.root);
    }

    //Basic pattern: implement an eval* method for every node in the AST
    //(Not every one is necessary, and not all are necessarily void)
    public void evalStylesheet(Stylesheet node) {
        for (RuleSet ruleSet : node.ruleSets) {
            evalRuleSet(ruleSet);
        }
    }

    public void evalStatement(Statement node) {
    }

    public void evalRuleSet(RuleSet ruleSet) {
        for (Node node2 : this.select(ruleSet.getSelector(), doc)) {
            for (Declaration declaration : ruleSet.getDeclarations()) {
                evalDeclaration(declaration, node2);
            }
        }
    }

    public void evalSelector(Selector node) {
    }

    public void evalDeclaration(Declaration declaration, Node node2) {
        switch (declaration.getProperty()) {
            case "background-color":
                PreviewPane.setBackgroundColor(declaration.getValue().toString(), node2, doc);
                break;
            case "height":
                Size height = (Size) declaration.getValue();
                PreviewPane.setHeight(String.valueOf(height.getNumber()), node2, doc);
                break;
            case "width":
                Size width = (Size) declaration.getValue();
                PreviewPane.setWidth(String.valueOf(width.getNumber()), node2, doc);
                break;
        }
//        PreviewPane.setWidth("100", node2, doc);
//        PreviewPane.setColor("pink", node2, doc);
//        PreviewPane.setFontSize("30px", node2, doc);
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
        if (sel.tag != null) {
            NodeList nodes = doc.getElementsByTagName(sel.tag);
            for (int i = 0; i < nodes.getLength(); i++) {
                selection.add(nodes.item(i));
            }
        }
        return selection;
    }
}
