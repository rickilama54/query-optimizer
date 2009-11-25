// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g 2009-11-25 13:52:48

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SQL_grammarLexer extends Lexer {
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

    public SQL_grammarLexer() {;} 
    public SQL_grammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQL_grammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:3:6: ( ';' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:3:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:4:6: ( 'SELECT' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:4:8: 'SELECT'
            {
            match("SELECT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:5:6: ( ',' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:5:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:6:7: ( 'FROM' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:6:9: 'FROM'
            {
            match("FROM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:7:7: ( 'WHERE' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:7:9: 'WHERE'
            {
            match("WHERE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:8:7: ( 'AND' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:8:9: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:9:7: ( '=' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:9:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:10:7: ( '<' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:10:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:11:7: ( '>' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:11:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:12:7: ( '<=' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:12:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:13:7: ( '>=' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:13:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:36:2: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:36:5: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:40:6: ( '*' )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:40:8: '*'
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

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:41:6: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ )
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:41:8: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:41:8: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
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
            	    // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:
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
        // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | WS | STAR | NAME )
        int alt2=14;
        alt2 = dfa2.predict(input);
        switch (alt2) {
            case 1 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:10: T__7
                {
                mT__7(); 

                }
                break;
            case 2 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:15: T__8
                {
                mT__8(); 

                }
                break;
            case 3 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:20: T__9
                {
                mT__9(); 

                }
                break;
            case 4 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:25: T__10
                {
                mT__10(); 

                }
                break;
            case 5 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:31: T__11
                {
                mT__11(); 

                }
                break;
            case 6 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:37: T__12
                {
                mT__12(); 

                }
                break;
            case 7 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:43: T__13
                {
                mT__13(); 

                }
                break;
            case 8 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:49: T__14
                {
                mT__14(); 

                }
                break;
            case 9 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:55: T__15
                {
                mT__15(); 

                }
                break;
            case 10 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:61: T__16
                {
                mT__16(); 

                }
                break;
            case 11 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:67: T__17
                {
                mT__17(); 

                }
                break;
            case 12 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:73: WS
                {
                mWS(); 

                }
                break;
            case 13 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:76: STAR
                {
                mSTAR(); 

                }
                break;
            case 14 :
                // /home/dragan/Dragan/workspaces/eclipse_workspace/query_optimizer/SQL_grammar.g:1:81: NAME
                {
                mNAME(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    static final String DFA2_eotS =
        "\2\uffff\1\14\1\uffff\3\14\1\uffff\1\22\1\24\3\uffff\4\14\4\uffff"+
        "\3\14\1\34\1\14\1\36\1\14\1\uffff\1\14\1\uffff\1\41\1\42\2\uffff";
    static final String DFA2_eofS =
        "\43\uffff";
    static final String DFA2_minS =
        "\1\11\1\uffff\1\105\1\uffff\1\122\1\110\1\116\1\uffff\2\75\3\uffff"+
        "\1\114\1\117\1\105\1\104\4\uffff\1\105\1\115\1\122\1\60\1\103\1"+
        "\60\1\105\1\uffff\1\124\1\uffff\2\60\2\uffff";
    static final String DFA2_maxS =
        "\1\172\1\uffff\1\105\1\uffff\1\122\1\110\1\116\1\uffff\2\75\3\uffff"+
        "\1\114\1\117\1\105\1\104\4\uffff\1\105\1\115\1\122\1\172\1\103\1"+
        "\172\1\105\1\uffff\1\124\1\uffff\2\172\2\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\3\uffff\1\7\2\uffff\1\14\1\15\1\16\4\uffff"+
        "\1\12\1\10\1\13\1\11\7\uffff\1\6\1\uffff\1\4\2\uffff\1\5\1\2";
    static final String DFA2_specialS =
        "\43\uffff}>";
    static final String[] DFA2_transitionS = {
            "\2\12\1\uffff\2\12\22\uffff\1\12\11\uffff\1\13\1\uffff\1\3\3"+
            "\uffff\12\14\1\uffff\1\1\1\10\1\7\1\11\2\uffff\1\6\4\14\1\4"+
            "\14\14\1\2\3\14\1\5\3\14\6\uffff\32\14",
            "",
            "\1\15",
            "",
            "\1\16",
            "\1\17",
            "\1\20",
            "",
            "\1\21",
            "\1\23",
            "",
            "",
            "",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "",
            "",
            "",
            "",
            "\1\31",
            "\1\32",
            "\1\33",
            "\12\14\7\uffff\32\14\6\uffff\32\14",
            "\1\35",
            "\12\14\7\uffff\32\14\6\uffff\32\14",
            "\1\37",
            "",
            "\1\40",
            "",
            "\12\14\7\uffff\32\14\6\uffff\32\14",
            "\12\14\7\uffff\32\14\6\uffff\32\14",
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
            return "1:1: Tokens : ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | WS | STAR | NAME );";
        }
    }
 

}