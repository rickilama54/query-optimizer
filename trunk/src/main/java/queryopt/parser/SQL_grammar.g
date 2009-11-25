grammar SQL_grammar;

options 
{
	output=AST;
	ASTLabelType=CommonTree;
}

@header{package queryopt.parser;}
@lexer::header {package queryopt.parser;}

@members {
List<RecognitionException> exceptions = new ArrayList<RecognitionException>();

public  void reportError(RecognitionException e)
{
    exceptions.add(e);
}

public boolean hasError()
{
 return exceptions.size() > 0; 
}

public String getErrorMessage()
{
	if (exceptions.size() > 0)
		return this.getErrorMessage(exceptions.get(0), this.getTokenNames());
	else
		return "No Errors";
}

public String getErrorPosition()
{
	return this.getErrorHeader(exceptions.get(0));
}
}


query
	:	select from where? ';'! EOF!
	; 
 	   
select	: 	SELECT^  (NAME (','! NAME)* | STAR)  
	;
	 
from	:	FROM^ NAME (','! NAME)*
	;
	
where	:	WHERE^ and
	;

and	:	clause ( 'AND'! clause)* 
	;

clause	:	NAME op^ NAME | NAME op^ LITERAL  | LITERAL op^ NAME  | LITERAL op^ LITERAL
	; 
	


op	:	(EQ | LS | GT | LS_EQ | GT_EQ)
	;
  
  	
/* Ignore white spaces */	
WS	
	:  (' '|'\r'|'\t'|'\u000C'|'\n')
	{$channel=HIDDEN;}
	;
SELECT	:	'SELECT';	
FROM	:	'FROM';
WHERE	:	'WHERE';
STAR	:	'*';
EQ	:	'=';
DIFF	:	'<>';
GT_EQ	:	'>=';
LS_EQ	:	'<=';
LS	:	'<';
GT	:	'>';
LITERAL	:	'\''NAME'\'';
NAME	:	('0'..'9'|'a'..'z'|'A'..'Z')+ ; 