package nl.han.ica.icss.parser;

import nl.han.ica.icss.ast.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Objects;

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
		System.out.println(test.getSymbol().getText());
	}

	public void visitTerminal(TerminalNode test) {
		System.out.println(test.getSymbol().getText());
	}

	public void enterEveryRule(ParserRuleContext ctx) {
		System.out.println(ctx.getText());
	}

	@Override public void enterStylesheet( ICSSParser.StylesheetContext ctx) {


	}

	@Override public void enterAssignment(ICSSParser.AssignmentContext ctx) {
		for (ParseTree parseTree : ctx.value().children) {
			if (Objects.equals(parseTree.getClass().getName(), "nl.han.ica.icss.parser.ICSSParser$ColorContext")) {
				ast.root.assignments.add(new Assignment(new ConstantIdentifier(ctx.constantIdentifier().getText()), new Color(parseTree.getText())));
			}
		}
	}

	@Override public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
		System.out.println("variable: " + ctx.getText() + " property: " + ctx.property().getText());
//		System.out.println(ctx.value().children);
		for (ParseTree parseTree: ctx.value().children){
			System.out.println(parseTree.getClass().getName());
			ast.root.statements.add(new Declaration(ctx.property().getText(), addValue(parseTree)));


		}
//		ast.root.statements.add(new Declaration(ctx.property().getText(), ctx.value().getText()));
		System.out.println("ast " + ast.root.statements.get(0).getProperty());


	}

	private Value addValue(ParseTree parseTree) {
		switch (parseTree.getClass().getName()) {
			case "nl.han.ica.icss.parser.ICSSParser$ConstantIdentifierContext" :
				for(Assignment assignment : ast.root.assignments) {
					if(assignment.name.equals(parseTree.getText())) {
						return assignment.value;
					}
				}

				System.out.println("hoi");
				break;
		}
		return null;
	}

}