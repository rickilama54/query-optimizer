grammar SQL_grammar;

options 
{
	output=AST;
	ASTLabelType=CommonTree;
}


query
	:	select from where? ';'! EOF!
	; 
 	   
select	: 	'SELECT'^  (NAME (','! NAME)* | STAR)  
	;
	 
from	:	'FROM'^ NAME (','! NAME)*
	;
	
where	:	'WHERE'^ and
	;

and	:	clause ( 'AND'! clause)* 
	;

clause	:	NAME op^ NAME
	; 
	


op	:	('=' | '<' | '>' | '<=' | '>=')
	;
  	
/* Ignore white spaces */	
WS	
	:  (' '|'\r'|'\t'|'\u000C'|'\n')
	{$channel=HIDDEN;}
	;
	
STAR	:	'*';
NAME	:	('0'..'9'|'a'..'z'|'A'..'Z')+ ; 