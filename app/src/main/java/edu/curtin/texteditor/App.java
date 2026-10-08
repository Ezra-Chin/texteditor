package edu.curtin.texteditor;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;


/**
 * Example code for setting up a JavaFX GUI.
 */
public class App extends Application
{
    public static final int FONT_SIZE = 20;
    private TextArea textArea = new TextArea();
    private LoadSaveUI loadSaveUI;
    private ApiImpl api;

    public static void main(String[] args)
    {
        Locale locale;
        if (args.length > 0){
            locale = new Locale(args[0]);
        }else{
            locale = Locale.getDefault();
        }


        Locale.setDefault(locale);
        Application.launch(args);
    }




    @Override
    public void start(Stage stage)
    {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("bundle" , locale );
        api = new ApiImpl(locale);


        loadSaveUI = new LoadSaveUI(stage, textArea, new FileIO(), bundle);
        stage.setTitle(bundle.getString("title"));
        stage.setMinWidth(800);
        stage.setMinHeight(600);

        // Create toolbar
        Button openButton = new Button(bundle.getString("open_button") );
        Button saveButton = new Button(bundle.getString("save_button"));
        Button pluginButton = new Button(bundle.getString("plugins_button"));
        ToolBar toolBar = new ToolBar(openButton, saveButton, pluginButton);

        // Subtle user experience tweaks
        toolBar.setFocusTraversable(false);
        toolBar.getItems().forEach(btn -> btn.setFocusTraversable(false));
        textArea.setStyle(String.format(
            "-fx-font-family: 'monospace'; -fx-font-size: %d;",
            FONT_SIZE)); // Set the font

        // Add the main parts of the UI to the window.
        BorderPane mainBox = new BorderPane();
        mainBox.setTop(toolBar);
        mainBox.setCenter(textArea);
        Scene scene = new Scene(mainBox);

        // Button event handlers.
        openButton.setOnAction(event -> loadSaveUI.open());
        saveButton.setOnAction(event -> loadSaveUI.save());
        pluginButton.setOnAction(event -> toolBar.getItems().add(new Button("ButtonN")));

        // TextArea event handlers & caret positioning.
        textArea.textProperty().addListener((object, oldValue, newValue) ->
        {
            System.out.println("caret position is " + textArea.getCaretPosition() +
                               "; text is\n---\n" + newValue + "\n---\n");
        });


        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

}