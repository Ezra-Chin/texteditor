package edu.curtin.texteditor;

import edu.curtin.texteditor.keymap.KeymapParser;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;
import java.util.Locale;

public record KeymapHandler() {
    private final List<KeymapParser.BindingContext> bindings;    
    private final TextArea textArea;
    private boolean swallowType = false;

    public KeymapHandler(List<KeymapParser.BindingContext> bindings, TextArea textArea){
        this.bindings = List.of(bindings);
        this.textArea = textArea;
    }

    public void registerKeyHandlers(Scene scene ){
        scene.addEventFilter(KeyEvent.KEY_PRESSED , this::keyPressed);
        scene.addEventFilter(KeyEvent.KEY_TYPED, this::keyTyped);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> swallowType = false);
    }


    private void keyPressed(KeyEvent event){
        boolean matched = false;

        for(KeymapParser.BindingContext binding: bindings){
            if(matches(binding,event)){
                apply(binding);
                matched = true;
            }
        }
        if (matched){
            event.consume();
            swallowType = true;
        }
    }

    private void keyTyped(KeyEvent event){
        if(swallowType){
            event.consume();
        }
    }

    private static boolean matches(KeymapParser.BindingContext binding, KeyEvent event){
        boolean alt = false;
        boolean ctrl = false;
        boolean shift = false;

        for(KeymapParser.ModifierContext mod : binding.combo().modifier()){
            if(mod.ALT() != null){
                alt = true ;
            }
            if (mod.CTRL() != null){
                ctrl = true;
            }
            if (mod.SHIFT() != null){
                shift = true;
            }
        }


        String letter = binding.combo().LETTER().getText().toUpperCase(Locale.ROOT);

        return event.getCode() == KeyCode.valueOf(letter) && event.isAltDown() == alt && event.isControlDown() == ctrl && event.isShiftDown() == shift;
    }
}
