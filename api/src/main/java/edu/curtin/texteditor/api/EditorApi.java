package edu.curtin.texteditor.api;
import java.util.Locale;

public interface EditorApi {
    void addButton(String name, ButtonHandler handler);
    void addTextChangeLIstener(TextChangeListener listener);
    void addFunctionKeyListener(FunctionKeyListener listener);

    String getText();
    void setText(String text);

    int getCaret();
    void setCaret(int position);

    int getSelectionStart();
    int getSelectionEnd();
    void setSelection(int start, int end);

    Locale getLocale();
}
