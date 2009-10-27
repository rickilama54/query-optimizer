// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/SelectQueryGrammar.g 2009-10-27 09:32:57
package queryopt.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SelectQueryGrammarLexer extends Lexer {
    public static final int WHERE=8;
    public static final int NAME=13;
    public static final int WS=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int IN=11;
    public static final int T__18=18;
    public static final int AGGREGATE_FUNC=12;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int OP=10;
    public static final int QUERY=4;
    public static final int FROM=7;
    public static final int AND=9;
    public static final int EOF=-1;
    public static final int SELECT=6;

    // delegates
    // delegators

    public SelectQueryGrammarLexer() {;} 
    public SelectQueryGrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SelectQueryGrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/dragan/Dragan/SelectQueryGrammar.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:5:7: ( ';' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:5:9: ';'
            {
            match(';'); 

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
            // /home/dragan/Dragan/SelectQueryGrammar.g:6:7: ( '*' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:6:9: '*'
            {
            match('*'); 

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
            // /home/dragan/Dragan/SelectQueryGrammar.g:7:7: ( ',' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:7:9: ','
            {
            match(','); 

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
            // /home/dragan/Dragan/SelectQueryGrammar.g:8:7: ( '(' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:8:9: '('
            {
            match('('); 

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
            // /home/dragan/Dragan/SelectQueryGrammar.g:9:7: ( ')' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:9:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:77:8: ( 'SELECT' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:77:10: 'SELECT'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:78:6: ( 'FROM' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:78:8: 'FROM'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:79:7: ( 'WHERE' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:79:9: 'WHERE'
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

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:80:5: ( 'AND' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:80:7: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:81:4: ( 'IN' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:81:6: 'IN'
            {
            match("IN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "AGGREGATE_FUNC"
    public final void mAGGREGATE_FUNC() throws RecognitionException {
        try {
            int _type = AGGREGATE_FUNC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:82:17: ( ( 'AVG' | 'SUM' | 'MIN' | 'MAX' )+ )
            // /home/dragan/Dragan/SelectQueryGrammar.g:82:21: ( 'AVG' | 'SUM' | 'MIN' | 'MAX' )+
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:82:21: ( 'AVG' | 'SUM' | 'MIN' | 'MAX' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case 'A':
                    {
                    alt1=1;
                    }
                    break;
                case 'S':
                    {
                    alt1=2;
                    }
                    break;
                case 'M':
                    {
                    int LA1_4 = input.LA(2);

                    if ( (LA1_4=='I') ) {
                        alt1=3;
                    }
                    else if ( (LA1_4=='A') ) {
                        alt1=4;
                    }


                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:82:22: 'AVG'
            	    {
            	    match("AVG"); 


            	    }
            	    break;
            	case 2 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:82:28: 'SUM'
            	    {
            	    match("SUM"); 


            	    }
            	    break;
            	case 3 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:82:34: 'MIN'
            	    {
            	    match("MIN"); 


            	    }
            	    break;
            	case 4 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:82:40: 'MAX'
            	    {
            	    match("MAX"); 


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
    // $ANTLR end "AGGREGATE_FUNC"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:83:6: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
            // /home/dragan/Dragan/SelectQueryGrammar.g:83:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:83:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "OP"
    public final void mOP() throws RecognitionException {
        try {
            int _type = OP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:84:4: ( ( '=' | '<' | '>' | '<=' | '>=' ) )
            // /home/dragan/Dragan/SelectQueryGrammar.g:84:8: ( '=' | '<' | '>' | '<=' | '>=' )
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:84:8: ( '=' | '<' | '>' | '<=' | '>=' )
            int alt3=5;
            switch ( input.LA(1) ) {
            case '=':
                {
                alt3=1;
                }
                break;
            case '<':
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2=='=') ) {
                    alt3=4;
                }
                else {
                    alt3=2;}
                }
                break;
            case '>':
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3=='=') ) {
                    alt3=5;
                }
                else {
                    alt3=3;}
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:84:9: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:84:13: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 3 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:84:17: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 4 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:84:21: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 5 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:84:26: '>='
                    {
                    match(">="); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:85:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/dragan/Dragan/SelectQueryGrammar.g:85:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:85:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/dragan/Dragan/SelectQueryGrammar.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | SELECT | FROM | WHERE | AND | IN | AGGREGATE_FUNC | NAME | OP | WS )
        int alt5=14;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:40: SELECT
                {
                mSELECT(); 

                }
                break;
            case 7 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:47: FROM
                {
                mFROM(); 

                }
                break;
            case 8 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:52: WHERE
                {
                mWHERE(); 

                }
                break;
            case 9 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:58: AND
                {
                mAND(); 

                }
                break;
            case 10 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:62: IN
                {
                mIN(); 

                }
                break;
            case 11 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:65: AGGREGATE_FUNC
                {
                mAGGREGATE_FUNC(); 

                }
                break;
            case 12 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:80: NAME
                {
                mNAME(); 

                }
                break;
            case 13 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:85: OP
                {
                mOP(); 

                }
                break;
            case 14 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:88: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\6\uffff\6\14\3\uffff\6\14\1\36\3\14\1\42\2\14\1\47\1\42\1\uffff"+
        "\2\42\1\14\1\uffff\2\14\1\51\1\14\1\uffff\1\14\1\uffff\1\54\1\55"+
        "\2\uffff";
    static final String DFA5_eofS =
        "\56\uffff";
    static final String DFA5_minS =
        "\1\11\5\uffff\1\105\1\122\1\110\2\116\1\101\3\uffff\1\114\1\115"+
        "\1\117\1\105\1\104\1\107\1\60\1\116\1\130\1\105\1\60\1\115\1\122"+
        "\2\60\1\uffff\2\60\1\103\1\uffff\1\126\1\125\1\60\1\105\1\uffff"+
        "\1\124\1\uffff\2\60\2\uffff";
    static final String DFA5_maxS =
        "\1\172\5\uffff\1\125\1\122\1\110\1\126\1\116\1\111\3\uffff\1\114"+
        "\1\115\1\117\1\105\1\104\1\107\1\172\1\116\1\130\1\105\1\172\1\115"+
        "\1\122\2\172\1\uffff\2\172\1\103\1\uffff\1\126\1\125\1\172\1\105"+
        "\1\uffff\1\124\1\uffff\2\172\2\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\6\uffff\1\14\1\15\1\16\17\uffff\1\12"+
        "\3\uffff\1\13\4\uffff\1\11\1\uffff\1\7\2\uffff\1\10\1\6";
    static final String DFA5_specialS =
        "\56\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\16\2\uffff\1\16\22\uffff\1\16\7\uffff\1\4\1\5\1\2\1\uffff"+
            "\1\3\3\uffff\12\14\1\uffff\1\1\3\15\2\uffff\1\11\4\14\1\7\2"+
            "\14\1\12\3\14\1\13\5\14\1\6\3\14\1\10\3\14\4\uffff\1\14\1\uffff"+
            "\32\14",
            "",
            "",
            "",
            "",
            "",
            "\1\17\17\uffff\1\20",
            "\1\21",
            "\1\22",
            "\1\23\7\uffff\1\24",
            "\1\25",
            "\1\27\7\uffff\1\26",
            "",
            "",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\37",
            "\1\40",
            "\1\41",
            "\12\14\7\uffff\1\43\13\14\1\13\5\14\1\44\7\14\4\uffff\1\14"+
            "\1\uffff\32\14",
            "\1\45",
            "\1\46",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\12\14\7\uffff\1\43\13\14\1\13\5\14\1\44\7\14\4\uffff\1\14"+
            "\1\uffff\32\14",
            "",
            "\12\14\7\uffff\1\43\13\14\1\13\5\14\1\44\7\14\4\uffff\1\14"+
            "\1\uffff\32\14",
            "\12\14\7\uffff\1\43\13\14\1\13\5\14\1\44\7\14\4\uffff\1\14"+
            "\1\uffff\32\14",
            "\1\50",
            "",
            "\1\24",
            "\1\20",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\52",
            "",
            "\1\53",
            "",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | SELECT | FROM | WHERE | AND | IN | AGGREGATE_FUNC | NAME | OP | WS );";
        }
    }
 

}