// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g 2009-11-25 13:52:47

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class SQL_grammarParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NAME", "STAR", "WS", "';'", "'SELECT'", "','", "'FROM'", "'WHERE'", "'AND'", "'='", "'<'", "'>'", "'<='", "'>='"
    };
    public static final int NAME=4;
    public static final int WS=6;
    public static final int STAR=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__8=8;
    public static final int T__7=7;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "query", "select", "from", "op", "clause", "and", 
        "where"
    };
     
        public int ruleLevel = 0;
        public int getRuleLevel() { return ruleLevel; }
        public void incRuleLevel() { ruleLevel++; }
        public void decRuleLevel() { ruleLevel--; }
        public SQL_grammarParser(TokenStream input) {
            this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
        }
        public SQL_grammarParser(TokenStream input, int port, RecognizerSharedState state) {
            super(input, state);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this,port,adaptor);
            setDebugListener(proxy);
            setTokenStream(new DebugTokenStream(input,proxy));
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }
            TreeAdaptor adap = new CommonTreeAdaptor();
            setTreeAdaptor(adap);
            proxy.setTreeAdaptor(adap);
        }
    public SQL_grammarParser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);

         
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);

    }
    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor;
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);

    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return SQL_grammarParser.tokenNames; }
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g"; }


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:10:1: query : select from ( where )? ';' EOF ;
    public final SQL_grammarParser.query_return query() throws RecognitionException {
        SQL_grammarParser.query_return retval = new SQL_grammarParser.query_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal4=null;
        Token EOF5=null;
        SQL_grammarParser.select_return select1 = null;

        SQL_grammarParser.from_return from2 = null;

        SQL_grammarParser.where_return where3 = null;


        CommonTree char_literal4_tree=null;
        CommonTree EOF5_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "query");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(10, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:11:2: ( select from ( where )? ';' EOF )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:11:4: select from ( where )? ';' EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(11,4);
            pushFollow(FOLLOW_select_in_query29);
            select1=select();

            state._fsp--;

            adaptor.addChild(root_0, select1.getTree());
            dbg.location(11,11);
            pushFollow(FOLLOW_from_in_query31);
            from2=from();

            state._fsp--;

            adaptor.addChild(root_0, from2.getTree());
            dbg.location(11,16);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:11:16: ( where )?
            int alt1=2;
            try { dbg.enterSubRule(1);
            try { dbg.enterDecision(1);

            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:11:16: where
                    {
                    dbg.location(11,16);
                    pushFollow(FOLLOW_where_in_query33);
                    where3=where();

                    state._fsp--;

                    adaptor.addChild(root_0, where3.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(1);}

            dbg.location(11,26);
            char_literal4=(Token)match(input,7,FOLLOW_7_in_query36); 
            dbg.location(11,31);
            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_query39); 

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
        dbg.location(12, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "query");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "query"

    public static class select_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:1: select : 'SELECT' ( NAME ( ',' NAME )* | STAR ) ;
    public final SQL_grammarParser.select_return select() throws RecognitionException {
        SQL_grammarParser.select_return retval = new SQL_grammarParser.select_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal6=null;
        Token NAME7=null;
        Token char_literal8=null;
        Token NAME9=null;
        Token STAR10=null;

        CommonTree string_literal6_tree=null;
        CommonTree NAME7_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree NAME9_tree=null;
        CommonTree STAR10_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "select");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(14, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:8: ( 'SELECT' ( NAME ( ',' NAME )* | STAR ) )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:11: 'SELECT' ( NAME ( ',' NAME )* | STAR )
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(14,19);
            string_literal6=(Token)match(input,8,FOLLOW_8_in_select57); 
            string_literal6_tree = (CommonTree)adaptor.create(string_literal6);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal6_tree, root_0);

            dbg.location(14,22);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:22: ( NAME ( ',' NAME )* | STAR )
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3);

            int LA3_0 = input.LA(1);

            if ( (LA3_0==NAME) ) {
                alt3=1;
            }
            else if ( (LA3_0==STAR) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:23: NAME ( ',' NAME )*
                    {
                    dbg.location(14,23);
                    NAME7=(Token)match(input,NAME,FOLLOW_NAME_in_select62); 
                    NAME7_tree = (CommonTree)adaptor.create(NAME7);
                    adaptor.addChild(root_0, NAME7_tree);

                    dbg.location(14,28);
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:28: ( ',' NAME )*
                    try { dbg.enterSubRule(2);

                    loop2:
                    do {
                        int alt2=2;
                        try { dbg.enterDecision(2);

                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==9) ) {
                            alt2=1;
                        }


                        } finally {dbg.exitDecision(2);}

                        switch (alt2) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:29: ',' NAME
                    	    {
                    	    dbg.location(14,32);
                    	    char_literal8=(Token)match(input,9,FOLLOW_9_in_select65); 
                    	    dbg.location(14,34);
                    	    NAME9=(Token)match(input,NAME,FOLLOW_NAME_in_select68); 
                    	    NAME9_tree = (CommonTree)adaptor.create(NAME9);
                    	    adaptor.addChild(root_0, NAME9_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(2);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:14:43: STAR
                    {
                    dbg.location(14,43);
                    STAR10=(Token)match(input,STAR,FOLLOW_STAR_in_select74); 
                    STAR10_tree = (CommonTree)adaptor.create(STAR10);
                    adaptor.addChild(root_0, STAR10_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}


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
        dbg.location(15, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "select");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "select"

    public static class from_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "from"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:17:1: from : 'FROM' NAME ( ',' NAME )* ;
    public final SQL_grammarParser.from_return from() throws RecognitionException {
        SQL_grammarParser.from_return retval = new SQL_grammarParser.from_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal11=null;
        Token NAME12=null;
        Token char_literal13=null;
        Token NAME14=null;

        CommonTree string_literal11_tree=null;
        CommonTree NAME12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree NAME14_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "from");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(17, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:17:6: ( 'FROM' NAME ( ',' NAME )* )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:17:8: 'FROM' NAME ( ',' NAME )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(17,14);
            string_literal11=(Token)match(input,10,FOLLOW_10_in_from89); 
            string_literal11_tree = (CommonTree)adaptor.create(string_literal11);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal11_tree, root_0);

            dbg.location(17,16);
            NAME12=(Token)match(input,NAME,FOLLOW_NAME_in_from92); 
            NAME12_tree = (CommonTree)adaptor.create(NAME12);
            adaptor.addChild(root_0, NAME12_tree);

            dbg.location(17,21);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:17:21: ( ',' NAME )*
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=2;
                try { dbg.enterDecision(4);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==9) ) {
                    alt4=1;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:17:22: ',' NAME
            	    {
            	    dbg.location(17,25);
            	    char_literal13=(Token)match(input,9,FOLLOW_9_in_from95); 
            	    dbg.location(17,27);
            	    NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_from98); 
            	    NAME14_tree = (CommonTree)adaptor.create(NAME14);
            	    adaptor.addChild(root_0, NAME14_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);
            } finally {dbg.exitSubRule(4);}


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
        dbg.location(18, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "from");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "from"

    public static class where_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:20:1: where : 'WHERE' and ;
    public final SQL_grammarParser.where_return where() throws RecognitionException {
        SQL_grammarParser.where_return retval = new SQL_grammarParser.where_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal15=null;
        SQL_grammarParser.and_return and16 = null;


        CommonTree string_literal15_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "where");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(20, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:20:7: ( 'WHERE' and )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:20:9: 'WHERE' and
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(20,16);
            string_literal15=(Token)match(input,11,FOLLOW_11_in_where111); 
            string_literal15_tree = (CommonTree)adaptor.create(string_literal15);
            root_0 = (CommonTree)adaptor.becomeRoot(string_literal15_tree, root_0);

            dbg.location(20,18);
            pushFollow(FOLLOW_and_in_where114);
            and16=and();

            state._fsp--;

            adaptor.addChild(root_0, and16.getTree());

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
        dbg.location(21, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "where");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "where"

    public static class and_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:23:1: and : clause ( 'AND' clause )* ;
    public final SQL_grammarParser.and_return and() throws RecognitionException {
        SQL_grammarParser.and_return retval = new SQL_grammarParser.and_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal18=null;
        SQL_grammarParser.clause_return clause17 = null;

        SQL_grammarParser.clause_return clause19 = null;


        CommonTree string_literal18_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "and");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(23, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:23:5: ( clause ( 'AND' clause )* )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:23:7: clause ( 'AND' clause )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(23,7);
            pushFollow(FOLLOW_clause_in_and124);
            clause17=clause();

            state._fsp--;

            adaptor.addChild(root_0, clause17.getTree());
            dbg.location(23,14);
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:23:14: ( 'AND' clause )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==12) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:23:16: 'AND' clause
            	    {
            	    dbg.location(23,21);
            	    string_literal18=(Token)match(input,12,FOLLOW_12_in_and128); 
            	    dbg.location(23,23);
            	    pushFollow(FOLLOW_clause_in_and131);
            	    clause19=clause();

            	    state._fsp--;

            	    adaptor.addChild(root_0, clause19.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}


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
        dbg.location(24, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "and");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "and"

    public static class clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "clause"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:26:1: clause : NAME op NAME ;
    public final SQL_grammarParser.clause_return clause() throws RecognitionException {
        SQL_grammarParser.clause_return retval = new SQL_grammarParser.clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME20=null;
        Token NAME22=null;
        SQL_grammarParser.op_return op21 = null;


        CommonTree NAME20_tree=null;
        CommonTree NAME22_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "clause");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:26:8: ( NAME op NAME )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:26:10: NAME op NAME
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(26,10);
            NAME20=(Token)match(input,NAME,FOLLOW_NAME_in_clause144); 
            NAME20_tree = (CommonTree)adaptor.create(NAME20);
            adaptor.addChild(root_0, NAME20_tree);

            dbg.location(26,17);
            pushFollow(FOLLOW_op_in_clause146);
            op21=op();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(op21.getTree(), root_0);
            dbg.location(26,19);
            NAME22=(Token)match(input,NAME,FOLLOW_NAME_in_clause149); 
            NAME22_tree = (CommonTree)adaptor.create(NAME22);
            adaptor.addChild(root_0, NAME22_tree);


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
        dbg.location(27, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "clause");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "clause"

    public static class op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:31:1: op : ( '=' | '<' | '>' | '<=' | '>=' ) ;
    public final SQL_grammarParser.op_return op() throws RecognitionException {
        SQL_grammarParser.op_return retval = new SQL_grammarParser.op_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set23=null;

        CommonTree set23_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "op");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 1);

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:31:4: ( ( '=' | '<' | '>' | '<=' | '>=' ) )
            dbg.enterAlt(1);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:31:6: ( '=' | '<' | '>' | '<=' | '>=' )
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(31,6);
            set23=(Token)input.LT(1);
            if ( (input.LA(1)>=13 && input.LA(1)<=17) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set23));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
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
        dbg.location(32, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "op");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "op"

    // Delegated rules


 

    public static final BitSet FOLLOW_select_in_query29 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_from_in_query31 = new BitSet(new long[]{0x0000000000000880L});
    public static final BitSet FOLLOW_where_in_query33 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_query36 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query39 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_select57 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_NAME_in_select62 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_select65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NAME_in_select68 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_STAR_in_select74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_from89 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NAME_in_from92 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_from95 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NAME_in_from98 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_11_in_where111 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_and_in_where114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clause_in_and124 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_and128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_clause_in_and131 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_NAME_in_clause144 = new BitSet(new long[]{0x000000000003E000L});
    public static final BitSet FOLLOW_op_in_clause146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_NAME_in_clause149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op163 = new BitSet(new long[]{0x0000000000000002L});

}