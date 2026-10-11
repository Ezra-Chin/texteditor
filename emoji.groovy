def SMILEY = ":-)"
def EMOJI = "\uD83D\uDE0A"   

app.addTextChangeListener { newText ->
    def text = app.getText()
    int caret = app.getCaret()
    if (caret >= SMILEY.length() && text.substring(caret - SMILEY.length(), caret) == SMILEY) {
        int start = caret - SMILEY.length()
        app.setText(text.substring(0, start) + EMOJI + text.substring(caret))
        app.setCaret(start + EMOJI.length())
    }
}