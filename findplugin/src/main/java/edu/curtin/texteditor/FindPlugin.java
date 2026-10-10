package edu.curtin.texteditor;

import edu.curtin.texteditor.api.Plugin;
import edu.curtin.texteditor.api.PluginService;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FindPlugin implements Plugin{
   @Override 
   public void start(PluginService api){
        api.addButton("Find", () -> find(api)); 
        api.addFunctionKeyListener(key -> {
            if(key == 3){
                find(api);
            }
        });
   
   }
   private void find(PluginService api ) {
        String term = api.getUserInput("Find:");
        if(term == null || term.isEmpty()){
            return;
        }
        String text = api.getText();
        String target = term;
        int from = Math.min(api.getCaret(), text.length());
        int index = text.indexOf(target,from );
        if (index >= 0){
            api.setSelection(index, index + target.length());
        }
          
   }
}

