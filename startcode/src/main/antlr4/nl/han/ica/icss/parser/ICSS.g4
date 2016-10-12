grammar ICSS;
//INCOMPLETE!

//stylesheet: IDENT;
properties: variable+ element+;
element: name '{' attribute+ '}';
varName: '$' name;
attribute: name ':' varType ';';
varType: value|varName;
value: intValue|stringValue|color ;
color: '#' stringValue;
uom: name;
variable: varName ':' varType ';';
name: STRING;
stringValue: VALUE;
intValue: integer+ uom;
integer: INT;



STRING:[a-zA-Z\-]+;
VALUE:[a-zA-Z0-9-_]+;
INT : [0-9]+;
DUMP:[\-];
//IDENT: [\-]?[a-z_][a-z0-9\-_{}]*;
BRACKET: [/{];
BRACKETR: [/}];
WS : [ \t\r\n]+ -> skip ;

