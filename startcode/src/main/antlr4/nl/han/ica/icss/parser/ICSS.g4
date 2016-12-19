grammar ICSS;

properties: stylesheet;
stylesheet:((assignment+ ruleset+)|(ruleset+ assignment+))+  ;
ruleset: selector '{' declaration+ '}';
constantIdentifier: '$' STRING;
declaration: property ':' value ';';
value:   size |number | stringValue | color | constantIdentifier;
color: '#' HEX;
assignment: constantIdentifier ':' value ';';
size: INT uom;
selector: STRING;
property: STRING;
stringValue : STRING;
uom: STRING;
number: INT;

STRING:[a-zA-Z\-]+;
INT : [0-9]+ ;
fragment HEXCHAR : [0-9a-fA-F];
fragment HEX3 : HEXCHAR HEXCHAR HEXCHAR;
HEX : HEX3 HEX3?;
WS : [ \t\r\n]+ -> skip ;
COMMENT :  '//'  ~( '\r' | '\n' )* -> skip ; // no need for a NEWLINE at the end

