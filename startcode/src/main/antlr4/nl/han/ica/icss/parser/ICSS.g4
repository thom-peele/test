grammar ICSS;
//INCOMPLETE!

//stylesheet: IDENT;

properties: stylesheet;
stylesheet: variable+ element+;
element: name '{' attribute+ '}';
varName: '$' STRING;
attribute: name ':' varType ';';
varType: value|varName;
value: intValue|string|color|integer ;
intValue: integer uom;
color: '#' BLOB;
uom: STRING;
variable: varName ':' varType ';';
name: STRING;
integer: INT;

string : STRING;

STRING:[a-zA-Z\-]+;
BLOB:[a-zA-Z0-9-_]+;
INT:[0-9]+;
WS : [ \t\r\n]+ -> skip ;

