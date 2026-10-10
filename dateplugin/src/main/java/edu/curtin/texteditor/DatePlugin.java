package edu.curtin.texteditor;
import edu.curtin.texteditor.api.Plugin;
import edu.curtin.texteditor.api.PluginService;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DatePlugin implements Plugin {
    @Override 
    public void start(PluginService api){
        
        api.addButton("Date", () -> {
            ZonedDateTime now = ZonedDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(api.getLocale());
            String dateString = formatter.format(now);

            int caret = api.getCaret();
            String text = api.getText();

            String newText = text.substring(0,caret) + dateString + text.substring(caret);
            api.setText(newText);
            api.setCaret(caret + dateString.length() );

        });
    }
}
