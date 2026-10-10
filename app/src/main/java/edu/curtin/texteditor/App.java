package edu.curtin.texteditor;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
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

        PluginServiceImpl api = new PluginServiceImpl(locale, bundle, textArea, toolBar, scene);
        PluginLoader pluginLoader = new PluginLoader(api);
        PluginDialog pluginDialog = new PluginDialog(pluginLoader , stage, bundle);

        pluginButton.setOnAction(event -> pluginDialog.show());




        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
       





    }

}