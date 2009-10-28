// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/SelectQueryGrammar.g 2009-10-27 23:19:47

package queryopt.parser;
import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SelectQueryGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "QUERY", "LITERAL", "WS", "SELECT", "STAR", "FROM", "WHERE", "AND", "OP", "IN", "AGGREGATE_FUNC", "NAME", "';'", "','", "'('", "')'", "'\\''"
    };
    public static final int WHERE=10;
    public static final int STAR=8;
    public static final int AGGREGATE_FUNC=14;
    public static final int T__20=20;
    public static final int LITERAL=5;
    public static final int AND=11;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int NAME=15;
    public static final int T__16=16;
    public static final int WS=6;
    public static final int IN=13;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int OP=12;
    public static final int QUERY=4;
    public static final int FROM=9;
    public static final int SELECT=7;

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:44:1: query : ( WS )? query_block ';' EOF ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:44:7: ( ( WS )? query_block ';' EOF )
            // /home/dragan/Dragan/SelectQueryGrammar.g:44:9: ( WS )? query_block ';' EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/dragan/Dragan/SelectQueryGrammar.g:44:11: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==WS) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:44:11: WS
                    {
                    WS1=(Token)match(input,WS,FOLLOW_WS_in_query61); 

                    }
                    break;

            }

            pushFollow(FOLLOW_query_block_in_query65);
            query_block2=query_block();

            state._fsp--;

            adaptor.addChild(root_0, query_block2.getTree());
            char_literal3=(Token)match(input,16,FOLLOW_16_in_query67); 
            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_query70); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:46:1: query_block : (select= select_block WS -> ^( QUERY $select) ) (from= from_block -> ^( QUERY $from $select) ) ( WS where= where_block -> ^( QUERY $from $select $where) )? ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:46:13: ( (select= select_block WS -> ^( QUERY $select) ) (from= from_block -> ^( QUERY $from $select) ) ( WS where= where_block -> ^( QUERY $from $select $where) )? )
            // /home/dragan/Dragan/SelectQueryGrammar.g:46:15: (select= select_block WS -> ^( QUERY $select) ) (from= from_block -> ^( QUERY $from $select) ) ( WS where= where_block -> ^( QUERY $from $select $where) )?
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:46:15: (select= select_block WS -> ^( QUERY $select) )
            // /home/dragan/Dragan/SelectQueryGrammar.g:46:16: select= select_block WS
            {
            pushFollow(FOLLOW_select_block_in_query_block87);
            select=select_block();

            state._fsp--;

            stream_select_block.add(select.getTree());
            WS5=(Token)match(input,WS,FOLLOW_WS_in_query_block89);  
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
            // 46:39: -> ^( QUERY $select)
            {
                // /home/dragan/Dragan/SelectQueryGrammar.g:46:41: ^( QUERY $select)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_select.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            // /home/dragan/Dragan/SelectQueryGrammar.g:47:4: (from= from_block -> ^( QUERY $from $select) )
            // /home/dragan/Dragan/SelectQueryGrammar.g:47:5: from= from_block
            {
            pushFollow(FOLLOW_from_block_in_query_block107);
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
            // 47:20: -> ^( QUERY $from $select)
            {
                // /home/dragan/Dragan/SelectQueryGrammar.g:47:23: ^( QUERY $from $select)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUERY, "QUERY"), root_1);

                adaptor.addChild(root_1, stream_from.nextTree());
                adaptor.addChild(root_1, stream_select.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            // /home/dragan/Dragan/SelectQueryGrammar.g:48:4: ( WS where= where_block -> ^( QUERY $from $select $where) )?
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
                    // /home/dragan/Dragan/SelectQueryGrammar.g:48:5: WS where= where_block
                    {
                    WS6=(Token)match(input,WS,FOLLOW_WS_in_query_block126);  
                    stream_WS.add(WS6);

                    pushFollow(FOLLOW_where_block_in_query_block130);
                    where=where_block();

                    state._fsp--;

                    stream_where_block.add(where.getTree());


                    // AST REWRITE
                    // elements: select, from, where
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
                    // 48:25: -> ^( QUERY $from $select $where)
                    {
                        // /home/dragan/Dragan/SelectQueryGrammar.g:48:28: ^( QUERY $from $select $where)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(QUERY, "QUERY"), root_1);

                        adaptor.addChild(root_1, stream_from.nextTree());
                        adaptor.addChild(root_1, stream_select.nextTree());
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:50:1: select_block : SELECT WS select_clause ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:51:2: ( SELECT WS select_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:51:5: SELECT WS select_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            SELECT7=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_block158); 
            SELECT7_tree = (CommonTree)adaptor.create(SELECT7);
            root_0 = (CommonTree)adaptor.becomeRoot(SELECT7_tree, root_0);

            WS8=(Token)match(input,WS,FOLLOW_WS_in_select_block161); 
            pushFollow(FOLLOW_select_clause_in_select_block164);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:53:1: select_clause : ( STAR | term ( ( WS )? ',' ( WS )? term )* );
    public final SelectQueryGrammarParser.select_clause_return select_clause() throws RecognitionException {
        SelectQueryGrammarParser.select_clause_return retval = new SelectQueryGrammarParser.select_clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STAR10=null;
        Token WS12=null;
        Token char_literal13=null;
        Token WS14=null;
        SelectQueryGrammarParser.term_return term11 = null;

        SelectQueryGrammarParser.term_return term15 = null;


        CommonTree STAR10_tree=null;
        CommonTree WS12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree WS14_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:53:15: ( STAR | term ( ( WS )? ',' ( WS )? term )* )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==STAR) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=AGGREGATE_FUNC && LA6_0<=NAME)||LA6_0==20) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:53:17: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STAR10=(Token)match(input,STAR,FOLLOW_STAR_in_select_clause172); 
                    STAR10_tree = (CommonTree)adaptor.create(STAR10);
                    adaptor.addChild(root_0, STAR10_tree);


                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:54:4: term ( ( WS )? ',' ( WS )? term )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_term_in_select_clause177);
                    term11=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term11.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:54:9: ( ( WS )? ',' ( WS )? term )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==WS) ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1==17) ) {
                                alt5=1;
                            }


                        }
                        else if ( (LA5_0==17) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:54:10: ( WS )? ',' ( WS )? term
                    	    {
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:54:12: ( WS )?
                    	    int alt3=2;
                    	    int LA3_0 = input.LA(1);

                    	    if ( (LA3_0==WS) ) {
                    	        alt3=1;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // /home/dragan/Dragan/SelectQueryGrammar.g:54:12: WS
                    	            {
                    	            WS12=(Token)match(input,WS,FOLLOW_WS_in_select_clause180); 

                    	            }
                    	            break;

                    	    }

                    	    char_literal13=(Token)match(input,17,FOLLOW_17_in_select_clause183); 
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:54:21: ( WS )?
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==WS) ) {
                    	        alt4=1;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // /home/dragan/Dragan/SelectQueryGrammar.g:54:21: WS
                    	            {
                    	            WS14=(Token)match(input,WS,FOLLOW_WS_in_select_clause186); 

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_term_in_select_clause190);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:56:1: from_block : FROM WS from_clause ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:57:2: ( FROM WS from_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:57:5: FROM WS from_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            FROM16=(Token)match(input,FROM,FOLLOW_FROM_in_from_block204); 
            FROM16_tree = (CommonTree)adaptor.create(FROM16);
            root_0 = (CommonTree)adaptor.becomeRoot(FROM16_tree, root_0);

            WS17=(Token)match(input,WS,FOLLOW_WS_in_from_block207); 
            pushFollow(FOLLOW_from_clause_in_from_block210);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:58:1: from_clause : nested_query ( ( WS )? ',' ( WS )? nested_query )* ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:58:13: ( nested_query ( ( WS )? ',' ( WS )? nested_query )* )
            // /home/dragan/Dragan/SelectQueryGrammar.g:58:15: nested_query ( ( WS )? ',' ( WS )? nested_query )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_nested_query_in_from_clause217);
            nested_query19=nested_query();

            state._fsp--;

            adaptor.addChild(root_0, nested_query19.getTree());
            // /home/dragan/Dragan/SelectQueryGrammar.g:58:28: ( ( WS )? ',' ( WS )? nested_query )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==WS) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==17) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==17) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:58:29: ( WS )? ',' ( WS )? nested_query
            	    {
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:58:31: ( WS )?
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==WS) ) {
            	        alt7=1;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // /home/dragan/Dragan/SelectQueryGrammar.g:58:31: WS
            	            {
            	            WS20=(Token)match(input,WS,FOLLOW_WS_in_from_clause220); 

            	            }
            	            break;

            	    }

            	    char_literal21=(Token)match(input,17,FOLLOW_17_in_from_clause223); 
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:58:40: ( WS )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==WS) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // /home/dragan/Dragan/SelectQueryGrammar.g:58:40: WS
            	            {
            	            WS22=(Token)match(input,WS,FOLLOW_WS_in_from_clause226); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_nested_query_in_from_clause230);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:60:1: nested_query : ( table | '(' ( WS )? query_block ( WS )? ')' );
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:60:14: ( table | '(' ( WS )? query_block ( WS )? ')' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NAME) ) {
                alt12=1;
            }
            else if ( (LA12_0==18) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:60:16: table
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_table_in_nested_query242);
                    table24=table();

                    state._fsp--;

                    adaptor.addChild(root_0, table24.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:60:24: '(' ( WS )? query_block ( WS )? ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal25=(Token)match(input,18,FOLLOW_18_in_nested_query246); 
                    // /home/dragan/Dragan/SelectQueryGrammar.g:60:31: ( WS )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==WS) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:60:31: WS
                            {
                            WS26=(Token)match(input,WS,FOLLOW_WS_in_nested_query249); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_query_block_in_nested_query253);
                    query_block27=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block27.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:60:48: ( WS )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==WS) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:60:48: WS
                            {
                            WS28=(Token)match(input,WS,FOLLOW_WS_in_nested_query255); 

                            }
                            break;

                    }

                    char_literal29=(Token)match(input,19,FOLLOW_19_in_nested_query259); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:62:1: where_block : WHERE WS where_clause ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:63:2: ( WHERE WS where_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:63:5: WHERE WS where_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            WHERE30=(Token)match(input,WHERE,FOLLOW_WHERE_in_where_block271); 
            WHERE30_tree = (CommonTree)adaptor.create(WHERE30);
            root_0 = (CommonTree)adaptor.becomeRoot(WHERE30_tree, root_0);

            WS31=(Token)match(input,WS,FOLLOW_WS_in_where_block274); 
            pushFollow(FOLLOW_where_clause_in_where_block277);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:65:1: where_clause : where_condition ( WS AND WS where_condition )* ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:65:14: ( where_condition ( WS AND WS where_condition )* )
            // /home/dragan/Dragan/SelectQueryGrammar.g:65:16: where_condition ( WS AND WS where_condition )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_where_condition_in_where_clause286);
            where_condition33=where_condition();

            state._fsp--;

            adaptor.addChild(root_0, where_condition33.getTree());
            // /home/dragan/Dragan/SelectQueryGrammar.g:65:32: ( WS AND WS where_condition )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:65:33: WS AND WS where_condition
            	    {
            	    WS34=(Token)match(input,WS,FOLLOW_WS_in_where_clause289); 
            	    AND35=(Token)match(input,AND,FOLLOW_AND_in_where_clause292); 
            	    AND35_tree = (CommonTree)adaptor.create(AND35);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND35_tree, root_0);

            	    WS36=(Token)match(input,WS,FOLLOW_WS_in_where_clause295); 
            	    pushFollow(FOLLOW_where_condition_in_where_clause298);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:67:1: where_condition : ( column ( WS )? OP ( WS )? column | column ( WS )? OP ( WS )? query_block | query_block ( WS )? OP ( WS )? column | column WS IN ( WS )? '(' query_block ')' );
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:67:16: ( column ( WS )? OP ( WS )? column | column ( WS )? OP ( WS )? query_block | query_block ( WS )? OP ( WS )? column | column WS IN ( WS )? '(' query_block ')' )
            int alt21=4;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:67:19: column ( WS )? OP ( WS )? column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition309);
                    column38=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column38.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:67:28: ( WS )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==WS) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:67:28: WS
                            {
                            WS39=(Token)match(input,WS,FOLLOW_WS_in_where_condition311); 

                            }
                            break;

                    }

                    OP40=(Token)match(input,OP,FOLLOW_OP_in_where_condition315); 
                    OP40_tree = (CommonTree)adaptor.create(OP40);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP40_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:67:37: ( WS )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==WS) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:67:37: WS
                            {
                            WS41=(Token)match(input,WS,FOLLOW_WS_in_where_condition318); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_column_in_where_condition322);
                    column42=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column42.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:68:4: column ( WS )? OP ( WS )? query_block
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition327);
                    column43=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column43.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:68:13: ( WS )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==WS) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:68:13: WS
                            {
                            WS44=(Token)match(input,WS,FOLLOW_WS_in_where_condition329); 

                            }
                            break;

                    }

                    OP45=(Token)match(input,OP,FOLLOW_OP_in_where_condition333); 
                    OP45_tree = (CommonTree)adaptor.create(OP45);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP45_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:68:22: ( WS )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==WS) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:68:22: WS
                            {
                            WS46=(Token)match(input,WS,FOLLOW_WS_in_where_condition336); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_query_block_in_where_condition340);
                    query_block47=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block47.getTree());

                    }
                    break;
                case 3 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:69:4: query_block ( WS )? OP ( WS )? column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_query_block_in_where_condition345);
                    query_block48=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block48.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:69:18: ( WS )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==WS) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:69:18: WS
                            {
                            WS49=(Token)match(input,WS,FOLLOW_WS_in_where_condition347); 

                            }
                            break;

                    }

                    OP50=(Token)match(input,OP,FOLLOW_OP_in_where_condition351); 
                    OP50_tree = (CommonTree)adaptor.create(OP50);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP50_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:69:27: ( WS )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==WS) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:69:27: WS
                            {
                            WS51=(Token)match(input,WS,FOLLOW_WS_in_where_condition354); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_column_in_where_condition358);
                    column52=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column52.getTree());

                    }
                    break;
                case 4 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:70:4: column WS IN ( WS )? '(' query_block ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition363);
                    column53=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column53.getTree());
                    WS54=(Token)match(input,WS,FOLLOW_WS_in_where_condition365); 
                    IN55=(Token)match(input,IN,FOLLOW_IN_in_where_condition368); 
                    IN55_tree = (CommonTree)adaptor.create(IN55);
                    root_0 = (CommonTree)adaptor.becomeRoot(IN55_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:70:21: ( WS )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==WS) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:70:21: WS
                            {
                            WS56=(Token)match(input,WS,FOLLOW_WS_in_where_condition371); 

                            }
                            break;

                    }

                    char_literal57=(Token)match(input,18,FOLLOW_18_in_where_condition375); 
                    pushFollow(FOLLOW_query_block_in_where_condition377);
                    query_block58=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block58.getTree());
                    char_literal59=(Token)match(input,19,FOLLOW_19_in_where_condition378); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:72:1: term : ( column | AGGREGATE_FUNC '(' column ')' );
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:72:5: ( column | AGGREGATE_FUNC '(' column ')' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==NAME||LA22_0==20) ) {
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
                    // /home/dragan/Dragan/SelectQueryGrammar.g:72:8: column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_term387);
                    column60=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column60.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:73:4: AGGREGATE_FUNC '(' column ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    AGGREGATE_FUNC61=(Token)match(input,AGGREGATE_FUNC,FOLLOW_AGGREGATE_FUNC_in_term392); 
                    AGGREGATE_FUNC61_tree = (CommonTree)adaptor.create(AGGREGATE_FUNC61);
                    root_0 = (CommonTree)adaptor.becomeRoot(AGGREGATE_FUNC61_tree, root_0);

                    char_literal62=(Token)match(input,18,FOLLOW_18_in_term394); 
                    pushFollow(FOLLOW_column_in_term396);
                    column63=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column63.getTree());
                    char_literal64=(Token)match(input,19,FOLLOW_19_in_term397); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:75:1: column : ( (col= NAME -> $col) | ( '\\'' literal= NAME '\\'' -> ^( LITERAL $literal) ) );
    public final SelectQueryGrammarParser.column_return column() throws RecognitionException {
        SelectQueryGrammarParser.column_return retval = new SelectQueryGrammarParser.column_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token col=null;
        Token literal=null;
        Token char_literal65=null;
        Token char_literal66=null;

        CommonTree col_tree=null;
        CommonTree literal_tree=null;
        CommonTree char_literal65_tree=null;
        CommonTree char_literal66_tree=null;
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:75:8: ( (col= NAME -> $col) | ( '\\'' literal= NAME '\\'' -> ^( LITERAL $literal) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==NAME) ) {
                alt23=1;
            }
            else if ( (LA23_0==20) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:75:10: (col= NAME -> $col)
                    {
                    // /home/dragan/Dragan/SelectQueryGrammar.g:75:10: (col= NAME -> $col)
                    // /home/dragan/Dragan/SelectQueryGrammar.g:75:11: col= NAME
                    {
                    col=(Token)match(input,NAME,FOLLOW_NAME_in_column410);  
                    stream_NAME.add(col);



                    // AST REWRITE
                    // elements: col
                    // token labels: col
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_col=new RewriteRuleTokenStream(adaptor,"token col",col);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 75:20: -> $col
                    {
                        adaptor.addChild(root_0, stream_col.nextNode());

                    }

                    retval.tree = root_0;
                    }


                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:76:5: ( '\\'' literal= NAME '\\'' -> ^( LITERAL $literal) )
                    {
                    // /home/dragan/Dragan/SelectQueryGrammar.g:76:5: ( '\\'' literal= NAME '\\'' -> ^( LITERAL $literal) )
                    // /home/dragan/Dragan/SelectQueryGrammar.g:76:6: '\\'' literal= NAME '\\''
                    {
                    char_literal65=(Token)match(input,20,FOLLOW_20_in_column424);  
                    stream_20.add(char_literal65);

                    literal=(Token)match(input,NAME,FOLLOW_NAME_in_column427);  
                    stream_NAME.add(literal);

                    char_literal66=(Token)match(input,20,FOLLOW_20_in_column428);  
                    stream_20.add(char_literal66);



                    // AST REWRITE
                    // elements: literal
                    // token labels: literal
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_literal=new RewriteRuleTokenStream(adaptor,"token literal",literal);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 76:26: -> ^( LITERAL $literal)
                    {
                        // /home/dragan/Dragan/SelectQueryGrammar.g:76:29: ^( LITERAL $literal)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LITERAL, "LITERAL"), root_1);

                        adaptor.addChild(root_1, stream_literal.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }


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
    // $ANTLR end "column"

    public static class table_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table"
    // /home/dragan/Dragan/SelectQueryGrammar.g:77:1: table : NAME ;
    public final SelectQueryGrammarParser.table_return table() throws RecognitionException {
        SelectQueryGrammarParser.table_return retval = new SelectQueryGrammarParser.table_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME67=null;

        CommonTree NAME67_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:77:7: ( NAME )
            // /home/dragan/Dragan/SelectQueryGrammar.g:77:9: NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME67=(Token)match(input,NAME,FOLLOW_NAME_in_table446); 
            NAME67_tree = (CommonTree)adaptor.create(NAME67);
            adaptor.addChild(root_0, NAME67_tree);


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


    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA21_eotS =
        "\14\uffff";
    static final String DFA21_eofS =
        "\14\uffff";
    static final String DFA21_minS =
        "\1\7\1\6\1\17\1\uffff\1\14\1\6\1\24\1\uffff\1\7\2\uffff\1\6";
    static final String DFA21_maxS =
        "\1\24\1\14\1\17\1\uffff\1\15\2\24\1\uffff\1\24\2\uffff\1\14";
    static final String DFA21_acceptS =
        "\3\uffff\1\3\3\uffff\1\4\1\uffff\1\1\1\2\1\uffff";
    static final String DFA21_specialS =
        "\14\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\7\uffff\1\1\4\uffff\1\2",
            "\1\4\5\uffff\1\5",
            "\1\6",
            "",
            "\1\5\1\7",
            "\1\10\1\12\7\uffff\1\11\4\uffff\1\11",
            "\1\13",
            "",
            "\1\12\7\uffff\1\11\4\uffff\1\11",
            "",
            "",
            "\1\4\5\uffff\1\5"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "67:1: where_condition : ( column ( WS )? OP ( WS )? column | column ( WS )? OP ( WS )? query_block | query_block ( WS )? OP ( WS )? column | column WS IN ( WS )? '(' query_block ')' );";
        }
    }
 

    public static final BitSet FOLLOW_WS_in_query61 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_query_block_in_query65 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_query67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_block_in_query_block87 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_WS_in_query_block89 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_from_block_in_query_block107 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_WS_in_query_block126 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_where_block_in_query_block130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_block158 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_WS_in_select_block161 = new BitSet(new long[]{0x000000000010C100L});
    public static final BitSet FOLLOW_select_clause_in_select_block164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_select_clause172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_select_clause177 = new BitSet(new long[]{0x0000000000020042L});
    public static final BitSet FOLLOW_WS_in_select_clause180 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_select_clause183 = new BitSet(new long[]{0x000000000010C140L});
    public static final BitSet FOLLOW_WS_in_select_clause186 = new BitSet(new long[]{0x000000000010C100L});
    public static final BitSet FOLLOW_term_in_select_clause190 = new BitSet(new long[]{0x0000000000020042L});
    public static final BitSet FOLLOW_FROM_in_from_block204 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_WS_in_from_block207 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_from_clause_in_from_block210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_query_in_from_clause217 = new BitSet(new long[]{0x0000000000020042L});
    public static final BitSet FOLLOW_WS_in_from_clause220 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_from_clause223 = new BitSet(new long[]{0x0000000000048040L});
    public static final BitSet FOLLOW_WS_in_from_clause226 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_nested_query_in_from_clause230 = new BitSet(new long[]{0x0000000000020042L});
    public static final BitSet FOLLOW_table_in_nested_query242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_nested_query246 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_WS_in_nested_query249 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_query_block_in_nested_query253 = new BitSet(new long[]{0x0000000000080040L});
    public static final BitSet FOLLOW_WS_in_nested_query255 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_nested_query259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where_block271 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_WS_in_where_block274 = new BitSet(new long[]{0x0000000000108080L});
    public static final BitSet FOLLOW_where_clause_in_where_block277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_condition_in_where_clause286 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_WS_in_where_clause289 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_AND_in_where_clause292 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_WS_in_where_clause295 = new BitSet(new long[]{0x0000000000108080L});
    public static final BitSet FOLLOW_where_condition_in_where_clause298 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_column_in_where_condition309 = new BitSet(new long[]{0x0000000000001040L});
    public static final BitSet FOLLOW_WS_in_where_condition311 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_OP_in_where_condition315 = new BitSet(new long[]{0x0000000000108040L});
    public static final BitSet FOLLOW_WS_in_where_condition318 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_column_in_where_condition322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_where_condition327 = new BitSet(new long[]{0x0000000000001040L});
    public static final BitSet FOLLOW_WS_in_where_condition329 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_OP_in_where_condition333 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_WS_in_where_condition336 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_query_block_in_where_condition340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_block_in_where_condition345 = new BitSet(new long[]{0x0000000000001040L});
    public static final BitSet FOLLOW_WS_in_where_condition347 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_OP_in_where_condition351 = new BitSet(new long[]{0x0000000000108040L});
    public static final BitSet FOLLOW_WS_in_where_condition354 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_column_in_where_condition358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_where_condition363 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_WS_in_where_condition365 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IN_in_where_condition368 = new BitSet(new long[]{0x0000000000040040L});
    public static final BitSet FOLLOW_WS_in_where_condition371 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_where_condition375 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_query_block_in_where_condition377 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_where_condition378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_term387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AGGREGATE_FUNC_in_term392 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_term394 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_column_in_term396 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_term397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_column410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_column424 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_NAME_in_column427 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_column428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_table446 = new BitSet(new long[]{0x0000000000000002L});

}