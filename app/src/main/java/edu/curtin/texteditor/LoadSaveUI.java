package edu.curtin.texteditor;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.io.File;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class LoadSaveUI {
    private static final int SPACING = 8;

    private Stage stage;
    private TextArea textArea;
    private FileIO fileIO;    
    private FileChooser fileDialog = new FileChooser();
    private Dialog<String> encodingDialog;


    public LoadSaveUI(Stage stage, TextArea textArea,FileIO fileIO){
        this.stage = stage;
        this.textArea = textArea;
        this.fileIO = fileIO;
    }

    private String getEncoding(){
        if (encodingDialog == null){
            var encodingComboBox = new ComboBox<String>();
            var content = new FlowPane();
            encodingDialog = new Dialog<>();
            encodingDialog.setTitle("Select File Encoding");
            encodingDialog.getDialogPane().setContent(content);
            encodingDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
              encodingDialog.setResultConverter(
                btn -> (btn == ButtonType.OK) ? encodingComboBox.getValue() : null);
            
            content.setHgap(SPACING);
            content.getChildren().setAll(new Label("Encoding"), encodingComboBox);
            
            encodingComboBox.getItems().setAll("UTF-8", "UTF-16", "UTF-32");
            encodingComboBox.setValue("UTF-8");
        }
        return encodingDialog.showAndWait().orElse(null);
    }


    public void save(){
        fileDialog.setTitle("Save File");
        File f = fileDialog.showSaveDialog(stage);
        if (f != null){
            String encoding = getEncoding();
            if (encoding != null){
                try{
                    fileIO.save(f, textArea.getText(),encoding);
                }catch(Exception e){
                    new Alert(
                        Alert.AlertType.ERROR, 
                        String.format("Error saving timetable: %s - %s", e.getClass().getName(), e.getMessage()),
                        ButtonType.CLOSE
                    ).showAndWait();
                }
            }
        }
    }
    public void open(){

    }

}
