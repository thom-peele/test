package nl.han.ica.icss.gui;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebView;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@SuppressWarnings("restriction")
public class PreviewPane extends BorderPane {

	private Label title;
	private WebView webview;
	private TextArea source;
	
	public PreviewPane() {
		super();

		title = new Label("Preview:");
		title.setPadding(new Insets(0, 0, 5, 0));
	
		//Layout content
		TabPane tabs = new TabPane();
		Tab webviewTab, sourceTab;
	
		webview = new WebView();
		webviewTab = new Tab();
		webviewTab.setText("Rendering");
		webviewTab.setClosable(false);
		webviewTab.setContent(webview);
		
		source = new TextArea();
		source.setEditable(false);
		sourceTab = new Tab();
		sourceTab.setText("Source");
		sourceTab.setClosable(false);
		sourceTab.setContent(source);		
	
		tabs.getTabs().addAll(webviewTab,sourceTab);
		this.setTop(title);
		this.setCenter(tabs);
		this.setPadding(new Insets(5, 5, 5, 5));
	
		//Load example content
		setHtml("<div class=\"example\"><h1>Hello ICSS Studio</h1></div>");
	}
	
	public void setHtml(String html) {
		webview.getEngine().loadContent(html);
		source.setText(html);	
	}
	public void setHtmlFromFile(File file) {
		try {
			this.setHtml(new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset()));
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public Document getDocument() {
		return webview.getEngine().getDocument();
	}
	
	//API FOR SETTING ATTRIBUTES IN THE PREVIEW DOCUMENT
	
	//Utility functions for manipulating the document
	public static void setColor(String color, Node node, Document doc) {
		setProperty("color",color,node,doc);
	}
	public static void setBackgroundColor(String color, Node node, Document doc) {
		setProperty("background-color",color,node,doc);
	}
	public static void setFontSize(String size, Node node, Document doc) {
		setProperty("font-size",size,node,doc);
	}
	public static void setWidth(String width, Node node, Document doc) {
		setProperty("width",width,node,doc);
	}
	public static void setHeight(String width, Node node, Document doc) {
		setProperty("height",width,node,doc);
	}
	
	private static void setProperty(String property,String value, Node node, Document doc) {
		//Note: For this exercise we actually use normal css properties to implement
		//the API. We could also implement the samen property based API for other DOM
		//implementations that don't have built-in css rendering.
		Attr styleAttr = (Attr) node.getAttributes().getNamedItem("style");
		if(styleAttr == null) {
			styleAttr = doc.createAttribute("style");
			styleAttr.setValue(property + ": " + value);
		} else {
			styleAttr.setValue(styleAttr.getValue() + "; " + property + ": " + value);
		}
		node.getAttributes().setNamedItem(styleAttr);
	}
}
