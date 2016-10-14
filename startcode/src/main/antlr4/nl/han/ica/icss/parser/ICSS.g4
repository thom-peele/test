grammar ICSS;

properties: stylesheet;
stylesheet:((variable+ element+)|(element+ variable+))+  ;
element: name '{' attribute+ '}';
varName: '$' STRING;
attribute: name ':' varType ';';
varType:   INT uom |INT | string | color | varName;
color: '#' HEX;
variable: varName ':' varType ';';
name: STRING;
string : STRING;
uom: STRING;

STRING:[a-zA-Z\-]+;
INT : [0-9]+ ;
fragment HEXCHAR : [0-9a-fA-F];
fragment HEX3 : HEXCHAR HEXCHAR HEXCHAR;
HEX : HEX3 HEX3?;
WS : [ \t\r\n]+ -> skip ;
COMMENT :  '//'  ~( '\r' | '\n' )* -> skip ; // no need for a NEWLINE at the end

