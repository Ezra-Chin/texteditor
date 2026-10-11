grammar Keymap;

keymap : (binding? NEWLINE)* binding? EOF ;

binding : threekeys EQUALS action STRING position ;

threekeys : modifier (PLUS modifier)* PLUS LETTER ;

modifier : ALT | CTRL | SHIFT ;
action : INSERT | DELETE ;
position : AT START OF LINE | AT CARET ;

ALT    : 'alt' ;
CTRL   : 'ctrl' ;
SHIFT  : 'shift' ;
INSERT : 'insert' ;
DELETE : 'delete' ;
AT     : 'at' ;
START  : 'start' ;
OF     : 'of' ;
LINE   : 'line' ;
CARET  : 'caret' ;
PLUS   : '+' ;
EQUALS : '=' ;

LETTER : [a-z] ;
STRING : '"' ~["\r\n]* '"' ;

NEWLINE : '\r'? '\n' ;
WHITESPACE : [ \t]+ -> skip ;