// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/SelectQueryGrammar.g 2009-10-26 23:11:17

package queryopt.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SelectQueryGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "SELECT", "FROM", "WHERE", "AND", "OP", "IN", "AGGREGATE_FUNC", "NAME", "';'", "'*'", "','", "'('", "')'"
    };
    public static final int WHERE=7;
    public static final int NAME=12;
    public static final int WS=4;
    public static final int T__16=16;
    public static final int IN=10;
    public static final int T__15=15;
    public static final int AGGREGATE_FUNC=11;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int OP=9;
    public static final int AND=8;
    public static final int FROM=6;
    public static final int EOF=-1;
    public static final int SELECT=5;

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


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // /home/dragan/Dragan/SelectQueryGrammar.g:15:1: query : ( WS )? query_block ';' EOF ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:15:7: ( ( WS )? query_block ';' EOF )
            // /home/dragan/Dragan/SelectQueryGrammar.g:15:9: ( WS )? query_block ';' EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/dragan/Dragan/SelectQueryGrammar.g:15:11: ( WS )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==WS) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:15:11: WS
                    {
                    WS1=(Token)match(input,WS,FOLLOW_WS_in_query42); 

                    }
                    break;

            }

            pushFollow(FOLLOW_query_block_in_query46);
            query_block2=query_block();

            state._fsp--;

            adaptor.addChild(root_0, query_block2.getTree());
            char_literal3=(Token)match(input,13,FOLLOW_13_in_query48); 
            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_query51); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:17:1: query_block : (select= select_block WS -> $select) (from= from_block -> $query_block $from) ( WS where= where_block -> $query_block $where)? ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:17:13: ( (select= select_block WS -> $select) (from= from_block -> $query_block $from) ( WS where= where_block -> $query_block $where)? )
            // /home/dragan/Dragan/SelectQueryGrammar.g:17:15: (select= select_block WS -> $select) (from= from_block -> $query_block $from) ( WS where= where_block -> $query_block $where)?
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:17:15: (select= select_block WS -> $select)
            // /home/dragan/Dragan/SelectQueryGrammar.g:17:16: select= select_block WS
            {
            pushFollow(FOLLOW_select_block_in_query_block65);
            select=select_block();

            state._fsp--;

            stream_select_block.add(select.getTree());
            WS5=(Token)match(input,WS,FOLLOW_WS_in_query_block67);  
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
            // 17:39: -> $select
            {
                adaptor.addChild(root_0, stream_select.nextTree());

            }

            retval.tree = root_0;
            }

            // /home/dragan/Dragan/SelectQueryGrammar.g:18:4: (from= from_block -> $query_block $from)
            // /home/dragan/Dragan/SelectQueryGrammar.g:18:5: from= from_block
            {
            pushFollow(FOLLOW_from_block_in_query_block80);
            from=from_block();

            state._fsp--;

            stream_from_block.add(from.getTree());


            // AST REWRITE
            // elements: from, query_block
            // token labels: 
            // rule labels: retval, from
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_from=new RewriteRuleSubtreeStream(adaptor,"rule from",from!=null?from.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 18:20: -> $query_block $from
            {
                adaptor.addChild(root_0, stream_retval.nextTree());
                adaptor.addChild(root_0, stream_from.nextTree());

            }

            retval.tree = root_0;
            }

            // /home/dragan/Dragan/SelectQueryGrammar.g:19:4: ( WS where= where_block -> $query_block $where)?
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
                    // /home/dragan/Dragan/SelectQueryGrammar.g:19:5: WS where= where_block
                    {
                    WS6=(Token)match(input,WS,FOLLOW_WS_in_query_block94);  
                    stream_WS.add(WS6);

                    pushFollow(FOLLOW_where_block_in_query_block98);
                    where=where_block();

                    state._fsp--;

                    stream_where_block.add(where.getTree());


                    // AST REWRITE
                    // elements: query_block, where
                    // token labels: 
                    // rule labels: retval, where
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_where=new RewriteRuleSubtreeStream(adaptor,"rule where",where!=null?where.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 19:25: -> $query_block $where
                    {
                        adaptor.addChild(root_0, stream_retval.nextTree());
                        adaptor.addChild(root_0, stream_where.nextTree());

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:21:1: select_block : SELECT WS select_clause ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:22:2: ( SELECT WS select_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:22:5: SELECT WS select_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            SELECT7=(Token)match(input,SELECT,FOLLOW_SELECT_in_select_block118); 
            SELECT7_tree = (CommonTree)adaptor.create(SELECT7);
            root_0 = (CommonTree)adaptor.becomeRoot(SELECT7_tree, root_0);

            WS8=(Token)match(input,WS,FOLLOW_WS_in_select_block121); 
            pushFollow(FOLLOW_select_clause_in_select_block124);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:24:1: select_clause : ( '*' | term ( ( WS )? ',' ( WS )? term )* );
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:24:15: ( '*' | term ( ( WS )? ',' ( WS )? term )* )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
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
                    // /home/dragan/Dragan/SelectQueryGrammar.g:24:17: '*'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal10=(Token)match(input,14,FOLLOW_14_in_select_clause132); 
                    char_literal10_tree = (CommonTree)adaptor.create(char_literal10);
                    adaptor.addChild(root_0, char_literal10_tree);


                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:25:4: term ( ( WS )? ',' ( WS )? term )*
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_term_in_select_clause137);
                    term11=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term11.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:25:9: ( ( WS )? ',' ( WS )? term )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==WS) ) {
                            int LA5_1 = input.LA(2);

                            if ( (LA5_1==15) ) {
                                alt5=1;
                            }


                        }
                        else if ( (LA5_0==15) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:25:10: ( WS )? ',' ( WS )? term
                    	    {
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:25:12: ( WS )?
                    	    int alt3=2;
                    	    int LA3_0 = input.LA(1);

                    	    if ( (LA3_0==WS) ) {
                    	        alt3=1;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // /home/dragan/Dragan/SelectQueryGrammar.g:25:12: WS
                    	            {
                    	            WS12=(Token)match(input,WS,FOLLOW_WS_in_select_clause140); 

                    	            }
                    	            break;

                    	    }

                    	    char_literal13=(Token)match(input,15,FOLLOW_15_in_select_clause143); 
                    	    // /home/dragan/Dragan/SelectQueryGrammar.g:25:21: ( WS )?
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==WS) ) {
                    	        alt4=1;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // /home/dragan/Dragan/SelectQueryGrammar.g:25:21: WS
                    	            {
                    	            WS14=(Token)match(input,WS,FOLLOW_WS_in_select_clause146); 

                    	            }
                    	            break;

                    	    }

                    	    pushFollow(FOLLOW_term_in_select_clause150);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:27:1: from_block : FROM WS from_clause ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:28:2: ( FROM WS from_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:28:5: FROM WS from_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            FROM16=(Token)match(input,FROM,FOLLOW_FROM_in_from_block164); 
            FROM16_tree = (CommonTree)adaptor.create(FROM16);
            root_0 = (CommonTree)adaptor.becomeRoot(FROM16_tree, root_0);

            WS17=(Token)match(input,WS,FOLLOW_WS_in_from_block167); 
            pushFollow(FOLLOW_from_clause_in_from_block170);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:29:1: from_clause : nested_query ( ( WS )? ',' ( WS )? nested_query )* ;
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:29:13: ( nested_query ( ( WS )? ',' ( WS )? nested_query )* )
            // /home/dragan/Dragan/SelectQueryGrammar.g:29:15: nested_query ( ( WS )? ',' ( WS )? nested_query )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_nested_query_in_from_clause177);
            nested_query19=nested_query();

            state._fsp--;

            adaptor.addChild(root_0, nested_query19.getTree());
            // /home/dragan/Dragan/SelectQueryGrammar.g:29:28: ( ( WS )? ',' ( WS )? nested_query )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==WS) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==15) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:29:29: ( WS )? ',' ( WS )? nested_query
            	    {
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:29:31: ( WS )?
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==WS) ) {
            	        alt7=1;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // /home/dragan/Dragan/SelectQueryGrammar.g:29:31: WS
            	            {
            	            WS20=(Token)match(input,WS,FOLLOW_WS_in_from_clause180); 

            	            }
            	            break;

            	    }

            	    char_literal21=(Token)match(input,15,FOLLOW_15_in_from_clause183); 
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:29:40: ( WS )?
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==WS) ) {
            	        alt8=1;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // /home/dragan/Dragan/SelectQueryGrammar.g:29:40: WS
            	            {
            	            WS22=(Token)match(input,WS,FOLLOW_WS_in_from_clause186); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_nested_query_in_from_clause190);
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:31:1: nested_query : ( table | '(' query ')' );
    public final SelectQueryGrammarParser.nested_query_return nested_query() throws RecognitionException {
        SelectQueryGrammarParser.nested_query_return retval = new SelectQueryGrammarParser.nested_query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal25=null;
        Token char_literal27=null;
        SelectQueryGrammarParser.table_return table24 = null;

        SelectQueryGrammarParser.query_return query26 = null;


        CommonTree char_literal25_tree=null;
        CommonTree char_literal27_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:31:14: ( table | '(' query ')' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==NAME) ) {
                alt10=1;
            }
            else if ( (LA10_0==16) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:31:16: table
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_table_in_nested_query202);
                    table24=table();

                    state._fsp--;

                    adaptor.addChild(root_0, table24.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:31:24: '(' query ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal25=(Token)match(input,16,FOLLOW_16_in_nested_query206); 
                    pushFollow(FOLLOW_query_in_nested_query209);
                    query26=query();

                    state._fsp--;

                    adaptor.addChild(root_0, query26.getTree());
                    char_literal27=(Token)match(input,17,FOLLOW_17_in_nested_query211); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:33:1: where_block : WHERE WS where_clause ;
    public final SelectQueryGrammarParser.where_block_return where_block() throws RecognitionException {
        SelectQueryGrammarParser.where_block_return retval = new SelectQueryGrammarParser.where_block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHERE28=null;
        Token WS29=null;
        SelectQueryGrammarParser.where_clause_return where_clause30 = null;


        CommonTree WHERE28_tree=null;
        CommonTree WS29_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:34:2: ( WHERE WS where_clause )
            // /home/dragan/Dragan/SelectQueryGrammar.g:34:5: WHERE WS where_clause
            {
            root_0 = (CommonTree)adaptor.nil();

            WHERE28=(Token)match(input,WHERE,FOLLOW_WHERE_in_where_block223); 
            WHERE28_tree = (CommonTree)adaptor.create(WHERE28);
            root_0 = (CommonTree)adaptor.becomeRoot(WHERE28_tree, root_0);

            WS29=(Token)match(input,WS,FOLLOW_WS_in_where_block226); 
            pushFollow(FOLLOW_where_clause_in_where_block229);
            where_clause30=where_clause();

            state._fsp--;

            adaptor.addChild(root_0, where_clause30.getTree());

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:36:1: where_clause : where_condition ( WS AND WS where_condition )* ;
    public final SelectQueryGrammarParser.where_clause_return where_clause() throws RecognitionException {
        SelectQueryGrammarParser.where_clause_return retval = new SelectQueryGrammarParser.where_clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS32=null;
        Token AND33=null;
        Token WS34=null;
        SelectQueryGrammarParser.where_condition_return where_condition31 = null;

        SelectQueryGrammarParser.where_condition_return where_condition35 = null;


        CommonTree WS32_tree=null;
        CommonTree AND33_tree=null;
        CommonTree WS34_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:36:14: ( where_condition ( WS AND WS where_condition )* )
            // /home/dragan/Dragan/SelectQueryGrammar.g:36:16: where_condition ( WS AND WS where_condition )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_where_condition_in_where_clause238);
            where_condition31=where_condition();

            state._fsp--;

            adaptor.addChild(root_0, where_condition31.getTree());
            // /home/dragan/Dragan/SelectQueryGrammar.g:36:32: ( WS AND WS where_condition )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==WS) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:36:33: WS AND WS where_condition
            	    {
            	    WS32=(Token)match(input,WS,FOLLOW_WS_in_where_clause241); 
            	    AND33=(Token)match(input,AND,FOLLOW_AND_in_where_clause244); 
            	    AND33_tree = (CommonTree)adaptor.create(AND33);
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND33_tree, root_0);

            	    WS34=(Token)match(input,WS,FOLLOW_WS_in_where_clause247); 
            	    pushFollow(FOLLOW_where_condition_in_where_clause250);
            	    where_condition35=where_condition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, where_condition35.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // /home/dragan/Dragan/SelectQueryGrammar.g:38:1: where_condition : ( column ( WS )? OP ( WS )? column | column ( WS )? OP ( WS )? query_block | query_block ( WS )? OP ( WS )? column | column WS IN ( WS )? '(' query_block ')' );
    public final SelectQueryGrammarParser.where_condition_return where_condition() throws RecognitionException {
        SelectQueryGrammarParser.where_condition_return retval = new SelectQueryGrammarParser.where_condition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS37=null;
        Token OP38=null;
        Token WS39=null;
        Token WS42=null;
        Token OP43=null;
        Token WS44=null;
        Token WS47=null;
        Token OP48=null;
        Token WS49=null;
        Token WS52=null;
        Token IN53=null;
        Token WS54=null;
        Token char_literal55=null;
        Token char_literal57=null;
        SelectQueryGrammarParser.column_return column36 = null;

        SelectQueryGrammarParser.column_return column40 = null;

        SelectQueryGrammarParser.column_return column41 = null;

        SelectQueryGrammarParser.query_block_return query_block45 = null;

        SelectQueryGrammarParser.query_block_return query_block46 = null;

        SelectQueryGrammarParser.column_return column50 = null;

        SelectQueryGrammarParser.column_return column51 = null;

        SelectQueryGrammarParser.query_block_return query_block56 = null;


        CommonTree WS37_tree=null;
        CommonTree OP38_tree=null;
        CommonTree WS39_tree=null;
        CommonTree WS42_tree=null;
        CommonTree OP43_tree=null;
        CommonTree WS44_tree=null;
        CommonTree WS47_tree=null;
        CommonTree OP48_tree=null;
        CommonTree WS49_tree=null;
        CommonTree WS52_tree=null;
        CommonTree IN53_tree=null;
        CommonTree WS54_tree=null;
        CommonTree char_literal55_tree=null;
        CommonTree char_literal57_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:38:16: ( column ( WS )? OP ( WS )? column | column ( WS )? OP ( WS )? query_block | query_block ( WS )? OP ( WS )? column | column WS IN ( WS )? '(' query_block ')' )
            int alt19=4;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==NAME) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==WS) ) {
                    int LA19_3 = input.LA(3);

                    if ( (LA19_3==IN) ) {
                        alt19=4;
                    }
                    else if ( (LA19_3==OP) ) {
                        switch ( input.LA(4) ) {
                        case WS:
                            {
                            int LA19_6 = input.LA(5);

                            if ( (LA19_6==NAME) ) {
                                alt19=1;
                            }
                            else if ( (LA19_6==SELECT) ) {
                                alt19=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 19, 6, input);

                                throw nvae;
                            }
                            }
                            break;
                        case NAME:
                            {
                            alt19=1;
                            }
                            break;
                        case SELECT:
                            {
                            alt19=2;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 4, input);

                            throw nvae;
                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA19_1==OP) ) {
                    switch ( input.LA(3) ) {
                    case WS:
                        {
                        int LA19_6 = input.LA(4);

                        if ( (LA19_6==NAME) ) {
                            alt19=1;
                        }
                        else if ( (LA19_6==SELECT) ) {
                            alt19=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 6, input);

                            throw nvae;
                        }
                        }
                        break;
                    case NAME:
                        {
                        alt19=1;
                        }
                        break;
                    case SELECT:
                        {
                        alt19=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 4, input);

                        throw nvae;
                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA19_0==SELECT) ) {
                alt19=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:38:19: column ( WS )? OP ( WS )? column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition261);
                    column36=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column36.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:38:28: ( WS )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==WS) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:38:28: WS
                            {
                            WS37=(Token)match(input,WS,FOLLOW_WS_in_where_condition263); 

                            }
                            break;

                    }

                    OP38=(Token)match(input,OP,FOLLOW_OP_in_where_condition267); 
                    OP38_tree = (CommonTree)adaptor.create(OP38);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP38_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:38:37: ( WS )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==WS) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:38:37: WS
                            {
                            WS39=(Token)match(input,WS,FOLLOW_WS_in_where_condition270); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_column_in_where_condition274);
                    column40=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column40.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:39:4: column ( WS )? OP ( WS )? query_block
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition279);
                    column41=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column41.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:39:13: ( WS )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==WS) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:39:13: WS
                            {
                            WS42=(Token)match(input,WS,FOLLOW_WS_in_where_condition281); 

                            }
                            break;

                    }

                    OP43=(Token)match(input,OP,FOLLOW_OP_in_where_condition285); 
                    OP43_tree = (CommonTree)adaptor.create(OP43);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP43_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:39:22: ( WS )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==WS) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:39:22: WS
                            {
                            WS44=(Token)match(input,WS,FOLLOW_WS_in_where_condition288); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_query_block_in_where_condition292);
                    query_block45=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block45.getTree());

                    }
                    break;
                case 3 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:40:4: query_block ( WS )? OP ( WS )? column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_query_block_in_where_condition297);
                    query_block46=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block46.getTree());
                    // /home/dragan/Dragan/SelectQueryGrammar.g:40:18: ( WS )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==WS) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:40:18: WS
                            {
                            WS47=(Token)match(input,WS,FOLLOW_WS_in_where_condition299); 

                            }
                            break;

                    }

                    OP48=(Token)match(input,OP,FOLLOW_OP_in_where_condition303); 
                    OP48_tree = (CommonTree)adaptor.create(OP48);
                    root_0 = (CommonTree)adaptor.becomeRoot(OP48_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:40:27: ( WS )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==WS) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:40:27: WS
                            {
                            WS49=(Token)match(input,WS,FOLLOW_WS_in_where_condition306); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_column_in_where_condition310);
                    column50=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column50.getTree());

                    }
                    break;
                case 4 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:41:4: column WS IN ( WS )? '(' query_block ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_where_condition315);
                    column51=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column51.getTree());
                    WS52=(Token)match(input,WS,FOLLOW_WS_in_where_condition317); 
                    IN53=(Token)match(input,IN,FOLLOW_IN_in_where_condition320); 
                    IN53_tree = (CommonTree)adaptor.create(IN53);
                    root_0 = (CommonTree)adaptor.becomeRoot(IN53_tree, root_0);

                    // /home/dragan/Dragan/SelectQueryGrammar.g:41:21: ( WS )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==WS) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/dragan/Dragan/SelectQueryGrammar.g:41:21: WS
                            {
                            WS54=(Token)match(input,WS,FOLLOW_WS_in_where_condition323); 

                            }
                            break;

                    }

                    char_literal55=(Token)match(input,16,FOLLOW_16_in_where_condition327); 
                    pushFollow(FOLLOW_query_block_in_where_condition329);
                    query_block56=query_block();

                    state._fsp--;

                    adaptor.addChild(root_0, query_block56.getTree());
                    char_literal57=(Token)match(input,17,FOLLOW_17_in_where_condition330); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:43:1: term : ( column | AGGREGATE_FUNC '(' column ')' );
    public final SelectQueryGrammarParser.term_return term() throws RecognitionException {
        SelectQueryGrammarParser.term_return retval = new SelectQueryGrammarParser.term_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AGGREGATE_FUNC59=null;
        Token char_literal60=null;
        Token char_literal62=null;
        SelectQueryGrammarParser.column_return column58 = null;

        SelectQueryGrammarParser.column_return column61 = null;


        CommonTree AGGREGATE_FUNC59_tree=null;
        CommonTree char_literal60_tree=null;
        CommonTree char_literal62_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:43:5: ( column | AGGREGATE_FUNC '(' column ')' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==NAME) ) {
                alt20=1;
            }
            else if ( (LA20_0==AGGREGATE_FUNC) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:43:8: column
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_column_in_term339);
                    column58=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column58.getTree());

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:44:4: AGGREGATE_FUNC '(' column ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    AGGREGATE_FUNC59=(Token)match(input,AGGREGATE_FUNC,FOLLOW_AGGREGATE_FUNC_in_term344); 
                    AGGREGATE_FUNC59_tree = (CommonTree)adaptor.create(AGGREGATE_FUNC59);
                    root_0 = (CommonTree)adaptor.becomeRoot(AGGREGATE_FUNC59_tree, root_0);

                    char_literal60=(Token)match(input,16,FOLLOW_16_in_term346); 
                    pushFollow(FOLLOW_column_in_term348);
                    column61=column();

                    state._fsp--;

                    adaptor.addChild(root_0, column61.getTree());
                    char_literal62=(Token)match(input,17,FOLLOW_17_in_term349); 

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
    // /home/dragan/Dragan/SelectQueryGrammar.g:46:1: column : NAME ;
    public final SelectQueryGrammarParser.column_return column() throws RecognitionException {
        SelectQueryGrammarParser.column_return retval = new SelectQueryGrammarParser.column_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME63=null;

        CommonTree NAME63_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:46:8: ( NAME )
            // /home/dragan/Dragan/SelectQueryGrammar.g:46:10: NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME63=(Token)match(input,NAME,FOLLOW_NAME_in_column359); 
            NAME63_tree = (CommonTree)adaptor.create(NAME63);
            adaptor.addChild(root_0, NAME63_tree);


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
    // /home/dragan/Dragan/SelectQueryGrammar.g:47:1: table : NAME ;
    public final SelectQueryGrammarParser.table_return table() throws RecognitionException {
        SelectQueryGrammarParser.table_return retval = new SelectQueryGrammarParser.table_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME64=null;

        CommonTree NAME64_tree=null;

        try {
            // /home/dragan/Dragan/SelectQueryGrammar.g:47:7: ( NAME )
            // /home/dragan/Dragan/SelectQueryGrammar.g:47:9: NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            NAME64=(Token)match(input,NAME,FOLLOW_NAME_in_table366); 
            NAME64_tree = (CommonTree)adaptor.create(NAME64);
            adaptor.addChild(root_0, NAME64_tree);


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


 

    public static final BitSet FOLLOW_WS_in_query42 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_query_block_in_query46 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_query48 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_block_in_query_block65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_query_block67 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_from_block_in_query_block80 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_query_block94 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_where_block_in_query_block98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_block118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_select_block121 = new BitSet(new long[]{0x0000000000005800L});
    public static final BitSet FOLLOW_select_clause_in_select_block124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_select_clause132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_select_clause137 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_WS_in_select_clause140 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_select_clause143 = new BitSet(new long[]{0x0000000000005810L});
    public static final BitSet FOLLOW_WS_in_select_clause146 = new BitSet(new long[]{0x0000000000005800L});
    public static final BitSet FOLLOW_term_in_select_clause150 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_FROM_in_from_block164 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_from_block167 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_from_clause_in_from_block170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_query_in_from_clause177 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_WS_in_from_clause180 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_from_clause183 = new BitSet(new long[]{0x0000000000011010L});
    public static final BitSet FOLLOW_WS_in_from_clause186 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_nested_query_in_from_clause190 = new BitSet(new long[]{0x0000000000008012L});
    public static final BitSet FOLLOW_table_in_nested_query202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_nested_query206 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_query_in_nested_query209 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_nested_query211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where_block223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_where_block226 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_where_clause_in_where_block229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_where_condition_in_where_clause238 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_where_clause241 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AND_in_where_clause244 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_where_clause247 = new BitSet(new long[]{0x0000000000001020L});
    public static final BitSet FOLLOW_where_condition_in_where_clause250 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_column_in_where_condition261 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_WS_in_where_condition263 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OP_in_where_condition267 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_WS_in_where_condition270 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_column_in_where_condition274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_where_condition279 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_WS_in_where_condition281 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OP_in_where_condition285 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_WS_in_where_condition288 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_query_block_in_where_condition292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_block_in_where_condition297 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_WS_in_where_condition299 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_OP_in_where_condition303 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_WS_in_where_condition306 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_column_in_where_condition310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_where_condition315 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_where_condition317 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IN_in_where_condition320 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_WS_in_where_condition323 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_where_condition327 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_query_block_in_where_condition329 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_where_condition330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_term339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AGGREGATE_FUNC_in_term344 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_term346 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_column_in_term348 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_term349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_column359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_table366 = new BitSet(new long[]{0x0000000000000002L});

}