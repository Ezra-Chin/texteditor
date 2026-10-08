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
import java.util.ResourceBundle;

public class LoadSaveUI {
    private static final int SPACING = 8;

    private Stage stage;
    private TextArea textArea;
    private FileIO fileIO;    
    private FileChooser fileDialog = new FileChooser();
    private Dialog<String> encodingDialog;
    private ResourceBundle bundle;


    public LoadSaveUI(Stage stage, TextArea textArea,FileIO fileIO , ResourceBundle bundle){
        this.stage = stage;
        this.textArea = textArea;
        this.fileIO = fileIO;
        this.bundle = bundle;
    }

    private String getEncoding(){
        if (encodingDialog == null){
            var encodingComboBox = new ComboBox<String>();
            var content = new FlowPane();
            encodingDialog = new Dialog<>();
            encodingDialog.setTitle(bundle.getString("encoding_dialog_title"));
            encodingDialog.getDialogPane().setContent(content);
            encodingDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
              encodingDialog.setResultConverter(
                btn -> (btn == ButtonType.OK) ? encodingComboBox.getValue() : null);
            
            content.setHgap(SPACING);
            content.getChildren().setAll(new Label(bundle.getString("encoding_label")), encodingComboBox);
            
            encodingComboBox.getItems().setAll("UTF-8", "UTF-16", "UTF-32");
            encodingComboBox.setValue("UTF-8");
        }
        return encodingDialog.showAndWait().orElse(null);
    }


    public void save(){
        fileDialog.setTitle(bundle.getString("save_dialog_title"));
        File f = fileDialog.showSaveDialog(stage);
        if (f != null){
            String encoding = getEncoding();
            if (encoding != null){
                try{
                    fileIO.save(f, textArea.getText(),encoding);
                }catch(Exception e){
                    new Alert(
                        Alert.AlertType.ERROR, 
                        String.format(bundle.getString("save_error"), e.getClass().getName(), e.getMessage()),
                        ButtonType.CLOSE
                    ).showAndWait();
                }
            }
        }
    }
    public void open(){
        fileDialog.setTitle(bundle.getString("open_dialog_title"));
        File f = fileDialog.showOpenDialog(stage);
        if (f != null){
            String encoding = getEncoding();
            if (encoding != null){
                try{
                    textArea.setText(fileIO.load(f, encoding));
                }catch(Exception e){
                    new Alert(
                        Alert.AlertType.ERROR, 
                        String.format(bundle.getString("open_error"), e.getClass().getName(), e.getMessage()),
                        ButtonType.CLOSE
                    ).showAndWait();
                }
            }
        }
    }

}
