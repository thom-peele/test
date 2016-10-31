package nl.han.ica.icss.parser;

import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.Number;
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

	@Override public void enterStylesheet( ICSSParser.StylesheetContext ctx) {


	}

	@Override public void enterRuleset(ICSSParser.RulesetContext ctx) {
		System.out.println(ctx);
		if(ctx.getChildCount()>2) {
			Selector selector = new Selector();
			selector.tag = ctx.selector().getText();
			Ruleset ruleset = new Ruleset(selector);
			ArrayList<Declaration> declarations = new ArrayList<Declaration>();
			for (ParseTree parseTree : ctx.children) {
				if(parseTree.getChildCount() == 4) {
					System.out.println(parseTree);
				}
//				declarations.add();
			}
			ruleset.setDeclarations(declarations);
			ast.root.rulesets.add(ruleset);
		}
	}

	@Override public void enterAssignment(ICSSParser.AssignmentContext ctx) {
		for (ParseTree parseTree : ctx.value().children) {
			ast.root.assignments.add(new Assignment(new ConstantIdentifier(ctx.constantIdentifier().getText()), addValue(parseTree)));
			System.out.println("added new assignment: " + ctx.constantIdentifier().getText() + " with value: " + addValue(parseTree));

		}
	}

	@Override public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
		for (ParseTree parseTree: ctx.value().children){
			ast.root.declarations.add(new Declaration(ctx.property().getText(), addValue(parseTree)));
			System.out.println("added new declaration: " + ctx.property().getText() + " with value: " + addValue(parseTree));
		}
	}

	private Value addValue(ParseTree parseTree) {
		switch (parseTree.getClass().getName()) {
			case "nl.han.ica.icss.parser.ICSSParser$ConstantIdentifierContext" :
				for(Assignment assignment : ast.root.assignments) {
					if(assignment.name.getName().equals(parseTree.getText())) {
						return assignment.value;
					}
				}
				break;
			case "nl.han.ica.icss.parser.ICSSParser$ColorContext":
				return new Color(parseTree.getText());
			case "nl.han.ica.icss.parser.ICSSParser$SizeContext":
				return new Size(Integer.parseInt(parseTree.getChild(0).getText()),parseTree.getChild(1).getText());
			case "nl.han.ica.icss.parser.ICSSParser$NumberContext":
				return new Number(Integer.parseInt(parseTree.getText()));
			case "nl.han.ica.icss.parser.ICSSParser$StringValueContext":
				return new StringValue(parseTree.getText());
		}
		return null;
	}

}