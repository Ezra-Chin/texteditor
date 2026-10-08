package edu.curtin.texteditor;

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

    public static void main(String[] args)
    {
        Application.launch(args);
    }




    @Override
    public void start(Stage stage)
    {
        loadSaveUI = new LoadSaveUI(stage, textArea, new FileIO());
        stage.setTitle("Not So Silly Window No More");
        stage.setMinWidth(800);
        stage.setMinHeight(600);

        // Create toolbar
        Button openButton = new Button("Open");
        Button saveButton = new Button("Save");
        Button pluginButton = new Button("Plugins");
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

        textArea.setText("This is some\ndemonstration text\nTry pressing F1, ctrl+b, ctrl+shift+b or alt+b.");
        textArea.selectRange(8, 16); // Select a range of text (and move the caret to the end)

        // Example global keypress handler.
        scene.setOnKeyPressed(keyEvent ->
        {
            // See the documentation for the KeyCode class to see all the available keys.

            KeyCode key = keyEvent.getCode();
            boolean ctrl = keyEvent.isControlDown();
            boolean shift = keyEvent.isShiftDown();
            boolean alt = keyEvent.isAltDown();

            if(key == KeyCode.F1)
            {
                new Alert(Alert.AlertType.INFORMATION, "You pressed F1.", ButtonType.OK).showAndWait();
            }
            else if(ctrl && shift && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "Your pressed ctrl+shift+B.", ButtonType.OK).showAndWait();
            }
            else if(ctrl && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "You pressed ctrl+B.", ButtonType.OK).showAndWait();
            }
            else if(alt && key == KeyCode.B)
            {
                new Alert(Alert.AlertType.INFORMATION, "You pressed alt+b.", ButtonType.OK).showAndWait();
            }
        });

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

}