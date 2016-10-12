grammar ICSS;
//NOT SATISFIED WITH THESE RULES STILL WON'T PARSE INTEGERS

properties: stylesheet;
stylesheet: variable+ element+;
element: name '{' attribute+ '}';
varName: '$' STRING;
attribute: name ':' varType ';';
varType: value|varName;
value: intValue|string|color|number ;
intValue: number uom;  // does nothing
color: '#' BLOB;
uom: STRING;  // does nothing
variable: varName ':' varType ';';
name: STRING;
number: BLOB;  // does the unwanted thing needs to be a real integer.
string : STRING;

STRING:[a-zA-Z\-]+;
BLOB:[a-zA-Z0-9-_]+;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;

