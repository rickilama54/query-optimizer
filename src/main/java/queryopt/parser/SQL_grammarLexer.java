// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g 2009-11-25 15:50:57
package queryopt.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SQL_grammarLexer extends Lexer {
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

    public SQL_grammarLexer() {;} 
    public SQL_grammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQL_grammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:5:7: ( ';' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:5:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:6:7: ( ',' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:6:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:7:7: ( 'AND' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:7:9: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:67:2: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:67:5: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:70:8: ( 'SELECT' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:70:10: 'SELECT'
            {
            match("SELECT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:71:6: ( 'FROM' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:71:8: 'FROM'
            {
            match("FROM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:72:7: ( 'WHERE' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:72:9: 'WHERE'
            {
            match("WHERE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:73:6: ( '*' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:73:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:74:4: ( '=' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:74:6: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "DIFF"
    public final void mDIFF() throws RecognitionException {
        try {
            int _type = DIFF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:75:6: ( '<>' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:75:8: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIFF"

    // $ANTLR start "GT_EQ"
    public final void mGT_EQ() throws RecognitionException {
        try {
            int _type = GT_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:76:7: ( '>=' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:76:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT_EQ"

    // $ANTLR start "LS_EQ"
    public final void mLS_EQ() throws RecognitionException {
        try {
            int _type = LS_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:77:7: ( '<=' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:77:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LS_EQ"

    // $ANTLR start "LS"
    public final void mLS() throws RecognitionException {
        try {
            int _type = LS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:78:4: ( '<' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:78:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LS"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:79:4: ( '>' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:79:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LITERAL"
    public final void mLITERAL() throws RecognitionException {
        try {
            int _type = LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:80:9: ( '\\'' NAME '\\'' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:80:11: '\\'' NAME '\\''
            {
            match('\''); 
            mNAME(); 
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LITERAL"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:81:6: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:81:8: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:81:8: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    public void mTokens() throws RecognitionException {
        // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:8: ( T__17 | T__18 | T__19 | WS | SELECT | FROM | WHERE | STAR | EQ | DIFF | GT_EQ | LS_EQ | LS | GT | LITERAL | NAME )
        int alt2=16;
        alt2 = dfa2.predict(input);
        switch (alt2) {
            case 1 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:28: WS
                {
                mWS(); 

                }
                break;
            case 5 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:31: SELECT
                {
                mSELECT(); 

                }
                break;
            case 6 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:38: FROM
                {
                mFROM(); 

                }
                break;
            case 7 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:43: WHERE
                {
                mWHERE(); 

                }
                break;
            case 8 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:49: STAR
                {
                mSTAR(); 

                }
                break;
            case 9 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:54: EQ
                {
                mEQ(); 

                }
                break;
            case 10 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:57: DIFF
                {
                mDIFF(); 

                }
                break;
            case 11 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:62: GT_EQ
                {
                mGT_EQ(); 

                }
                break;
            case 12 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:68: LS_EQ
                {
                mLS_EQ(); 

                }
                break;
            case 13 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:74: LS
                {
                mLS(); 

                }
                break;
            case 14 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:77: GT
                {
                mGT(); 

                }
                break;
            case 15 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:80: LITERAL
                {
                mLITERAL(); 

                }
                break;
            case 16 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/src/main/java/queryopt/parser/SQL_grammar.g:1:88: NAME
                {
                mNAME(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\3\uffff\1\15\1\uffff\3\15\2\uffff\1\24\1\26\2\uffff\4\15\5\uffff"+
        "\1\33\3\15\1\uffff\1\15\1\40\2\15\1\uffff\1\43\1\44\2\uffff";
    static final String DFA2_eofS =
        "\45\uffff";
    static final String DFA2_minS =
        "\1\11\2\uffff\1\116\1\uffff\1\105\1\122\1\110\2\uffff\2\75\2\uffff"+
        "\1\104\1\114\1\117\1\105\5\uffff\1\60\1\105\1\115\1\122\1\uffff"+
        "\1\103\1\60\1\105\1\124\1\uffff\2\60\2\uffff";
    static final String DFA2_maxS =
        "\1\172\2\uffff\1\116\1\uffff\1\105\1\122\1\110\2\uffff\1\76\1\75"+
        "\2\uffff\1\104\1\114\1\117\1\105\5\uffff\1\172\1\105\1\115\1\122"+
        "\1\uffff\1\103\1\172\1\105\1\124\1\uffff\2\172\2\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\3\uffff\1\10\1\11\2\uffff\1\17\1\20"+
        "\4\uffff\1\12\1\14\1\15\1\13\1\16\4\uffff\1\3\4\uffff\1\6\2\uffff"+
        "\1\7\1\5";
    static final String DFA2_specialS =
        "\45\uffff}>";
    static final String[] DFA2_transitionS = {
            "\2\4\1\uffff\2\4\22\uffff\1\4\6\uffff\1\14\2\uffff\1\10\1\uffff"+
            "\1\2\3\uffff\12\15\1\uffff\1\1\1\12\1\11\1\13\2\uffff\1\3\4"+
            "\15\1\6\14\15\1\5\3\15\1\7\3\15\6\uffff\32\15",
            "",
            "",
            "\1\16",
            "",
            "\1\17",
            "\1\20",
            "\1\21",
            "",
            "",
            "\1\23\1\22",
            "\1\25",
            "",
            "",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "",
            "",
            "",
            "",
            "",
            "\12\15\7\uffff\32\15\6\uffff\32\15",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "\1\37",
            "\12\15\7\uffff\32\15\6\uffff\32\15",
            "\1\41",
            "\1\42",
            "",
            "\12\15\7\uffff\32\15\6\uffff\32\15",
            "\12\15\7\uffff\32\15\6\uffff\32\15",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | WS | SELECT | FROM | WHERE | STAR | EQ | DIFF | GT_EQ | LS_EQ | LS | GT | LITERAL | NAME );";
        }
    }
 

}