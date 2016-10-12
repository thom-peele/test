package nl.han.ica.icss.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nl.han.ica.icss.ast.AST;
import nl.han.ica.icss.checker.Checker;
import nl.han.ica.icss.checker.SemanticError;
import nl.han.ica.icss.evaluator.Evaluator;
import nl.han.ica.icss.generator.Generator;
import nl.han.ica.icss.parser.ASTBuilder;
import nl.han.ica.icss.parser.ICSSLexer;
import nl.han.ica.icss.parser.ICSSParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;

@SuppressWarnings("restriction")
public class Main extends Application implements ANTLRErrorListener {

	//UI Components
	private InputPane inputPane;
	private PreviewPane previewPane;
	private OutputPane outputPane;
	private FeedbackPane feedbackPane;

	public static void main(String[] args) throws IOException {
		launch(args);
	}
	@Override
	public void start(Stage stage) {
		//Setup UI
		stage.setTitle("ICSS Tool");

		inputPane = new InputPane();
		previewPane = new PreviewPane();
		outputPane = new OutputPane();
		feedbackPane = new FeedbackPane();
		
		//Reference for the callbacks
		final Main me = this;
		
		//Create Update button
		Button processButton = new Button("Process!");
		processButton.setOnAction(new EventHandler<ActionEvent>() { 	 
			@Override
			public void handle(ActionEvent e) {
				me.process();
			}
		});
		
		//Create menus
		MenuBar menuBar = new MenuBar();
		
		Menu fileMenu = new Menu("File");
		MenuItem loadInput = new MenuItem("Load input ICSS...");
		loadInput.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open input ICSS...");
				fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("ICSS", "*.icss"));

				File file = fileChooser.showOpenDialog(stage);
				if(file != null) {
					inputPane.setTextFromFile(file);
				}
			}
		});
		
		MenuItem loadHtml = new MenuItem("Load preview HTML...");
		loadHtml.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Open preview HTML...");
				fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML", "*.html"));

				File file = fileChooser.showOpenDialog(stage);
				if(file != null) {
					previewPane.setHtmlFromFile(file);
				}
			}
		});
		
		MenuItem saveOutput = new MenuItem("Save generated CSS...");
		saveOutput.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				//Create file dialog
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Save generated CSS...");
				fileChooser.setInitialFileName("output.css");

				File file = fileChooser.showSaveDialog(stage);
				if (file != null) {
					outputPane.writeToFile(file);
				}
			}
		});
		
		MenuItem quit = new MenuItem("Quit");
		quit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Platform.exit();
			}
		});
		
		fileMenu.getItems().addAll(loadInput,loadHtml,new SeparatorMenuItem(),
				saveOutput,new SeparatorMenuItem(),quit);
		menuBar.getMenus().addAll(fileMenu);
		
		//Layout components
		BorderPane main = new BorderPane();
		
		HBox center = new HBox();
		center.getChildren().addAll(inputPane,previewPane,outputPane);
		
		BorderPane toolBar = new BorderPane();
		//toolBar.setAlignment(Pos.BASELINE_LEFT);
		toolBar.setPadding(new Insets(10, 10, 10, 10));
		toolBar.setLeft(processButton);
		toolBar.setCenter(feedbackPane);
		//toolBar.getChildren().addAll(processButton,feedbackPane);
		
		main.setTop(menuBar);
		main.setCenter(center);
		main.setBottom(toolBar);
	
		Scene scene = new Scene(main, 1200, 600);
		
		stage.setScene(scene);
		stage.show();
	}
	
	private void process() {
		feedbackPane.clear();
		
		//Create and execute the pipeline
		feedbackPane.addLine("Parsing...");
		//Lex (with Antlr's generated lexer)
		ANTLRInputStream inputStream = new ANTLRInputStream(inputPane.getText());
		ICSSLexer lexer = new ICSSLexer(inputStream);
		lexer.addErrorListener(this);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		//Parse (with Antlr's generated parser)
		ICSSParser parser = new ICSSParser(tokens);
		parser.addErrorListener(this);
		ParseTree parseTree = parser.stylesheet();
		
		//Extract AST from the Antlr parse tree
		feedbackPane.addLine("Building AST...");
		ASTBuilder builder = new ASTBuilder();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(builder,parseTree);
		feedbackPane.addLine(parseTree.getText());
		AST ast = builder.getAST();
		
		//Checking
		feedbackPane.addLine("Checking...");
		Checker checker = new Checker();
		
		ArrayList<SemanticError> errors = checker.check(ast);
		if(!errors.isEmpty()) {
			for(SemanticError e : errors) {
				feedbackPane.addLine(e.toString());
			}
		}
		
		//Evaluate to preview
		feedbackPane.addLine("Rendering preview...");
		Evaluator evaluator = new Evaluator(previewPane.getDocument());
		evaluator.eval(ast);
	
		feedbackPane.addLine("Generating output...");
		
		//Simplify & optimize
		ast.simplify();
		ast.optimize();
		
		//Generate output
		Generator generator = new Generator();
		outputPane.setText(generator.generate(ast));
	}
	
	//Handle ANTLR errors
	@Override
	public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3,
			boolean arg4, BitSet arg5, ATNConfigSet arg6) {
	}
	@Override
	public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2,
			int arg3, BitSet arg4, ATNConfigSet arg5) {
	}
	@Override
	public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2,
			int arg3, int arg4, ATNConfigSet arg5) {
	}
	@Override
	public void syntaxError(Recognizer<?, ?> arg0, Object arg1, int arg2,
			int arg3, String arg4, RecognitionException arg5) {
		feedbackPane.addLine(arg5.toString());
	}
}
