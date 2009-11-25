// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g 2009-11-25 15:50:57
package queryopt.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SQL_grammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SELECT", "NAME", "STAR", "FROM", "WHERE", "LITERAL", "EQ", "LS", "GT", "LS_EQ", "GT_EQ", "WS", "DIFF", "';'", "','", "'AND'"
    };
    public static final int WHERE=8;
    public static final int STAR=6;
    public static final int LS=11;
    public static final int LITERAL=9;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int NAME=5;
    public static final int WS=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int DIFF=16;
    public static final int GT=12;
    public static final int EQ=10;
    public static final int FROM=7;
    public static final int LS_EQ=13;
    public static final int SELECT=4;
    public static final int GT_EQ=14;

    // delegates
    // delegators


        public SQL_grammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SQL_grammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SQL_grammarParser.tokenNames; }
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g"; }


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


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:40:1: query : select from ( where )? ';' EOF ;
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

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:41:2: ( select from ( where )? ';' EOF )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:41:4: select from ( where )? ';' EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_select_in_query48);
            select1=select();

            state._fsp--;

            adaptor.addChild(root_0, select1.getTree());
            pushFollow(FOLLOW_from_in_query50);
            from2=from();

            state._fsp--;

            adaptor.addChild(root_0, from2.getTree());
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:41:16: ( where )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==WHERE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:41:16: where
                    {
                    pushFollow(FOLLOW_where_in_query52);
                    where3=where();

                    state._fsp--;

                    adaptor.addChild(root_0, where3.getTree());

                    }
                    break;

            }

            char_literal4=(Token)match(input,17,FOLLOW_17_in_query55); 
            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_query58); 

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

    public static class select_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:1: select : SELECT ( NAME ( ',' NAME )* | STAR ) ;
    public final SQL_grammarParser.select_return select() throws RecognitionException {
        SQL_grammarParser.select_return retval = new SQL_grammarParser.select_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SELECT6=null;
        Token NAME7=null;
        Token char_literal8=null;
        Token NAME9=null;
        Token STAR10=null;

        CommonTree SELECT6_tree=null;
        CommonTree NAME7_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree NAME9_tree=null;
        CommonTree STAR10_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:8: ( SELECT ( NAME ( ',' NAME )* | STAR ) )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:11: SELECT ( NAME ( ',' NAME )* | STAR )
            {
            root_0 = (CommonTree)adaptor.nil();

            SELECT6=(Token)match(input,SELECT,FOLLOW_SELECT_in_select76); 
            SELECT6_tree = (CommonTree)adaptor.create(SELECT6);
            root_0 = (CommonTree)adaptor.becomeRoot(SELECT6_tree, root_0);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:20: ( NAME ( ',' NAME )* | STAR )
            int alt3=2;
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

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:21: NAME ( ',' NAME )*
                    {
                    NAME7=(Token)match(input,NAME,FOLLOW_NAME_in_select81); 
                    NAME7_tree = (CommonTree)adaptor.create(NAME7);
                    adaptor.addChild(root_0, NAME7_tree);

                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:26: ( ',' NAME )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==18) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:27: ',' NAME
                    	    {
                    	    char_literal8=(Token)match(input,18,FOLLOW_18_in_select84); 
                    	    NAME9=(Token)match(input,NAME,FOLLOW_NAME_in_select87); 
                    	    NAME9_tree = (CommonTree)adaptor.create(NAME9);
                    	    adaptor.addChild(root_0, NAME9_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:44:41: STAR
                    {
                    STAR10=(Token)match(input,STAR,FOLLOW_STAR_in_select93); 
                    STAR10_tree = (CommonTree)adaptor.create(STAR10);
                    adaptor.addChild(root_0, STAR10_tree);


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
    // $ANTLR end "select"

    public static class from_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "from"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:47:1: from : FROM NAME ( ',' NAME )* ;
    public final SQL_grammarParser.from_return from() throws RecognitionException {
        SQL_grammarParser.from_return retval = new SQL_grammarParser.from_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FROM11=null;
        Token NAME12=null;
        Token char_literal13=null;
        Token NAME14=null;

        CommonTree FROM11_tree=null;
        CommonTree NAME12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree NAME14_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:47:6: ( FROM NAME ( ',' NAME )* )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:47:8: FROM NAME ( ',' NAME )*
            {
            root_0 = (CommonTree)adaptor.nil();

            FROM11=(Token)match(input,FROM,FOLLOW_FROM_in_from108); 
            FROM11_tree = (CommonTree)adaptor.create(FROM11);
            root_0 = (CommonTree)adaptor.becomeRoot(FROM11_tree, root_0);

            NAME12=(Token)match(input,NAME,FOLLOW_NAME_in_from111); 
            NAME12_tree = (CommonTree)adaptor.create(NAME12);
            adaptor.addChild(root_0, NAME12_tree);

            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:47:19: ( ',' NAME )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:47:20: ',' NAME
            	    {
            	    char_literal13=(Token)match(input,18,FOLLOW_18_in_from114); 
            	    NAME14=(Token)match(input,NAME,FOLLOW_NAME_in_from117); 
            	    NAME14_tree = (CommonTree)adaptor.create(NAME14);
            	    adaptor.addChild(root_0, NAME14_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "from"

    public static class where_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:1: where : WHERE and ;
    public final SQL_grammarParser.where_return where() throws RecognitionException {
        SQL_grammarParser.where_return retval = new SQL_grammarParser.where_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHERE15=null;
        SQL_grammarParser.and_return and16 = null;


        CommonTree WHERE15_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:7: ( WHERE and )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:50:9: WHERE and
            {
            root_0 = (CommonTree)adaptor.nil();

            WHERE15=(Token)match(input,WHERE,FOLLOW_WHERE_in_where130); 
            WHERE15_tree = (CommonTree)adaptor.create(WHERE15);
            root_0 = (CommonTree)adaptor.becomeRoot(WHERE15_tree, root_0);

            pushFollow(FOLLOW_and_in_where133);
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
        return retval;
    }
    // $ANTLR end "where"

    public static class and_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:53:1: and : clause ( 'AND' clause )* ;
    public final SQL_grammarParser.and_return and() throws RecognitionException {
        SQL_grammarParser.and_return retval = new SQL_grammarParser.and_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal18=null;
        SQL_grammarParser.clause_return clause17 = null;

        SQL_grammarParser.clause_return clause19 = null;


        CommonTree string_literal18_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:53:5: ( clause ( 'AND' clause )* )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:53:7: clause ( 'AND' clause )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_clause_in_and143);
            clause17=clause();

            state._fsp--;

            adaptor.addChild(root_0, clause17.getTree());
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:53:14: ( 'AND' clause )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:53:16: 'AND' clause
            	    {
            	    string_literal18=(Token)match(input,19,FOLLOW_19_in_and147); 
            	    pushFollow(FOLLOW_clause_in_and150);
            	    clause19=clause();

            	    state._fsp--;

            	    adaptor.addChild(root_0, clause19.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "and"

    public static class clause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "clause"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:1: clause : ( NAME op NAME | NAME op LITERAL | LITERAL op NAME | LITERAL op LITERAL );
    public final SQL_grammarParser.clause_return clause() throws RecognitionException {
        SQL_grammarParser.clause_return retval = new SQL_grammarParser.clause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NAME20=null;
        Token NAME22=null;
        Token NAME23=null;
        Token LITERAL25=null;
        Token LITERAL26=null;
        Token NAME28=null;
        Token LITERAL29=null;
        Token LITERAL31=null;
        SQL_grammarParser.op_return op21 = null;

        SQL_grammarParser.op_return op24 = null;

        SQL_grammarParser.op_return op27 = null;

        SQL_grammarParser.op_return op30 = null;


        CommonTree NAME20_tree=null;
        CommonTree NAME22_tree=null;
        CommonTree NAME23_tree=null;
        CommonTree LITERAL25_tree=null;
        CommonTree LITERAL26_tree=null;
        CommonTree NAME28_tree=null;
        CommonTree LITERAL29_tree=null;
        CommonTree LITERAL31_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:8: ( NAME op NAME | NAME op LITERAL | LITERAL op NAME | LITERAL op LITERAL )
            int alt6=4;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==NAME) ) {
                int LA6_1 = input.LA(2);

                if ( ((LA6_1>=EQ && LA6_1<=GT_EQ)) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==NAME) ) {
                        alt6=1;
                    }
                    else if ( (LA6_3==LITERAL) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA6_0==LITERAL) ) {
                int LA6_2 = input.LA(2);

                if ( ((LA6_2>=EQ && LA6_2<=GT_EQ)) ) {
                    int LA6_4 = input.LA(3);

                    if ( (LA6_4==NAME) ) {
                        alt6=3;
                    }
                    else if ( (LA6_4==LITERAL) ) {
                        alt6=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:10: NAME op NAME
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NAME20=(Token)match(input,NAME,FOLLOW_NAME_in_clause163); 
                    NAME20_tree = (CommonTree)adaptor.create(NAME20);
                    adaptor.addChild(root_0, NAME20_tree);

                    pushFollow(FOLLOW_op_in_clause165);
                    op21=op();

                    state._fsp--;

                    root_0 = (CommonTree)adaptor.becomeRoot(op21.getTree(), root_0);
                    NAME22=(Token)match(input,NAME,FOLLOW_NAME_in_clause168); 
                    NAME22_tree = (CommonTree)adaptor.create(NAME22);
                    adaptor.addChild(root_0, NAME22_tree);


                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:26: NAME op LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    NAME23=(Token)match(input,NAME,FOLLOW_NAME_in_clause172); 
                    NAME23_tree = (CommonTree)adaptor.create(NAME23);
                    adaptor.addChild(root_0, NAME23_tree);

                    pushFollow(FOLLOW_op_in_clause174);
                    op24=op();

                    state._fsp--;

                    root_0 = (CommonTree)adaptor.becomeRoot(op24.getTree(), root_0);
                    LITERAL25=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_clause177); 
                    LITERAL25_tree = (CommonTree)adaptor.create(LITERAL25);
                    adaptor.addChild(root_0, LITERAL25_tree);


                    }
                    break;
                case 3 :
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:46: LITERAL op NAME
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LITERAL26=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_clause182); 
                    LITERAL26_tree = (CommonTree)adaptor.create(LITERAL26);
                    adaptor.addChild(root_0, LITERAL26_tree);

                    pushFollow(FOLLOW_op_in_clause184);
                    op27=op();

                    state._fsp--;

                    root_0 = (CommonTree)adaptor.becomeRoot(op27.getTree(), root_0);
                    NAME28=(Token)match(input,NAME,FOLLOW_NAME_in_clause187); 
                    NAME28_tree = (CommonTree)adaptor.create(NAME28);
                    adaptor.addChild(root_0, NAME28_tree);


                    }
                    break;
                case 4 :
                    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:56:66: LITERAL op LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LITERAL29=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_clause192); 
                    LITERAL29_tree = (CommonTree)adaptor.create(LITERAL29);
                    adaptor.addChild(root_0, LITERAL29_tree);

                    pushFollow(FOLLOW_op_in_clause194);
                    op30=op();

                    state._fsp--;

                    root_0 = (CommonTree)adaptor.becomeRoot(op30.getTree(), root_0);
                    LITERAL31=(Token)match(input,LITERAL,FOLLOW_LITERAL_in_clause197); 
                    LITERAL31_tree = (CommonTree)adaptor.create(LITERAL31);
                    adaptor.addChild(root_0, LITERAL31_tree);


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
    // $ANTLR end "clause"

    public static class op_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "op"
    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:61:1: op : ( EQ | LS | GT | LS_EQ | GT_EQ ) ;
    public final SQL_grammarParser.op_return op() throws RecognitionException {
        SQL_grammarParser.op_return retval = new SQL_grammarParser.op_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set32=null;

        CommonTree set32_tree=null;

        try {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:61:4: ( ( EQ | LS | GT | LS_EQ | GT_EQ ) )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:61:6: ( EQ | LS | GT | LS_EQ | GT_EQ )
            {
            root_0 = (CommonTree)adaptor.nil();

            set32=(Token)input.LT(1);
            if ( (input.LA(1)>=EQ && input.LA(1)<=GT_EQ) ) {
                input.consume();
                adaptor.addChild(root_0, (CommonTree)adaptor.create(set32));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
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
        return retval;
    }
    // $ANTLR end "op"

    // Delegated rules


 

    public static final BitSet FOLLOW_select_in_query48 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_from_in_query50 = new BitSet(new long[]{0x0000000000020100L});
    public static final BitSet FOLLOW_where_in_query52 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_query55 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_query58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select76 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_NAME_in_select81 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_select84 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NAME_in_select87 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STAR_in_select93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_from108 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NAME_in_from111 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_from114 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NAME_in_from117 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_WHERE_in_where130 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_and_in_where133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_clause_in_and143 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_and147 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_clause_in_and150 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_NAME_in_clause163 = new BitSet(new long[]{0x0000000000007C00L});
    public static final BitSet FOLLOW_op_in_clause165 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NAME_in_clause168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_clause172 = new BitSet(new long[]{0x0000000000007C00L});
    public static final BitSet FOLLOW_op_in_clause174 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LITERAL_in_clause177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_clause182 = new BitSet(new long[]{0x0000000000007C00L});
    public static final BitSet FOLLOW_op_in_clause184 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NAME_in_clause187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_clause192 = new BitSet(new long[]{0x0000000000007C00L});
    public static final BitSet FOLLOW_op_in_clause194 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_LITERAL_in_clause197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_op211 = new BitSet(new long[]{0x0000000000000002L});

}