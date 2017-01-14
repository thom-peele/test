package nl.han.ica.icss.parser;

import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.ast.Assignment;
import nl.han.ica.icss.ast.ConstantIdentifier;
import nl.han.ica.icss.ast.Declaration;
import nl.han.ica.icss.ast.Literal;
import nl.han.ica.icss.ast.RuleSet;
import nl.han.ica.icss.ast.Selector;
import nl.han.ica.icss.ast.Stylesheet;
import nl.han.ica.icss.ast.Value;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTBuilder extends ICSSBaseListener {
    AST ast;

    //INCOMPLETE!
    public ASTBuilder() {
        ast = new AST(new Stylesheet());
    }

    public AST getAST() {
        return ast;
    }

    public void visitErrorNode(ErrorNode test) {
//		System.out.println(test.getSymbol().getText());
    }

    public void visitTerminal(TerminalNode test) {
//		System.out.println(test.getSymbol().getText());
    }

    public void enterEveryRule(ParserRuleContext ctx) {
//		System.out.println(ctx.getText());
    }

    @Override
    public void enterStylesheet(ICSSParser.StylesheetContext ctx) {


    }

    @Override
    public void enterRuleSet(ICSSParser.RuleSetContext ctx) {
        System.out.println(ctx);
        if (ctx.getChildCount() > 2) {
            Selector selector = new Selector();
            selector.setTag(ctx.selector().getText());
            RuleSet ruleSet = new RuleSet(selector);
            ArrayList<Declaration> declarations = new ArrayList<Declaration>();
            for (ParseTree parseTree : ctx.children) {
                if (parseTree.getChildCount() == 4) {
                    declarations.add(new Declaration(parseTree.getChild(0).getText(), addValue(parseTree.getChild(2).getChild(0))));
                    System.out.println(parseTree);
                }
//				declarations.add();
            }
            ruleSet.setDeclarations(declarations);
            ast.getRoot().getRuleSets().add(ruleSet);
        }
    }

    @Override
    public void enterAssignment(ICSSParser.AssignmentContext ctx) {
        for (ParseTree parseTree : ctx.value().children) {
            boolean assignmentExists = false;
            for(Assignment assignment : ast.getRoot().getAssignments()) {
                if(assignment.getConstantName().getName().equals(parseTree.getText())) {
                    assignment.setValue(addValue(parseTree));
                    assignmentExists = true;
                }
            }
            if(!assignmentExists) {
                ast.getRoot().getAssignments().add(new Assignment(new ConstantIdentifier(ctx.constantIdentifier().getText()), addValue(parseTree)));
            }
            System.out.println("added new assignment: " + ctx.constantIdentifier().getText() + " with value: " + addValue(parseTree));

        }
    }

    @Override
    public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
        for (ParseTree parseTree : ctx.value().children) {
            ast.getRoot().getDeclarations().add(new Declaration(ctx.property().getText(), addValue(parseTree)));
            System.out.println("added new declaration: " + ctx.property().getText() + " with value: " + addValue(parseTree));
        }
    }

    private Value addValue(ParseTree parseTree) {


        /* todo: clean up this piece of code. probably still useful though */
		switch (parseTree.getClass().getName()) {
			case "nl.han.ica.icss.parser.ICSSParser$ConstantIdentifierContext" :
				for(Assignment assignment : ast.getRoot().getAssignments()) {
                    if(assignment.getConstantName().getName().equals(parseTree.getText())) {
						return assignment.getValue();
					}
				}
                Assignment assignment = new Assignment(new ConstantIdentifier(parseTree.getText()), null);
                ast.getRoot().getAssignments().add(assignment);
				return new Literal(parseTree.getText());
//				break;
//			case "nl.han.ica.icss.parser.ICSSParser$ColorContext":
//				return new Color(parseTree.getText());
//			case "nl.han.ica.icss.parser.ICSSParser$SizeContext":
//				return new Size(Integer.parseInt(parseTree.getChild(0).getText()),parseTree.getChild(1).getText());
//			case "nl.han.ica.icss.parser.ICSSParser$NumberContext":
//				return new Number(Integer.parseInt(parseTree.getText()));
//			case "nl.han.ica.icss.parser.ICSSParser$StringValueContext":
//				return new StringValue(parseTree.getText());
		}
        return new Literal(parseTree.getText());
//		return null;
    }

}