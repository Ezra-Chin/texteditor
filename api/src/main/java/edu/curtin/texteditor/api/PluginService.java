package edu.curtin.texteditor.api;
import java.util.Locale;

public interface PluginService {
    void addButton(String name, ButtonHandler handler);
    void addTextChangeListener(TextChangeListener listener);
    void addFunctionKeyListener(FunctionKeyListener listener);

    String getUserInput(String input);
    String getText();
    void setText(String text);

    int getCaret();
    void setCaret(int position);

    int getSelectionStart();
    int getSelectionEnd();
    void setSelection(int start, int end);

    Locale getLocale();
}
