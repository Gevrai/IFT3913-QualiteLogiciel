/* 
 * https://tomassetti.me/antlr-mega-tutorial/#java-setup 
 */

/* 
 * Parser Rules
 */

grammar uml_grammar;

model : 'MODEL' ID decls;


decls : decl* ;

decl : uml_class SEMICOLON
	| association SEMICOLON
	| generalization SEMICOLON
	| aggregation SEMICOLON ;


uml_class : 'CLASS' ID uml_class_content;

uml_class_content : 'ATTRIBUTES' attributes? 'OPERATIONS' operations? ;

attributes : idTypePair (COMMA idTypePair)* ;

operations : operation (COMMA operation)* ;

operation : ID args COLON type ; 

args : LPAREN idTypePair? (COMMA idTypePair)* RPAREN ;

idTypePair : ID COLON type;

type : ID;


association : 'RELATION' ID 'ROLES' two_roles ;

two_roles : role COMMA role ;

role : 'CLASS' ID multiplicity ;

roles : role (COMMA role)* ;

multiplicity : 'ONE'
						 | 'MANY'
						 | 'ONE_OR_MANY'
						 | 'OPTIONALLY_ONE'
						 | 'UNDEFINED' ;

aggregation : 'AGGREGATION' 'CONTAINER' role 'PARTS' roles; 

generalization : 'GENERALIZATION' ID 'SUBCLASSES' subclass_names;

subclass_names : ID (COMMA ID)* ;

/* 
 * Lexer Rules
 */

LPAREN		: '(' ;
RPAREN		: ')' ;
COLON			: ':' ;
SEMICOLON : ';' ;
COMMA 			: ',' ;

ID : [_A-Za-z][_A-Za-z0-9]+ ;

WHITESPACE : [ \n\t\r]+ -> skip ;
