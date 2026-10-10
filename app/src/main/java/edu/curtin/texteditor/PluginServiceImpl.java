package edu.curtin.texteditor;

import edu.curtin.texteditor.api.ButtonHandler;
import edu.curtin.texteditor.api.PluginService;
import edu.curtin.texteditor.api.FunctionKeyListener;
import edu.curtin.texteditor.api.TextChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class PluginServiceImpl implements PluginService{

    private KeyCode[] functionKeys = {KeyCode.F1, KeyCode.F2, KeyCode.F3, KeyCode.F4, KeyCode.F5, KeyCode.F6,
            KeyCode.F7, KeyCode.F8, KeyCode.F9, KeyCode.F10, KeyCode.F11, KeyCode.F12};

    private final Locale locale;
    private final ResourceBundle bundle;
    private final TextArea textArea;
    private final ToolBar toolBar;
    private final List<TextChangeListener> textListeners = new ArrayList<>();
    private final List<FunctionKeyListener> fKeyListeners = new ArrayList<>();

    private boolean apiEditing = false;

    public PluginServiceImpl(Locale locale, ResourceBundle bundle, TextArea textArea, ToolBar toolBar, Scene scene) {
        this.locale = locale;
        this.bundle = bundle;
        this.textArea = textArea;
        this.toolBar = toolBar;



        textArea.textProperty().addListener((object, oldValue , newValue) -> {

            if (!apiEditing) {
                for (TextChangeListener l : List.copyOf(textListeners)) {
                    l.textChanged(newValue);
                }
            }
        });

        //https://docs.oracle.com/en/java/java-components/javafx/27/docs/javafx.base/javafx/beans/property/adapter/JavaBeanStringProperty.html?utm_source=chatgpt.com#addListener(javafx.beans.value.ChangeListener)
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            int keyNumber = functionKeyToNumber(event.getCode());
            if (keyNumber > 0) {
                for (FunctionKeyListener l : List.copyOf(fKeyListeners)) {
                    l.functionKeyPressed(keyNumber);
                }
            }
        });

    }

    private int functionKeyToNumber(KeyCode key) {
        
        int result = 0;
        for (int i = 0; i < functionKeys.length; i++) {


            if (functionKeys[i] == key) {
                result = i + 1;
            }
        }

        return result;
    }

    private int clamp(int index) {
        return Math.max(0, Math.min(index, textArea.getLength()));
    }

    @Override
    public String getUserInput(String input) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle(bundle.getString("user_input_dialog_title"));
        dialog.setHeaderText(null);
        dialog.setContentText(input);
        return dialog.showAndWait().orElse(null); 
    }

    @Override
    public void addButton(String label, ButtonHandler handler) {


        Button button = new Button(label);
        button.setFocusTraversable(false);
        button.setOnAction(event -> handler.pressButton());
        toolBar.getItems().add(button);
    }



    @Override
    public void addTextChangeListener(TextChangeListener listener) {
        textListeners.add(listener);
    }

    @Override
    public void addFunctionKeyListener(FunctionKeyListener listener) {

        fKeyListeners.add(listener);
    }

    @Override
    public String getText() {
        return textArea.getText();
    }

    @Override
    public void setText(String text) {
        apiEditing = true;


        try {
            textArea.setText(text);
        } finally {
            apiEditing = false;
        }
    }

    @Override
    public int getCaret() {
        return textArea.getCaretPosition();
    }

    @Override
    public void setCaret(int position) {
        textArea.positionCaret(clamp(position));
    }

    @Override
    public int getSelectionStart() {
        return textArea.getSelection().getStart();
    }

    @Override
    public int getSelectionEnd() {
        return textArea.getSelection().getEnd();
    }

    @Override
    public void setSelection(int start, int end) {
        textArea.selectRange(clamp(start), clamp(end)); 
    }

    @Override
    public Locale getLocale() {
        return locale;
    }
}