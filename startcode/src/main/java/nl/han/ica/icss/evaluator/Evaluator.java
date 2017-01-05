package nl.han.ica.icss.evaluator;

import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.Assignment;
import nl.han.ica.icss.ast.ConstantIdentifier;
import nl.han.ica.icss.ast.Declaration;
import nl.han.ica.icss.ast.Literal;
import nl.han.ica.icss.ast.RuleSet;
import nl.han.ica.icss.ast.Selector;
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
    private AST ast;

    public Evaluator(Document doc) {
        this.doc = doc;
    }

    public void eval(AST ast) {
        this.ast = ast;
        //Example:
        evalStylesheet(ast.getRoot());
    }

    //Basic pattern: implement an eval* method for every node in the AST
    //(Not every one is necessary, and not all are necessarily void)
    public void evalStylesheet(Stylesheet node) {
        for (RuleSet ruleSet : node.getRuleSets()) {
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
        Value value = declaration.getValue();
        if (declaration.getValue().toString().startsWith("$")) {
            for (Assignment assignment : ast.getRoot().getAssignments()) {
                if (declaration.getValue().toString().equals(assignment.getConstantName().getName())) {
                    value = assignment.getValue();
                }
            }
        }

        switch (declaration.getProperty()) {
            case "background-color":
                PreviewPane.setBackgroundColor(value.toString(), node2, doc);
                break;
            case "height":
//                Size height = (Size) declaration.getValue();
//                PreviewPane.setHeight(String.valueOf(height.getNumber()), node2, doc);
                PreviewPane.setWidth(value.toString(), node2, doc);
                break;
            case "width":
//                Size width = (Size) declaration.getValue();
//                PreviewPane.setWidth(String.valueOf(width.getNumber()), node2, doc);
                PreviewPane.setWidth(value.toString(), node2, doc);
                break;
            case "color":
                PreviewPane.setColor(value.toString(), node2, doc);
                break;
            case "font-size":
                PreviewPane.setFontSize(value.toString(), node2, doc);
                break;
        }
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
        if (sel.getTag() != null) {
            NodeList nodes = doc.getElementsByTagName(sel.getTag());
            for (int i = 0; i < nodes.getLength(); i++) {
                selection.add(nodes.item(i));
            }
        }
        return selection;
    }
}
