package nl.han.ica.icss.ast;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

/**
 * A stylesheet is the root node of the AST, it consists of one or more declarations
 */
public class Stylesheet {
    private ArrayList<Declaration> declarations;
    private ArrayList<Assignment> assignments;
    private ArrayList<RuleSet> ruleSets;

    public Stylesheet() {
        declarations = new ArrayList<Declaration>();
        assignments = new ArrayList<Assignment>();
        ruleSets = new ArrayList<RuleSet>();
    }

    public void addToken(Token t) {

    }

    public ArrayList<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(ArrayList<Declaration> declarations) {
        this.declarations = declarations;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<RuleSet> getRuleSets() {
        return ruleSets;
    }

    public void setRuleSets(ArrayList<RuleSet> ruleSets) {
        this.ruleSets = ruleSets;
    }

    @Override
    public String toString() {
        String returnString = new String();

        if (declarations != null && !declarations.isEmpty()) {
            returnString += "declarations: ";
            for (Declaration declaration : declarations) {
                returnString += declaration.toString();
            }
        }
        return null;
    }


}
