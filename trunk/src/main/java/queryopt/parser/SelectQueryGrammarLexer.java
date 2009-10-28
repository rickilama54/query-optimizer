// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/dragan/Dragan/SelectQueryGrammar.g 2009-10-27 23:19:47
package queryopt.parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SelectQueryGrammarLexer extends Lexer {
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

    public SelectQueryGrammarLexer() {;} 
    public SelectQueryGrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SelectQueryGrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/dragan/Dragan/SelectQueryGrammar.g"; }

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:6:7: ( ',' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:6:9: ','
            {
            match(','); 

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
            // /home/dragan/Dragan/SelectQueryGrammar.g:7:7: ( '(' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:7:9: '('
            {
            match('('); 

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
            // /home/dragan/Dragan/SelectQueryGrammar.g:8:7: ( ')' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:8:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:9:7: ( '\\'' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:9:9: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:79:6: ( '*' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:79:8: '*'
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

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/dragan/Dragan/SelectQueryGrammar.g:80:8: ( 'SELECT' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:80:10: 'SELECT'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:81:6: ( 'FROM' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:81:8: 'FROM'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:82:7: ( 'WHERE' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:82:9: 'WHERE'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:83:5: ( 'AND' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:83:7: 'AND'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:84:4: ( 'IN' )
            // /home/dragan/Dragan/SelectQueryGrammar.g:84:6: 'IN'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:85:17: ( ( 'AVG' | 'SUM' | 'MIN' | 'MAX' )+ )
            // /home/dragan/Dragan/SelectQueryGrammar.g:85:21: ( 'AVG' | 'SUM' | 'MIN' | 'MAX' )+
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:85:21: ( 'AVG' | 'SUM' | 'MIN' | 'MAX' )+
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
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:85:22: 'AVG'
            	    {
            	    match("AVG"); 


            	    }
            	    break;
            	case 2 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:85:28: 'SUM'
            	    {
            	    match("SUM"); 


            	    }
            	    break;
            	case 3 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:85:34: 'MIN'
            	    {
            	    match("MIN"); 


            	    }
            	    break;
            	case 4 :
            	    // /home/dragan/Dragan/SelectQueryGrammar.g:85:40: 'MAX'
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:86:7: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
            // /home/dragan/Dragan/SelectQueryGrammar.g:86:11: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:86:11: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:87:4: ( ( '=' | '<' | '>' | '<=' | '>=' ) )
            // /home/dragan/Dragan/SelectQueryGrammar.g:87:8: ( '=' | '<' | '>' | '<=' | '>=' )
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:87:8: ( '=' | '<' | '>' | '<=' | '>=' )
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
                    // /home/dragan/Dragan/SelectQueryGrammar.g:87:9: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:87:13: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 3 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:87:17: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 4 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:87:21: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 5 :
                    // /home/dragan/Dragan/SelectQueryGrammar.g:87:26: '>='
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
            // /home/dragan/Dragan/SelectQueryGrammar.g:88:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // /home/dragan/Dragan/SelectQueryGrammar.g:88:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // /home/dragan/Dragan/SelectQueryGrammar.g:88:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
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
        // /home/dragan/Dragan/SelectQueryGrammar.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | STAR | SELECT | FROM | WHERE | AND | IN | AGGREGATE_FUNC | NAME | OP | WS )
        int alt5=15;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:10: T__16
                {
                mT__16(); 

                }
                break;
            case 2 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:16: T__17
                {
                mT__17(); 

                }
                break;
            case 3 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:22: T__18
                {
                mT__18(); 

                }
                break;
            case 4 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:28: T__19
                {
                mT__19(); 

                }
                break;
            case 5 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:34: T__20
                {
                mT__20(); 

                }
                break;
            case 6 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:40: STAR
                {
                mSTAR(); 

                }
                break;
            case 7 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:45: SELECT
                {
                mSELECT(); 

                }
                break;
            case 8 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:52: FROM
                {
                mFROM(); 

                }
                break;
            case 9 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:57: WHERE
                {
                mWHERE(); 

                }
                break;
            case 10 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:63: AND
                {
                mAND(); 

                }
                break;
            case 11 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:67: IN
                {
                mIN(); 

                }
                break;
            case 12 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:70: AGGREGATE_FUNC
                {
                mAGGREGATE_FUNC(); 

                }
                break;
            case 13 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:85: NAME
                {
                mNAME(); 

                }
                break;
            case 14 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:90: OP
                {
                mOP(); 

                }
                break;
            case 15 :
                // /home/dragan/Dragan/SelectQueryGrammar.g:1:93: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\7\uffff\6\15\3\uffff\6\15\1\37\3\15\1\43\2\15\1\50\1\43\1\uffff"+
        "\2\43\1\15\1\uffff\2\15\1\52\1\15\1\uffff\1\15\1\uffff\1\55\1\56"+
        "\2\uffff";
    static final String DFA5_eofS =
        "\57\uffff";
    static final String DFA5_minS =
        "\1\11\6\uffff\1\105\1\122\1\110\2\116\1\101\3\uffff\1\114\1\115"+
        "\1\117\1\105\1\104\1\107\1\60\1\116\1\130\1\105\1\60\1\115\1\122"+
        "\2\60\1\uffff\2\60\1\103\1\uffff\1\126\1\125\1\60\1\105\1\uffff"+
        "\1\124\1\uffff\2\60\2\uffff";
    static final String DFA5_maxS =
        "\1\172\6\uffff\1\125\1\122\1\110\1\126\1\116\1\111\3\uffff\1\114"+
        "\1\115\1\117\1\105\1\104\1\107\1\172\1\116\1\130\1\105\1\172\1\115"+
        "\1\122\2\172\1\uffff\2\172\1\103\1\uffff\1\126\1\125\1\172\1\105"+
        "\1\uffff\1\124\1\uffff\2\172\2\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\6\uffff\1\15\1\16\1\17\17\uffff"+
        "\1\13\3\uffff\1\14\4\uffff\1\12\1\uffff\1\10\2\uffff\1\11\1\7";
    static final String DFA5_specialS =
        "\57\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\17\2\uffff\1\17\22\uffff\1\17\6\uffff\1\5\1\3\1\4\1\6\1\uffff"+
            "\1\2\3\uffff\12\15\1\uffff\1\1\3\16\2\uffff\1\12\4\15\1\10\2"+
            "\15\1\13\3\15\1\14\5\15\1\7\3\15\1\11\3\15\4\uffff\1\15\1\uffff"+
            "\32\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\17\uffff\1\21",
            "\1\22",
            "\1\23",
            "\1\24\7\uffff\1\25",
            "\1\26",
            "\1\30\7\uffff\1\27",
            "",
            "",
            "",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\40",
            "\1\41",
            "\1\42",
            "\12\15\7\uffff\1\44\13\15\1\14\5\15\1\45\7\15\4\uffff\1\15"+
            "\1\uffff\32\15",
            "\1\46",
            "\1\47",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\12\15\7\uffff\1\44\13\15\1\14\5\15\1\45\7\15\4\uffff\1\15"+
            "\1\uffff\32\15",
            "",
            "\12\15\7\uffff\1\44\13\15\1\14\5\15\1\45\7\15\4\uffff\1\15"+
            "\1\uffff\32\15",
            "\12\15\7\uffff\1\44\13\15\1\14\5\15\1\45\7\15\4\uffff\1\15"+
            "\1\uffff\32\15",
            "\1\51",
            "",
            "\1\25",
            "\1\21",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\53",
            "",
            "\1\54",
            "",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
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
            return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | STAR | SELECT | FROM | WHERE | AND | IN | AGGREGATE_FUNC | NAME | OP | WS );";
        }
    }
 

}