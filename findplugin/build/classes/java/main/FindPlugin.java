package edu.curtin.texteditor;

import edu.curtin.texteditor.api.Plugin;
import edu.curtin.texteditor.api.PluginService;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FindPlugin implements Plugin{
   @Override 
   public void start(EditorApi api){
        api.addButton("Find", () -> find(api)); 
        api.addFunctionKeyListener(key -> {
            if(key == 3){
                find(api);
            }
        });
   
   }
   private void find(EditorApi api ) {

   }
}

