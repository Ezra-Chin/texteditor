package edu.curtin.texteditor;

import edu.curtin.texteditor.api.Plugin;
import edu.curtin.texteditor.api.PluginService;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
        ResourceBundle bundle = ResourceBundle.getBundle("findplugin", api.getLocale(), FindPlugin.class.getClassLoader());
        String term = api.getUserInput(bundle.getString("find"));
        if(term == null || term.isEmpty()){
            return;
        }
        

        String text = api.getText();
        String target = term;
        int from = Math.min(api.getCaret(), text.length());



        //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/text/Normalizer.html
        //normalize ts 
        StringBuilder normText = new StringBuilder();
        List<Integer> oriIndex = new ArrayList<>();
        int i = from;
        while (i < text.length()) {
            int len = Character.charCount(text.codePointAt(i));
            String piece = Normalizer.normalize(text.substring(i, i + len), Normalizer.Form.NFKC);
            for (int k = 0; k < piece.length(); k++) {
                oriIndex.add(i);
            }
            normText.append(piece);
            i += len;
        }
        oriIndex.add(text.length());


        int index = normText.indexOf(target);
        if (index >= 0){
            int start = oriIndex.get(index);
            int end = oriIndex.get(index + target.length());
            api.setSelection(start,end);
        }
          
   }
}

