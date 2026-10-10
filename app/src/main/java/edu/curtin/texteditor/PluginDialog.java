package edu.curtin.texteditor;

import edu.curtin.texteditor.api.Plugin;
import edu.curtin.texteditor.api.PluginService;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.jar.JarFile;

import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class PluginDialog {
    private PluginLoader pluginLoader;
    private Stage stage;
    private ResourceBundle bundle;
    private Dialog<Void> dialog;
    private FileChooser fileChooser = new FileChooser();
    private ListView<String> loadedList = new ListView<>();

    public PluginDialog(PluginLoader pluginLoader, Stage stage, ResourceBundle bundle) {
        this.pluginLoader = pluginLoader;
        this.stage = stage;
        this.bundle = bundle;
    }

    private void refreshList() {
        loadedList.getItems().setAll(pluginLoader.getLoadedNames());
    }

    public void show() {
        System.out.println("Pressed");
        // https://docs.oracle.com/en/java/java-components/javafx/21/docs/javafx.controls/javafx/scene/control/Dialog.html6
        if (dialog == null) {
            Button jarButton = new Button(bundle.getString("button_load_jar"));
            Button scriptButton = new Button(bundle.getString("button_load_script"));
            Button classButton = new Button(bundle.getString("button_load_class"));
            classButton.setOnAction(event -> loadClass());
            jarButton.setOnAction(event -> loadJar());
            scriptButton.setOnAction(event -> loadScript());

            // https://docs.oracle.com/en/java/java-components/javafx/27/docs/javafx.graphics/javafx/scene/layout/VBox.html
            VBox content = new VBox(8, new Label(bundle.getString("label_loaded")), loadedList,
                    new HBox(8, jarButton, scriptButton));

            dialog = new Dialog<>();
            dialog.initOwner(stage);
            dialog.setTitle(bundle.getString("dialog_plugins_title"));
            dialog.getDialogPane().setContent(content);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        }
        dialog.showAndWait();
    }

    private void loadScript() {
        fileChooser.setTitle(bundle.getString("dialog_script_title"));
        fileChooser.getExtensionFilters().setAll(
                new FileChooser.ExtensionFilter(
                        bundle.getString("filter_script"), "*.groovy"));

        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            try {

                pluginLoader.loadScript(file);
                refreshList();
            } catch (ClassCastException e) {

                Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to load JAR ", ButtonType.CLOSE);
                alert.initOwner(stage);
                alert.showAndWait();

            }

        }
    }

    private void loadClass() {
        TextInputDialog input = new TextInputDialog();
        input.initOwner(stage);
        input.setTitle(bundle.getString("dialog_class_title"));
        input.setHeaderText(null);
        input.setContentText(bundle.getString("label_class_name"));
        input.showAndWait().ifPresent(name -> {
                pluginLoader.loadByClassName(name.trim());
                refreshList();
        });
    }

    public void loadJar() {
        fileChooser.setTitle(bundle.getString("dialog_jar_title"));
        fileChooser.getExtensionFilters()
                .setAll(new FileChooser.ExtensionFilter(bundle.getString("filter_jar"), "*.jar"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try{
                pluginLoader.loadJar(file);
                refreshList();
            }catch( ClassCastException e){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Unable to load JAR ", ButtonType.CLOSE);
                alert.initOwner(stage);
                alert.showAndWait();

            }
        }
    }

}
