package nl.han.ica.icss.gui;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

@SuppressWarnings("restriction")
public class InputPane extends BorderPane {
    private TextArea content;
    private Label title;

    public InputPane() {
        super();

        title = new Label("Input (icss):");
        content = new TextArea();
        title.setPadding(new Insets(5, 5, 5, 5));

        this.setTop(title);
        this.setCenter(content);

        //Set content
        StringBuilder demo = new StringBuilder();
        demo.append("$height: 300px;\n\n");
        demo.append("div {\n");
        demo.append("\tbackground-color: $bgcolor;\n");
        demo.append("\twidth: 100px;\n");
        demo.append("\theight: $height;\n");
        demo.append("}\n\n");
        demo.append("$bgcolor: #f0f;\n\n");
        demo.append("$bgcolor: red;\n\n");
        demo.append("$fontcolor: green;\n\n");
        demo.append("$textsize: 20px;\n\n");
        demo.append("$width: 50px;\n\n");
        demo.append("h {\n\n");
        demo.append("\tcolor: $fontcolor;\n");
        demo.append("\tfont-size: $textsize;\n");
        demo.append("\twidth: $width;\n");
        demo.append("}\n\n");

        content.setText(demo.toString());

    }

    public void setTextFromFile(File file) {
        try {
            this.setText(new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset()));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public String getText() {
        return content.getText();
    }

    public void setText(String text) {
        this.content.setText(text);
    }
}
