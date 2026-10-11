package edu.curtin.texteditor;

import edu.curtin.texteditor.keymap.KeymapLexer;
import edu.curtin.texteditor.keymap.KeymapParser;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Collections;

public class KeymapLoader {
    private ResourceBundle bundle;
    public KeymapLoader(ResourceBundle bundle){
        this.bundle = bundle;
    }
    
    public List<KeymapParser.BindingContext> load (Path path){
        try{


            KeymapLexer lexer = new KeymapLexer(CharStreams.fromPath(path));
            KeymapParser parser = new KeymapParser( new CommonTokenStream(lexer));

            BaseErrorListener errorListener = new BaseErrorListener(){
                @Override 
                public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e ){
                     throw new ParseCancellationException(String.format(
                    bundle.getString("keymap_error_line"), line, charPositionInLine, msg));
                }
            };
            lexer.removeErrorListeners();
            parser.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            parser.addErrorListener(errorListener);

            return parser.keymap().binding();
        }catch(IOException e){
            return Collections.emptyList();

        }
        

    }

}
