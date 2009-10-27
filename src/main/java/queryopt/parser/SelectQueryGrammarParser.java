// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/SelectQueryGrammar.g 2009-10-27 09:32:57

package queryopt.parser;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SelectQueryGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUERY", "WS", "SELECT", "FROM", "WHERE", "AND", "OP", "IN", "AGGREGATE_FUNC", "NAME", "';'", "'*'", "','", "'('", "')'"
    };
    public static final int WHERE=8;
    public static final int NAME=13;
    public static final int WS=5;
    public static final int T__16=16;
    public static final int IN=11;
    public static final int T__15=15;
    public static final int AGGREGATE_FUNC=12;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int OP=10;
    public static final int QUERY=4;
    public static final int AND=9;
    public static final int FROM=7;
    public static final int EOF=-1;
    public static final int SELECT=6;

    // delegates
    // delegators


        public SelectQueryGrammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SelectQueryGrammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SelectQueryGrammarParser.tokenNames; }
    public String getGrammarFileName() { return "/home/dragan/Dragan/SelectQueryGrammar.g"; }


    List<RecognitionException> exceptions = new ArrayList<RecognitionException>();

    public void reportError(RecognitionException e)
    {
        exceptions.add(e);
    }

    public boolean hasError()
    {
    	return exceptions.size() > 0;
    }

    public String getErrorMessage()
    {
    	return this.getErrorMessage((RecognitionException)exceptions.get(0), this.getTokenNames()); 
    }

    public String getErrorPosition()
    {
     	return this.getErrorHeader((RecognitionException)exceptions.get(0)); 
    }


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // /home/dragan/Dragan/SelectQueryGrammar.g:43:1: query : ( WS )? query_block ';' EOF ;
    public final SelectQueryGrammarParser.query_return query() throws RecognitionException {
        SelectQueryGrammarParser.query_return retval = new SelectQueryGrammarParser.query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS1=null;
        Token char_literal3=null;
        Token EOF4=null;
        SelectQueryGrammarParser.query_block_return query_block2 = null;


        CommonTree WS1_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree EOF4_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:43:7: ( ( WS )? query_block ';' EOF )
            // /home/dragan/Dragan/SelectQueryGrammar.g:43:9: ( WS )? query_block ';' EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/dragan/Dragan/SelectQueryGrammar.g:43:11: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==WS) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:43:11: WS
                    {
                    WS1=(Token)match(input,WS,FOLLOW_WS_in_query56); 

                    }
                    break;

            }

            pushFollow(FOLLOW_query_block_in_query60);
            query_block2=query_block();

            state._fsp--;

            adaptor.addChild(root_0, query_block2.getTree());
            char_literal3=(Token)match(input,14,FOLLOW_14_in_query62); 
            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_query65); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "query"

    public static class query_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query_block"
    // /home/dragan/Dragan/SelectQueryGrammar.g:45:1: query_block : (select= select_block WS -> ^( QUERY $select) ) (from= from_block -> ^( QUERY $select $from) ) ( WS where= where_block -> ^( QUERY $select $from $where) )? ;
    public final SelectQueryGrammarParser.query_block_return query_block() throws RecognitionException {
        SelectQueryGrammarParser.query_block_return retval = new SelectQueryGrammarParser.query_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS5=null;
        Token WS6=null;
        SelectQueryGrammarParser.select_block_return select = null;

        SelectQueryGrammarParser.from_block_return from = null;

        SelectQueryGrammarParser.where_block_return where = null;


        CommonTree WS5_tree=null;
        CommonTree WS6_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleSubtreeStream stream_select_block=new RewriteRuleSubtreeStream(adaptor,"rule select_block");
        RewriteRuleSubtreeStream stream_from_block=new RewriteRuleSubtreeStream(adaptor,"rule from_block");
        RewriteRuleSubtreeStream stream_where_block=new RewriteRuleSubtreeStream(adaptor,"rule where_block");
        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:45:13: ( (select= select_block WS -> ^( QUERY $select) ) (from= from_block -> ^( QUERY $select $from) ) ( WS where= where_block -> ^( QUERY $select $from $where) )? )
            // /home/dragan/Dragan/SelectQueryGrammar.g:45:15: (select= select_block WS -> ^( QUERY $select) ) (from= from_block -> ^( QUERY $select $from) ) ( WS where= where_block -> ^( QUERY $select $from $where) )?
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:45:15: (select= select_block WS -> ^( QUERY $select) )
            // /home/dragan/Dragan/SelectQueryGrammar.g:45:16: select= select_block WS
            {
            pushFollow(FOLLOW_select_block_in_query_block82);
            select=select_block();

            state._fsp--;

            stream_select_block.add(select.getTree());
            WS5=(Token)match(input,WS,FOLLOW_WS_in_query_block84);  
            stream_WS.add(WS5);



            // AST REWRITE
            // elements: select
            // token labels: 
            // rule labels: retval, select
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select",select!=null?select.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 45:39: -> ^( QUERY $select)
            {
                // /home/dragan/Dragan/SelectQueryGrammar.g:45:41: ^( QUERY $select)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_select.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            // /home/dragan/Dragan/SelectQueryGrammar.g:46:4: (from= from_block -> ^( QUERY $select $from) )
            // /home/dragan/Dragan/SelectQueryGrammar.g:46:5: from= from_block
            {
            pushFollow(FOLLOW_from_block_in_query_block102);
            from=from_block();

            state._fsp--;

            stream_from_block.add(from.getTree());


            // AST REWRITE
            // elements: select, from
            // token labels: 
            // rule labels: retval, select, from
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select",select!=null?select.tree:null);
            RewriteRuleSubtreeStream stream_from=new RewriteRuleSubtreeStream(adaptor,"rule from",from!=null?from.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 46:20: -> ^( QUERY $select $from)
            {
                // /home/dragan/Dragan/SelectQueryGrammar.g:46:23: ^( QUERY $select $from)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_select.nextTree());
                adaptor.addChild(root_1, stream_from.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            // /home/dragan/Dragan/SelectQueryGrammar.g:47:4: ( WS where= where_block -> ^( QUERY $select $from $where) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==WS) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==WHERE) ) {
                    alt2=1;
                }
            }
            switch (alt2) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:47:5: WS where= where_block
                    {
                    WS6=(Token)match(input,WS,FOLLOW_WS_in_query_block120);  
                    stream_WS.add(WS6);

                    pushFollow(FOLLOW_where_block_in_query_block124);
                    where=where_block();

                    state._fsp--;

                    stream_where_block.add(where.getTree());


                    // AST REWRITE
                    // elements: from, where, select
                    // token labels: 
                    // rule labels: retval, select, from, where
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_select=new RewriteRuleSubtreeStream(adaptor,"rule select",select!=null?select.tree:null);
                    RewriteRuleSubtreeStream stream_from=new RewriteRuleSubtreeStream(adaptor,"rule from",from!=null?from.tree:null);
                    RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where",where!=null?where.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 47:25: -> ^( QUERY $select $from $where)
                    {
                        // /home/dragan/Dragan/SelectQueryGrammar.g:47:28: ^( QUERY $select $from $where)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUERY, "QUERY"), root_1);

                        adaptor.addChild(root_1, stream_select.nextTree());
                        adaptor.addChild(root_1, stream_from.nextTree());
                        adaptor.addChild(root_1, stream_where.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "query_block"

    public static class select_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_block"
    // /home/dragan/Dragan/SelectQueryGrammar.g:49:1: select_block : SELECT WS select_clause ;
    public final SelectQueryGrammarParser.select_block_return select_block() throws RecognitionException {
        SelectQueryGrammarParser.select_block_return retval = new SelectQueryGrammarParser.select_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SELECT7=null;
        Token WS8=null;
        SelectQueryGrammarParser.select_clause_return select_clause9 = null;


        CommonTree SELECT7_tree=null;
        CommonTree WS8_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:50:2: ( SELECT WS select_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:50:5: SELECT WS select_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            SELECT7=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_block152); 
            SELECT7_tree = (CommonTree)adaptor.create(SELECT7);
            root_0 = (CommonTree)adaptor.becomeRoot(SELECT7_tree, root_0);

            WS8=(Token)match(input,WS,FOLLOW_WS_in_select_block155); 
            pushFollow(FOLLOW_select_clause_in_select_block158);
            select_clause9=select_clause();

            state._fsp--;

            adaptor.addChild(root_0, select_clause9.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "select_block"

    public static class select_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select_clause"
    // /home/dragan/Dragan/SelectQueryGrammar.g:52:1: select_clause : ( '*' | term ( ( WS )? ',' ( WS )? term )* );
    public final SelectQueryGrammarParser.select_clause_return select_clause() throws RecognitionException {
        SelectQueryGrammarParser.select_clause_return retval = new SelectQueryGrammarParser.select_clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal10=null;
        Token WS12=null;
        Token char_literal13=null;
        Token WS14=null;
        SelectQueryGrammarParser.term_return term11 = null;

        SelectQueryGrammarParser.term_return term15 = null;


        CommonTree char_literal10_tree=null;
        CommonTree WS12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree WS14_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:52:15: ( '*' | term ( ( WS )? ',' ( WS )? term )* )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=AGGREGATE_FUNC && LA6_0<=NAME)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:52:17: '*'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal10=(Token)match(input,15,FOLLOW_15_in_select_clause166); 
                    char_literal10_tree = (CommonTree)adaptor.create(char_literal10);
                    adaptor.addChild(root_0, char_literal10_tree);


                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:53:4: term ( ( WS )? ',' ( WS )? term )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_term_in_select_clause171);
                    term11=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term11.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:53:9: ( ( WS )? ',' ( WS )? term )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==WS) ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1==16) ) {
                                alt5=1;
                            }


                        }
                        else if ( (LA5_0==16) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:53:10: ( WS )? ',' ( WS )? term
                    	    {
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:53:12: ( WS )?
                    	    int alt3=2;
                    	    int LA3_0 = input.LA(1);

                    	    if ( (LA3_0==WS) ) {
                    	        alt3=1;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // /home/dragan/Dragan/SelectQueryGrammar.g:53:12: WS
                    	            {
                    	            WS12=(Token)match(input,WS,FOLLOW_WS_in_select_clause174); 

                    	            }
                    	            break;

                    	    }

                    	    char_literal13=(Token)match(input,16,FOLLOW_16_in_select_clause177); 
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:53:21: ( WS )?
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==WS) ) {
                    	        alt4=1;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // /home/dragan/Dragan/SelectQueryGrammar.g:53:21: WS
                    	            {
                    	            WS14=(Token)match(input,WS,FOLLOW_WS_in_select_clause180); 

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_term_in_select_clause184);
                    	    term15=term();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, term15.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "select_clause"

    public static class from_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "from_block"
    // /home/dragan/Dragan/SelectQueryGrammar.g:55:1: from_block : FROM WS from_clause ;
    public final SelectQueryGrammarParser.from_block_return from_block() throws RecognitionException {
        SelectQueryGrammarParser.from_block_return retval = new SelectQueryGrammarParser.from_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FROM16=null;
        Token WS17=null;
        SelectQueryGrammarParser.from_clause_return from_clause18 = null;


        CommonTree FROM16_tree=null;
        CommonTree WS17_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:56:2: ( FROM WS from_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:56:5: FROM WS from_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            FROM16=(Token)match(input,FROM,FOLLOW_FROM_in_from_block198); 
            FROM16_tree = (CommonTree)adaptor.create(FROM16);
            root_0 = (CommonTree)adaptor.becomeRoot(FROM16_tree, root_0);

            WS17=(Token)match(input,WS,FOLLOW_WS_in_from_block201); 
            pushFollow(FOLLOW_from_clause_in_from_block204);
            from_clause18=from_clause();

            state._fsp--;

            adaptor.addChild(root_0, from_clause18.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "from_block"

    public static class from_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "from_clause"
    // /home/dragan/Dragan/SelectQueryGrammar.g:57:1: from_clause : nested_query ( ( WS )? ',' ( WS )? nested_query )* ;
    public final SelectQueryGrammarParser.from_clause_return from_clause() throws RecognitionException {
        SelectQueryGrammarParser.from_clause_return retval = new SelectQueryGrammarParser.from_clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS20=null;
        Token char_literal21=null;
        Token WS22=null;
        SelectQueryGrammarParser.nested_query_return nested_query19 = null;

        SelectQueryGrammarParser.nested_query_return nested_query23 = null;


        CommonTree WS20_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree WS22_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:57:13: ( nested_query ( ( WS )? ',' ( WS )? nested_query )* )
            // /home/dragan/Dragan/SelectQueryGrammar.g:57:15: nested_query ( ( WS )? ',' ( WS )? nested_query )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_nested_query_in_from_clause211);
            nested_query19=nested_query();

            state._fsp--;

            adaptor.addChild(root_0, nested_query19.getTree());
            // /home/dragan/Dragan/SelectQueryGrammar.g:57:28: ( ( WS )? ',' ( WS )? nested_query )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==WS) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==16) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:57:29: ( WS )? ',' ( WS )? nested_query
            	    {
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:57:31: ( WS )?
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==WS) ) {
            	        alt7=1;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // /home/dragan/Dragan/SelectQueryGrammar.g:57:31: WS
            	            {
            	            WS20=(Token)match(input,WS,FOLLOW_WS_in_from_clause214); 

            	            }
            	            break;

            	    }

            	    char_literal21=(Token)match(input,16,FOLLOW_16_in_from_clause217); 
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:57:40: ( WS )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==WS) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // /home/dragan/Dragan/SelectQueryGrammar.g:57:40: WS
            	            {
            	            WS22=(Token)match(input,WS,FOLLOW_WS_in_from_clause220); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_nested_query_in_from_clause224);
            	    nested_query23=nested_query();

            	    state._fsp--;

            	    adaptor.addChild(root_0, nested_query23.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "from_clause"

    public static class nested_query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nested_query"
    // /home/dragan/Dragan/SelectQueryGrammar.g:59:1: nested_query : ( table | '(' ( WS )? query_block ( WS )? ')' );
    public final SelectQueryGrammarParser.nested_query_return nested_query() throws RecognitionException {
        SelectQueryGrammarParser.nested_query_return retval = new SelectQueryGrammarParser.nested_query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal25=null;
        Token WS26=null;
        Token WS28=null;
        Token char_literal29=null;
        SelectQueryGrammarParser.table_return table24 = null;

        SelectQueryGrammarParser.query_block_return query_block27 = null;


        CommonTree char_literal25_tree=null;
        CommonTree WS26_tree=null;
        CommonTree WS28_tree=null;
        CommonTree char_literal29_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:59:14: ( table | '(' ( WS )? query_block ( WS )? ')' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NAME) ) {
                alt12=1;
            }
            else if ( (LA12_0==17) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:59:16: table
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_table_in_nested_query236);
                    table24=table();

                    state._fsp--;

                    adaptor.addChild(root_0, table24.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:59:24: '(' ( WS )? query_block ( WS )? ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal25=(Token)match(input,17,FOLLOW_17_in_nested_query240); 
                    // /home/dragan/Dragan/SelectQueryGrammar.g:59:31: ( WS )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==WS) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:59:31: WS
                            {
                            WS26=(Token)match(input,WS,FOLLOW_WS_in_nested_query243); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_query_block_in_nested_query247);
                    query_block27=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block27.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:59:48: ( WS )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==WS) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:59:48: WS
                            {
                            WS28=(Token)match(input,WS,FOLLOW_WS_in_nested_query249); 

                            }
                            break;

                    }

                    char_literal29=(Token)match(input,18,FOLLOW_18_in_nested_query253); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nested_query"

    public static class where_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where_block"
    // /home/dragan/Dragan/SelectQueryGrammar.g:61:1: where_block : WHERE WS where_clause ;
    public final SelectQueryGrammarParser.where_block_return where_block() throws RecognitionException {
        SelectQueryGrammarParser.where_block_return retval = new SelectQueryGrammarParser.where_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHERE30=null;
        Token WS31=null;
        SelectQueryGrammarParser.where_clause_return where_clause32 = null;


        CommonTree WHERE30_tree=null;
        CommonTree WS31_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:62:2: ( WHERE WS where_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:62:5: WHERE WS where_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            WHERE30=(Token)match(input,WHERE,FOLLOW_WHERE_in_where_block265); 
            WHERE30_tree = (CommonTree)adaptor.create(WHERE30);
            root_0 = (CommonTree)adaptor.becomeRoot(WHERE30_tree, root_0);

            WS31=(Token)match(input,WS,FOLLOW_WS_in_where_block268); 
            pushFollow(FOLLOW_where_clause_in_where_block271);
            where_clause32=where_clause();

            state._fsp--;

            adaptor.addChild(root_0, where_clause32.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "where_block"

    public static class where_clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where_clause"
    // /home/dragan/Dragan/SelectQueryGrammar.g:64:1: where_clause : where_condition ( WS AND WS where_condition )* ;
    public final SelectQueryGrammarParser.where_clause_return where_clause() throws RecognitionException {
        SelectQueryGrammarParser.where_clause_return retval = new SelectQueryGrammarParser.where_clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS34=null;
        Token AND35=null;
        Token WS36=null;
        SelectQueryGrammarParser.where_condition_return where_condition33 = null;

        SelectQueryGrammarParser.where_condition_return where_condition37 = null;


        CommonTree WS34_tree=null;
        CommonTree AND35_tree=null;
        CommonTree WS36_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:64:14: ( where_condition ( WS AND WS where_condition )* )
            // /home/dragan/Dragan/SelectQueryGrammar.g:64:16: where_condition ( WS AND WS where_condition )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_where_condition_in_where_clause280);
            where_condition33=where_condition();

            state._fsp--;

            adaptor.addChild(root_0, where_condition33.getTree());
            // /home/dragan/Dragan/SelectQueryGrammar.g:64:32: ( WS AND WS where_condition )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:64:33: WS AND WS where_condition
            	    {
            	    WS34=(Token)match(input,WS,FOLLOW_WS_in_where_clause283); 
            	    AND35=(Token)match(input,AND,FOLLOW_AND_in_where_clause286); 
            	    AND35_tree = (CommonTree)adaptor.create(AND35);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND35_tree, root_0);

            	    WS36=(Token)match(input,WS,FOLLOW_WS_in_where_clause289); 
            	    pushFollow(FOLLOW_where_condition_in_where_clause292);
            	    where_condition37=where_condition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, where_condition37.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "where_clause"

    public static class where_condition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where_condition"
    // /home/dragan/Dragan/SelectQueryGrammar.g:66:1: where_condition : ( column ( WS )? OP ( WS )? column | column ( WS )? OP ( WS )? query_block | query_block ( WS )? OP ( WS )? column | column WS IN ( WS )? '(' query_block ')' );
    public final SelectQueryGrammarParser.where_condition_return where_condition() throws RecognitionException {
        SelectQueryGrammarParser.where_condition_return retval = new SelectQueryGrammarParser.where_condition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS39=null;
        Token OP40=null;
        Token WS41=null;
        Token WS44=null;
        Token OP45=null;
        Token WS46=null;
        Token WS49=null;
        Token OP50=null;
        Token WS51=null;
        Token WS54=null;
        Token IN55=null;
        Token WS56=null;
        Token char_literal57=null;
        Token char_literal59=null;
        SelectQueryGrammarParser.column_return column38 = null;

        SelectQueryGrammarParser.column_return column42 = null;

        SelectQueryGrammarParser.column_return column43 = null;

        SelectQueryGrammarParser.query_block_return query_block47 = null;

        SelectQueryGrammarParser.query_block_return query_block48 = null;

        SelectQueryGrammarParser.column_return column52 = null;

        SelectQueryGrammarParser.column_return column53 = null;

        SelectQueryGrammarParser.query_block_return query_block58 = null;


        CommonTree WS39_tree=null;
        CommonTree OP40_tree=null;
        CommonTree WS41_tree=null;
        CommonTree WS44_tree=null;
        CommonTree OP45_tree=null;
        CommonTree WS46_tree=null;
        CommonTree WS49_tree=null;
        CommonTree OP50_tree=null;
        CommonTree WS51_tree=null;
        CommonTree WS54_tree=null;
        CommonTree IN55_tree=null;
        CommonTree WS56_tree=null;
        CommonTree char_literal57_tree=null;
        CommonTree char_literal59_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:66:16: ( column ( WS )? OP ( WS )? column | column ( WS )? OP ( WS )? query_block | query_block ( WS )? OP ( WS )? column | column WS IN ( WS )? '(' query_block ')' )
            int alt21=4;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==NAME) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==WS) ) {
                    int LA21_3 = input.LA(3);

                    if ( (LA21_3==IN) ) {
                        alt21=4;
                    }
                    else if ( (LA21_3==OP) ) {
                        switch ( input.LA(4) ) {
                        case WS:
                            {
                            int LA21_6 = input.LA(5);

                            if ( (LA21_6==SELECT) ) {
                                alt21=2;
                            }
                            else if ( (LA21_6==NAME) ) {
                                alt21=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 21, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case NAME:
                            {
                            alt21=1;
                            }
                            break;
                        case SELECT:
                            {
                            alt21=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 21, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA21_1==OP) ) {
                    switch ( input.LA(3) ) {
                    case WS:
                        {
                        int LA21_6 = input.LA(4);

                        if ( (LA21_6==SELECT) ) {
                            alt21=2;
                        }
                        else if ( (LA21_6==NAME) ) {
                            alt21=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 21, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case NAME:
                        {
                        alt21=1;
                        }
                        break;
                    case SELECT:
                        {
                        alt21=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 4, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA21_0==SELECT) ) {
                alt21=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:66:19: column ( WS )? OP ( WS )? column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition303);
                    column38=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column38.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:66:28: ( WS )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==WS) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:66:28: WS
                            {
                            WS39=(Token)match(input,WS,FOLLOW_WS_in_where_condition305); 

                            }
                            break;

                    }

                    OP40=(Token)match(input,OP,FOLLOW_OP_in_where_condition309); 
                    OP40_tree = (CommonTree)adaptor.create(OP40);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP40_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:66:37: ( WS )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==WS) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:66:37: WS
                            {
                            WS41=(Token)match(input,WS,FOLLOW_WS_in_where_condition312); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_column_in_where_condition316);
                    column42=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column42.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:67:4: column ( WS )? OP ( WS )? query_block
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition321);
                    column43=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column43.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:67:13: ( WS )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==WS) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:67:13: WS
                            {
                            WS44=(Token)match(input,WS,FOLLOW_WS_in_where_condition323); 

                            }
                            break;

                    }

                    OP45=(Token)match(input,OP,FOLLOW_OP_in_where_condition327); 
                    OP45_tree = (CommonTree)adaptor.create(OP45);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP45_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:67:22: ( WS )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==WS) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:67:22: WS
                            {
                            WS46=(Token)match(input,WS,FOLLOW_WS_in_where_condition330); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_query_block_in_where_condition334);
                    query_block47=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block47.getTree());

                    }
                    break;
                case 3 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:68:4: query_block ( WS )? OP ( WS )? column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_query_block_in_where_condition339);
                    query_block48=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block48.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:68:18: ( WS )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==WS) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:68:18: WS
                            {
                            WS49=(Token)match(input,WS,FOLLOW_WS_in_where_condition341); 

                            }
                            break;

                    }

                    OP50=(Token)match(input,OP,FOLLOW_OP_in_where_condition345); 
                    OP50_tree = (CommonTree)adaptor.create(OP50);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP50_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:68:27: ( WS )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==WS) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:68:27: WS
                            {
                            WS51=(Token)match(input,WS,FOLLOW_WS_in_where_condition348); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_column_in_where_condition352);
                    column52=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column52.getTree());

                    }
                    break;
                case 4 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:69:4: column WS IN ( WS )? '(' query_block ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition357);
                    column53=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column53.getTree());
                    WS54=(Token)match(input,WS,FOLLOW_WS_in_where_condition359); 
                    IN55=(Token)match(input,IN,FOLLOW_IN_in_where_condition362); 
                    IN55_tree = (CommonTree)adaptor.create(IN55);
                    root_0 = (CommonTree)adaptor.becomeRoot(IN55_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:69:21: ( WS )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==WS) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:69:21: WS
                            {
                            WS56=(Token)match(input,WS,FOLLOW_WS_in_where_condition365); 

                            }
                            break;

                    }

                    char_literal57=(Token)match(input,17,FOLLOW_17_in_where_condition369); 
                    pushFollow(FOLLOW_query_block_in_where_condition371);
                    query_block58=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block58.getTree());
                    char_literal59=(Token)match(input,18,FOLLOW_18_in_where_condition372); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "where_condition"

    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // /home/dragan/Dragan/SelectQueryGrammar.g:71:1: term : ( column | AGGREGATE_FUNC '(' column ')' );
    public final SelectQueryGrammarParser.term_return term() throws RecognitionException {
        SelectQueryGrammarParser.term_return retval = new SelectQueryGrammarParser.term_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AGGREGATE_FUNC61=null;
        Token char_literal62=null;
        Token char_literal64=null;
        SelectQueryGrammarParser.column_return column60 = null;

        SelectQueryGrammarParser.column_return column63 = null;


        CommonTree AGGREGATE_FUNC61_tree=null;
        CommonTree char_literal62_tree=null;
        CommonTree char_literal64_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:71:5: ( column | AGGREGATE_FUNC '(' column ')' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NAME) ) {
                alt22=1;
            }
            else if ( (LA22_0==AGGREGATE_FUNC) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:71:8: column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_term381);
                    column60=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column60.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:72:4: AGGREGATE_FUNC '(' column ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    AGGREGATE_FUNC61=(Token)match(input,AGGREGATE_FUNC,FOLLOW_AGGREGATE_FUNC_in_term386); 
                    AGGREGATE_FUNC61_tree = (CommonTree)adaptor.create(AGGREGATE_FUNC61);
                    root_0 = (CommonTree)adaptor.becomeRoot(AGGREGATE_FUNC61_tree, root_0);

                    char_literal62=(Token)match(input,17,FOLLOW_17_in_term388); 
                    pushFollow(FOLLOW_column_in_term390);
                    column63=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column63.getTree());
                    char_literal64=(Token)match(input,18,FOLLOW_18_in_term391); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class column_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column"
    // /home/dragan/Dragan/SelectQueryGrammar.g:74:1: column : NAME ;
    public final SelectQueryGrammarParser.column_return column() throws RecognitionException {
        SelectQueryGrammarParser.column_return retval = new SelectQueryGrammarParser.column_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME65=null;

        CommonTree NAME65_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:74:8: ( NAME )
            // /home/dragan/Dragan/SelectQueryGrammar.g:74:10: NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME65=(Token)match(input,NAME,FOLLOW_NAME_in_column401); 
            NAME65_tree = (CommonTree)adaptor.create(NAME65);
            adaptor.addChild(root_0, NAME65_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "column"

    public static class table_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table"
    // /home/dragan/Dragan/SelectQueryGrammar.g:75:1: table : NAME ;
    public final SelectQueryGrammarParser.table_return table() throws RecognitionException {
        SelectQueryGrammarParser.table_return retval = new SelectQueryGrammarParser.table_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME66=null;

        CommonTree NAME66_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:75:7: ( NAME )
            // /home/dragan/Dragan/SelectQueryGrammar.g:75:9: NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME66=(Token)match(input,NAME,FOLLOW_NAME_in_table408); 
            NAME66_tree = (CommonTree)adaptor.create(NAME66);
            adaptor.addChild(root_0, NAME66_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "table"

    // Delegated rules


 

    public static final BitSet FOLLOW_WS_in_query56 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_query_block_in_query60 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_query62 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_block_in_query_block82 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_WS_in_query_block84 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_from_block_in_query_block102 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_WS_in_query_block120 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_where_block_in_query_block124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_block152 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_WS_in_select_block155 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_select_clause_in_select_block158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_select_clause166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_select_clause171 = new BitSet(new long[]{0x0000000000010022L});
    public static final BitSet FOLLOW_WS_in_select_clause174 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_select_clause177 = new BitSet(new long[]{0x000000000000B020L});
    public static final BitSet FOLLOW_WS_in_select_clause180 = new BitSet(new long[]{0x000000000000B000L});
    public static final BitSet FOLLOW_term_in_select_clause184 = new BitSet(new long[]{0x0000000000010022L});
    public static final BitSet FOLLOW_FROM_in_from_block198 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_WS_in_from_block201 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_from_clause_in_from_block204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_query_in_from_clause211 = new BitSet(new long[]{0x0000000000010022L});
    public static final BitSet FOLLOW_WS_in_from_clause214 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_from_clause217 = new BitSet(new long[]{0x0000000000022020L});
    public static final BitSet FOLLOW_WS_in_from_clause220 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_nested_query_in_from_clause224 = new BitSet(new long[]{0x0000000000010022L});
    public static final BitSet FOLLOW_table_in_nested_query236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_nested_query240 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_WS_in_nested_query243 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_query_block_in_nested_query247 = new BitSet(new long[]{0x0000000000040020L});
    public static final BitSet FOLLOW_WS_in_nested_query249 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_nested_query253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where_block265 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_WS_in_where_block268 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_where_clause_in_where_block271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_condition_in_where_clause280 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_WS_in_where_clause283 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_AND_in_where_clause286 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_WS_in_where_clause289 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_where_condition_in_where_clause292 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_column_in_where_condition303 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_WS_in_where_condition305 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OP_in_where_condition309 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_WS_in_where_condition312 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_column_in_where_condition316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_where_condition321 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_WS_in_where_condition323 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OP_in_where_condition327 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_WS_in_where_condition330 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_query_block_in_where_condition334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_block_in_where_condition339 = new BitSet(new long[]{0x0000000000000420L});
    public static final BitSet FOLLOW_WS_in_where_condition341 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_OP_in_where_condition345 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_WS_in_where_condition348 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_column_in_where_condition352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_where_condition357 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_WS_in_where_condition359 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IN_in_where_condition362 = new BitSet(new long[]{0x0000000000020020L});
    public static final BitSet FOLLOW_WS_in_where_condition365 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_where_condition369 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_query_block_in_where_condition371 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_where_condition372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_term381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AGGREGATE_FUNC_in_term386 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_term388 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_column_in_term390 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_term391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_column401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_table408 = new BitSet(new long[]{0x0000000000000002L});

}