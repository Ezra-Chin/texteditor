package edu.curtin.texteditor;
import edu.curtin.texteditor.api.Plugin;
import edu.curtin.texteditor.api.PluginService;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;

public class DatePlugin implements Plugin {
    @Override 
    public void start(PluginService api){
        
        ResourceBundle bundle = ResourceBundle.getBundle("dateplugin", api.getLocale(), DatePlugin.class.getClassLoader());
        api.addButton(bundle.getString("date"), () -> {
            ZonedDateTime now = ZonedDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).localizedBy(api.getLocale());
            String dateString = formatter.format(now);

            int caret = api.getCaret();
            String text = api.getText();

            String newText = text.substring(0,caret) + dateString + text.substring(caret);
            api.setText(newText);
            api.setCaret(caret + dateString.length() );

        });
    }
}
