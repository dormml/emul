// $ANTLR 3.2 Sep 23, 2009 12:02:23 /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g 2010-06-11 06:24:06

package org.ejs.eulang.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class EulangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SCOPE", "ADDSCOPE", "EXTENDSCOPE", "LIST_COMPREHENSION", "CODE", "METHOD", "MACRO", "STMTLIST", "PROTO", "ARGLIST", "ARGDEF", "REF", "ALLOC", "ASSIGN", "DEFINE", "EXPR", "LIST", "TYPE", "STMTEXPR", "CONDLIST", "CONDTEST", "CALL", "INLINE", "CAST", "COND", "BITAND", "BITOR", "BITXOR", "ADD", "SUB", "MUL", "DIV", "UDIV", "MOD", "NEG", "INV", "POSTINC", "POSTDEC", "PREINC", "PREDEC", "LIT", "IDREF", "IDLIST", "LABEL", "GOTO", "BLOCK", "TUPLE", "TUPLETYPE", "LABELSTMT", "BINDING", "FIELDREF", "ARRAY", "INDEX", "POINTER", "DEREF", "ADDRREF", "ADDROF", "SIZEOF", "TYPEOF", "INITEXPR", "INITLIST", "INSTANCE", "GENERIC", "SEMI", "FORWARD", "ID", "COMMA", "COLON_EQUALS", "COLON", "EQUALS", "PLUS", "PLUS_EQ", "LBRACKET", "RBRACKET", "EQUALS_COLON", "LBRACE", "RBRACE", "FOR", "IN", "ATSIGN", "LPAREN", "RPAREN", "ARROW", "NIL", "QUESTION", "CARET", "MINUS_EQ", "STAR_EQ", "SLASH_EQ", "REM_EQ", "UDIV_EQ", "UREM_EQ", "MOD_EQ", "AND_EQ", "OR_EQ", "XOR_EQ", "LSHIFT_EQ", "RSHIFT_EQ", "URSHIFT_EQ", "CLSHIFT_EQ", "CRSHIFT_EQ", "PERIOD", "DO", "WHILE", "REPEAT", "AND", "BY", "AT", "BREAK", "IF", "THEN", "ELIF", "ELSE", "FI", "OR", "NOT", "COMPEQ", "COMPNE", "COMPLE", "COMPGE", "COMPULE", "COMPUGE", "LESS", "ULESS", "GREATER", "UGREATER", "BAR", "TILDE", "AMP", "LSHIFT", "RSHIFT", "URSHIFT", "CRSHIFT", "CLSHIFT", "MINUS", "STAR", "SLASH", "REM", "UREM", "PLUSPLUS", "MINUSMINUS", "NUMBER", "CHAR_LITERAL", "STRING_LITERAL", "AS", "FALSE", "TRUE", "COLONS", "DATA", "STATIC", "COLON_COLON_EQUALS", "HASH", "POINTS", "BAR_BAR", "SELECT", "WHEN", "UNTIL", "WITH", "END", "IDSUFFIX", "LETTERLIKE", "DIGIT", "NEWLINE", "WS", "SINGLE_COMMENT", "MULTI_COMMENT"
    };
    public static final int CAST=27;
    public static final int CONDTEST=24;
    public static final int STAR=139;
    public static final int WHILE=107;
    public static final int GENERIC=66;
    public static final int MOD=37;
    public static final int POINTER=57;
    public static final int LSHIFT_EQ=100;
    public static final int PREDEC=43;
    public static final int REM_EQ=93;
    public static final int DEREF=58;
    public static final int MINUSMINUS=144;
    public static final int DO=106;
    public static final int ARGLIST=13;
    public static final int EQUALS=73;
    public static final int NOT=119;
    public static final int EOF=-1;
    public static final int BREAK=112;
    public static final int TYPE=21;
    public static final int CODE=8;
    public static final int LBRACKET=76;
    public static final int TUPLE=50;
    public static final int RPAREN=85;
    public static final int STRING_LITERAL=147;
    public static final int GREATER=128;
    public static final int ADDRREF=59;
    public static final int ADDSCOPE=5;
    public static final int UREM_EQ=95;
    public static final int EXTENDSCOPE=6;
    public static final int COMPLE=122;
    public static final int AND_EQ=97;
    public static final int CARET=89;
    public static final int LESS=126;
    public static final int XOR_EQ=99;
    public static final int INITEXPR=63;
    public static final int INITLIST=64;
    public static final int ATSIGN=83;
    public static final int GOTO=48;
    public static final int SELECT=158;
    public static final int CLSHIFT_EQ=103;
    public static final int ARRAY=55;
    public static final int LABELSTMT=52;
    public static final int CRSHIFT=136;
    public static final int RBRACE=80;
    public static final int STMTEXPR=22;
    public static final int STATIC=153;
    public static final int PERIOD=105;
    public static final int LSHIFT=133;
    public static final int INV=39;
    public static final int ADDROF=60;
    public static final int ELSE=116;
    public static final int NUMBER=145;
    public static final int UDIV=36;
    public static final int LIT=44;
    public static final int CRSHIFT_EQ=104;
    public static final int UDIV_EQ=94;
    public static final int LIST=20;
    public static final int PLUS_EQ=75;
    public static final int MUL=34;
    public static final int RSHIFT_EQ=101;
    public static final int ARGDEF=14;
    public static final int FI=117;
    public static final int MINUS_EQ=90;
    public static final int ELIF=115;
    public static final int WS=167;
    public static final int OR_EQ=98;
    public static final int BITOR=30;
    public static final int NIL=87;
    public static final int TYPEOF=62;
    public static final int UNTIL=160;
    public static final int STMTLIST=11;
    public static final int OR=118;
    public static final int SIZEOF=61;
    public static final int ALLOC=16;
    public static final int IDLIST=46;
    public static final int REPEAT=108;
    public static final int INLINE=26;
    public static final int CALL=25;
    public static final int POSTINC=40;
    public static final int END=162;
    public static final int FALSE=149;
    public static final int COMPULE=124;
    public static final int POSTDEC=41;
    public static final int MOD_EQ=96;
    public static final int BINDING=53;
    public static final int FORWARD=68;
    public static final int BAR_BAR=157;
    public static final int AMP=132;
    public static final int POINTS=156;
    public static final int PLUSPLUS=143;
    public static final int UGREATER=129;
    public static final int LBRACE=79;
    public static final int MULTI_COMMENT=169;
    public static final int FIELDREF=54;
    public static final int FOR=81;
    public static final int SUB=33;
    public static final int AND=109;
    public static final int ID=69;
    public static final int DEFINE=18;
    public static final int UREM=142;
    public static final int BITAND=29;
    public static final int LPAREN=84;
    public static final int IF=113;
    public static final int COLONS=151;
    public static final int COLON_COLON_EQUALS=154;
    public static final int AT=111;
    public static final int AS=148;
    public static final int INDEX=56;
    public static final int CONDLIST=23;
    public static final int IDSUFFIX=163;
    public static final int SLASH=140;
    public static final int EXPR=19;
    public static final int THEN=114;
    public static final int IN=82;
    public static final int SCOPE=4;
    public static final int COMMA=70;
    public static final int PREINC=42;
    public static final int BITXOR=31;
    public static final int TILDE=131;
    public static final int PLUS=74;
    public static final int SINGLE_COMMENT=168;
    public static final int DIGIT=165;
    public static final int RBRACKET=77;
    public static final int RSHIFT=134;
    public static final int WITH=161;
    public static final int ADD=32;
    public static final int EQUALS_COLON=78;
    public static final int COMPGE=123;
    public static final int URSHIFT_EQ=102;
    public static final int ULESS=127;
    public static final int BY=110;
    public static final int LETTERLIKE=164;
    public static final int LIST_COMPREHENSION=7;
    public static final int HASH=155;
    public static final int CLSHIFT=137;
    public static final int STAR_EQ=91;
    public static final int REM=141;
    public static final int MINUS=138;
    public static final int TRUE=150;
    public static final int SEMI=67;
    public static final int REF=15;
    public static final int COLON=72;
    public static final int TUPLETYPE=51;
    public static final int COLON_EQUALS=71;
    public static final int NEWLINE=166;
    public static final int QUESTION=88;
    public static final int CHAR_LITERAL=146;
    public static final int LABEL=47;
    public static final int WHEN=159;
    public static final int INSTANCE=65;
    public static final int BLOCK=49;
    public static final int NEG=38;
    public static final int ASSIGN=17;
    public static final int URSHIFT=135;
    public static final int ARROW=86;
    public static final int COMPEQ=120;
    public static final int IDREF=45;
    public static final int DIV=35;
    public static final int COND=28;
    public static final int MACRO=10;
    public static final int PROTO=12;
    public static final int COMPNE=121;
    public static final int METHOD=9;
    public static final int DATA=152;
    public static final int BAR=130;
    public static final int COMPUGE=125;
    public static final int SLASH_EQ=92;

    // delegates
    // delegators


        public EulangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EulangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EulangParser.tokenNames; }
    public String getGrammarFileName() { return "/home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g"; }


        public String getTokenErrorDisplay(Token t) {
            return '\'' + t.getText() + '\'';
        }

      protected CommonTree split(CommonTree items) {
            if (items == null) return null;
            StringBuilder sb = new StringBuilder();
            if (items.getText()!=null) sb.append(items.getText());
            for (int  i = 0; i < items.getChildCount(); i++)
              sb.append(items.getChild(i).getText());
            //return new CommonTree(new CommonToken(COLONS, sb.toString()));
            CommonTree out = new CommonTree();
            for (int i = 0; i < sb.length(); i++) 
              out.addChild(new CommonTree(new CommonToken(COLON, ":")));
              return out;
          }


    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:128:1: prog : toplevelstmts EOF ;
    public final EulangParser.prog_return prog() throws RecognitionException {
        EulangParser.prog_return retval = new EulangParser.prog_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        EulangParser.toplevelstmts_return toplevelstmts1 = null;


        CommonTree EOF2_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:128:5: ( toplevelstmts EOF )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:128:9: toplevelstmts EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_toplevelstmts_in_prog437);
            toplevelstmts1=toplevelstmts();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, toplevelstmts1.getTree());
            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_prog439); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "prog"

    public static class toplevelstmts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelstmts"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:131:1: toplevelstmts : ( toplevelstat )* -> ^( STMTLIST ( toplevelstat )* ) ;
    public final EulangParser.toplevelstmts_return toplevelstmts() throws RecognitionException {
        EulangParser.toplevelstmts_return retval = new EulangParser.toplevelstmts_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.toplevelstat_return toplevelstat3 = null;


        RewriteRuleSubtreeStream stream_toplevelstat=new RewriteRuleSubtreeStream(adaptor,"rule toplevelstat");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:131:14: ( ( toplevelstat )* -> ^( STMTLIST ( toplevelstat )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:131:16: ( toplevelstat )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:131:16: ( toplevelstat )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==CODE||(LA1_0>=SIZEOF && LA1_0<=TYPEOF)||(LA1_0>=FORWARD && LA1_0<=ID)||LA1_0==COLON||LA1_0==LBRACE||LA1_0==LPAREN||LA1_0==NIL||LA1_0==IF||LA1_0==NOT||(LA1_0>=TILDE && LA1_0<=AMP)||LA1_0==MINUS||(LA1_0>=PLUSPLUS && LA1_0<=STRING_LITERAL)||(LA1_0>=FALSE && LA1_0<=COLONS)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:131:16: toplevelstat
            	    {
            	    pushFollow(FOLLOW_toplevelstat_in_toplevelstmts468);
            	    toplevelstat3=toplevelstat();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_toplevelstat.add(toplevelstat3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: toplevelstat
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 131:35: -> ^( STMTLIST ( toplevelstat )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:131:38: ^( STMTLIST ( toplevelstat )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMTLIST, "STMTLIST"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:131:49: ( toplevelstat )*
                while ( stream_toplevelstat.hasNext() ) {
                    adaptor.addChild(root_1, stream_toplevelstat.nextTree());

                }
                stream_toplevelstat.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelstmts"

    public static class toplevelstmtsNoAlloc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelstmtsNoAlloc"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:133:1: toplevelstmtsNoAlloc : ( toplevelstatNoAlloc )* -> ^( STMTLIST ( toplevelstatNoAlloc )* ) ;
    public final EulangParser.toplevelstmtsNoAlloc_return toplevelstmtsNoAlloc() throws RecognitionException {
        EulangParser.toplevelstmtsNoAlloc_return retval = new EulangParser.toplevelstmtsNoAlloc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.toplevelstatNoAlloc_return toplevelstatNoAlloc4 = null;


        RewriteRuleSubtreeStream stream_toplevelstatNoAlloc=new RewriteRuleSubtreeStream(adaptor,"rule toplevelstatNoAlloc");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:133:21: ( ( toplevelstatNoAlloc )* -> ^( STMTLIST ( toplevelstatNoAlloc )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:133:23: ( toplevelstatNoAlloc )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:133:23: ( toplevelstatNoAlloc )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==CODE||(LA2_0>=SIZEOF && LA2_0<=TYPEOF)||(LA2_0>=FORWARD && LA2_0<=ID)||LA2_0==COLON||LA2_0==LBRACE||LA2_0==LPAREN||LA2_0==NIL||LA2_0==IF||LA2_0==NOT||(LA2_0>=TILDE && LA2_0<=AMP)||LA2_0==MINUS||(LA2_0>=PLUSPLUS && LA2_0<=STRING_LITERAL)||(LA2_0>=FALSE && LA2_0<=COLONS)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:133:23: toplevelstatNoAlloc
            	    {
            	    pushFollow(FOLLOW_toplevelstatNoAlloc_in_toplevelstmtsNoAlloc495);
            	    toplevelstatNoAlloc4=toplevelstatNoAlloc();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_toplevelstatNoAlloc.add(toplevelstatNoAlloc4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);



            // AST REWRITE
            // elements: toplevelstatNoAlloc
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 133:49: -> ^( STMTLIST ( toplevelstatNoAlloc )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:133:52: ^( STMTLIST ( toplevelstatNoAlloc )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMTLIST, "STMTLIST"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:133:63: ( toplevelstatNoAlloc )*
                while ( stream_toplevelstatNoAlloc.hasNext() ) {
                    adaptor.addChild(root_1, stream_toplevelstatNoAlloc.nextTree());

                }
                stream_toplevelstatNoAlloc.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelstmtsNoAlloc"

    public static class toplevelstat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelstat"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:136:1: toplevelstat : ( toplevelstatNoAlloc -> toplevelstatNoAlloc | toplevelAlloc SEMI -> toplevelAlloc );
    public final EulangParser.toplevelstat_return toplevelstat() throws RecognitionException {
        EulangParser.toplevelstat_return retval = new EulangParser.toplevelstat_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMI7=null;
        EulangParser.toplevelstatNoAlloc_return toplevelstatNoAlloc5 = null;

        EulangParser.toplevelAlloc_return toplevelAlloc6 = null;


        CommonTree SEMI7_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_toplevelstatNoAlloc=new RewriteRuleSubtreeStream(adaptor,"rule toplevelstatNoAlloc");
        RewriteRuleSubtreeStream stream_toplevelAlloc=new RewriteRuleSubtreeStream(adaptor,"rule toplevelAlloc");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:136:14: ( toplevelstatNoAlloc -> toplevelstatNoAlloc | toplevelAlloc SEMI -> toplevelAlloc )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:136:16: toplevelstatNoAlloc
                    {
                    pushFollow(FOLLOW_toplevelstatNoAlloc_in_toplevelstat524);
                    toplevelstatNoAlloc5=toplevelstatNoAlloc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_toplevelstatNoAlloc.add(toplevelstatNoAlloc5.getTree());


                    // AST REWRITE
                    // elements: toplevelstatNoAlloc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 136:36: -> toplevelstatNoAlloc
                    {
                        adaptor.addChild(root_0, stream_toplevelstatNoAlloc.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:137:7: toplevelAlloc SEMI
                    {
                    pushFollow(FOLLOW_toplevelAlloc_in_toplevelstat537);
                    toplevelAlloc6=toplevelAlloc();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_toplevelAlloc.add(toplevelAlloc6.getTree());
                    SEMI7=(Token)match(input,SEMI,FOLLOW_SEMI_in_toplevelstat539); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI7);



                    // AST REWRITE
                    // elements: toplevelAlloc
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 137:26: -> toplevelAlloc
                    {
                        adaptor.addChild(root_0, stream_toplevelAlloc.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelstat"

    public static class toplevelstatNoAlloc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelstatNoAlloc"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:139:1: toplevelstatNoAlloc : ( defineStmt | scopeExtension ( SEMI )? -> scopeExtension | FORWARD ID ( COMMA ID )* SEMI -> ( ^( FORWARD ID ) )+ | rhsExpr SEMI -> ^( EXPR rhsExpr ) | ( LBRACE )=> xscope ( SEMI )? );
    public final EulangParser.toplevelstatNoAlloc_return toplevelstatNoAlloc() throws RecognitionException {
        EulangParser.toplevelstatNoAlloc_return retval = new EulangParser.toplevelstatNoAlloc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMI10=null;
        Token FORWARD11=null;
        Token ID12=null;
        Token COMMA13=null;
        Token ID14=null;
        Token SEMI15=null;
        Token SEMI17=null;
        Token SEMI19=null;
        EulangParser.defineStmt_return defineStmt8 = null;

        EulangParser.scopeExtension_return scopeExtension9 = null;

        EulangParser.rhsExpr_return rhsExpr16 = null;

        EulangParser.xscope_return xscope18 = null;


        CommonTree SEMI10_tree=null;
        CommonTree FORWARD11_tree=null;
        CommonTree ID12_tree=null;
        CommonTree COMMA13_tree=null;
        CommonTree ID14_tree=null;
        CommonTree SEMI15_tree=null;
        CommonTree SEMI17_tree=null;
        CommonTree SEMI19_tree=null;
        RewriteRuleTokenStream stream_FORWARD=new RewriteRuleTokenStream(adaptor,"token FORWARD");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_scopeExtension=new RewriteRuleSubtreeStream(adaptor,"rule scopeExtension");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:139:20: ( defineStmt | scopeExtension ( SEMI )? -> scopeExtension | FORWARD ID ( COMMA ID )* SEMI -> ( ^( FORWARD ID ) )+ | rhsExpr SEMI -> ^( EXPR rhsExpr ) | ( LBRACE )=> xscope ( SEMI )? )
            int alt7=5;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:139:22: defineStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_defineStmt_in_toplevelstatNoAlloc554);
                    defineStmt8=defineStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defineStmt8.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:140:7: scopeExtension ( SEMI )?
                    {
                    pushFollow(FOLLOW_scopeExtension_in_toplevelstatNoAlloc562);
                    scopeExtension9=scopeExtension();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_scopeExtension.add(scopeExtension9.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:140:22: ( SEMI )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==SEMI) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:140:22: SEMI
                            {
                            SEMI10=(Token)match(input,SEMI,FOLLOW_SEMI_in_toplevelstatNoAlloc564); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_SEMI.add(SEMI10);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: scopeExtension
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 140:28: -> scopeExtension
                    {
                        adaptor.addChild(root_0, stream_scopeExtension.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:141:7: FORWARD ID ( COMMA ID )* SEMI
                    {
                    FORWARD11=(Token)match(input,FORWARD,FOLLOW_FORWARD_in_toplevelstatNoAlloc578); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FORWARD.add(FORWARD11);

                    ID12=(Token)match(input,ID,FOLLOW_ID_in_toplevelstatNoAlloc580); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID12);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:141:18: ( COMMA ID )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==COMMA) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:141:19: COMMA ID
                    	    {
                    	    COMMA13=(Token)match(input,COMMA,FOLLOW_COMMA_in_toplevelstatNoAlloc583); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA13);

                    	    ID14=(Token)match(input,ID,FOLLOW_ID_in_toplevelstatNoAlloc585); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID14);


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    SEMI15=(Token)match(input,SEMI,FOLLOW_SEMI_in_toplevelstatNoAlloc589); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI15);



                    // AST REWRITE
                    // elements: ID, FORWARD
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 141:35: -> ( ^( FORWARD ID ) )+
                    {
                        if ( !(stream_ID.hasNext()||stream_FORWARD.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext()||stream_FORWARD.hasNext() ) {
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:141:38: ^( FORWARD ID )
                            {
                            CommonTree root_1 = (CommonTree)adaptor.nil();
                            root_1 = (CommonTree)adaptor.becomeRoot(stream_FORWARD.nextNode(), root_1);

                            adaptor.addChild(root_1, stream_ID.nextNode());

                            adaptor.addChild(root_0, root_1);
                            }

                        }
                        stream_ID.reset();
                        stream_FORWARD.reset();

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:142:7: rhsExpr SEMI
                    {
                    pushFollow(FOLLOW_rhsExpr_in_toplevelstatNoAlloc606);
                    rhsExpr16=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr16.getTree());
                    SEMI17=(Token)match(input,SEMI,FOLLOW_SEMI_in_toplevelstatNoAlloc625); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI17);



                    // AST REWRITE
                    // elements: rhsExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 142:38: -> ^( EXPR rhsExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:142:41: ^( EXPR rhsExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR, "EXPR"), root_1);

                        adaptor.addChild(root_1, stream_rhsExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:143:7: ( LBRACE )=> xscope ( SEMI )?
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_xscope_in_toplevelstatNoAlloc648);
                    xscope18=xscope();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, xscope18.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:143:26: ( SEMI )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==SEMI) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:143:26: SEMI
                            {
                            SEMI19=(Token)match(input,SEMI,FOLLOW_SEMI_in_toplevelstatNoAlloc650); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            SEMI19_tree = (CommonTree)adaptor.create(SEMI19);
                            adaptor.addChild(root_0, SEMI19_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelstatNoAlloc"

    public static class toplevelAlloc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelAlloc"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:146:1: toplevelAlloc : ( toplevelSingleVarDecl | toplevelTupleVarDecl );
    public final EulangParser.toplevelAlloc_return toplevelAlloc() throws RecognitionException {
        EulangParser.toplevelAlloc_return retval = new EulangParser.toplevelAlloc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.toplevelSingleVarDecl_return toplevelSingleVarDecl20 = null;

        EulangParser.toplevelTupleVarDecl_return toplevelTupleVarDecl21 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:146:15: ( toplevelSingleVarDecl | toplevelTupleVarDecl )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==LPAREN) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:146:17: toplevelSingleVarDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_toplevelSingleVarDecl_in_toplevelAlloc665);
                    toplevelSingleVarDecl20=toplevelSingleVarDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, toplevelSingleVarDecl20.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:146:41: toplevelTupleVarDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_toplevelTupleVarDecl_in_toplevelAlloc669);
                    toplevelTupleVarDecl21=toplevelTupleVarDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, toplevelTupleVarDecl21.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelAlloc"

    public static class toplevelSingleVarDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelSingleVarDecl"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:148:1: toplevelSingleVarDecl : ID ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC ID TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC ID type ( rhsExprOrInitList )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) ) | ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? ) ) ) ;
    public final EulangParser.toplevelSingleVarDecl_return toplevelSingleVarDecl() throws RecognitionException {
        EulangParser.toplevelSingleVarDecl_return retval = new EulangParser.toplevelSingleVarDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID22=null;
        Token COLON_EQUALS23=null;
        Token COLON25=null;
        Token EQUALS27=null;
        Token COMMA29=null;
        Token ID30=null;
        Token COLON_EQUALS31=null;
        Token PLUS32=null;
        Token COMMA34=null;
        Token COLON36=null;
        Token EQUALS38=null;
        Token PLUS39=null;
        Token COMMA41=null;
        EulangParser.rhsExprOrInitList_return rhsExprOrInitList24 = null;

        EulangParser.type_return type26 = null;

        EulangParser.rhsExprOrInitList_return rhsExprOrInitList28 = null;

        EulangParser.rhsExprOrInitList_return rhsExprOrInitList33 = null;

        EulangParser.rhsExprOrInitList_return rhsExprOrInitList35 = null;

        EulangParser.type_return type37 = null;

        EulangParser.rhsExprOrInitList_return rhsExprOrInitList40 = null;

        EulangParser.rhsExprOrInitList_return rhsExprOrInitList42 = null;


        CommonTree ID22_tree=null;
        CommonTree COLON_EQUALS23_tree=null;
        CommonTree COLON25_tree=null;
        CommonTree EQUALS27_tree=null;
        CommonTree COMMA29_tree=null;
        CommonTree ID30_tree=null;
        CommonTree COLON_EQUALS31_tree=null;
        CommonTree PLUS32_tree=null;
        CommonTree COMMA34_tree=null;
        CommonTree COLON36_tree=null;
        CommonTree EQUALS38_tree=null;
        CommonTree PLUS39_tree=null;
        CommonTree COMMA41_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_COLON_EQUALS=new RewriteRuleTokenStream(adaptor,"token COLON_EQUALS");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_rhsExprOrInitList=new RewriteRuleSubtreeStream(adaptor,"rule rhsExprOrInitList");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:148:22: ( ID ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC ID TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC ID type ( rhsExprOrInitList )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) ) | ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? ) ) ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:149:5: ID ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC ID TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC ID type ( rhsExprOrInitList )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) ) | ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? ) ) )
            {
            ID22=(Token)match(input,ID,FOLLOW_ID_in_toplevelSingleVarDecl680); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID22);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:149:8: ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC ID TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC ID type ( rhsExprOrInitList )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) ) | ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? ) ) )
            int alt17=3;
            switch ( input.LA(1) ) {
            case COLON_EQUALS:
                {
                alt17=1;
                }
                break;
            case COLON:
                {
                alt17=2;
                }
                break;
            case COMMA:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:150:9: ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC ID TYPE rhsExprOrInitList ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:150:9: ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC ID TYPE rhsExprOrInitList ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:150:11: COLON_EQUALS rhsExprOrInitList
                    {
                    COLON_EQUALS23=(Token)match(input,COLON_EQUALS,FOLLOW_COLON_EQUALS_in_toplevelSingleVarDecl694); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON_EQUALS.add(COLON_EQUALS23);

                    pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl696);
                    rhsExprOrInitList24=rhsExprOrInitList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList24.getTree());


                    // AST REWRITE
                    // elements: ID, rhsExprOrInitList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 150:50: -> ^( ALLOC ID TYPE rhsExprOrInitList )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:150:53: ^( ALLOC ID TYPE rhsExprOrInitList )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, (CommonTree)adaptor.create(TYPE, "TYPE"));
                        adaptor.addChild(root_1, stream_rhsExprOrInitList.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:151:9: ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC ID type ( rhsExprOrInitList )* ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:151:9: ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC ID type ( rhsExprOrInitList )* ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:151:11: COLON type ( EQUALS rhsExprOrInitList )?
                    {
                    COLON25=(Token)match(input,COLON,FOLLOW_COLON_in_toplevelSingleVarDecl730); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON25);

                    pushFollow(FOLLOW_type_in_toplevelSingleVarDecl732);
                    type26=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type26.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:151:22: ( EQUALS rhsExprOrInitList )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==EQUALS) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:151:23: EQUALS rhsExprOrInitList
                            {
                            EQUALS27=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_toplevelSingleVarDecl735); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS27);

                            pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl737);
                            rhsExprOrInitList28=rhsExprOrInitList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList28.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: ID, rhsExprOrInitList, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 151:51: -> ^( ALLOC ID type ( rhsExprOrInitList )* )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:151:54: ^( ALLOC ID type ( rhsExprOrInitList )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_type.nextTree());
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:151:70: ( rhsExprOrInitList )*
                        while ( stream_rhsExprOrInitList.hasNext() ) {
                            adaptor.addChild(root_1, stream_rhsExprOrInitList.nextTree());

                        }
                        stream_rhsExprOrInitList.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:152:9: ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) ) | ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:152:9: ( COMMA ID )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==COMMA) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:152:11: COMMA ID
                    	    {
                    	    COMMA29=(Token)match(input,COMMA,FOLLOW_COMMA_in_toplevelSingleVarDecl767); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA29);

                    	    ID30=(Token)match(input,ID,FOLLOW_ID_in_toplevelSingleVarDecl769); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID30);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:9: ( ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) ) | ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? ) )
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==COLON_EQUALS) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==COLON) ) {
                        alt16=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 0, input);

                        throw nvae;
                    }
                    switch (alt16) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:12: ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )
                            {
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:12: ( COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:14: COLON_EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )*
                            {
                            COLON_EQUALS31=(Token)match(input,COLON_EQUALS,FOLLOW_COLON_EQUALS_in_toplevelSingleVarDecl788); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON_EQUALS.add(COLON_EQUALS31);

                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:27: ( PLUS )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==PLUS) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:27: PLUS
                                    {
                                    PLUS32=(Token)match(input,PLUS,FOLLOW_PLUS_in_toplevelSingleVarDecl790); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS32);


                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl793);
                            rhsExprOrInitList33=rhsExprOrInitList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList33.getTree());
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:51: ( COMMA rhsExprOrInitList )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==COMMA) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:153:52: COMMA rhsExprOrInitList
                            	    {
                            	    COMMA34=(Token)match(input,COMMA,FOLLOW_COMMA_in_toplevelSingleVarDecl796); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA34);

                            	    pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl798);
                            	    rhsExprOrInitList35=rhsExprOrInitList();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList35.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);


                            }



                            // AST REWRITE
                            // elements: PLUS, rhsExprOrInitList, ID
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 154:15: -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) )
                            {
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:154:18: ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( rhsExprOrInitList )+ ) )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:154:26: ^( LIST ( ID )+ )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                if ( !(stream_ID.hasNext()) ) {
                                    throw new RewriteEarlyExitException();
                                }
                                while ( stream_ID.hasNext() ) {
                                    adaptor.addChild(root_2, stream_ID.nextNode());

                                }
                                stream_ID.reset();

                                adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_1, (CommonTree)adaptor.create(TYPE, "TYPE"));
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:154:43: ( PLUS )?
                                if ( stream_PLUS.hasNext() ) {
                                    adaptor.addChild(root_1, stream_PLUS.nextNode());

                                }
                                stream_PLUS.reset();
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:154:49: ^( LIST ( rhsExprOrInitList )+ )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                if ( !(stream_rhsExprOrInitList.hasNext()) ) {
                                    throw new RewriteEarlyExitException();
                                }
                                while ( stream_rhsExprOrInitList.hasNext() ) {
                                    adaptor.addChild(root_2, stream_rhsExprOrInitList.nextTree());

                                }
                                stream_rhsExprOrInitList.reset();

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:12: ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? )
                            {
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:12: ( COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )? )
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:14: COLON type ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )?
                            {
                            COLON36=(Token)match(input,COLON,FOLLOW_COLON_in_toplevelSingleVarDecl857); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON36);

                            pushFollow(FOLLOW_type_in_toplevelSingleVarDecl859);
                            type37=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_type.add(type37.getTree());
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:25: ( EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )* )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==EQUALS) ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:26: EQUALS ( PLUS )? rhsExprOrInitList ( COMMA rhsExprOrInitList )*
                                    {
                                    EQUALS38=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_toplevelSingleVarDecl862); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS38);

                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:33: ( PLUS )?
                                    int alt13=2;
                                    int LA13_0 = input.LA(1);

                                    if ( (LA13_0==PLUS) ) {
                                        alt13=1;
                                    }
                                    switch (alt13) {
                                        case 1 :
                                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:33: PLUS
                                            {
                                            PLUS39=(Token)match(input,PLUS,FOLLOW_PLUS_in_toplevelSingleVarDecl864); if (state.failed) return retval; 
                                            if ( state.backtracking==0 ) stream_PLUS.add(PLUS39);


                                            }
                                            break;

                                    }

                                    pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl867);
                                    rhsExprOrInitList40=rhsExprOrInitList();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList40.getTree());
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:57: ( COMMA rhsExprOrInitList )*
                                    loop14:
                                    do {
                                        int alt14=2;
                                        int LA14_0 = input.LA(1);

                                        if ( (LA14_0==COMMA) ) {
                                            alt14=1;
                                        }


                                        switch (alt14) {
                                    	case 1 :
                                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:155:58: COMMA rhsExprOrInitList
                                    	    {
                                    	    COMMA41=(Token)match(input,COMMA,FOLLOW_COMMA_in_toplevelSingleVarDecl870); if (state.failed) return retval; 
                                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA41);

                                    	    pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl872);
                                    	    rhsExprOrInitList42=rhsExprOrInitList();

                                    	    state._fsp--;
                                    	    if (state.failed) return retval;
                                    	    if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList42.getTree());

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop14;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }



                            // AST REWRITE
                            // elements: type, rhsExprOrInitList, PLUS, ID
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 156:15: -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? )
                            {
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:156:18: ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( rhsExprOrInitList )+ ) )? )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:156:26: ^( LIST ( ID )+ )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                if ( !(stream_ID.hasNext()) ) {
                                    throw new RewriteEarlyExitException();
                                }
                                while ( stream_ID.hasNext() ) {
                                    adaptor.addChild(root_2, stream_ID.nextNode());

                                }
                                stream_ID.reset();

                                adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_1, stream_type.nextTree());
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:156:43: ( PLUS )?
                                if ( stream_PLUS.hasNext() ) {
                                    adaptor.addChild(root_1, stream_PLUS.nextNode());

                                }
                                stream_PLUS.reset();
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:156:49: ( ^( LIST ( rhsExprOrInitList )+ ) )?
                                if ( stream_rhsExprOrInitList.hasNext() ) {
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:156:49: ^( LIST ( rhsExprOrInitList )+ )
                                    {
                                    CommonTree root_2 = (CommonTree)adaptor.nil();
                                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                    if ( !(stream_rhsExprOrInitList.hasNext()) ) {
                                        throw new RewriteEarlyExitException();
                                    }
                                    while ( stream_rhsExprOrInitList.hasNext() ) {
                                        adaptor.addChild(root_2, stream_rhsExprOrInitList.nextTree());

                                    }
                                    stream_rhsExprOrInitList.reset();

                                    adaptor.addChild(root_1, root_2);
                                    }

                                }
                                stream_rhsExprOrInitList.reset();

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelSingleVarDecl"

    public static class toplevelTupleVarDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelTupleVarDecl"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:161:1: toplevelTupleVarDecl : idTuple ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC idTuple TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC idTuple type ( rhsExprOrInitList )* ) ) ) ;
    public final EulangParser.toplevelTupleVarDecl_return toplevelTupleVarDecl() throws RecognitionException {
        EulangParser.toplevelTupleVarDecl_return retval = new EulangParser.toplevelTupleVarDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON_EQUALS44=null;
        Token COLON46=null;
        Token EQUALS48=null;
        EulangParser.idTuple_return idTuple43 = null;

        EulangParser.rhsExprOrInitList_return rhsExprOrInitList45 = null;

        EulangParser.type_return type47 = null;

        EulangParser.rhsExprOrInitList_return rhsExprOrInitList49 = null;


        CommonTree COLON_EQUALS44_tree=null;
        CommonTree COLON46_tree=null;
        CommonTree EQUALS48_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_COLON_EQUALS=new RewriteRuleTokenStream(adaptor,"token COLON_EQUALS");
        RewriteRuleSubtreeStream stream_idTuple=new RewriteRuleSubtreeStream(adaptor,"rule idTuple");
        RewriteRuleSubtreeStream stream_rhsExprOrInitList=new RewriteRuleSubtreeStream(adaptor,"rule rhsExprOrInitList");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:161:21: ( idTuple ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC idTuple TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC idTuple type ( rhsExprOrInitList )* ) ) ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:162:5: idTuple ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC idTuple TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC idTuple type ( rhsExprOrInitList )* ) ) )
            {
            pushFollow(FOLLOW_idTuple_in_toplevelTupleVarDecl963);
            idTuple43=idTuple();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_idTuple.add(idTuple43.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:163:7: ( ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC idTuple TYPE rhsExprOrInitList ) ) | ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC idTuple type ( rhsExprOrInitList )* ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==COLON_EQUALS) ) {
                alt19=1;
            }
            else if ( (LA19_0==COLON) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:164:9: ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC idTuple TYPE rhsExprOrInitList ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:164:9: ( COLON_EQUALS rhsExprOrInitList -> ^( ALLOC idTuple TYPE rhsExprOrInitList ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:164:11: COLON_EQUALS rhsExprOrInitList
                    {
                    COLON_EQUALS44=(Token)match(input,COLON_EQUALS,FOLLOW_COLON_EQUALS_in_toplevelTupleVarDecl985); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON_EQUALS.add(COLON_EQUALS44);

                    pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelTupleVarDecl987);
                    rhsExprOrInitList45=rhsExprOrInitList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList45.getTree());


                    // AST REWRITE
                    // elements: idTuple, rhsExprOrInitList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 164:50: -> ^( ALLOC idTuple TYPE rhsExprOrInitList )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:164:53: ^( ALLOC idTuple TYPE rhsExprOrInitList )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_idTuple.nextTree());
                        adaptor.addChild(root_1, (CommonTree)adaptor.create(TYPE, "TYPE"));
                        adaptor.addChild(root_1, stream_rhsExprOrInitList.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:165:9: ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC idTuple type ( rhsExprOrInitList )* ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:165:9: ( COLON type ( EQUALS rhsExprOrInitList )? -> ^( ALLOC idTuple type ( rhsExprOrInitList )* ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:165:11: COLON type ( EQUALS rhsExprOrInitList )?
                    {
                    COLON46=(Token)match(input,COLON,FOLLOW_COLON_in_toplevelTupleVarDecl1021); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON46);

                    pushFollow(FOLLOW_type_in_toplevelTupleVarDecl1023);
                    type47=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type47.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:165:22: ( EQUALS rhsExprOrInitList )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==EQUALS) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:165:23: EQUALS rhsExprOrInitList
                            {
                            EQUALS48=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_toplevelTupleVarDecl1026); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS48);

                            pushFollow(FOLLOW_rhsExprOrInitList_in_toplevelTupleVarDecl1028);
                            rhsExprOrInitList49=rhsExprOrInitList();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_rhsExprOrInitList.add(rhsExprOrInitList49.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: rhsExprOrInitList, type, idTuple
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 165:51: -> ^( ALLOC idTuple type ( rhsExprOrInitList )* )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:165:54: ^( ALLOC idTuple type ( rhsExprOrInitList )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_idTuple.nextTree());
                        adaptor.addChild(root_1, stream_type.nextTree());
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:165:75: ( rhsExprOrInitList )*
                        while ( stream_rhsExprOrInitList.hasNext() ) {
                            adaptor.addChild(root_1, stream_rhsExprOrInitList.nextTree());

                        }
                        stream_rhsExprOrInitList.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelTupleVarDecl"

    public static class rhsExprOrInitList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rhsExprOrInitList"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:169:1: rhsExprOrInitList : ( rhsExpr | initList );
    public final EulangParser.rhsExprOrInitList_return rhsExprOrInitList() throws RecognitionException {
        EulangParser.rhsExprOrInitList_return retval = new EulangParser.rhsExprOrInitList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.rhsExpr_return rhsExpr50 = null;

        EulangParser.initList_return initList51 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:169:19: ( rhsExpr | initList )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==CODE||(LA20_0>=SIZEOF && LA20_0<=TYPEOF)||LA20_0==ID||LA20_0==COLON||LA20_0==LPAREN||LA20_0==NIL||LA20_0==IF||LA20_0==NOT||(LA20_0>=TILDE && LA20_0<=AMP)||LA20_0==MINUS||(LA20_0>=PLUSPLUS && LA20_0<=STRING_LITERAL)||(LA20_0>=FALSE && LA20_0<=COLONS)) ) {
                alt20=1;
            }
            else if ( (LA20_0==LBRACKET) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:169:21: rhsExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rhsExpr_in_rhsExprOrInitList1071);
                    rhsExpr50=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rhsExpr50.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:169:31: initList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_initList_in_rhsExprOrInitList1075);
                    initList51=initList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, initList51.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "rhsExprOrInitList"

    public static class scopeExtension_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scopeExtension"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:171:1: scopeExtension : namespaceRef PLUS_EQ xscopeNoAlloc -> ^( EXTENDSCOPE namespaceRef xscopeNoAlloc ) ;
    public final EulangParser.scopeExtension_return scopeExtension() throws RecognitionException {
        EulangParser.scopeExtension_return retval = new EulangParser.scopeExtension_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS_EQ53=null;
        EulangParser.namespaceRef_return namespaceRef52 = null;

        EulangParser.xscopeNoAlloc_return xscopeNoAlloc54 = null;


        CommonTree PLUS_EQ53_tree=null;
        RewriteRuleTokenStream stream_PLUS_EQ=new RewriteRuleTokenStream(adaptor,"token PLUS_EQ");
        RewriteRuleSubtreeStream stream_xscopeNoAlloc=new RewriteRuleSubtreeStream(adaptor,"rule xscopeNoAlloc");
        RewriteRuleSubtreeStream stream_namespaceRef=new RewriteRuleSubtreeStream(adaptor,"rule namespaceRef");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:171:16: ( namespaceRef PLUS_EQ xscopeNoAlloc -> ^( EXTENDSCOPE namespaceRef xscopeNoAlloc ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:171:18: namespaceRef PLUS_EQ xscopeNoAlloc
            {
            pushFollow(FOLLOW_namespaceRef_in_scopeExtension1084);
            namespaceRef52=namespaceRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_namespaceRef.add(namespaceRef52.getTree());
            PLUS_EQ53=(Token)match(input,PLUS_EQ,FOLLOW_PLUS_EQ_in_scopeExtension1086); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PLUS_EQ.add(PLUS_EQ53);

            pushFollow(FOLLOW_xscopeNoAlloc_in_scopeExtension1088);
            xscopeNoAlloc54=xscopeNoAlloc();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_xscopeNoAlloc.add(xscopeNoAlloc54.getTree());


            // AST REWRITE
            // elements: xscopeNoAlloc, namespaceRef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 171:53: -> ^( EXTENDSCOPE namespaceRef xscopeNoAlloc )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:171:56: ^( EXTENDSCOPE namespaceRef xscopeNoAlloc )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXTENDSCOPE, "EXTENDSCOPE"), root_1);

                adaptor.addChild(root_1, stream_namespaceRef.nextTree());
                adaptor.addChild(root_1, stream_xscopeNoAlloc.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "scopeExtension"

    public static class defineStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defineStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:173:1: defineStmt : ( ( ID EQUALS LBRACKET )=> ID EQUALS LBRACKET idlistOrEmpty RBRACKET toplevelvalue SEMI -> ^( DEFINE ID idlistOrEmpty toplevelvalue ) | ( ID EQUALS_COLON )=> ID EQUALS_COLON type SEMI -> ^( DEFINE ID type ) | ( ID EQUALS )=> ID EQUALS toplevelvalue SEMI -> ^( DEFINE ID toplevelvalue ) );
    public final EulangParser.defineStmt_return defineStmt() throws RecognitionException {
        EulangParser.defineStmt_return retval = new EulangParser.defineStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID55=null;
        Token EQUALS56=null;
        Token LBRACKET57=null;
        Token RBRACKET59=null;
        Token SEMI61=null;
        Token ID62=null;
        Token EQUALS_COLON63=null;
        Token SEMI65=null;
        Token ID66=null;
        Token EQUALS67=null;
        Token SEMI69=null;
        EulangParser.idlistOrEmpty_return idlistOrEmpty58 = null;

        EulangParser.toplevelvalue_return toplevelvalue60 = null;

        EulangParser.type_return type64 = null;

        EulangParser.toplevelvalue_return toplevelvalue68 = null;


        CommonTree ID55_tree=null;
        CommonTree EQUALS56_tree=null;
        CommonTree LBRACKET57_tree=null;
        CommonTree RBRACKET59_tree=null;
        CommonTree SEMI61_tree=null;
        CommonTree ID62_tree=null;
        CommonTree EQUALS_COLON63_tree=null;
        CommonTree SEMI65_tree=null;
        CommonTree ID66_tree=null;
        CommonTree EQUALS67_tree=null;
        CommonTree SEMI69_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_EQUALS_COLON=new RewriteRuleTokenStream(adaptor,"token EQUALS_COLON");
        RewriteRuleSubtreeStream stream_toplevelvalue=new RewriteRuleSubtreeStream(adaptor,"rule toplevelvalue");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        RewriteRuleSubtreeStream stream_idlistOrEmpty=new RewriteRuleSubtreeStream(adaptor,"rule idlistOrEmpty");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:173:12: ( ( ID EQUALS LBRACKET )=> ID EQUALS LBRACKET idlistOrEmpty RBRACKET toplevelvalue SEMI -> ^( DEFINE ID idlistOrEmpty toplevelvalue ) | ( ID EQUALS_COLON )=> ID EQUALS_COLON type SEMI -> ^( DEFINE ID type ) | ( ID EQUALS )=> ID EQUALS toplevelvalue SEMI -> ^( DEFINE ID toplevelvalue ) )
            int alt21=3;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:173:14: ( ID EQUALS LBRACKET )=> ID EQUALS LBRACKET idlistOrEmpty RBRACKET toplevelvalue SEMI
                    {
                    ID55=(Token)match(input,ID,FOLLOW_ID_in_defineStmt1117); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID55);

                    EQUALS56=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_defineStmt1119); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS56);

                    LBRACKET57=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_defineStmt1121); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET57);

                    pushFollow(FOLLOW_idlistOrEmpty_in_defineStmt1123);
                    idlistOrEmpty58=idlistOrEmpty();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_idlistOrEmpty.add(idlistOrEmpty58.getTree());
                    RBRACKET59=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_defineStmt1125); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET59);

                    pushFollow(FOLLOW_toplevelvalue_in_defineStmt1128);
                    toplevelvalue60=toplevelvalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_toplevelvalue.add(toplevelvalue60.getTree());
                    SEMI61=(Token)match(input,SEMI,FOLLOW_SEMI_in_defineStmt1134); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI61);



                    // AST REWRITE
                    // elements: ID, toplevelvalue, idlistOrEmpty
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 173:105: -> ^( DEFINE ID idlistOrEmpty toplevelvalue )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:173:108: ^( DEFINE ID idlistOrEmpty toplevelvalue )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEFINE, "DEFINE"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_idlistOrEmpty.nextTree());
                        adaptor.addChild(root_1, stream_toplevelvalue.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:174:7: ( ID EQUALS_COLON )=> ID EQUALS_COLON type SEMI
                    {
                    ID62=(Token)match(input,ID,FOLLOW_ID_in_defineStmt1164); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID62);

                    EQUALS_COLON63=(Token)match(input,EQUALS_COLON,FOLLOW_EQUALS_COLON_in_defineStmt1166); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS_COLON.add(EQUALS_COLON63);

                    pushFollow(FOLLOW_type_in_defineStmt1168);
                    type64=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type64.getTree());
                    SEMI65=(Token)match(input,SEMI,FOLLOW_SEMI_in_defineStmt1174); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI65);



                    // AST REWRITE
                    // elements: ID, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 174:59: -> ^( DEFINE ID type )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:174:62: ^( DEFINE ID type )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEFINE, "DEFINE"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_type.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:175:7: ( ID EQUALS )=> ID EQUALS toplevelvalue SEMI
                    {
                    ID66=(Token)match(input,ID,FOLLOW_ID_in_defineStmt1201); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID66);

                    EQUALS67=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_defineStmt1203); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS67);

                    pushFollow(FOLLOW_toplevelvalue_in_defineStmt1205);
                    toplevelvalue68=toplevelvalue();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_toplevelvalue.add(toplevelvalue68.getTree());
                    SEMI69=(Token)match(input,SEMI,FOLLOW_SEMI_in_defineStmt1211); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI69);



                    // AST REWRITE
                    // elements: ID, toplevelvalue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 175:56: -> ^( DEFINE ID toplevelvalue )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:175:59: ^( DEFINE ID toplevelvalue )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEFINE, "DEFINE"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_toplevelvalue.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "defineStmt"

    public static class toplevelvalue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "toplevelvalue"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:178:1: toplevelvalue : ( ( LBRACE )=> xscope | namespaceRef PLUS data -> ^( ADDSCOPE namespaceRef data ) | namespaceRef PLUS xscope -> ^( ADDSCOPE namespaceRef xscope ) | selector | rhsExpr | data | macro );
    public final EulangParser.toplevelvalue_return toplevelvalue() throws RecognitionException {
        EulangParser.toplevelvalue_return retval = new EulangParser.toplevelvalue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS72=null;
        Token PLUS75=null;
        EulangParser.xscope_return xscope70 = null;

        EulangParser.namespaceRef_return namespaceRef71 = null;

        EulangParser.data_return data73 = null;

        EulangParser.namespaceRef_return namespaceRef74 = null;

        EulangParser.xscope_return xscope76 = null;

        EulangParser.selector_return selector77 = null;

        EulangParser.rhsExpr_return rhsExpr78 = null;

        EulangParser.data_return data79 = null;

        EulangParser.macro_return macro80 = null;


        CommonTree PLUS72_tree=null;
        CommonTree PLUS75_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleSubtreeStream stream_xscope=new RewriteRuleSubtreeStream(adaptor,"rule xscope");
        RewriteRuleSubtreeStream stream_data=new RewriteRuleSubtreeStream(adaptor,"rule data");
        RewriteRuleSubtreeStream stream_namespaceRef=new RewriteRuleSubtreeStream(adaptor,"rule namespaceRef");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:178:15: ( ( LBRACE )=> xscope | namespaceRef PLUS data -> ^( ADDSCOPE namespaceRef data ) | namespaceRef PLUS xscope -> ^( ADDSCOPE namespaceRef xscope ) | selector | rhsExpr | data | macro )
            int alt22=7;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:178:17: ( LBRACE )=> xscope
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_xscope_in_toplevelvalue1239);
                    xscope70=xscope();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, xscope70.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:179:7: namespaceRef PLUS data
                    {
                    pushFollow(FOLLOW_namespaceRef_in_toplevelvalue1247);
                    namespaceRef71=namespaceRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namespaceRef.add(namespaceRef71.getTree());
                    PLUS72=(Token)match(input,PLUS,FOLLOW_PLUS_in_toplevelvalue1249); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS72);

                    pushFollow(FOLLOW_data_in_toplevelvalue1251);
                    data73=data();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_data.add(data73.getTree());


                    // AST REWRITE
                    // elements: namespaceRef, data
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 179:30: -> ^( ADDSCOPE namespaceRef data )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:179:33: ^( ADDSCOPE namespaceRef data )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ADDSCOPE, "ADDSCOPE"), root_1);

                        adaptor.addChild(root_1, stream_namespaceRef.nextTree());
                        adaptor.addChild(root_1, stream_data.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:180:7: namespaceRef PLUS xscope
                    {
                    pushFollow(FOLLOW_namespaceRef_in_toplevelvalue1269);
                    namespaceRef74=namespaceRef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_namespaceRef.add(namespaceRef74.getTree());
                    PLUS75=(Token)match(input,PLUS,FOLLOW_PLUS_in_toplevelvalue1271); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS75);

                    pushFollow(FOLLOW_xscope_in_toplevelvalue1273);
                    xscope76=xscope();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_xscope.add(xscope76.getTree());


                    // AST REWRITE
                    // elements: namespaceRef, xscope
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 180:32: -> ^( ADDSCOPE namespaceRef xscope )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:180:35: ^( ADDSCOPE namespaceRef xscope )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ADDSCOPE, "ADDSCOPE"), root_1);

                        adaptor.addChild(root_1, stream_namespaceRef.nextTree());
                        adaptor.addChild(root_1, stream_xscope.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:181:7: selector
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_selector_in_toplevelvalue1291);
                    selector77=selector();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, selector77.getTree());

                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:182:7: rhsExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rhsExpr_in_toplevelvalue1299);
                    rhsExpr78=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rhsExpr78.getTree());

                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:183:7: data
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_data_in_toplevelvalue1307);
                    data79=data();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, data79.getTree());

                    }
                    break;
                case 7 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:184:7: macro
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_macro_in_toplevelvalue1315);
                    macro80=macro();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macro80.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "toplevelvalue"

    public static class selector_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selector"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:189:1: selector : LBRACKET selectors RBRACKET -> ^( LIST ( selectors )* ) ;
    public final EulangParser.selector_return selector() throws RecognitionException {
        EulangParser.selector_return retval = new EulangParser.selector_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET81=null;
        Token RBRACKET83=null;
        EulangParser.selectors_return selectors82 = null;


        CommonTree LBRACKET81_tree=null;
        CommonTree RBRACKET83_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_selectors=new RewriteRuleSubtreeStream(adaptor,"rule selectors");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:189:9: ( LBRACKET selectors RBRACKET -> ^( LIST ( selectors )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:189:11: LBRACKET selectors RBRACKET
            {
            LBRACKET81=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_selector1334); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET81);

            pushFollow(FOLLOW_selectors_in_selector1336);
            selectors82=selectors();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_selectors.add(selectors82.getTree());
            RBRACKET83=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_selector1338); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET83);



            // AST REWRITE
            // elements: selectors
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 189:42: -> ^( LIST ( selectors )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:189:45: ^( LIST ( selectors )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:189:52: ( selectors )*
                while ( stream_selectors.hasNext() ) {
                    adaptor.addChild(root_1, stream_selectors.nextTree());

                }
                stream_selectors.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "selector"

    public static class selectors_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectors"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:1: selectors : ( selectoritem ( COMMA selectoritem )* ( COMMA )? )? -> ( selectoritem )* ;
    public final EulangParser.selectors_return selectors() throws RecognitionException {
        EulangParser.selectors_return retval = new EulangParser.selectors_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA85=null;
        Token COMMA87=null;
        EulangParser.selectoritem_return selectoritem84 = null;

        EulangParser.selectoritem_return selectoritem86 = null;


        CommonTree COMMA85_tree=null;
        CommonTree COMMA87_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_selectoritem=new RewriteRuleSubtreeStream(adaptor,"rule selectoritem");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:10: ( ( selectoritem ( COMMA selectoritem )* ( COMMA )? )? -> ( selectoritem )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:12: ( selectoritem ( COMMA selectoritem )* ( COMMA )? )?
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:12: ( selectoritem ( COMMA selectoritem )* ( COMMA )? )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==CODE||LA25_0==MACRO||(LA25_0>=SIZEOF && LA25_0<=TYPEOF)||LA25_0==ID||LA25_0==COLON||LA25_0==LPAREN||LA25_0==NIL||LA25_0==IF||LA25_0==NOT||(LA25_0>=TILDE && LA25_0<=AMP)||LA25_0==MINUS||(LA25_0>=PLUSPLUS && LA25_0<=STRING_LITERAL)||(LA25_0>=FALSE && LA25_0<=COLONS)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:13: selectoritem ( COMMA selectoritem )* ( COMMA )?
                    {
                    pushFollow(FOLLOW_selectoritem_in_selectors1364);
                    selectoritem84=selectoritem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_selectoritem.add(selectoritem84.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:26: ( COMMA selectoritem )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==COMMA) ) {
                            int LA23_1 = input.LA(2);

                            if ( (LA23_1==CODE||LA23_1==MACRO||(LA23_1>=SIZEOF && LA23_1<=TYPEOF)||LA23_1==ID||LA23_1==COLON||LA23_1==LPAREN||LA23_1==NIL||LA23_1==IF||LA23_1==NOT||(LA23_1>=TILDE && LA23_1<=AMP)||LA23_1==MINUS||(LA23_1>=PLUSPLUS && LA23_1<=STRING_LITERAL)||(LA23_1>=FALSE && LA23_1<=COLONS)) ) {
                                alt23=1;
                            }


                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:28: COMMA selectoritem
                    	    {
                    	    COMMA85=(Token)match(input,COMMA,FOLLOW_COMMA_in_selectors1368); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA85);

                    	    pushFollow(FOLLOW_selectoritem_in_selectors1370);
                    	    selectoritem86=selectoritem();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_selectoritem.add(selectoritem86.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:50: ( COMMA )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==COMMA) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:50: COMMA
                            {
                            COMMA87=(Token)match(input,COMMA,FOLLOW_COMMA_in_selectors1375); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA87);


                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: selectoritem
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 192:62: -> ( selectoritem )*
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:192:65: ( selectoritem )*
                while ( stream_selectoritem.hasNext() ) {
                    adaptor.addChild(root_0, stream_selectoritem.nextTree());

                }
                stream_selectoritem.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "selectors"

    public static class selectoritem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "selectoritem"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:195:1: selectoritem : ( macro | rhsExpr );
    public final EulangParser.selectoritem_return selectoritem() throws RecognitionException {
        EulangParser.selectoritem_return retval = new EulangParser.selectoritem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.macro_return macro88 = null;

        EulangParser.rhsExpr_return rhsExpr89 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:195:14: ( macro | rhsExpr )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==MACRO) ) {
                alt26=1;
            }
            else if ( (LA26_0==CODE||(LA26_0>=SIZEOF && LA26_0<=TYPEOF)||LA26_0==ID||LA26_0==COLON||LA26_0==LPAREN||LA26_0==NIL||LA26_0==IF||LA26_0==NOT||(LA26_0>=TILDE && LA26_0<=AMP)||LA26_0==MINUS||(LA26_0>=PLUSPLUS && LA26_0<=STRING_LITERAL)||(LA26_0>=FALSE && LA26_0<=COLONS)) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:195:17: macro
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_macro_in_selectoritem1406);
                    macro88=macro();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macro88.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:195:25: rhsExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rhsExpr_in_selectoritem1410);
                    rhsExpr89=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rhsExpr89.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "selectoritem"

    public static class xscope_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xscope"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:199:1: xscope : LBRACE toplevelstmts RBRACE -> ^( SCOPE ( toplevelstmts )* ) ;
    public final EulangParser.xscope_return xscope() throws RecognitionException {
        EulangParser.xscope_return retval = new EulangParser.xscope_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE90=null;
        Token RBRACE92=null;
        EulangParser.toplevelstmts_return toplevelstmts91 = null;


        CommonTree LBRACE90_tree=null;
        CommonTree RBRACE92_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_toplevelstmts=new RewriteRuleSubtreeStream(adaptor,"rule toplevelstmts");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:199:8: ( LBRACE toplevelstmts RBRACE -> ^( SCOPE ( toplevelstmts )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:199:10: LBRACE toplevelstmts RBRACE
            {
            LBRACE90=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_xscope1421); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE90);

            pushFollow(FOLLOW_toplevelstmts_in_xscope1423);
            toplevelstmts91=toplevelstmts();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_toplevelstmts.add(toplevelstmts91.getTree());
            RBRACE92=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_xscope1425); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE92);



            // AST REWRITE
            // elements: toplevelstmts
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 199:41: -> ^( SCOPE ( toplevelstmts )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:199:44: ^( SCOPE ( toplevelstmts )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SCOPE, "SCOPE"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:199:52: ( toplevelstmts )*
                while ( stream_toplevelstmts.hasNext() ) {
                    adaptor.addChild(root_1, stream_toplevelstmts.nextTree());

                }
                stream_toplevelstmts.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "xscope"

    public static class xscopeNoAlloc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xscopeNoAlloc"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:201:1: xscopeNoAlloc : LBRACE toplevelstmtsNoAlloc RBRACE -> ^( SCOPE ( toplevelstmtsNoAlloc )* ) ;
    public final EulangParser.xscopeNoAlloc_return xscopeNoAlloc() throws RecognitionException {
        EulangParser.xscopeNoAlloc_return retval = new EulangParser.xscopeNoAlloc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE93=null;
        Token RBRACE95=null;
        EulangParser.toplevelstmtsNoAlloc_return toplevelstmtsNoAlloc94 = null;


        CommonTree LBRACE93_tree=null;
        CommonTree RBRACE95_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_toplevelstmtsNoAlloc=new RewriteRuleSubtreeStream(adaptor,"rule toplevelstmtsNoAlloc");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:201:15: ( LBRACE toplevelstmtsNoAlloc RBRACE -> ^( SCOPE ( toplevelstmtsNoAlloc )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:201:17: LBRACE toplevelstmtsNoAlloc RBRACE
            {
            LBRACE93=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_xscopeNoAlloc1450); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE93);

            pushFollow(FOLLOW_toplevelstmtsNoAlloc_in_xscopeNoAlloc1452);
            toplevelstmtsNoAlloc94=toplevelstmtsNoAlloc();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_toplevelstmtsNoAlloc.add(toplevelstmtsNoAlloc94.getTree());
            RBRACE95=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_xscopeNoAlloc1454); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE95);



            // AST REWRITE
            // elements: toplevelstmtsNoAlloc
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 201:55: -> ^( SCOPE ( toplevelstmtsNoAlloc )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:201:58: ^( SCOPE ( toplevelstmtsNoAlloc )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SCOPE, "SCOPE"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:201:66: ( toplevelstmtsNoAlloc )*
                while ( stream_toplevelstmtsNoAlloc.hasNext() ) {
                    adaptor.addChild(root_1, stream_toplevelstmtsNoAlloc.nextTree());

                }
                stream_toplevelstmtsNoAlloc.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "xscopeNoAlloc"

    public static class listCompr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listCompr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:206:1: listCompr : ( forIn )+ COLON listiterable -> ^( LIST_COMPREHENSION ( forIn )+ listiterable ) ;
    public final EulangParser.listCompr_return listCompr() throws RecognitionException {
        EulangParser.listCompr_return retval = new EulangParser.listCompr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON97=null;
        EulangParser.forIn_return forIn96 = null;

        EulangParser.listiterable_return listiterable98 = null;


        CommonTree COLON97_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_forIn=new RewriteRuleSubtreeStream(adaptor,"rule forIn");
        RewriteRuleSubtreeStream stream_listiterable=new RewriteRuleSubtreeStream(adaptor,"rule listiterable");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:206:10: ( ( forIn )+ COLON listiterable -> ^( LIST_COMPREHENSION ( forIn )+ listiterable ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:206:12: ( forIn )+ COLON listiterable
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:206:12: ( forIn )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==FOR) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:206:12: forIn
            	    {
            	    pushFollow(FOLLOW_forIn_in_listCompr1481);
            	    forIn96=forIn();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_forIn.add(forIn96.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            COLON97=(Token)match(input,COLON,FOLLOW_COLON_in_listCompr1484); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON97);

            pushFollow(FOLLOW_listiterable_in_listCompr1486);
            listiterable98=listiterable();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_listiterable.add(listiterable98.getTree());


            // AST REWRITE
            // elements: listiterable, forIn
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 206:42: -> ^( LIST_COMPREHENSION ( forIn )+ listiterable )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:206:45: ^( LIST_COMPREHENSION ( forIn )+ listiterable )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST_COMPREHENSION, "LIST_COMPREHENSION"), root_1);

                if ( !(stream_forIn.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_forIn.hasNext() ) {
                    adaptor.addChild(root_1, stream_forIn.nextTree());

                }
                stream_forIn.reset();
                adaptor.addChild(root_1, stream_listiterable.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "listCompr"

    public static class forIn_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forIn"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:209:1: forIn : FOR idlist IN list -> ^( FOR idlist list ) ;
    public final EulangParser.forIn_return forIn() throws RecognitionException {
        EulangParser.forIn_return retval = new EulangParser.forIn_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FOR99=null;
        Token IN101=null;
        EulangParser.idlist_return idlist100 = null;

        EulangParser.list_return list102 = null;


        CommonTree FOR99_tree=null;
        CommonTree IN101_tree=null;
        RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleSubtreeStream stream_list=new RewriteRuleSubtreeStream(adaptor,"rule list");
        RewriteRuleSubtreeStream stream_idlist=new RewriteRuleSubtreeStream(adaptor,"rule idlist");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:209:7: ( FOR idlist IN list -> ^( FOR idlist list ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:209:9: FOR idlist IN list
            {
            FOR99=(Token)match(input,FOR,FOLLOW_FOR_in_forIn1518); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FOR.add(FOR99);

            pushFollow(FOLLOW_idlist_in_forIn1520);
            idlist100=idlist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_idlist.add(idlist100.getTree());
            IN101=(Token)match(input,IN,FOLLOW_IN_in_forIn1522); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IN.add(IN101);

            pushFollow(FOLLOW_list_in_forIn1524);
            list102=list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_list.add(list102.getTree());


            // AST REWRITE
            // elements: idlist, FOR, list
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 209:33: -> ^( FOR idlist list )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:209:36: ^( FOR idlist list )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR.nextNode(), root_1);

                adaptor.addChild(root_1, stream_idlist.nextTree());
                adaptor.addChild(root_1, stream_list.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "forIn"

    public static class idlist_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idlist"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:211:1: idlist : ID ( COMMA ID )* -> ^( IDLIST ( ID )+ ) ;
    public final EulangParser.idlist_return idlist() throws RecognitionException {
        EulangParser.idlist_return retval = new EulangParser.idlist_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID103=null;
        Token COMMA104=null;
        Token ID105=null;

        CommonTree ID103_tree=null;
        CommonTree COMMA104_tree=null;
        CommonTree ID105_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:211:8: ( ID ( COMMA ID )* -> ^( IDLIST ( ID )+ ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:211:10: ID ( COMMA ID )*
            {
            ID103=(Token)match(input,ID,FOLLOW_ID_in_idlist1549); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID103);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:211:13: ( COMMA ID )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==COMMA) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:211:14: COMMA ID
            	    {
            	    COMMA104=(Token)match(input,COMMA,FOLLOW_COMMA_in_idlist1552); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA104);

            	    ID105=(Token)match(input,ID,FOLLOW_ID_in_idlist1554); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID105);


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);



            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 211:28: -> ^( IDLIST ( ID )+ )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:211:31: ^( IDLIST ( ID )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IDLIST, "IDLIST"), root_1);

                if ( !(stream_ID.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ID.hasNext() ) {
                    adaptor.addChild(root_1, stream_ID.nextNode());

                }
                stream_ID.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "idlist"

    public static class idlistOrEmpty_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idlistOrEmpty"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:213:1: idlistOrEmpty : ( idlist -> idlist | -> ^( IDLIST ) );
    public final EulangParser.idlistOrEmpty_return idlistOrEmpty() throws RecognitionException {
        EulangParser.idlistOrEmpty_return retval = new EulangParser.idlistOrEmpty_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.idlist_return idlist106 = null;


        RewriteRuleSubtreeStream stream_idlist=new RewriteRuleSubtreeStream(adaptor,"rule idlist");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:213:15: ( idlist -> idlist | -> ^( IDLIST ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==ID) ) {
                alt29=1;
            }
            else if ( (LA29_0==RBRACKET) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:213:17: idlist
                    {
                    pushFollow(FOLLOW_idlist_in_idlistOrEmpty1580);
                    idlist106=idlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_idlist.add(idlist106.getTree());


                    // AST REWRITE
                    // elements: idlist
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 213:24: -> idlist
                    {
                        adaptor.addChild(root_0, stream_idlist.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:213:36: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 213:36: -> ^( IDLIST )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:213:39: ^( IDLIST )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IDLIST, "IDLIST"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "idlistOrEmpty"

    public static class listiterable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listiterable"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:215:1: listiterable : ( code | macro ) ;
    public final EulangParser.listiterable_return listiterable() throws RecognitionException {
        EulangParser.listiterable_return retval = new EulangParser.listiterable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.code_return code107 = null;

        EulangParser.macro_return macro108 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:215:14: ( ( code | macro ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:215:16: ( code | macro )
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:215:16: ( code | macro )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==CODE) ) {
                alt30=1;
            }
            else if ( (LA30_0==MACRO) ) {
                alt30=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:215:18: code
                    {
                    pushFollow(FOLLOW_code_in_listiterable1603);
                    code107=code();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, code107.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:215:25: macro
                    {
                    pushFollow(FOLLOW_macro_in_listiterable1607);
                    macro108=macro();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macro108.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "listiterable"

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:217:1: list : LBRACKET listitems RBRACKET -> ^( LIST ( listitems )* ) ;
    public final EulangParser.list_return list() throws RecognitionException {
        EulangParser.list_return retval = new EulangParser.list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET109=null;
        Token RBRACKET111=null;
        EulangParser.listitems_return listitems110 = null;


        CommonTree LBRACKET109_tree=null;
        CommonTree RBRACKET111_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_listitems=new RewriteRuleSubtreeStream(adaptor,"rule listitems");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:217:6: ( LBRACKET listitems RBRACKET -> ^( LIST ( listitems )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:217:8: LBRACKET listitems RBRACKET
            {
            LBRACKET109=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_list1622); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET109);

            pushFollow(FOLLOW_listitems_in_list1624);
            listitems110=listitems();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_listitems.add(listitems110.getTree());
            RBRACKET111=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_list1626); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET111);



            // AST REWRITE
            // elements: listitems
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 217:40: -> ^( LIST ( listitems )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:217:43: ^( LIST ( listitems )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:217:50: ( listitems )*
                while ( stream_listitems.hasNext() ) {
                    adaptor.addChild(root_1, stream_listitems.nextTree());

                }
                stream_listitems.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "list"

    public static class listitems_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listitems"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:1: listitems : ( listitem ( COMMA listitem )* ( COMMA )? )? ;
    public final EulangParser.listitems_return listitems() throws RecognitionException {
        EulangParser.listitems_return retval = new EulangParser.listitems_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA113=null;
        Token COMMA115=null;
        EulangParser.listitem_return listitem112 = null;

        EulangParser.listitem_return listitem114 = null;


        CommonTree COMMA113_tree=null;
        CommonTree COMMA115_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:10: ( ( listitem ( COMMA listitem )* ( COMMA )? )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:12: ( listitem ( COMMA listitem )* ( COMMA )? )?
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:12: ( listitem ( COMMA listitem )* ( COMMA )? )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==CODE||LA33_0==MACRO||(LA33_0>=SIZEOF && LA33_0<=TYPEOF)||LA33_0==ID||LA33_0==COLON||LA33_0==LBRACKET||LA33_0==LBRACE||LA33_0==LPAREN||LA33_0==NIL||LA33_0==IF||LA33_0==NOT||(LA33_0>=TILDE && LA33_0<=AMP)||LA33_0==MINUS||(LA33_0>=PLUSPLUS && LA33_0<=STRING_LITERAL)||(LA33_0>=FALSE && LA33_0<=DATA)) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:13: listitem ( COMMA listitem )* ( COMMA )?
                    {
                    pushFollow(FOLLOW_listitem_in_listitems1656);
                    listitem112=listitem();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, listitem112.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:22: ( COMMA listitem )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==COMMA) ) {
                            int LA31_1 = input.LA(2);

                            if ( (LA31_1==CODE||LA31_1==MACRO||(LA31_1>=SIZEOF && LA31_1<=TYPEOF)||LA31_1==ID||LA31_1==COLON||LA31_1==LBRACKET||LA31_1==LBRACE||LA31_1==LPAREN||LA31_1==NIL||LA31_1==IF||LA31_1==NOT||(LA31_1>=TILDE && LA31_1<=AMP)||LA31_1==MINUS||(LA31_1>=PLUSPLUS && LA31_1<=STRING_LITERAL)||(LA31_1>=FALSE && LA31_1<=DATA)) ) {
                                alt31=1;
                            }


                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:24: COMMA listitem
                    	    {
                    	    COMMA113=(Token)match(input,COMMA,FOLLOW_COMMA_in_listitems1660); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA113_tree = (CommonTree)adaptor.create(COMMA113);
                    	    adaptor.addChild(root_0, COMMA113_tree);
                    	    }
                    	    pushFollow(FOLLOW_listitem_in_listitems1662);
                    	    listitem114=listitem();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, listitem114.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:42: ( COMMA )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==COMMA) ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:220:42: COMMA
                            {
                            COMMA115=(Token)match(input,COMMA,FOLLOW_COMMA_in_listitems1667); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA115_tree = (CommonTree)adaptor.create(COMMA115);
                            adaptor.addChild(root_0, COMMA115_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "listitems"

    public static class listitem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listitem"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:223:1: listitem : toplevelvalue ;
    public final EulangParser.listitem_return listitem() throws RecognitionException {
        EulangParser.listitem_return retval = new EulangParser.listitem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.toplevelvalue_return toplevelvalue116 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:223:10: ( toplevelvalue )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:223:12: toplevelvalue
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_toplevelvalue_in_listitem1693);
            toplevelvalue116=toplevelvalue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, toplevelvalue116.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "listitem"

    public static class code_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "code"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:1: code : CODE ( proto )? LBRACE codestmtlist RBRACE -> ^( CODE ( proto )? ( codestmtlist )* ) ;
    public final EulangParser.code_return code() throws RecognitionException {
        EulangParser.code_return retval = new EulangParser.code_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CODE117=null;
        Token LBRACE119=null;
        Token RBRACE121=null;
        EulangParser.proto_return proto118 = null;

        EulangParser.codestmtlist_return codestmtlist120 = null;


        CommonTree CODE117_tree=null;
        CommonTree LBRACE119_tree=null;
        CommonTree RBRACE121_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_CODE=new RewriteRuleTokenStream(adaptor,"token CODE");
        RewriteRuleSubtreeStream stream_codestmtlist=new RewriteRuleSubtreeStream(adaptor,"rule codestmtlist");
        RewriteRuleSubtreeStream stream_proto=new RewriteRuleSubtreeStream(adaptor,"rule proto");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:6: ( CODE ( proto )? LBRACE codestmtlist RBRACE -> ^( CODE ( proto )? ( codestmtlist )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:8: CODE ( proto )? LBRACE codestmtlist RBRACE
            {
            CODE117=(Token)match(input,CODE,FOLLOW_CODE_in_code1711); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CODE.add(CODE117);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:13: ( proto )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==LPAREN) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:13: proto
                    {
                    pushFollow(FOLLOW_proto_in_code1713);
                    proto118=proto();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_proto.add(proto118.getTree());

                    }
                    break;

            }

            LBRACE119=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_code1716); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE119);

            pushFollow(FOLLOW_codestmtlist_in_code1718);
            codestmtlist120=codestmtlist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_codestmtlist.add(codestmtlist120.getTree());
            RBRACE121=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_code1720); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE121);



            // AST REWRITE
            // elements: proto, codestmtlist, CODE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 228:47: -> ^( CODE ( proto )? ( codestmtlist )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:50: ^( CODE ( proto )? ( codestmtlist )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_CODE.nextNode(), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:57: ( proto )?
                if ( stream_proto.hasNext() ) {
                    adaptor.addChild(root_1, stream_proto.nextTree());

                }
                stream_proto.reset();
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:228:64: ( codestmtlist )*
                while ( stream_codestmtlist.hasNext() ) {
                    adaptor.addChild(root_1, stream_codestmtlist.nextTree());

                }
                stream_codestmtlist.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "code"

    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macro"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:1: macro : MACRO ( proto )? LBRACE codestmtlist RBRACE -> ^( MACRO ( proto )? ( codestmtlist )* ) ;
    public final EulangParser.macro_return macro() throws RecognitionException {
        EulangParser.macro_return retval = new EulangParser.macro_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MACRO122=null;
        Token LBRACE124=null;
        Token RBRACE126=null;
        EulangParser.proto_return proto123 = null;

        EulangParser.codestmtlist_return codestmtlist125 = null;


        CommonTree MACRO122_tree=null;
        CommonTree LBRACE124_tree=null;
        CommonTree RBRACE126_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_MACRO=new RewriteRuleTokenStream(adaptor,"token MACRO");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_codestmtlist=new RewriteRuleSubtreeStream(adaptor,"rule codestmtlist");
        RewriteRuleSubtreeStream stream_proto=new RewriteRuleSubtreeStream(adaptor,"rule proto");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:7: ( MACRO ( proto )? LBRACE codestmtlist RBRACE -> ^( MACRO ( proto )? ( codestmtlist )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:9: MACRO ( proto )? LBRACE codestmtlist RBRACE
            {
            MACRO122=(Token)match(input,MACRO,FOLLOW_MACRO_in_macro1748); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_MACRO.add(MACRO122);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:15: ( proto )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==LPAREN) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:15: proto
                    {
                    pushFollow(FOLLOW_proto_in_macro1750);
                    proto123=proto();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_proto.add(proto123.getTree());

                    }
                    break;

            }

            LBRACE124=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_macro1754); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE124);

            pushFollow(FOLLOW_codestmtlist_in_macro1756);
            codestmtlist125=codestmtlist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_codestmtlist.add(codestmtlist125.getTree());
            RBRACE126=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_macro1758); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE126);



            // AST REWRITE
            // elements: MACRO, proto, codestmtlist
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 232:50: -> ^( MACRO ( proto )? ( codestmtlist )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:53: ^( MACRO ( proto )? ( codestmtlist )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_MACRO.nextNode(), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:61: ( proto )?
                if ( stream_proto.hasNext() ) {
                    adaptor.addChild(root_1, stream_proto.nextTree());

                }
                stream_proto.reset();
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:232:68: ( codestmtlist )*
                while ( stream_codestmtlist.hasNext() ) {
                    adaptor.addChild(root_1, stream_codestmtlist.nextTree());

                }
                stream_codestmtlist.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "macro"

    public static class argdefs_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argdefs"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:237:1: argdefs options {backtrack=true; } : ( | argdefsWithTypes | argdefWithType | argdefsWithNames );
    public final EulangParser.argdefs_return argdefs() throws RecognitionException {
        EulangParser.argdefs_return retval = new EulangParser.argdefs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.argdefsWithTypes_return argdefsWithTypes127 = null;

        EulangParser.argdefWithType_return argdefWithType128 = null;

        EulangParser.argdefsWithNames_return argdefsWithNames129 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:237:40: ( | argdefsWithTypes | argdefWithType | argdefsWithNames )
            int alt36=4;
            switch ( input.LA(1) ) {
            case RPAREN:
            case ARROW:
                {
                alt36=1;
                }
                break;
            case ATSIGN:
                {
                int LA36_3 = input.LA(2);

                if ( (synpred7_Eulang()) ) {
                    alt36=2;
                }
                else if ( (synpred8_Eulang()) ) {
                    alt36=3;
                }
                else if ( (true) ) {
                    alt36=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 3, input);

                    throw nvae;
                }
                }
                break;
            case ID:
                {
                int LA36_4 = input.LA(2);

                if ( (synpred7_Eulang()) ) {
                    alt36=2;
                }
                else if ( (synpred8_Eulang()) ) {
                    alt36=3;
                }
                else if ( (true) ) {
                    alt36=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 4, input);

                    throw nvae;
                }
                }
                break;
            case MACRO:
                {
                int LA36_5 = input.LA(2);

                if ( (synpred7_Eulang()) ) {
                    alt36=2;
                }
                else if ( (synpred8_Eulang()) ) {
                    alt36=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:238:3: 
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:238:5: argdefsWithTypes
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_argdefsWithTypes_in_argdefs1803);
                    argdefsWithTypes127=argdefsWithTypes();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argdefsWithTypes127.getTree());

                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:239:5: argdefWithType
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_argdefWithType_in_argdefs1810);
                    argdefWithType128=argdefWithType();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argdefWithType128.getTree());

                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:240:6: argdefsWithNames
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_argdefsWithNames_in_argdefs1817);
                    argdefsWithNames129=argdefsWithNames();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argdefsWithNames129.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "argdefs"

    public static class argdefsWithTypes_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argdefsWithTypes"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:1: argdefsWithTypes : ( argdefWithType ( SEMI argdefWithType )+ ( SEMI )? ) -> ( argdefWithType )* ;
    public final EulangParser.argdefsWithTypes_return argdefsWithTypes() throws RecognitionException {
        EulangParser.argdefsWithTypes_return retval = new EulangParser.argdefsWithTypes_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMI131=null;
        Token SEMI133=null;
        EulangParser.argdefWithType_return argdefWithType130 = null;

        EulangParser.argdefWithType_return argdefWithType132 = null;


        CommonTree SEMI131_tree=null;
        CommonTree SEMI133_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_argdefWithType=new RewriteRuleSubtreeStream(adaptor,"rule argdefWithType");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:17: ( ( argdefWithType ( SEMI argdefWithType )+ ( SEMI )? ) -> ( argdefWithType )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:19: ( argdefWithType ( SEMI argdefWithType )+ ( SEMI )? )
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:19: ( argdefWithType ( SEMI argdefWithType )+ ( SEMI )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:20: argdefWithType ( SEMI argdefWithType )+ ( SEMI )?
            {
            pushFollow(FOLLOW_argdefWithType_in_argdefsWithTypes1833);
            argdefWithType130=argdefWithType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_argdefWithType.add(argdefWithType130.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:35: ( SEMI argdefWithType )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==SEMI) ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1==MACRO||LA37_1==ID||LA37_1==ATSIGN) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:37: SEMI argdefWithType
            	    {
            	    SEMI131=(Token)match(input,SEMI,FOLLOW_SEMI_in_argdefsWithTypes1837); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_SEMI.add(SEMI131);

            	    pushFollow(FOLLOW_argdefWithType_in_argdefsWithTypes1839);
            	    argdefWithType132=argdefWithType();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_argdefWithType.add(argdefWithType132.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:59: ( SEMI )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==SEMI) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:59: SEMI
                    {
                    SEMI133=(Token)match(input,SEMI,FOLLOW_SEMI_in_argdefsWithTypes1843); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI133);


                    }
                    break;

            }


            }



            // AST REWRITE
            // elements: argdefWithType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 243:73: -> ( argdefWithType )*
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:243:76: ( argdefWithType )*
                while ( stream_argdefWithType.hasNext() ) {
                    adaptor.addChild(root_0, stream_argdefWithType.nextTree());

                }
                stream_argdefWithType.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "argdefsWithTypes"

    public static class argdefWithType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argdefWithType"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:1: argdefWithType : ( ( ATSIGN )? ID ( COMMA ID )* ( COLON type )? -> ( ^( ARGDEF ( ATSIGN )? ID ( type )* ) )+ | MACRO ID ( COMMA ID )* ( COLON type )? ( EQUALS init= rhsExpr )? -> ( ^( ARGDEF MACRO ID ( type )* ( $init)? ) )+ );
    public final EulangParser.argdefWithType_return argdefWithType() throws RecognitionException {
        EulangParser.argdefWithType_return retval = new EulangParser.argdefWithType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ATSIGN134=null;
        Token ID135=null;
        Token COMMA136=null;
        Token ID137=null;
        Token COLON138=null;
        Token MACRO140=null;
        Token ID141=null;
        Token COMMA142=null;
        Token ID143=null;
        Token COLON144=null;
        Token EQUALS146=null;
        EulangParser.rhsExpr_return init = null;

        EulangParser.type_return type139 = null;

        EulangParser.type_return type145 = null;


        CommonTree ATSIGN134_tree=null;
        CommonTree ID135_tree=null;
        CommonTree COMMA136_tree=null;
        CommonTree ID137_tree=null;
        CommonTree COLON138_tree=null;
        CommonTree MACRO140_tree=null;
        CommonTree ID141_tree=null;
        CommonTree COMMA142_tree=null;
        CommonTree ID143_tree=null;
        CommonTree COLON144_tree=null;
        CommonTree EQUALS146_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_MACRO=new RewriteRuleTokenStream(adaptor,"token MACRO");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:15: ( ( ATSIGN )? ID ( COMMA ID )* ( COLON type )? -> ( ^( ARGDEF ( ATSIGN )? ID ( type )* ) )+ | MACRO ID ( COMMA ID )* ( COLON type )? ( EQUALS init= rhsExpr )? -> ( ^( ARGDEF MACRO ID ( type )* ( $init)? ) )+ )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==ID||LA45_0==ATSIGN) ) {
                alt45=1;
            }
            else if ( (LA45_0==MACRO) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:18: ( ATSIGN )? ID ( COMMA ID )* ( COLON type )?
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:18: ( ATSIGN )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==ATSIGN) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:18: ATSIGN
                            {
                            ATSIGN134=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_argdefWithType1872); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN134);


                            }
                            break;

                    }

                    ID135=(Token)match(input,ID,FOLLOW_ID_in_argdefWithType1875); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID135);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:29: ( COMMA ID )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==COMMA) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:30: COMMA ID
                    	    {
                    	    COMMA136=(Token)match(input,COMMA,FOLLOW_COMMA_in_argdefWithType1878); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA136);

                    	    ID137=(Token)match(input,ID,FOLLOW_ID_in_argdefWithType1880); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID137);


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:41: ( COLON type )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==COLON) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:42: COLON type
                            {
                            COLON138=(Token)match(input,COLON,FOLLOW_COLON_in_argdefWithType1885); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON138);

                            pushFollow(FOLLOW_type_in_argdefWithType1887);
                            type139=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_type.add(type139.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: type, ID, ATSIGN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 247:57: -> ( ^( ARGDEF ( ATSIGN )? ID ( type )* ) )+
                    {
                        if ( !(stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext() ) {
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:60: ^( ARGDEF ( ATSIGN )? ID ( type )* )
                            {
                            CommonTree root_1 = (CommonTree)adaptor.nil();
                            root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGDEF, "ARGDEF"), root_1);

                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:69: ( ATSIGN )?
                            if ( stream_ATSIGN.hasNext() ) {
                                adaptor.addChild(root_1, stream_ATSIGN.nextNode());

                            }
                            stream_ATSIGN.reset();
                            adaptor.addChild(root_1, stream_ID.nextNode());
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:247:80: ( type )*
                            while ( stream_type.hasNext() ) {
                                adaptor.addChild(root_1, stream_type.nextTree());

                            }
                            stream_type.reset();

                            adaptor.addChild(root_0, root_1);
                            }

                        }
                        stream_ID.reset();

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:7: MACRO ID ( COMMA ID )* ( COLON type )? ( EQUALS init= rhsExpr )?
                    {
                    MACRO140=(Token)match(input,MACRO,FOLLOW_MACRO_in_argdefWithType1915); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MACRO.add(MACRO140);

                    ID141=(Token)match(input,ID,FOLLOW_ID_in_argdefWithType1917); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID141);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:16: ( COMMA ID )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==COMMA) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:17: COMMA ID
                    	    {
                    	    COMMA142=(Token)match(input,COMMA,FOLLOW_COMMA_in_argdefWithType1920); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA142);

                    	    ID143=(Token)match(input,ID,FOLLOW_ID_in_argdefWithType1922); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID143);


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:28: ( COLON type )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==COLON) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:29: COLON type
                            {
                            COLON144=(Token)match(input,COLON,FOLLOW_COLON_in_argdefWithType1927); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON144);

                            pushFollow(FOLLOW_type_in_argdefWithType1929);
                            type145=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_type.add(type145.getTree());

                            }
                            break;

                    }

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:42: ( EQUALS init= rhsExpr )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==EQUALS) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:43: EQUALS init= rhsExpr
                            {
                            EQUALS146=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_argdefWithType1934); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS146);

                            pushFollow(FOLLOW_rhsExpr_in_argdefWithType1938);
                            init=rhsExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_rhsExpr.add(init.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: MACRO, type, init, ID
                    // token labels: 
                    // rule labels: retval, init
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_init=new RewriteRuleSubtreeStream(adaptor,"rule init",init!=null?init.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 248:68: -> ( ^( ARGDEF MACRO ID ( type )* ( $init)? ) )+
                    {
                        if ( !(stream_MACRO.hasNext()||stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_MACRO.hasNext()||stream_ID.hasNext() ) {
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:71: ^( ARGDEF MACRO ID ( type )* ( $init)? )
                            {
                            CommonTree root_1 = (CommonTree)adaptor.nil();
                            root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGDEF, "ARGDEF"), root_1);

                            adaptor.addChild(root_1, stream_MACRO.nextNode());
                            adaptor.addChild(root_1, stream_ID.nextNode());
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:89: ( type )*
                            while ( stream_type.hasNext() ) {
                                adaptor.addChild(root_1, stream_type.nextTree());

                            }
                            stream_type.reset();
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:248:95: ( $init)?
                            if ( stream_init.hasNext() ) {
                                adaptor.addChild(root_1, stream_init.nextTree());

                            }
                            stream_init.reset();

                            adaptor.addChild(root_0, root_1);
                            }

                        }
                        stream_MACRO.reset();
                        stream_ID.reset();

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "argdefWithType"

    public static class argdefsWithNames_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argdefsWithNames"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:1: argdefsWithNames : ( argdefWithName ( COMMA argdefWithName )+ ( COMMA )? ) -> ( argdefWithName )* ;
    public final EulangParser.argdefsWithNames_return argdefsWithNames() throws RecognitionException {
        EulangParser.argdefsWithNames_return retval = new EulangParser.argdefsWithNames_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA148=null;
        Token COMMA150=null;
        EulangParser.argdefWithName_return argdefWithName147 = null;

        EulangParser.argdefWithName_return argdefWithName149 = null;


        CommonTree COMMA148_tree=null;
        CommonTree COMMA150_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_argdefWithName=new RewriteRuleSubtreeStream(adaptor,"rule argdefWithName");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:18: ( ( argdefWithName ( COMMA argdefWithName )+ ( COMMA )? ) -> ( argdefWithName )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:21: ( argdefWithName ( COMMA argdefWithName )+ ( COMMA )? )
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:21: ( argdefWithName ( COMMA argdefWithName )+ ( COMMA )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:22: argdefWithName ( COMMA argdefWithName )+ ( COMMA )?
            {
            pushFollow(FOLLOW_argdefWithName_in_argdefsWithNames1974);
            argdefWithName147=argdefWithName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_argdefWithName.add(argdefWithName147.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:37: ( COMMA argdefWithName )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==COMMA) ) {
                    int LA46_1 = input.LA(2);

                    if ( (LA46_1==ID||LA46_1==ATSIGN) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:39: COMMA argdefWithName
            	    {
            	    COMMA148=(Token)match(input,COMMA,FOLLOW_COMMA_in_argdefsWithNames1978); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA148);

            	    pushFollow(FOLLOW_argdefWithName_in_argdefsWithNames1980);
            	    argdefWithName149=argdefWithName();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_argdefWithName.add(argdefWithName149.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt46 >= 1 ) break loop46;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
            } while (true);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:62: ( COMMA )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==COMMA) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:62: COMMA
                    {
                    COMMA150=(Token)match(input,COMMA,FOLLOW_COMMA_in_argdefsWithNames1984); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMA.add(COMMA150);


                    }
                    break;

            }


            }



            // AST REWRITE
            // elements: argdefWithName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 251:73: -> ( argdefWithName )*
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:251:76: ( argdefWithName )*
                while ( stream_argdefWithName.hasNext() ) {
                    adaptor.addChild(root_0, stream_argdefWithName.nextTree());

                }
                stream_argdefWithName.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "argdefsWithNames"

    public static class argdefWithName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argdefWithName"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:253:1: argdefWithName : ( ATSIGN )? ID -> ^( ARGDEF ( ATSIGN )? ID ) ;
    public final EulangParser.argdefWithName_return argdefWithName() throws RecognitionException {
        EulangParser.argdefWithName_return retval = new EulangParser.argdefWithName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ATSIGN151=null;
        Token ID152=null;

        CommonTree ATSIGN151_tree=null;
        CommonTree ID152_tree=null;
        RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:253:15: ( ( ATSIGN )? ID -> ^( ARGDEF ( ATSIGN )? ID ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:253:17: ( ATSIGN )? ID
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:253:17: ( ATSIGN )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==ATSIGN) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:253:17: ATSIGN
                    {
                    ATSIGN151=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_argdefWithName2006); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN151);


                    }
                    break;

            }

            ID152=(Token)match(input,ID,FOLLOW_ID_in_argdefWithName2009); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID152);



            // AST REWRITE
            // elements: ATSIGN, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 253:30: -> ^( ARGDEF ( ATSIGN )? ID )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:253:33: ^( ARGDEF ( ATSIGN )? ID )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGDEF, "ARGDEF"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:253:42: ( ATSIGN )?
                if ( stream_ATSIGN.hasNext() ) {
                    adaptor.addChild(root_1, stream_ATSIGN.nextNode());

                }
                stream_ATSIGN.reset();
                adaptor.addChild(root_1, stream_ID.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "argdefWithName"

    public static class proto_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "proto"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:1: proto : LPAREN argdefs ( xreturns )? RPAREN -> ^( PROTO ( xreturns )? ( argdefs )* ) ;
    public final EulangParser.proto_return proto() throws RecognitionException {
        EulangParser.proto_return retval = new EulangParser.proto_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAREN153=null;
        Token RPAREN156=null;
        EulangParser.argdefs_return argdefs154 = null;

        EulangParser.xreturns_return xreturns155 = null;


        CommonTree LPAREN153_tree=null;
        CommonTree RPAREN156_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_argdefs=new RewriteRuleSubtreeStream(adaptor,"rule argdefs");
        RewriteRuleSubtreeStream stream_xreturns=new RewriteRuleSubtreeStream(adaptor,"rule xreturns");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:7: ( LPAREN argdefs ( xreturns )? RPAREN -> ^( PROTO ( xreturns )? ( argdefs )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:9: LPAREN argdefs ( xreturns )? RPAREN
            {
            LPAREN153=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_proto2035); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN153);

            pushFollow(FOLLOW_argdefs_in_proto2037);
            argdefs154=argdefs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_argdefs.add(argdefs154.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:24: ( xreturns )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==ARROW) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:24: xreturns
                    {
                    pushFollow(FOLLOW_xreturns_in_proto2039);
                    xreturns155=xreturns();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_xreturns.add(xreturns155.getTree());

                    }
                    break;

            }

            RPAREN156=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_proto2042); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN156);



            // AST REWRITE
            // elements: xreturns, argdefs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 257:59: -> ^( PROTO ( xreturns )? ( argdefs )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:62: ^( PROTO ( xreturns )? ( argdefs )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PROTO, "PROTO"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:70: ( xreturns )?
                if ( stream_xreturns.hasNext() ) {
                    adaptor.addChild(root_1, stream_xreturns.nextTree());

                }
                stream_xreturns.reset();
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:257:80: ( argdefs )*
                while ( stream_argdefs.hasNext() ) {
                    adaptor.addChild(root_1, stream_argdefs.nextTree());

                }
                stream_argdefs.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "proto"

    public static class xreturns_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xreturns"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:260:1: xreturns : ( ARROW type -> type | ARROW NIL -> ^( TYPE NIL ) );
    public final EulangParser.xreturns_return xreturns() throws RecognitionException {
        EulangParser.xreturns_return retval = new EulangParser.xreturns_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ARROW157=null;
        Token ARROW159=null;
        Token NIL160=null;
        EulangParser.type_return type158 = null;


        CommonTree ARROW157_tree=null;
        CommonTree ARROW159_tree=null;
        CommonTree NIL160_tree=null;
        RewriteRuleTokenStream stream_ARROW=new RewriteRuleTokenStream(adaptor,"token ARROW");
        RewriteRuleTokenStream stream_NIL=new RewriteRuleTokenStream(adaptor,"token NIL");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:260:10: ( ARROW type -> type | ARROW NIL -> ^( TYPE NIL ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==ARROW) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==NIL) ) {
                    alt50=2;
                }
                else if ( (LA50_1==CODE||LA50_1==ID||LA50_1==COLON||LA50_1==LPAREN||(LA50_1>=COLONS && LA50_1<=DATA)) ) {
                    alt50=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:260:12: ARROW type
                    {
                    ARROW157=(Token)match(input,ARROW,FOLLOW_ARROW_in_xreturns2085); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ARROW.add(ARROW157);

                    pushFollow(FOLLOW_type_in_xreturns2087);
                    type158=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type158.getTree());


                    // AST REWRITE
                    // elements: type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 260:28: -> type
                    {
                        adaptor.addChild(root_0, stream_type.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:262:5: ARROW NIL
                    {
                    ARROW159=(Token)match(input,ARROW,FOLLOW_ARROW_in_xreturns2104); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ARROW.add(ARROW159);

                    NIL160=(Token)match(input,NIL,FOLLOW_NIL_in_xreturns2106); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NIL.add(NIL160);



                    // AST REWRITE
                    // elements: NIL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 262:26: -> ^( TYPE NIL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:262:29: ^( TYPE NIL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                        adaptor.addChild(root_1, stream_NIL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "xreturns"

    public static class argtuple_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argtuple"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:265:1: argtuple : LPAREN tupleargdefs RPAREN -> ^( TUPLETYPE tupleargdefs ) ;
    public final EulangParser.argtuple_return argtuple() throws RecognitionException {
        EulangParser.argtuple_return retval = new EulangParser.argtuple_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAREN161=null;
        Token RPAREN163=null;
        EulangParser.tupleargdefs_return tupleargdefs162 = null;


        CommonTree LPAREN161_tree=null;
        CommonTree RPAREN163_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_tupleargdefs=new RewriteRuleSubtreeStream(adaptor,"rule tupleargdefs");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:265:10: ( LPAREN tupleargdefs RPAREN -> ^( TUPLETYPE tupleargdefs ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:265:12: LPAREN tupleargdefs RPAREN
            {
            LPAREN161=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_argtuple2136); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN161);

            pushFollow(FOLLOW_tupleargdefs_in_argtuple2138);
            tupleargdefs162=tupleargdefs();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tupleargdefs.add(tupleargdefs162.getTree());
            RPAREN163=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_argtuple2140); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN163);



            // AST REWRITE
            // elements: tupleargdefs
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 265:42: -> ^( TUPLETYPE tupleargdefs )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:265:45: ^( TUPLETYPE tupleargdefs )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TUPLETYPE, "TUPLETYPE"), root_1);

                adaptor.addChild(root_1, stream_tupleargdefs.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "argtuple"

    public static class tupleargdefs_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tupleargdefs"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:1: tupleargdefs : ( tupleargdef ( COMMA tupleargdef )+ ) -> ( tupleargdef )* ;
    public final EulangParser.tupleargdefs_return tupleargdefs() throws RecognitionException {
        EulangParser.tupleargdefs_return retval = new EulangParser.tupleargdefs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA165=null;
        EulangParser.tupleargdef_return tupleargdef164 = null;

        EulangParser.tupleargdef_return tupleargdef166 = null;


        CommonTree COMMA165_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_tupleargdef=new RewriteRuleSubtreeStream(adaptor,"rule tupleargdef");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:13: ( ( tupleargdef ( COMMA tupleargdef )+ ) -> ( tupleargdef )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:15: ( tupleargdef ( COMMA tupleargdef )+ )
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:15: ( tupleargdef ( COMMA tupleargdef )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:16: tupleargdef ( COMMA tupleargdef )+
            {
            pushFollow(FOLLOW_tupleargdef_in_tupleargdefs2162);
            tupleargdef164=tupleargdef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tupleargdef.add(tupleargdef164.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:28: ( COMMA tupleargdef )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==COMMA) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:30: COMMA tupleargdef
            	    {
            	    COMMA165=(Token)match(input,COMMA,FOLLOW_COMMA_in_tupleargdefs2166); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA165);

            	    pushFollow(FOLLOW_tupleargdef_in_tupleargdefs2168);
            	    tupleargdef166=tupleargdef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_tupleargdef.add(tupleargdef166.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);


            }



            // AST REWRITE
            // elements: tupleargdef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 268:75: -> ( tupleargdef )*
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:268:78: ( tupleargdef )*
                while ( stream_tupleargdef.hasNext() ) {
                    adaptor.addChild(root_0, stream_tupleargdef.nextTree());

                }
                stream_tupleargdef.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "tupleargdefs"

    public static class tupleargdef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tupleargdef"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:271:1: tupleargdef : ( type -> type | QUESTION -> ^( TYPE NIL ) | -> ^( TYPE NIL ) );
    public final EulangParser.tupleargdef_return tupleargdef() throws RecognitionException {
        EulangParser.tupleargdef_return retval = new EulangParser.tupleargdef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token QUESTION168=null;
        EulangParser.type_return type167 = null;


        CommonTree QUESTION168_tree=null;
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:271:12: ( type -> type | QUESTION -> ^( TYPE NIL ) | -> ^( TYPE NIL ) )
            int alt52=3;
            switch ( input.LA(1) ) {
            case CODE:
            case ID:
            case COLON:
            case LPAREN:
            case COLONS:
            case DATA:
                {
                alt52=1;
                }
                break;
            case QUESTION:
                {
                alt52=2;
                }
                break;
            case COMMA:
            case RPAREN:
                {
                alt52=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:271:14: type
                    {
                    pushFollow(FOLLOW_type_in_tupleargdef2213);
                    type167=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type167.getTree());


                    // AST REWRITE
                    // elements: type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 271:22: -> type
                    {
                        adaptor.addChild(root_0, stream_type.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:272:5: QUESTION
                    {
                    QUESTION168=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_tupleargdef2226); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION168);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 272:21: -> ^( TYPE NIL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:272:24: ^( TYPE NIL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NIL, "NIL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:273:21: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 273:21: -> ^( TYPE NIL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:273:24: ^( TYPE NIL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NIL, "NIL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "tupleargdef"

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:279:1: type : ( nonArrayType -> nonArrayType ) ( ( ( ( arraySuff )+ )=> ( arraySuff )+ -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) ) ) | ( LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) ) ) | ( CARET -> ^( TYPE ^( POINTER $type) ) ) )* ;
    public final EulangParser.type_return type() throws RecognitionException {
        EulangParser.type_return retval = new EulangParser.type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET171=null;
        Token COMMA173=null;
        Token RBRACKET175=null;
        Token CARET176=null;
        EulangParser.nonArrayType_return nonArrayType169 = null;

        EulangParser.arraySuff_return arraySuff170 = null;

        EulangParser.rhsExpr_return rhsExpr172 = null;

        EulangParser.rhsExpr_return rhsExpr174 = null;


        CommonTree LBRACKET171_tree=null;
        CommonTree COMMA173_tree=null;
        CommonTree RBRACKET175_tree=null;
        CommonTree CARET176_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_CARET=new RewriteRuleTokenStream(adaptor,"token CARET");
        RewriteRuleSubtreeStream stream_arraySuff=new RewriteRuleSubtreeStream(adaptor,"rule arraySuff");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        RewriteRuleSubtreeStream stream_nonArrayType=new RewriteRuleSubtreeStream(adaptor,"rule nonArrayType");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:279:6: ( ( nonArrayType -> nonArrayType ) ( ( ( ( arraySuff )+ )=> ( arraySuff )+ -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) ) ) | ( LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) ) ) | ( CARET -> ^( TYPE ^( POINTER $type) ) ) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:280:5: ( nonArrayType -> nonArrayType ) ( ( ( ( arraySuff )+ )=> ( arraySuff )+ -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) ) ) | ( LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) ) ) | ( CARET -> ^( TYPE ^( POINTER $type) ) ) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:280:5: ( nonArrayType -> nonArrayType )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:280:6: nonArrayType
            {
            pushFollow(FOLLOW_nonArrayType_in_type2291);
            nonArrayType169=nonArrayType();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_nonArrayType.add(nonArrayType169.getTree());


            // AST REWRITE
            // elements: nonArrayType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 280:19: -> nonArrayType
            {
                adaptor.addChild(root_0, stream_nonArrayType.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:281:6: ( ( ( ( arraySuff )+ )=> ( arraySuff )+ -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) ) ) | ( LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) ) ) | ( CARET -> ^( TYPE ^( POINTER $type) ) ) )*
            loop55:
            do {
                int alt55=4;
                alt55 = dfa55.predict(input);
                switch (alt55) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:282:7: ( ( ( arraySuff )+ )=> ( arraySuff )+ -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:282:7: ( ( ( arraySuff )+ )=> ( arraySuff )+ -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:9: ( ( arraySuff )+ )=> ( arraySuff )+
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:25: ( arraySuff )+
            	    int cnt53=0;
            	    loop53:
            	    do {
            	        int alt53=2;
            	        int LA53_0 = input.LA(1);

            	        if ( (LA53_0==LBRACKET) ) {
            	            alt53=1;
            	        }


            	        switch (alt53) {
            	    	case 1 :
            	    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:25: arraySuff
            	    	    {
            	    	    pushFollow(FOLLOW_arraySuff_in_type2329);
            	    	    arraySuff170=arraySuff();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) stream_arraySuff.add(arraySuff170.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt53 >= 1 ) break loop53;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(53, input);
            	                throw eee;
            	        }
            	        cnt53++;
            	    } while (true);



            	    // AST REWRITE
            	    // elements: type, arraySuff
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 283:36: -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:39: ^( TYPE ^( ARRAY $type ( arraySuff )+ ) )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:46: ^( ARRAY $type ( arraySuff )+ )
            	        {
            	        CommonTree root_2 = (CommonTree)adaptor.nil();
            	        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_2);

            	        adaptor.addChild(root_2, stream_retval.nextTree());
            	        if ( !(stream_arraySuff.hasNext()) ) {
            	            throw new RewriteEarlyExitException();
            	        }
            	        while ( stream_arraySuff.hasNext() ) {
            	            adaptor.addChild(root_2, stream_arraySuff.nextTree());

            	        }
            	        stream_arraySuff.reset();

            	        adaptor.addChild(root_1, root_2);
            	        }

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:286:8: ( LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:286:8: ( LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:287:9: LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET
            	    {
            	    LBRACKET171=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_type2384); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET171);

            	    pushFollow(FOLLOW_rhsExpr_in_type2386);
            	    rhsExpr172=rhsExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr172.getTree());
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:287:26: ( COMMA rhsExpr )+
            	    int cnt54=0;
            	    loop54:
            	    do {
            	        int alt54=2;
            	        int LA54_0 = input.LA(1);

            	        if ( (LA54_0==COMMA) ) {
            	            alt54=1;
            	        }


            	        switch (alt54) {
            	    	case 1 :
            	    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:287:28: COMMA rhsExpr
            	    	    {
            	    	    COMMA173=(Token)match(input,COMMA,FOLLOW_COMMA_in_type2390); if (state.failed) return retval; 
            	    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA173);

            	    	    pushFollow(FOLLOW_rhsExpr_in_type2392);
            	    	    rhsExpr174=rhsExpr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr174.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt54 >= 1 ) break loop54;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(54, input);
            	                throw eee;
            	        }
            	        cnt54++;
            	    } while (true);

            	    RBRACKET175=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_type2397); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET175);



            	    // AST REWRITE
            	    // elements: type, rhsExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 287:54: -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:287:57: ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:287:64: ^( ARRAY $type ( rhsExpr )+ )
            	        {
            	        CommonTree root_2 = (CommonTree)adaptor.nil();
            	        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_2);

            	        adaptor.addChild(root_2, stream_retval.nextTree());
            	        if ( !(stream_rhsExpr.hasNext()) ) {
            	            throw new RewriteEarlyExitException();
            	        }
            	        while ( stream_rhsExpr.hasNext() ) {
            	            adaptor.addChild(root_2, stream_rhsExpr.nextTree());

            	        }
            	        stream_rhsExpr.reset();

            	        adaptor.addChild(root_1, root_2);
            	        }

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:290:8: ( CARET -> ^( TYPE ^( POINTER $type) ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:290:8: ( CARET -> ^( TYPE ^( POINTER $type) ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:291:10: CARET
            	    {
            	    CARET176=(Token)match(input,CARET,FOLLOW_CARET_in_type2456); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CARET.add(CARET176);



            	    // AST REWRITE
            	    // elements: type
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 291:16: -> ^( TYPE ^( POINTER $type) )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:291:19: ^( TYPE ^( POINTER $type) )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:291:26: ^( POINTER $type)
            	        {
            	        CommonTree root_2 = (CommonTree)adaptor.nil();
            	        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POINTER, "POINTER"), root_2);

            	        adaptor.addChild(root_2, stream_retval.nextTree());

            	        adaptor.addChild(root_1, root_2);
            	        }

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "type"

    public static class nonArrayType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nonArrayType"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:296:1: nonArrayType : ( ( idExpr -> ^( TYPE idExpr ) ) | ( CODE ( proto )? -> ^( TYPE ^( CODE ( proto )? ) ) ) | data -> ^( TYPE data ) | argtuple );
    public final EulangParser.nonArrayType_return nonArrayType() throws RecognitionException {
        EulangParser.nonArrayType_return retval = new EulangParser.nonArrayType_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CODE178=null;
        EulangParser.idExpr_return idExpr177 = null;

        EulangParser.proto_return proto179 = null;

        EulangParser.data_return data180 = null;

        EulangParser.argtuple_return argtuple181 = null;


        CommonTree CODE178_tree=null;
        RewriteRuleTokenStream stream_CODE=new RewriteRuleTokenStream(adaptor,"token CODE");
        RewriteRuleSubtreeStream stream_idExpr=new RewriteRuleSubtreeStream(adaptor,"rule idExpr");
        RewriteRuleSubtreeStream stream_data=new RewriteRuleSubtreeStream(adaptor,"rule data");
        RewriteRuleSubtreeStream stream_proto=new RewriteRuleSubtreeStream(adaptor,"rule proto");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:296:14: ( ( idExpr -> ^( TYPE idExpr ) ) | ( CODE ( proto )? -> ^( TYPE ^( CODE ( proto )? ) ) ) | data -> ^( TYPE data ) | argtuple )
            int alt57=4;
            switch ( input.LA(1) ) {
            case ID:
            case COLON:
            case COLONS:
                {
                alt57=1;
                }
                break;
            case CODE:
                {
                alt57=2;
                }
                break;
            case DATA:
                {
                alt57=3;
                }
                break;
            case LPAREN:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:297:4: ( idExpr -> ^( TYPE idExpr ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:297:4: ( idExpr -> ^( TYPE idExpr ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:297:6: idExpr
                    {
                    pushFollow(FOLLOW_idExpr_in_nonArrayType2508);
                    idExpr177=idExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_idExpr.add(idExpr177.getTree());


                    // AST REWRITE
                    // elements: idExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 297:13: -> ^( TYPE idExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:297:16: ^( TYPE idExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                        adaptor.addChild(root_1, stream_idExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:5: ( CODE ( proto )? -> ^( TYPE ^( CODE ( proto )? ) ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:5: ( CODE ( proto )? -> ^( TYPE ^( CODE ( proto )? ) ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:7: CODE ( proto )?
                    {
                    CODE178=(Token)match(input,CODE,FOLLOW_CODE_in_nonArrayType2526); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CODE.add(CODE178);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:12: ( proto )?
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==LPAREN) ) {
                        alt56=1;
                    }
                    switch (alt56) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:12: proto
                            {
                            pushFollow(FOLLOW_proto_in_nonArrayType2528);
                            proto179=proto();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_proto.add(proto179.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: CODE, proto
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 298:19: -> ^( TYPE ^( CODE ( proto )? ) )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:22: ^( TYPE ^( CODE ( proto )? ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:29: ^( CODE ( proto )? )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(stream_CODE.nextNode(), root_2);

                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:298:36: ( proto )?
                        if ( stream_proto.hasNext() ) {
                            adaptor.addChild(root_2, stream_proto.nextTree());

                        }
                        stream_proto.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:299:5: data
                    {
                    pushFollow(FOLLOW_data_in_nonArrayType2551);
                    data180=data();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_data.add(data180.getTree());


                    // AST REWRITE
                    // elements: data
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 299:10: -> ^( TYPE data )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:299:13: ^( TYPE data )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TYPE, "TYPE"), root_1);

                        adaptor.addChild(root_1, stream_data.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:300:5: argtuple
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_argtuple_in_nonArrayType2567);
                    argtuple181=argtuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argtuple181.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "nonArrayType"

    public static class arraySuff_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arraySuff"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:302:1: arraySuff : ( LBRACKET rhsExpr RBRACKET -> rhsExpr | LBRACKET RBRACKET -> FALSE );
    public final EulangParser.arraySuff_return arraySuff() throws RecognitionException {
        EulangParser.arraySuff_return retval = new EulangParser.arraySuff_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET182=null;
        Token RBRACKET184=null;
        Token LBRACKET185=null;
        Token RBRACKET186=null;
        EulangParser.rhsExpr_return rhsExpr183 = null;


        CommonTree LBRACKET182_tree=null;
        CommonTree RBRACKET184_tree=null;
        CommonTree LBRACKET185_tree=null;
        CommonTree RBRACKET186_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:302:11: ( LBRACKET rhsExpr RBRACKET -> rhsExpr | LBRACKET RBRACKET -> FALSE )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==LBRACKET) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==RBRACKET) ) {
                    alt58=2;
                }
                else if ( (LA58_1==CODE||(LA58_1>=SIZEOF && LA58_1<=TYPEOF)||LA58_1==ID||LA58_1==COLON||LA58_1==LPAREN||LA58_1==NIL||LA58_1==IF||LA58_1==NOT||(LA58_1>=TILDE && LA58_1<=AMP)||LA58_1==MINUS||(LA58_1>=PLUSPLUS && LA58_1<=STRING_LITERAL)||(LA58_1>=FALSE && LA58_1<=COLONS)) ) {
                    alt58=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:302:13: LBRACKET rhsExpr RBRACKET
                    {
                    LBRACKET182=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySuff2583); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET182);

                    pushFollow(FOLLOW_rhsExpr_in_arraySuff2585);
                    rhsExpr183=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr183.getTree());
                    RBRACKET184=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySuff2587); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET184);



                    // AST REWRITE
                    // elements: rhsExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 302:39: -> rhsExpr
                    {
                        adaptor.addChild(root_0, stream_rhsExpr.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:303:7: LBRACKET RBRACKET
                    {
                    LBRACKET185=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arraySuff2599); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET185);

                    RBRACKET186=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arraySuff2601); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET186);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 303:25: -> FALSE
                    {
                        adaptor.addChild(root_0, (CommonTree)adaptor.create(FALSE, "FALSE"));

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "arraySuff"

    public static class codestmtlist_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "codestmtlist"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:1: codestmtlist : ( codeStmt ( SEMI ( codeStmt )? )* -> ^( STMTLIST ( codeStmt )* ) | -> ^( STMTLIST ) );
    public final EulangParser.codestmtlist_return codestmtlist() throws RecognitionException {
        EulangParser.codestmtlist_return retval = new EulangParser.codestmtlist_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMI188=null;
        EulangParser.codeStmt_return codeStmt187 = null;

        EulangParser.codeStmt_return codeStmt189 = null;


        CommonTree SEMI188_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_codeStmt=new RewriteRuleSubtreeStream(adaptor,"rule codeStmt");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:13: ( codeStmt ( SEMI ( codeStmt )? )* -> ^( STMTLIST ( codeStmt )* ) | -> ^( STMTLIST ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==CODE||LA61_0==GOTO||(LA61_0>=SIZEOF && LA61_0<=TYPEOF)||LA61_0==ID||LA61_0==COLON||LA61_0==LBRACE||LA61_0==FOR||(LA61_0>=ATSIGN && LA61_0<=LPAREN)||LA61_0==NIL||(LA61_0>=DO && LA61_0<=REPEAT)||LA61_0==IF||LA61_0==NOT||(LA61_0>=TILDE && LA61_0<=AMP)||LA61_0==MINUS||(LA61_0>=PLUSPLUS && LA61_0<=STRING_LITERAL)||(LA61_0>=FALSE && LA61_0<=COLONS)) ) {
                alt61=1;
            }
            else if ( (LA61_0==RBRACE) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:16: codeStmt ( SEMI ( codeStmt )? )*
                    {
                    pushFollow(FOLLOW_codeStmt_in_codestmtlist2617);
                    codeStmt187=codeStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_codeStmt.add(codeStmt187.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:25: ( SEMI ( codeStmt )? )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==SEMI) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:26: SEMI ( codeStmt )?
                    	    {
                    	    SEMI188=(Token)match(input,SEMI,FOLLOW_SEMI_in_codestmtlist2620); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_SEMI.add(SEMI188);

                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:31: ( codeStmt )?
                    	    int alt59=2;
                    	    int LA59_0 = input.LA(1);

                    	    if ( (LA59_0==CODE||LA59_0==GOTO||(LA59_0>=SIZEOF && LA59_0<=TYPEOF)||LA59_0==ID||LA59_0==COLON||LA59_0==LBRACE||LA59_0==FOR||(LA59_0>=ATSIGN && LA59_0<=LPAREN)||LA59_0==NIL||(LA59_0>=DO && LA59_0<=REPEAT)||LA59_0==IF||LA59_0==NOT||(LA59_0>=TILDE && LA59_0<=AMP)||LA59_0==MINUS||(LA59_0>=PLUSPLUS && LA59_0<=STRING_LITERAL)||(LA59_0>=FALSE && LA59_0<=COLONS)) ) {
                    	        alt59=1;
                    	    }
                    	    switch (alt59) {
                    	        case 1 :
                    	            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:31: codeStmt
                    	            {
                    	            pushFollow(FOLLOW_codeStmt_in_codestmtlist2622);
                    	            codeStmt189=codeStmt();

                    	            state._fsp--;
                    	            if (state.failed) return retval;
                    	            if ( state.backtracking==0 ) stream_codeStmt.add(codeStmt189.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: codeStmt
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 305:44: -> ^( STMTLIST ( codeStmt )* )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:48: ^( STMTLIST ( codeStmt )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMTLIST, "STMTLIST"), root_1);

                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:305:59: ( codeStmt )*
                        while ( stream_codeStmt.hasNext() ) {
                            adaptor.addChild(root_1, stream_codeStmt.nextTree());

                        }
                        stream_codeStmt.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:306:7: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 306:7: -> ^( STMTLIST )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:306:10: ^( STMTLIST )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMTLIST, "STMTLIST"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "codestmtlist"

    public static class codeStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "codeStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:309:1: codeStmt : ( labelStmt codeStmtExpr -> ^( LABELSTMT labelStmt codeStmtExpr ) | codeStmtExpr -> codeStmtExpr );
    public final EulangParser.codeStmt_return codeStmt() throws RecognitionException {
        EulangParser.codeStmt_return retval = new EulangParser.codeStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.labelStmt_return labelStmt190 = null;

        EulangParser.codeStmtExpr_return codeStmtExpr191 = null;

        EulangParser.codeStmtExpr_return codeStmtExpr192 = null;


        RewriteRuleSubtreeStream stream_labelStmt=new RewriteRuleSubtreeStream(adaptor,"rule labelStmt");
        RewriteRuleSubtreeStream stream_codeStmtExpr=new RewriteRuleSubtreeStream(adaptor,"rule codeStmtExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:309:10: ( labelStmt codeStmtExpr -> ^( LABELSTMT labelStmt codeStmtExpr ) | codeStmtExpr -> codeStmtExpr )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==ATSIGN) ) {
                alt62=1;
            }
            else if ( (LA62_0==CODE||LA62_0==GOTO||(LA62_0>=SIZEOF && LA62_0<=TYPEOF)||LA62_0==ID||LA62_0==COLON||LA62_0==LBRACE||LA62_0==FOR||LA62_0==LPAREN||LA62_0==NIL||(LA62_0>=DO && LA62_0<=REPEAT)||LA62_0==IF||LA62_0==NOT||(LA62_0>=TILDE && LA62_0<=AMP)||LA62_0==MINUS||(LA62_0>=PLUSPLUS && LA62_0<=STRING_LITERAL)||(LA62_0>=FALSE && LA62_0<=COLONS)) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:309:12: labelStmt codeStmtExpr
                    {
                    pushFollow(FOLLOW_labelStmt_in_codeStmt2666);
                    labelStmt190=labelStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_labelStmt.add(labelStmt190.getTree());
                    pushFollow(FOLLOW_codeStmtExpr_in_codeStmt2668);
                    codeStmtExpr191=codeStmtExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_codeStmtExpr.add(codeStmtExpr191.getTree());


                    // AST REWRITE
                    // elements: codeStmtExpr, labelStmt
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 309:36: -> ^( LABELSTMT labelStmt codeStmtExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:309:39: ^( LABELSTMT labelStmt codeStmtExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LABELSTMT, "LABELSTMT"), root_1);

                        adaptor.addChild(root_1, stream_labelStmt.nextTree());
                        adaptor.addChild(root_1, stream_codeStmtExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:310:9: codeStmtExpr
                    {
                    pushFollow(FOLLOW_codeStmtExpr_in_codeStmt2689);
                    codeStmtExpr192=codeStmtExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_codeStmtExpr.add(codeStmtExpr192.getTree());


                    // AST REWRITE
                    // elements: codeStmtExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 310:22: -> codeStmtExpr
                    {
                        adaptor.addChild(root_0, stream_codeStmtExpr.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "codeStmt"

    public static class codeStmtExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "codeStmtExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:313:1: codeStmtExpr : ( ( varDecl )=> varDecl -> varDecl | ( assignStmt )=> assignStmt -> assignStmt | rhsExpr -> ^( STMTEXPR rhsExpr ) | ( LBRACE )=> blockStmt -> blockStmt | gotoStmt -> gotoStmt | controlStmt -> controlStmt );
    public final EulangParser.codeStmtExpr_return codeStmtExpr() throws RecognitionException {
        EulangParser.codeStmtExpr_return retval = new EulangParser.codeStmtExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.varDecl_return varDecl193 = null;

        EulangParser.assignStmt_return assignStmt194 = null;

        EulangParser.rhsExpr_return rhsExpr195 = null;

        EulangParser.blockStmt_return blockStmt196 = null;

        EulangParser.gotoStmt_return gotoStmt197 = null;

        EulangParser.controlStmt_return controlStmt198 = null;


        RewriteRuleSubtreeStream stream_assignStmt=new RewriteRuleSubtreeStream(adaptor,"rule assignStmt");
        RewriteRuleSubtreeStream stream_gotoStmt=new RewriteRuleSubtreeStream(adaptor,"rule gotoStmt");
        RewriteRuleSubtreeStream stream_blockStmt=new RewriteRuleSubtreeStream(adaptor,"rule blockStmt");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        RewriteRuleSubtreeStream stream_controlStmt=new RewriteRuleSubtreeStream(adaptor,"rule controlStmt");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:313:14: ( ( varDecl )=> varDecl -> varDecl | ( assignStmt )=> assignStmt -> assignStmt | rhsExpr -> ^( STMTEXPR rhsExpr ) | ( LBRACE )=> blockStmt -> blockStmt | gotoStmt -> gotoStmt | controlStmt -> controlStmt )
            int alt63=6;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:314:7: ( varDecl )=> varDecl
                    {
                    pushFollow(FOLLOW_varDecl_in_codeStmtExpr2721);
                    varDecl193=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_varDecl.add(varDecl193.getTree());


                    // AST REWRITE
                    // elements: varDecl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 314:32: -> varDecl
                    {
                        adaptor.addChild(root_0, stream_varDecl.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:315:9: ( assignStmt )=> assignStmt
                    {
                    pushFollow(FOLLOW_assignStmt_in_codeStmtExpr2744);
                    assignStmt194=assignStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignStmt.add(assignStmt194.getTree());


                    // AST REWRITE
                    // elements: assignStmt
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 315:39: -> assignStmt
                    {
                        adaptor.addChild(root_0, stream_assignStmt.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:316:9: rhsExpr
                    {
                    pushFollow(FOLLOW_rhsExpr_in_codeStmtExpr2761);
                    rhsExpr195=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr195.getTree());


                    // AST REWRITE
                    // elements: rhsExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 316:23: -> ^( STMTEXPR rhsExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:316:27: ^( STMTEXPR rhsExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(STMTEXPR, "STMTEXPR"), root_1);

                        adaptor.addChild(root_1, stream_rhsExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:317:9: ( LBRACE )=> blockStmt
                    {
                    pushFollow(FOLLOW_blockStmt_in_codeStmtExpr2794);
                    blockStmt196=blockStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_blockStmt.add(blockStmt196.getTree());


                    // AST REWRITE
                    // elements: blockStmt
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 317:41: -> blockStmt
                    {
                        adaptor.addChild(root_0, stream_blockStmt.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:318:9: gotoStmt
                    {
                    pushFollow(FOLLOW_gotoStmt_in_codeStmtExpr2816);
                    gotoStmt197=gotoStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_gotoStmt.add(gotoStmt197.getTree());


                    // AST REWRITE
                    // elements: gotoStmt
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 318:23: -> gotoStmt
                    {
                        adaptor.addChild(root_0, stream_gotoStmt.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:320:9: controlStmt
                    {
                    pushFollow(FOLLOW_controlStmt_in_codeStmtExpr2842);
                    controlStmt198=controlStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_controlStmt.add(controlStmt198.getTree());


                    // AST REWRITE
                    // elements: controlStmt
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 320:26: -> controlStmt
                    {
                        adaptor.addChild(root_0, stream_controlStmt.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "codeStmtExpr"

    public static class varDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDecl"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:323:1: varDecl : ( singleVarDecl | tupleVarDecl );
    public final EulangParser.varDecl_return varDecl() throws RecognitionException {
        EulangParser.varDecl_return retval = new EulangParser.varDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.singleVarDecl_return singleVarDecl199 = null;

        EulangParser.tupleVarDecl_return tupleVarDecl200 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:323:8: ( singleVarDecl | tupleVarDecl )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==ID) ) {
                alt64=1;
            }
            else if ( (LA64_0==LPAREN) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:323:10: singleVarDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_singleVarDecl_in_varDecl2865);
                    singleVarDecl199=singleVarDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, singleVarDecl199.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:323:26: tupleVarDecl
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_tupleVarDecl_in_varDecl2869);
                    tupleVarDecl200=tupleVarDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, tupleVarDecl200.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "varDecl"

    public static class singleVarDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "singleVarDecl"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:325:1: singleVarDecl : ID ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC ID TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC ID type ( assignOrInitExpr )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) | ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? ) ) ) ;
    public final EulangParser.singleVarDecl_return singleVarDecl() throws RecognitionException {
        EulangParser.singleVarDecl_return retval = new EulangParser.singleVarDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID201=null;
        Token COLON_EQUALS202=null;
        Token COLON204=null;
        Token EQUALS206=null;
        Token COMMA208=null;
        Token ID209=null;
        Token COLON_EQUALS210=null;
        Token PLUS211=null;
        Token COMMA213=null;
        Token COLON215=null;
        Token EQUALS217=null;
        Token PLUS218=null;
        Token COMMA220=null;
        EulangParser.assignOrInitExpr_return assignOrInitExpr203 = null;

        EulangParser.type_return type205 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr207 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr212 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr214 = null;

        EulangParser.type_return type216 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr219 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr221 = null;


        CommonTree ID201_tree=null;
        CommonTree COLON_EQUALS202_tree=null;
        CommonTree COLON204_tree=null;
        CommonTree EQUALS206_tree=null;
        CommonTree COMMA208_tree=null;
        CommonTree ID209_tree=null;
        CommonTree COLON_EQUALS210_tree=null;
        CommonTree PLUS211_tree=null;
        CommonTree COMMA213_tree=null;
        CommonTree COLON215_tree=null;
        CommonTree EQUALS217_tree=null;
        CommonTree PLUS218_tree=null;
        CommonTree COMMA220_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_COLON_EQUALS=new RewriteRuleTokenStream(adaptor,"token COLON_EQUALS");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignOrInitExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignOrInitExpr");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:325:14: ( ID ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC ID TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC ID type ( assignOrInitExpr )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) | ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? ) ) ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:326:5: ID ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC ID TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC ID type ( assignOrInitExpr )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) | ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? ) ) )
            {
            ID201=(Token)match(input,ID,FOLLOW_ID_in_singleVarDecl2881); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID201);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:326:8: ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC ID TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC ID type ( assignOrInitExpr )* ) ) | ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) | ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? ) ) )
            int alt73=3;
            switch ( input.LA(1) ) {
            case COLON_EQUALS:
                {
                alt73=1;
                }
                break;
            case COLON:
                {
                alt73=2;
                }
                break;
            case COMMA:
                {
                alt73=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:327:9: ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC ID TYPE assignOrInitExpr ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:327:9: ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC ID TYPE assignOrInitExpr ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:327:11: COLON_EQUALS assignOrInitExpr
                    {
                    COLON_EQUALS202=(Token)match(input,COLON_EQUALS,FOLLOW_COLON_EQUALS_in_singleVarDecl2895); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON_EQUALS.add(COLON_EQUALS202);

                    pushFollow(FOLLOW_assignOrInitExpr_in_singleVarDecl2897);
                    assignOrInitExpr203=assignOrInitExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr203.getTree());


                    // AST REWRITE
                    // elements: assignOrInitExpr, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 327:49: -> ^( ALLOC ID TYPE assignOrInitExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:327:52: ^( ALLOC ID TYPE assignOrInitExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, (CommonTree)adaptor.create(TYPE, "TYPE"));
                        adaptor.addChild(root_1, stream_assignOrInitExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:328:9: ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC ID type ( assignOrInitExpr )* ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:328:9: ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC ID type ( assignOrInitExpr )* ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:328:11: COLON type ( EQUALS assignOrInitExpr )?
                    {
                    COLON204=(Token)match(input,COLON,FOLLOW_COLON_in_singleVarDecl2931); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON204);

                    pushFollow(FOLLOW_type_in_singleVarDecl2933);
                    type205=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type205.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:328:22: ( EQUALS assignOrInitExpr )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==EQUALS) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:328:23: EQUALS assignOrInitExpr
                            {
                            EQUALS206=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_singleVarDecl2936); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS206);

                            pushFollow(FOLLOW_assignOrInitExpr_in_singleVarDecl2938);
                            assignOrInitExpr207=assignOrInitExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr207.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: assignOrInitExpr, ID, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 328:50: -> ^( ALLOC ID type ( assignOrInitExpr )* )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:328:53: ^( ALLOC ID type ( assignOrInitExpr )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_type.nextTree());
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:328:69: ( assignOrInitExpr )*
                        while ( stream_assignOrInitExpr.hasNext() ) {
                            adaptor.addChild(root_1, stream_assignOrInitExpr.nextTree());

                        }
                        stream_assignOrInitExpr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:329:9: ( COMMA ID )+ ( ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) | ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:329:9: ( COMMA ID )+
                    int cnt66=0;
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==COMMA) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:329:11: COMMA ID
                    	    {
                    	    COMMA208=(Token)match(input,COMMA,FOLLOW_COMMA_in_singleVarDecl2968); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA208);

                    	    ID209=(Token)match(input,ID,FOLLOW_ID_in_singleVarDecl2970); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID209);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt66 >= 1 ) break loop66;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(66, input);
                                throw eee;
                        }
                        cnt66++;
                    } while (true);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:9: ( ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* ) -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) | ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? ) -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? ) )
                    int alt72=2;
                    int LA72_0 = input.LA(1);

                    if ( (LA72_0==COLON_EQUALS) ) {
                        alt72=1;
                    }
                    else if ( (LA72_0==COLON) ) {
                        alt72=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 72, 0, input);

                        throw nvae;
                    }
                    switch (alt72) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:12: ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )
                            {
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:12: ( COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:14: COLON_EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )*
                            {
                            COLON_EQUALS210=(Token)match(input,COLON_EQUALS,FOLLOW_COLON_EQUALS_in_singleVarDecl2989); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON_EQUALS.add(COLON_EQUALS210);

                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:27: ( PLUS )?
                            int alt67=2;
                            int LA67_0 = input.LA(1);

                            if ( (LA67_0==PLUS) ) {
                                alt67=1;
                            }
                            switch (alt67) {
                                case 1 :
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:27: PLUS
                                    {
                                    PLUS211=(Token)match(input,PLUS,FOLLOW_PLUS_in_singleVarDecl2991); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS211);


                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_assignOrInitExpr_in_singleVarDecl2994);
                            assignOrInitExpr212=assignOrInitExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr212.getTree());
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:50: ( COMMA assignOrInitExpr )*
                            loop68:
                            do {
                                int alt68=2;
                                int LA68_0 = input.LA(1);

                                if ( (LA68_0==COMMA) ) {
                                    alt68=1;
                                }


                                switch (alt68) {
                            	case 1 :
                            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:330:51: COMMA assignOrInitExpr
                            	    {
                            	    COMMA213=(Token)match(input,COMMA,FOLLOW_COMMA_in_singleVarDecl2997); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA213);

                            	    pushFollow(FOLLOW_assignOrInitExpr_in_singleVarDecl2999);
                            	    assignOrInitExpr214=assignOrInitExpr();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr214.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop68;
                                }
                            } while (true);


                            }



                            // AST REWRITE
                            // elements: ID, PLUS, assignOrInitExpr
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 331:15: -> ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) )
                            {
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:331:18: ^( ALLOC ^( LIST ( ID )+ ) TYPE ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:331:26: ^( LIST ( ID )+ )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                if ( !(stream_ID.hasNext()) ) {
                                    throw new RewriteEarlyExitException();
                                }
                                while ( stream_ID.hasNext() ) {
                                    adaptor.addChild(root_2, stream_ID.nextNode());

                                }
                                stream_ID.reset();

                                adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_1, (CommonTree)adaptor.create(TYPE, "TYPE"));
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:331:43: ( PLUS )?
                                if ( stream_PLUS.hasNext() ) {
                                    adaptor.addChild(root_1, stream_PLUS.nextNode());

                                }
                                stream_PLUS.reset();
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:331:49: ^( LIST ( assignOrInitExpr )+ )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                if ( !(stream_assignOrInitExpr.hasNext()) ) {
                                    throw new RewriteEarlyExitException();
                                }
                                while ( stream_assignOrInitExpr.hasNext() ) {
                                    adaptor.addChild(root_2, stream_assignOrInitExpr.nextTree());

                                }
                                stream_assignOrInitExpr.reset();

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:12: ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? )
                            {
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:12: ( COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )? )
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:14: COLON type ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )?
                            {
                            COLON215=(Token)match(input,COLON,FOLLOW_COLON_in_singleVarDecl3058); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COLON.add(COLON215);

                            pushFollow(FOLLOW_type_in_singleVarDecl3060);
                            type216=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_type.add(type216.getTree());
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:25: ( EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* )?
                            int alt71=2;
                            int LA71_0 = input.LA(1);

                            if ( (LA71_0==EQUALS) ) {
                                alt71=1;
                            }
                            switch (alt71) {
                                case 1 :
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:26: EQUALS ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )*
                                    {
                                    EQUALS217=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_singleVarDecl3063); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS217);

                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:33: ( PLUS )?
                                    int alt69=2;
                                    int LA69_0 = input.LA(1);

                                    if ( (LA69_0==PLUS) ) {
                                        alt69=1;
                                    }
                                    switch (alt69) {
                                        case 1 :
                                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:33: PLUS
                                            {
                                            PLUS218=(Token)match(input,PLUS,FOLLOW_PLUS_in_singleVarDecl3065); if (state.failed) return retval; 
                                            if ( state.backtracking==0 ) stream_PLUS.add(PLUS218);


                                            }
                                            break;

                                    }

                                    pushFollow(FOLLOW_assignOrInitExpr_in_singleVarDecl3068);
                                    assignOrInitExpr219=assignOrInitExpr();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr219.getTree());
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:56: ( COMMA assignOrInitExpr )*
                                    loop70:
                                    do {
                                        int alt70=2;
                                        int LA70_0 = input.LA(1);

                                        if ( (LA70_0==COMMA) ) {
                                            alt70=1;
                                        }


                                        switch (alt70) {
                                    	case 1 :
                                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:332:57: COMMA assignOrInitExpr
                                    	    {
                                    	    COMMA220=(Token)match(input,COMMA,FOLLOW_COMMA_in_singleVarDecl3071); if (state.failed) return retval; 
                                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA220);

                                    	    pushFollow(FOLLOW_assignOrInitExpr_in_singleVarDecl3073);
                                    	    assignOrInitExpr221=assignOrInitExpr();

                                    	    state._fsp--;
                                    	    if (state.failed) return retval;
                                    	    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr221.getTree());

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop70;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            }



                            // AST REWRITE
                            // elements: assignOrInitExpr, type, ID, PLUS
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 333:15: -> ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? )
                            {
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:333:18: ^( ALLOC ^( LIST ( ID )+ ) type ( PLUS )? ( ^( LIST ( assignOrInitExpr )+ ) )? )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:333:26: ^( LIST ( ID )+ )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                if ( !(stream_ID.hasNext()) ) {
                                    throw new RewriteEarlyExitException();
                                }
                                while ( stream_ID.hasNext() ) {
                                    adaptor.addChild(root_2, stream_ID.nextNode());

                                }
                                stream_ID.reset();

                                adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_1, stream_type.nextTree());
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:333:43: ( PLUS )?
                                if ( stream_PLUS.hasNext() ) {
                                    adaptor.addChild(root_1, stream_PLUS.nextNode());

                                }
                                stream_PLUS.reset();
                                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:333:49: ( ^( LIST ( assignOrInitExpr )+ ) )?
                                if ( stream_assignOrInitExpr.hasNext() ) {
                                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:333:49: ^( LIST ( assignOrInitExpr )+ )
                                    {
                                    CommonTree root_2 = (CommonTree)adaptor.nil();
                                    root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                                    if ( !(stream_assignOrInitExpr.hasNext()) ) {
                                        throw new RewriteEarlyExitException();
                                    }
                                    while ( stream_assignOrInitExpr.hasNext() ) {
                                        adaptor.addChild(root_2, stream_assignOrInitExpr.nextTree());

                                    }
                                    stream_assignOrInitExpr.reset();

                                    adaptor.addChild(root_1, root_2);
                                    }

                                }
                                stream_assignOrInitExpr.reset();

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "singleVarDecl"

    public static class tupleVarDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tupleVarDecl"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:337:1: tupleVarDecl : idTuple ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC idTuple TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC idTuple type ( assignOrInitExpr )* ) ) ) ;
    public final EulangParser.tupleVarDecl_return tupleVarDecl() throws RecognitionException {
        EulangParser.tupleVarDecl_return retval = new EulangParser.tupleVarDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COLON_EQUALS223=null;
        Token COLON225=null;
        Token EQUALS227=null;
        EulangParser.idTuple_return idTuple222 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr224 = null;

        EulangParser.type_return type226 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr228 = null;


        CommonTree COLON_EQUALS223_tree=null;
        CommonTree COLON225_tree=null;
        CommonTree EQUALS227_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_COLON_EQUALS=new RewriteRuleTokenStream(adaptor,"token COLON_EQUALS");
        RewriteRuleSubtreeStream stream_idTuple=new RewriteRuleSubtreeStream(adaptor,"rule idTuple");
        RewriteRuleSubtreeStream stream_assignOrInitExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignOrInitExpr");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:337:13: ( idTuple ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC idTuple TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC idTuple type ( assignOrInitExpr )* ) ) ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:338:5: idTuple ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC idTuple TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC idTuple type ( assignOrInitExpr )* ) ) )
            {
            pushFollow(FOLLOW_idTuple_in_tupleVarDecl3159);
            idTuple222=idTuple();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_idTuple.add(idTuple222.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:339:7: ( ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC idTuple TYPE assignOrInitExpr ) ) | ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC idTuple type ( assignOrInitExpr )* ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==COLON_EQUALS) ) {
                alt75=1;
            }
            else if ( (LA75_0==COLON) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:339:10: ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC idTuple TYPE assignOrInitExpr ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:339:10: ( COLON_EQUALS assignOrInitExpr -> ^( ALLOC idTuple TYPE assignOrInitExpr ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:339:12: COLON_EQUALS assignOrInitExpr
                    {
                    COLON_EQUALS223=(Token)match(input,COLON_EQUALS,FOLLOW_COLON_EQUALS_in_tupleVarDecl3173); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON_EQUALS.add(COLON_EQUALS223);

                    pushFollow(FOLLOW_assignOrInitExpr_in_tupleVarDecl3175);
                    assignOrInitExpr224=assignOrInitExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr224.getTree());


                    // AST REWRITE
                    // elements: assignOrInitExpr, idTuple
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 339:50: -> ^( ALLOC idTuple TYPE assignOrInitExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:339:53: ^( ALLOC idTuple TYPE assignOrInitExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_idTuple.nextTree());
                        adaptor.addChild(root_1, (CommonTree)adaptor.create(TYPE, "TYPE"));
                        adaptor.addChild(root_1, stream_assignOrInitExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:340:9: ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC idTuple type ( assignOrInitExpr )* ) )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:340:9: ( COLON type ( EQUALS assignOrInitExpr )? -> ^( ALLOC idTuple type ( assignOrInitExpr )* ) )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:340:11: COLON type ( EQUALS assignOrInitExpr )?
                    {
                    COLON225=(Token)match(input,COLON,FOLLOW_COLON_in_tupleVarDecl3209); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON225);

                    pushFollow(FOLLOW_type_in_tupleVarDecl3211);
                    type226=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type226.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:340:22: ( EQUALS assignOrInitExpr )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==EQUALS) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:340:23: EQUALS assignOrInitExpr
                            {
                            EQUALS227=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_tupleVarDecl3214); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS227);

                            pushFollow(FOLLOW_assignOrInitExpr_in_tupleVarDecl3216);
                            assignOrInitExpr228=assignOrInitExpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr228.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: idTuple, assignOrInitExpr, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 340:50: -> ^( ALLOC idTuple type ( assignOrInitExpr )* )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:340:53: ^( ALLOC idTuple type ( assignOrInitExpr )* )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                        adaptor.addChild(root_1, stream_idTuple.nextTree());
                        adaptor.addChild(root_1, stream_type.nextTree());
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:340:74: ( assignOrInitExpr )*
                        while ( stream_assignOrInitExpr.hasNext() ) {
                            adaptor.addChild(root_1, stream_assignOrInitExpr.nextTree());

                        }
                        stream_assignOrInitExpr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "tupleVarDecl"

    public static class assignStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:345:1: assignStmt : ( ( lhs assignEqOp )=> lhs assignEqOp assignOrInitExpr -> ^( ASSIGN assignEqOp lhs assignOrInitExpr ) | idTuple EQUALS assignOrInitExpr -> ^( ASSIGN EQUALS idTuple assignOrInitExpr ) | ( lhs ( COMMA lhs )+ assignEqOp )=> lhs ( COMMA lhs )+ assignEqOp ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* -> ^( ASSIGN assignEqOp ^( LIST ( lhs )+ ) ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) );
    public final EulangParser.assignStmt_return assignStmt() throws RecognitionException {
        EulangParser.assignStmt_return retval = new EulangParser.assignStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS233=null;
        Token COMMA236=null;
        Token PLUS239=null;
        Token COMMA241=null;
        EulangParser.lhs_return lhs229 = null;

        EulangParser.assignEqOp_return assignEqOp230 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr231 = null;

        EulangParser.idTuple_return idTuple232 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr234 = null;

        EulangParser.lhs_return lhs235 = null;

        EulangParser.lhs_return lhs237 = null;

        EulangParser.assignEqOp_return assignEqOp238 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr240 = null;

        EulangParser.assignOrInitExpr_return assignOrInitExpr242 = null;


        CommonTree EQUALS233_tree=null;
        CommonTree COMMA236_tree=null;
        CommonTree PLUS239_tree=null;
        CommonTree COMMA241_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_idTuple=new RewriteRuleSubtreeStream(adaptor,"rule idTuple");
        RewriteRuleSubtreeStream stream_assignEqOp=new RewriteRuleSubtreeStream(adaptor,"rule assignEqOp");
        RewriteRuleSubtreeStream stream_assignOrInitExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignOrInitExpr");
        RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:345:12: ( ( lhs assignEqOp )=> lhs assignEqOp assignOrInitExpr -> ^( ASSIGN assignEqOp lhs assignOrInitExpr ) | idTuple EQUALS assignOrInitExpr -> ^( ASSIGN EQUALS idTuple assignOrInitExpr ) | ( lhs ( COMMA lhs )+ assignEqOp )=> lhs ( COMMA lhs )+ assignEqOp ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* -> ^( ASSIGN assignEqOp ^( LIST ( lhs )+ ) ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) )
            int alt79=3;
            alt79 = dfa79.predict(input);
            switch (alt79) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:345:14: ( lhs assignEqOp )=> lhs assignEqOp assignOrInitExpr
                    {
                    pushFollow(FOLLOW_lhs_in_assignStmt3264);
                    lhs229=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(lhs229.getTree());
                    pushFollow(FOLLOW_assignEqOp_in_assignStmt3266);
                    assignEqOp230=assignEqOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignEqOp.add(assignEqOp230.getTree());
                    pushFollow(FOLLOW_assignOrInitExpr_in_assignStmt3268);
                    assignOrInitExpr231=assignOrInitExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr231.getTree());


                    // AST REWRITE
                    // elements: lhs, assignEqOp, assignOrInitExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 345:73: -> ^( ASSIGN assignEqOp lhs assignOrInitExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:345:76: ^( ASSIGN assignEqOp lhs assignOrInitExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_assignEqOp.nextTree());
                        adaptor.addChild(root_1, stream_lhs.nextTree());
                        adaptor.addChild(root_1, stream_assignOrInitExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:346:7: idTuple EQUALS assignOrInitExpr
                    {
                    pushFollow(FOLLOW_idTuple_in_assignStmt3295);
                    idTuple232=idTuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_idTuple.add(idTuple232.getTree());
                    EQUALS233=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_assignStmt3297); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS233);

                    pushFollow(FOLLOW_assignOrInitExpr_in_assignStmt3299);
                    assignOrInitExpr234=assignOrInitExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr234.getTree());


                    // AST REWRITE
                    // elements: EQUALS, idTuple, assignOrInitExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 346:53: -> ^( ASSIGN EQUALS idTuple assignOrInitExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:346:56: ^( ASSIGN EQUALS idTuple assignOrInitExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_EQUALS.nextNode());
                        adaptor.addChild(root_1, stream_idTuple.nextTree());
                        adaptor.addChild(root_1, stream_assignOrInitExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:7: ( lhs ( COMMA lhs )+ assignEqOp )=> lhs ( COMMA lhs )+ assignEqOp ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )*
                    {
                    pushFollow(FOLLOW_lhs_in_assignStmt3354);
                    lhs235=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(lhs235.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:45: ( COMMA lhs )+
                    int cnt76=0;
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==COMMA) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:46: COMMA lhs
                    	    {
                    	    COMMA236=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignStmt3357); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA236);

                    	    pushFollow(FOLLOW_lhs_in_assignStmt3359);
                    	    lhs237=lhs();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_lhs.add(lhs237.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt76 >= 1 ) break loop76;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(76, input);
                                throw eee;
                        }
                        cnt76++;
                    } while (true);

                    pushFollow(FOLLOW_assignEqOp_in_assignStmt3363);
                    assignEqOp238=assignEqOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignEqOp.add(assignEqOp238.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:69: ( PLUS )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==PLUS) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:69: PLUS
                            {
                            PLUS239=(Token)match(input,PLUS,FOLLOW_PLUS_in_assignStmt3365); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PLUS.add(PLUS239);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_assignOrInitExpr_in_assignStmt3368);
                    assignOrInitExpr240=assignOrInitExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr240.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:92: ( COMMA assignOrInitExpr )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==COMMA) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:93: COMMA assignOrInitExpr
                    	    {
                    	    COMMA241=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignStmt3371); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA241);

                    	    pushFollow(FOLLOW_assignOrInitExpr_in_assignStmt3373);
                    	    assignOrInitExpr242=assignOrInitExpr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_assignOrInitExpr.add(assignOrInitExpr242.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: assignEqOp, assignOrInitExpr, PLUS, lhs
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 349:9: -> ^( ASSIGN assignEqOp ^( LIST ( lhs )+ ) ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:349:12: ^( ASSIGN assignEqOp ^( LIST ( lhs )+ ) ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_assignEqOp.nextTree());
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:349:32: ^( LIST ( lhs )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                        if ( !(stream_lhs.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_lhs.hasNext() ) {
                            adaptor.addChild(root_2, stream_lhs.nextTree());

                        }
                        stream_lhs.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:349:45: ( PLUS )?
                        if ( stream_PLUS.hasNext() ) {
                            adaptor.addChild(root_1, stream_PLUS.nextNode());

                        }
                        stream_PLUS.reset();
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:349:51: ^( LIST ( assignOrInitExpr )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                        if ( !(stream_assignOrInitExpr.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_assignOrInitExpr.hasNext() ) {
                            adaptor.addChild(root_2, stream_assignOrInitExpr.nextTree());

                        }
                        stream_assignOrInitExpr.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "assignStmt"

    public static class assignOrInitExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignOrInitExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:352:1: assignOrInitExpr : ( assignExpr | initList );
    public final EulangParser.assignOrInitExpr_return assignOrInitExpr() throws RecognitionException {
        EulangParser.assignOrInitExpr_return retval = new EulangParser.assignOrInitExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.assignExpr_return assignExpr243 = null;

        EulangParser.initList_return initList244 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:352:18: ( assignExpr | initList )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==CODE||(LA80_0>=SIZEOF && LA80_0<=TYPEOF)||LA80_0==ID||LA80_0==COLON||LA80_0==LPAREN||LA80_0==NIL||LA80_0==IF||LA80_0==NOT||(LA80_0>=TILDE && LA80_0<=AMP)||LA80_0==MINUS||(LA80_0>=PLUSPLUS && LA80_0<=STRING_LITERAL)||(LA80_0>=FALSE && LA80_0<=COLONS)) ) {
                alt80=1;
            }
            else if ( (LA80_0==LBRACKET) ) {
                alt80=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:352:20: assignExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignExpr_in_assignOrInitExpr3434);
                    assignExpr243=assignExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignExpr243.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:352:33: initList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_initList_in_assignOrInitExpr3438);
                    initList244=initList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, initList244.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "assignOrInitExpr"

    public static class assignExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:355:1: assignExpr : ( ( lhs assignEqOp )=> lhs assignEqOp assignExpr -> ^( ASSIGN assignEqOp lhs assignExpr ) | ( idTuple EQUALS )=> idTuple EQUALS assignExpr -> ^( ASSIGN EQUALS idTuple assignExpr ) | rhsExpr -> rhsExpr );
    public final EulangParser.assignExpr_return assignExpr() throws RecognitionException {
        EulangParser.assignExpr_return retval = new EulangParser.assignExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS249=null;
        EulangParser.lhs_return lhs245 = null;

        EulangParser.assignEqOp_return assignEqOp246 = null;

        EulangParser.assignExpr_return assignExpr247 = null;

        EulangParser.idTuple_return idTuple248 = null;

        EulangParser.assignExpr_return assignExpr250 = null;

        EulangParser.rhsExpr_return rhsExpr251 = null;


        CommonTree EQUALS249_tree=null;
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleSubtreeStream stream_idTuple=new RewriteRuleSubtreeStream(adaptor,"rule idTuple");
        RewriteRuleSubtreeStream stream_assignEqOp=new RewriteRuleSubtreeStream(adaptor,"rule assignEqOp");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:355:12: ( ( lhs assignEqOp )=> lhs assignEqOp assignExpr -> ^( ASSIGN assignEqOp lhs assignExpr ) | ( idTuple EQUALS )=> idTuple EQUALS assignExpr -> ^( ASSIGN EQUALS idTuple assignExpr ) | rhsExpr -> rhsExpr )
            int alt81=3;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:355:14: ( lhs assignEqOp )=> lhs assignEqOp assignExpr
                    {
                    pushFollow(FOLLOW_lhs_in_assignExpr3456);
                    lhs245=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(lhs245.getTree());
                    pushFollow(FOLLOW_assignEqOp_in_assignExpr3458);
                    assignEqOp246=assignEqOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignEqOp.add(assignEqOp246.getTree());
                    pushFollow(FOLLOW_assignExpr_in_assignExpr3460);
                    assignExpr247=assignExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignExpr.add(assignExpr247.getTree());


                    // AST REWRITE
                    // elements: assignExpr, assignEqOp, lhs
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 355:67: -> ^( ASSIGN assignEqOp lhs assignExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:355:70: ^( ASSIGN assignEqOp lhs assignExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_assignEqOp.nextTree());
                        adaptor.addChild(root_1, stream_lhs.nextTree());
                        adaptor.addChild(root_1, stream_assignExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:356:7: ( idTuple EQUALS )=> idTuple EQUALS assignExpr
                    {
                    pushFollow(FOLLOW_idTuple_in_assignExpr3495);
                    idTuple248=idTuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_idTuple.add(idTuple248.getTree());
                    EQUALS249=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_assignExpr3497); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS249);

                    pushFollow(FOLLOW_assignExpr_in_assignExpr3499);
                    assignExpr250=assignExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignExpr.add(assignExpr250.getTree());


                    // AST REWRITE
                    // elements: EQUALS, idTuple, assignExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 356:67: -> ^( ASSIGN EQUALS idTuple assignExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:356:70: ^( ASSIGN EQUALS idTuple assignExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ASSIGN, "ASSIGN"), root_1);

                        adaptor.addChild(root_1, stream_EQUALS.nextNode());
                        adaptor.addChild(root_1, stream_idTuple.nextTree());
                        adaptor.addChild(root_1, stream_assignExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:357:7: rhsExpr
                    {
                    pushFollow(FOLLOW_rhsExpr_in_assignExpr3533);
                    rhsExpr251=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr251.getTree());


                    // AST REWRITE
                    // elements: rhsExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 357:43: -> rhsExpr
                    {
                        adaptor.addChild(root_0, stream_rhsExpr.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "assignExpr"

    public static class assignOp_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignOp"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:360:1: assignOp : ( PLUS_EQ | MINUS_EQ | STAR_EQ | SLASH_EQ | REM_EQ | UDIV_EQ | UREM_EQ | MOD_EQ | AND_EQ | OR_EQ | XOR_EQ | LSHIFT_EQ | RSHIFT_EQ | URSHIFT_EQ | CLSHIFT_EQ | CRSHIFT_EQ );
    public final EulangParser.assignOp_return assignOp() throws RecognitionException {
        EulangParser.assignOp_return retval = new EulangParser.assignOp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set252=null;

        CommonTree set252_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:360:10: ( PLUS_EQ | MINUS_EQ | STAR_EQ | SLASH_EQ | REM_EQ | UDIV_EQ | UREM_EQ | MOD_EQ | AND_EQ | OR_EQ | XOR_EQ | LSHIFT_EQ | RSHIFT_EQ | URSHIFT_EQ | CLSHIFT_EQ | CRSHIFT_EQ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set252=(Token)input.LT(1);
            if ( input.LA(1)==PLUS_EQ||(input.LA(1)>=MINUS_EQ && input.LA(1)<=CRSHIFT_EQ) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set252));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "assignOp"

    public static class assignEqOp_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignEqOp"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:362:1: assignEqOp : ( EQUALS | assignOp );
    public final EulangParser.assignEqOp_return assignEqOp() throws RecognitionException {
        EulangParser.assignEqOp_return retval = new EulangParser.assignEqOp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS253=null;
        EulangParser.assignOp_return assignOp254 = null;


        CommonTree EQUALS253_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:362:12: ( EQUALS | assignOp )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==EQUALS) ) {
                alt82=1;
            }
            else if ( (LA82_0==PLUS_EQ||(LA82_0>=MINUS_EQ && LA82_0<=CRSHIFT_EQ)) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:362:14: EQUALS
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EQUALS253=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_assignEqOp3648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQUALS253_tree = (CommonTree)adaptor.create(EQUALS253);
                    adaptor.addChild(root_0, EQUALS253_tree);
                    }

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:362:23: assignOp
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assignOp_in_assignEqOp3652);
                    assignOp254=assignOp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignOp254.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "assignEqOp"

    public static class initList_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "initList"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:1: initList : LBRACKET ( initExpr ( COMMA initExpr )* )? RBRACKET -> ^( INITLIST ( initExpr )* ) ;
    public final EulangParser.initList_return initList() throws RecognitionException {
        EulangParser.initList_return retval = new EulangParser.initList_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET255=null;
        Token COMMA257=null;
        Token RBRACKET259=null;
        EulangParser.initExpr_return initExpr256 = null;

        EulangParser.initExpr_return initExpr258 = null;


        CommonTree LBRACKET255_tree=null;
        CommonTree COMMA257_tree=null;
        CommonTree RBRACKET259_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_initExpr=new RewriteRuleSubtreeStream(adaptor,"rule initExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:10: ( LBRACKET ( initExpr ( COMMA initExpr )* )? RBRACKET -> ^( INITLIST ( initExpr )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:12: LBRACKET ( initExpr ( COMMA initExpr )* )? RBRACKET
            {
            LBRACKET255=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_initList3661); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET255);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:21: ( initExpr ( COMMA initExpr )* )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==CODE||(LA84_0>=SIZEOF && LA84_0<=TYPEOF)||LA84_0==ID||LA84_0==COLON||LA84_0==LBRACKET||LA84_0==LPAREN||LA84_0==NIL||LA84_0==PERIOD||LA84_0==IF||LA84_0==NOT||(LA84_0>=TILDE && LA84_0<=AMP)||LA84_0==MINUS||(LA84_0>=PLUSPLUS && LA84_0<=STRING_LITERAL)||(LA84_0>=FALSE && LA84_0<=COLONS)) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:22: initExpr ( COMMA initExpr )*
                    {
                    pushFollow(FOLLOW_initExpr_in_initList3664);
                    initExpr256=initExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_initExpr.add(initExpr256.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:31: ( COMMA initExpr )*
                    loop83:
                    do {
                        int alt83=2;
                        int LA83_0 = input.LA(1);

                        if ( (LA83_0==COMMA) ) {
                            alt83=1;
                        }


                        switch (alt83) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:32: COMMA initExpr
                    	    {
                    	    COMMA257=(Token)match(input,COMMA,FOLLOW_COMMA_in_initList3667); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA257);

                    	    pushFollow(FOLLOW_initExpr_in_initList3669);
                    	    initExpr258=initExpr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_initExpr.add(initExpr258.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop83;
                        }
                    } while (true);


                    }
                    break;

            }

            RBRACKET259=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_initList3675); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET259);



            // AST REWRITE
            // elements: initExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 364:64: -> ^( INITLIST ( initExpr )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:67: ^( INITLIST ( initExpr )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INITLIST, "INITLIST"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:364:78: ( initExpr )*
                while ( stream_initExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_initExpr.nextTree());

                }
                stream_initExpr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "initList"

    public static class initExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "initExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:365:1: initExpr : ( ( rhsExpr )=>e= rhsExpr -> ^( INITEXPR $e) | PERIOD ID EQUALS ei= initElement -> ^( INITEXPR $ei ID ) | ( LBRACKET i= rhsExpr RBRACKET )=> LBRACKET i= rhsExpr RBRACKET EQUALS ei= initElement -> ^( INITEXPR $ei $i) | initList );
    public final EulangParser.initExpr_return initExpr() throws RecognitionException {
        EulangParser.initExpr_return retval = new EulangParser.initExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PERIOD260=null;
        Token ID261=null;
        Token EQUALS262=null;
        Token LBRACKET263=null;
        Token RBRACKET264=null;
        Token EQUALS265=null;
        EulangParser.rhsExpr_return e = null;

        EulangParser.initElement_return ei = null;

        EulangParser.rhsExpr_return i = null;

        EulangParser.initList_return initList266 = null;


        CommonTree PERIOD260_tree=null;
        CommonTree ID261_tree=null;
        CommonTree EQUALS262_tree=null;
        CommonTree LBRACKET263_tree=null;
        CommonTree RBRACKET264_tree=null;
        CommonTree EQUALS265_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_EQUALS=new RewriteRuleTokenStream(adaptor,"token EQUALS");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_initElement=new RewriteRuleSubtreeStream(adaptor,"rule initElement");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:366:5: ( ( rhsExpr )=>e= rhsExpr -> ^( INITEXPR $e) | PERIOD ID EQUALS ei= initElement -> ^( INITEXPR $ei ID ) | ( LBRACKET i= rhsExpr RBRACKET )=> LBRACKET i= rhsExpr RBRACKET EQUALS ei= initElement -> ^( INITEXPR $ei $i) | initList )
            int alt85=4;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:366:7: ( rhsExpr )=>e= rhsExpr
                    {
                    pushFollow(FOLLOW_rhsExpr_in_initExpr3710);
                    e=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExpr.add(e.getTree());


                    // AST REWRITE
                    // elements: e
                    // token labels: 
                    // rule labels: retval, e
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 366:75: -> ^( INITEXPR $e)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:366:78: ^( INITEXPR $e)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INITEXPR, "INITEXPR"), root_1);

                        adaptor.addChild(root_1, stream_e.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:367:7: PERIOD ID EQUALS ei= initElement
                    {
                    PERIOD260=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_initExpr3773); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD260);

                    ID261=(Token)match(input,ID,FOLLOW_ID_in_initExpr3775); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID261);

                    EQUALS262=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_initExpr3777); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS262);

                    pushFollow(FOLLOW_initElement_in_initExpr3781);
                    ei=initElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_initElement.add(ei.getTree());


                    // AST REWRITE
                    // elements: ei, ID
                    // token labels: 
                    // rule labels: retval, ei
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ei=new RewriteRuleSubtreeStream(adaptor,"rule ei",ei!=null?ei.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 367:72: -> ^( INITEXPR $ei ID )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:367:75: ^( INITEXPR $ei ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INITEXPR, "INITEXPR"), root_1);

                        adaptor.addChild(root_1, stream_ei.nextTree());
                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:368:7: ( LBRACKET i= rhsExpr RBRACKET )=> LBRACKET i= rhsExpr RBRACKET EQUALS ei= initElement
                    {
                    LBRACKET263=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_initExpr3846); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET263);

                    pushFollow(FOLLOW_rhsExpr_in_initExpr3850);
                    i=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExpr.add(i.getTree());
                    RBRACKET264=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_initExpr3852); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET264);

                    EQUALS265=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_initExpr3854); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EQUALS.add(EQUALS265);

                    pushFollow(FOLLOW_initElement_in_initExpr3858);
                    ei=initElement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_initElement.add(ei.getTree());


                    // AST REWRITE
                    // elements: ei, i
                    // token labels: 
                    // rule labels: retval, ei, i
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_ei=new RewriteRuleSubtreeStream(adaptor,"rule ei",ei!=null?ei.tree:null);
                    RewriteRuleSubtreeStream stream_i=new RewriteRuleSubtreeStream(adaptor,"rule i",i!=null?i.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 368:107: -> ^( INITEXPR $ei $i)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:368:110: ^( INITEXPR $ei $i)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INITEXPR, "INITEXPR"), root_1);

                        adaptor.addChild(root_1, stream_ei.nextTree());
                        adaptor.addChild(root_1, stream_i.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:369:7: initList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_initList_in_initExpr3895);
                    initList266=initList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, initList266.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "initExpr"

    public static class initElement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "initElement"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:372:1: initElement : ( rhsExpr | initList );
    public final EulangParser.initElement_return initElement() throws RecognitionException {
        EulangParser.initElement_return retval = new EulangParser.initElement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.rhsExpr_return rhsExpr267 = null;

        EulangParser.initList_return initList268 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:372:13: ( rhsExpr | initList )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==CODE||(LA86_0>=SIZEOF && LA86_0<=TYPEOF)||LA86_0==ID||LA86_0==COLON||LA86_0==LPAREN||LA86_0==NIL||LA86_0==IF||LA86_0==NOT||(LA86_0>=TILDE && LA86_0<=AMP)||LA86_0==MINUS||(LA86_0>=PLUSPLUS && LA86_0<=STRING_LITERAL)||(LA86_0>=FALSE && LA86_0<=COLONS)) ) {
                alt86=1;
            }
            else if ( (LA86_0==LBRACKET) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:372:15: rhsExpr
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_rhsExpr_in_initElement3909);
                    rhsExpr267=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, rhsExpr267.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:372:25: initList
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_initList_in_initElement3913);
                    initList268=initList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, initList268.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "initElement"

    public static class controlStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "controlStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:374:1: controlStmt : ( doWhile | whileDo | repeat | forIter );
    public final EulangParser.controlStmt_return controlStmt() throws RecognitionException {
        EulangParser.controlStmt_return retval = new EulangParser.controlStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.doWhile_return doWhile269 = null;

        EulangParser.whileDo_return whileDo270 = null;

        EulangParser.repeat_return repeat271 = null;

        EulangParser.forIter_return forIter272 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:374:13: ( doWhile | whileDo | repeat | forIter )
            int alt87=4;
            switch ( input.LA(1) ) {
            case DO:
                {
                alt87=1;
                }
                break;
            case WHILE:
                {
                alt87=2;
                }
                break;
            case REPEAT:
                {
                alt87=3;
                }
                break;
            case FOR:
                {
                alt87=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:374:15: doWhile
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_doWhile_in_controlStmt3925);
                    doWhile269=doWhile();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, doWhile269.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:374:25: whileDo
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_whileDo_in_controlStmt3929);
                    whileDo270=whileDo();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileDo270.getTree());

                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:374:35: repeat
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_repeat_in_controlStmt3933);
                    repeat271=repeat();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, repeat271.getTree());

                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:374:44: forIter
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_forIter_in_controlStmt3937);
                    forIter272=forIter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forIter272.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "controlStmt"

    public static class doWhile_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "doWhile"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:376:1: doWhile : DO codeStmtExpr WHILE rhsExpr -> ^( DO codeStmtExpr rhsExpr ) ;
    public final EulangParser.doWhile_return doWhile() throws RecognitionException {
        EulangParser.doWhile_return retval = new EulangParser.doWhile_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DO273=null;
        Token WHILE275=null;
        EulangParser.codeStmtExpr_return codeStmtExpr274 = null;

        EulangParser.rhsExpr_return rhsExpr276 = null;


        CommonTree DO273_tree=null;
        CommonTree WHILE275_tree=null;
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleSubtreeStream stream_codeStmtExpr=new RewriteRuleSubtreeStream(adaptor,"rule codeStmtExpr");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:376:9: ( DO codeStmtExpr WHILE rhsExpr -> ^( DO codeStmtExpr rhsExpr ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:376:11: DO codeStmtExpr WHILE rhsExpr
            {
            DO273=(Token)match(input,DO,FOLLOW_DO_in_doWhile3946); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DO.add(DO273);

            pushFollow(FOLLOW_codeStmtExpr_in_doWhile3948);
            codeStmtExpr274=codeStmtExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_codeStmtExpr.add(codeStmtExpr274.getTree());
            WHILE275=(Token)match(input,WHILE,FOLLOW_WHILE_in_doWhile3950); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHILE.add(WHILE275);

            pushFollow(FOLLOW_rhsExpr_in_doWhile3952);
            rhsExpr276=rhsExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr276.getTree());


            // AST REWRITE
            // elements: rhsExpr, codeStmtExpr, DO
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 376:43: -> ^( DO codeStmtExpr rhsExpr )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:376:46: ^( DO codeStmtExpr rhsExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_DO.nextNode(), root_1);

                adaptor.addChild(root_1, stream_codeStmtExpr.nextTree());
                adaptor.addChild(root_1, stream_rhsExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "doWhile"

    public static class whileDo_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileDo"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:379:1: whileDo : WHILE rhsExpr DO codeStmtExpr -> ^( WHILE rhsExpr codeStmtExpr ) ;
    public final EulangParser.whileDo_return whileDo() throws RecognitionException {
        EulangParser.whileDo_return retval = new EulangParser.whileDo_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHILE277=null;
        Token DO279=null;
        EulangParser.rhsExpr_return rhsExpr278 = null;

        EulangParser.codeStmtExpr_return codeStmtExpr280 = null;


        CommonTree WHILE277_tree=null;
        CommonTree DO279_tree=null;
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleSubtreeStream stream_codeStmtExpr=new RewriteRuleSubtreeStream(adaptor,"rule codeStmtExpr");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:379:9: ( WHILE rhsExpr DO codeStmtExpr -> ^( WHILE rhsExpr codeStmtExpr ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:379:11: WHILE rhsExpr DO codeStmtExpr
            {
            WHILE277=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileDo3975); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHILE.add(WHILE277);

            pushFollow(FOLLOW_rhsExpr_in_whileDo3977);
            rhsExpr278=rhsExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr278.getTree());
            DO279=(Token)match(input,DO,FOLLOW_DO_in_whileDo3979); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DO.add(DO279);

            pushFollow(FOLLOW_codeStmtExpr_in_whileDo3981);
            codeStmtExpr280=codeStmtExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_codeStmtExpr.add(codeStmtExpr280.getTree());


            // AST REWRITE
            // elements: rhsExpr, WHILE, codeStmtExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 379:43: -> ^( WHILE rhsExpr codeStmtExpr )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:379:46: ^( WHILE rhsExpr codeStmtExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_WHILE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_rhsExpr.nextTree());
                adaptor.addChild(root_1, stream_codeStmtExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "whileDo"

    public static class repeat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "repeat"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:382:1: repeat : REPEAT rhsExpr DO codeStmt -> ^( REPEAT rhsExpr codeStmt ) ;
    public final EulangParser.repeat_return repeat() throws RecognitionException {
        EulangParser.repeat_return retval = new EulangParser.repeat_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REPEAT281=null;
        Token DO283=null;
        EulangParser.rhsExpr_return rhsExpr282 = null;

        EulangParser.codeStmt_return codeStmt284 = null;


        CommonTree REPEAT281_tree=null;
        CommonTree DO283_tree=null;
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_REPEAT=new RewriteRuleTokenStream(adaptor,"token REPEAT");
        RewriteRuleSubtreeStream stream_codeStmt=new RewriteRuleSubtreeStream(adaptor,"rule codeStmt");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:382:8: ( REPEAT rhsExpr DO codeStmt -> ^( REPEAT rhsExpr codeStmt ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:382:10: REPEAT rhsExpr DO codeStmt
            {
            REPEAT281=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_repeat4006); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_REPEAT.add(REPEAT281);

            pushFollow(FOLLOW_rhsExpr_in_repeat4008);
            rhsExpr282=rhsExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr282.getTree());
            DO283=(Token)match(input,DO,FOLLOW_DO_in_repeat4010); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DO.add(DO283);

            pushFollow(FOLLOW_codeStmt_in_repeat4012);
            codeStmt284=codeStmt();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_codeStmt.add(codeStmt284.getTree());


            // AST REWRITE
            // elements: codeStmt, REPEAT, rhsExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 382:45: -> ^( REPEAT rhsExpr codeStmt )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:382:48: ^( REPEAT rhsExpr codeStmt )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_REPEAT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_rhsExpr.nextTree());
                adaptor.addChild(root_1, stream_codeStmt.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "repeat"

    public static class forIter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forIter"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:1: forIter : FOR forIds ( forMovement )? IN rhsExpr DO codeStmt -> ^( FOR ^( LIST forIds ) ( forMovement )? rhsExpr codeStmt ) ;
    public final EulangParser.forIter_return forIter() throws RecognitionException {
        EulangParser.forIter_return retval = new EulangParser.forIter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FOR285=null;
        Token IN288=null;
        Token DO290=null;
        EulangParser.forIds_return forIds286 = null;

        EulangParser.forMovement_return forMovement287 = null;

        EulangParser.rhsExpr_return rhsExpr289 = null;

        EulangParser.codeStmt_return codeStmt291 = null;


        CommonTree FOR285_tree=null;
        CommonTree IN288_tree=null;
        CommonTree DO290_tree=null;
        RewriteRuleTokenStream stream_FOR=new RewriteRuleTokenStream(adaptor,"token FOR");
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleTokenStream stream_IN=new RewriteRuleTokenStream(adaptor,"token IN");
        RewriteRuleSubtreeStream stream_forMovement=new RewriteRuleSubtreeStream(adaptor,"rule forMovement");
        RewriteRuleSubtreeStream stream_codeStmt=new RewriteRuleSubtreeStream(adaptor,"rule codeStmt");
        RewriteRuleSubtreeStream stream_forIds=new RewriteRuleSubtreeStream(adaptor,"rule forIds");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:9: ( FOR forIds ( forMovement )? IN rhsExpr DO codeStmt -> ^( FOR ^( LIST forIds ) ( forMovement )? rhsExpr codeStmt ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:11: FOR forIds ( forMovement )? IN rhsExpr DO codeStmt
            {
            FOR285=(Token)match(input,FOR,FOLLOW_FOR_in_forIter4042); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FOR.add(FOR285);

            pushFollow(FOLLOW_forIds_in_forIter4044);
            forIds286=forIds();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_forIds.add(forIds286.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:22: ( forMovement )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( ((LA88_0>=BY && LA88_0<=AT)) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:22: forMovement
                    {
                    pushFollow(FOLLOW_forMovement_in_forIter4046);
                    forMovement287=forMovement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_forMovement.add(forMovement287.getTree());

                    }
                    break;

            }

            IN288=(Token)match(input,IN,FOLLOW_IN_in_forIter4049); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IN.add(IN288);

            pushFollow(FOLLOW_rhsExpr_in_forIter4051);
            rhsExpr289=rhsExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr289.getTree());
            DO290=(Token)match(input,DO,FOLLOW_DO_in_forIter4053); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DO.add(DO290);

            pushFollow(FOLLOW_codeStmt_in_forIter4055);
            codeStmt291=codeStmt();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_codeStmt.add(codeStmt291.getTree());


            // AST REWRITE
            // elements: codeStmt, forIds, forMovement, FOR, rhsExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 385:64: -> ^( FOR ^( LIST forIds ) ( forMovement )? rhsExpr codeStmt )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:67: ^( FOR ^( LIST forIds ) ( forMovement )? rhsExpr codeStmt )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_FOR.nextNode(), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:73: ^( LIST forIds )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_2);

                adaptor.addChild(root_2, stream_forIds.nextTree());

                adaptor.addChild(root_1, root_2);
                }
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:385:88: ( forMovement )?
                if ( stream_forMovement.hasNext() ) {
                    adaptor.addChild(root_1, stream_forMovement.nextTree());

                }
                stream_forMovement.reset();
                adaptor.addChild(root_1, stream_rhsExpr.nextTree());
                adaptor.addChild(root_1, stream_codeStmt.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "forIter"

    public static class forIds_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forIds"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:388:1: forIds : ID ( AND ID )* -> ( ID )+ ;
    public final EulangParser.forIds_return forIds() throws RecognitionException {
        EulangParser.forIds_return retval = new EulangParser.forIds_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID292=null;
        Token AND293=null;
        Token ID294=null;

        CommonTree ID292_tree=null;
        CommonTree AND293_tree=null;
        CommonTree ID294_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:388:8: ( ID ( AND ID )* -> ( ID )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:388:10: ID ( AND ID )*
            {
            ID292=(Token)match(input,ID,FOLLOW_ID_in_forIds4092); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID292);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:388:13: ( AND ID )*
            loop89:
            do {
                int alt89=2;
                int LA89_0 = input.LA(1);

                if ( (LA89_0==AND) ) {
                    alt89=1;
                }


                switch (alt89) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:388:14: AND ID
            	    {
            	    AND293=(Token)match(input,AND,FOLLOW_AND_in_forIds4095); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND293);

            	    ID294=(Token)match(input,ID,FOLLOW_ID_in_forIds4097); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID294);


            	    }
            	    break;

            	default :
            	    break loop89;
                }
            } while (true);



            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 388:23: -> ( ID )+
            {
                if ( !(stream_ID.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ID.hasNext() ) {
                    adaptor.addChild(root_0, stream_ID.nextNode());

                }
                stream_ID.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "forIds"

    public static class forMovement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forMovement"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:390:1: forMovement : ( atId | stepping );
    public final EulangParser.forMovement_return forMovement() throws RecognitionException {
        EulangParser.forMovement_return retval = new EulangParser.forMovement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.atId_return atId295 = null;

        EulangParser.stepping_return stepping296 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:390:13: ( atId | stepping )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==AT) ) {
                alt90=1;
            }
            else if ( (LA90_0==BY) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:390:15: atId
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atId_in_forMovement4113);
                    atId295=atId();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atId295.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:390:22: stepping
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_stepping_in_forMovement4117);
                    stepping296=stepping();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stepping296.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "forMovement"

    public static class stepping_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stepping"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:392:1: stepping : BY rhsExpr -> ^( BY rhsExpr ) ;
    public final EulangParser.stepping_return stepping() throws RecognitionException {
        EulangParser.stepping_return retval = new EulangParser.stepping_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BY297=null;
        EulangParser.rhsExpr_return rhsExpr298 = null;


        CommonTree BY297_tree=null;
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:392:10: ( BY rhsExpr -> ^( BY rhsExpr ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:392:12: BY rhsExpr
            {
            BY297=(Token)match(input,BY,FOLLOW_BY_in_stepping4126); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BY.add(BY297);

            pushFollow(FOLLOW_rhsExpr_in_stepping4128);
            rhsExpr298=rhsExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr298.getTree());


            // AST REWRITE
            // elements: rhsExpr, BY
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 392:23: -> ^( BY rhsExpr )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:392:26: ^( BY rhsExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_BY.nextNode(), root_1);

                adaptor.addChild(root_1, stream_rhsExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "stepping"

    public static class atId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atId"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:394:1: atId : AT ID -> ^( AT ID ) ;
    public final EulangParser.atId_return atId() throws RecognitionException {
        EulangParser.atId_return retval = new EulangParser.atId_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AT299=null;
        Token ID300=null;

        CommonTree AT299_tree=null;
        CommonTree ID300_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:394:6: ( AT ID -> ^( AT ID ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:394:8: AT ID
            {
            AT299=(Token)match(input,AT,FOLLOW_AT_in_atId4145); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_AT.add(AT299);

            ID300=(Token)match(input,ID,FOLLOW_ID_in_atId4147); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID300);



            // AST REWRITE
            // elements: ID, AT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 394:17: -> ^( AT ID )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:394:20: ^( AT ID )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_AT.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "atId"

    public static class breakStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "breakStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:398:1: breakStmt : BREAK rhsExpr -> ^( BREAK rhsExpr ) ;
    public final EulangParser.breakStmt_return breakStmt() throws RecognitionException {
        EulangParser.breakStmt_return retval = new EulangParser.breakStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BREAK301=null;
        EulangParser.rhsExpr_return rhsExpr302 = null;


        CommonTree BREAK301_tree=null;
        RewriteRuleTokenStream stream_BREAK=new RewriteRuleTokenStream(adaptor,"token BREAK");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:398:11: ( BREAK rhsExpr -> ^( BREAK rhsExpr ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:398:13: BREAK rhsExpr
            {
            BREAK301=(Token)match(input,BREAK,FOLLOW_BREAK_in_breakStmt4175); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BREAK.add(BREAK301);

            pushFollow(FOLLOW_rhsExpr_in_breakStmt4177);
            rhsExpr302=rhsExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr302.getTree());


            // AST REWRITE
            // elements: rhsExpr, BREAK
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 398:27: -> ^( BREAK rhsExpr )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:398:31: ^( BREAK rhsExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_BREAK.nextNode(), root_1);

                adaptor.addChild(root_1, stream_rhsExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "breakStmt"

    public static class labelStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "labelStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:406:1: labelStmt : ATSIGN ID COLON -> ^( LABEL ID ) ;
    public final EulangParser.labelStmt_return labelStmt() throws RecognitionException {
        EulangParser.labelStmt_return retval = new EulangParser.labelStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ATSIGN303=null;
        Token ID304=null;
        Token COLON305=null;

        CommonTree ATSIGN303_tree=null;
        CommonTree ID304_tree=null;
        CommonTree COLON305_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_ATSIGN=new RewriteRuleTokenStream(adaptor,"token ATSIGN");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:406:10: ( ATSIGN ID COLON -> ^( LABEL ID ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:406:12: ATSIGN ID COLON
            {
            ATSIGN303=(Token)match(input,ATSIGN,FOLLOW_ATSIGN_in_labelStmt4205); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ATSIGN.add(ATSIGN303);

            ID304=(Token)match(input,ID,FOLLOW_ID_in_labelStmt4207); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID304);

            COLON305=(Token)match(input,COLON,FOLLOW_COLON_in_labelStmt4209); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON305);



            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 406:47: -> ^( LABEL ID )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:406:50: ^( LABEL ID )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LABEL, "LABEL"), root_1);

                adaptor.addChild(root_1, stream_ID.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "labelStmt"

    public static class gotoStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gotoStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:408:1: gotoStmt : GOTO idOrScopeRef ( IF rhsExpr )? -> ^( GOTO idOrScopeRef ( rhsExpr )? ) ;
    public final EulangParser.gotoStmt_return gotoStmt() throws RecognitionException {
        EulangParser.gotoStmt_return retval = new EulangParser.gotoStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GOTO306=null;
        Token IF308=null;
        EulangParser.idOrScopeRef_return idOrScopeRef307 = null;

        EulangParser.rhsExpr_return rhsExpr309 = null;


        CommonTree GOTO306_tree=null;
        CommonTree IF308_tree=null;
        RewriteRuleTokenStream stream_GOTO=new RewriteRuleTokenStream(adaptor,"token GOTO");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_idOrScopeRef=new RewriteRuleSubtreeStream(adaptor,"rule idOrScopeRef");
        RewriteRuleSubtreeStream stream_rhsExpr=new RewriteRuleSubtreeStream(adaptor,"rule rhsExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:408:9: ( GOTO idOrScopeRef ( IF rhsExpr )? -> ^( GOTO idOrScopeRef ( rhsExpr )? ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:408:11: GOTO idOrScopeRef ( IF rhsExpr )?
            {
            GOTO306=(Token)match(input,GOTO,FOLLOW_GOTO_in_gotoStmt4245); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GOTO.add(GOTO306);

            pushFollow(FOLLOW_idOrScopeRef_in_gotoStmt4247);
            idOrScopeRef307=idOrScopeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_idOrScopeRef.add(idOrScopeRef307.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:408:29: ( IF rhsExpr )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==IF) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:408:30: IF rhsExpr
                    {
                    IF308=(Token)match(input,IF,FOLLOW_IF_in_gotoStmt4250); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF.add(IF308);

                    pushFollow(FOLLOW_rhsExpr_in_gotoStmt4252);
                    rhsExpr309=rhsExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rhsExpr.add(rhsExpr309.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: GOTO, rhsExpr, idOrScopeRef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 408:53: -> ^( GOTO idOrScopeRef ( rhsExpr )? )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:408:56: ^( GOTO idOrScopeRef ( rhsExpr )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_GOTO.nextNode(), root_1);

                adaptor.addChild(root_1, stream_idOrScopeRef.nextTree());
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:408:76: ( rhsExpr )?
                if ( stream_rhsExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_rhsExpr.nextTree());

                }
                stream_rhsExpr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "gotoStmt"

    public static class blockStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blockStmt"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:411:1: blockStmt : LBRACE codestmtlist RBRACE -> ^( BLOCK codestmtlist ) ;
    public final EulangParser.blockStmt_return blockStmt() throws RecognitionException {
        EulangParser.blockStmt_return retval = new EulangParser.blockStmt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE310=null;
        Token RBRACE312=null;
        EulangParser.codestmtlist_return codestmtlist311 = null;


        CommonTree LBRACE310_tree=null;
        CommonTree RBRACE312_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_codestmtlist=new RewriteRuleSubtreeStream(adaptor,"rule codestmtlist");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:411:10: ( LBRACE codestmtlist RBRACE -> ^( BLOCK codestmtlist ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:411:12: LBRACE codestmtlist RBRACE
            {
            LBRACE310=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_blockStmt4287); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE310);

            pushFollow(FOLLOW_codestmtlist_in_blockStmt4289);
            codestmtlist311=codestmtlist();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_codestmtlist.add(codestmtlist311.getTree());
            RBRACE312=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_blockStmt4291); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE312);



            // AST REWRITE
            // elements: codestmtlist
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 411:43: -> ^( BLOCK codestmtlist )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:411:46: ^( BLOCK codestmtlist )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BLOCK, "BLOCK"), root_1);

                adaptor.addChild(root_1, stream_codestmtlist.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "blockStmt"

    public static class tuple_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tuple"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:414:1: tuple : LPAREN tupleEntries RPAREN -> ^( TUPLE ( tupleEntries )+ ) ;
    public final EulangParser.tuple_return tuple() throws RecognitionException {
        EulangParser.tuple_return retval = new EulangParser.tuple_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAREN313=null;
        Token RPAREN315=null;
        EulangParser.tupleEntries_return tupleEntries314 = null;


        CommonTree LPAREN313_tree=null;
        CommonTree RPAREN315_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_tupleEntries=new RewriteRuleSubtreeStream(adaptor,"rule tupleEntries");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:414:7: ( LPAREN tupleEntries RPAREN -> ^( TUPLE ( tupleEntries )+ ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:414:9: LPAREN tupleEntries RPAREN
            {
            LPAREN313=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tuple4314); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN313);

            pushFollow(FOLLOW_tupleEntries_in_tuple4316);
            tupleEntries314=tupleEntries();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tupleEntries.add(tupleEntries314.getTree());
            RPAREN315=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tuple4318); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN315);



            // AST REWRITE
            // elements: tupleEntries
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 414:41: -> ^( TUPLE ( tupleEntries )+ )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:414:44: ^( TUPLE ( tupleEntries )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TUPLE, "TUPLE"), root_1);

                if ( !(stream_tupleEntries.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_tupleEntries.hasNext() ) {
                    adaptor.addChild(root_1, stream_tupleEntries.nextTree());

                }
                stream_tupleEntries.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "tuple"

    public static class tupleEntries_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tupleEntries"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:417:1: tupleEntries : assignExpr ( COMMA assignExpr )+ -> ( assignExpr )+ ;
    public final EulangParser.tupleEntries_return tupleEntries() throws RecognitionException {
        EulangParser.tupleEntries_return retval = new EulangParser.tupleEntries_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA317=null;
        EulangParser.assignExpr_return assignExpr316 = null;

        EulangParser.assignExpr_return assignExpr318 = null;


        CommonTree COMMA317_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:417:14: ( assignExpr ( COMMA assignExpr )+ -> ( assignExpr )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:417:16: assignExpr ( COMMA assignExpr )+
            {
            pushFollow(FOLLOW_assignExpr_in_tupleEntries4346);
            assignExpr316=assignExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignExpr.add(assignExpr316.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:417:27: ( COMMA assignExpr )+
            int cnt92=0;
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( (LA92_0==COMMA) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:417:28: COMMA assignExpr
            	    {
            	    COMMA317=(Token)match(input,COMMA,FOLLOW_COMMA_in_tupleEntries4349); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA317);

            	    pushFollow(FOLLOW_assignExpr_in_tupleEntries4351);
            	    assignExpr318=assignExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assignExpr.add(assignExpr318.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt92 >= 1 ) break loop92;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(92, input);
                        throw eee;
                }
                cnt92++;
            } while (true);



            // AST REWRITE
            // elements: assignExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 417:48: -> ( assignExpr )+
            {
                if ( !(stream_assignExpr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_assignExpr.hasNext() ) {
                    adaptor.addChild(root_0, stream_assignExpr.nextTree());

                }
                stream_assignExpr.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "tupleEntries"

    public static class idTuple_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idTuple"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:420:1: idTuple : LPAREN idTupleEntries RPAREN -> ^( TUPLE ( idTupleEntries )+ ) ;
    public final EulangParser.idTuple_return idTuple() throws RecognitionException {
        EulangParser.idTuple_return retval = new EulangParser.idTuple_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LPAREN319=null;
        Token RPAREN321=null;
        EulangParser.idTupleEntries_return idTupleEntries320 = null;


        CommonTree LPAREN319_tree=null;
        CommonTree RPAREN321_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_idTupleEntries=new RewriteRuleSubtreeStream(adaptor,"rule idTupleEntries");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:420:9: ( LPAREN idTupleEntries RPAREN -> ^( TUPLE ( idTupleEntries )+ ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:420:11: LPAREN idTupleEntries RPAREN
            {
            LPAREN319=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_idTuple4370); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN319);

            pushFollow(FOLLOW_idTupleEntries_in_idTuple4372);
            idTupleEntries320=idTupleEntries();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_idTupleEntries.add(idTupleEntries320.getTree());
            RPAREN321=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_idTuple4374); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN321);



            // AST REWRITE
            // elements: idTupleEntries
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 420:45: -> ^( TUPLE ( idTupleEntries )+ )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:420:48: ^( TUPLE ( idTupleEntries )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(TUPLE, "TUPLE"), root_1);

                if ( !(stream_idTupleEntries.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_idTupleEntries.hasNext() ) {
                    adaptor.addChild(root_1, stream_idTupleEntries.nextTree());

                }
                stream_idTupleEntries.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "idTuple"

    public static class idTupleEntries_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idTupleEntries"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:423:1: idTupleEntries : idOrScopeRef ( COMMA idOrScopeRef )+ -> ( idOrScopeRef )+ ;
    public final EulangParser.idTupleEntries_return idTupleEntries() throws RecognitionException {
        EulangParser.idTupleEntries_return retval = new EulangParser.idTupleEntries_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA323=null;
        EulangParser.idOrScopeRef_return idOrScopeRef322 = null;

        EulangParser.idOrScopeRef_return idOrScopeRef324 = null;


        CommonTree COMMA323_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_idOrScopeRef=new RewriteRuleSubtreeStream(adaptor,"rule idOrScopeRef");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:423:16: ( idOrScopeRef ( COMMA idOrScopeRef )+ -> ( idOrScopeRef )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:423:18: idOrScopeRef ( COMMA idOrScopeRef )+
            {
            pushFollow(FOLLOW_idOrScopeRef_in_idTupleEntries4402);
            idOrScopeRef322=idOrScopeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_idOrScopeRef.add(idOrScopeRef322.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:423:31: ( COMMA idOrScopeRef )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==COMMA) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:423:32: COMMA idOrScopeRef
            	    {
            	    COMMA323=(Token)match(input,COMMA,FOLLOW_COMMA_in_idTupleEntries4405); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA323);

            	    pushFollow(FOLLOW_idOrScopeRef_in_idTupleEntries4407);
            	    idOrScopeRef324=idOrScopeRef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_idOrScopeRef.add(idOrScopeRef324.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt93 >= 1 ) break loop93;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
            } while (true);



            // AST REWRITE
            // elements: idOrScopeRef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 423:54: -> ( idOrScopeRef )+
            {
                if ( !(stream_idOrScopeRef.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_idOrScopeRef.hasNext() ) {
                    adaptor.addChild(root_0, stream_idOrScopeRef.nextTree());

                }
                stream_idOrScopeRef.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "idTupleEntries"

    public static class rhsExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rhsExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:426:1: rhsExpr : condStar -> condStar ;
    public final EulangParser.rhsExpr_return rhsExpr() throws RecognitionException {
        EulangParser.rhsExpr_return retval = new EulangParser.rhsExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.condStar_return condStar325 = null;


        RewriteRuleSubtreeStream stream_condStar=new RewriteRuleSubtreeStream(adaptor,"rule condStar");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:426:9: ( condStar -> condStar )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:426:13: condStar
            {
            pushFollow(FOLLOW_condStar_in_rhsExpr4428);
            condStar325=condStar();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_condStar.add(condStar325.getTree());


            // AST REWRITE
            // elements: condStar
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 426:22: -> condStar
            {
                adaptor.addChild(root_0, stream_condStar.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "rhsExpr"

    public static class arglist_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arglist"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:1: arglist : ( arg ( COMMA arg )* ( COMMA )? )? -> ^( ARGLIST ( arg )* ) ;
    public final EulangParser.arglist_return arglist() throws RecognitionException {
        EulangParser.arglist_return retval = new EulangParser.arglist_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMA327=null;
        Token COMMA329=null;
        EulangParser.arg_return arg326 = null;

        EulangParser.arg_return arg328 = null;


        CommonTree COMMA327_tree=null;
        CommonTree COMMA329_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"rule arg");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:8: ( ( arg ( COMMA arg )* ( COMMA )? )? -> ^( ARGLIST ( arg )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:10: ( arg ( COMMA arg )* ( COMMA )? )?
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:10: ( arg ( COMMA arg )* ( COMMA )? )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==CODE||LA96_0==GOTO||(LA96_0>=SIZEOF && LA96_0<=TYPEOF)||LA96_0==ID||LA96_0==COLON||LA96_0==LBRACE||LA96_0==LPAREN||LA96_0==NIL||LA96_0==IF||LA96_0==NOT||(LA96_0>=TILDE && LA96_0<=AMP)||LA96_0==MINUS||(LA96_0>=PLUSPLUS && LA96_0<=STRING_LITERAL)||(LA96_0>=FALSE && LA96_0<=COLONS)) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:11: arg ( COMMA arg )* ( COMMA )?
                    {
                    pushFollow(FOLLOW_arg_in_arglist4449);
                    arg326=arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_arg.add(arg326.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:15: ( COMMA arg )*
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==COMMA) ) {
                            int LA94_1 = input.LA(2);

                            if ( (LA94_1==CODE||LA94_1==GOTO||(LA94_1>=SIZEOF && LA94_1<=TYPEOF)||LA94_1==ID||LA94_1==COLON||LA94_1==LBRACE||LA94_1==LPAREN||LA94_1==NIL||LA94_1==IF||LA94_1==NOT||(LA94_1>=TILDE && LA94_1<=AMP)||LA94_1==MINUS||(LA94_1>=PLUSPLUS && LA94_1<=STRING_LITERAL)||(LA94_1>=FALSE && LA94_1<=COLONS)) ) {
                                alt94=1;
                            }


                        }


                        switch (alt94) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:17: COMMA arg
                    	    {
                    	    COMMA327=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist4453); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA327);

                    	    pushFollow(FOLLOW_arg_in_arglist4455);
                    	    arg328=arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_arg.add(arg328.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop94;
                        }
                    } while (true);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:29: ( COMMA )?
                    int alt95=2;
                    int LA95_0 = input.LA(1);

                    if ( (LA95_0==COMMA) ) {
                        alt95=1;
                    }
                    switch (alt95) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:29: COMMA
                            {
                            COMMA329=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist4459); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA329);


                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: arg
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 429:61: -> ^( ARGLIST ( arg )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:64: ^( ARGLIST ( arg )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARGLIST, "ARGLIST"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:429:74: ( arg )*
                while ( stream_arg.hasNext() ) {
                    adaptor.addChild(root_1, stream_arg.nextTree());

                }
                stream_arg.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "arglist"

    public static class arg_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arg"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:432:1: arg : ( assignExpr -> ^( EXPR assignExpr ) | LBRACE codestmtlist RBRACE -> ^( EXPR ^( CODE codestmtlist ) ) | gotoStmt -> ^( EXPR gotoStmt ) );
    public final EulangParser.arg_return arg() throws RecognitionException {
        EulangParser.arg_return retval = new EulangParser.arg_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACE331=null;
        Token RBRACE333=null;
        EulangParser.assignExpr_return assignExpr330 = null;

        EulangParser.codestmtlist_return codestmtlist332 = null;

        EulangParser.gotoStmt_return gotoStmt334 = null;


        CommonTree LBRACE331_tree=null;
        CommonTree RBRACE333_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_gotoStmt=new RewriteRuleSubtreeStream(adaptor,"rule gotoStmt");
        RewriteRuleSubtreeStream stream_codestmtlist=new RewriteRuleSubtreeStream(adaptor,"rule codestmtlist");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:432:4: ( assignExpr -> ^( EXPR assignExpr ) | LBRACE codestmtlist RBRACE -> ^( EXPR ^( CODE codestmtlist ) ) | gotoStmt -> ^( EXPR gotoStmt ) )
            int alt97=3;
            switch ( input.LA(1) ) {
            case CODE:
            case SIZEOF:
            case TYPEOF:
            case ID:
            case COLON:
            case LPAREN:
            case NIL:
            case IF:
            case NOT:
            case TILDE:
            case AMP:
            case MINUS:
            case PLUSPLUS:
            case MINUSMINUS:
            case NUMBER:
            case CHAR_LITERAL:
            case STRING_LITERAL:
            case FALSE:
            case TRUE:
            case COLONS:
                {
                alt97=1;
                }
                break;
            case LBRACE:
                {
                alt97=2;
                }
                break;
            case GOTO:
                {
                alt97=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:432:7: assignExpr
                    {
                    pushFollow(FOLLOW_assignExpr_in_arg4508);
                    assignExpr330=assignExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignExpr.add(assignExpr330.getTree());


                    // AST REWRITE
                    // elements: assignExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 432:37: -> ^( EXPR assignExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:432:40: ^( EXPR assignExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR, "EXPR"), root_1);

                        adaptor.addChild(root_1, stream_assignExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:433:5: LBRACE codestmtlist RBRACE
                    {
                    LBRACE331=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_arg4541); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE331);

                    pushFollow(FOLLOW_codestmtlist_in_arg4543);
                    codestmtlist332=codestmtlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_codestmtlist.add(codestmtlist332.getTree());
                    RBRACE333=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_arg4545); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE333);



                    // AST REWRITE
                    // elements: codestmtlist
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 433:37: -> ^( EXPR ^( CODE codestmtlist ) )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:433:40: ^( EXPR ^( CODE codestmtlist ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR, "EXPR"), root_1);

                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:433:47: ^( CODE codestmtlist )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CODE, "CODE"), root_2);

                        adaptor.addChild(root_2, stream_codestmtlist.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:434:5: gotoStmt
                    {
                    pushFollow(FOLLOW_gotoStmt_in_arg4569);
                    gotoStmt334=gotoStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_gotoStmt.add(gotoStmt334.getTree());


                    // AST REWRITE
                    // elements: gotoStmt
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 434:37: -> ^( EXPR gotoStmt )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:434:40: ^( EXPR gotoStmt )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(EXPR, "EXPR"), root_1);

                        adaptor.addChild(root_1, stream_gotoStmt.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "arg"

    public static class condStar_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condStar"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:455:1: condStar : ( cond -> cond | IF ifExprs -> ifExprs );
    public final EulangParser.condStar_return condStar() throws RecognitionException {
        EulangParser.condStar_return retval = new EulangParser.condStar_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IF336=null;
        EulangParser.cond_return cond335 = null;

        EulangParser.ifExprs_return ifExprs337 = null;


        CommonTree IF336_tree=null;
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_ifExprs=new RewriteRuleSubtreeStream(adaptor,"rule ifExprs");
        RewriteRuleSubtreeStream stream_cond=new RewriteRuleSubtreeStream(adaptor,"rule cond");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:455:9: ( cond -> cond | IF ifExprs -> ifExprs )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==CODE||(LA98_0>=SIZEOF && LA98_0<=TYPEOF)||LA98_0==ID||LA98_0==COLON||LA98_0==LPAREN||LA98_0==NIL||LA98_0==NOT||(LA98_0>=TILDE && LA98_0<=AMP)||LA98_0==MINUS||(LA98_0>=PLUSPLUS && LA98_0<=STRING_LITERAL)||(LA98_0>=FALSE && LA98_0<=COLONS)) ) {
                alt98=1;
            }
            else if ( (LA98_0==IF) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:455:11: cond
                    {
                    pushFollow(FOLLOW_cond_in_condStar4630);
                    cond335=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_cond.add(cond335.getTree());


                    // AST REWRITE
                    // elements: cond
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 455:16: -> cond
                    {
                        adaptor.addChild(root_0, stream_cond.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:456:6: IF ifExprs
                    {
                    IF336=(Token)match(input,IF,FOLLOW_IF_in_condStar4641); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IF.add(IF336);

                    pushFollow(FOLLOW_ifExprs_in_condStar4643);
                    ifExprs337=ifExprs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ifExprs.add(ifExprs337.getTree());


                    // AST REWRITE
                    // elements: ifExprs
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 456:17: -> ifExprs
                    {
                        adaptor.addChild(root_0, stream_ifExprs.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "condStar"

    public static class ifExprs_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifExprs"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:462:1: ifExprs : thenClause elses -> ^( CONDLIST thenClause elses ) ;
    public final EulangParser.ifExprs_return ifExprs() throws RecognitionException {
        EulangParser.ifExprs_return retval = new EulangParser.ifExprs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.thenClause_return thenClause338 = null;

        EulangParser.elses_return elses339 = null;


        RewriteRuleSubtreeStream stream_thenClause=new RewriteRuleSubtreeStream(adaptor,"rule thenClause");
        RewriteRuleSubtreeStream stream_elses=new RewriteRuleSubtreeStream(adaptor,"rule elses");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:462:9: ( thenClause elses -> ^( CONDLIST thenClause elses ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:462:11: thenClause elses
            {
            pushFollow(FOLLOW_thenClause_in_ifExprs4662);
            thenClause338=thenClause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_thenClause.add(thenClause338.getTree());
            pushFollow(FOLLOW_elses_in_ifExprs4664);
            elses339=elses();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_elses.add(elses339.getTree());


            // AST REWRITE
            // elements: elses, thenClause
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 462:28: -> ^( CONDLIST thenClause elses )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:462:31: ^( CONDLIST thenClause elses )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDLIST, "CONDLIST"), root_1);

                adaptor.addChild(root_1, stream_thenClause.nextTree());
                adaptor.addChild(root_1, stream_elses.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "ifExprs"

    public static class thenClause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "thenClause"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:464:1: thenClause : t= assignExpr ( THEN | COLON ) v= condStmtExpr -> ^( CONDTEST $t $v) ;
    public final EulangParser.thenClause_return thenClause() throws RecognitionException {
        EulangParser.thenClause_return retval = new EulangParser.thenClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token THEN340=null;
        Token COLON341=null;
        EulangParser.assignExpr_return t = null;

        EulangParser.condStmtExpr_return v = null;


        CommonTree THEN340_tree=null;
        CommonTree COLON341_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleSubtreeStream stream_condStmtExpr=new RewriteRuleSubtreeStream(adaptor,"rule condStmtExpr");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:464:12: (t= assignExpr ( THEN | COLON ) v= condStmtExpr -> ^( CONDTEST $t $v) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:464:14: t= assignExpr ( THEN | COLON ) v= condStmtExpr
            {
            pushFollow(FOLLOW_assignExpr_in_thenClause4686);
            t=assignExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignExpr.add(t.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:465:3: ( THEN | COLON )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==THEN) ) {
                alt99=1;
            }
            else if ( (LA99_0==COLON) ) {
                alt99=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:465:4: THEN
                    {
                    THEN340=(Token)match(input,THEN,FOLLOW_THEN_in_thenClause4692); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_THEN.add(THEN340);


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:465:9: COLON
                    {
                    COLON341=(Token)match(input,COLON,FOLLOW_COLON_in_thenClause4694); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON341);


                    }
                    break;

            }

            pushFollow(FOLLOW_condStmtExpr_in_thenClause4699);
            v=condStmtExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_condStmtExpr.add(v.getTree());


            // AST REWRITE
            // elements: t, v
            // token labels: 
            // rule labels: v, retval, t
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 465:33: -> ^( CONDTEST $t $v)
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:465:36: ^( CONDTEST $t $v)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDTEST, "CONDTEST"), root_1);

                adaptor.addChild(root_1, stream_t.nextTree());
                adaptor.addChild(root_1, stream_v.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "thenClause"

    public static class elses_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elses"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:467:1: elses : ( elif )* elseClause -> ( elif )* elseClause ;
    public final EulangParser.elses_return elses() throws RecognitionException {
        EulangParser.elses_return retval = new EulangParser.elses_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.elif_return elif342 = null;

        EulangParser.elseClause_return elseClause343 = null;


        RewriteRuleSubtreeStream stream_elseClause=new RewriteRuleSubtreeStream(adaptor,"rule elseClause");
        RewriteRuleSubtreeStream stream_elif=new RewriteRuleSubtreeStream(adaptor,"rule elif");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:467:7: ( ( elif )* elseClause -> ( elif )* elseClause )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:467:9: ( elif )* elseClause
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:467:9: ( elif )*
            loop100:
            do {
                int alt100=2;
                int LA100_0 = input.LA(1);

                if ( (LA100_0==ELIF) ) {
                    alt100=1;
                }


                switch (alt100) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:467:9: elif
            	    {
            	    pushFollow(FOLLOW_elif_in_elses4727);
            	    elif342=elif();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_elif.add(elif342.getTree());

            	    }
            	    break;

            	default :
            	    break loop100;
                }
            } while (true);

            pushFollow(FOLLOW_elseClause_in_elses4730);
            elseClause343=elseClause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_elseClause.add(elseClause343.getTree());


            // AST REWRITE
            // elements: elseClause, elif
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 467:29: -> ( elif )* elseClause
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:467:32: ( elif )*
                while ( stream_elif.hasNext() ) {
                    adaptor.addChild(root_0, stream_elif.nextTree());

                }
                stream_elif.reset();
                adaptor.addChild(root_0, stream_elseClause.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "elses"

    public static class elif_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elif"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:469:1: elif : ELIF t= assignExpr ( THEN | COLON ) v= condStmtExpr -> ^( CONDTEST $t $v) ;
    public final EulangParser.elif_return elif() throws RecognitionException {
        EulangParser.elif_return retval = new EulangParser.elif_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELIF344=null;
        Token THEN345=null;
        Token COLON346=null;
        EulangParser.assignExpr_return t = null;

        EulangParser.condStmtExpr_return v = null;


        CommonTree ELIF344_tree=null;
        CommonTree THEN345_tree=null;
        CommonTree COLON346_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_ELIF=new RewriteRuleTokenStream(adaptor,"token ELIF");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleSubtreeStream stream_condStmtExpr=new RewriteRuleSubtreeStream(adaptor,"rule condStmtExpr");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:469:6: ( ELIF t= assignExpr ( THEN | COLON ) v= condStmtExpr -> ^( CONDTEST $t $v) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:469:8: ELIF t= assignExpr ( THEN | COLON ) v= condStmtExpr
            {
            ELIF344=(Token)match(input,ELIF,FOLLOW_ELIF_in_elif4753); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELIF.add(ELIF344);

            pushFollow(FOLLOW_assignExpr_in_elif4757);
            t=assignExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignExpr.add(t.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:469:26: ( THEN | COLON )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==THEN) ) {
                alt101=1;
            }
            else if ( (LA101_0==COLON) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:469:27: THEN
                    {
                    THEN345=(Token)match(input,THEN,FOLLOW_THEN_in_elif4760); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_THEN.add(THEN345);


                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:469:32: COLON
                    {
                    COLON346=(Token)match(input,COLON,FOLLOW_COLON_in_elif4762); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON346);


                    }
                    break;

            }

            pushFollow(FOLLOW_condStmtExpr_in_elif4767);
            v=condStmtExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_condStmtExpr.add(v.getTree());


            // AST REWRITE
            // elements: v, t
            // token labels: 
            // rule labels: v, retval, t
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_v=new RewriteRuleSubtreeStream(adaptor,"rule v",v!=null?v.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 469:55: -> ^( CONDTEST $t $v)
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:469:58: ^( CONDTEST $t $v)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDTEST, "CONDTEST"), root_1);

                adaptor.addChild(root_1, stream_t.nextTree());
                adaptor.addChild(root_1, stream_v.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "elif"

    public static class elseClause_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elseClause"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:471:1: elseClause : ( ELSE condStmtExpr -> ^( CONDTEST ^( LIT TRUE ) condStmtExpr ) | FI -> ^( CONDTEST ^( LIT TRUE ) ^( LIT NIL ) ) );
    public final EulangParser.elseClause_return elseClause() throws RecognitionException {
        EulangParser.elseClause_return retval = new EulangParser.elseClause_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ELSE347=null;
        Token FI349=null;
        EulangParser.condStmtExpr_return condStmtExpr348 = null;


        CommonTree ELSE347_tree=null;
        CommonTree FI349_tree=null;
        RewriteRuleTokenStream stream_FI=new RewriteRuleTokenStream(adaptor,"token FI");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_condStmtExpr=new RewriteRuleSubtreeStream(adaptor,"rule condStmtExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:471:12: ( ELSE condStmtExpr -> ^( CONDTEST ^( LIT TRUE ) condStmtExpr ) | FI -> ^( CONDTEST ^( LIT TRUE ) ^( LIT NIL ) ) )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==ELSE) ) {
                alt102=1;
            }
            else if ( (LA102_0==FI) ) {
                alt102=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:471:14: ELSE condStmtExpr
                    {
                    ELSE347=(Token)match(input,ELSE,FOLLOW_ELSE_in_elseClause4793); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ELSE.add(ELSE347);

                    pushFollow(FOLLOW_condStmtExpr_in_elseClause4795);
                    condStmtExpr348=condStmtExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_condStmtExpr.add(condStmtExpr348.getTree());


                    // AST REWRITE
                    // elements: condStmtExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 471:38: -> ^( CONDTEST ^( LIT TRUE ) condStmtExpr )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:471:41: ^( CONDTEST ^( LIT TRUE ) condStmtExpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDTEST, "CONDTEST"), root_1);

                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:471:52: ^( LIT TRUE )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_2);

                        adaptor.addChild(root_2, (CommonTree)adaptor.create(TRUE, "TRUE"));

                        adaptor.addChild(root_1, root_2);
                        }
                        adaptor.addChild(root_1, stream_condStmtExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:472:6: FI
                    {
                    FI349=(Token)match(input,FI,FOLLOW_FI_in_elseClause4822); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FI.add(FI349);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 472:9: -> ^( CONDTEST ^( LIT TRUE ) ^( LIT NIL ) )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:472:12: ^( CONDTEST ^( LIT TRUE ) ^( LIT NIL ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDTEST, "CONDTEST"), root_1);

                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:472:23: ^( LIT TRUE )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_2);

                        adaptor.addChild(root_2, (CommonTree)adaptor.create(TRUE, "TRUE"));

                        adaptor.addChild(root_1, root_2);
                        }
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:472:35: ^( LIT NIL )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_2);

                        adaptor.addChild(root_2, (CommonTree)adaptor.create(NIL, "NIL"));

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "elseClause"

    public static class condStmtExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condStmtExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:475:1: condStmtExpr : ( arg | breakStmt );
    public final EulangParser.condStmtExpr_return condStmtExpr() throws RecognitionException {
        EulangParser.condStmtExpr_return retval = new EulangParser.condStmtExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.arg_return arg350 = null;

        EulangParser.breakStmt_return breakStmt351 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:475:14: ( arg | breakStmt )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==CODE||LA103_0==GOTO||(LA103_0>=SIZEOF && LA103_0<=TYPEOF)||LA103_0==ID||LA103_0==COLON||LA103_0==LBRACE||LA103_0==LPAREN||LA103_0==NIL||LA103_0==IF||LA103_0==NOT||(LA103_0>=TILDE && LA103_0<=AMP)||LA103_0==MINUS||(LA103_0>=PLUSPLUS && LA103_0<=STRING_LITERAL)||(LA103_0>=FALSE && LA103_0<=COLONS)) ) {
                alt103=1;
            }
            else if ( (LA103_0==BREAK) ) {
                alt103=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:475:16: arg
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arg_in_condStmtExpr4853);
                    arg350=arg();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arg350.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:475:22: breakStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_breakStmt_in_condStmtExpr4857);
                    breakStmt351=breakStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, breakStmt351.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "condStmtExpr"

    public static class cond_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "cond"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:477:1: cond : ( logor -> logor ) ( QUESTION t= logor COLON f= logor -> ^( CONDLIST ^( CONDTEST $cond $t) ^( CONDTEST ^( LIT TRUE ) $f) ) )* ;
    public final EulangParser.cond_return cond() throws RecognitionException {
        EulangParser.cond_return retval = new EulangParser.cond_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token QUESTION353=null;
        Token COLON354=null;
        EulangParser.logor_return t = null;

        EulangParser.logor_return f = null;

        EulangParser.logor_return logor352 = null;


        CommonTree QUESTION353_tree=null;
        CommonTree COLON354_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");
        RewriteRuleSubtreeStream stream_logor=new RewriteRuleSubtreeStream(adaptor,"rule logor");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:477:5: ( ( logor -> logor ) ( QUESTION t= logor COLON f= logor -> ^( CONDLIST ^( CONDTEST $cond $t) ^( CONDTEST ^( LIT TRUE ) $f) ) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:477:10: ( logor -> logor ) ( QUESTION t= logor COLON f= logor -> ^( CONDLIST ^( CONDTEST $cond $t) ^( CONDTEST ^( LIT TRUE ) $f) ) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:477:10: ( logor -> logor )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:477:12: logor
            {
            pushFollow(FOLLOW_logor_in_cond4874);
            logor352=logor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logor.add(logor352.getTree());


            // AST REWRITE
            // elements: logor
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 477:19: -> logor
            {
                adaptor.addChild(root_0, stream_logor.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:478:7: ( QUESTION t= logor COLON f= logor -> ^( CONDLIST ^( CONDTEST $cond $t) ^( CONDTEST ^( LIT TRUE ) $f) ) )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==QUESTION) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:478:9: QUESTION t= logor COLON f= logor
            	    {
            	    QUESTION353=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_cond4891); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_QUESTION.add(QUESTION353);

            	    pushFollow(FOLLOW_logor_in_cond4895);
            	    t=logor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logor.add(t.getTree());
            	    COLON354=(Token)match(input,COLON,FOLLOW_COLON_in_cond4897); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COLON.add(COLON354);

            	    pushFollow(FOLLOW_logor_in_cond4901);
            	    f=logor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logor.add(f.getTree());


            	    // AST REWRITE
            	    // elements: t, f, cond
            	    // token labels: 
            	    // rule labels: f, retval, t
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.tree:null);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 478:40: -> ^( CONDLIST ^( CONDTEST $cond $t) ^( CONDTEST ^( LIT TRUE ) $f) )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:478:43: ^( CONDLIST ^( CONDTEST $cond $t) ^( CONDTEST ^( LIT TRUE ) $f) )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDLIST, "CONDLIST"), root_1);

            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:478:54: ^( CONDTEST $cond $t)
            	        {
            	        CommonTree root_2 = (CommonTree)adaptor.nil();
            	        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDTEST, "CONDTEST"), root_2);

            	        adaptor.addChild(root_2, stream_retval.nextTree());
            	        adaptor.addChild(root_2, stream_t.nextTree());

            	        adaptor.addChild(root_1, root_2);
            	        }
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:478:75: ^( CONDTEST ^( LIT TRUE ) $f)
            	        {
            	        CommonTree root_2 = (CommonTree)adaptor.nil();
            	        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDTEST, "CONDTEST"), root_2);

            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:478:86: ^( LIT TRUE )
            	        {
            	        CommonTree root_3 = (CommonTree)adaptor.nil();
            	        root_3 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_3);

            	        adaptor.addChild(root_3, (CommonTree)adaptor.create(TRUE, "TRUE"));

            	        adaptor.addChild(root_2, root_3);
            	        }
            	        adaptor.addChild(root_2, stream_f.nextTree());

            	        adaptor.addChild(root_1, root_2);
            	        }

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "cond"

    public static class logor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logor"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:481:1: logor : ( logand -> logand ) ( OR r= logand -> ^( OR $logor $r) )* ;
    public final EulangParser.logor_return logor() throws RecognitionException {
        EulangParser.logor_return retval = new EulangParser.logor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR356=null;
        EulangParser.logand_return r = null;

        EulangParser.logand_return logand355 = null;


        CommonTree OR356_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_logand=new RewriteRuleSubtreeStream(adaptor,"rule logand");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:481:7: ( ( logand -> logand ) ( OR r= logand -> ^( OR $logor $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:481:9: ( logand -> logand ) ( OR r= logand -> ^( OR $logor $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:481:9: ( logand -> logand )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:481:11: logand
            {
            pushFollow(FOLLOW_logand_in_logor4945);
            logand355=logand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_logand.add(logand355.getTree());


            // AST REWRITE
            // elements: logand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 481:19: -> logand
            {
                adaptor.addChild(root_0, stream_logand.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:482:7: ( OR r= logand -> ^( OR $logor $r) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==OR) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:482:9: OR r= logand
            	    {
            	    OR356=(Token)match(input,OR,FOLLOW_OR_in_logor4962); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_OR.add(OR356);

            	    pushFollow(FOLLOW_logand_in_logor4966);
            	    r=logand();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_logand.add(r.getTree());


            	    // AST REWRITE
            	    // elements: logor, OR, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 482:21: -> ^( OR $logor $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:482:24: ^( OR $logor $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_OR.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "logor"

    public static class logand_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logand"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:484:1: logand : ( not -> not ) ( AND r= not -> ^( AND $logand $r) )* ;
    public final EulangParser.logand_return logand() throws RecognitionException {
        EulangParser.logand_return retval = new EulangParser.logand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND358=null;
        EulangParser.not_return r = null;

        EulangParser.not_return not357 = null;


        CommonTree AND358_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_not=new RewriteRuleSubtreeStream(adaptor,"rule not");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:484:8: ( ( not -> not ) ( AND r= not -> ^( AND $logand $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:484:10: ( not -> not ) ( AND r= not -> ^( AND $logand $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:484:10: ( not -> not )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:484:12: not
            {
            pushFollow(FOLLOW_not_in_logand4997);
            not357=not();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_not.add(not357.getTree());


            // AST REWRITE
            // elements: not
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 484:16: -> not
            {
                adaptor.addChild(root_0, stream_not.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:485:7: ( AND r= not -> ^( AND $logand $r) )*
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==AND) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:485:9: AND r= not
            	    {
            	    AND358=(Token)match(input,AND,FOLLOW_AND_in_logand5013); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AND.add(AND358);

            	    pushFollow(FOLLOW_not_in_logand5017);
            	    r=not();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_not.add(r.getTree());


            	    // AST REWRITE
            	    // elements: logand, r, AND
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 485:19: -> ^( AND $logand $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:485:22: ^( AND $logand $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_AND.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop106;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "logand"

    public static class not_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "not"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:488:1: not : ( comp -> comp | NOT u= comp -> ^( NOT $u) );
    public final EulangParser.not_return not() throws RecognitionException {
        EulangParser.not_return retval = new EulangParser.not_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NOT360=null;
        EulangParser.comp_return u = null;

        EulangParser.comp_return comp359 = null;


        CommonTree NOT360_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleSubtreeStream stream_comp=new RewriteRuleSubtreeStream(adaptor,"rule comp");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:488:5: ( comp -> comp | NOT u= comp -> ^( NOT $u) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==CODE||(LA107_0>=SIZEOF && LA107_0<=TYPEOF)||LA107_0==ID||LA107_0==COLON||LA107_0==LPAREN||LA107_0==NIL||(LA107_0>=TILDE && LA107_0<=AMP)||LA107_0==MINUS||(LA107_0>=PLUSPLUS && LA107_0<=STRING_LITERAL)||(LA107_0>=FALSE && LA107_0<=COLONS)) ) {
                alt107=1;
            }
            else if ( (LA107_0==NOT) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:488:8: comp
                    {
                    pushFollow(FOLLOW_comp_in_not5063);
                    comp359=comp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_comp.add(comp359.getTree());


                    // AST REWRITE
                    // elements: comp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 488:17: -> comp
                    {
                        adaptor.addChild(root_0, stream_comp.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:489:7: NOT u= comp
                    {
                    NOT360=(Token)match(input,NOT,FOLLOW_NOT_in_not5079); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT360);

                    pushFollow(FOLLOW_comp_in_not5083);
                    u=comp();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_comp.add(u.getTree());


                    // AST REWRITE
                    // elements: NOT, u
                    // token labels: 
                    // rule labels: retval, u
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_u=new RewriteRuleSubtreeStream(adaptor,"rule u",u!=null?u.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 489:22: -> ^( NOT $u)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:489:25: ^( NOT $u)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_u.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "not"

    public static class comp_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comp"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:492:1: comp : ( bitor -> bitor ) ( COMPEQ r= bitor -> ^( COMPEQ $comp $r) | COMPNE r= bitor -> ^( COMPNE $comp $r) | COMPLE r= bitor -> ^( COMPLE $comp $r) | COMPGE r= bitor -> ^( COMPGE $comp $r) | COMPULE r= bitor -> ^( COMPULE $comp $r) | COMPUGE r= bitor -> ^( COMPUGE $comp $r) | LESS r= bitor -> ^( LESS $comp $r) | ULESS r= bitor -> ^( ULESS $comp $r) | GREATER r= bitor -> ^( GREATER $comp $r) | UGREATER r= bitor -> ^( UGREATER $comp $r) )* ;
    public final EulangParser.comp_return comp() throws RecognitionException {
        EulangParser.comp_return retval = new EulangParser.comp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMPEQ362=null;
        Token COMPNE363=null;
        Token COMPLE364=null;
        Token COMPGE365=null;
        Token COMPULE366=null;
        Token COMPUGE367=null;
        Token LESS368=null;
        Token ULESS369=null;
        Token GREATER370=null;
        Token UGREATER371=null;
        EulangParser.bitor_return r = null;

        EulangParser.bitor_return bitor361 = null;


        CommonTree COMPEQ362_tree=null;
        CommonTree COMPNE363_tree=null;
        CommonTree COMPLE364_tree=null;
        CommonTree COMPGE365_tree=null;
        CommonTree COMPULE366_tree=null;
        CommonTree COMPUGE367_tree=null;
        CommonTree LESS368_tree=null;
        CommonTree ULESS369_tree=null;
        CommonTree GREATER370_tree=null;
        CommonTree UGREATER371_tree=null;
        RewriteRuleTokenStream stream_COMPGE=new RewriteRuleTokenStream(adaptor,"token COMPGE");
        RewriteRuleTokenStream stream_ULESS=new RewriteRuleTokenStream(adaptor,"token ULESS");
        RewriteRuleTokenStream stream_COMPEQ=new RewriteRuleTokenStream(adaptor,"token COMPEQ");
        RewriteRuleTokenStream stream_GREATER=new RewriteRuleTokenStream(adaptor,"token GREATER");
        RewriteRuleTokenStream stream_COMPLE=new RewriteRuleTokenStream(adaptor,"token COMPLE");
        RewriteRuleTokenStream stream_COMPNE=new RewriteRuleTokenStream(adaptor,"token COMPNE");
        RewriteRuleTokenStream stream_COMPULE=new RewriteRuleTokenStream(adaptor,"token COMPULE");
        RewriteRuleTokenStream stream_UGREATER=new RewriteRuleTokenStream(adaptor,"token UGREATER");
        RewriteRuleTokenStream stream_COMPUGE=new RewriteRuleTokenStream(adaptor,"token COMPUGE");
        RewriteRuleTokenStream stream_LESS=new RewriteRuleTokenStream(adaptor,"token LESS");
        RewriteRuleSubtreeStream stream_bitor=new RewriteRuleSubtreeStream(adaptor,"rule bitor");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:492:5: ( ( bitor -> bitor ) ( COMPEQ r= bitor -> ^( COMPEQ $comp $r) | COMPNE r= bitor -> ^( COMPNE $comp $r) | COMPLE r= bitor -> ^( COMPLE $comp $r) | COMPGE r= bitor -> ^( COMPGE $comp $r) | COMPULE r= bitor -> ^( COMPULE $comp $r) | COMPUGE r= bitor -> ^( COMPUGE $comp $r) | LESS r= bitor -> ^( LESS $comp $r) | ULESS r= bitor -> ^( ULESS $comp $r) | GREATER r= bitor -> ^( GREATER $comp $r) | UGREATER r= bitor -> ^( UGREATER $comp $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:492:9: ( bitor -> bitor ) ( COMPEQ r= bitor -> ^( COMPEQ $comp $r) | COMPNE r= bitor -> ^( COMPNE $comp $r) | COMPLE r= bitor -> ^( COMPLE $comp $r) | COMPGE r= bitor -> ^( COMPGE $comp $r) | COMPULE r= bitor -> ^( COMPULE $comp $r) | COMPUGE r= bitor -> ^( COMPUGE $comp $r) | LESS r= bitor -> ^( LESS $comp $r) | ULESS r= bitor -> ^( ULESS $comp $r) | GREATER r= bitor -> ^( GREATER $comp $r) | UGREATER r= bitor -> ^( UGREATER $comp $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:492:9: ( bitor -> bitor )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:492:11: bitor
            {
            pushFollow(FOLLOW_bitor_in_comp5117);
            bitor361=bitor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bitor.add(bitor361.getTree());


            // AST REWRITE
            // elements: bitor
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 492:24: -> bitor
            {
                adaptor.addChild(root_0, stream_bitor.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:493:7: ( COMPEQ r= bitor -> ^( COMPEQ $comp $r) | COMPNE r= bitor -> ^( COMPNE $comp $r) | COMPLE r= bitor -> ^( COMPLE $comp $r) | COMPGE r= bitor -> ^( COMPGE $comp $r) | COMPULE r= bitor -> ^( COMPULE $comp $r) | COMPUGE r= bitor -> ^( COMPUGE $comp $r) | LESS r= bitor -> ^( LESS $comp $r) | ULESS r= bitor -> ^( ULESS $comp $r) | GREATER r= bitor -> ^( GREATER $comp $r) | UGREATER r= bitor -> ^( UGREATER $comp $r) )*
            loop108:
            do {
                int alt108=11;
                switch ( input.LA(1) ) {
                case COMPEQ:
                    {
                    alt108=1;
                    }
                    break;
                case COMPNE:
                    {
                    alt108=2;
                    }
                    break;
                case COMPLE:
                    {
                    alt108=3;
                    }
                    break;
                case COMPGE:
                    {
                    alt108=4;
                    }
                    break;
                case COMPULE:
                    {
                    alt108=5;
                    }
                    break;
                case COMPUGE:
                    {
                    alt108=6;
                    }
                    break;
                case LESS:
                    {
                    alt108=7;
                    }
                    break;
                case ULESS:
                    {
                    alt108=8;
                    }
                    break;
                case GREATER:
                    {
                    alt108=9;
                    }
                    break;
                case UGREATER:
                    {
                    alt108=10;
                    }
                    break;

                }

                switch (alt108) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:493:9: COMPEQ r= bitor
            	    {
            	    COMPEQ362=(Token)match(input,COMPEQ,FOLLOW_COMPEQ_in_comp5150); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMPEQ.add(COMPEQ362);

            	    pushFollow(FOLLOW_bitor_in_comp5154);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: comp, r, COMPEQ
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 493:24: -> ^( COMPEQ $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:493:27: ^( COMPEQ $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_COMPEQ.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 2 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:494:9: COMPNE r= bitor
            	    {
            	    COMPNE363=(Token)match(input,COMPNE,FOLLOW_COMPNE_in_comp5176); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMPNE.add(COMPNE363);

            	    pushFollow(FOLLOW_bitor_in_comp5180);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: COMPNE, r, comp
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 494:24: -> ^( COMPNE $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:494:27: ^( COMPNE $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_COMPNE.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 3 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:495:9: COMPLE r= bitor
            	    {
            	    COMPLE364=(Token)match(input,COMPLE,FOLLOW_COMPLE_in_comp5202); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMPLE.add(COMPLE364);

            	    pushFollow(FOLLOW_bitor_in_comp5206);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: COMPLE, comp, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 495:27: -> ^( COMPLE $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:495:30: ^( COMPLE $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_COMPLE.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 4 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:496:9: COMPGE r= bitor
            	    {
            	    COMPGE365=(Token)match(input,COMPGE,FOLLOW_COMPGE_in_comp5231); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMPGE.add(COMPGE365);

            	    pushFollow(FOLLOW_bitor_in_comp5235);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: comp, r, COMPGE
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 496:27: -> ^( COMPGE $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:496:30: ^( COMPGE $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_COMPGE.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 5 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:497:9: COMPULE r= bitor
            	    {
            	    COMPULE366=(Token)match(input,COMPULE,FOLLOW_COMPULE_in_comp5260); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMPULE.add(COMPULE366);

            	    pushFollow(FOLLOW_bitor_in_comp5264);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, comp, COMPULE
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 497:28: -> ^( COMPULE $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:497:31: ^( COMPULE $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_COMPULE.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 6 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:498:9: COMPUGE r= bitor
            	    {
            	    COMPUGE367=(Token)match(input,COMPUGE,FOLLOW_COMPUGE_in_comp5289); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMPUGE.add(COMPUGE367);

            	    pushFollow(FOLLOW_bitor_in_comp5293);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: comp, r, COMPUGE
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 498:28: -> ^( COMPUGE $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:498:31: ^( COMPUGE $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_COMPUGE.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 7 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:499:9: LESS r= bitor
            	    {
            	    LESS368=(Token)match(input,LESS,FOLLOW_LESS_in_comp5318); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LESS.add(LESS368);

            	    pushFollow(FOLLOW_bitor_in_comp5322);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: comp, LESS, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 499:26: -> ^( LESS $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:499:29: ^( LESS $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_LESS.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 8 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:500:9: ULESS r= bitor
            	    {
            	    ULESS369=(Token)match(input,ULESS,FOLLOW_ULESS_in_comp5348); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ULESS.add(ULESS369);

            	    pushFollow(FOLLOW_bitor_in_comp5352);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: comp, ULESS, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 500:27: -> ^( ULESS $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:500:30: ^( ULESS $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_ULESS.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 9 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:501:9: GREATER r= bitor
            	    {
            	    GREATER370=(Token)match(input,GREATER,FOLLOW_GREATER_in_comp5378); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_GREATER.add(GREATER370);

            	    pushFollow(FOLLOW_bitor_in_comp5382);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, GREATER, comp
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 501:28: -> ^( GREATER $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:501:31: ^( GREATER $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_GREATER.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 10 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:502:9: UGREATER r= bitor
            	    {
            	    UGREATER371=(Token)match(input,UGREATER,FOLLOW_UGREATER_in_comp5407); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_UGREATER.add(UGREATER371);

            	    pushFollow(FOLLOW_bitor_in_comp5411);
            	    r=bitor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: UGREATER, r, comp
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 502:29: -> ^( UGREATER $comp $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:502:32: ^( UGREATER $comp $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_UGREATER.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop108;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "comp"

    public static class bitor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitor"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:507:1: bitor : ( bitxor -> bitxor ) ( BAR r= bitxor -> ^( BITOR $bitor $r) )* ;
    public final EulangParser.bitor_return bitor() throws RecognitionException {
        EulangParser.bitor_return retval = new EulangParser.bitor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BAR373=null;
        EulangParser.bitxor_return r = null;

        EulangParser.bitxor_return bitxor372 = null;


        CommonTree BAR373_tree=null;
        RewriteRuleTokenStream stream_BAR=new RewriteRuleTokenStream(adaptor,"token BAR");
        RewriteRuleSubtreeStream stream_bitxor=new RewriteRuleSubtreeStream(adaptor,"rule bitxor");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:507:6: ( ( bitxor -> bitxor ) ( BAR r= bitxor -> ^( BITOR $bitor $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:507:8: ( bitxor -> bitxor ) ( BAR r= bitxor -> ^( BITOR $bitor $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:507:8: ( bitxor -> bitxor )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:507:10: bitxor
            {
            pushFollow(FOLLOW_bitxor_in_bitor5461);
            bitxor372=bitxor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bitxor.add(bitxor372.getTree());


            // AST REWRITE
            // elements: bitxor
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 507:22: -> bitxor
            {
                adaptor.addChild(root_0, stream_bitxor.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:508:7: ( BAR r= bitxor -> ^( BITOR $bitor $r) )*
            loop109:
            do {
                int alt109=2;
                int LA109_0 = input.LA(1);

                if ( (LA109_0==BAR) ) {
                    alt109=1;
                }


                switch (alt109) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:508:9: BAR r= bitxor
            	    {
            	    BAR373=(Token)match(input,BAR,FOLLOW_BAR_in_bitor5489); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_BAR.add(BAR373);

            	    pushFollow(FOLLOW_bitxor_in_bitor5493);
            	    r=bitxor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitxor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: bitor, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 508:23: -> ^( BITOR $bitor $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:508:26: ^( BITOR $bitor $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BITOR, "BITOR"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop109;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "bitor"

    public static class bitxor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitxor"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:510:1: bitxor : ( bitand -> bitand ) ( TILDE r= bitand -> ^( BITXOR $bitxor $r) )* ;
    public final EulangParser.bitxor_return bitxor() throws RecognitionException {
        EulangParser.bitxor_return retval = new EulangParser.bitxor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TILDE375=null;
        EulangParser.bitand_return r = null;

        EulangParser.bitand_return bitand374 = null;


        CommonTree TILDE375_tree=null;
        RewriteRuleTokenStream stream_TILDE=new RewriteRuleTokenStream(adaptor,"token TILDE");
        RewriteRuleSubtreeStream stream_bitand=new RewriteRuleSubtreeStream(adaptor,"rule bitand");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:510:7: ( ( bitand -> bitand ) ( TILDE r= bitand -> ^( BITXOR $bitxor $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:510:9: ( bitand -> bitand ) ( TILDE r= bitand -> ^( BITXOR $bitxor $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:510:9: ( bitand -> bitand )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:510:11: bitand
            {
            pushFollow(FOLLOW_bitand_in_bitxor5519);
            bitand374=bitand();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bitand.add(bitand374.getTree());


            // AST REWRITE
            // elements: bitand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 510:23: -> bitand
            {
                adaptor.addChild(root_0, stream_bitand.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:511:7: ( TILDE r= bitand -> ^( BITXOR $bitxor $r) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==TILDE) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:511:9: TILDE r= bitand
            	    {
            	    TILDE375=(Token)match(input,TILDE,FOLLOW_TILDE_in_bitxor5547); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_TILDE.add(TILDE375);

            	    pushFollow(FOLLOW_bitand_in_bitxor5551);
            	    r=bitand();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_bitand.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, bitxor
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 511:25: -> ^( BITXOR $bitxor $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:511:28: ^( BITXOR $bitxor $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BITXOR, "BITXOR"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop110;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "bitxor"

    public static class bitand_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bitand"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:513:1: bitand : ( shift -> shift ) ( AMP r= shift -> ^( BITAND $bitand $r) )* ;
    public final EulangParser.bitand_return bitand() throws RecognitionException {
        EulangParser.bitand_return retval = new EulangParser.bitand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AMP377=null;
        EulangParser.shift_return r = null;

        EulangParser.shift_return shift376 = null;


        CommonTree AMP377_tree=null;
        RewriteRuleTokenStream stream_AMP=new RewriteRuleTokenStream(adaptor,"token AMP");
        RewriteRuleSubtreeStream stream_shift=new RewriteRuleSubtreeStream(adaptor,"rule shift");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:513:7: ( ( shift -> shift ) ( AMP r= shift -> ^( BITAND $bitand $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:513:9: ( shift -> shift ) ( AMP r= shift -> ^( BITAND $bitand $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:513:9: ( shift -> shift )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:513:11: shift
            {
            pushFollow(FOLLOW_shift_in_bitand5576);
            shift376=shift();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_shift.add(shift376.getTree());


            // AST REWRITE
            // elements: shift
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 513:22: -> shift
            {
                adaptor.addChild(root_0, stream_shift.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:514:7: ( AMP r= shift -> ^( BITAND $bitand $r) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( (LA111_0==AMP) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:514:9: AMP r= shift
            	    {
            	    AMP377=(Token)match(input,AMP,FOLLOW_AMP_in_bitand5604); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_AMP.add(AMP377);

            	    pushFollow(FOLLOW_shift_in_bitand5608);
            	    r=shift();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_shift.add(r.getTree());


            	    // AST REWRITE
            	    // elements: bitand, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 514:22: -> ^( BITAND $bitand $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:514:25: ^( BITAND $bitand $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(BITAND, "BITAND"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop111;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "bitand"

    public static class shift_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shift"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:517:1: shift : ( factor -> factor ) ( ( LSHIFT r= factor -> ^( LSHIFT $shift $r) ) | ( RSHIFT r= factor -> ^( RSHIFT $shift $r) ) | ( URSHIFT r= factor -> ^( URSHIFT $shift $r) ) | ( CRSHIFT r= factor -> ^( CRSHIFT $shift $r) ) | ( CLSHIFT r= factor -> ^( CLSHIFT $shift $r) ) )* ;
    public final EulangParser.shift_return shift() throws RecognitionException {
        EulangParser.shift_return retval = new EulangParser.shift_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LSHIFT379=null;
        Token RSHIFT380=null;
        Token URSHIFT381=null;
        Token CRSHIFT382=null;
        Token CLSHIFT383=null;
        EulangParser.factor_return r = null;

        EulangParser.factor_return factor378 = null;


        CommonTree LSHIFT379_tree=null;
        CommonTree RSHIFT380_tree=null;
        CommonTree URSHIFT381_tree=null;
        CommonTree CRSHIFT382_tree=null;
        CommonTree CLSHIFT383_tree=null;
        RewriteRuleTokenStream stream_URSHIFT=new RewriteRuleTokenStream(adaptor,"token URSHIFT");
        RewriteRuleTokenStream stream_CLSHIFT=new RewriteRuleTokenStream(adaptor,"token CLSHIFT");
        RewriteRuleTokenStream stream_CRSHIFT=new RewriteRuleTokenStream(adaptor,"token CRSHIFT");
        RewriteRuleTokenStream stream_RSHIFT=new RewriteRuleTokenStream(adaptor,"token RSHIFT");
        RewriteRuleTokenStream stream_LSHIFT=new RewriteRuleTokenStream(adaptor,"token LSHIFT");
        RewriteRuleSubtreeStream stream_factor=new RewriteRuleSubtreeStream(adaptor,"rule factor");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:517:6: ( ( factor -> factor ) ( ( LSHIFT r= factor -> ^( LSHIFT $shift $r) ) | ( RSHIFT r= factor -> ^( RSHIFT $shift $r) ) | ( URSHIFT r= factor -> ^( URSHIFT $shift $r) ) | ( CRSHIFT r= factor -> ^( CRSHIFT $shift $r) ) | ( CLSHIFT r= factor -> ^( CLSHIFT $shift $r) ) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:517:9: ( factor -> factor ) ( ( LSHIFT r= factor -> ^( LSHIFT $shift $r) ) | ( RSHIFT r= factor -> ^( RSHIFT $shift $r) ) | ( URSHIFT r= factor -> ^( URSHIFT $shift $r) ) | ( CRSHIFT r= factor -> ^( CRSHIFT $shift $r) ) | ( CLSHIFT r= factor -> ^( CLSHIFT $shift $r) ) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:517:9: ( factor -> factor )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:517:11: factor
            {
            pushFollow(FOLLOW_factor_in_shift5635);
            factor378=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_factor.add(factor378.getTree());


            // AST REWRITE
            // elements: factor
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 517:25: -> factor
            {
                adaptor.addChild(root_0, stream_factor.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:518:7: ( ( LSHIFT r= factor -> ^( LSHIFT $shift $r) ) | ( RSHIFT r= factor -> ^( RSHIFT $shift $r) ) | ( URSHIFT r= factor -> ^( URSHIFT $shift $r) ) | ( CRSHIFT r= factor -> ^( CRSHIFT $shift $r) ) | ( CLSHIFT r= factor -> ^( CLSHIFT $shift $r) ) )*
            loop112:
            do {
                int alt112=6;
                switch ( input.LA(1) ) {
                case LSHIFT:
                    {
                    alt112=1;
                    }
                    break;
                case RSHIFT:
                    {
                    alt112=2;
                    }
                    break;
                case URSHIFT:
                    {
                    alt112=3;
                    }
                    break;
                case CRSHIFT:
                    {
                    alt112=4;
                    }
                    break;
                case CLSHIFT:
                    {
                    alt112=5;
                    }
                    break;

                }

                switch (alt112) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:518:9: ( LSHIFT r= factor -> ^( LSHIFT $shift $r) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:518:9: ( LSHIFT r= factor -> ^( LSHIFT $shift $r) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:518:11: LSHIFT r= factor
            	    {
            	    LSHIFT379=(Token)match(input,LSHIFT,FOLLOW_LSHIFT_in_shift5669); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LSHIFT.add(LSHIFT379);

            	    pushFollow(FOLLOW_factor_in_shift5673);
            	    r=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_factor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, LSHIFT, shift
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 518:29: -> ^( LSHIFT $shift $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:518:32: ^( LSHIFT $shift $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_LSHIFT.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:519:9: ( RSHIFT r= factor -> ^( RSHIFT $shift $r) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:519:9: ( RSHIFT r= factor -> ^( RSHIFT $shift $r) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:519:11: RSHIFT r= factor
            	    {
            	    RSHIFT380=(Token)match(input,RSHIFT,FOLLOW_RSHIFT_in_shift5702); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RSHIFT.add(RSHIFT380);

            	    pushFollow(FOLLOW_factor_in_shift5706);
            	    r=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_factor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: shift, r, RSHIFT
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 519:29: -> ^( RSHIFT $shift $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:519:32: ^( RSHIFT $shift $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_RSHIFT.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:520:9: ( URSHIFT r= factor -> ^( URSHIFT $shift $r) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:520:9: ( URSHIFT r= factor -> ^( URSHIFT $shift $r) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:520:11: URSHIFT r= factor
            	    {
            	    URSHIFT381=(Token)match(input,URSHIFT,FOLLOW_URSHIFT_in_shift5734); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_URSHIFT.add(URSHIFT381);

            	    pushFollow(FOLLOW_factor_in_shift5738);
            	    r=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_factor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, shift, URSHIFT
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 520:30: -> ^( URSHIFT $shift $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:520:33: ^( URSHIFT $shift $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_URSHIFT.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 4 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:521:9: ( CRSHIFT r= factor -> ^( CRSHIFT $shift $r) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:521:9: ( CRSHIFT r= factor -> ^( CRSHIFT $shift $r) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:521:11: CRSHIFT r= factor
            	    {
            	    CRSHIFT382=(Token)match(input,CRSHIFT,FOLLOW_CRSHIFT_in_shift5766); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CRSHIFT.add(CRSHIFT382);

            	    pushFollow(FOLLOW_factor_in_shift5770);
            	    r=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_factor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: shift, r, CRSHIFT
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 521:30: -> ^( CRSHIFT $shift $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:521:33: ^( CRSHIFT $shift $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_CRSHIFT.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 5 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:522:9: ( CLSHIFT r= factor -> ^( CLSHIFT $shift $r) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:522:9: ( CLSHIFT r= factor -> ^( CLSHIFT $shift $r) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:522:11: CLSHIFT r= factor
            	    {
            	    CLSHIFT383=(Token)match(input,CLSHIFT,FOLLOW_CLSHIFT_in_shift5798); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CLSHIFT.add(CLSHIFT383);

            	    pushFollow(FOLLOW_factor_in_shift5802);
            	    r=factor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_factor.add(r.getTree());


            	    // AST REWRITE
            	    // elements: CLSHIFT, shift, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 522:30: -> ^( CLSHIFT $shift $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:522:33: ^( CLSHIFT $shift $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_CLSHIFT.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;

            	default :
            	    break loop112;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "shift"

    public static class factor_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:525:1: factor : ( term -> term ) ( PLUS r= term -> ^( ADD $factor $r) | ( MINUS term )=> MINUS r= term -> ^( SUB $factor $r) )* ;
    public final EulangParser.factor_return factor() throws RecognitionException {
        EulangParser.factor_return retval = new EulangParser.factor_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS385=null;
        Token MINUS386=null;
        EulangParser.term_return r = null;

        EulangParser.term_return term384 = null;


        CommonTree PLUS385_tree=null;
        CommonTree MINUS386_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:526:5: ( ( term -> term ) ( PLUS r= term -> ^( ADD $factor $r) | ( MINUS term )=> MINUS r= term -> ^( SUB $factor $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:526:7: ( term -> term ) ( PLUS r= term -> ^( ADD $factor $r) | ( MINUS term )=> MINUS r= term -> ^( SUB $factor $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:526:7: ( term -> term )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:526:9: term
            {
            pushFollow(FOLLOW_term_in_factor5844);
            term384=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_term.add(term384.getTree());


            // AST REWRITE
            // elements: term
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 526:27: -> term
            {
                adaptor.addChild(root_0, stream_term.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:527:9: ( PLUS r= term -> ^( ADD $factor $r) | ( MINUS term )=> MINUS r= term -> ^( SUB $factor $r) )*
            loop113:
            do {
                int alt113=3;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==PLUS) ) {
                    alt113=1;
                }
                else if ( (LA113_0==MINUS) && (synpred19_Eulang())) {
                    alt113=2;
                }


                switch (alt113) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:527:13: PLUS r= term
            	    {
            	    PLUS385=(Token)match(input,PLUS,FOLLOW_PLUS_in_factor5877); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PLUS.add(PLUS385);

            	    pushFollow(FOLLOW_term_in_factor5881);
            	    r=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_term.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, factor
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 527:33: -> ^( ADD $factor $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:527:36: ^( ADD $factor $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ADD, "ADD"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 2 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:528:12: ( MINUS term )=> MINUS r= term
            	    {
            	    MINUS386=(Token)match(input,MINUS,FOLLOW_MINUS_in_factor5923); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_MINUS.add(MINUS386);

            	    pushFollow(FOLLOW_term_in_factor5927);
            	    r=term();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_term.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, factor
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 528:49: -> ^( SUB $factor $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:528:52: ^( SUB $factor $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SUB, "SUB"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop113;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "factor"

    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:532:1: term : ( unary -> unary ) ( ( STAR unary )=> STAR r= unary -> ^( MUL $term $r) | SLASH r= unary -> ^( DIV $term $r) | REM r= unary -> ^( REM $term $r) | UDIV r= unary -> ^( UDIV $term $r) | UREM r= unary -> ^( UREM $term $r) | MOD r= unary -> ^( MOD $term $r) )* ;
    public final EulangParser.term_return term() throws RecognitionException {
        EulangParser.term_return retval = new EulangParser.term_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STAR388=null;
        Token SLASH389=null;
        Token REM390=null;
        Token UDIV391=null;
        Token UREM392=null;
        Token MOD393=null;
        EulangParser.unary_return r = null;

        EulangParser.unary_return unary387 = null;


        CommonTree STAR388_tree=null;
        CommonTree SLASH389_tree=null;
        CommonTree REM390_tree=null;
        CommonTree UDIV391_tree=null;
        CommonTree UREM392_tree=null;
        CommonTree MOD393_tree=null;
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_SLASH=new RewriteRuleTokenStream(adaptor,"token SLASH");
        RewriteRuleTokenStream stream_REM=new RewriteRuleTokenStream(adaptor,"token REM");
        RewriteRuleTokenStream stream_UREM=new RewriteRuleTokenStream(adaptor,"token UREM");
        RewriteRuleTokenStream stream_MOD=new RewriteRuleTokenStream(adaptor,"token MOD");
        RewriteRuleTokenStream stream_UDIV=new RewriteRuleTokenStream(adaptor,"token UDIV");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:532:6: ( ( unary -> unary ) ( ( STAR unary )=> STAR r= unary -> ^( MUL $term $r) | SLASH r= unary -> ^( DIV $term $r) | REM r= unary -> ^( REM $term $r) | UDIV r= unary -> ^( UDIV $term $r) | UREM r= unary -> ^( UREM $term $r) | MOD r= unary -> ^( MOD $term $r) )* )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:532:8: ( unary -> unary ) ( ( STAR unary )=> STAR r= unary -> ^( MUL $term $r) | SLASH r= unary -> ^( DIV $term $r) | REM r= unary -> ^( REM $term $r) | UDIV r= unary -> ^( UDIV $term $r) | UREM r= unary -> ^( UREM $term $r) | MOD r= unary -> ^( MOD $term $r) )*
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:532:8: ( unary -> unary )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:532:10: unary
            {
            pushFollow(FOLLOW_unary_in_term5972);
            unary387=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_unary.add(unary387.getTree());


            // AST REWRITE
            // elements: unary
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 532:33: -> unary
            {
                adaptor.addChild(root_0, stream_unary.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:533:9: ( ( STAR unary )=> STAR r= unary -> ^( MUL $term $r) | SLASH r= unary -> ^( DIV $term $r) | REM r= unary -> ^( REM $term $r) | UDIV r= unary -> ^( UDIV $term $r) | UREM r= unary -> ^( UREM $term $r) | MOD r= unary -> ^( MOD $term $r) )*
            loop114:
            do {
                int alt114=7;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==STAR) && (synpred20_Eulang())) {
                    alt114=1;
                }
                else if ( (LA114_0==SLASH) ) {
                    alt114=2;
                }
                else if ( (LA114_0==REM) ) {
                    alt114=3;
                }
                else if ( (LA114_0==UDIV) ) {
                    alt114=4;
                }
                else if ( (LA114_0==UREM) ) {
                    alt114=5;
                }
                else if ( (LA114_0==MOD) ) {
                    alt114=6;
                }


                switch (alt114) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:533:11: ( STAR unary )=> STAR r= unary
            	    {
            	    STAR388=(Token)match(input,STAR,FOLLOW_STAR_in_term6016); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_STAR.add(STAR388);

            	    pushFollow(FOLLOW_unary_in_term6020);
            	    r=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, term
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 533:52: -> ^( MUL $term $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:533:55: ^( MUL $term $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(MUL, "MUL"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 2 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:534:11: SLASH r= unary
            	    {
            	    SLASH389=(Token)match(input,SLASH,FOLLOW_SLASH_in_term6056); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_SLASH.add(SLASH389);

            	    pushFollow(FOLLOW_unary_in_term6060);
            	    r=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(r.getTree());


            	    // AST REWRITE
            	    // elements: term, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 534:36: -> ^( DIV $term $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:534:39: ^( DIV $term $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DIV, "DIV"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 3 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:535:11: REM r= unary
            	    {
            	    REM390=(Token)match(input,REM,FOLLOW_REM_in_term6095); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_REM.add(REM390);

            	    pushFollow(FOLLOW_unary_in_term6099);
            	    r=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(r.getTree());


            	    // AST REWRITE
            	    // elements: term, r, REM
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 535:34: -> ^( REM $term $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:535:37: ^( REM $term $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_REM.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 4 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:536:11: UDIV r= unary
            	    {
            	    UDIV391=(Token)match(input,UDIV,FOLLOW_UDIV_in_term6134); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_UDIV.add(UDIV391);

            	    pushFollow(FOLLOW_unary_in_term6138);
            	    r=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(r.getTree());


            	    // AST REWRITE
            	    // elements: r, term, UDIV
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 536:35: -> ^( UDIV $term $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:536:38: ^( UDIV $term $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_UDIV.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 5 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:537:11: UREM r= unary
            	    {
            	    UREM392=(Token)match(input,UREM,FOLLOW_UREM_in_term6173); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_UREM.add(UREM392);

            	    pushFollow(FOLLOW_unary_in_term6177);
            	    r=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(r.getTree());


            	    // AST REWRITE
            	    // elements: UREM, term, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 537:35: -> ^( UREM $term $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:537:38: ^( UREM $term $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_UREM.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 6 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:538:11: MOD r= unary
            	    {
            	    MOD393=(Token)match(input,MOD,FOLLOW_MOD_in_term6212); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_MOD.add(MOD393);

            	    pushFollow(FOLLOW_unary_in_term6216);
            	    r=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_unary.add(r.getTree());


            	    // AST REWRITE
            	    // elements: term, MOD, r
            	    // token labels: 
            	    // rule labels: retval, r
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 538:34: -> ^( MOD $term $r)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:538:37: ^( MOD $term $r)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot(stream_MOD.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_r.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop114;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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

    public static class unary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:543:1: unary : ( MINUS u= unary -> ^( NEG $u) | TILDE u= unary -> ^( INV $u) | ( lhs PLUSPLUS )=>a= lhs PLUSPLUS -> ^( POSTINC $a) | ( lhs MINUSMINUS )=>a= lhs MINUSMINUS -> ^( POSTDEC $a) | ( atom -> atom ) | PLUSPLUS a= lhs -> ^( PREINC $a) | MINUSMINUS a= lhs -> ^( PREDEC $a) | AMP lhs -> ^( ADDROF lhs ) | SIZEOF atom -> ^( SIZEOF atom ) | TYPEOF atom -> ^( TYPEOF atom ) );
    public final EulangParser.unary_return unary() throws RecognitionException {
        EulangParser.unary_return retval = new EulangParser.unary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MINUS394=null;
        Token TILDE395=null;
        Token PLUSPLUS396=null;
        Token MINUSMINUS397=null;
        Token PLUSPLUS399=null;
        Token MINUSMINUS400=null;
        Token AMP401=null;
        Token SIZEOF403=null;
        Token TYPEOF405=null;
        EulangParser.unary_return u = null;

        EulangParser.lhs_return a = null;

        EulangParser.atom_return atom398 = null;

        EulangParser.lhs_return lhs402 = null;

        EulangParser.atom_return atom404 = null;

        EulangParser.atom_return atom406 = null;


        CommonTree MINUS394_tree=null;
        CommonTree TILDE395_tree=null;
        CommonTree PLUSPLUS396_tree=null;
        CommonTree MINUSMINUS397_tree=null;
        CommonTree PLUSPLUS399_tree=null;
        CommonTree MINUSMINUS400_tree=null;
        CommonTree AMP401_tree=null;
        CommonTree SIZEOF403_tree=null;
        CommonTree TYPEOF405_tree=null;
        RewriteRuleTokenStream stream_SIZEOF=new RewriteRuleTokenStream(adaptor,"token SIZEOF");
        RewriteRuleTokenStream stream_MINUSMINUS=new RewriteRuleTokenStream(adaptor,"token MINUSMINUS");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_TYPEOF=new RewriteRuleTokenStream(adaptor,"token TYPEOF");
        RewriteRuleTokenStream stream_AMP=new RewriteRuleTokenStream(adaptor,"token AMP");
        RewriteRuleTokenStream stream_PLUSPLUS=new RewriteRuleTokenStream(adaptor,"token PLUSPLUS");
        RewriteRuleTokenStream stream_TILDE=new RewriteRuleTokenStream(adaptor,"token TILDE");
        RewriteRuleSubtreeStream stream_unary=new RewriteRuleSubtreeStream(adaptor,"rule unary");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        RewriteRuleSubtreeStream stream_lhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:543:6: ( MINUS u= unary -> ^( NEG $u) | TILDE u= unary -> ^( INV $u) | ( lhs PLUSPLUS )=>a= lhs PLUSPLUS -> ^( POSTINC $a) | ( lhs MINUSMINUS )=>a= lhs MINUSMINUS -> ^( POSTDEC $a) | ( atom -> atom ) | PLUSPLUS a= lhs -> ^( PREINC $a) | MINUSMINUS a= lhs -> ^( PREDEC $a) | AMP lhs -> ^( ADDROF lhs ) | SIZEOF atom -> ^( SIZEOF atom ) | TYPEOF atom -> ^( TYPEOF atom ) )
            int alt115=10;
            alt115 = dfa115.predict(input);
            switch (alt115) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:543:9: MINUS u= unary
                    {
                    MINUS394=(Token)match(input,MINUS,FOLLOW_MINUS_in_unary6289); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS394);

                    pushFollow(FOLLOW_unary_in_unary6293);
                    u=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary.add(u.getTree());


                    // AST REWRITE
                    // elements: u
                    // token labels: 
                    // rule labels: retval, u
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_u=new RewriteRuleSubtreeStream(adaptor,"rule u",u!=null?u.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 543:23: -> ^( NEG $u)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:543:26: ^( NEG $u)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NEG, "NEG"), root_1);

                        adaptor.addChild(root_1, stream_u.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:544:9: TILDE u= unary
                    {
                    TILDE395=(Token)match(input,TILDE,FOLLOW_TILDE_in_unary6313); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TILDE.add(TILDE395);

                    pushFollow(FOLLOW_unary_in_unary6317);
                    u=unary();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unary.add(u.getTree());


                    // AST REWRITE
                    // elements: u
                    // token labels: 
                    // rule labels: retval, u
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_u=new RewriteRuleSubtreeStream(adaptor,"rule u",u!=null?u.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 544:27: -> ^( INV $u)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:544:30: ^( INV $u)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INV, "INV"), root_1);

                        adaptor.addChild(root_1, stream_u.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:545:9: ( lhs PLUSPLUS )=>a= lhs PLUSPLUS
                    {
                    pushFollow(FOLLOW_lhs_in_unary6352);
                    a=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(a.getTree());
                    PLUSPLUS396=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unary6354); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUSPLUS.add(PLUSPLUS396);



                    // AST REWRITE
                    // elements: a
                    // token labels: 
                    // rule labels: retval, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 545:44: -> ^( POSTINC $a)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:545:47: ^( POSTINC $a)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POSTINC, "POSTINC"), root_1);

                        adaptor.addChild(root_1, stream_a.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:546:9: ( lhs MINUSMINUS )=>a= lhs MINUSMINUS
                    {
                    pushFollow(FOLLOW_lhs_in_unary6385);
                    a=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(a.getTree());
                    MINUSMINUS397=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_unary6387); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUSMINUS.add(MINUSMINUS397);



                    // AST REWRITE
                    // elements: a
                    // token labels: 
                    // rule labels: retval, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 546:47: -> ^( POSTDEC $a)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:546:50: ^( POSTDEC $a)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(POSTDEC, "POSTDEC"), root_1);

                        adaptor.addChild(root_1, stream_a.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:547:9: ( atom -> atom )
                    {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:547:9: ( atom -> atom )
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:547:11: atom
                    {
                    pushFollow(FOLLOW_atom_in_unary6408);
                    atom398=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom398.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 547:23: -> atom
                    {
                        adaptor.addChild(root_0, stream_atom.nextTree());

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:548:9: PLUSPLUS a= lhs
                    {
                    PLUSPLUS399=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unary6439); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PLUSPLUS.add(PLUSPLUS399);

                    pushFollow(FOLLOW_lhs_in_unary6443);
                    a=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(a.getTree());


                    // AST REWRITE
                    // elements: a
                    // token labels: 
                    // rule labels: retval, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 548:26: -> ^( PREINC $a)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:548:29: ^( PREINC $a)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREINC, "PREINC"), root_1);

                        adaptor.addChild(root_1, stream_a.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:549:9: MINUSMINUS a= lhs
                    {
                    MINUSMINUS400=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_unary6464); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUSMINUS.add(MINUSMINUS400);

                    pushFollow(FOLLOW_lhs_in_unary6468);
                    a=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(a.getTree());


                    // AST REWRITE
                    // elements: a
                    // token labels: 
                    // rule labels: retval, a
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 549:26: -> ^( PREDEC $a)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:549:29: ^( PREDEC $a)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PREDEC, "PREDEC"), root_1);

                        adaptor.addChild(root_1, stream_a.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:550:10: AMP lhs
                    {
                    AMP401=(Token)match(input,AMP,FOLLOW_AMP_in_unary6488); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AMP.add(AMP401);

                    pushFollow(FOLLOW_lhs_in_unary6490);
                    lhs402=lhs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_lhs.add(lhs402.getTree());


                    // AST REWRITE
                    // elements: lhs
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 550:41: -> ^( ADDROF lhs )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:550:44: ^( ADDROF lhs )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ADDROF, "ADDROF"), root_1);

                        adaptor.addChild(root_1, stream_lhs.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:551:9: SIZEOF atom
                    {
                    SIZEOF403=(Token)match(input,SIZEOF,FOLLOW_SIZEOF_in_unary6531); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SIZEOF.add(SIZEOF403);

                    pushFollow(FOLLOW_atom_in_unary6533);
                    atom404=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom404.getTree());


                    // AST REWRITE
                    // elements: atom, SIZEOF
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 551:27: -> ^( SIZEOF atom )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:551:30: ^( SIZEOF atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_SIZEOF.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:552:9: TYPEOF atom
                    {
                    TYPEOF405=(Token)match(input,TYPEOF,FOLLOW_TYPEOF_in_unary6557); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TYPEOF.add(TYPEOF405);

                    pushFollow(FOLLOW_atom_in_unary6559);
                    atom406=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atom.add(atom406.getTree());


                    // AST REWRITE
                    // elements: atom, TYPEOF
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 552:27: -> ^( TYPEOF atom )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:552:30: ^( TYPEOF atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(stream_TYPEOF.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "unary"

    public static class lhs_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lhs"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:555:1: lhs : ( idExpr -> idExpr | ( tuple )=> tuple -> tuple | NUMBER -> ^( LIT NUMBER ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | LPAREN a1= assignExpr RPAREN -> $a1) ( ( PERIOD ID -> ^( FIELDREF $lhs ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $lhs arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $lhs arrayAccess ) ) | ( CARET -> ^( DEREF $lhs) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $lhs) ) )* ( AS ( PLUS )? type -> ^( CAST ( PLUS )? type $lhs) )? ;
    public final EulangParser.lhs_return lhs() throws RecognitionException {
        EulangParser.lhs_return retval = new EulangParser.lhs_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NUMBER409=null;
        Token CHAR_LITERAL410=null;
        Token STRING_LITERAL411=null;
        Token LPAREN412=null;
        Token RPAREN413=null;
        Token PERIOD414=null;
        Token ID415=null;
        Token LPAREN416=null;
        Token RPAREN418=null;
        Token CARET420=null;
        Token LBRACE421=null;
        Token PLUS422=null;
        Token RBRACE424=null;
        Token AS425=null;
        Token PLUS426=null;
        EulangParser.assignExpr_return a1 = null;

        EulangParser.idExpr_return idExpr407 = null;

        EulangParser.tuple_return tuple408 = null;

        EulangParser.arglist_return arglist417 = null;

        EulangParser.arrayAccess_return arrayAccess419 = null;

        EulangParser.type_return type423 = null;

        EulangParser.type_return type427 = null;


        CommonTree NUMBER409_tree=null;
        CommonTree CHAR_LITERAL410_tree=null;
        CommonTree STRING_LITERAL411_tree=null;
        CommonTree LPAREN412_tree=null;
        CommonTree RPAREN413_tree=null;
        CommonTree PERIOD414_tree=null;
        CommonTree ID415_tree=null;
        CommonTree LPAREN416_tree=null;
        CommonTree RPAREN418_tree=null;
        CommonTree CARET420_tree=null;
        CommonTree LBRACE421_tree=null;
        CommonTree PLUS422_tree=null;
        CommonTree RBRACE424_tree=null;
        CommonTree AS425_tree=null;
        CommonTree PLUS426_tree=null;
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_CARET=new RewriteRuleTokenStream(adaptor,"token CARET");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleSubtreeStream stream_arglist=new RewriteRuleSubtreeStream(adaptor,"rule arglist");
        RewriteRuleSubtreeStream stream_arrayAccess=new RewriteRuleSubtreeStream(adaptor,"rule arrayAccess");
        RewriteRuleSubtreeStream stream_idExpr=new RewriteRuleSubtreeStream(adaptor,"rule idExpr");
        RewriteRuleSubtreeStream stream_tuple=new RewriteRuleSubtreeStream(adaptor,"rule tuple");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:555:5: ( ( idExpr -> idExpr | ( tuple )=> tuple -> tuple | NUMBER -> ^( LIT NUMBER ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | LPAREN a1= assignExpr RPAREN -> $a1) ( ( PERIOD ID -> ^( FIELDREF $lhs ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $lhs arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $lhs arrayAccess ) ) | ( CARET -> ^( DEREF $lhs) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $lhs) ) )* ( AS ( PLUS )? type -> ^( CAST ( PLUS )? type $lhs) )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:556:3: ( idExpr -> idExpr | ( tuple )=> tuple -> tuple | NUMBER -> ^( LIT NUMBER ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | LPAREN a1= assignExpr RPAREN -> $a1) ( ( PERIOD ID -> ^( FIELDREF $lhs ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $lhs arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $lhs arrayAccess ) ) | ( CARET -> ^( DEREF $lhs) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $lhs) ) )* ( AS ( PLUS )? type -> ^( CAST ( PLUS )? type $lhs) )?
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:556:3: ( idExpr -> idExpr | ( tuple )=> tuple -> tuple | NUMBER -> ^( LIT NUMBER ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | LPAREN a1= assignExpr RPAREN -> $a1)
            int alt116=6;
            switch ( input.LA(1) ) {
            case ID:
            case COLON:
            case COLONS:
                {
                alt116=1;
                }
                break;
            case LPAREN:
                {
                int LA116_3 = input.LA(2);

                if ( (synpred23_Eulang()) ) {
                    alt116=2;
                }
                else if ( (true) ) {
                    alt116=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 116, 3, input);

                    throw nvae;
                }
                }
                break;
            case NUMBER:
                {
                alt116=3;
                }
                break;
            case CHAR_LITERAL:
                {
                alt116=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt116=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:557:8: idExpr
                    {
                    pushFollow(FOLLOW_idExpr_in_lhs6594);
                    idExpr407=idExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_idExpr.add(idExpr407.getTree());


                    // AST REWRITE
                    // elements: idExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 557:40: -> idExpr
                    {
                        adaptor.addChild(root_0, stream_idExpr.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:558:9: ( tuple )=> tuple
                    {
                    pushFollow(FOLLOW_tuple_in_lhs6641);
                    tuple408=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tuple.add(tuple408.getTree());


                    // AST REWRITE
                    // elements: tuple
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 558:53: -> tuple
                    {
                        adaptor.addChild(root_0, stream_tuple.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:559:9: NUMBER
                    {
                    NUMBER409=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_lhs6680); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER409);



                    // AST REWRITE
                    // elements: NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 559:41: -> ^( LIT NUMBER )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:559:44: ^( LIT NUMBER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:560:9: CHAR_LITERAL
                    {
                    CHAR_LITERAL410=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_lhs6723); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(CHAR_LITERAL410);



                    // AST REWRITE
                    // elements: CHAR_LITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 560:39: -> ^( LIT CHAR_LITERAL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:560:42: ^( LIT CHAR_LITERAL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_CHAR_LITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:561:9: STRING_LITERAL
                    {
                    STRING_LITERAL411=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_lhs6758); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING_LITERAL.add(STRING_LITERAL411);



                    // AST REWRITE
                    // elements: STRING_LITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 561:39: -> ^( LIT STRING_LITERAL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:561:42: ^( LIT STRING_LITERAL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:562:9: LPAREN a1= assignExpr RPAREN
                    {
                    LPAREN412=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_lhs6791); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN412);

                    pushFollow(FOLLOW_assignExpr_in_lhs6795);
                    a1=assignExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignExpr.add(a1.getTree());
                    RPAREN413=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_lhs6797); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN413);



                    // AST REWRITE
                    // elements: a1
                    // token labels: 
                    // rule labels: retval, a1
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a1=new RewriteRuleSubtreeStream(adaptor,"rule a1",a1!=null?a1.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 562:51: -> $a1
                    {
                        adaptor.addChild(root_0, stream_a1.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:564:5: ( ( PERIOD ID -> ^( FIELDREF $lhs ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $lhs arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $lhs arrayAccess ) ) | ( CARET -> ^( DEREF $lhs) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $lhs) ) )*
            loop118:
            do {
                int alt118=6;
                int LA118_0 = input.LA(1);

                if ( (LA118_0==PERIOD) ) {
                    alt118=1;
                }
                else if ( (LA118_0==LPAREN) ) {
                    alt118=2;
                }
                else if ( (LA118_0==LBRACKET) && (synpred24_Eulang())) {
                    alt118=3;
                }
                else if ( (LA118_0==CARET) ) {
                    alt118=4;
                }
                else if ( (LA118_0==LBRACE) ) {
                    alt118=5;
                }


                switch (alt118) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:565:7: ( PERIOD ID -> ^( FIELDREF $lhs ID ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:565:7: ( PERIOD ID -> ^( FIELDREF $lhs ID ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:565:9: PERIOD ID
            	    {
            	    PERIOD414=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_lhs6840); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD414);

            	    ID415=(Token)match(input,ID,FOLLOW_ID_in_lhs6842); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID415);



            	    // AST REWRITE
            	    // elements: ID, lhs
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 565:20: -> ^( FIELDREF $lhs ID )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:565:23: ^( FIELDREF $lhs ID )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FIELDREF, "FIELDREF"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_ID.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:566:7: ( LPAREN arglist RPAREN -> ^( CALL $lhs arglist ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:566:7: ( LPAREN arglist RPAREN -> ^( CALL $lhs arglist ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:566:10: LPAREN arglist RPAREN
            	    {
            	    LPAREN416=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_lhs6867); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN416);

            	    pushFollow(FOLLOW_arglist_in_lhs6869);
            	    arglist417=arglist();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_arglist.add(arglist417.getTree());
            	    RPAREN418=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_lhs6871); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN418);



            	    // AST REWRITE
            	    // elements: lhs, arglist
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 566:34: -> ^( CALL $lhs arglist )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:566:37: ^( CALL $lhs arglist )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_arglist.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:567:7: ( ( LBRACKET )=> arrayAccess -> ^( INDEX $lhs arrayAccess ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:567:7: ( ( LBRACKET )=> arrayAccess -> ^( INDEX $lhs arrayAccess ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:567:9: ( LBRACKET )=> arrayAccess
            	    {
            	    pushFollow(FOLLOW_arrayAccess_in_lhs6904);
            	    arrayAccess419=arrayAccess();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_arrayAccess.add(arrayAccess419.getTree());


            	    // AST REWRITE
            	    // elements: arrayAccess, lhs
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 567:39: -> ^( INDEX $lhs arrayAccess )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:567:42: ^( INDEX $lhs arrayAccess )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_arrayAccess.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 4 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:568:7: ( CARET -> ^( DEREF $lhs) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:568:7: ( CARET -> ^( DEREF $lhs) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:568:9: CARET
            	    {
            	    CARET420=(Token)match(input,CARET,FOLLOW_CARET_in_lhs6929); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CARET.add(CARET420);



            	    // AST REWRITE
            	    // elements: lhs
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 568:15: -> ^( DEREF $lhs)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:568:18: ^( DEREF $lhs)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEREF, "DEREF"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 5 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:569:7: ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $lhs) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:569:7: ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $lhs) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:569:9: LBRACE ( PLUS )? type RBRACE
            	    {
            	    LBRACE421=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_lhs6950); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE421);

            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:569:16: ( PLUS )?
            	    int alt117=2;
            	    int LA117_0 = input.LA(1);

            	    if ( (LA117_0==PLUS) ) {
            	        alt117=1;
            	    }
            	    switch (alt117) {
            	        case 1 :
            	            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:569:16: PLUS
            	            {
            	            PLUS422=(Token)match(input,PLUS,FOLLOW_PLUS_in_lhs6952); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_PLUS.add(PLUS422);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_type_in_lhs6955);
            	    type423=type();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_type.add(type423.getTree());
            	    RBRACE424=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_lhs6957); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE424);



            	    // AST REWRITE
            	    // elements: lhs, type, PLUS
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 569:34: -> ^( CAST ( PLUS )? type $lhs)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:569:37: ^( CAST ( PLUS )? type $lhs)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAST, "CAST"), root_1);

            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:569:44: ( PLUS )?
            	        if ( stream_PLUS.hasNext() ) {
            	            adaptor.addChild(root_1, stream_PLUS.nextNode());

            	        }
            	        stream_PLUS.reset();
            	        adaptor.addChild(root_1, stream_type.nextTree());
            	        adaptor.addChild(root_1, stream_retval.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;

            	default :
            	    break loop118;
                }
            } while (true);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:572:5: ( AS ( PLUS )? type -> ^( CAST ( PLUS )? type $lhs) )?
            int alt120=2;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==AS) ) {
                alt120=1;
            }
            switch (alt120) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:573:7: AS ( PLUS )? type
                    {
                    AS425=(Token)match(input,AS,FOLLOW_AS_in_lhs6998); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS425);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:573:10: ( PLUS )?
                    int alt119=2;
                    int LA119_0 = input.LA(1);

                    if ( (LA119_0==PLUS) ) {
                        alt119=1;
                    }
                    switch (alt119) {
                        case 1 :
                            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:573:10: PLUS
                            {
                            PLUS426=(Token)match(input,PLUS,FOLLOW_PLUS_in_lhs7000); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_PLUS.add(PLUS426);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_type_in_lhs7003);
                    type427=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type427.getTree());


                    // AST REWRITE
                    // elements: PLUS, type, lhs
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 573:21: -> ^( CAST ( PLUS )? type $lhs)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:573:24: ^( CAST ( PLUS )? type $lhs)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAST, "CAST"), root_1);

                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:573:31: ( PLUS )?
                        if ( stream_PLUS.hasNext() ) {
                            adaptor.addChild(root_1, stream_PLUS.nextNode());

                        }
                        stream_PLUS.reset();
                        adaptor.addChild(root_1, stream_type.nextTree());
                        adaptor.addChild(root_1, stream_retval.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "lhs"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:577:1: atom : ( NUMBER -> ^( LIT NUMBER ) | FALSE -> ^( LIT FALSE ) | TRUE -> ^( LIT TRUE ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | NIL -> ^( LIT NIL ) | idExpr -> idExpr | ( tuple )=> tuple -> tuple | ( LPAREN varDecl )=> LPAREN a0= varDecl RPAREN -> $a0 | LPAREN a1= assignExpr RPAREN -> $a1 | ( CODE )=> code -> code ) ( ( PERIOD ID -> ^( FIELDREF $atom ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $atom arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $atom arrayAccess ) ) | ( CARET -> ^( DEREF $atom) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $atom) ) )* ( AS type -> ^( CAST type $atom) )? ;
    public final EulangParser.atom_return atom() throws RecognitionException {
        EulangParser.atom_return retval = new EulangParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NUMBER428=null;
        Token FALSE429=null;
        Token TRUE430=null;
        Token CHAR_LITERAL431=null;
        Token STRING_LITERAL432=null;
        Token NIL433=null;
        Token LPAREN436=null;
        Token RPAREN437=null;
        Token LPAREN438=null;
        Token RPAREN439=null;
        Token PERIOD441=null;
        Token ID442=null;
        Token LPAREN443=null;
        Token RPAREN445=null;
        Token CARET447=null;
        Token LBRACE448=null;
        Token PLUS449=null;
        Token RBRACE451=null;
        Token AS452=null;
        EulangParser.varDecl_return a0 = null;

        EulangParser.assignExpr_return a1 = null;

        EulangParser.idExpr_return idExpr434 = null;

        EulangParser.tuple_return tuple435 = null;

        EulangParser.code_return code440 = null;

        EulangParser.arglist_return arglist444 = null;

        EulangParser.arrayAccess_return arrayAccess446 = null;

        EulangParser.type_return type450 = null;

        EulangParser.type_return type453 = null;


        CommonTree NUMBER428_tree=null;
        CommonTree FALSE429_tree=null;
        CommonTree TRUE430_tree=null;
        CommonTree CHAR_LITERAL431_tree=null;
        CommonTree STRING_LITERAL432_tree=null;
        CommonTree NIL433_tree=null;
        CommonTree LPAREN436_tree=null;
        CommonTree RPAREN437_tree=null;
        CommonTree LPAREN438_tree=null;
        CommonTree RPAREN439_tree=null;
        CommonTree PERIOD441_tree=null;
        CommonTree ID442_tree=null;
        CommonTree LPAREN443_tree=null;
        CommonTree RPAREN445_tree=null;
        CommonTree CARET447_tree=null;
        CommonTree LBRACE448_tree=null;
        CommonTree PLUS449_tree=null;
        CommonTree RBRACE451_tree=null;
        CommonTree AS452_tree=null;
        RewriteRuleTokenStream stream_AS=new RewriteRuleTokenStream(adaptor,"token AS");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_NIL=new RewriteRuleTokenStream(adaptor,"token NIL");
        RewriteRuleTokenStream stream_CHAR_LITERAL=new RewriteRuleTokenStream(adaptor,"token CHAR_LITERAL");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleTokenStream stream_CARET=new RewriteRuleTokenStream(adaptor,"token CARET");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleTokenStream stream_NUMBER=new RewriteRuleTokenStream(adaptor,"token NUMBER");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_FALSE=new RewriteRuleTokenStream(adaptor,"token FALSE");
        RewriteRuleTokenStream stream_TRUE=new RewriteRuleTokenStream(adaptor,"token TRUE");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_arglist=new RewriteRuleSubtreeStream(adaptor,"rule arglist");
        RewriteRuleSubtreeStream stream_arrayAccess=new RewriteRuleSubtreeStream(adaptor,"rule arrayAccess");
        RewriteRuleSubtreeStream stream_idExpr=new RewriteRuleSubtreeStream(adaptor,"rule idExpr");
        RewriteRuleSubtreeStream stream_tuple=new RewriteRuleSubtreeStream(adaptor,"rule tuple");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        RewriteRuleSubtreeStream stream_code=new RewriteRuleSubtreeStream(adaptor,"rule code");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:577:6: ( ( NUMBER -> ^( LIT NUMBER ) | FALSE -> ^( LIT FALSE ) | TRUE -> ^( LIT TRUE ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | NIL -> ^( LIT NIL ) | idExpr -> idExpr | ( tuple )=> tuple -> tuple | ( LPAREN varDecl )=> LPAREN a0= varDecl RPAREN -> $a0 | LPAREN a1= assignExpr RPAREN -> $a1 | ( CODE )=> code -> code ) ( ( PERIOD ID -> ^( FIELDREF $atom ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $atom arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $atom arrayAccess ) ) | ( CARET -> ^( DEREF $atom) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $atom) ) )* ( AS type -> ^( CAST type $atom) )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:578:3: ( NUMBER -> ^( LIT NUMBER ) | FALSE -> ^( LIT FALSE ) | TRUE -> ^( LIT TRUE ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | NIL -> ^( LIT NIL ) | idExpr -> idExpr | ( tuple )=> tuple -> tuple | ( LPAREN varDecl )=> LPAREN a0= varDecl RPAREN -> $a0 | LPAREN a1= assignExpr RPAREN -> $a1 | ( CODE )=> code -> code ) ( ( PERIOD ID -> ^( FIELDREF $atom ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $atom arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $atom arrayAccess ) ) | ( CARET -> ^( DEREF $atom) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $atom) ) )* ( AS type -> ^( CAST type $atom) )?
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:578:3: ( NUMBER -> ^( LIT NUMBER ) | FALSE -> ^( LIT FALSE ) | TRUE -> ^( LIT TRUE ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | NIL -> ^( LIT NIL ) | idExpr -> idExpr | ( tuple )=> tuple -> tuple | ( LPAREN varDecl )=> LPAREN a0= varDecl RPAREN -> $a0 | LPAREN a1= assignExpr RPAREN -> $a1 | ( CODE )=> code -> code )
            int alt121=11;
            alt121 = dfa121.predict(input);
            switch (alt121) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:579:7: NUMBER
                    {
                    NUMBER428=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_atom7052); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NUMBER.add(NUMBER428);



                    // AST REWRITE
                    // elements: NUMBER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 579:39: -> ^( LIT NUMBER )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:579:42: ^( LIT NUMBER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_NUMBER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:580:9: FALSE
                    {
                    FALSE429=(Token)match(input,FALSE,FOLLOW_FALSE_in_atom7095); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FALSE.add(FALSE429);



                    // AST REWRITE
                    // elements: FALSE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 580:39: -> ^( LIT FALSE )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:580:42: ^( LIT FALSE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_FALSE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:581:9: TRUE
                    {
                    TRUE430=(Token)match(input,TRUE,FOLLOW_TRUE_in_atom7137); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRUE.add(TRUE430);



                    // AST REWRITE
                    // elements: TRUE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 581:39: -> ^( LIT TRUE )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:581:42: ^( LIT TRUE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_TRUE.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:582:9: CHAR_LITERAL
                    {
                    CHAR_LITERAL431=(Token)match(input,CHAR_LITERAL,FOLLOW_CHAR_LITERAL_in_atom7180); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHAR_LITERAL.add(CHAR_LITERAL431);



                    // AST REWRITE
                    // elements: CHAR_LITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 582:39: -> ^( LIT CHAR_LITERAL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:582:42: ^( LIT CHAR_LITERAL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_CHAR_LITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:583:9: STRING_LITERAL
                    {
                    STRING_LITERAL432=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom7215); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRING_LITERAL.add(STRING_LITERAL432);



                    // AST REWRITE
                    // elements: STRING_LITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 583:39: -> ^( LIT STRING_LITERAL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:583:42: ^( LIT STRING_LITERAL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_STRING_LITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:584:9: NIL
                    {
                    NIL433=(Token)match(input,NIL,FOLLOW_NIL_in_atom7248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NIL.add(NIL433);



                    // AST REWRITE
                    // elements: NIL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 584:38: -> ^( LIT NIL )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:584:41: ^( LIT NIL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIT, "LIT"), root_1);

                        adaptor.addChild(root_1, stream_NIL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:585:9: idExpr
                    {
                    pushFollow(FOLLOW_idExpr_in_atom7291);
                    idExpr434=idExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_idExpr.add(idExpr434.getTree());


                    // AST REWRITE
                    // elements: idExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 585:41: -> idExpr
                    {
                        adaptor.addChild(root_0, stream_idExpr.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:586:9: ( tuple )=> tuple
                    {
                    pushFollow(FOLLOW_tuple_in_atom7338);
                    tuple435=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_tuple.add(tuple435.getTree());


                    // AST REWRITE
                    // elements: tuple
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 586:53: -> tuple
                    {
                        adaptor.addChild(root_0, stream_tuple.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:587:9: ( LPAREN varDecl )=> LPAREN a0= varDecl RPAREN
                    {
                    LPAREN436=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom7387); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN436);

                    pushFollow(FOLLOW_varDecl_in_atom7391);
                    a0=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_varDecl.add(a0.getTree());
                    RPAREN437=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom7393); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN437);



                    // AST REWRITE
                    // elements: a0
                    // token labels: 
                    // rule labels: retval, a0
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a0=new RewriteRuleSubtreeStream(adaptor,"rule a0",a0!=null?a0.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 587:70: -> $a0
                    {
                        adaptor.addChild(root_0, stream_a0.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:588:9: LPAREN a1= assignExpr RPAREN
                    {
                    LPAREN438=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom7422); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN438);

                    pushFollow(FOLLOW_assignExpr_in_atom7426);
                    a1=assignExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignExpr.add(a1.getTree());
                    RPAREN439=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom7428); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN439);



                    // AST REWRITE
                    // elements: a1
                    // token labels: 
                    // rule labels: retval, a1
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_a1=new RewriteRuleSubtreeStream(adaptor,"rule a1",a1!=null?a1.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 588:51: -> $a1
                    {
                        adaptor.addChild(root_0, stream_a1.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:589:9: ( CODE )=> code
                    {
                    pushFollow(FOLLOW_code_in_atom7466);
                    code440=code();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_code.add(code440.getTree());


                    // AST REWRITE
                    // elements: code
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 589:53: -> code
                    {
                        adaptor.addChild(root_0, stream_code.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:593:5: ( ( PERIOD ID -> ^( FIELDREF $atom ID ) ) | ( LPAREN arglist RPAREN -> ^( CALL $atom arglist ) ) | ( ( LBRACKET )=> arrayAccess -> ^( INDEX $atom arrayAccess ) ) | ( CARET -> ^( DEREF $atom) ) | ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $atom) ) )*
            loop123:
            do {
                int alt123=6;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==PERIOD) ) {
                    alt123=1;
                }
                else if ( (LA123_0==LPAREN) ) {
                    alt123=2;
                }
                else if ( (LA123_0==LBRACKET) && (synpred28_Eulang())) {
                    alt123=3;
                }
                else if ( (LA123_0==CARET) ) {
                    alt123=4;
                }
                else if ( (LA123_0==LBRACE) ) {
                    alt123=5;
                }


                switch (alt123) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:594:7: ( PERIOD ID -> ^( FIELDREF $atom ID ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:594:7: ( PERIOD ID -> ^( FIELDREF $atom ID ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:594:9: PERIOD ID
            	    {
            	    PERIOD441=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_atom7525); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD441);

            	    ID442=(Token)match(input,ID,FOLLOW_ID_in_atom7527); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID442);



            	    // AST REWRITE
            	    // elements: atom, ID
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 594:20: -> ^( FIELDREF $atom ID )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:594:23: ^( FIELDREF $atom ID )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FIELDREF, "FIELDREF"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_ID.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:595:7: ( LPAREN arglist RPAREN -> ^( CALL $atom arglist ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:595:7: ( LPAREN arglist RPAREN -> ^( CALL $atom arglist ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:595:10: LPAREN arglist RPAREN
            	    {
            	    LPAREN443=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom7552); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN443);

            	    pushFollow(FOLLOW_arglist_in_atom7554);
            	    arglist444=arglist();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_arglist.add(arglist444.getTree());
            	    RPAREN445=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom7556); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN445);



            	    // AST REWRITE
            	    // elements: arglist, atom
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 595:34: -> ^( CALL $atom arglist )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:595:37: ^( CALL $atom arglist )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CALL, "CALL"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_arglist.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:596:7: ( ( LBRACKET )=> arrayAccess -> ^( INDEX $atom arrayAccess ) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:596:7: ( ( LBRACKET )=> arrayAccess -> ^( INDEX $atom arrayAccess ) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:596:9: ( LBRACKET )=> arrayAccess
            	    {
            	    pushFollow(FOLLOW_arrayAccess_in_atom7589);
            	    arrayAccess446=arrayAccess();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_arrayAccess.add(arrayAccess446.getTree());


            	    // AST REWRITE
            	    // elements: atom, arrayAccess
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 596:39: -> ^( INDEX $atom arrayAccess )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:596:42: ^( INDEX $atom arrayAccess )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_arrayAccess.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 4 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:597:7: ( CARET -> ^( DEREF $atom) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:597:7: ( CARET -> ^( DEREF $atom) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:597:9: CARET
            	    {
            	    CARET447=(Token)match(input,CARET,FOLLOW_CARET_in_atom7614); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CARET.add(CARET447);



            	    // AST REWRITE
            	    // elements: atom
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 597:15: -> ^( DEREF $atom)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:597:18: ^( DEREF $atom)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DEREF, "DEREF"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;
            	case 5 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:598:7: ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $atom) )
            	    {
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:598:7: ( LBRACE ( PLUS )? type RBRACE -> ^( CAST ( PLUS )? type $atom) )
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:598:9: LBRACE ( PLUS )? type RBRACE
            	    {
            	    LBRACE448=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_atom7635); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE448);

            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:598:16: ( PLUS )?
            	    int alt122=2;
            	    int LA122_0 = input.LA(1);

            	    if ( (LA122_0==PLUS) ) {
            	        alt122=1;
            	    }
            	    switch (alt122) {
            	        case 1 :
            	            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:598:16: PLUS
            	            {
            	            PLUS449=(Token)match(input,PLUS,FOLLOW_PLUS_in_atom7637); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_PLUS.add(PLUS449);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_type_in_atom7640);
            	    type450=type();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_type.add(type450.getTree());
            	    RBRACE451=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_atom7642); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE451);



            	    // AST REWRITE
            	    // elements: atom, PLUS, type
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 598:34: -> ^( CAST ( PLUS )? type $atom)
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:598:37: ^( CAST ( PLUS )? type $atom)
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAST, "CAST"), root_1);

            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:598:44: ( PLUS )?
            	        if ( stream_PLUS.hasNext() ) {
            	            adaptor.addChild(root_1, stream_PLUS.nextNode());

            	        }
            	        stream_PLUS.reset();
            	        adaptor.addChild(root_1, stream_type.nextTree());
            	        adaptor.addChild(root_1, stream_retval.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }


            	    }
            	    break;

            	default :
            	    break loop123;
                }
            } while (true);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:601:5: ( AS type -> ^( CAST type $atom) )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==AS) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:602:7: AS type
                    {
                    AS452=(Token)match(input,AS,FOLLOW_AS_in_atom7683); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_AS.add(AS452);

                    pushFollow(FOLLOW_type_in_atom7685);
                    type453=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type.add(type453.getTree());


                    // AST REWRITE
                    // elements: atom, type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 602:15: -> ^( CAST type $atom)
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:602:18: ^( CAST type $atom)
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CAST, "CAST"), root_1);

                        adaptor.addChild(root_1, stream_type.nextTree());
                        adaptor.addChild(root_1, stream_retval.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "atom"

    public static class arrayAccess_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayAccess"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:606:1: arrayAccess : LBRACKET assignExpr ( COMMA assignExpr )* RBRACKET -> ( assignExpr )+ ;
    public final EulangParser.arrayAccess_return arrayAccess() throws RecognitionException {
        EulangParser.arrayAccess_return retval = new EulangParser.arrayAccess_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBRACKET454=null;
        Token COMMA456=null;
        Token RBRACKET458=null;
        EulangParser.assignExpr_return assignExpr455 = null;

        EulangParser.assignExpr_return assignExpr457 = null;


        CommonTree LBRACKET454_tree=null;
        CommonTree COMMA456_tree=null;
        CommonTree RBRACKET458_tree=null;
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignExpr=new RewriteRuleSubtreeStream(adaptor,"rule assignExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:606:13: ( LBRACKET assignExpr ( COMMA assignExpr )* RBRACKET -> ( assignExpr )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:606:15: LBRACKET assignExpr ( COMMA assignExpr )* RBRACKET
            {
            LBRACKET454=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_arrayAccess7719); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET454);

            pushFollow(FOLLOW_assignExpr_in_arrayAccess7721);
            assignExpr455=assignExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignExpr.add(assignExpr455.getTree());
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:606:35: ( COMMA assignExpr )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==COMMA) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:606:36: COMMA assignExpr
            	    {
            	    COMMA456=(Token)match(input,COMMA,FOLLOW_COMMA_in_arrayAccess7724); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA456);

            	    pushFollow(FOLLOW_assignExpr_in_arrayAccess7726);
            	    assignExpr457=assignExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assignExpr.add(assignExpr457.getTree());

            	    }
            	    break;

            	default :
            	    break loop125;
                }
            } while (true);

            RBRACKET458=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_arrayAccess7730); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET458);



            // AST REWRITE
            // elements: assignExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 606:65: -> ( assignExpr )+
            {
                if ( !(stream_assignExpr.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_assignExpr.hasNext() ) {
                    adaptor.addChild(root_0, stream_assignExpr.nextTree());

                }
                stream_assignExpr.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "arrayAccess"

    public static class idExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:608:1: idExpr : ( idOrScopeRef -> idOrScopeRef ) ( PERIOD ID -> ^( FIELDREF $idExpr ID ) )* ( ( instantiation )=> instantiation -> ^( INSTANCE $idExpr instantiation ) )? ;
    public final EulangParser.idExpr_return idExpr() throws RecognitionException {
        EulangParser.idExpr_return retval = new EulangParser.idExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PERIOD460=null;
        Token ID461=null;
        EulangParser.idOrScopeRef_return idOrScopeRef459 = null;

        EulangParser.instantiation_return instantiation462 = null;


        CommonTree PERIOD460_tree=null;
        CommonTree ID461_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_idOrScopeRef=new RewriteRuleSubtreeStream(adaptor,"rule idOrScopeRef");
        RewriteRuleSubtreeStream stream_instantiation=new RewriteRuleSubtreeStream(adaptor,"rule instantiation");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:608:8: ( ( idOrScopeRef -> idOrScopeRef ) ( PERIOD ID -> ^( FIELDREF $idExpr ID ) )* ( ( instantiation )=> instantiation -> ^( INSTANCE $idExpr instantiation ) )? )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:609:5: ( idOrScopeRef -> idOrScopeRef ) ( PERIOD ID -> ^( FIELDREF $idExpr ID ) )* ( ( instantiation )=> instantiation -> ^( INSTANCE $idExpr instantiation ) )?
            {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:609:5: ( idOrScopeRef -> idOrScopeRef )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:609:7: idOrScopeRef
            {
            pushFollow(FOLLOW_idOrScopeRef_in_idExpr7752);
            idOrScopeRef459=idOrScopeRef();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_idOrScopeRef.add(idOrScopeRef459.getTree());


            // AST REWRITE
            // elements: idOrScopeRef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 609:20: -> idOrScopeRef
            {
                adaptor.addChild(root_0, stream_idOrScopeRef.nextTree());

            }

            retval.tree = root_0;}
            }

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:610:7: ( PERIOD ID -> ^( FIELDREF $idExpr ID ) )*
            loop126:
            do {
                int alt126=2;
                int LA126_0 = input.LA(1);

                if ( (LA126_0==PERIOD) ) {
                    int LA126_2 = input.LA(2);

                    if ( (LA126_2==ID) ) {
                        alt126=1;
                    }


                }


                switch (alt126) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:610:9: PERIOD ID
            	    {
            	    PERIOD460=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_idExpr7768); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD460);

            	    ID461=(Token)match(input,ID,FOLLOW_ID_in_idExpr7770); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID461);



            	    // AST REWRITE
            	    // elements: ID, idExpr
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (CommonTree)adaptor.nil();
            	    // 610:20: -> ^( FIELDREF $idExpr ID )
            	    {
            	        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:610:23: ^( FIELDREF $idExpr ID )
            	        {
            	        CommonTree root_1 = (CommonTree)adaptor.nil();
            	        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FIELDREF, "FIELDREF"), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        adaptor.addChild(root_1, stream_ID.nextNode());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop126;
                }
            } while (true);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:611:5: ( ( instantiation )=> instantiation -> ^( INSTANCE $idExpr instantiation ) )?
            int alt127=2;
            alt127 = dfa127.predict(input);
            switch (alt127) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:611:7: ( instantiation )=> instantiation
                    {
                    pushFollow(FOLLOW_instantiation_in_idExpr7800);
                    instantiation462=instantiation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_instantiation.add(instantiation462.getTree());


                    // AST REWRITE
                    // elements: idExpr, instantiation
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 611:41: -> ^( INSTANCE $idExpr instantiation )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:611:44: ^( INSTANCE $idExpr instantiation )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INSTANCE, "INSTANCE"), root_1);

                        adaptor.addChild(root_1, stream_retval.nextTree());
                        adaptor.addChild(root_1, stream_instantiation.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "idExpr"

    public static class namespaceRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "namespaceRef"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:613:1: namespaceRef : ( ID ( PERIOD ID )* -> ^( IDREF ( ID )+ ) | c= colons ID ( PERIOD ID )* -> ^( IDREF ( ID )+ ) );
    public final EulangParser.namespaceRef_return namespaceRef() throws RecognitionException {
        EulangParser.namespaceRef_return retval = new EulangParser.namespaceRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID463=null;
        Token PERIOD464=null;
        Token ID465=null;
        Token ID466=null;
        Token PERIOD467=null;
        Token ID468=null;
        EulangParser.colons_return c = null;


        CommonTree ID463_tree=null;
        CommonTree PERIOD464_tree=null;
        CommonTree ID465_tree=null;
        CommonTree ID466_tree=null;
        CommonTree PERIOD467_tree=null;
        CommonTree ID468_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_PERIOD=new RewriteRuleTokenStream(adaptor,"token PERIOD");
        RewriteRuleSubtreeStream stream_colons=new RewriteRuleSubtreeStream(adaptor,"rule colons");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:613:14: ( ID ( PERIOD ID )* -> ^( IDREF ( ID )+ ) | c= colons ID ( PERIOD ID )* -> ^( IDREF ( ID )+ ) )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==ID) ) {
                alt130=1;
            }
            else if ( (LA130_0==COLON||LA130_0==COLONS) ) {
                alt130=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }
            switch (alt130) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:614:5: ID ( PERIOD ID )*
                    {
                    ID463=(Token)match(input,ID,FOLLOW_ID_in_namespaceRef7831); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID463);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:614:8: ( PERIOD ID )*
                    loop128:
                    do {
                        int alt128=2;
                        int LA128_0 = input.LA(1);

                        if ( (LA128_0==PERIOD) ) {
                            alt128=1;
                        }


                        switch (alt128) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:614:9: PERIOD ID
                    	    {
                    	    PERIOD464=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_namespaceRef7834); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD464);

                    	    ID465=(Token)match(input,ID,FOLLOW_ID_in_namespaceRef7836); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID465);


                    	    }
                    	    break;

                    	default :
                    	    break loop128;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 614:22: -> ^( IDREF ( ID )+ )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:614:25: ^( IDREF ( ID )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IDREF, "IDREF"), root_1);

                        if ( !(stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext() ) {
                            adaptor.addChild(root_1, stream_ID.nextNode());

                        }
                        stream_ID.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:615:7: c= colons ID ( PERIOD ID )*
                    {
                    pushFollow(FOLLOW_colons_in_namespaceRef7860);
                    c=colons();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_colons.add(c.getTree());
                    ID466=(Token)match(input,ID,FOLLOW_ID_in_namespaceRef7862); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID466);

                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:615:19: ( PERIOD ID )*
                    loop129:
                    do {
                        int alt129=2;
                        int LA129_0 = input.LA(1);

                        if ( (LA129_0==PERIOD) ) {
                            alt129=1;
                        }


                        switch (alt129) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:615:20: PERIOD ID
                    	    {
                    	    PERIOD467=(Token)match(input,PERIOD,FOLLOW_PERIOD_in_namespaceRef7865); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_PERIOD.add(PERIOD467);

                    	    ID468=(Token)match(input,ID,FOLLOW_ID_in_namespaceRef7867); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID468);


                    	    }
                    	    break;

                    	default :
                    	    break loop129;
                        }
                    } while (true);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 615:33: -> ^( IDREF ( ID )+ )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:615:36: ^( IDREF ( ID )+ )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IDREF, "IDREF"), root_1);

                        adaptor.addChild(root_1, split((c!=null?((CommonTree)c.tree):null)));
                        if ( !(stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext() ) {
                            adaptor.addChild(root_1, stream_ID.nextNode());

                        }
                        stream_ID.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "namespaceRef"

    public static class instantiation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instantiation"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:1: instantiation : LESS ( instanceExpr ( COMMA instanceExpr )* )? GREATER -> ^( LIST ( instanceExpr )* ) ;
    public final EulangParser.instantiation_return instantiation() throws RecognitionException {
        EulangParser.instantiation_return retval = new EulangParser.instantiation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LESS469=null;
        Token COMMA471=null;
        Token GREATER473=null;
        EulangParser.instanceExpr_return instanceExpr470 = null;

        EulangParser.instanceExpr_return instanceExpr472 = null;


        CommonTree LESS469_tree=null;
        CommonTree COMMA471_tree=null;
        CommonTree GREATER473_tree=null;
        RewriteRuleTokenStream stream_GREATER=new RewriteRuleTokenStream(adaptor,"token GREATER");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LESS=new RewriteRuleTokenStream(adaptor,"token LESS");
        RewriteRuleSubtreeStream stream_instanceExpr=new RewriteRuleSubtreeStream(adaptor,"rule instanceExpr");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:15: ( LESS ( instanceExpr ( COMMA instanceExpr )* )? GREATER -> ^( LIST ( instanceExpr )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:17: LESS ( instanceExpr ( COMMA instanceExpr )* )? GREATER
            {
            LESS469=(Token)match(input,LESS,FOLLOW_LESS_in_instantiation7896); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LESS.add(LESS469);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:22: ( instanceExpr ( COMMA instanceExpr )* )?
            int alt132=2;
            int LA132_0 = input.LA(1);

            if ( (LA132_0==CODE||LA132_0==ID||LA132_0==COLON||LA132_0==LPAREN||LA132_0==NIL||(LA132_0>=NUMBER && LA132_0<=STRING_LITERAL)||(LA132_0>=FALSE && LA132_0<=DATA)) ) {
                alt132=1;
            }
            switch (alt132) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:23: instanceExpr ( COMMA instanceExpr )*
                    {
                    pushFollow(FOLLOW_instanceExpr_in_instantiation7899);
                    instanceExpr470=instanceExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_instanceExpr.add(instanceExpr470.getTree());
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:36: ( COMMA instanceExpr )*
                    loop131:
                    do {
                        int alt131=2;
                        int LA131_0 = input.LA(1);

                        if ( (LA131_0==COMMA) ) {
                            alt131=1;
                        }


                        switch (alt131) {
                    	case 1 :
                    	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:37: COMMA instanceExpr
                    	    {
                    	    COMMA471=(Token)match(input,COMMA,FOLLOW_COMMA_in_instantiation7902); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA471);

                    	    pushFollow(FOLLOW_instanceExpr_in_instantiation7904);
                    	    instanceExpr472=instanceExpr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_instanceExpr.add(instanceExpr472.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop131;
                        }
                    } while (true);


                    }
                    break;

            }

            GREATER473=(Token)match(input,GREATER,FOLLOW_GREATER_in_instantiation7910); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GREATER.add(GREATER473);



            // AST REWRITE
            // elements: instanceExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 618:70: -> ^( LIST ( instanceExpr )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:73: ^( LIST ( instanceExpr )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(LIST, "LIST"), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:618:80: ( instanceExpr )*
                while ( stream_instanceExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_instanceExpr.nextTree());

                }
                stream_instanceExpr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "instantiation"

    public static class instanceExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instanceExpr"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:621:1: instanceExpr options {backtrack=true; } : ( type | atom );
    public final EulangParser.instanceExpr_return instanceExpr() throws RecognitionException {
        EulangParser.instanceExpr_return retval = new EulangParser.instanceExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        EulangParser.type_return type474 = null;

        EulangParser.atom_return atom475 = null;



        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:621:41: ( type | atom )
            int alt133=2;
            alt133 = dfa133.predict(input);
            switch (alt133) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:621:43: type
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_type_in_instanceExpr7942);
                    type474=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, type474.getTree());

                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:621:50: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_instanceExpr7946);
                    atom475=atom();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom475.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "instanceExpr"

    public static class idOrScopeRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "idOrScopeRef"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:622:1: idOrScopeRef : ( ID -> ^( IDREF ID ) | c= colons ID -> ^( IDREF ID ) );
    public final EulangParser.idOrScopeRef_return idOrScopeRef() throws RecognitionException {
        EulangParser.idOrScopeRef_return retval = new EulangParser.idOrScopeRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID476=null;
        Token ID477=null;
        EulangParser.colons_return c = null;


        CommonTree ID476_tree=null;
        CommonTree ID477_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_colons=new RewriteRuleSubtreeStream(adaptor,"rule colons");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:622:14: ( ID -> ^( IDREF ID ) | c= colons ID -> ^( IDREF ID ) )
            int alt134=2;
            int LA134_0 = input.LA(1);

            if ( (LA134_0==ID) ) {
                alt134=1;
            }
            else if ( (LA134_0==COLON||LA134_0==COLONS) ) {
                alt134=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 134, 0, input);

                throw nvae;
            }
            switch (alt134) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:622:16: ID
                    {
                    ID476=(Token)match(input,ID,FOLLOW_ID_in_idOrScopeRef7954); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID476);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 622:20: -> ^( IDREF ID )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:622:23: ^( IDREF ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IDREF, "IDREF"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:623:9: c= colons ID
                    {
                    pushFollow(FOLLOW_colons_in_idOrScopeRef7977);
                    c=colons();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_colons.add(c.getTree());
                    ID477=(Token)match(input,ID,FOLLOW_ID_in_idOrScopeRef7979); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID477);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 623:21: -> ^( IDREF ID )
                    {
                        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:623:24: ^( IDREF ID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(IDREF, "IDREF"), root_1);

                        adaptor.addChild(root_1, split((c!=null?((CommonTree)c.tree):null)));
                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "idOrScopeRef"

    public static class colons_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "colons"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:626:1: colons : ( COLON | COLONS )+ ;
    public final EulangParser.colons_return colons() throws RecognitionException {
        EulangParser.colons_return retval = new EulangParser.colons_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set478=null;

        CommonTree set478_tree=null;

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:626:8: ( ( COLON | COLONS )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:626:10: ( COLON | COLONS )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:626:10: ( COLON | COLONS )+
            int cnt135=0;
            loop135:
            do {
                int alt135=2;
                int LA135_0 = input.LA(1);

                if ( (LA135_0==COLON||LA135_0==COLONS) ) {
                    alt135=1;
                }


                switch (alt135) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:
            	    {
            	    set478=(Token)input.LT(1);
            	    if ( input.LA(1)==COLON||input.LA(1)==COLONS ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set478));
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt135 >= 1 ) break loop135;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(135, input);
                        throw eee;
                }
                cnt135++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "colons"

    public static class data_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "data"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:628:1: data : DATA LBRACE ( fieldDecl )* RBRACE -> ^( DATA ( fieldDecl )* ) ;
    public final EulangParser.data_return data() throws RecognitionException {
        EulangParser.data_return retval = new EulangParser.data_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DATA479=null;
        Token LBRACE480=null;
        Token RBRACE482=null;
        EulangParser.fieldDecl_return fieldDecl481 = null;


        CommonTree DATA479_tree=null;
        CommonTree LBRACE480_tree=null;
        CommonTree RBRACE482_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_DATA=new RewriteRuleTokenStream(adaptor,"token DATA");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_fieldDecl=new RewriteRuleSubtreeStream(adaptor,"rule fieldDecl");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:628:6: ( DATA LBRACE ( fieldDecl )* RBRACE -> ^( DATA ( fieldDecl )* ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:628:8: DATA LBRACE ( fieldDecl )* RBRACE
            {
            DATA479=(Token)match(input,DATA,FOLLOW_DATA_in_data8022); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DATA.add(DATA479);

            LBRACE480=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_data8024); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(LBRACE480);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:628:20: ( fieldDecl )*
            loop136:
            do {
                int alt136=2;
                int LA136_0 = input.LA(1);

                if ( (LA136_0==ID||LA136_0==LPAREN||LA136_0==STATIC) ) {
                    alt136=1;
                }


                switch (alt136) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:628:20: fieldDecl
            	    {
            	    pushFollow(FOLLOW_fieldDecl_in_data8026);
            	    fieldDecl481=fieldDecl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_fieldDecl.add(fieldDecl481.getTree());

            	    }
            	    break;

            	default :
            	    break loop136;
                }
            } while (true);

            RBRACE482=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_data8029); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(RBRACE482);



            // AST REWRITE
            // elements: DATA, fieldDecl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 628:39: -> ^( DATA ( fieldDecl )* )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:628:42: ^( DATA ( fieldDecl )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_DATA.nextNode(), root_1);

                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:628:49: ( fieldDecl )*
                while ( stream_fieldDecl.hasNext() ) {
                    adaptor.addChild(root_1, stream_fieldDecl.nextTree());

                }
                stream_fieldDecl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "data"

    public static class staticVarDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "staticVarDecl"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:630:1: staticVarDecl : STATIC varDecl -> ^( STATIC varDecl ) ;
    public final EulangParser.staticVarDecl_return staticVarDecl() throws RecognitionException {
        EulangParser.staticVarDecl_return retval = new EulangParser.staticVarDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STATIC483=null;
        EulangParser.varDecl_return varDecl484 = null;


        CommonTree STATIC483_tree=null;
        RewriteRuleTokenStream stream_STATIC=new RewriteRuleTokenStream(adaptor,"token STATIC");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:630:15: ( STATIC varDecl -> ^( STATIC varDecl ) )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:630:17: STATIC varDecl
            {
            STATIC483=(Token)match(input,STATIC,FOLLOW_STATIC_in_staticVarDecl8048); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_STATIC.add(STATIC483);

            pushFollow(FOLLOW_varDecl_in_staticVarDecl8050);
            varDecl484=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_varDecl.add(varDecl484.getTree());


            // AST REWRITE
            // elements: varDecl, STATIC
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 630:32: -> ^( STATIC varDecl )
            {
                // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:630:35: ^( STATIC varDecl )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_STATIC.nextNode(), root_1);

                adaptor.addChild(root_1, stream_varDecl.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "staticVarDecl"

    public static class fieldDecl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fieldDecl"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:632:1: fieldDecl : ( staticVarDecl SEMI -> staticVarDecl | varDecl SEMI -> varDecl | defineStmt );
    public final EulangParser.fieldDecl_return fieldDecl() throws RecognitionException {
        EulangParser.fieldDecl_return retval = new EulangParser.fieldDecl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMI486=null;
        Token SEMI488=null;
        EulangParser.staticVarDecl_return staticVarDecl485 = null;

        EulangParser.varDecl_return varDecl487 = null;

        EulangParser.defineStmt_return defineStmt489 = null;


        CommonTree SEMI486_tree=null;
        CommonTree SEMI488_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_staticVarDecl=new RewriteRuleSubtreeStream(adaptor,"rule staticVarDecl");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:632:11: ( staticVarDecl SEMI -> staticVarDecl | varDecl SEMI -> varDecl | defineStmt )
            int alt137=3;
            switch ( input.LA(1) ) {
            case STATIC:
                {
                alt137=1;
                }
                break;
            case ID:
                {
                int LA137_2 = input.LA(2);

                if ( (LA137_2==EQUALS||LA137_2==EQUALS_COLON) ) {
                    alt137=3;
                }
                else if ( ((LA137_2>=COMMA && LA137_2<=COLON)) ) {
                    alt137=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 137, 2, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                alt137=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:632:13: staticVarDecl SEMI
                    {
                    pushFollow(FOLLOW_staticVarDecl_in_fieldDecl8067);
                    staticVarDecl485=staticVarDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_staticVarDecl.add(staticVarDecl485.getTree());
                    SEMI486=(Token)match(input,SEMI,FOLLOW_SEMI_in_fieldDecl8069); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI486);



                    // AST REWRITE
                    // elements: staticVarDecl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 632:32: -> staticVarDecl
                    {
                        adaptor.addChild(root_0, stream_staticVarDecl.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:633:7: varDecl SEMI
                    {
                    pushFollow(FOLLOW_varDecl_in_fieldDecl8082);
                    varDecl487=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_varDecl.add(varDecl487.getTree());
                    SEMI488=(Token)match(input,SEMI,FOLLOW_SEMI_in_fieldDecl8084); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI488);



                    // AST REWRITE
                    // elements: varDecl
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 633:20: -> varDecl
                    {
                        adaptor.addChild(root_0, stream_varDecl.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:634:7: defineStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_defineStmt_in_fieldDecl8097);
                    defineStmt489=defineStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, defineStmt489.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "fieldDecl"

    public static class fieldIdRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fieldIdRef"
    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:637:1: fieldIdRef : ID ( COMMA ID )* -> ( ^( ALLOC ID ) )+ ;
    public final EulangParser.fieldIdRef_return fieldIdRef() throws RecognitionException {
        EulangParser.fieldIdRef_return retval = new EulangParser.fieldIdRef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID490=null;
        Token COMMA491=null;
        Token ID492=null;

        CommonTree ID490_tree=null;
        CommonTree COMMA491_tree=null;
        CommonTree ID492_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:637:12: ( ID ( COMMA ID )* -> ( ^( ALLOC ID ) )+ )
            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:637:14: ID ( COMMA ID )*
            {
            ID490=(Token)match(input,ID,FOLLOW_ID_in_fieldIdRef8110); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID490);

            // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:637:17: ( COMMA ID )*
            loop138:
            do {
                int alt138=2;
                int LA138_0 = input.LA(1);

                if ( (LA138_0==COMMA) ) {
                    alt138=1;
                }


                switch (alt138) {
            	case 1 :
            	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:637:18: COMMA ID
            	    {
            	    COMMA491=(Token)match(input,COMMA,FOLLOW_COMMA_in_fieldIdRef8113); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA491);

            	    ID492=(Token)match(input,ID,FOLLOW_ID_in_fieldIdRef8115); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID492);


            	    }
            	    break;

            	default :
            	    break loop138;
                }
            } while (true);



            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 637:29: -> ( ^( ALLOC ID ) )+
            {
                if ( !(stream_ID.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ID.hasNext() ) {
                    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:637:32: ^( ALLOC ID )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ALLOC, "ALLOC"), root_1);

                    adaptor.addChild(root_1, stream_ID.nextNode());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_ID.reset();

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
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
    // $ANTLR end "fieldIdRef"

    // $ANTLR start synpred1_Eulang
    public final void synpred1_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:143:7: ( LBRACE )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:143:8: LBRACE
        {
        match(input,LBRACE,FOLLOW_LBRACE_in_synpred1_Eulang643); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Eulang

    // $ANTLR start synpred2_Eulang
    public final void synpred2_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:173:14: ( ID EQUALS LBRACKET )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:173:15: ID EQUALS LBRACKET
        {
        match(input,ID,FOLLOW_ID_in_synpred2_Eulang1108); if (state.failed) return ;
        match(input,EQUALS,FOLLOW_EQUALS_in_synpred2_Eulang1110); if (state.failed) return ;
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred2_Eulang1112); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Eulang

    // $ANTLR start synpred3_Eulang
    public final void synpred3_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:174:7: ( ID EQUALS_COLON )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:174:8: ID EQUALS_COLON
        {
        match(input,ID,FOLLOW_ID_in_synpred3_Eulang1157); if (state.failed) return ;
        match(input,EQUALS_COLON,FOLLOW_EQUALS_COLON_in_synpred3_Eulang1159); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Eulang

    // $ANTLR start synpred4_Eulang
    public final void synpred4_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:175:7: ( ID EQUALS )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:175:8: ID EQUALS
        {
        match(input,ID,FOLLOW_ID_in_synpred4_Eulang1194); if (state.failed) return ;
        match(input,EQUALS,FOLLOW_EQUALS_in_synpred4_Eulang1196); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Eulang

    // $ANTLR start synpred5_Eulang
    public final void synpred5_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:178:17: ( LBRACE )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:178:18: LBRACE
        {
        match(input,LBRACE,FOLLOW_LBRACE_in_synpred5_Eulang1234); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Eulang

    // $ANTLR start synpred7_Eulang
    public final void synpred7_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:238:5: ( argdefsWithTypes )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:238:5: argdefsWithTypes
        {
        pushFollow(FOLLOW_argdefsWithTypes_in_synpred7_Eulang1803);
        argdefsWithTypes();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_Eulang

    // $ANTLR start synpred8_Eulang
    public final void synpred8_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:239:5: ( argdefWithType )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:239:5: argdefWithType
        {
        pushFollow(FOLLOW_argdefWithType_in_synpred8_Eulang1810);
        argdefWithType();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_Eulang

    // $ANTLR start synpred9_Eulang
    public final void synpred9_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:9: ( ( arraySuff )+ )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:10: ( arraySuff )+
        {
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:10: ( arraySuff )+
        int cnt139=0;
        loop139:
        do {
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==LBRACKET) ) {
                alt139=1;
            }


            switch (alt139) {
        	case 1 :
        	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:283:10: arraySuff
        	    {
        	    pushFollow(FOLLOW_arraySuff_in_synpred9_Eulang2323);
        	    arraySuff();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt139 >= 1 ) break loop139;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(139, input);
                    throw eee;
            }
            cnt139++;
        } while (true);


        }
    }
    // $ANTLR end synpred9_Eulang

    // $ANTLR start synpred10_Eulang
    public final void synpred10_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:314:7: ( varDecl )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:314:9: varDecl
        {
        pushFollow(FOLLOW_varDecl_in_synpred10_Eulang2716);
        varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_Eulang

    // $ANTLR start synpred11_Eulang
    public final void synpred11_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:315:9: ( assignStmt )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:315:10: assignStmt
        {
        pushFollow(FOLLOW_assignStmt_in_synpred11_Eulang2739);
        assignStmt();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_Eulang

    // $ANTLR start synpred12_Eulang
    public final void synpred12_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:317:9: ( LBRACE )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:317:11: LBRACE
        {
        match(input,LBRACE,FOLLOW_LBRACE_in_synpred12_Eulang2788); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_Eulang

    // $ANTLR start synpred13_Eulang
    public final void synpred13_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:345:14: ( lhs assignEqOp )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:345:15: lhs assignEqOp
        {
        pushFollow(FOLLOW_lhs_in_synpred13_Eulang3257);
        lhs();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignEqOp_in_synpred13_Eulang3259);
        assignEqOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_Eulang

    // $ANTLR start synpred14_Eulang
    public final void synpred14_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:7: ( lhs ( COMMA lhs )+ assignEqOp )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:8: lhs ( COMMA lhs )+ assignEqOp
        {
        pushFollow(FOLLOW_lhs_in_synpred14_Eulang3339);
        lhs();

        state._fsp--;
        if (state.failed) return ;
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:12: ( COMMA lhs )+
        int cnt140=0;
        loop140:
        do {
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==COMMA) ) {
                alt140=1;
            }


            switch (alt140) {
        	case 1 :
        	    // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:348:13: COMMA lhs
        	    {
        	    match(input,COMMA,FOLLOW_COMMA_in_synpred14_Eulang3342); if (state.failed) return ;
        	    pushFollow(FOLLOW_lhs_in_synpred14_Eulang3344);
        	    lhs();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt140 >= 1 ) break loop140;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(140, input);
                    throw eee;
            }
            cnt140++;
        } while (true);

        pushFollow(FOLLOW_assignEqOp_in_synpred14_Eulang3348);
        assignEqOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_Eulang

    // $ANTLR start synpred15_Eulang
    public final void synpred15_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:355:14: ( lhs assignEqOp )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:355:15: lhs assignEqOp
        {
        pushFollow(FOLLOW_lhs_in_synpred15_Eulang3449);
        lhs();

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_assignEqOp_in_synpred15_Eulang3451);
        assignEqOp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_Eulang

    // $ANTLR start synpred16_Eulang
    public final void synpred16_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:356:7: ( idTuple EQUALS )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:356:8: idTuple EQUALS
        {
        pushFollow(FOLLOW_idTuple_in_synpred16_Eulang3488);
        idTuple();

        state._fsp--;
        if (state.failed) return ;
        match(input,EQUALS,FOLLOW_EQUALS_in_synpred16_Eulang3490); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_Eulang

    // $ANTLR start synpred17_Eulang
    public final void synpred17_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:366:7: ( rhsExpr )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:366:8: rhsExpr
        {
        pushFollow(FOLLOW_rhsExpr_in_synpred17_Eulang3703);
        rhsExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_Eulang

    // $ANTLR start synpred18_Eulang
    public final void synpred18_Eulang_fragment() throws RecognitionException {   
        EulangParser.rhsExpr_return i = null;


        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:368:7: ( LBRACKET i= rhsExpr RBRACKET )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:368:8: LBRACKET i= rhsExpr RBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred18_Eulang3835); if (state.failed) return ;
        pushFollow(FOLLOW_rhsExpr_in_synpred18_Eulang3839);
        i=rhsExpr();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACKET,FOLLOW_RBRACKET_in_synpred18_Eulang3841); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred18_Eulang

    // $ANTLR start synpred19_Eulang
    public final void synpred19_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:528:12: ( MINUS term )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:528:14: MINUS term
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred19_Eulang5916); if (state.failed) return ;
        pushFollow(FOLLOW_term_in_synpred19_Eulang5918);
        term();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_Eulang

    // $ANTLR start synpred20_Eulang
    public final void synpred20_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:533:11: ( STAR unary )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:533:13: STAR unary
        {
        match(input,STAR,FOLLOW_STAR_in_synpred20_Eulang6009); if (state.failed) return ;
        pushFollow(FOLLOW_unary_in_synpred20_Eulang6011);
        unary();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_Eulang

    // $ANTLR start synpred21_Eulang
    public final void synpred21_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:545:9: ( lhs PLUSPLUS )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:545:11: lhs PLUSPLUS
        {
        pushFollow(FOLLOW_lhs_in_synpred21_Eulang6343);
        lhs();

        state._fsp--;
        if (state.failed) return ;
        match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_synpred21_Eulang6345); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_Eulang

    // $ANTLR start synpred22_Eulang
    public final void synpred22_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:546:9: ( lhs MINUSMINUS )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:546:11: lhs MINUSMINUS
        {
        pushFollow(FOLLOW_lhs_in_synpred22_Eulang6376);
        lhs();

        state._fsp--;
        if (state.failed) return ;
        match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_synpred22_Eulang6378); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_Eulang

    // $ANTLR start synpred23_Eulang
    public final void synpred23_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:558:9: ( tuple )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:558:11: tuple
        {
        pushFollow(FOLLOW_tuple_in_synpred23_Eulang6635);
        tuple();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_Eulang

    // $ANTLR start synpred24_Eulang
    public final void synpred24_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:567:9: ( LBRACKET )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:567:11: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred24_Eulang6898); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_Eulang

    // $ANTLR start synpred25_Eulang
    public final void synpred25_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:586:9: ( tuple )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:586:11: tuple
        {
        pushFollow(FOLLOW_tuple_in_synpred25_Eulang7332);
        tuple();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_Eulang

    // $ANTLR start synpred26_Eulang
    public final void synpred26_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:587:9: ( LPAREN varDecl )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:587:11: LPAREN varDecl
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred26_Eulang7379); if (state.failed) return ;
        pushFollow(FOLLOW_varDecl_in_synpred26_Eulang7381);
        varDecl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_Eulang

    // $ANTLR start synpred27_Eulang
    public final void synpred27_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:589:9: ( CODE )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:589:11: CODE
        {
        match(input,CODE,FOLLOW_CODE_in_synpred27_Eulang7459); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_Eulang

    // $ANTLR start synpred28_Eulang
    public final void synpred28_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:596:9: ( LBRACKET )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:596:11: LBRACKET
        {
        match(input,LBRACKET,FOLLOW_LBRACKET_in_synpred28_Eulang7583); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_Eulang

    // $ANTLR start synpred29_Eulang
    public final void synpred29_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:611:7: ( instantiation )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:611:8: instantiation
        {
        pushFollow(FOLLOW_instantiation_in_synpred29_Eulang7794);
        instantiation();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_Eulang

    // $ANTLR start synpred30_Eulang
    public final void synpred30_Eulang_fragment() throws RecognitionException {   
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:621:43: ( type )
        // /home/ejs/devel/emul/java/v9t9-java/eulang/org/ejs/eulang/parser/Eulang.g:621:43: type
        {
        pushFollow(FOLLOW_type_in_synpred30_Eulang7942);
        type();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_Eulang

    // Delegated rules

    public final boolean synpred18_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred18_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_Eulang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_Eulang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA79 dfa79 = new DFA79(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA115 dfa115 = new DFA115(this);
    protected DFA121 dfa121 = new DFA121(this);
    protected DFA127 dfa127 = new DFA127(this);
    protected DFA133 dfa133 = new DFA133(this);
    static final String DFA3_eotS =
        "\17\uffff";
    static final String DFA3_eofS =
        "\17\uffff";
    static final String DFA3_minS =
        "\1\10\1\44\1\uffff\1\10\1\uffff\1\44\1\105\1\10\2\44\1\105\1\10"+
        "\3\44";
    static final String DFA3_maxS =
        "\1\u0097\1\u0094\1\uffff\1\u0097\1\uffff\1\u0094\2\u0097\2\u0094"+
        "\2\u0097\3\u0094";
    static final String DFA3_acceptS =
        "\2\uffff\1\1\1\uffff\1\2\12\uffff";
    static final String DFA3_specialS =
        "\17\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\2\64\uffff\2\2\5\uffff\1\2\1\1\2\uffff\1\2\6\uffff\1\2\4"+
            "\uffff\1\3\2\uffff\1\2\31\uffff\1\2\5\uffff\1\2\13\uffff\2\2"+
            "\5\uffff\1\2\4\uffff\5\2\1\uffff\3\2",
            "\2\2\35\uffff\1\2\2\uffff\3\4\4\2\1\uffff\2\2\4\uffff\1\2\3"+
            "\uffff\2\2\17\uffff\1\2\3\uffff\1\2\10\uffff\1\2\1\uffff\31"+
            "\2\3\uffff\1\2",
            "",
            "\1\2\64\uffff\2\2\6\uffff\1\5\2\uffff\1\6\13\uffff\1\2\2\uffff"+
            "\1\2\31\uffff\1\2\5\uffff\1\2\13\uffff\2\2\5\uffff\1\2\4\uffff"+
            "\5\2\1\uffff\2\2\1\6",
            "",
            "\2\2\40\uffff\1\7\6\2\2\uffff\1\2\4\uffff\2\2\2\uffff\22\2"+
            "\3\uffff\1\2\10\uffff\1\2\1\uffff\31\2\3\uffff\1\2",
            "\1\10\2\uffff\1\6\116\uffff\1\6",
            "\1\2\64\uffff\2\2\6\uffff\1\11\2\uffff\1\12\13\uffff\1\2\2"+
            "\uffff\1\2\31\uffff\1\2\5\uffff\1\2\13\uffff\2\2\5\uffff\1\2"+
            "\4\uffff\5\2\1\uffff\2\2\1\12",
            "\2\2\40\uffff\1\13\2\uffff\4\2\2\uffff\1\2\4\uffff\2\2\2\uffff"+
            "\22\2\3\uffff\1\2\10\uffff\1\2\1\uffff\31\2\3\uffff\1\2",
            "\2\2\40\uffff\1\7\6\2\2\uffff\1\2\4\uffff\1\2\1\14\2\uffff"+
            "\22\2\3\uffff\1\2\10\uffff\1\2\1\uffff\31\2\3\uffff\1\2",
            "\1\15\2\uffff\1\12\116\uffff\1\12",
            "\1\2\64\uffff\2\2\6\uffff\1\16\2\uffff\1\12\13\uffff\1\2\2"+
            "\uffff\1\2\31\uffff\1\2\5\uffff\1\2\13\uffff\2\2\5\uffff\1\2"+
            "\4\uffff\5\2\1\uffff\2\2\1\12",
            "\2\2\35\uffff\1\2\3\uffff\2\4\1\uffff\1\2\1\uffff\1\2\2\uffff"+
            "\1\2\4\uffff\1\2\3\uffff\2\2\17\uffff\1\2\3\uffff\1\2\10\uffff"+
            "\1\2\1\uffff\31\2\3\uffff\1\2",
            "\2\2\40\uffff\1\13\2\uffff\4\2\2\uffff\1\2\4\uffff\1\2\1\14"+
            "\2\uffff\22\2\3\uffff\1\2\10\uffff\1\2\1\uffff\31\2\3\uffff"+
            "\1\2",
            "\2\2\40\uffff\1\13\2\uffff\4\2\2\uffff\1\2\4\uffff\1\2\1\14"+
            "\2\uffff\22\2\3\uffff\1\2\10\uffff\1\2\1\uffff\31\2\3\uffff"+
            "\1\2"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "136:1: toplevelstat : ( toplevelstatNoAlloc -> toplevelstatNoAlloc | toplevelAlloc SEMI -> toplevelAlloc );";
        }
    }
    static final String DFA7_eotS =
        "\15\uffff";
    static final String DFA7_eofS =
        "\15\uffff";
    static final String DFA7_minS =
        "\1\10\1\44\1\105\4\uffff\1\105\1\uffff\2\44\1\105\1\44";
    static final String DFA7_maxS =
        "\1\u0097\1\u0094\1\u0097\4\uffff\1\105\1\uffff\2\u0094\1\105\1\u0094";
    static final String DFA7_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\1\1\uffff\1\2\4\uffff";
    static final String DFA7_specialS =
        "\1\0\14\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\4\64\uffff\2\4\5\uffff\1\3\1\1\2\uffff\1\2\6\uffff\1\5\4"+
            "\uffff\1\4\2\uffff\1\4\31\uffff\1\4\5\uffff\1\4\13\uffff\2\4"+
            "\5\uffff\1\4\4\uffff\5\4\1\uffff\2\4\1\2",
            "\2\4\35\uffff\1\4\5\uffff\1\6\1\4\1\10\1\4\1\uffff\1\6\1\4"+
            "\4\uffff\1\4\3\uffff\2\4\17\uffff\1\7\3\uffff\1\4\10\uffff\1"+
            "\4\1\uffff\31\4\3\uffff\1\4",
            "\1\11\2\uffff\1\2\116\uffff\1\2",
            "",
            "",
            "",
            "",
            "\1\12",
            "",
            "\2\4\35\uffff\1\4\6\uffff\1\4\1\10\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\3\uffff\2\4\17\uffff\1\13\3\uffff\1\4\10\uffff\1\4\1\uffff"+
            "\31\4\3\uffff\1\4",
            "\2\4\35\uffff\1\4\6\uffff\1\4\1\10\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\3\uffff\2\4\17\uffff\1\7\3\uffff\1\4\10\uffff\1\4\1\uffff"+
            "\31\4\3\uffff\1\4",
            "\1\14",
            "\2\4\35\uffff\1\4\6\uffff\1\4\1\10\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\3\uffff\2\4\17\uffff\1\13\3\uffff\1\4\10\uffff\1\4\1\uffff"+
            "\31\4\3\uffff\1\4"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "139:1: toplevelstatNoAlloc : ( defineStmt | scopeExtension ( SEMI )? -> scopeExtension | FORWARD ID ( COMMA ID )* SEMI -> ( ^( FORWARD ID ) )+ | rhsExpr SEMI -> ^( EXPR rhsExpr ) | ( LBRACE )=> xscope ( SEMI )? );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_0 = input.LA(1);

                         
                        int index7_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA7_0==ID) ) {s = 1;}

                        else if ( (LA7_0==COLON||LA7_0==COLONS) ) {s = 2;}

                        else if ( (LA7_0==FORWARD) ) {s = 3;}

                        else if ( (LA7_0==CODE||(LA7_0>=SIZEOF && LA7_0<=TYPEOF)||LA7_0==LPAREN||LA7_0==NIL||LA7_0==IF||LA7_0==NOT||(LA7_0>=TILDE && LA7_0<=AMP)||LA7_0==MINUS||(LA7_0>=PLUSPLUS && LA7_0<=STRING_LITERAL)||(LA7_0>=FALSE && LA7_0<=TRUE)) ) {s = 4;}

                        else if ( (LA7_0==LBRACE) && (synpred1_Eulang())) {s = 5;}

                         
                        input.seek(index7_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\u00a8\uffff";
    static final String DFA21_eofS =
        "\u00a8\uffff";
    static final String DFA21_minS =
        "\1\105\1\111\1\10\1\uffff\1\10\31\uffff\1\44\20\uffff\1\10\44\uffff"+
        "\1\10\31\uffff\1\44\71\uffff";
    static final String DFA21_maxS =
        "\1\105\1\116\1\u0098\1\uffff\1\u0097\31\uffff\1\u0094\20\uffff\1"+
        "\u0098\44\uffff\1\u0097\31\uffff\1\u0094\71\uffff";
    static final String DFA21_acceptS =
        "\3\uffff\1\2\1\uffff\31\3\1\uffff\20\3\1\uffff\44\3\1\uffff\1\3"+
        "\27\1\1\3\1\uffff\71\3";
    static final String DFA21_specialS =
        "\1\uffff\1\4\1\2\1\uffff\1\1\31\uffff\1\0\20\uffff\1\6\44\uffff"+
        "\1\5\31\uffff\1\3\71\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1",
            "\1\2\4\uffff\1\3",
            "\1\21\1\uffff\1\32\62\uffff\1\25\1\26\6\uffff\1\6\2\uffff\1"+
            "\7\3\uffff\1\4\2\uffff\1\5\4\uffff\1\12\2\uffff\1\20\31\uffff"+
            "\1\30\5\uffff\1\27\13\uffff\1\11\1\24\5\uffff\1\10\4\uffff\1"+
            "\22\1\23\1\13\1\14\1\15\1\uffff\1\16\1\17\1\7\1\31",
            "",
            "\1\47\1\uffff\1\33\62\uffff\1\53\1\54\6\uffff\1\36\2\uffff"+
            "\1\37\4\uffff\1\57\6\uffff\1\40\2\uffff\1\46\31\uffff\1\56\5"+
            "\uffff\1\55\13\uffff\1\35\1\52\5\uffff\1\34\4\uffff\1\50\1\51"+
            "\1\41\1\42\1\43\1\uffff\1\44\1\45\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\73\1\75\40\uffff\1\124\3\uffff\1\76\1\uffff\1\63\1\57\1"+
            "\uffff\1\65\4\uffff\1\62\3\uffff\1\123\1\64\17\uffff\1\60\3"+
            "\uffff\1\121\10\uffff\1\122\1\uffff\1\110\1\111\1\112\1\113"+
            "\1\114\1\115\1\61\1\116\1\117\1\120\1\107\1\106\1\105\1\100"+
            "\1\101\1\102\1\103\1\104\1\77\1\70\1\71\1\72\1\74\1\67\1\125"+
            "\3\uffff\1\66",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\143\1\uffff\1\154\62\uffff\1\147\1\150\4\uffff\1\155\1\uffff"+
            "\1\127\2\uffff\1\130\3\uffff\1\131\2\uffff\1\126\4\uffff\1\134"+
            "\2\uffff\1\142\31\uffff\1\152\5\uffff\1\151\13\uffff\1\133\1"+
            "\146\5\uffff\1\132\4\uffff\1\144\1\145\1\135\1\136\1\137\1\uffff"+
            "\1\140\1\141\1\130\1\153",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\172\1\uffff\1\157\62\uffff\1\176\1\177\6\uffff\1\156\2\uffff"+
            "\1\162\4\uffff\1\u0082\6\uffff\1\163\2\uffff\1\171\31\uffff"+
            "\1\u0081\5\uffff\1\u0080\13\uffff\1\161\1\175\5\uffff\1\160"+
            "\4\uffff\1\173\1\174\1\164\1\165\1\166\1\uffff\1\167\1\170\1"+
            "\162",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008e\1\u0090\40\uffff\1\124\3\uffff\1\u0091\1\uffff\1\u0086"+
            "\1\57\1\uffff\1\u0088\4\uffff\1\u0085\3\uffff\1\u00a6\1\u0087"+
            "\17\uffff\1\u0083\3\uffff\1\u00a4\10\uffff\1\u00a5\1\uffff\1"+
            "\u009b\1\u009c\1\u009d\1\u009e\1\u009f\1\u00a0\1\u0084\1\u00a1"+
            "\1\u00a2\1\u00a3\1\u009a\1\u0099\1\u0098\1\u0093\1\u0094\1\u0095"+
            "\1\u0096\1\u0097\1\u0092\1\u008b\1\u008c\1\u008d\1\u008f\1\u00a7"+
            "\1\u008a\3\uffff\1\u0089",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
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
            return "173:1: defineStmt : ( ( ID EQUALS LBRACKET )=> ID EQUALS LBRACKET idlistOrEmpty RBRACKET toplevelvalue SEMI -> ^( DEFINE ID idlistOrEmpty toplevelvalue ) | ( ID EQUALS_COLON )=> ID EQUALS_COLON type SEMI -> ^( DEFINE ID type ) | ( ID EQUALS )=> ID EQUALS toplevelvalue SEMI -> ^( DEFINE ID toplevelvalue ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_30 = input.LA(1);

                         
                        int index21_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_30==PERIOD) && (synpred4_Eulang())) {s = 48;}

                        else if ( (LA21_30==LESS) && (synpred4_Eulang())) {s = 49;}

                        else if ( (LA21_30==LPAREN) && (synpred4_Eulang())) {s = 50;}

                        else if ( (LA21_30==LBRACKET) && (synpred4_Eulang())) {s = 51;}

                        else if ( (LA21_30==CARET) && (synpred4_Eulang())) {s = 52;}

                        else if ( (LA21_30==LBRACE) && (synpred4_Eulang())) {s = 53;}

                        else if ( (LA21_30==AS) && (synpred4_Eulang())) {s = 54;}

                        else if ( (LA21_30==PLUSPLUS) && (synpred4_Eulang())) {s = 55;}

                        else if ( (LA21_30==STAR) && (synpred4_Eulang())) {s = 56;}

                        else if ( (LA21_30==SLASH) && (synpred4_Eulang())) {s = 57;}

                        else if ( (LA21_30==REM) && (synpred4_Eulang())) {s = 58;}

                        else if ( (LA21_30==UDIV) && (synpred4_Eulang())) {s = 59;}

                        else if ( (LA21_30==UREM) && (synpred4_Eulang())) {s = 60;}

                        else if ( (LA21_30==MOD) && (synpred4_Eulang())) {s = 61;}

                        else if ( (LA21_30==PLUS) && (synpred4_Eulang())) {s = 62;}

                        else if ( (LA21_30==MINUS) && (synpred4_Eulang())) {s = 63;}

                        else if ( (LA21_30==LSHIFT) && (synpred4_Eulang())) {s = 64;}

                        else if ( (LA21_30==RSHIFT) && (synpred4_Eulang())) {s = 65;}

                        else if ( (LA21_30==URSHIFT) && (synpred4_Eulang())) {s = 66;}

                        else if ( (LA21_30==CRSHIFT) && (synpred4_Eulang())) {s = 67;}

                        else if ( (LA21_30==CLSHIFT) && (synpred4_Eulang())) {s = 68;}

                        else if ( (LA21_30==AMP) && (synpred4_Eulang())) {s = 69;}

                        else if ( (LA21_30==TILDE) && (synpred4_Eulang())) {s = 70;}

                        else if ( (LA21_30==BAR) && (synpred4_Eulang())) {s = 71;}

                        else if ( (LA21_30==COMPEQ) && (synpred4_Eulang())) {s = 72;}

                        else if ( (LA21_30==COMPNE) && (synpred4_Eulang())) {s = 73;}

                        else if ( (LA21_30==COMPLE) && (synpred4_Eulang())) {s = 74;}

                        else if ( (LA21_30==COMPGE) && (synpred4_Eulang())) {s = 75;}

                        else if ( (LA21_30==COMPULE) && (synpred4_Eulang())) {s = 76;}

                        else if ( (LA21_30==COMPUGE) && (synpred4_Eulang())) {s = 77;}

                        else if ( (LA21_30==ULESS) && (synpred4_Eulang())) {s = 78;}

                        else if ( (LA21_30==GREATER) && (synpred4_Eulang())) {s = 79;}

                        else if ( (LA21_30==UGREATER) && (synpred4_Eulang())) {s = 80;}

                        else if ( (LA21_30==AND) && (synpred4_Eulang())) {s = 81;}

                        else if ( (LA21_30==OR) && (synpred4_Eulang())) {s = 82;}

                        else if ( (LA21_30==QUESTION) && (synpred4_Eulang())) {s = 83;}

                        else if ( (LA21_30==COMMA) ) {s = 84;}

                        else if ( (LA21_30==RBRACKET) ) {s = 47;}

                        else if ( (LA21_30==MINUSMINUS) && (synpred4_Eulang())) {s = 85;}

                         
                        input.seek(index21_30);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_4 = input.LA(1);

                         
                        int index21_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_4==MACRO) && (synpred4_Eulang())) {s = 27;}

                        else if ( (LA21_4==MINUS) && (synpred4_Eulang())) {s = 28;}

                        else if ( (LA21_4==TILDE) && (synpred4_Eulang())) {s = 29;}

                        else if ( (LA21_4==ID) ) {s = 30;}

                        else if ( (LA21_4==COLON||LA21_4==COLONS) && (synpred4_Eulang())) {s = 31;}

                        else if ( (LA21_4==LPAREN) && (synpred4_Eulang())) {s = 32;}

                        else if ( (LA21_4==NUMBER) && (synpred4_Eulang())) {s = 33;}

                        else if ( (LA21_4==CHAR_LITERAL) && (synpred4_Eulang())) {s = 34;}

                        else if ( (LA21_4==STRING_LITERAL) && (synpred4_Eulang())) {s = 35;}

                        else if ( (LA21_4==FALSE) && (synpred4_Eulang())) {s = 36;}

                        else if ( (LA21_4==TRUE) && (synpred4_Eulang())) {s = 37;}

                        else if ( (LA21_4==NIL) && (synpred4_Eulang())) {s = 38;}

                        else if ( (LA21_4==CODE) && (synpred4_Eulang())) {s = 39;}

                        else if ( (LA21_4==PLUSPLUS) && (synpred4_Eulang())) {s = 40;}

                        else if ( (LA21_4==MINUSMINUS) && (synpred4_Eulang())) {s = 41;}

                        else if ( (LA21_4==AMP) && (synpred4_Eulang())) {s = 42;}

                        else if ( (LA21_4==SIZEOF) && (synpred4_Eulang())) {s = 43;}

                        else if ( (LA21_4==TYPEOF) && (synpred4_Eulang())) {s = 44;}

                        else if ( (LA21_4==NOT) && (synpred4_Eulang())) {s = 45;}

                        else if ( (LA21_4==IF) && (synpred4_Eulang())) {s = 46;}

                        else if ( (LA21_4==RBRACKET) ) {s = 47;}

                         
                        input.seek(index21_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_2 = input.LA(1);

                         
                        int index21_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_2==LBRACKET) ) {s = 4;}

                        else if ( (LA21_2==LBRACE) && (synpred4_Eulang())) {s = 5;}

                        else if ( (LA21_2==ID) && (synpred4_Eulang())) {s = 6;}

                        else if ( (LA21_2==COLON||LA21_2==COLONS) && (synpred4_Eulang())) {s = 7;}

                        else if ( (LA21_2==MINUS) && (synpred4_Eulang())) {s = 8;}

                        else if ( (LA21_2==TILDE) && (synpred4_Eulang())) {s = 9;}

                        else if ( (LA21_2==LPAREN) && (synpred4_Eulang())) {s = 10;}

                        else if ( (LA21_2==NUMBER) && (synpred4_Eulang())) {s = 11;}

                        else if ( (LA21_2==CHAR_LITERAL) && (synpred4_Eulang())) {s = 12;}

                        else if ( (LA21_2==STRING_LITERAL) && (synpred4_Eulang())) {s = 13;}

                        else if ( (LA21_2==FALSE) && (synpred4_Eulang())) {s = 14;}

                        else if ( (LA21_2==TRUE) && (synpred4_Eulang())) {s = 15;}

                        else if ( (LA21_2==NIL) && (synpred4_Eulang())) {s = 16;}

                        else if ( (LA21_2==CODE) && (synpred4_Eulang())) {s = 17;}

                        else if ( (LA21_2==PLUSPLUS) && (synpred4_Eulang())) {s = 18;}

                        else if ( (LA21_2==MINUSMINUS) && (synpred4_Eulang())) {s = 19;}

                        else if ( (LA21_2==AMP) && (synpred4_Eulang())) {s = 20;}

                        else if ( (LA21_2==SIZEOF) && (synpred4_Eulang())) {s = 21;}

                        else if ( (LA21_2==TYPEOF) && (synpred4_Eulang())) {s = 22;}

                        else if ( (LA21_2==NOT) && (synpred4_Eulang())) {s = 23;}

                        else if ( (LA21_2==IF) && (synpred4_Eulang())) {s = 24;}

                        else if ( (LA21_2==DATA) && (synpred4_Eulang())) {s = 25;}

                        else if ( (LA21_2==MACRO) && (synpred4_Eulang())) {s = 26;}

                         
                        input.seek(index21_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_110 = input.LA(1);

                         
                        int index21_110 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_110==PERIOD) && (synpred4_Eulang())) {s = 131;}

                        else if ( (LA21_110==LESS) && (synpred4_Eulang())) {s = 132;}

                        else if ( (LA21_110==LPAREN) && (synpred4_Eulang())) {s = 133;}

                        else if ( (LA21_110==LBRACKET) && (synpred4_Eulang())) {s = 134;}

                        else if ( (LA21_110==CARET) && (synpred4_Eulang())) {s = 135;}

                        else if ( (LA21_110==LBRACE) && (synpred4_Eulang())) {s = 136;}

                        else if ( (LA21_110==AS) && (synpred4_Eulang())) {s = 137;}

                        else if ( (LA21_110==MINUSMINUS) && (synpred4_Eulang())) {s = 138;}

                        else if ( (LA21_110==RBRACKET) ) {s = 47;}

                        else if ( (LA21_110==COMMA) ) {s = 84;}

                        else if ( (LA21_110==STAR) && (synpred4_Eulang())) {s = 139;}

                        else if ( (LA21_110==SLASH) && (synpred4_Eulang())) {s = 140;}

                        else if ( (LA21_110==REM) && (synpred4_Eulang())) {s = 141;}

                        else if ( (LA21_110==UDIV) && (synpred4_Eulang())) {s = 142;}

                        else if ( (LA21_110==UREM) && (synpred4_Eulang())) {s = 143;}

                        else if ( (LA21_110==MOD) && (synpred4_Eulang())) {s = 144;}

                        else if ( (LA21_110==PLUS) && (synpred4_Eulang())) {s = 145;}

                        else if ( (LA21_110==MINUS) && (synpred4_Eulang())) {s = 146;}

                        else if ( (LA21_110==LSHIFT) && (synpred4_Eulang())) {s = 147;}

                        else if ( (LA21_110==RSHIFT) && (synpred4_Eulang())) {s = 148;}

                        else if ( (LA21_110==URSHIFT) && (synpred4_Eulang())) {s = 149;}

                        else if ( (LA21_110==CRSHIFT) && (synpred4_Eulang())) {s = 150;}

                        else if ( (LA21_110==CLSHIFT) && (synpred4_Eulang())) {s = 151;}

                        else if ( (LA21_110==AMP) && (synpred4_Eulang())) {s = 152;}

                        else if ( (LA21_110==TILDE) && (synpred4_Eulang())) {s = 153;}

                        else if ( (LA21_110==BAR) && (synpred4_Eulang())) {s = 154;}

                        else if ( (LA21_110==COMPEQ) && (synpred4_Eulang())) {s = 155;}

                        else if ( (LA21_110==COMPNE) && (synpred4_Eulang())) {s = 156;}

                        else if ( (LA21_110==COMPLE) && (synpred4_Eulang())) {s = 157;}

                        else if ( (LA21_110==COMPGE) && (synpred4_Eulang())) {s = 158;}

                        else if ( (LA21_110==COMPULE) && (synpred4_Eulang())) {s = 159;}

                        else if ( (LA21_110==COMPUGE) && (synpred4_Eulang())) {s = 160;}

                        else if ( (LA21_110==ULESS) && (synpred4_Eulang())) {s = 161;}

                        else if ( (LA21_110==GREATER) && (synpred4_Eulang())) {s = 162;}

                        else if ( (LA21_110==UGREATER) && (synpred4_Eulang())) {s = 163;}

                        else if ( (LA21_110==AND) && (synpred4_Eulang())) {s = 164;}

                        else if ( (LA21_110==OR) && (synpred4_Eulang())) {s = 165;}

                        else if ( (LA21_110==QUESTION) && (synpred4_Eulang())) {s = 166;}

                        else if ( (LA21_110==PLUSPLUS) && (synpred4_Eulang())) {s = 167;}

                         
                        input.seek(index21_110);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_1 = input.LA(1);

                         
                        int index21_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_1==EQUALS) ) {s = 2;}

                        else if ( (LA21_1==EQUALS_COLON) && (synpred3_Eulang())) {s = 3;}

                         
                        input.seek(index21_1);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_84 = input.LA(1);

                         
                        int index21_84 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_84==ID) ) {s = 110;}

                        else if ( (LA21_84==MACRO) && (synpred4_Eulang())) {s = 111;}

                        else if ( (LA21_84==MINUS) && (synpred4_Eulang())) {s = 112;}

                        else if ( (LA21_84==TILDE) && (synpred4_Eulang())) {s = 113;}

                        else if ( (LA21_84==COLON||LA21_84==COLONS) && (synpred4_Eulang())) {s = 114;}

                        else if ( (LA21_84==LPAREN) && (synpred4_Eulang())) {s = 115;}

                        else if ( (LA21_84==NUMBER) && (synpred4_Eulang())) {s = 116;}

                        else if ( (LA21_84==CHAR_LITERAL) && (synpred4_Eulang())) {s = 117;}

                        else if ( (LA21_84==STRING_LITERAL) && (synpred4_Eulang())) {s = 118;}

                        else if ( (LA21_84==FALSE) && (synpred4_Eulang())) {s = 119;}

                        else if ( (LA21_84==TRUE) && (synpred4_Eulang())) {s = 120;}

                        else if ( (LA21_84==NIL) && (synpred4_Eulang())) {s = 121;}

                        else if ( (LA21_84==CODE) && (synpred4_Eulang())) {s = 122;}

                        else if ( (LA21_84==PLUSPLUS) && (synpred4_Eulang())) {s = 123;}

                        else if ( (LA21_84==MINUSMINUS) && (synpred4_Eulang())) {s = 124;}

                        else if ( (LA21_84==AMP) && (synpred4_Eulang())) {s = 125;}

                        else if ( (LA21_84==SIZEOF) && (synpred4_Eulang())) {s = 126;}

                        else if ( (LA21_84==TYPEOF) && (synpred4_Eulang())) {s = 127;}

                        else if ( (LA21_84==NOT) && (synpred4_Eulang())) {s = 128;}

                        else if ( (LA21_84==IF) && (synpred4_Eulang())) {s = 129;}

                        else if ( (LA21_84==RBRACKET) && (synpred4_Eulang())) {s = 130;}

                         
                        input.seek(index21_84);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_47 = input.LA(1);

                         
                        int index21_47 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_47==LBRACE) && (synpred2_Eulang())) {s = 86;}

                        else if ( (LA21_47==ID) && (synpred2_Eulang())) {s = 87;}

                        else if ( (LA21_47==COLON||LA21_47==COLONS) && (synpred2_Eulang())) {s = 88;}

                        else if ( (LA21_47==LBRACKET) && (synpred2_Eulang())) {s = 89;}

                        else if ( (LA21_47==MINUS) && (synpred2_Eulang())) {s = 90;}

                        else if ( (LA21_47==TILDE) && (synpred2_Eulang())) {s = 91;}

                        else if ( (LA21_47==LPAREN) && (synpred2_Eulang())) {s = 92;}

                        else if ( (LA21_47==NUMBER) && (synpred2_Eulang())) {s = 93;}

                        else if ( (LA21_47==CHAR_LITERAL) && (synpred2_Eulang())) {s = 94;}

                        else if ( (LA21_47==STRING_LITERAL) && (synpred2_Eulang())) {s = 95;}

                        else if ( (LA21_47==FALSE) && (synpred2_Eulang())) {s = 96;}

                        else if ( (LA21_47==TRUE) && (synpred2_Eulang())) {s = 97;}

                        else if ( (LA21_47==NIL) && (synpred2_Eulang())) {s = 98;}

                        else if ( (LA21_47==CODE) && (synpred2_Eulang())) {s = 99;}

                        else if ( (LA21_47==PLUSPLUS) && (synpred2_Eulang())) {s = 100;}

                        else if ( (LA21_47==MINUSMINUS) && (synpred2_Eulang())) {s = 101;}

                        else if ( (LA21_47==AMP) && (synpred2_Eulang())) {s = 102;}

                        else if ( (LA21_47==SIZEOF) && (synpred2_Eulang())) {s = 103;}

                        else if ( (LA21_47==TYPEOF) && (synpred2_Eulang())) {s = 104;}

                        else if ( (LA21_47==NOT) && (synpred2_Eulang())) {s = 105;}

                        else if ( (LA21_47==IF) && (synpred2_Eulang())) {s = 106;}

                        else if ( (LA21_47==DATA) && (synpred2_Eulang())) {s = 107;}

                        else if ( (LA21_47==MACRO) && (synpred2_Eulang())) {s = 108;}

                        else if ( (LA21_47==SEMI) && (synpred4_Eulang())) {s = 109;}

                         
                        input.seek(index21_47);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\20\uffff";
    static final String DFA22_eofS =
        "\20\uffff";
    static final String DFA22_minS =
        "\1\10\1\uffff\1\44\1\105\4\uffff\1\105\1\10\2\44\2\uffff\1\105\1"+
        "\44";
    static final String DFA22_maxS =
        "\1\u0098\1\uffff\1\u0094\1\u0097\4\uffff\1\105\1\u0098\2\u0094\2"+
        "\uffff\1\105\1\u0094";
    static final String DFA22_acceptS =
        "\1\uffff\1\1\2\uffff\1\4\1\5\1\6\1\7\4\uffff\1\3\1\2\2\uffff";
    static final String DFA22_specialS =
        "\1\0\17\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\5\1\uffff\1\7\62\uffff\2\5\6\uffff\1\2\2\uffff\1\3\3\uffff"+
            "\1\4\2\uffff\1\1\4\uffff\1\5\2\uffff\1\5\31\uffff\1\5\5\uffff"+
            "\1\5\13\uffff\2\5\5\uffff\1\5\4\uffff\5\5\1\uffff\2\5\1\3\1"+
            "\6",
            "",
            "\2\5\35\uffff\1\5\2\uffff\1\5\3\uffff\1\11\1\uffff\2\5\1\uffff"+
            "\1\5\4\uffff\1\5\3\uffff\2\5\17\uffff\1\10\3\uffff\1\5\10\uffff"+
            "\1\5\1\uffff\31\5\3\uffff\1\5",
            "\1\12\2\uffff\1\3\116\uffff\1\3",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\5\64\uffff\2\5\6\uffff\1\5\2\uffff\1\5\6\uffff\1\14\4\uffff"+
            "\1\5\2\uffff\1\5\53\uffff\2\5\5\uffff\1\5\4\uffff\5\5\1\uffff"+
            "\3\5\1\15",
            "\2\5\35\uffff\1\5\2\uffff\1\5\3\uffff\1\11\1\uffff\2\5\1\uffff"+
            "\1\5\4\uffff\1\5\3\uffff\2\5\17\uffff\1\16\3\uffff\1\5\10\uffff"+
            "\1\5\1\uffff\31\5\3\uffff\1\5",
            "\2\5\35\uffff\1\5\2\uffff\1\5\3\uffff\1\11\1\uffff\2\5\1\uffff"+
            "\1\5\4\uffff\1\5\3\uffff\2\5\17\uffff\1\10\3\uffff\1\5\10\uffff"+
            "\1\5\1\uffff\31\5\3\uffff\1\5",
            "",
            "",
            "\1\17",
            "\2\5\35\uffff\1\5\2\uffff\1\5\3\uffff\1\11\1\uffff\2\5\1\uffff"+
            "\1\5\4\uffff\1\5\3\uffff\2\5\17\uffff\1\16\3\uffff\1\5\10\uffff"+
            "\1\5\1\uffff\31\5\3\uffff\1\5"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "178:1: toplevelvalue : ( ( LBRACE )=> xscope | namespaceRef PLUS data -> ^( ADDSCOPE namespaceRef data ) | namespaceRef PLUS xscope -> ^( ADDSCOPE namespaceRef xscope ) | selector | rhsExpr | data | macro );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0==LBRACE) && (synpred5_Eulang())) {s = 1;}

                        else if ( (LA22_0==ID) ) {s = 2;}

                        else if ( (LA22_0==COLON||LA22_0==COLONS) ) {s = 3;}

                        else if ( (LA22_0==LBRACKET) ) {s = 4;}

                        else if ( (LA22_0==CODE||(LA22_0>=SIZEOF && LA22_0<=TYPEOF)||LA22_0==LPAREN||LA22_0==NIL||LA22_0==IF||LA22_0==NOT||(LA22_0>=TILDE && LA22_0<=AMP)||LA22_0==MINUS||(LA22_0>=PLUSPLUS && LA22_0<=STRING_LITERAL)||(LA22_0>=FALSE && LA22_0<=TRUE)) ) {s = 5;}

                        else if ( (LA22_0==DATA) ) {s = 6;}

                        else if ( (LA22_0==MACRO) ) {s = 7;}

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA55_eotS =
        "\65\uffff";
    static final String DFA55_eofS =
        "\1\1\64\uffff";
    static final String DFA55_minS =
        "\1\44\60\uffff\1\0\3\uffff";
    static final String DFA55_maxS =
        "\1\u0090\60\uffff\1\0\3\uffff";
    static final String DFA55_acceptS =
        "\1\uffff\1\4\60\uffff\1\3\1\1\1\2";
    static final String DFA55_specialS =
        "\61\uffff\1\0\3\uffff}>";
    static final String[] DFA55_transitionS = {
            "\2\1\35\uffff\1\1\2\uffff\1\1\1\uffff\4\1\1\61\1\1\2\uffff\1"+
            "\1\1\uffff\1\1\2\uffff\2\1\1\uffff\1\1\1\62\17\1\1\uffff\2\1"+
            "\1\uffff\1\1\4\uffff\5\1\1\uffff\31\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA55_eot = DFA.unpackEncodedString(DFA55_eotS);
    static final short[] DFA55_eof = DFA.unpackEncodedString(DFA55_eofS);
    static final char[] DFA55_min = DFA.unpackEncodedStringToUnsignedChars(DFA55_minS);
    static final char[] DFA55_max = DFA.unpackEncodedStringToUnsignedChars(DFA55_maxS);
    static final short[] DFA55_accept = DFA.unpackEncodedString(DFA55_acceptS);
    static final short[] DFA55_special = DFA.unpackEncodedString(DFA55_specialS);
    static final short[][] DFA55_transition;

    static {
        int numStates = DFA55_transitionS.length;
        DFA55_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA55_transition[i] = DFA.unpackEncodedString(DFA55_transitionS[i]);
        }
    }

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = DFA55_eot;
            this.eof = DFA55_eof;
            this.min = DFA55_min;
            this.max = DFA55_max;
            this.accept = DFA55_accept;
            this.special = DFA55_special;
            this.transition = DFA55_transition;
        }
        public String getDescription() {
            return "()* loopback of 281:6: ( ( ( ( arraySuff )+ )=> ( arraySuff )+ -> ^( TYPE ^( ARRAY $type ( arraySuff )+ ) ) ) | ( LBRACKET rhsExpr ( COMMA rhsExpr )+ RBRACKET -> ^( TYPE ^( ARRAY $type ( rhsExpr )+ ) ) ) | ( CARET -> ^( TYPE ^( POINTER $type) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA55_49 = input.LA(1);

                         
                        int index55_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred9_Eulang()) ) {s = 51;}

                        else if ( (true) ) {s = 52;}

                         
                        input.seek(index55_49);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 55, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA63_eotS =
        "\34\uffff";
    static final String DFA63_eofS =
        "\34\uffff";
    static final String DFA63_minS =
        "\1\10\6\0\25\uffff";
    static final String DFA63_maxS =
        "\1\u0097\6\0\25\uffff";
    static final String DFA63_acceptS =
        "\7\uffff\1\3\14\uffff\1\4\1\5\1\6\3\uffff\1\1\1\2";
    static final String DFA63_specialS =
        "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\25\uffff}>";
    static final String[] DFA63_transitionS = {
            "\1\7\47\uffff\1\25\14\uffff\2\7\6\uffff\1\1\2\uffff\1\3\6\uffff"+
            "\1\24\1\uffff\1\26\2\uffff\1\2\2\uffff\1\7\22\uffff\3\26\4\uffff"+
            "\1\7\5\uffff\1\7\13\uffff\2\7\5\uffff\1\7\4\uffff\2\7\1\4\1"+
            "\5\1\6\1\uffff\2\7\1\3",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA63_eot = DFA.unpackEncodedString(DFA63_eotS);
    static final short[] DFA63_eof = DFA.unpackEncodedString(DFA63_eofS);
    static final char[] DFA63_min = DFA.unpackEncodedStringToUnsignedChars(DFA63_minS);
    static final char[] DFA63_max = DFA.unpackEncodedStringToUnsignedChars(DFA63_maxS);
    static final short[] DFA63_accept = DFA.unpackEncodedString(DFA63_acceptS);
    static final short[] DFA63_special = DFA.unpackEncodedString(DFA63_specialS);
    static final short[][] DFA63_transition;

    static {
        int numStates = DFA63_transitionS.length;
        DFA63_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA63_transition[i] = DFA.unpackEncodedString(DFA63_transitionS[i]);
        }
    }

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = DFA63_eot;
            this.eof = DFA63_eof;
            this.min = DFA63_min;
            this.max = DFA63_max;
            this.accept = DFA63_accept;
            this.special = DFA63_special;
            this.transition = DFA63_transition;
        }
        public String getDescription() {
            return "313:1: codeStmtExpr : ( ( varDecl )=> varDecl -> varDecl | ( assignStmt )=> assignStmt -> assignStmt | rhsExpr -> ^( STMTEXPR rhsExpr ) | ( LBRACE )=> blockStmt -> blockStmt | gotoStmt -> gotoStmt | controlStmt -> controlStmt );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA63_0 = input.LA(1);

                         
                        int index63_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA63_0==ID) ) {s = 1;}

                        else if ( (LA63_0==LPAREN) ) {s = 2;}

                        else if ( (LA63_0==COLON||LA63_0==COLONS) ) {s = 3;}

                        else if ( (LA63_0==NUMBER) ) {s = 4;}

                        else if ( (LA63_0==CHAR_LITERAL) ) {s = 5;}

                        else if ( (LA63_0==STRING_LITERAL) ) {s = 6;}

                        else if ( (LA63_0==CODE||(LA63_0>=SIZEOF && LA63_0<=TYPEOF)||LA63_0==NIL||LA63_0==IF||LA63_0==NOT||(LA63_0>=TILDE && LA63_0<=AMP)||LA63_0==MINUS||(LA63_0>=PLUSPLUS && LA63_0<=MINUSMINUS)||(LA63_0>=FALSE && LA63_0<=TRUE)) ) {s = 7;}

                        else if ( (LA63_0==LBRACE) && (synpred12_Eulang())) {s = 20;}

                        else if ( (LA63_0==GOTO) ) {s = 21;}

                        else if ( (LA63_0==FOR||(LA63_0>=DO && LA63_0<=REPEAT)) ) {s = 22;}

                         
                        input.seek(index63_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA63_1 = input.LA(1);

                         
                        int index63_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Eulang()) ) {s = 26;}

                        else if ( (synpred11_Eulang()) ) {s = 27;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index63_1);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA63_2 = input.LA(1);

                         
                        int index63_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Eulang()) ) {s = 26;}

                        else if ( (synpred11_Eulang()) ) {s = 27;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index63_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA63_3 = input.LA(1);

                         
                        int index63_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Eulang()) ) {s = 27;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index63_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA63_4 = input.LA(1);

                         
                        int index63_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Eulang()) ) {s = 27;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index63_4);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA63_5 = input.LA(1);

                         
                        int index63_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Eulang()) ) {s = 27;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index63_5);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA63_6 = input.LA(1);

                         
                        int index63_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Eulang()) ) {s = 27;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index63_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 63, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA79_eotS =
        "\12\uffff";
    static final String DFA79_eofS =
        "\12\uffff";
    static final String DFA79_minS =
        "\1\105\6\0\3\uffff";
    static final String DFA79_maxS =
        "\1\u0097\6\0\3\uffff";
    static final String DFA79_acceptS =
        "\7\uffff\1\1\1\3\1\2";
    static final String DFA79_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\3\uffff}>";
    static final String[] DFA79_transitionS = {
            "\1\1\2\uffff\1\2\13\uffff\1\3\74\uffff\1\4\1\5\1\6\3\uffff\1"+
            "\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA79_eot = DFA.unpackEncodedString(DFA79_eotS);
    static final short[] DFA79_eof = DFA.unpackEncodedString(DFA79_eofS);
    static final char[] DFA79_min = DFA.unpackEncodedStringToUnsignedChars(DFA79_minS);
    static final char[] DFA79_max = DFA.unpackEncodedStringToUnsignedChars(DFA79_maxS);
    static final short[] DFA79_accept = DFA.unpackEncodedString(DFA79_acceptS);
    static final short[] DFA79_special = DFA.unpackEncodedString(DFA79_specialS);
    static final short[][] DFA79_transition;

    static {
        int numStates = DFA79_transitionS.length;
        DFA79_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA79_transition[i] = DFA.unpackEncodedString(DFA79_transitionS[i]);
        }
    }

    class DFA79 extends DFA {

        public DFA79(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 79;
            this.eot = DFA79_eot;
            this.eof = DFA79_eof;
            this.min = DFA79_min;
            this.max = DFA79_max;
            this.accept = DFA79_accept;
            this.special = DFA79_special;
            this.transition = DFA79_transition;
        }
        public String getDescription() {
            return "345:1: assignStmt : ( ( lhs assignEqOp )=> lhs assignEqOp assignOrInitExpr -> ^( ASSIGN assignEqOp lhs assignOrInitExpr ) | idTuple EQUALS assignOrInitExpr -> ^( ASSIGN EQUALS idTuple assignOrInitExpr ) | ( lhs ( COMMA lhs )+ assignEqOp )=> lhs ( COMMA lhs )+ assignEqOp ( PLUS )? assignOrInitExpr ( COMMA assignOrInitExpr )* -> ^( ASSIGN assignEqOp ^( LIST ( lhs )+ ) ( PLUS )? ^( LIST ( assignOrInitExpr )+ ) ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA79_1 = input.LA(1);

                         
                        int index79_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_Eulang()) ) {s = 7;}

                        else if ( (synpred14_Eulang()) ) {s = 8;}

                         
                        input.seek(index79_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA79_2 = input.LA(1);

                         
                        int index79_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_Eulang()) ) {s = 7;}

                        else if ( (synpred14_Eulang()) ) {s = 8;}

                         
                        input.seek(index79_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA79_3 = input.LA(1);

                         
                        int index79_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_Eulang()) ) {s = 7;}

                        else if ( (true) ) {s = 9;}

                        else if ( (synpred14_Eulang()) ) {s = 8;}

                         
                        input.seek(index79_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA79_4 = input.LA(1);

                         
                        int index79_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_Eulang()) ) {s = 7;}

                        else if ( (synpred14_Eulang()) ) {s = 8;}

                         
                        input.seek(index79_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA79_5 = input.LA(1);

                         
                        int index79_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_Eulang()) ) {s = 7;}

                        else if ( (synpred14_Eulang()) ) {s = 8;}

                         
                        input.seek(index79_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA79_6 = input.LA(1);

                         
                        int index79_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred13_Eulang()) ) {s = 7;}

                        else if ( (synpred14_Eulang()) ) {s = 8;}

                         
                        input.seek(index79_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 79, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA81_eotS =
        "\26\uffff";
    static final String DFA81_eofS =
        "\26\uffff";
    static final String DFA81_minS =
        "\1\10\6\0\17\uffff";
    static final String DFA81_maxS =
        "\1\u0097\6\0\17\uffff";
    static final String DFA81_acceptS =
        "\7\uffff\1\3\14\uffff\1\1\1\2";
    static final String DFA81_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\17\uffff}>";
    static final String[] DFA81_transitionS = {
            "\1\7\64\uffff\2\7\6\uffff\1\1\2\uffff\1\2\13\uffff\1\3\2\uffff"+
            "\1\7\31\uffff\1\7\5\uffff\1\7\13\uffff\2\7\5\uffff\1\7\4\uffff"+
            "\2\7\1\4\1\5\1\6\1\uffff\2\7\1\2",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA81_eot = DFA.unpackEncodedString(DFA81_eotS);
    static final short[] DFA81_eof = DFA.unpackEncodedString(DFA81_eofS);
    static final char[] DFA81_min = DFA.unpackEncodedStringToUnsignedChars(DFA81_minS);
    static final char[] DFA81_max = DFA.unpackEncodedStringToUnsignedChars(DFA81_maxS);
    static final short[] DFA81_accept = DFA.unpackEncodedString(DFA81_acceptS);
    static final short[] DFA81_special = DFA.unpackEncodedString(DFA81_specialS);
    static final short[][] DFA81_transition;

    static {
        int numStates = DFA81_transitionS.length;
        DFA81_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA81_transition[i] = DFA.unpackEncodedString(DFA81_transitionS[i]);
        }
    }

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = DFA81_eot;
            this.eof = DFA81_eof;
            this.min = DFA81_min;
            this.max = DFA81_max;
            this.accept = DFA81_accept;
            this.special = DFA81_special;
            this.transition = DFA81_transition;
        }
        public String getDescription() {
            return "355:1: assignExpr : ( ( lhs assignEqOp )=> lhs assignEqOp assignExpr -> ^( ASSIGN assignEqOp lhs assignExpr ) | ( idTuple EQUALS )=> idTuple EQUALS assignExpr -> ^( ASSIGN EQUALS idTuple assignExpr ) | rhsExpr -> rhsExpr );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA81_1 = input.LA(1);

                         
                        int index81_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Eulang()) ) {s = 20;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index81_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA81_2 = input.LA(1);

                         
                        int index81_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Eulang()) ) {s = 20;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index81_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA81_3 = input.LA(1);

                         
                        int index81_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Eulang()) ) {s = 20;}

                        else if ( (synpred16_Eulang()) ) {s = 21;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index81_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA81_4 = input.LA(1);

                         
                        int index81_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Eulang()) ) {s = 20;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index81_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA81_5 = input.LA(1);

                         
                        int index81_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Eulang()) ) {s = 20;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index81_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA81_6 = input.LA(1);

                         
                        int index81_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_Eulang()) ) {s = 20;}

                        else if ( (true) ) {s = 7;}

                         
                        input.seek(index81_6);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 81, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA85_eotS =
        "\30\uffff";
    static final String DFA85_eofS =
        "\30\uffff";
    static final String DFA85_minS =
        "\1\10\24\uffff\1\0\2\uffff";
    static final String DFA85_maxS =
        "\1\u0097\24\uffff\1\0\2\uffff";
    static final String DFA85_acceptS =
        "\1\uffff\23\1\1\2\1\uffff\1\3\1\4";
    static final String DFA85_specialS =
        "\1\0\24\uffff\1\1\2\uffff}>";
    static final String[] DFA85_transitionS = {
            "\1\14\64\uffff\1\20\1\21\6\uffff\1\3\2\uffff\1\4\3\uffff\1\25"+
            "\7\uffff\1\5\2\uffff\1\13\21\uffff\1\24\7\uffff\1\23\5\uffff"+
            "\1\22\13\uffff\1\2\1\17\5\uffff\1\1\4\uffff\1\15\1\16\1\6\1"+
            "\7\1\10\1\uffff\1\11\1\12\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA85_eot = DFA.unpackEncodedString(DFA85_eotS);
    static final short[] DFA85_eof = DFA.unpackEncodedString(DFA85_eofS);
    static final char[] DFA85_min = DFA.unpackEncodedStringToUnsignedChars(DFA85_minS);
    static final char[] DFA85_max = DFA.unpackEncodedStringToUnsignedChars(DFA85_maxS);
    static final short[] DFA85_accept = DFA.unpackEncodedString(DFA85_acceptS);
    static final short[] DFA85_special = DFA.unpackEncodedString(DFA85_specialS);
    static final short[][] DFA85_transition;

    static {
        int numStates = DFA85_transitionS.length;
        DFA85_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA85_transition[i] = DFA.unpackEncodedString(DFA85_transitionS[i]);
        }
    }

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = DFA85_eot;
            this.eof = DFA85_eof;
            this.min = DFA85_min;
            this.max = DFA85_max;
            this.accept = DFA85_accept;
            this.special = DFA85_special;
            this.transition = DFA85_transition;
        }
        public String getDescription() {
            return "365:1: initExpr : ( ( rhsExpr )=>e= rhsExpr -> ^( INITEXPR $e) | PERIOD ID EQUALS ei= initElement -> ^( INITEXPR $ei ID ) | ( LBRACKET i= rhsExpr RBRACKET )=> LBRACKET i= rhsExpr RBRACKET EQUALS ei= initElement -> ^( INITEXPR $ei $i) | initList );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA85_0 = input.LA(1);

                         
                        int index85_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA85_0==MINUS) && (synpred17_Eulang())) {s = 1;}

                        else if ( (LA85_0==TILDE) && (synpred17_Eulang())) {s = 2;}

                        else if ( (LA85_0==ID) && (synpred17_Eulang())) {s = 3;}

                        else if ( (LA85_0==COLON||LA85_0==COLONS) && (synpred17_Eulang())) {s = 4;}

                        else if ( (LA85_0==LPAREN) && (synpred17_Eulang())) {s = 5;}

                        else if ( (LA85_0==NUMBER) && (synpred17_Eulang())) {s = 6;}

                        else if ( (LA85_0==CHAR_LITERAL) && (synpred17_Eulang())) {s = 7;}

                        else if ( (LA85_0==STRING_LITERAL) && (synpred17_Eulang())) {s = 8;}

                        else if ( (LA85_0==FALSE) && (synpred17_Eulang())) {s = 9;}

                        else if ( (LA85_0==TRUE) && (synpred17_Eulang())) {s = 10;}

                        else if ( (LA85_0==NIL) && (synpred17_Eulang())) {s = 11;}

                        else if ( (LA85_0==CODE) && (synpred17_Eulang())) {s = 12;}

                        else if ( (LA85_0==PLUSPLUS) && (synpred17_Eulang())) {s = 13;}

                        else if ( (LA85_0==MINUSMINUS) && (synpred17_Eulang())) {s = 14;}

                        else if ( (LA85_0==AMP) && (synpred17_Eulang())) {s = 15;}

                        else if ( (LA85_0==SIZEOF) && (synpred17_Eulang())) {s = 16;}

                        else if ( (LA85_0==TYPEOF) && (synpred17_Eulang())) {s = 17;}

                        else if ( (LA85_0==NOT) && (synpred17_Eulang())) {s = 18;}

                        else if ( (LA85_0==IF) && (synpred17_Eulang())) {s = 19;}

                        else if ( (LA85_0==PERIOD) ) {s = 20;}

                        else if ( (LA85_0==LBRACKET) ) {s = 21;}

                         
                        input.seek(index85_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA85_21 = input.LA(1);

                         
                        int index85_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred18_Eulang()) ) {s = 22;}

                        else if ( (true) ) {s = 23;}

                         
                        input.seek(index85_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 85, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA115_eotS =
        "\24\uffff";
    static final String DFA115_eofS =
        "\24\uffff";
    static final String DFA115_minS =
        "\1\10\2\uffff\6\0\13\uffff";
    static final String DFA115_maxS =
        "\1\u0097\2\uffff\6\0\13\uffff";
    static final String DFA115_acceptS =
        "\1\uffff\1\1\1\2\6\uffff\1\5\3\uffff\1\6\1\7\1\10\1\11\1\12\1\3"+
        "\1\4";
    static final String DFA115_specialS =
        "\3\uffff\1\0\1\1\1\2\1\3\1\4\1\5\13\uffff}>";
    static final String[] DFA115_transitionS = {
            "\1\11\64\uffff\1\20\1\21\6\uffff\1\3\2\uffff\1\4\13\uffff\1"+
            "\5\2\uffff\1\11\53\uffff\1\2\1\17\5\uffff\1\1\4\uffff\1\15\1"+
            "\16\1\6\1\7\1\10\1\uffff\2\11\1\4",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA115_eot = DFA.unpackEncodedString(DFA115_eotS);
    static final short[] DFA115_eof = DFA.unpackEncodedString(DFA115_eofS);
    static final char[] DFA115_min = DFA.unpackEncodedStringToUnsignedChars(DFA115_minS);
    static final char[] DFA115_max = DFA.unpackEncodedStringToUnsignedChars(DFA115_maxS);
    static final short[] DFA115_accept = DFA.unpackEncodedString(DFA115_acceptS);
    static final short[] DFA115_special = DFA.unpackEncodedString(DFA115_specialS);
    static final short[][] DFA115_transition;

    static {
        int numStates = DFA115_transitionS.length;
        DFA115_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA115_transition[i] = DFA.unpackEncodedString(DFA115_transitionS[i]);
        }
    }

    class DFA115 extends DFA {

        public DFA115(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 115;
            this.eot = DFA115_eot;
            this.eof = DFA115_eof;
            this.min = DFA115_min;
            this.max = DFA115_max;
            this.accept = DFA115_accept;
            this.special = DFA115_special;
            this.transition = DFA115_transition;
        }
        public String getDescription() {
            return "543:1: unary : ( MINUS u= unary -> ^( NEG $u) | TILDE u= unary -> ^( INV $u) | ( lhs PLUSPLUS )=>a= lhs PLUSPLUS -> ^( POSTINC $a) | ( lhs MINUSMINUS )=>a= lhs MINUSMINUS -> ^( POSTDEC $a) | ( atom -> atom ) | PLUSPLUS a= lhs -> ^( PREINC $a) | MINUSMINUS a= lhs -> ^( PREDEC $a) | AMP lhs -> ^( ADDROF lhs ) | SIZEOF atom -> ^( SIZEOF atom ) | TYPEOF atom -> ^( TYPEOF atom ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA115_3 = input.LA(1);

                         
                        int index115_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_Eulang()) ) {s = 18;}

                        else if ( (synpred22_Eulang()) ) {s = 19;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index115_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA115_4 = input.LA(1);

                         
                        int index115_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_Eulang()) ) {s = 18;}

                        else if ( (synpred22_Eulang()) ) {s = 19;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index115_4);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA115_5 = input.LA(1);

                         
                        int index115_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_Eulang()) ) {s = 18;}

                        else if ( (synpred22_Eulang()) ) {s = 19;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index115_5);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA115_6 = input.LA(1);

                         
                        int index115_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_Eulang()) ) {s = 18;}

                        else if ( (synpred22_Eulang()) ) {s = 19;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index115_6);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA115_7 = input.LA(1);

                         
                        int index115_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_Eulang()) ) {s = 18;}

                        else if ( (synpred22_Eulang()) ) {s = 19;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index115_7);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA115_8 = input.LA(1);

                         
                        int index115_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred21_Eulang()) ) {s = 18;}

                        else if ( (synpred22_Eulang()) ) {s = 19;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index115_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 115, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA121_eotS =
        "\16\uffff";
    static final String DFA121_eofS =
        "\16\uffff";
    static final String DFA121_minS =
        "\1\10\10\uffff\1\0\4\uffff";
    static final String DFA121_maxS =
        "\1\u0097\10\uffff\1\0\4\uffff";
    static final String DFA121_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\1\13\1\10\1\11\1\12";
    static final String DFA121_specialS =
        "\1\0\10\uffff\1\1\4\uffff}>";
    static final String[] DFA121_transitionS = {
            "\1\12\74\uffff\1\7\2\uffff\1\7\13\uffff\1\11\2\uffff\1\6\71"+
            "\uffff\1\1\1\4\1\5\1\uffff\1\2\1\3\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA121_eot = DFA.unpackEncodedString(DFA121_eotS);
    static final short[] DFA121_eof = DFA.unpackEncodedString(DFA121_eofS);
    static final char[] DFA121_min = DFA.unpackEncodedStringToUnsignedChars(DFA121_minS);
    static final char[] DFA121_max = DFA.unpackEncodedStringToUnsignedChars(DFA121_maxS);
    static final short[] DFA121_accept = DFA.unpackEncodedString(DFA121_acceptS);
    static final short[] DFA121_special = DFA.unpackEncodedString(DFA121_specialS);
    static final short[][] DFA121_transition;

    static {
        int numStates = DFA121_transitionS.length;
        DFA121_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA121_transition[i] = DFA.unpackEncodedString(DFA121_transitionS[i]);
        }
    }

    class DFA121 extends DFA {

        public DFA121(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 121;
            this.eot = DFA121_eot;
            this.eof = DFA121_eof;
            this.min = DFA121_min;
            this.max = DFA121_max;
            this.accept = DFA121_accept;
            this.special = DFA121_special;
            this.transition = DFA121_transition;
        }
        public String getDescription() {
            return "578:3: ( NUMBER -> ^( LIT NUMBER ) | FALSE -> ^( LIT FALSE ) | TRUE -> ^( LIT TRUE ) | CHAR_LITERAL -> ^( LIT CHAR_LITERAL ) | STRING_LITERAL -> ^( LIT STRING_LITERAL ) | NIL -> ^( LIT NIL ) | idExpr -> idExpr | ( tuple )=> tuple -> tuple | ( LPAREN varDecl )=> LPAREN a0= varDecl RPAREN -> $a0 | LPAREN a1= assignExpr RPAREN -> $a1 | ( CODE )=> code -> code )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA121_0 = input.LA(1);

                         
                        int index121_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA121_0==NUMBER) ) {s = 1;}

                        else if ( (LA121_0==FALSE) ) {s = 2;}

                        else if ( (LA121_0==TRUE) ) {s = 3;}

                        else if ( (LA121_0==CHAR_LITERAL) ) {s = 4;}

                        else if ( (LA121_0==STRING_LITERAL) ) {s = 5;}

                        else if ( (LA121_0==NIL) ) {s = 6;}

                        else if ( (LA121_0==ID||LA121_0==COLON||LA121_0==COLONS) ) {s = 7;}

                        else if ( (LA121_0==LPAREN) ) {s = 9;}

                        else if ( (LA121_0==CODE) && (synpred27_Eulang())) {s = 10;}

                         
                        input.seek(index121_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA121_9 = input.LA(1);

                         
                        int index121_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred25_Eulang()) ) {s = 11;}

                        else if ( (synpred26_Eulang()) ) {s = 12;}

                        else if ( (true) ) {s = 13;}

                         
                        input.seek(index121_9);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 121, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA127_eotS =
        "\70\uffff";
    static final String DFA127_eofS =
        "\1\2\67\uffff";
    static final String DFA127_minS =
        "\1\44\1\0\66\uffff";
    static final String DFA127_maxS =
        "\1\u0094\1\0\66\uffff";
    static final String DFA127_acceptS =
        "\2\uffff\1\2\64\uffff\1\1";
    static final String DFA127_specialS =
        "\1\uffff\1\0\66\uffff}>";
    static final String[] DFA127_transitionS = {
            "\2\2\35\uffff\1\2\2\uffff\1\2\1\uffff\6\2\1\uffff\2\2\1\uffff"+
            "\1\2\1\uffff\3\2\1\uffff\24\2\1\uffff\1\2\4\uffff\5\2\1\uffff"+
            "\6\2\1\1\22\2\3\uffff\1\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA127_eot = DFA.unpackEncodedString(DFA127_eotS);
    static final short[] DFA127_eof = DFA.unpackEncodedString(DFA127_eofS);
    static final char[] DFA127_min = DFA.unpackEncodedStringToUnsignedChars(DFA127_minS);
    static final char[] DFA127_max = DFA.unpackEncodedStringToUnsignedChars(DFA127_maxS);
    static final short[] DFA127_accept = DFA.unpackEncodedString(DFA127_acceptS);
    static final short[] DFA127_special = DFA.unpackEncodedString(DFA127_specialS);
    static final short[][] DFA127_transition;

    static {
        int numStates = DFA127_transitionS.length;
        DFA127_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA127_transition[i] = DFA.unpackEncodedString(DFA127_transitionS[i]);
        }
    }

    class DFA127 extends DFA {

        public DFA127(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 127;
            this.eot = DFA127_eot;
            this.eof = DFA127_eof;
            this.min = DFA127_min;
            this.max = DFA127_max;
            this.accept = DFA127_accept;
            this.special = DFA127_special;
            this.transition = DFA127_transition;
        }
        public String getDescription() {
            return "611:5: ( ( instantiation )=> instantiation -> ^( INSTANCE $idExpr instantiation ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA127_1 = input.LA(1);

                         
                        int index127_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred29_Eulang()) ) {s = 55;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index127_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 127, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA133_eotS =
        "\14\uffff";
    static final String DFA133_eofS =
        "\14\uffff";
    static final String DFA133_minS =
        "\1\10\3\0\1\uffff\1\0\6\uffff";
    static final String DFA133_maxS =
        "\1\u0098\3\0\1\uffff\1\0\6\uffff";
    static final String DFA133_acceptS =
        "\4\uffff\1\1\1\uffff\1\2\5\uffff";
    static final String DFA133_specialS =
        "\1\uffff\1\0\1\1\1\2\1\uffff\1\3\6\uffff}>";
    static final String[] DFA133_transitionS = {
            "\1\3\74\uffff\1\1\2\uffff\1\2\13\uffff\1\5\2\uffff\1\6\71\uffff"+
            "\3\6\1\uffff\2\6\1\2\1\4",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA133_eot = DFA.unpackEncodedString(DFA133_eotS);
    static final short[] DFA133_eof = DFA.unpackEncodedString(DFA133_eofS);
    static final char[] DFA133_min = DFA.unpackEncodedStringToUnsignedChars(DFA133_minS);
    static final char[] DFA133_max = DFA.unpackEncodedStringToUnsignedChars(DFA133_maxS);
    static final short[] DFA133_accept = DFA.unpackEncodedString(DFA133_acceptS);
    static final short[] DFA133_special = DFA.unpackEncodedString(DFA133_specialS);
    static final short[][] DFA133_transition;

    static {
        int numStates = DFA133_transitionS.length;
        DFA133_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA133_transition[i] = DFA.unpackEncodedString(DFA133_transitionS[i]);
        }
    }

    class DFA133 extends DFA {

        public DFA133(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 133;
            this.eot = DFA133_eot;
            this.eof = DFA133_eof;
            this.min = DFA133_min;
            this.max = DFA133_max;
            this.accept = DFA133_accept;
            this.special = DFA133_special;
            this.transition = DFA133_transition;
        }
        public String getDescription() {
            return "621:1: instanceExpr options {backtrack=true; } : ( type | atom );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA133_1 = input.LA(1);

                         
                        int index133_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_Eulang()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index133_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA133_2 = input.LA(1);

                         
                        int index133_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_Eulang()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index133_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA133_3 = input.LA(1);

                         
                        int index133_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_Eulang()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index133_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA133_5 = input.LA(1);

                         
                        int index133_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred30_Eulang()) ) {s = 4;}

                        else if ( (true) ) {s = 6;}

                         
                        input.seek(index133_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 133, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_toplevelstmts_in_prog437 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_prog439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toplevelstat_in_toplevelstmts468 = new BitSet(new long[]{0x6000000000000102L,0x0082000000908130L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_toplevelstatNoAlloc_in_toplevelstmtsNoAlloc495 = new BitSet(new long[]{0x6000000000000102L,0x0082000000908130L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_toplevelstatNoAlloc_in_toplevelstat524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toplevelAlloc_in_toplevelstat537 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_toplevelstat539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineStmt_in_toplevelstatNoAlloc554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scopeExtension_in_toplevelstatNoAlloc562 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_toplevelstatNoAlloc564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORWARD_in_toplevelstatNoAlloc578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_toplevelstatNoAlloc580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_COMMA_in_toplevelstatNoAlloc583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_toplevelstatNoAlloc585 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000048L});
    public static final BitSet FOLLOW_SEMI_in_toplevelstatNoAlloc589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_toplevelstatNoAlloc606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_toplevelstatNoAlloc625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xscope_in_toplevelstatNoAlloc648 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_toplevelstatNoAlloc650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toplevelSingleVarDecl_in_toplevelAlloc665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toplevelTupleVarDecl_in_toplevelAlloc669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_toplevelSingleVarDecl680 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_COLON_EQUALS_in_toplevelSingleVarDecl694 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_toplevelSingleVarDecl730 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_toplevelSingleVarDecl732 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_toplevelSingleVarDecl735 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_toplevelSingleVarDecl767 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_toplevelSingleVarDecl769 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_COLON_EQUALS_in_toplevelSingleVarDecl788 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901520L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_PLUS_in_toplevelSingleVarDecl790 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl793 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_toplevelSingleVarDecl796 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl798 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_toplevelSingleVarDecl857 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_toplevelSingleVarDecl859 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_toplevelSingleVarDecl862 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901520L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_PLUS_in_toplevelSingleVarDecl864 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl867 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_toplevelSingleVarDecl870 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelSingleVarDecl872 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_idTuple_in_toplevelTupleVarDecl963 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_COLON_EQUALS_in_toplevelTupleVarDecl985 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelTupleVarDecl987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_toplevelTupleVarDecl1021 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_toplevelTupleVarDecl1023 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_toplevelTupleVarDecl1026 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExprOrInitList_in_toplevelTupleVarDecl1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_rhsExprOrInitList1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initList_in_rhsExprOrInitList1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_namespaceRef_in_scopeExtension1084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_PLUS_EQ_in_scopeExtension1086 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_xscopeNoAlloc_in_scopeExtension1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_defineStmt1117 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_defineStmt1119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_LBRACKET_in_defineStmt1121 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002020L});
    public static final BitSet FOLLOW_idlistOrEmpty_in_defineStmt1123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RBRACKET_in_defineStmt1125 = new BitSet(new long[]{0x6000000000000500L,0x0082000000909130L,0x0000000001EF8418L});
    public static final BitSet FOLLOW_toplevelvalue_in_defineStmt1128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_defineStmt1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_defineStmt1164 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQUALS_COLON_in_defineStmt1166 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_defineStmt1168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_defineStmt1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_defineStmt1201 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_defineStmt1203 = new BitSet(new long[]{0x6000000000000500L,0x0082000000909130L,0x0000000001EF8418L});
    public static final BitSet FOLLOW_toplevelvalue_in_defineStmt1205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_defineStmt1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xscope_in_toplevelvalue1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_namespaceRef_in_toplevelvalue1247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_PLUS_in_toplevelvalue1249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_data_in_toplevelvalue1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_namespaceRef_in_toplevelvalue1269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_PLUS_in_toplevelvalue1271 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908130L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_xscope_in_toplevelvalue1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_toplevelvalue1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_toplevelvalue1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_data_in_toplevelvalue1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_macro_in_toplevelvalue1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_selector1334 = new BitSet(new long[]{0x6000000000000500L,0x008200000090B130L,0x0000000001EF8418L});
    public static final BitSet FOLLOW_selectors_in_selector1336 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RBRACKET_in_selector1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectoritem_in_selectors1364 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_selectors1368 = new BitSet(new long[]{0x6000000000000500L,0x0082000000909130L,0x0000000001EF8418L});
    public static final BitSet FOLLOW_selectoritem_in_selectors1370 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_selectors1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_macro_in_selectoritem1406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_selectoritem1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_xscope1421 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908130L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_toplevelstmts_in_xscope1423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_xscope1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_xscopeNoAlloc1450 = new BitSet(new long[]{0x6000000000000100L,0x0082000000918130L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_toplevelstmtsNoAlloc_in_xscopeNoAlloc1452 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_xscopeNoAlloc1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forIn_in_listCompr1481 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020100L});
    public static final BitSet FOLLOW_COLON_in_listCompr1484 = new BitSet(new long[]{0x6000000000000500L,0x0082000000909130L,0x0000000001EF8418L});
    public static final BitSet FOLLOW_listiterable_in_listCompr1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forIn1518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_idlist_in_forIn1520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_IN_in_forIn1522 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_list_in_forIn1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_idlist1549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_idlist1552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_idlist1554 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_idlist_in_idlistOrEmpty1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_code_in_listiterable1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_macro_in_listiterable1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_list1622 = new BitSet(new long[]{0x6000000000000500L,0x008200000090B130L,0x0000000001EF8418L});
    public static final BitSet FOLLOW_listitems_in_list1624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RBRACKET_in_list1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listitem_in_listitems1656 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_listitems1660 = new BitSet(new long[]{0x6000000000000500L,0x0082000000909130L,0x0000000001EF8418L});
    public static final BitSet FOLLOW_listitem_in_listitems1662 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_listitems1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_toplevelvalue_in_listitem1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CODE_in_code1711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000108000L});
    public static final BitSet FOLLOW_proto_in_code1713 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_LBRACE_in_code1716 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009B83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codestmtlist_in_code1718 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_code1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_in_macro1748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000108000L});
    public static final BitSet FOLLOW_proto_in_macro1750 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_LBRACE_in_macro1754 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009B83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codestmtlist_in_macro1756 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_macro1758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argdefsWithTypes_in_argdefs1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argdefWithType_in_argdefs1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argdefsWithNames_in_argdefs1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argdefWithType_in_argdefsWithTypes1833 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_argdefsWithTypes1837 = new BitSet(new long[]{0x0000000000000400L,0x0000000000080020L});
    public static final BitSet FOLLOW_argdefWithType_in_argdefsWithTypes1839 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_argdefsWithTypes1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATSIGN_in_argdefWithType1872 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_argdefWithType1875 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000140L});
    public static final BitSet FOLLOW_COMMA_in_argdefWithType1878 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_argdefWithType1880 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000140L});
    public static final BitSet FOLLOW_COLON_in_argdefWithType1885 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_argdefWithType1887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_in_argdefWithType1915 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_argdefWithType1917 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000340L});
    public static final BitSet FOLLOW_COMMA_in_argdefWithType1920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_argdefWithType1922 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000340L});
    public static final BitSet FOLLOW_COLON_in_argdefWithType1927 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_argdefWithType1929 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_argdefWithType1934 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_argdefWithType1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argdefWithName_in_argdefsWithNames1974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_argdefsWithNames1978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080020L});
    public static final BitSet FOLLOW_argdefWithName_in_argdefsWithNames1980 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_argdefsWithNames1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATSIGN_in_argdefWithName2006 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_argdefWithName2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_proto2035 = new BitSet(new long[]{0x0000000000000400L,0x0000000000680020L});
    public static final BitSet FOLLOW_argdefs_in_proto2037 = new BitSet(new long[]{0x0000000000000000L,0x0000000000600000L});
    public static final BitSet FOLLOW_xreturns_in_proto2039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_proto2042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROW_in_xreturns2085 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_xreturns2087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROW_in_xreturns2104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_NIL_in_xreturns2106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_argtuple2136 = new BitSet(new long[]{0x0000000000000100L,0x0000000001100160L,0x0000000001800000L});
    public static final BitSet FOLLOW_tupleargdefs_in_argtuple2138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_argtuple2140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleargdef_in_tupleargdefs2162 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_tupleargdefs2166 = new BitSet(new long[]{0x0000000000000100L,0x0000000001100160L,0x0000000001800000L});
    public static final BitSet FOLLOW_tupleargdef_in_tupleargdefs2168 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_tupleargdef2213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_tupleargdef2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nonArrayType_in_type2291 = new BitSet(new long[]{0x0000000000000002L,0x0000000002001000L});
    public static final BitSet FOLLOW_arraySuff_in_type2329 = new BitSet(new long[]{0x0000000000000002L,0x0000000002001000L});
    public static final BitSet FOLLOW_LBRACKET_in_type2384 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_type2386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_type2390 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_type2392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_RBRACKET_in_type2397 = new BitSet(new long[]{0x0000000000000002L,0x0000000002001000L});
    public static final BitSet FOLLOW_CARET_in_type2456 = new BitSet(new long[]{0x0000000000000002L,0x0000000002001000L});
    public static final BitSet FOLLOW_idExpr_in_nonArrayType2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CODE_in_nonArrayType2526 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_proto_in_nonArrayType2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_data_in_nonArrayType2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argtuple_in_nonArrayType2567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySuff2583 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_arraySuff2585 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySuff2587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arraySuff2599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RBRACKET_in_arraySuff2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codeStmt_in_codestmtlist2617 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_codestmtlist2620 = new BitSet(new long[]{0x6001000000000102L,0x00821C00009A83B8L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codeStmt_in_codestmtlist2622 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_labelStmt_in_codeStmt2666 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009A83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codeStmtExpr_in_codeStmt2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_codeStmtExpr_in_codeStmt2689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_codeStmtExpr2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignStmt_in_codeStmtExpr2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_codeStmtExpr2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStmt_in_codeStmtExpr2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gotoStmt_in_codeStmtExpr2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_controlStmt_in_codeStmtExpr2842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_singleVarDecl_in_varDecl2865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tupleVarDecl_in_varDecl2869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_singleVarDecl2881 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_COLON_EQUALS_in_singleVarDecl2895 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_singleVarDecl2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_singleVarDecl2931 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_singleVarDecl2933 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_singleVarDecl2936 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_singleVarDecl2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_singleVarDecl2968 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_singleVarDecl2970 = new BitSet(new long[]{0x0000000000000000L,0x00000000000001C0L});
    public static final BitSet FOLLOW_COLON_EQUALS_in_singleVarDecl2989 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909730L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_PLUS_in_singleVarDecl2991 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_singleVarDecl2994 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_singleVarDecl2997 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_singleVarDecl2999 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_singleVarDecl3058 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_singleVarDecl3060 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_singleVarDecl3063 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909730L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_PLUS_in_singleVarDecl3065 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_singleVarDecl3068 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_singleVarDecl3071 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_singleVarDecl3073 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_idTuple_in_tupleVarDecl3159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_COLON_EQUALS_in_tupleVarDecl3173 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_tupleVarDecl3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_tupleVarDecl3209 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_tupleVarDecl3211 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_tupleVarDecl3214 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_tupleVarDecl3216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_assignStmt3264 = new BitSet(new long[]{0x0000000000000000L,0x000001FFFC000A00L});
    public static final BitSet FOLLOW_assignEqOp_in_assignStmt3266 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_assignStmt3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idTuple_in_assignStmt3295 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_assignStmt3297 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_assignStmt3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_assignStmt3354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_assignStmt3357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100120L,0x00000000008E0000L});
    public static final BitSet FOLLOW_lhs_in_assignStmt3359 = new BitSet(new long[]{0x0000000000000000L,0x000001FFFC000A40L});
    public static final BitSet FOLLOW_assignEqOp_in_assignStmt3363 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909730L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_PLUS_in_assignStmt3365 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_assignStmt3368 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_assignStmt3371 = new BitSet(new long[]{0x6000000000000100L,0x0082000000909330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignOrInitExpr_in_assignStmt3373 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_assignExpr_in_assignOrInitExpr3434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initList_in_assignOrInitExpr3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_assignExpr3456 = new BitSet(new long[]{0x0000000000000000L,0x000001FFFC000A00L});
    public static final BitSet FOLLOW_assignEqOp_in_assignExpr3458 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_assignExpr3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idTuple_in_assignExpr3495 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_assignExpr3497 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_assignExpr3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_assignExpr3533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assignOp0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_assignEqOp3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignOp_in_assignEqOp3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_initList3661 = new BitSet(new long[]{0x6000000000000100L,0x0082020000903120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_initExpr_in_initList3664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_COMMA_in_initList3667 = new BitSet(new long[]{0x6000000000000100L,0x0082020000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_initExpr_in_initList3669 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_RBRACKET_in_initList3675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_initExpr3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_initExpr3773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_initExpr3775 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_initExpr3777 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_initElement_in_initExpr3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_initExpr3846 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_initExpr3850 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RBRACKET_in_initExpr3852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_initExpr3854 = new BitSet(new long[]{0x6000000000000100L,0x0082000000901120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_initElement_in_initExpr3858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initList_in_initExpr3895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_initElement3909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initList_in_initElement3913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doWhile_in_controlStmt3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileDo_in_controlStmt3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeat_in_controlStmt3933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forIter_in_controlStmt3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_doWhile3946 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009A83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codeStmtExpr_in_doWhile3948 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
    public static final BitSet FOLLOW_WHILE_in_doWhile3950 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_doWhile3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileDo3975 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_whileDo3977 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_DO_in_whileDo3979 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009A83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codeStmtExpr_in_whileDo3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPEAT_in_repeat4006 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_repeat4008 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_DO_in_repeat4010 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009A83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codeStmt_in_repeat4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forIter4042 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_forIds_in_forIter4044 = new BitSet(new long[]{0x0000000000000000L,0x0000C00000040000L});
    public static final BitSet FOLLOW_forMovement_in_forIter4046 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_IN_in_forIter4049 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_forIter4051 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
    public static final BitSet FOLLOW_DO_in_forIter4053 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009A83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codeStmt_in_forIter4055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_forIds4092 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_AND_in_forIds4095 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_forIds4097 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_atId_in_forMovement4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stepping_in_forMovement4117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_stepping4126 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_stepping4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_atId4145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_atId4147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_breakStmt4175 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_breakStmt4177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATSIGN_in_labelStmt4205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_labelStmt4207 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_labelStmt4209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOTO_in_gotoStmt4245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000120L,0x0000000000800000L});
    public static final BitSet FOLLOW_idOrScopeRef_in_gotoStmt4247 = new BitSet(new long[]{0x0000000000000002L,0x0002000000000000L});
    public static final BitSet FOLLOW_IF_in_gotoStmt4250 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_gotoStmt4252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_blockStmt4287 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009B83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codestmtlist_in_blockStmt4289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_blockStmt4291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_tuple4314 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_tupleEntries_in_tuple4316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_tuple4318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignExpr_in_tupleEntries4346 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_tupleEntries4349 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_tupleEntries4351 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_LPAREN_in_idTuple4370 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000120L,0x0000000000800000L});
    public static final BitSet FOLLOW_idTupleEntries_in_idTuple4372 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_idTuple4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idOrScopeRef_in_idTupleEntries4402 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_idTupleEntries4405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000120L,0x0000000000800000L});
    public static final BitSet FOLLOW_idOrScopeRef_in_idTupleEntries4407 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_condStar_in_rhsExpr4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_in_arglist4449 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_arglist4453 = new BitSet(new long[]{0x6001000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_arg_in_arglist4455 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_arglist4459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignExpr_in_arg4508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_arg4541 = new BitSet(new long[]{0x6001000000000100L,0x00821C00009B83B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_codestmtlist_in_arg4543 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_arg4545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gotoStmt_in_arg4569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cond_in_condStar4630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_condStar4641 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_ifExprs_in_condStar4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_thenClause_in_ifExprs4662 = new BitSet(new long[]{0x0000000000000000L,0x0038000000000000L});
    public static final BitSet FOLLOW_elses_in_ifExprs4664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignExpr_in_thenClause4686 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000100L});
    public static final BitSet FOLLOW_THEN_in_thenClause4692 = new BitSet(new long[]{0x6001000000000100L,0x0083000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_COLON_in_thenClause4694 = new BitSet(new long[]{0x6001000000000100L,0x0083000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_condStmtExpr_in_thenClause4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elif_in_elses4727 = new BitSet(new long[]{0x0000000000000000L,0x0038000000000000L});
    public static final BitSet FOLLOW_elseClause_in_elses4730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELIF_in_elif4753 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_elif4757 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000100L});
    public static final BitSet FOLLOW_THEN_in_elif4760 = new BitSet(new long[]{0x6001000000000100L,0x0083000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_COLON_in_elif4762 = new BitSet(new long[]{0x6001000000000100L,0x0083000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_condStmtExpr_in_elif4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_elseClause4793 = new BitSet(new long[]{0x6001000000000100L,0x0083000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_condStmtExpr_in_elseClause4795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FI_in_elseClause4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_in_condStmtExpr4853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStmt_in_condStmtExpr4857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logor_in_cond4874 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_QUESTION_in_cond4891 = new BitSet(new long[]{0x6000000000000100L,0x0080000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_logor_in_cond4895 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_cond4897 = new BitSet(new long[]{0x6000000000000100L,0x0080000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_logor_in_cond4901 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_logand_in_logor4945 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_OR_in_logor4962 = new BitSet(new long[]{0x6000000000000100L,0x0080000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_logand_in_logor4966 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
    public static final BitSet FOLLOW_not_in_logand4997 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_AND_in_logand5013 = new BitSet(new long[]{0x6000000000000100L,0x0080000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_not_in_logand5017 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
    public static final BitSet FOLLOW_comp_in_not5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_not5079 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_comp_in_not5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bitor_in_comp5117 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_COMPEQ_in_comp5150 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5154 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_COMPNE_in_comp5176 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5180 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_COMPLE_in_comp5202 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5206 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_COMPGE_in_comp5231 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5235 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_COMPULE_in_comp5260 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5264 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_COMPUGE_in_comp5289 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5293 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_LESS_in_comp5318 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5322 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ULESS_in_comp5348 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5352 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_GREATER_in_comp5378 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5382 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_UGREATER_in_comp5407 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitor_in_comp5411 = new BitSet(new long[]{0x0000000000000002L,0xFF00000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_bitxor_in_bitor5461 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_BAR_in_bitor5489 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitxor_in_bitor5493 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_bitand_in_bitxor5519 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TILDE_in_bitxor5547 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_bitand_in_bitxor5551 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_shift_in_bitand5576 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_AMP_in_bitand5604 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_shift_in_bitand5608 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_factor_in_shift5635 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000003E0L});
    public static final BitSet FOLLOW_LSHIFT_in_shift5669 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_factor_in_shift5673 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000003E0L});
    public static final BitSet FOLLOW_RSHIFT_in_shift5702 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_factor_in_shift5706 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000003E0L});
    public static final BitSet FOLLOW_URSHIFT_in_shift5734 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_factor_in_shift5738 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000003E0L});
    public static final BitSet FOLLOW_CRSHIFT_in_shift5766 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_factor_in_shift5770 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000003E0L});
    public static final BitSet FOLLOW_CLSHIFT_in_shift5798 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_factor_in_shift5802 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x00000000000003E0L});
    public static final BitSet FOLLOW_term_in_factor5844 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L,0x0000000000000400L});
    public static final BitSet FOLLOW_PLUS_in_factor5877 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_term_in_factor5881 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L,0x0000000000000400L});
    public static final BitSet FOLLOW_MINUS_in_factor5923 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_term_in_factor5927 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L,0x0000000000000400L});
    public static final BitSet FOLLOW_unary_in_term5972 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_STAR_in_term6016 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_term6020 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_SLASH_in_term6056 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_term6060 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_REM_in_term6095 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_term6099 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_UDIV_in_term6134 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_term6138 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_UREM_in_term6173 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_term6177 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_MOD_in_term6212 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_term6216 = new BitSet(new long[]{0x0000003000000002L,0x0000000000000000L,0x0000000000007800L});
    public static final BitSet FOLLOW_MINUS_in_unary6289 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_unary6293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_unary6313 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_unary6317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_unary6352 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unary6354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_unary6385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_MINUSMINUS_in_unary6387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unary6408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unary6439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100120L,0x00000000008E0000L});
    public static final BitSet FOLLOW_lhs_in_unary6443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUSMINUS_in_unary6464 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100120L,0x00000000008E0000L});
    public static final BitSet FOLLOW_lhs_in_unary6468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMP_in_unary6488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100120L,0x00000000008E0000L});
    public static final BitSet FOLLOW_lhs_in_unary6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_unary6531 = new BitSet(new long[]{0x0000000000000100L,0x0000000000900120L,0x0000000000EE0000L});
    public static final BitSet FOLLOW_atom_in_unary6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPEOF_in_unary6557 = new BitSet(new long[]{0x0000000000000100L,0x0000000000900120L,0x0000000000EE0000L});
    public static final BitSet FOLLOW_atom_in_unary6559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idExpr_in_lhs6594 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_tuple_in_lhs6641 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_lhs6680 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_lhs6723 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_lhs6758 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_lhs6791 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_lhs6795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_lhs6797 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_PERIOD_in_lhs6840 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_lhs6842 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_lhs6867 = new BitSet(new long[]{0x6001000000000100L,0x0082000000B08330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_arglist_in_lhs6869 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_lhs6871 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_arrayAccess_in_lhs6904 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_CARET_in_lhs6929 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LBRACE_in_lhs6950 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100520L,0x0000000001800000L});
    public static final BitSet FOLLOW_PLUS_in_lhs6952 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_lhs6955 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_lhs6957 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_AS_in_lhs6998 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100520L,0x0000000001800000L});
    public static final BitSet FOLLOW_PLUS_in_lhs7000 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_lhs7003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom7052 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_FALSE_in_atom7095 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_TRUE_in_atom7137 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_CHAR_LITERAL_in_atom7180 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom7215 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_NIL_in_atom7248 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_idExpr_in_atom7291 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_tuple_in_atom7338 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_atom7387 = new BitSet(new long[]{0x6000000000000100L,0x00820000009081B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_varDecl_in_atom7391 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_atom7393 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_atom7422 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_atom7426 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_atom7428 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_code_in_atom7466 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_PERIOD_in_atom7525 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_atom7527 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LPAREN_in_atom7552 = new BitSet(new long[]{0x6001000000000100L,0x0082000000B08330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_arglist_in_atom7554 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_RPAREN_in_atom7556 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_arrayAccess_in_atom7589 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_CARET_in_atom7614 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_LBRACE_in_atom7635 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100520L,0x0000000001800000L});
    public static final BitSet FOLLOW_PLUS_in_atom7637 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_atom7640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_RBRACE_in_atom7642 = new BitSet(new long[]{0x0000000000000002L,0x0000020002109000L,0x0000000000100000L});
    public static final BitSet FOLLOW_AS_in_atom7683 = new BitSet(new long[]{0x0000000000000100L,0x0000000000100120L,0x0000000001800000L});
    public static final BitSet FOLLOW_type_in_atom7685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_arrayAccess7719 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_arrayAccess7721 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_COMMA_in_arrayAccess7724 = new BitSet(new long[]{0x6000000000000100L,0x0082000000908330L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_assignExpr_in_arrayAccess7726 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002040L});
    public static final BitSet FOLLOW_RBRACKET_in_arrayAccess7730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idOrScopeRef_in_idExpr7752 = new BitSet(new long[]{0x0000000000000002L,0x4000020000000000L});
    public static final BitSet FOLLOW_PERIOD_in_idExpr7768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_idExpr7770 = new BitSet(new long[]{0x0000000000000002L,0x4000020000000000L});
    public static final BitSet FOLLOW_instantiation_in_idExpr7800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_namespaceRef7831 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_PERIOD_in_namespaceRef7834 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_namespaceRef7836 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_colons_in_namespaceRef7860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_namespaceRef7862 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_PERIOD_in_namespaceRef7865 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_namespaceRef7867 = new BitSet(new long[]{0x0000000000000002L,0x0000020000000000L});
    public static final BitSet FOLLOW_LESS_in_instantiation7896 = new BitSet(new long[]{0x0000000000000100L,0x0000000000900120L,0x0000000001EE0001L});
    public static final BitSet FOLLOW_instanceExpr_in_instantiation7899 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x0000000000000001L});
    public static final BitSet FOLLOW_COMMA_in_instantiation7902 = new BitSet(new long[]{0x0000000000000100L,0x0000000000900120L,0x0000000001EE0000L});
    public static final BitSet FOLLOW_instanceExpr_in_instantiation7904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L,0x0000000000000001L});
    public static final BitSet FOLLOW_GREATER_in_instantiation7910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_instanceExpr7942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_instanceExpr7946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_idOrScopeRef7954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_colons_in_idOrScopeRef7977 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_idOrScopeRef7979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_colons8005 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L,0x0000000000800000L});
    public static final BitSet FOLLOW_DATA_in_data8022 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_LBRACE_in_data8024 = new BitSet(new long[]{0x6000000000000100L,0x00820000009181B0L,0x0000000002EF8418L});
    public static final BitSet FOLLOW_fieldDecl_in_data8026 = new BitSet(new long[]{0x6000000000000100L,0x00820000009181B0L,0x0000000002EF8418L});
    public static final BitSet FOLLOW_RBRACE_in_data8029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATIC_in_staticVarDecl8048 = new BitSet(new long[]{0x6000000000000100L,0x00820000009081B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_varDecl_in_staticVarDecl8050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_staticVarDecl_in_fieldDecl8067 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_fieldDecl8069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_fieldDecl8082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_SEMI_in_fieldDecl8084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defineStmt_in_fieldDecl8097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_fieldIdRef8110 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_fieldIdRef8113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_fieldIdRef8115 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_LBRACE_in_synpred1_Eulang643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred2_Eulang1108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_synpred2_Eulang1110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred2_Eulang1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred3_Eulang1157 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_EQUALS_COLON_in_synpred3_Eulang1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_synpred4_Eulang1194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_synpred4_Eulang1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_synpred5_Eulang1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argdefsWithTypes_in_synpred7_Eulang1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argdefWithType_in_synpred8_Eulang1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arraySuff_in_synpred9_Eulang2323 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_varDecl_in_synpred10_Eulang2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignStmt_in_synpred11_Eulang2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_synpred12_Eulang2788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_synpred13_Eulang3257 = new BitSet(new long[]{0x0000000000000000L,0x000001FFFC000A00L});
    public static final BitSet FOLLOW_assignEqOp_in_synpred13_Eulang3259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_synpred14_Eulang3339 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_synpred14_Eulang3342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100120L,0x00000000008E0000L});
    public static final BitSet FOLLOW_lhs_in_synpred14_Eulang3344 = new BitSet(new long[]{0x0000000000000000L,0x000001FFFC000A40L});
    public static final BitSet FOLLOW_assignEqOp_in_synpred14_Eulang3348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_synpred15_Eulang3449 = new BitSet(new long[]{0x0000000000000000L,0x000001FFFC000A00L});
    public static final BitSet FOLLOW_assignEqOp_in_synpred15_Eulang3451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_idTuple_in_synpred16_Eulang3488 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_EQUALS_in_synpred16_Eulang3490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rhsExpr_in_synpred17_Eulang3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred18_Eulang3835 = new BitSet(new long[]{0x6000000000000100L,0x0082000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_rhsExpr_in_synpred18_Eulang3839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_RBRACKET_in_synpred18_Eulang3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred19_Eulang5916 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_term_in_synpred19_Eulang5918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred20_Eulang6009 = new BitSet(new long[]{0x6000000000000100L,0x0000000000900120L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_unary_in_synpred20_Eulang6011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_synpred21_Eulang6343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_PLUSPLUS_in_synpred21_Eulang6345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lhs_in_synpred22_Eulang6376 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_MINUSMINUS_in_synpred22_Eulang6378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_synpred23_Eulang6635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred24_Eulang6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_synpred25_Eulang7332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred26_Eulang7379 = new BitSet(new long[]{0x6000000000000100L,0x00820000009081B0L,0x0000000000EF8418L});
    public static final BitSet FOLLOW_varDecl_in_synpred26_Eulang7381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CODE_in_synpred27_Eulang7459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_synpred28_Eulang7583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instantiation_in_synpred29_Eulang7794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_synpred30_Eulang7942 = new BitSet(new long[]{0x0000000000000002L});

}